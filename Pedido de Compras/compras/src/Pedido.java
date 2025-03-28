import java.util.ArrayList;

public class Pedido {
	private Cliente cliente;
	private ArrayList<Prato> pratos;

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.pratos = new ArrayList<>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(ArrayList<Prato> pratos) {
		this.pratos = pratos;
	}

	public void adicionarPrato(Prato prato) {
		pratos.add(prato);
	}

	public void removerPrato(int codigoPrato) {
		for (int i = 0; i < pratos.size(); i++) {
			if (pratos.get(i).getId() == codigoPrato) {
				pratos.remove(i);
			}
		}
	}

	public void removerPratoInstanciaN(int codigoPrato, int n) {
		int instancia = 0;

		for (int i = 0; i < pratos.size(); i++) {
			if (pratos.get(i).getId() == codigoPrato) {
				if (instancia == n) {
					pratos.remove(i);
				}
				instancia++;
			}
		}

	}

	public ArrayList<Prato> listarPratos(int codigoPrato) {
		ArrayList<Prato> pratosComMesmoCodigo = new ArrayList<>();

		for (int i = 0; i < pratos.size(); i++) {
			if (pratos.get(i).getId() == codigoPrato)
				pratosComMesmoCodigo.add(pratos.get(i));
		}

		return pratosComMesmoCodigo;
	}

	public void exibirPedido() {
		System.out.println("\n*** PEDIDO DO CLIENTE ***");
		cliente.exibirDados();
		System.out.println("Pratos escolhidos:");
		double total = 0;

		for (int i = 0; i < pratos.size(); i++) {
			pratos.get(i).exibirDetalhes();
			total += pratos.get(i).getPreco();
		}

		System.out.println("Total do Pedido: R$ " + total + "\n");
	}
}