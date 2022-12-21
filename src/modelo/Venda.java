package modelo;

import java.util.ArrayList;

public class Venda extends Entidade {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private ArrayList<Produto> produtos;
	
	public Venda() {
    	this.id = 0;
    	this.produtos = null;
    	this.cliente = null;
    }
	
	public Venda(int id, Produto prod, Cliente cliente){
		this.id = id;
		this.produtos = new ArrayList<Produto>();
		this.produtos.add(prod);
		this.cliente = cliente;
	}

	public ArrayList<Produto> getProds() {
		return produtos;
	}

	public void addProd(Produto prod) {
		this.produtos.add(prod);
	}

	public Cliente getCli() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void iniListProd() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public void status() {
		System.out.println("Nome do cliente comprador: " + this.cliente.getName());
		System.out.println("\nProdutos comprados: ");
		
		for(int i = 0; i < this.produtos.size(); i++) {
			System.out.println("Produto " + (i + 1) + ": " + this.produtos.get(i).getName());
		}
		
    }
	
}
