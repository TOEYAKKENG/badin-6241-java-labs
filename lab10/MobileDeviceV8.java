package onchoysakul.badin.lab10;
import onchoysakul.badin.lab9.MobileDeviceV7;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import javax.imageio.ImageIO;
import java.io.File;


public class MobileDeviceV8 extends MobileDeviceV7 {
    //set title
    public MobileDeviceV8(String title){
        super(title);
    }
    @Override
    public void addComponents(){
        super.addComponents();
        
    }
    public String getDeviceInfo(){
        String selectedTypeString = "";

        ///for (Enumeration<typeBtGrp.getClass()> button : typeBtGrp.getElements()) {

        if (tabletRadioButton.isSelected()) {
            selectedTypeString += tabletRadioButton.getText();
        }
        else if (smartphonRadioButton.isSelected()) {
            selectedTypeString += smartphonRadioButton.getText();
        }

        else {selectedTypeString += null;}
        return String.format("Device Name: %s \nBrand: %s \nPrice: %s Type: %s \nOperating System %s \nFeatures:%s \nAvailable at: %s \nRating: %s",
        inputDeviceName.getText(),inputBrand.getText(),inputPrice.getText(),selectedTypeString,options.getSelectedItem(),featuresArea.getText(),list.getSelectedValue(),slide.getValue());

    }
    public void addListeners(){
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,getDeviceInfo(),"Device Information",JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputDeviceName.setText("");
                inputPrice.setText("");
                inputBrand.setText("");
                radioGroup.clearSelection();
                options.setSelectedItem(0);
                featuresArea.setText("");
                list.setSelectedValue(null, false);
            }
        });
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
   

    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.addComponents();
        mdv8.addMenus();
        mdv8.addListeners();
        mdv8.setFrameFeatures();
    }
}
