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

import modelo.Venda;
import persistencia.VendaPersist;
import controle.ControleVenda;

import modelo.Cliente;
import persistencia.ClientePersist;
import controle.ControleCliente;

public class VisaoVenda extends JFrame {
    
    private JFrame frame;
    private JLabel lbIdCliente, lbProdutos;
    private JTextField tflbIdCliente, tfProdutos;
    private JTable table;
    private DefaultTableModel tableModel;

    public VisaoVenda(){

        frame = new JFrame("Vendas");
        frame.setSize(500,580);
        frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
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
        tableModel.addColumn("produto");
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
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new VisaoVenda();
    }

}
