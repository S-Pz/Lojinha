package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Entidade;

public class ClientePersist extends Persistencia {
	
	private static ClientePersist cP;
	private static List<Cliente> clientes;
	private static int ids;

	private ClientePersist() {
	  clientes = new ArrayList<>();
	}

	public static ClientePersist getCliPer(){

	  if(cP == null){
		  cP = new ClientePersist();
		  cP.setIds(0);
		}

	  return cP;
	}

	public int getIds() {
		return ids;
	}
	
	public void setIds(int id) {
		ids = id;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void inserir(Entidade entidade) {
		clientes.add((Cliente) entidade);
	}

	public boolean remover(Entidade entidade) {
		return clientes.remove((Cliente) entidade);
	}

	public boolean alterar(Entidade entidade){
		Cliente cliente = (Cliente) entidade;
		
		for (int i = 0; i < clientes.size(); i++) {

			if (clientes.get(i).getId() == cliente.getId()) {
				clientes.set(i, cliente);

				return true;
			}
		}
    
		return false;
	}

	public Entidade buscar(int id) {
		
		for (Cliente cliente : clientes) {
		
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		
		return null;
	}

	public Entidade buscar(String nome) {
		
		for (Cliente cliente : clientes) {
			if (cliente.getName().equals(nome)) {
				return cliente;
			}
		}
		
		return null;
	}
  
	public boolean salvarNoArquivo() {
	    File file = new File("clientes.txt");
	    FileOutputStream fos;
	    ObjectOutputStream oos;
	
	    try {
	    	fos = new FileOutputStream(file);
	    	oos = new ObjectOutputStream(fos);
	
	    	for (Cliente cliente : clientes) {
	    		oos.writeObject(cliente);
	    	}
	
	    	oos.close();
	    	fos.close();
	
	    	return true;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public boolean carregarDoArquivo() {
	    clientes = new ArrayList<>();
	    File file = new File("clientes.txt");
	    FileInputStream fis;
	    ObjectInputStream ois;
	
	    try {
	    	fis = new FileInputStream(file);
	    	ois = new ObjectInputStream(fis);
	
	    	try {
	    		
	    		while (true) {
	    			Object obj = ois.readObject();
	    			clientes.add((Cliente) obj);
	    		}
	    		
	    	} catch (EOFException e) {
	    		ois.close();
	    		fis.close();
	    	}
	    	
	    	ids = clientes.size();
	    	return true;
	    } catch (Exception e) {
	    	return false;
	    }
	}
}