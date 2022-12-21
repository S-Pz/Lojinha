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

import modelo.Cliente;
import controle.ControleCliente;

public class VisaoClient extends JFrame{

    private static final long serialVersionUID = 1L;

	ControleCliente cc = new ControleCliente();

    private JFrame frame; 
    JLabel lbName, lbAge, lbCpf, lbPhone, lbAdress;
    JTextField tfName, tfAge, tfCpf, tfPhone, tfAdress;
    DefaultTableModel tableModel;
    JPanel btnPanel;
    JButton btnInserir, btApagar, btnBuscar;
    JTable table ;
    JScrollPane scroll;

    public VisaoClient(){
        
    	frame = new JFrame("Cadastra Cliente");
        frame.setSize(500, 580);
        frame.setLocationRelativeTo(null);
    
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
        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Cpf");
        tableModel.addColumn("Telefone");

        table = new JTable(tableModel);
        table.setPreferredSize(new Dimension(500, 400));
        table.setLayout(new FlowLayout(FlowLayout.CENTER));
        table.getColumnModel().getColumn(0).setMinWidth(10);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(90);

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

        btApagar = new JButton("Apagar");
		btApagar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
                try{
                    String getMessage = JOptionPane.showInputDialog(frame, "Qual ID deseja remover?");
                    cc.remover(cc.buscar(Integer.parseInt(getMessage)));
                
                } catch(Exception e) {
                    frame.dispose();
                }
                
                carregarTabela();
			}	
			
		});
		
		btnPanel.add(btApagar);

        btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			    String getMessage = JOptionPane.showInputDialog(frame, "Qual ID ou cliente (nome) deseja buscar?");
			    
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

        frame.add(btnPanel);
        frame.setVisible(true);
    }

    public void inserir(){
        Cliente cliente = new Cliente();
        
        cliente.setId(cc.getPersist().getIds());
        cc.getPersist().setIds(cc.getPersist().getIds() + 1);
        cliente.setName(tfName.getText());
        cliente.setCpf(Long.parseLong(tfCpf.getText()));
        cliente.setPhone(Long.parseLong(tfPhone.getText()));
        cliente.setAge(Integer.parseInt(tfAge.getText()));
        cliente.setAdress(tfAdress.getText());

        cc.inserir(cliente);
    }

    private void carregarTabela(){
        Cliente c;

        tableModel.setNumRows(0);

        for(int i = 0; i < cc.getPersist().getClientes().size(); i++) {
            c = cc.getPersist().getClientes().get(i);
        
            tableModel.addRow(new Object[]{
                c.getId(),
                c.getName(),
                c.getCpf(),
                c.getPhone(),
    
            });
            
        }
        
    }

    private void carregarTabela(int ID){
        Cliente c;

        tableModel.setNumRows(0);

        for(int i = 0; i < cc.getPersist().getClientes().size(); i++) {
            c = cc.getPersist().getClientes().get(i);

            if(c.getId() == ID){
            	
                tableModel.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getCpf(),
                    c.getPhone(),

                });
                
            }
            
        }
        
    }

    private void carregarTabela(String name){
        Cliente c;
        tableModel.setNumRows(0);

        for(int i = 0; i < cc.getPersist().getClientes().size(); i++) {
            c = cc.getPersist().getClientes().get(i);

            if(c.getName().equals(name)){
            	
                tableModel.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getCpf(),
                    c.getPhone(),
                });
                
            }
            
        }
        
    }
    
}