package onchoysakul.badin.lab8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV1 extends MySimpleWindow {
 
    protected JButton okButton, cancelButton;
    protected JPanel buttoPanel;

    protected JLabel deviceName, brand, price, type;
    protected JTextField inputDeviceName, inputBrand, inputPrice;

    protected JRadioButton smartphonRadioButton, tabletRadioButton;
    protected ButtonGroup radioGroup;

    protected JPanel formPanel;
    protected JPanel typePanel;
    
    MobileDeviceV1(String title) {
        //set title
        super(title);
        //button
        cancelButton = new JButton("Cancle");
        okButton = new JButton("OK");
        buttoPanel = new JPanel();
        buttoPanel.add(cancelButton);
        buttoPanel.add(okButton);
        //add button to main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttoPanel,BorderLayout.SOUTH);
        
        //input labels
        deviceName = new JLabel("Device Name:");
        brand = new JLabel("Brand:");
        price = new JLabel("Price:");
        type = new JLabel("Type:");
        //input fields
        inputDeviceName = new JTextField(15);
        inputPrice = new JTextField(15);
        inputBrand = new JTextField(15);
        //radio buttons
        smartphonRadioButton = new JRadioButton("Smartphon",true);
        tabletRadioButton = new JRadioButton("Tablet");
        radioGroup = new ButtonGroup();
    }

    @Override
    protected void addComponents() {
        //form panel
        formPanel = new JPanel(new GridLayout(4,2));
        typePanel = new JPanel();
    
        radioGroup.add(smartphonRadioButton);
        radioGroup.add(tabletRadioButton);
        //add components to form panel
        formPanel.add(deviceName);
        formPanel.add(inputDeviceName);
        formPanel.add(brand);
        formPanel.add(inputBrand);
        formPanel.add(price);
        formPanel.add(inputPrice);
        formPanel.add(type);

        typePanel.add(smartphonRadioButton);
        typePanel.add(tabletRadioButton);

        formPanel.add(typePanel);
        //add form panel to main panel
        mainPanel.add(formPanel,BorderLayout.NORTH);

    }



    //@Override
    ///remember bro static method can not be overrided super static methods are hidden but can be accessed using compound string and can be rewrited on subclass and be given presendence
    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        mdv1.addComponents();
        mdv1.setFrameFeatures();
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
