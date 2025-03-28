public class Main {
	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Restaurante BCC");
		restaurante.adicionarPratoAoMenu(new Prato(1, "Lasanha", 35.0));
		restaurante.adicionarPratoAoMenu(new Prato(2, "Feijoada", 50.0));
		restaurante.adicionarPratoAoMenu(new Prato(3, "Pizza", 60.0));
		restaurante.adicionarPratoAoMenu(new Prato(4, "Hambúrguer", 25.0));
		restaurante.adicionarPratoAoMenu(new Prato(5, "Arroz", 20.0));
		restaurante.adicionarPratoAoMenu(new Prato(6, "Salada", 15.0));

		Menu menu = new Menu(restaurante);

		menu.cadastrarCliente();
		menu.cadastrarPedido();

		menu.encerrar();
	}
}