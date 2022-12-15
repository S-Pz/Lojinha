package controle;

import persistencia.ClientePersist;

public class ControleCliente extends Controle {
    
    public ControleCliente(){
        super(new ClientePersist());
    }
}