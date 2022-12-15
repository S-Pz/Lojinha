package controle;

import persistencia.VendaPersist;

public class ControleVenda extends Controle {
    
    public ControleVenda(){
        super(VendaPersist.getVendaPer());
    }
}