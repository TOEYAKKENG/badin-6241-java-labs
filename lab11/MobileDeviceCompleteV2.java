package onchoysakul.badin.lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener{
    

    public MobileDeviceCompleteV2(String title) {
            super(title);
    }
    // Add action listeners to the text fields
    public void addListeners(){
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }
     /**
     * Handles action events triggered by pressing Enter in the text fields.
     * Displays a message dialog with the entered text.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object srcObject = e.getSource();
        if(srcObject == deviceNameField){
            JOptionPane.showMessageDialog(this, "You pressed Enter in Device Name field: " + e.getActionCommand(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(srcObject == brandField){
            JOptionPane.showMessageDialog(this, "Brand field says: " + e.getActionCommand(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(srcObject == priceField){
            JOptionPane.showMessageDialog(this, "Price entered: " + e.getActionCommand(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run(){
                createAndShowGUI();
            }
        }));
    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device CompleteV2");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }
    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
