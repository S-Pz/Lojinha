package persistencia;

import modelo.Entidade;

public abstract class Persistencia {
    
    public abstract void inserir(Entidade entidade);

    public abstract boolean remover(Entidade entidade);
  
    public abstract boolean alterar(Entidade entidade);
  
    public abstract Entidade buscar(int id);
  
    public abstract Entidade buscar(String valor);
  
    public abstract boolean carregarDoArquivo();
  
    public abstract boolean salvarNoArquivo();
}