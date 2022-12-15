package visao;

import visao.VisaoClient;
import visao.VisaoProduto;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuInicial extends JFrame{

    String res = new String();
    VisaoProduto veioDoProduct;

    private JButton btnCliente, btnProduto, btnFronecedor, btnVenda ;
    private JFrame frame; 
    
    public MenuInicial(){

        frame = new JFrame("Menu Inicial");
        
        frame.setSize(400, 305);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setResizable(false);
        
        // JPanel panel = new JPanel();

        // panel.setPreferredSize(new Dimension(500, 500));
        // panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //frame.add(panel);

        btnCliente = new JButton("Cliente");
        btnCliente.setPreferredSize(new Dimension(350, 60));
        btnCliente.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0){

                new VisaoClient();       
            }
        });

        frame.add(btnCliente);
   
        btnProduto = new JButton("Produto");
        btnProduto.setPreferredSize(new Dimension(350, 60));
		btnProduto.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent arg0){

                System.out.println(new VisaoProduto().adicionarProduto());
                
			}			
		});

        frame.add(btnProduto);

        btnFronecedor = new JButton("Fornecedor");
        btnFronecedor.setPreferredSize(new Dimension(350, 60));
        btnFronecedor.addActionListener( new ActionListener(){
            public void actionPerformed (ActionEvent arg0){

            }
        });
		frame.add(btnFronecedor);

        btnVenda = new JButton("Venda");
        btnVenda.setPreferredSize(new Dimension(350, 60));
        btnVenda.addActionListener( new ActionListener(){

            public void actionPerformed (ActionEvent arg0){

            }
        });
    
        frame.add(btnVenda);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MenuInicial();

    }
}

