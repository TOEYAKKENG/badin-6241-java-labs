package onchoysakul.badin.lab8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MySimpleWindow extends JFrame {
    protected JButton resetButton;
    protected JButton submitButton;
    protected JPanel mainPanel;
    protected JPanel buttonPanel;

    public MySimpleWindow(String title){
        super(title);
    }
    
    protected void addComponents(){
        resetButton = new JButton("Cancel");
        submitButton = new JButton("OK");
        buttonPanel = new JPanel();
        mainPanel = new JPanel();
        
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel);
        
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
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}