package onchoysakul.badin.lab11;

import javax.management.ObjectName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Users can select a custom text color from the menu.

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 implements ActionListener{
    protected JColorChooser colorChooser; // Color chooser for selecting text color
    protected JMenuItem custom; // Menu item for custom color selectio
    
    public MobileDeviceCompleteV4(String title) {
        super(title);
        // Create menu components
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        custom = new JMenuItem("Custom");
        // Add menus to the menu bar
        addMenus();
        menuBar.add(configMenu);
        configMenu.add(colorMenu);
        colorMenu.add(custom);
    }
    
    public void addListeners(){
        custom.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object srcObject = e.getSource();
        if(srcObject == custom){
            // Open a color chooser dialog and allow the user to select a color
            Color selectedColor = JColorChooser.showDialog(this, "Choose Text Color", Color.BLACK);
            if (selectedColor != null) {
                // Perform additional actions with selectedColor if needed
                System.out.println("Selected color: " + selectedColor);
            }
            // Change the text color of input fields
            deviceNameField.setForeground(selectedColor);
            brandField.setForeground(selectedColor);
            priceField.setForeground(selectedColor);
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
        MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device CompleteV4");
        window.addComponents();
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
    