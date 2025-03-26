package onchoysakul.badin.lab10;
import onchoysakul.badin.lab9.MobileDeviceV7;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {
    //set title
    public MobileDeviceV8(String title){
        super(title);
    }
    @Override
    public void addComponents(){
        super.addComponents();
        
    }
    // Retrieves device information and formats it as a string
    public String getDeviceInfo(){
        String selectedTypeString = "";
        // Determine selected device type
        if (tabletRadioButton.isSelected()) {
            selectedTypeString += tabletRadioButton.getText();
        }
        else if (smartphoneRadioButton.isSelected()) {
            selectedTypeString += smartphoneRadioButton.getText();
        }

        else {selectedTypeString += null;}
        // Format and return the device details
        return String.format("Device Name: %s \nBrand: %s \nPrice: %s \nType: %s \nOperating System: %s \nFeatures:%sAvailable at: %s \nRating: %s",
        inputDeviceName.getText(),inputBrand.getText(),inputPrice.getText(),selectedTypeString,options.getSelectedItem(),featuresArea.getText(),list.getSelectedValue(),slide.getValue());

    }

    // Adds event listeners for buttons
    public void addListeners(){
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }
    // Handles button click events
    public void actionPerformed(ActionEvent e){
        Object srcObject = e.getSource();
        if (srcObject == okButton){
            // Display device details in a dialog box
            JOptionPane.showMessageDialog(null,getDeviceInfo(),"Device Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(srcObject == cancelButton){
            // Reset form fields to default values
            inputDeviceName.setText("");
            inputPrice.setText("");
            inputBrand.setText("");
            radioGroup.clearSelection();
            options.setSelectedItem(0);
            featuresArea.setText("");
            list.setSelectedValue(null, false);
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
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.addComponents();
        mdv8.addMenus();
        mdv8.addListeners();
        mdv8.setFrameFeatures();
    }
}
