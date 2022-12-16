package visao;

import java.util.*;


import controle.*;
import visao.*;
import modelo.*;
import persistencia.*;

public class Main {

	public static void main(String[] args){

		ControleCliente c = new ControleCliente();
		ControleProduto p = new ControleProduto();

		c.carregar();
		p.carregar();

		new MenuInicial();
	}
}