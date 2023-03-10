package visao;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;
import modelo.Fornecedor;
import controle.ControleProduto;
import controle.ControleFornecedor;

public class VisaoProduto extends JFrame{

    private static final long serialVersionUID = 1L;

    ControleProduto cp = new ControleProduto();
	ControleFornecedor cf = new ControleFornecedor();

    private JTextField tfName, tfType, tfPrice, tfQuant, tfFor;
    private JLabel lbName, lbType, lbPrice, lbQuant, lbFor;
    private JButton btnInserir, btnApagar, btnBuscar;
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame frame; 

    public VisaoProduto() {
        frame = new JFrame("Cadastra Produto");
        
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setResizable(false);
        
        JPanel inPanel = new JPanel();
        inPanel.setPreferredSize(new Dimension(380, 80));
        inPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        //Name insert
        lbName = new JLabel("Nome do Produto:");
        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(200,20));

        inPanel.add(lbName);
        inPanel.add(tfName);

        //Type insert
        lbType = new JLabel("Tipo/categoria:");
        tfType= new JTextField();
        tfType.setPreferredSize(new Dimension(70,20));

        inPanel.add(lbType);
        inPanel.add(tfType);
        
        //Price insert
        lbPrice = new JLabel("Preço:");
        tfPrice = new JTextField();
        tfPrice.setPreferredSize(new Dimension(50,20));

        inPanel.add(lbPrice);
        inPanel.add(tfPrice);

        //Quant insert
        lbQuant = new JLabel("Quantidade:");
        tfQuant = new JTextField();
        tfQuant.setPreferredSize(new Dimension(40,20));

        inPanel.add(lbQuant);
        inPanel.add(tfQuant);
        
        //For insert
        lbFor = new JLabel("ID do fornecedor:");
        tfFor = new JTextField();
        tfFor.setPreferredSize(new Dimension(40,20));

        inPanel.add(lbFor);
        inPanel.add(tfFor);

        frame.add(inPanel);

        //Cria tabela com as colunas dos atributos dos produtos.
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Preço(R$)");
        tableModel.addColumn("Quantidade");

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
        
        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(500, 80));
        btnPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        carregarTabela();

        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0){
                inserir();
                carregarTabela();
            }

        });

        btnPanel.add(btnInserir);
        
        btnApagar = new JButton("Apagar");
		btnApagar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String getMessage = JOptionPane.showInputDialog(frame, "Qual ID deseja remover?");
			    
			    if(cf.buscar(((Produto) cp.buscar(Integer.parseInt(getMessage))).getFornecedor().getId()) == null) {
			    	cp.remover(cp.buscar(Integer.parseInt(getMessage)));
	                carregarTabela();
			    } else {
                    errorMessage("Exclua o fornecedor " + ((Produto) cp.buscar(Integer.parseInt(getMessage))).getFornecedor().getId());
			    	carregarTabela();
			    }
                
			}
			
		});
		
		btnPanel.add(btnApagar);

        btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			    String getMessage = JOptionPane.showInputDialog(frame, "Qual ID ou produto (nome) deseja buscar?");
			    
                try{
                    int aux = Integer.parseInt(getMessage);
                    carregarTabela(aux);
                } catch(Exception e) {
                    carregarTabela(getMessage);
                }
                
			}
			
		});
		
		btnPanel.add(btnBuscar);

        frame.add(btnPanel);
        frame.setVisible(true);
    }

    public void inserir(){
    	int idFor;
        Produto produto = new Produto();

        produto.setId(cp.getPersist().getIds());
        cp.getPersist().setIds(cp.getPersist().getIds() + 1);
        produto.setName(tfName.getText());
        produto.setType(tfType.getText());
        produto.setPrice(Float.parseFloat(tfPrice.getText()));
        produto.setQuantity(Integer.parseInt(tfQuant.getText()));
        idFor = Integer.parseInt(tfFor.getText());
        produto.setFornecedor((Fornecedor) cf.buscar(idFor));
        
        if(cf.buscar(idFor) == null) {
            errorMessage("Insira um fornecedor válido");
        } else {
        	
        	cp.inserir(produto);
        }
       
    }

    private void carregarTabela(){
        Produto p;
        tableModel.setNumRows(0);

        for(int i = 0; i < cp.getPersist().getProdutos().size(); i++) {
            p = cp.getPersist().getProdutos().get(i);

            tableModel.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getType(),
                p.getPrice(),
                p.getQuantity()
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
    
    private void errorMessage(String m){
        JOptionPane.showMessageDialog(this, m,
        "ERROR", JOptionPane.ERROR_MESSAGE);
    }

}

