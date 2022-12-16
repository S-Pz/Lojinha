package visao;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.*;

import modelo.Venda;
import modelo.Produto;

public class buscarVenda extends JFrame{

    ControleVenda cv = new ControleVenda();

    private DefaultTableModel tableModel;
	private JButton btnBuscarVenda;
    private JFrame frame; 
    private JTextField tflbIdVenda, tfIdCliente;
    private JLabel lbIdVenda, lbIdCliente;
    private JTable table;

    public buscarVenda(){
        frame = new JFrame("Busca Venda");
        
        frame.setSize(500, 580);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
     
        frame.setResizable(false);
    
        lbIdVenda = new JLabel("ID da Venda: ");
        tflbIdVenda= new JTextField();

        tflbIdVenda.setPreferredSize(new Dimension(30,30));

        frame.add(lbIdVenda);
        frame.add(tflbIdVenda);

        tfIdCliente = new JTextField();
        tfIdCliente.setPreferredSize(new Dimension(30,30));

        btnBuscarVenda = new JButton("Buscar Venda");
        btnBuscarVenda.setPreferredSize(new Dimension(150, 30));
        btnBuscarVenda.addActionListener( new ActionListener(){
            
            public void actionPerformed (ActionEvent arg0){
                tfIdCliente.setText(buscar(Integer.parseInt(tflbIdVenda.getText())));
            }
            
        });
        
		frame.add(btnBuscarVenda);
        lbIdCliente = new JLabel("ID Cliente");
        frame.add(lbIdCliente);
        frame.add(tfIdCliente);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Produtos");
   
        table = new JTable(tableModel);
        table.setPreferredSize(new Dimension(500, 400));
        table.setLayout(new FlowLayout(FlowLayout.RIGHT));
        table.getColumnModel().getColumn(0).setMaxWidth(500);
       
        JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);

        frame.add(scroll);
        frame.setVisible(true);
    }

    private String buscar(int ID){
        
        Produto p;
        Venda v = (Venda) cv.buscar(ID);
        tableModel.setNumRows(0);

        for(int i = 0; i < v.getProds().size(); i++) {
            p = v.getProds().get(i);

            tableModel.addRow(new Object[]{
                p.getName(),
            });

        } 

        return Integer.toString(v.getCli().getId());
    }

    public static void main(String[] args) {
        new buscarVenda();
    }
}
