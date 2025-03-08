package onchoysakul.badin.lab12;

import onchoysakul.badin.lab7.MobileDevice;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MobileDeviceV13 extends MobileDeviceV12  {
    protected JButton addButton, displayButton;
    private static final Color newbuttonBGColor = Color.WHITE;
    //create list
    private List<MobileDevice> devicesList = new ArrayList<>();
    //set title
    public MobileDeviceV13(String title){
        super(title);
    }
    //get name from text field
    public void addComponents(){
        super.addComponents();
        //add new 2 buttons
        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        //add buttons to panel
        buttoPanel.add(addButton);
        buttoPanel.add(displayButton);
        //add color to button
        addButton.setBackground(newbuttonBGColor);
        displayButton.setBackground(newbuttonBGColor);
    
    }
    //add listeners
    public void addListeners(){
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
        
    }
    //handle action event
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton();
        } else if (src == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }

   public void handleAddButton(){
        try {
            // Get the text from the input fields
            String name = inputDeviceName.getText().trim();
            String brand = inputBrand.getText().trim();
            String priceText = inputPrice.getText().trim().replace(",", ""); // Remove commas
            //convert price to double
            double price = Double.parseDouble(priceText); // Now it won't throw an error

            // Check which radio button is selected
            if (smartphonRadioButton.isSelected()) {
                devicesList.add(new SmartPhone(name, brand, price)); // Add a new SmartPhone object to the list
                JOptionPane.showMessageDialog(null, "SmartPhone " + name + " is added", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (tabletRadioButton.isSelected()) {
                devicesList.add(new Tablet(name, brand, price)); // Add a new Tablet object to the list
                JOptionPane.showMessageDialog(null, "Tablet " + name + " is added", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a device type!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   public void handleDisplayButton(){
      JOptionPane.showMessageDialog(null,displayDevice(), "Message", JOptionPane.INFORMATION_MESSAGE); // Display the devices
   }
   //display device
   protected String displayDevice(){
    StringBuilder result = new StringBuilder(); // Use StringBuilder to concatenate strings
    for (MobileDevice device : devicesList) {
        result.append(device.toString()).append("\n"); // Append the string representation of the device object
    }
    return result.toString(); // Return the concatenated string
}

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    

    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        mdv13.addComponents();
        mdv13.addMenus();
        mdv13.addListeners();
        mdv13.setFrameFeatures();
    }
}

class SmartPhone extends MobileDevice implements Serializable{
    //constructor
    public SmartPhone(String name, String brand, double price, String color) {
        super(name, brand, price, color);
    }
    //constructor
    public SmartPhone(String name, String brand, double price) {
        super(name, brand, price);
    }

    @Override
    public boolean isWatch() {
        return false;
    }
    //return string
    public String toString(){
        return "SmartPhone: " + name + " (" + brand + ") " + price + " Baht";
    }
}

class Tablet extends MobileDevice implements Serializable{
    //constructor
    public Tablet(String name, String brand, double price, String color) {
        super(name, brand, price, color);
    }
    //constructor
    public Tablet(String name, String brand, double price) {
        super(name, brand, price);
    }
    @Override
    public boolean isWatch() {
        return false;
    }
    //return string
    public String toString(){
        return "Tablet: " + name + " (" + brand + ") " + price+ " Baht";
    }
}