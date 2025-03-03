package onchoysakul.badin.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MobileDeviceV9 extends MobileDeviceV8 implements ActionListener {
    protected JFileChooser fileChooser = new JFileChooser();    
    public MobileDeviceV9(String title){
        super(title);
    }

    @Override
    public void addComponents(){
        super.addComponents();
    }
    // Adds action listeners for menu items
    public void addListeners(){
        super.addListeners();
        // File menu actions
        newMI.addActionListener(this);
        openMI.addActionListener(this);
        saveMI.addActionListener(this);
        exitMI.addActionListener(this);
        // Font size menu actions
        smallItem.addActionListener(this);
        mediumItem.addActionListener(this);
        largeItem.addActionListener(this);
        extraLargeItem.addActionListener(this);
        // Font color menu actions
        blackItem.addActionListener(this);
        redItem.addActionListener(this);
        greenItem.addActionListener(this);
        blueItem.addActionListener(this);
        // Font style menu actions
        font1Item.addActionListener(this);
        font2Item.addActionListener(this);
        font3Item.addActionListener(this);
    }
    // Handles action events for menu interactions
    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        Object srcObject = e.getSource();

        if(srcObject == newMI){
            inputDeviceName.setText("");
            inputPrice.setText("");
            inputBrand.setText("");
            radioGroup.clearSelection();
            options.setSelectedItem(0);
            featuresArea.setText("");
            list.setSelectedValue(null, false);
        }
        // Opens a file and displays a message using JFileechooser
        else if(srcObject == openMI){
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    JOptionPane.showMessageDialog(this, "Opening: " + selectedFile.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        // Saves data to a file and displays a success message using JFilechooser
        else if (srcObject == saveMI){
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                    JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if (srcObject == exitMI){
            System.exit(0);
        }
        else if (srcObject == smallItem ){
            setFontSize(10);
        }
        else if (srcObject == mediumItem){
            setFontSize(14);
        }
        else if (srcObject == largeItem){
            setFontSize(18);
        }
        else if (srcObject == extraLargeItem){
            setFontSize(22);
        }
        else if (srcObject == blackItem){
            setFontColor(Color.BLACK);
        }
        else if (srcObject == redItem){
            setFontColor(Color.RED);
        }
        else if (srcObject == greenItem){
            setFontColor(Color.GREEN);
        }
        else if (srcObject == blueItem){
            setFontColor(Color.BLUE);
        }
        else if (srcObject == font1Item){
            setFontStyle("Serif");
        }
        else if (srcObject == font2Item){
            setFontStyle("SansSerif");
        }
        else if (srcObject == font3Item){
            setFontStyle("Monospaced");
        }
    }
     // Updates font size
    private void setFontSize(int size) {
        inputDeviceName.setFont(new Font("Arial", Font.PLAIN, size));
        inputBrand.setFont(new Font("Arial", Font.PLAIN, size));
        inputPrice.setFont(new Font("Arial", Font.PLAIN, size));
        featuresArea.setFont(new Font("Arial", Font.PLAIN, size));
    }
     // Updates font color
    private void setFontColor(Color color) {
        inputDeviceName.setForeground(color);
        inputBrand.setForeground(color);
        inputPrice.setForeground(color);
        featuresArea.setForeground(color);
    }
    // Updates font style while maintaining current size
    private void setFontStyle(String style) {
        int currentSize = inputDeviceName.getFont().getSize();
        inputDeviceName.setFont(new Font(style, Font.PLAIN, currentSize));
        inputBrand.setFont(new Font(style, Font.PLAIN, currentSize));
        inputPrice.setFont(new Font(style, Font.PLAIN, currentSize));
        featuresArea.setFont(new Font(style, Font.PLAIN, currentSize));
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.addComponents();
        mdv9.addMenus();
        mdv9.addListeners();
        mdv9.setFrameFeatures();
    }
}
