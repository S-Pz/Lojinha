package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;
import modelo.Entidade;

public class ProdutoPersist extends Persistencia {

	private static ProdutoPersist pP;
	private static List<Produto> produtos;

	private ProdutoPersist() {
		produtos = new ArrayList<>();
	}

	public static ProdutoPersist getProdPer(){

		if(pP == null){
			pP = new ProdutoPersist();
		}

		return pP;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void inserir(Entidade entidade) {
		produtos.add((Produto) entidade);
	}

	public boolean remover(Entidade entidade) {
		return produtos.remove((Produto) entidade);
	}

	public boolean alterar(Entidade entidade){

		Produto produto = (Produto) entidade;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == produto.getId()) {

				produtos.set(i, produto);
				return true;
			}
		}
		return false;
	}

	public Entidade buscar(int id) {
	for (Produto produto : produtos) {
		if (produto.getId() == id) {
			return produto;
		}
	}
		return null;
	}

	public Entidade buscar(String nome) {
		for (Produto produto : produtos) {
			if (produto.getName().equals(nome)) {
				return produto;
			}
		}
		return null;
	}
	
	public boolean salvarNoArquivo() {
		File file = new File("produtos.txt");
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			for (Produto produto : produtos) {
				oos.writeObject(produto);
			}

			oos.close();
			fos.close();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean carregarDoArquivo() {
		produtos = new ArrayList<>();
		File file = new File("produtos.txt");
		FileInputStream fis;
		ObjectInputStream ois;

		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			try {
				while (true) {
					Object obj = ois.readObject();
					produtos.add((Produto) obj);
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