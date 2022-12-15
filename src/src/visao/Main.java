package visao;

import java.util.*;
import visao.*;
import modelo.*;
import persistencia.*;

public class Main {

	public static void main(String[] args){

		MenuInicial m = new MenuInicial();

		ClientePersist sC = new ClientePersist();
		ProdutoPersis sP = new ProdutoPersis();
		VendaPersis sV = new VendaPersis();

		int op = 0, idC = 0, idP = 0, idV = 0, ver = 0, verAddProd = 0;
		String res = "";
		Venda v;
		
		//Colocar as listas nas persistências
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		
		clientes = sC.read();
		idC += clientes.size();
		produtos = sP.read();
		idP += produtos.size();
		vendas = sV.read(clientes, produtos);
		idV += vendas.size();
		
		while(op != 10){

			res += m.MenuIniT;

			System.out.println();

			String[] parts = res.split("-");
		
			op = Integer.parseInt(parts[0]);
			
			if(op == 1) {
				
				try {
					Integer.parseInt(parts[1]);
				} catch(Exception e) {
					Cliente c = new Cliente(idC, parts[1], Long.parseLong(parts[4]), Long.parseLong(parts[5]), Integer.parseInt(parts[3]), parts[2]);
					
					clientes.add(c);
					idC++;
					m.conf(idC);
				}
				
			} else if(op == 2) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					if(clientes.size() < Integer.parseInt(parts[2])) {
						m.except();
					} else {
						clientes.remove(Integer.parseInt(parts[2]));
						m.conf();
					}
					
				}
				
			} else if(op == 3) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					if(clientes.size() < (Integer.parseInt(parts[2]) + 1)) {
						m.except();
					} else {
						clientes.get(Integer.parseInt(parts[2])).status();
						m.conf();
					}
					
				}
				
			} else if(op == 4) {
				
				try {
					Integer.parseInt(parts[1]);
				} catch(Exception e) {
					Produto p = new Produto(idP, parts[1], parts[2], Integer.parseInt(parts[4]), Float.parseFloat(parts[3]));
					
					produtos.add(p);
					idP++;
					m.conf(idP);
				}
				
			} else if(op == 5) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					if(produtos.size() < Integer.parseInt(parts[2])) {
						m.except();
					} else {
						produtos.remove(Integer.parseInt(parts[2]));
						m.conf();
					}
					
				}
				
			} else if(op == 6) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					if(produtos.size() < (Integer.parseInt(parts[2]) + 1)) {
						m.except();
					} else {
						produtos.get(Integer.parseInt(parts[2])).status();
						m.conf();
					}
				
				}
				
			} else if(op == 7) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					try {
						v = new Venda(idV, produtos.get(Integer.parseInt(parts[3])), clientes.get(Integer.parseInt(parts[3 + Integer.parseInt(parts[2])])), Integer.parseInt(parts[4 + Integer.parseInt(parts[2])]), Integer.parseInt(parts[5 + Integer.parseInt(parts[2])]));
					} catch(Exception e) {
						System.out.println("Aqui 2");
						m.except();
						res = "";
						verAddProd = 1;
						continue;
					}
					
					if((produtos.get(Integer.parseInt(parts[3])).getQuantity()) - 1 <= 0) {
						m.insProdu();
						res = "";
						verAddProd = 1;
						continue;
					} else {
						produtos.get(Integer.parseInt(parts[3])).setQuantity((produtos.get(Integer.parseInt(parts[3])).getQuantity()) - 1);
					}
					
					try {
						
						for(int i = 1; i < Integer.parseInt(parts[2]); i++) {
							
							if((produtos.get(Integer.parseInt(parts[3 + i])).getQuantity()) - 1 >= 0) {
								v.addProd(produtos.get(Integer.parseInt(parts[3 + i])));
								produtos.get(Integer.parseInt(parts[3 + i])).setQuantity((produtos.get(Integer.parseInt(parts[3 + i])).getQuantity()) - 1);
							} else {
								m.insProdu();
								verAddProd = 1;
								res = "";
								break;
							}
							
						}
						
					} catch(Exception e) {
						System.out.println("Aqui 3");
						m.except();
						verAddProd = 1;
						res = "";
						continue;
					}
					
					if(verAddProd == 0) {
						vendas.add(v);
						idV++;
						m.conf(idV);
					} else {
						verAddProd = 0;
					}
					
				}
				
			} else if(op == 8) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					if(vendas.size() < Integer.parseInt(parts[2])) {
						m.except();
					} else {
						
						try {
							vendas.get(Integer.parseInt(parts[2])).getCli();
						} catch(ArrayIndexOutOfBoundsException e) {
							ver = 1;
						}
						
						try {
							
							for(int i = 0; i < vendas.get(Integer.parseInt(parts[2])).getProds().size(); i++) {
								vendas.get(Integer.parseInt(parts[2])).getProds().get(i);
							}
							
						} catch(ArrayIndexOutOfBoundsException e) {
							ver = 1;
						}
						
						if(ver == 1) {
							vendas.remove(Integer.parseInt(parts[2]));
							m.conf();
						} else {
							ver = 0;
							m.remFail();
						}
						
					}
					
				}
				
			} else if(op == 9) {
				
				if(Integer.parseInt(parts[1]) == 1) {
					
					if(vendas.size() < (Integer.parseInt(parts[2]) + 1)) {
						m.except();
					} else {
						vendas.get(Integer.parseInt(parts[2])).status();
						m.conf();
					}
				
				}
				
			}
			
			res = "";
		}
		
		sC.save(clientes);
		sP.save(produtos);
		sV.save(vendas);
	}

}
