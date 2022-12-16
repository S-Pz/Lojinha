package controle;

import persistencia.ProdutoPersist;

public class ControleProduto extends Controle {

	public ControleProduto(){
        super(ProdutoPersist.getProdPer());
    }

    public ProdutoPersist getPersist(){
        return (ProdutoPersist) this.persistencia;
    }
    
}
