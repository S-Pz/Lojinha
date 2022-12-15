package visao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Remover extends JFrame{
    
    private JFrame frame; 

    public Remover(){

        frame = new JFrame();
        
        String getMessage = JOptionPane.showInputDialog(frame, "Qual id deseja remover");
        
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Remover();
    }
}