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

public class BuscarVenda extends JFrame{

    private static final long serialVersionUID = 1L;

	ControleVenda cv = new ControleVenda();

    private DefaultTableModel tableModel;
	private JButton btnBuscarVenda;
    private JFrame frame; 
    private JTextField tflbIdVenda, tfIdCliente;
    private JLabel lbIdVenda, lbIdCliente;
    private JTable table;

    public BuscarVenda(){

        frame = new JFrame("Busca Venda");
        
        frame.setSize(500, 580);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
     
        frame.setResizable(false);
        
        //Adição dos Labels
        lbIdVenda = new JLabel("ID da Venda: ");
        tflbIdVenda= new JTextField();

        tflbIdVenda.setPreferredSize(new Dimension(30,30));

        frame.add(lbIdVenda);
        frame.add(tflbIdVenda);

        //Adição dos campos de textos
        tfIdCliente = new JTextField();
        tfIdCliente.setPreferredSize(new Dimension(30,30));

        //Botão de buscar venda
        btnBuscarVenda = new JButton("Buscar Venda");
        btnBuscarVenda.setPreferredSize(new Dimension(150, 30));
        btnBuscarVenda.addActionListener( new ActionListener(){
            
            public void actionPerformed (ActionEvent arg0){
                
                //Seta no campo de texto o valor retornado pela função buscar
                tfIdCliente.setText(buscar(Integer.parseInt(tflbIdVenda.getText())));
            }
            
        });
        
		frame.add(btnBuscarVenda);

        lbIdCliente = new JLabel("ID Cliente");

        frame.add(lbIdCliente);
        frame.add(tfIdCliente);

        //Adição da tabela
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

    //Função que busca a venda realizada atráves do ID passado como parâmetro
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

    //O retorno da função é um inteiro que é o ID do cliente, que é setado para o usuário ver aparecendo no
    //campo de texto na tela interface de cliente.
}
