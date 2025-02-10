package onchoysakul.badin.exercises.GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class Ex4 extends JFrame{
    protected JPanel mainPanel,namePanel,addressPanel,buttonPanel;
    protected JLabel name,address;
    protected JTextField nameInput;
    protected JTextArea addressInput;
    protected JScrollPane textwrap;
    protected JButton okButton,cancelButton;

    public Ex4(String title){
        super(title);
    }

    protected void initValue(){
        mainPanel = new JPanel();
        name = new JLabel("Name:");
        nameInput = new JTextField("Badin",20);
        
        address = new JLabel("Address:");
        addressInput = new JTextArea("Lorem Ipsum is simply dummy text of the printing andtypesetting",4,10);
        addressInput.setLineWrap(true); // Enables line wrapping
        addressInput.setWrapStyleWord(true); // Wraps at word boundaries
        textwrap = new JScrollPane(addressInput);
    }
    
    protected void addButtons(){
        buttonPanel = new JPanel();
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

    }

    protected void addComponents(){
        mainPanel = new JPanel(new BorderLayout());
        namePanel = new JPanel();
        namePanel.add(name);
        namePanel.add(nameInput);
        mainPanel.add(namePanel,BorderLayout.NORTH);

        addressPanel = new JPanel();
        addressPanel.add(address);
        addressPanel.add(textwrap);
        mainPanel.add(addressPanel,BorderLayout.CENTER);
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
        Ex4 msw = new Ex4("673040624-1");
        msw.initValue();
        msw.addComponents();
        msw.addButtons();
        msw.setFrameFeatures();
    }
}


