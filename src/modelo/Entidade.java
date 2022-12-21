package modelo;

import java.io.Serializable;

public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int id;

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
