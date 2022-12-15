package modelo;

import java.util.ArrayList;

public class Venda extends Entidade {

	private Cliente cliente;
	private ArrayList<Produto> produtos;
	private int trDay;
	private int trMon;
	
	public Venda() {

    	this.id = 0;
    	this.produtos = null;
    	this.cliente = null;
        this.trDay = 0;
        this.trMon = 0;
    }
	
	public Venda(int id, Produto prod, Cliente cliente, int trDay, int trMon){

		this.id = id;
		this.produtos = new ArrayList<Produto>();
		this.produtos.add(prod);
		this.cliente = cliente;
		this.trDay = trDay;
		this.trMon = trMon;
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

	public int getTrDay() {
		return trDay;
	}

	public void setTrDay(int trDay) {
		this.trDay = trDay;
	}

	public int getTrMon() {
		return trMon;
	}

	public void setTrMon(int trMon) {
		this.trMon = trMon;
	}
	
	public void status() {
		System.out.println("Nome do cliente comprador: " + this.cliente.getName());
		System.out.println("Data da compra: " + this.getTrDay() + "/" + this.trMon);
		System.out.println("\nProdutos comprados: ");
		
		for(int i = 0; i < this.produtos.size(); i++) {
			System.out.println("Produto " + (i + 1) + ": " + this.produtos.get(i).getName());
		}
		
    }
	
}
