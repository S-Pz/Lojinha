package visao;

import controle.*;

public class Main {

	public static void main(String[] args){

		ControleCliente c = new ControleCliente();
        ControleFornecedor f = new ControleFornecedor();
        ControleProduto p = new ControleProduto();
        ControleVenda v = new ControleVenda();

		c.carregar();
		f.carregar();
		p.carregar();
		v.carregar();

		new MenuInicial();
	}
	
}