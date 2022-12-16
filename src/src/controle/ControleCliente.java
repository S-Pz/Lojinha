package controle;

import persistencia.ClientePersist;

public class ControleCliente extends Controle {
    
	public ControleCliente(){
		super(ClientePersist.getCliPer());
    }

    public ClientePersist getPersist(){
        return (ClientePersist) this.persistencia;
    }
    
}