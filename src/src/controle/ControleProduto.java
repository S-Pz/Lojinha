package controle;

import persistencia.ProdutoPersis;

public class ControleProduto extends Controle {
    
    public ControleProduto(){
        super(new ProdutoPersis());
    }
}
