package controle;

import persistencia.Persistencia;
import modelo.Entidade;

public abstract class Controle {

	protected Persistencia persistencia;

	public Controle(Persistencia persistencia) {
		this.persistencia = persistencia;
	}

	public void inserir(Entidade entidade) {
		persistencia.inserir(entidade);
	}

	public boolean remover(Entidade entidade) {
		return persistencia.remover(entidade);
	}

	public boolean alterar(Entidade entidade) {
		return persistencia.alterar(entidade);
	}

	public Entidade buscar(int id) {
		return persistencia.buscar(id);
	}

	public Entidade buscar(String valor) {
		return persistencia.buscar(valor);
	}

	public boolean carregar() {
		return persistencia.carregarDoArquivo();
	}

	public boolean salvar() {
		return persistencia.salvarNoArquivo();
	}

}