package visao;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.ControleVenda;
import modelo.Produto;
import modelo.Venda;
import modelo.Cliente;
import controle.ControleCliente;
import controle.ControleProduto;

public class VisaoVenda extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    ControleVenda cv = new ControleVenda();
    ControleCliente cc = new ControleCliente();
    ControleProduto cp = new ControleProduto();
    
	private JFrame frame;
    private JLabel lbIdCliente, lbProdutos;
    private JTextField tflbIdCliente, tfProdutos;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnCancelar, btnVender, btnBuscar;

    public VisaoVenda(){

        frame = new JFrame("Vendas");
        frame.setSize(500,580);
        frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        JOptionPane.showMessageDialog(this, "Para comprar faça: ID produto + hífen. Ex: 43-1-2", "Instrução",
        JOptionPane.INFORMATION_MESSAGE);

		//Adiciona os campos Labels e texto para o cliente
        lbIdCliente = new JLabel("ID do Cliente: ");
        tflbIdCliente = new JTextField();

        tflbIdCliente.setPreferredSize(new Dimension(25,30));

        frame.add(lbIdCliente);
        frame.add(tflbIdCliente);

		//Adiciona os campos Labels e texto para o produto
        lbProdutos = new JLabel("Digite os Produtos");
        tfProdutos = new JTextField();

        tfProdutos.setPreferredSize(new Dimension(240,30));

        frame.add(lbProdutos);
        frame.add(tfProdutos);

		//Adiciona a tabla na interface
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Preço(R$)");
        tableModel.addColumn("Quantidade");

        table = new JTable(tableModel);
        table.setPreferredSize(new Dimension(500, 400));
        table.setLayout(new FlowLayout(FlowLayout.RIGHT));
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setMaxWidth(150);

        JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);

        frame.add(scroll);
		
		//Atualiza a tabela assim que o menu se abrir
        carregarTabela();

		//botão de venda
        btnVender = new JButton("Finalizar Venda");
        btnVender.addActionListener(new ActionListener(){

        	public void actionPerformed(ActionEvent arg0){
                inserir();
                carregarTabela();
            }

        });

        frame.add(btnVender);
        
		//Botão de excluir venda
        btnCancelar = new JButton("Excluir Venda");
		btnCancelar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				int vRem = 0;
		    	int idProd = 0;
		    	
				String getMessage = JOptionPane.showInputDialog(frame, "Qual ID deseja remover?");
			    
			    if(cc.buscar(((Venda) cv.buscar(Integer.parseInt(getMessage))).getCli().getId()) == null) {
			    	
			    	for(int i = 0; i < ((Venda) cv.buscar(Integer.parseInt(getMessage))).getProds().size(); i++) {
			    		
			    		if(cp.buscar(((Venda) cv.buscar(Integer.parseInt(getMessage))).getProds().get(i).getId()) != null) {
					    	vRem = 1;
					    	idProd = ((Venda) cv.buscar(Integer.parseInt(getMessage))).getProds().get(i).getId();
					    	break;
			    		}
			    		
			    	}
			    	
			    	if(vRem == 1) {
			    		vRem = 0;
			    		errorMessage("Exclua o produto " + idProd);
				    	carregarTabela();
			    	} else {
			    		cv.remover(cv.buscar(Integer.parseInt(getMessage)));
		                carregarTabela();
			    	}
			    	
			    } else {
                    errorMessage("Exclua o cliente " + ((Venda) cv.buscar(Integer.parseInt(getMessage))).getCli().getId());
			    	carregarTabela();
			    }
			}		
		});

		frame.add(btnCancelar);

		//Botão de buscar uma venda
        btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
                new BuscarVenda();
			}	
			
		});

        frame.add(btnBuscar);
        frame.setVisible(true);
    }

	//Função que realiza a venda, no caso insere os produtos já cadastrados na tabela na aba de vendas
    public void inserir(){

	    int idCli, cont = 0, vEx = 0;
	    String idsProd;
	    Venda venda = new Venda();
	
	    idCli = Integer.parseInt(tflbIdCliente.getText());
	        
	    if(cc.buscar(idCli) == null) {
		    errorMessage("Insira um cliente válido");
	    } else {
	    	idsProd = tfProdutos.getText();
	    	String[] parts = idsProd.split("-");
	    	
	    	for(int i = 0; i < parts.length; i++) {

	    		if(cp.buscar(Integer.parseInt(parts[i])) == null) {
	    			vEx = 1;
	    			break;
	    		}
	    	}
	    	
	    	if(vEx == 1) {
	    		vEx = 0;
	    		errorMessage("Insira apenas produtos válidos");
	    	} else {
	    		venda.iniListProd();
	    		
	    		venda.setId(cv.getPersist().getIds());
	    	    cv.getPersist().setIds(cv.getPersist().getIds() + 1);
	    		venda.setCliente((Cliente) cc.buscar(idCli));
	    	    
	    		for(int i = 0; i < parts.length; i++) {
	    			
	    			if(((Produto) cp.buscar(Integer.parseInt(parts[i]))).getQuantity() - 1 >= 0) {
	    				venda.addProd((Produto) cp.buscar(Integer.parseInt(parts[i])));
	    				((Produto) cp.buscar(Integer.parseInt(parts[i]))).setQuantity(((Produto) cp.buscar(Integer.parseInt(parts[i]))).getQuantity() - 1);
	    				cont++;
	    			} else {
	    				vEx = 1;
	    				break;
	    			}	
		    	}
	    		
	    		if(vEx == 1) {
	    			vEx = 0;
	    			errorMessage("Produtos insuficientes");
	    			
	    			for(int i = 0; i < cont; i++) {
	    				((Produto) cp.buscar(Integer.parseInt(parts[i]))).setQuantity(((Produto) cp.buscar(Integer.parseInt(parts[i]))).getQuantity() + 1);
	    			}
	    			
	    			cont = 0;

	    		} else {
                    System.out.println("Id da venda adicionada: " + venda.getId());
	    			cv.inserir(venda);
	    		}
	    	}
	    }
    }

	//Função que atualiza a tabela de acordo com os dados inseridos
    private void carregarTabela(){

        Produto p;
        tableModel.setNumRows(0);

        for(int i = 0; i < cp.getPersist().getProdutos().size(); i++) {
            p = cp.getPersist().getProdutos().get(i);

            tableModel.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getQuantity()
            });   
        }
    }
    
	//Mostra uma menssagem de error na tela, essa menssagem é passada por parâmetro na função
    private void errorMessage(String m){
        JOptionPane.showMessageDialog(this, m, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}