package onchoysakul.badin.lab8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MobileDeviceV2 extends MobileDeviceV1{
    
    protected JLabel operatorLabel, featuresLabel ;
    protected JComboBox<String> options;
    protected JTextArea featuresArea;

    protected JScrollPane textwrap;

    protected JPanel extraPanel;


    public MobileDeviceV2(String title){
        super(title);
        //operator
        operatorLabel = new JLabel("Operating System:");
        options = new JComboBox(new String[]{"Android","iOS","Windows","and Others"});
        //set default to Android
        options.setSelectedIndex(0);
        //features
        featuresLabel = new JLabel("Features:");
        featuresArea = new JTextArea(3,25);
        //wrap text with JScrollPane
        textwrap = new JScrollPane();
        textwrap.setViewportView(featuresArea);
    
    }
    
    protected void addComponents(){
        super.addComponents();
        extraPanel = new JPanel(new GridLayout(2,2));
        extraPanel.add(operatorLabel);
        extraPanel.add(options);
        extraPanel.add(featuresLabel);
        extraPanel.add(textwrap);
        //add extra panel to main panel
        mainPanel.add(extraPanel,BorderLayout.CENTER);
        

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    
    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.addComponents();
        mdv2.setFrameFeatures();
    }
}
