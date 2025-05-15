package threads;

import java.util.ArrayList;
import java.util.Random;

class PopulationThread extends Thread {
	private double[] vector;
	private final int startIndex;
	private final int endIndex;
	private Random rng;
	
	public PopulationThread(double[] vector, final int startIndex, final int endIndex) {
		this.vector = vector;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.rng = new Random();
	}
	
	@Override
	public void run() {
		for (int i = startIndex; i < endIndex; i++) {
			vector[i] = rng.nextDouble();
		}
	}
}

class CalculationThread extends Thread {
	private double[] vector;
	private final int startIndex;
	private final int endIndex;
	private int counter;
	
	public CalculationThread(double[] vector, final int startIndex, final int endIndex) {
		this.vector = vector;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.counter = 0;
	}
	
	@Override
	public void run() {
		for (int i = startIndex; i < endIndex; i++) {
			if (vector[i] > 0.25 && vector[i] < 0.75) {
				counter++;
			}
		}
	}
	
	public final int getCounter() {
		return counter;
	}
}

public class Main {
	public static void main(String[] args) {
		double[] vector = new double[200_000_000];
		
		final int numThreads = 4;
		final int blockSize = vector.length / numThreads;
		
		ArrayList<PopulationThread> populationThreads = new ArrayList<>();
		
		for	(int i = 0; i < numThreads; i++) {
			final int startIndex = i * blockSize;
			final int endIndex = startIndex + blockSize;
			
			System.out.println("PopulationThread " + i + " está populando de " + startIndex + " até " + (endIndex - 1));
			populationThreads.add(new PopulationThread(vector, startIndex, endIndex));
			populationThreads.get(i).start();
		}
		
		populationThreads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
		
		System.out.println("Encerrou a inicialização!");
		
		ArrayList<CalculationThread> calculationThreads = new ArrayList<>();
		
		for	(int i = 0; i < numThreads; i++) {
			final int startIndex = i * blockSize;
			final int endIndex = startIndex + blockSize;
			
			System.out.println("CalculationThread " + i + " está contando de " + startIndex + " até " + (endIndex - 1));
			calculationThreads.add(new CalculationThread(vector, startIndex, endIndex));
			calculationThreads.get(i).start();
		}
		
		int finalCount = 0;
		for (int i = 0; i < calculationThreads.size(); i++) {
			try {
				calculationThreads.get(i).join();
				finalCount += calculationThreads.get(i).getCounter();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};
		
		System.out.println("Contagem total de valores maiores que 0.25 e menores que 0.75: " + finalCount);
	}
}
