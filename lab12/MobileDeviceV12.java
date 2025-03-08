package onchoysakul.badin.lab12;
import onchoysakul.badin.lab10.MobileDeviceV11;
import javax.swing.*;
import java.awt.event.*;

public class MobileDeviceV12 extends MobileDeviceV11  {
    //set title
    public MobileDeviceV12(String title){
        super(title);
    }
    //get name from text field
    public void addComponents(){
        super.addComponents();
        inputDeviceName.setName( "Device Name");
        inputBrand.setName("Brand");
        inputPrice.setName("Price");
    }
    //add listeners
    public void addListeners(){
        super.addListeners();
        inputDeviceName.addActionListener(this);
        inputBrand.addActionListener(this);
        inputPrice.addActionListener(this);
    }
    //handle action event
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        //check which text field is changed
        if (srcObject == inputDeviceName) {
            handleNormalTextField(inputDeviceName, inputBrand);
        } else if (srcObject == inputBrand) {
            handleNormalTextField(inputBrand, inputPrice);
        } else if (srcObject == inputPrice) {
            handlePosNumTextField(inputPrice, smartphonRadioButton);
        }
   }
    //handle text field
    public void handleNormalTextField(JTextField tf,JComponent nextComponent ){
        String text = tf.getText();
        if (text.isEmpty()) { // Check if the text field is empty
            JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();// Set focus back to the text field
            nextComponent.setEnabled(false);// Disable the next component
        } else {
            JOptionPane.showMessageDialog(null, tf.getName() +" is changed to "+ text , "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true);
        }
    }
    public void handlePosNumTextField(JTextField tf, JComponent nextComponent){
        String text = tf.getText();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            try {
                double num = Double.parseDouble(text);// Convert the text to a number
                if (num <= 0) {// Check if the number is positive
                    JOptionPane.showMessageDialog(null, "Price must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, tf.getName() +" is changed to "+ num , "Message", JOptionPane.INFORMATION_MESSAGE);
                    nextComponent.setEnabled(true);
                }
            } catch (NumberFormatException ex) {//catch invalid
                JOptionPane.showMessageDialog(null, "Please enter a valid number in Price", "Message", JOptionPane.INFORMATION_MESSAGE);
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
   

    public static void createAndShowGUI() {
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");
        mdv12.addComponents();
        mdv12.addMenus();
        mdv12.addListeners();
        mdv12.setFrameFeatures();
    }
}

