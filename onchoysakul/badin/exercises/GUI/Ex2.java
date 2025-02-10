package onchoysakul.badin.exercises.GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ex2 extends JFrame{
    protected JPanel mainPanel;
    protected JLabel name;

    public Ex2(String title){
        super(title);
    }

    protected void addComponents(){
        mainPanel = new JPanel();
        name = new JLabel("Badin:");
        JButton button1 = new JButton("Ice-cream");
        JButton button2 = new JButton("Fried Chicken");
        JButton button3 = new JButton("Hamburger");
        mainPanel.add(name);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);



    }
    protected void setFrameFeatures(){
        pack();
        this.add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    
    public static void createAndShowGUI(){
        Ex2 msw = new Ex2("673040624-1");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
