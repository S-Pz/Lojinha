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
import modelo.Venda;
import controle.ControleCliente;
import controle.ControleProduto;

public class VisaoVenda extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    ControleVenda cV = new ControleVenda();
    ControleCliente cC = new ControleCliente();
    ControleProduto cP = new ControleProduto();
    
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

        lbIdCliente = new JLabel("ID do Cliente: ");
        tflbIdCliente = new JTextField();

        tflbIdCliente.setPreferredSize(new Dimension(25,30));

        frame.add(lbIdCliente);
        frame.add(tflbIdCliente);

        lbProdutos = new JLabel("Digite os Produtos");
        tfProdutos = new JTextField();

        tfProdutos.setPreferredSize(new Dimension(240,30));

        frame.add(lbProdutos);
        frame.add(tfProdutos);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Produto");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("Preço(R$)");
        tableModel.addColumn("Total(R$)");

        table = new JTable(tableModel);
        table.setPreferredSize(new Dimension(500, 400));
        table.setLayout(new FlowLayout(FlowLayout.RIGHT));
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(200);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setMaxWidth(60);

        JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);

        frame.add(scroll);

        btnVender = new JButton("Finalizar Venda");
        btnVender.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0){
              
            }

        });

        frame.add(btnVender);
        
        btnCancelar = new JButton("Excluir Venda");
		btnCancelar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                

			}			
		});

		frame.add(btnCancelar);

        btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                
			    String getMessage = JOptionPane.showInputDialog(frame, "Qual ID ou venda deseja buscar");
			    
                try{
                    int aux = Integer.parseInt(getMessage);
                    carregarTabela(aux);

                }catch(Exception error){
                    carregarTabela(getMessage);
                }
                
			}			
		});

        frame.add(btnBuscar);

        frame.setVisible(true);
        
    }

    // public void inserir(){

    // 	int idFor;
    //     Produto produto = new Produto();

    //     produto.setId(cp.getPersist().getIds());
    //     cp.getPersist().setIds(cp.getPersist().getIds() + 1);
    //     produto.setName(tfName.getText());
    //     produto.setType(tfType.getText());
    //     produto.setPrice(Float.parseFloat(tfPrice.getText()));
    //     produto.setQuantity(Integer.parseInt(tfQuant.getText()));
    //     idFor = Integer.parseInt(tfFor.getText());
        
    //     if(cf.buscar(idFor) == null) {
    //         JOptionPane.showMessageDialog(this, "Insira um fornecedor válido.",
    //         "ERROR", JOptionPane.ERROR_MESSAGE);

    //     } else {
    //     	cp.inserir(produto);
    //     }
       
    // }

    private void carregarTabela(){

        Venda v;
        tableModel.setNumRows(0);
        
        for(int i = 0; i < cv.getPersist().getVenda().size(); i++) {
            v = cv.getPersist().getProdutos().get(i);

            tableModel.addRow(new Object[]{
                v.getId(),
                v.getCli(),
                v.getProds(),
                
            });
        }
    }

    private void carregarTabela(int ID){

        Produto p;
        tableModel.setNumRows(0);

        for(int i = 0; i < cp.getPersist().getProdutos().size(); i++) {
            p = cp.getPersist().getProdutos().get(i);

            if(p.getId() == ID){
                tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getType(),
                    p.getPrice(),
                    p.getQuantity()
                });
            }
        }
    }

    private void carregarTabela(String name){
        Produto p;

        tableModel.setNumRows(0);

        for(int i = 0; i < cp.getPersist().getProdutos().size(); i++) {
            p = cp.getPersist().getProdutos().get(i);

            if(p.getName().equals(name)){
                tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getType(),
                    p.getPrice(),
                    p.getQuantity()
                });
            }
        }
    }

    public static void main(String[] args) {
        new VisaoVenda();
    }
}
