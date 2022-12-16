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

import modelo.Fornecedor;
import controle.ControleFornecedor;

public class VisaoFornecedor extends JFrame {
    
    ControleFornecedor Cf = new ControleFornecedor();
    
    private JLabel lbName, lbCnpj, lbAdress, lbPhone;
    private JTextField tfName, tfCnpj, tfAdress, tfPhone;
    private JButton btnInserir, btnApagar ;
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame frame; 
    private JPanel btnPanel;
    JScrollPane scroll;

    public VisaoFornecedor(){
        
        frame = new JFrame("Fornecedor");
        
        frame.setSize(500, 560);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        //Name insert
        lbName = new JLabel("Nome do Fornecedor:");
        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(150,20));

        frame.add(lbName);
        frame.add(tfName);

        //CNPJ insert
        lbCnpj = new JLabel("Cnpj:");
        tfCnpj = new JTextField();
        tfCnpj.setPreferredSize(new Dimension(150,20));
    
        frame.add(lbCnpj);
        frame.add(tfCnpj);

        //Adress insert
        lbAdress = new JLabel("Endereço:");
        tfAdress = new JTextField();
        tfAdress.setPreferredSize(new Dimension(200,20));

        frame.add(lbAdress);
        frame.add(tfAdress);

        //Phone insert
        lbPhone = new JLabel("Telefone:");
        tfPhone = new JTextField();
        tfPhone.setPreferredSize(new Dimension(150,20));

        frame.add(lbPhone);
        frame.add(tfPhone);

        //Cria tabela com as colunas dos atributos dos produtos.
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("CNPJ");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("Telefone");

        table = new JTable(tableModel);
        table.setPreferredSize(new Dimension(500, 400));
        table.setLayout(new FlowLayout(FlowLayout.RIGHT));
        table.getColumnModel().getColumn(0).setMinWidth(10);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(90);
        table.getColumnModel().getColumn(3).setMinWidth(50);

        scroll = new JScrollPane();
		scroll.setViewportView(table);
        
		frame.add(scroll);
        
        btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(500, 80));
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
                
                String getMessage = JOptionPane.showInputDialog(frame, "Qual ID deseja remover");
                Cf.remover(Cf.buscar(Integer.parseInt(getMessage)));
                carregarTabela();

			}			
		});

		btnPanel.add(btnApagar);
        frame.add(btnPanel);

        frame.setVisible(true);

    }

    public void inserir(){

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setId(Cf.getPersist().getFornecedores().size() + 1);
        fornecedor.setName(tfName.getText());
        fornecedor.setCnpj(Long.parseLong(tfCnpj.getText()));
        fornecedor.setAdress(tfAdress.getText());
        fornecedor.setPhone(Long.parseLong(tfPhone.getText()));

        Cf.inserir(fornecedor);
    }

    private void carregarTabela(){

        Fornecedor f;

        tableModel.setNumRows(0);

        for(int i = 0; i < Cf.getPersist().getFornecedores().size(); i++) {
            f = Cf.getPersist().getFornecedores().get(i);
        
            tableModel.addRow(new Object[]{
                f.getId(),
                f.getName(),
                f.getCnpj(),
                f.getAdress(),
                f.getPhone(),
    
            });

            System.out.println(f.getName());
        }
    }
}
