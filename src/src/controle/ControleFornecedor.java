package controle;

import persistencia.FornecePersist;

public class ControleFornecedor extends Controle {
    
    public ControleFornecedor(){
        super(FornecePersist.getForPer());
    }

    public FornecePersist getPersist(){
        return (FornecePersist) this.persistencia;
    }
}
