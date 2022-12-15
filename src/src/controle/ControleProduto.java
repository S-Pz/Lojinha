package controle;

import persistencia.ProdutoPersist;

public class ControleProduto extends Controle {

    protected ProdutoPersist pPersist;

    public ControleProduto(){
        super(ProdutoPersist.getProdPer());
    }

    public ProdutoPersist getPersist(){
        return (ProdutoPersist) this.persistencia;
    }
}
