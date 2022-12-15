package visao;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;
import controle.ControleProduto;
import visao.MenuInicial;

public class VisaoProduto extends JFrame{

    private JTextField tfName, tfType, tfPrice, tfQuant;
    private JLabel lbName, lbType, lbPrice, lbQuant;
    private JButton btnInserir, btnApagar ;
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame frame; 

    private ArrayList<Produto> products;

    public VisaoProduto(){
        
        frame = new JFrame("Cadastra Produto");
        
        frame.setSize(500, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        frame.add(inPanel);

        //Cria tabela com as colunas dos atributos dos produtos.
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Preço");
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

        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0){
                inserir();
            }

        });

        btnPanel.add(btnInserir);
        
        btnApagar = new JButton("Apagar");
		btnApagar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}			
		});

		btnPanel.add(btnApagar);
        frame.add(btnPanel);

        frame.setVisible(true);

    }

    public void inserir(){

        Produto produto = new Produto();

        produto.setId(0);
        produto.setName(tfName.getText());
        produto.setType(tfType.getText());
        produto.setPrice(Float.parseFloat(tfPrice.getText()));
        produto.setQuantity(Integer.parseInt(tfPrice.getText()));

        ControleProduto cp = new ControleProduto();
        cp.inserir(produto);
    }

    private void carregarTabela(){
        tableModel.setNumRows(0);
        for(Produto p : products)
            tableModel.addRow(new Object[]{
                0,
                p.getName(),
                p.getPrice(),
                p.getQuantity(),
                p.getType()
            });
    }
    public static void main(String[] args) {
      new VisaoProduto();
    }
}

