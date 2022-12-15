package visao;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Menu {

	Scanner l = new Scanner(new BufferedInputStream(System.in));
	
	public String menuInit() {
		
		int op;
		String res = "";
		
		System.out.println("\n#-------# Bem Vindo! #-------#");
		System.out.println("Para começar, por favor selecione uma operação: ");
		System.out.println("1 - Cadastrar cliente;");
		System.out.println("2 - Remover cliente;");
		System.out.println("3 - Ver dados dos clientes;");
		System.out.println("4 - Cadastrar produto;");
		System.out.println("5 - Remover produto;");
		System.out.println("6 - Ver dados dos produtos;");
		System.out.println("7 - Realizar uma venda;");
		System.out.println("8 - Cancelar uma venda;");
		System.out.println("9 - Ver dados das vendas;");
		System.out.println("10 - Sair.");
		System.out.print("\n");
		
		//recebe a opção escolhida
		op = l.nextInt();
		res += Integer.toString(op);
		res += "-";
		
		// switch para as opções de escolha do usuário

		switch(op) {
			case 1:
				res += newCliente();
				break;
			case 2:
				res += remClient();
				break;
			case 3:
				res += showClient();
				break;
			case 4:
				res += newProduto();
				break;
			case 5:
				res += remProduct();
				break;
			case 6:
				res += showProduct();
				break;
			case 7:
				res += newTransaction();
				break;
			case 8:
				res += cancTransaction();//aleterar venda ao invés de apagar
				break;
			case 9:
				res += showTransaction();
				break;
			default:
				menuExit();
		}
		
		return res;
	}
	
	private String newCliente(){

		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Novo Cliente #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		
		if(aux != 1) {
			res += Integer.toString(aux);
			return res;
		}

		res = "";
		
		l.nextLine();
		
		System.out.println("Nome: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.println("Endereço: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.println("Idade: ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("CPF: ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("Telefone: ");

		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("\n");
		return res;
	}
	
	private String newProduto() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Novo Produto #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		
		if(aux != 1) {
			res += Integer.toString(aux);
			return res;
		}

		res = "";
		
		l.nextLine();
		
		System.out.println("Nome: ");
		
		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.println("Tipo: ");
		
		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.println("Preço: ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("Quantidade: ");

		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("\n");
		return res;
	}
	
	private String newTransaction() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Nova Venda #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		l.nextLine();
		
		System.out.println("ID do produto vendido: ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("ID do cliente comprador: ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("Dia da venda (do mês): ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("Mês da venda (número): ");
		
		if(l.hasNext()) {
			res += l.next();
			res += "-";
		}
		
		System.out.println("\n");
		return res;
	}
	
	private String showClient() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Dados do Cliente #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		System.out.println("Para acessar os dados de um cliente, informe o seu ID: ");

		l.nextLine();
		
		System.out.println("ID: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}

		System.out.print("\n");
		return res;
	}
	
	private String showProduct() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Dados do Produto #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		System.out.println("Para acessar os dados de um produto, informe o seu ID: ");

		l.nextLine();
		
		System.out.println("ID: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.print("\n");
		return res;
	}
	
	private String showTransaction() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Dados da Venda #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		System.out.println("Para acessar os dados de uma venda, informe o seu ID: ");

		l.nextLine();
		
		System.out.println("ID: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.print("\n");
		return res;
	}
	
	private String remClient() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Remover Cliente #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		System.out.println("Para remover os dados de um cliente, informe o seu ID: ");

		l.nextLine();
		
		System.out.println("ID: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.print("\n");
		return res;
	}
	
	private String remProduct() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Remover Produto #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		System.out.println("Para remover os dados de um produto, informe o seu ID: ");

		l.nextLine();
		
		System.out.println("ID: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.print("\n");
		return res;
	}
	
	private String cancTransaction() {
		String res = "";
		int aux;
		
		System.out.println("\n");
		System.out.println("#-------# Cancelar Venda #-------#");
		
		l.nextLine();
		
		System.out.println("Para prosseguir digite 1, caso queira retorna ao menu, digite qualquer número: ");
		aux = l.nextInt();
		res += Integer.toString(aux);
		res += "-";
		
		if(aux != 1) {
			return res;
		}
		
		System.out.println("Para cancelar uma venda, informe o seu ID: ");

		l.nextLine();
		
		System.out.println("ID: ");

		if(l.hasNext()) {
			res += l.nextLine();
			res += "-";
		}
		
		System.out.print("\n");
		return res;
	}

	//Sobrecarga de métodos
	public void conf() {
		System.out.println("\nOperação realizada com sucesso!\n");
	}
	
	public void conf(int id) {
		System.out.println("\nOperação realizada com sucesso!");
		System.out.println("ID do item adicionado: " + (id - 1) + "\n");
	}
	
	//Tratamentos de erros!
	public void except() {
		System.out.println("Operação não pode ser realizada!");
		System.out.println("Verifique os dados e tente novamente!\n");
	}

	public void insProdu() {
		System.out.println("\nInfelizmente este produto não está mais disponível no estoque!");
	}
	
	public void menuExit() {
		System.out.println("\n#-------# Fim da Execução! #-------#");
	}	
}
