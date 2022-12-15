package modelo;

import java.io.Serializable;

public abstract class Entidade implements Serializable {

	protected int id;

    //Construtor entidade vazio
    public Entidade(){
        this.id = 0;
    }

    public Entidade(int id){
        this.id = id;
    }
    
	public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public abstract void status();
}
