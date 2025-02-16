package onchoysakul.badin.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ChangeListener;

public class MobileDeviceV10 extends MobileDeviceV9 implements ActionListener, ListSelectionListener, ChangeListener{

    
    public MobileDeviceV10(String title){
        super(title);
    }

    @Override
    public void addComponents(){
        super.addComponents();// Reuse components from the previous version
    }

    public void addListeners(){
        super.addListeners();
        options.addActionListener(this); // Listener for dropdown selection
        list.addListSelectionListener(this); // Listener for list selection
        slide.addChangeListener(this); // Listener for slider changes
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        if (srcObject == options) { 
            String selectedOS = (String) options.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected Operating System: " + selectedOS, "OS Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // Handles list selection events
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { // Prevent duplicate triggers
            java.util.List<String> selectedVendors = list.getSelectedValuesList(); // Get selected values correctly
            if (!selectedVendors.isEmpty()) {
                String vendors = String.join(", ", selectedVendors); // Convert list to string
                JOptionPane.showMessageDialog(this, "Device is available at: " + vendors, "Vendor Selection", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    // Handles slider change events
    @Override
    public void stateChanged(ChangeEvent e) {
        if (!slide.getValueIsAdjusting()) { // Prevents multiple popups while dragging
            int rating = slide.getValue();
            JOptionPane.showMessageDialog(this, "New Rating: " + rating, "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents();
        mdv10.addMenus();
        mdv10.addListeners();
        mdv10.setFrameFeatures();
    }
}
