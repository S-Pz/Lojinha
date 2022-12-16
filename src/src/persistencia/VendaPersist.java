package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Venda;
import modelo.Entidade;

public class VendaPersist extends Persistencia {
	
	private static VendaPersist vP;
	private static List<Venda> venda;
	private static int ids;

	private VendaPersist() {
		venda = new ArrayList<>();
	}

	public static VendaPersist getVendaPer(){

		if(vP == null){
			vP = new VendaPersist();
			vP.setIds(0);
		}

		return vP;
	}
	
	public int getIds() {
		return ids;
	}
	
	public void setIds(int id) {
		ids = id;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void inserir(Entidade entidade) {
		venda.add((Venda) entidade);
	}

	public boolean remover(Entidade entidade) {
		return venda.remove((Venda) entidade);
	}

	public boolean alterar(Entidade entidade){
		Venda v = (Venda) entidade;
    
    	for (int i = 0; i < venda.size(); i++) {

    		if (venda.get(i).getId() == v.getId()) {
    			venda.set(i, v);
        		return true;
      		}

    	}
  
    	return false;
	}

	public Entidade buscar(int id) {
		
		for (Venda venda : venda) {
			
			if (venda.getId() == id) {
				return venda;
			}
			
		}
		
		return null;
	}

	public Entidade buscar(String nome) {
		
		for (Venda venda : venda) {
			
			if (venda.getCli().getName().equals(nome)) {//Faz a pesquisa pelo nome do cliente
				return venda;
			}
			
		}
		
		return null;
	}
  
	public boolean salvarNoArquivo() {
		File file = new File("venda.txt");
	    FileOutputStream fos;
	    ObjectOutputStream oos;
	
	    try {
	    	fos = new FileOutputStream(file);
	    	oos = new ObjectOutputStream(fos);
	
	    	for (Venda venda : venda) {
	    		oos.writeObject(venda);
	    	}
	
	    	oos.close();
	    	fos.close();
	
	    	return true;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public boolean carregarDoArquivo() {
		venda = new ArrayList<>();
	    File file = new File("venda.txt");
	    FileInputStream fis;
	    ObjectInputStream ois;
	
	    try {
	    	fis = new FileInputStream(file);
	    	ois = new ObjectInputStream(fis);
	
	    	try {
	    		
	    		while (true) {
	    			Object obj = ois.readObject();
	    			venda.add((Venda) obj);
	    		}
	    		
	    	} catch (EOFException e) {
	    		ois.close();
	    		fis.close();
	    	}
	    	
	    	return true;
	    } catch (Exception e) {
	      return false;
	    }
	    
	}

}
