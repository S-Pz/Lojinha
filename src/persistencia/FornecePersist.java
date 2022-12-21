package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Fornecedor;
import modelo.Entidade;

public class FornecePersist extends Persistencia {
	
	private static FornecePersist fP;
	private static List<Fornecedor> fornecedor;
	private static int ids;

	private FornecePersist() {
		fornecedor = new ArrayList<>();
	}

	public static FornecePersist getForPer(){

		if(fP == null){
			fP = new FornecePersist();
			fP.setIds(0);
		}

		return fP;
	}
	
	public int getIds() {
		return ids;
	}
	
	public void setIds(int id) {
		ids = id;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedor;
	}

	public void inserir(Entidade entidade) {
		fornecedor.add((Fornecedor) entidade);
	}

	public boolean remover(Entidade entidade) {
		return fornecedor.remove((Fornecedor) entidade);
	}

	public boolean alterar(Entidade entidade){
		Fornecedor f = (Fornecedor) entidade;

		for (int i = 0; i < fornecedor.size(); i++) {

			if(fornecedor.get(i).getId() == f.getId()) {
				fornecedor.set(i, f);

				return true;
			}

		}

		return false;
	}

	public Entidade buscar(int id) {
		
		for (Fornecedor fornecedor : fornecedor) {
			
			if (fornecedor.getId() == id) {
				return fornecedor;
			}
			
		}
		
		return null;
	}

	public Entidade buscar(String nome) {
		
		for (Fornecedor fornecedor : fornecedor) {
			
			if (fornecedor.getName().equals(nome)) {
				return fornecedor;
			}
			
		}
		
		return null;
	}
  
	public boolean salvarNoArquivo() {
	    File file = new File("fornecedor.txt");
	    FileOutputStream fos;
	    ObjectOutputStream oos;
	
	    try {
	    	fos = new FileOutputStream(file);
	    	oos = new ObjectOutputStream(fos);
	
	    	for(Fornecedor fornecedor : fornecedor) {
	    		oos.writeObject(fornecedor);
	    	}
	
	    	oos.close();
	    	fos.close();
	
	    	return true;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public boolean carregarDoArquivo() {
	    fornecedor = new ArrayList<>();
	    File file = new File("fornecedor.txt");
	    FileInputStream fis;
	    ObjectInputStream ois;
	
	    try {
	    	fis = new FileInputStream(file);
	    	ois = new ObjectInputStream(fis);
	
	    	try {
	    		
	    		while (true) {
	    			Object obj = ois.readObject();
	    			fornecedor.add((Fornecedor) obj);
	    		}
	    		
	    	} catch (EOFException e) {
	    		ois.close();
	    		fis.close();
	    	}
	    	
	    	ids = fornecedor.size();
	    	return true;
	    	} catch (Exception e) {
	    		return false;
	    	}
	    
	}

}