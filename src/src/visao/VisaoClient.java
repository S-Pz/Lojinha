package visao;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import controle.ControleCliente;

public class VisaoClient extends JFrame{

    private JFrame frame; 
    JLabel lbName, lbAge, lbCpf, lbPhone, lbAdress;
    JTextField tfName, tfAge, tfCpf, tfPhone, tfAdress;
    DefaultTableModel tableModel;
    JPanel btnPanel;
    JButton btnInserir, btApagar;
    JTable table ;
    JScrollPane scroll;

    public VisaoClient(){
        
        frame = new JFrame("Cadastra Cliente");
        frame.setSize(500, 580);
        frame.setLocationRelativeTo(null);
    
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setResizable(false);
        
        //Name insert
        lbName = new JLabel("Nome:");
        frame.add(lbName);

        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(180,20));

        frame.add(tfName);

        //Age insert
        lbAge = new JLabel("Idade:");
        frame.add(lbAge);

        tfAge = new JTextField();
        tfAge.setPreferredSize(new Dimension(30,20));

        frame.add(tfAge);

        //Cpf insert
        lbCpf = new JLabel("Cpf:");
        frame.add(lbCpf);

        tfCpf = new JTextField();
        tfCpf.setPreferredSize(new Dimension(150,20));

        frame.add(tfCpf);

        //Phone insert
        lbPhone = new JLabel("Telefone:");
        frame.add(lbPhone);

        tfPhone = new JTextField();
        tfPhone.setPreferredSize(new Dimension(150,20));

        frame.add(tfPhone);
  
       //Adress insert
        lbAdress = new JLabel("Endereço:");
        frame.add(lbAdress);

        tfAdress = new JTextField();
        tfAdress.setPreferredSize(new Dimension(200,20));

        frame.add(tfAdress);
        
        //Cria tabela com as colunas dos atributos dos clietes.
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Cpf");
        tableModel.addColumn("Telefone");

        table = new JTable(tableModel);
        table.setPreferredSize(new Dimension(500, 400));
        table.setLayout(new FlowLayout(FlowLayout.CENTER));
        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(1).setMaxWidth(150);
        table.getColumnModel().getColumn(2).setMaxWidth(150);

        scroll = new JScrollPane();
		scroll.setViewportView(table);
        
		frame.add(scroll);
        
        btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(500, 80));
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                inserir();
                // loadTable();
            }
        });

        //btnInserir.setPreferredSize(new Dimension(50, 10));

        btnPanel.add(btnInserir);

        btApagar = new JButton("Apagar");
		btApagar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// removePessoa();
				// carregarTabela();
			}			
		});

		btnPanel.add(btApagar);
        frame.add(btnPanel);
        frame.setVisible(true);
    }

    public void inserir(){

        Cliente cliente = new Cliente();

        cliente.setId(0);
        cliente.setName(tfName.getText());
        cliente.setCpf(Long.parseLong(tfCpf.getText()));
        cliente.setPhone(Long.parseLong(tfPhone.getText()));
        cliente.setAge(Integer.parseInt(tfAge.getText()));
        cliente.setAdress(tfAdress.getText());

        ControleCliente contCliente = new ControleCliente();
        contCliente.inserir(cliente);
    }

    public static void main(String[] args) {
      new VisaoClient();
    
    }
}