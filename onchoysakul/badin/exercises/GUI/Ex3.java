package onchoysakul.badin.exercises.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ex3 extends JFrame{
    protected JPanel mainPanel,formPanel,buttonPanel;
    protected JLabel name;
    protected JTextField nameInput;
    protected JButton button1,button2,button3;

    public Ex3(String title){
        super(title);
    }


    protected void addComponents(){
        mainPanel = new JPanel();

        name = new JLabel("Name:");
        nameInput = new JTextField("Badin",20);
        
        
        buttonPanel = new JPanel();

        button1 = new JButton("Ice-cream");
        button2 = new JButton("Fried Chicken");
        button3 = new JButton("Hamburger");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);
        formPanel = new JPanel();
        formPanel.add(name);
        formPanel.add(nameInput);
        mainPanel.add(formPanel);

        
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
        Ex3 msw = new Ex3("673040624-1");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
