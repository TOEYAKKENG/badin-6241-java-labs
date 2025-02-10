package onchoysakul.badin.lab9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV6 extends MobileDeviceV5 {
    private static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    private static final Color labelColor = Color.decode("#000080"); // dark blue
    
    private static final Font inputFont = new Font("Arial",Font.ITALIC,14);
    private static final Color inputFGColor = Color.DARK_GRAY;
    private static final Color inputBGColor = Color.LIGHT_GRAY;
    
    private static final Color featureBGColor = new Color(255,255,224);//light yellow
    private static final Font vendorFont = new Font("Arial",Font.BOLD,14);
    private static final Color vendorFGColor = Color.decode("#006400"); // dark green
    private static final Color vendorBGColor = Color.LIGHT_GRAY;
    private static final Color vendorSelectBG = Color.YELLOW;
    private static final Color vendorSelectFG = Color.BLACK;


    private static final Color buttonBGColor = Color.WHITE;
    
    //set title
    public MobileDeviceV6(String title){
        super(title);
    }

    @Override
    public void addComponents(){
        super.addComponents();
        //label
        //set font
        deviceName.setFont(labelFont);
        brand.setFont(labelFont);
        price.setFont(labelFont);
        type.setFont(labelFont);
        operatorLabel.setFont(labelFont);
        featuresLabel.setFont(labelFont);
        avalableLabel.setFont(labelFont);
        rateLabel.setFont(labelFont); 
        //set color
        deviceName.setForeground(labelColor);
        brand.setForeground(labelColor);
        price.setForeground(labelColor);
        type.setForeground(labelColor);
        operatorLabel.setForeground(labelColor);
        featuresLabel.setForeground(labelColor);
        avalableLabel.setForeground(labelColor);
        rateLabel.setForeground(labelColor);
        
        //text fields and text area
        inputDeviceName.setBackground(inputBGColor);
        inputBrand.setBackground(inputBGColor);
        inputPrice.setBackground(inputBGColor);
        inputDeviceName.setForeground(inputFGColor);
        inputBrand.setForeground(inputFGColor);
        inputPrice.setForeground(inputFGColor);
        inputDeviceName.setFont(inputFont);
        inputBrand.setFont(inputFont);
        inputPrice.setFont(inputFont);
        //feature area
        featuresArea.setBackground(featureBGColor);


        //vendor list appearance
        list.setFont(vendorFont);
        list.setBackground(vendorBGColor);
        list.setForeground(vendorFGColor);
        list.setSelectionBackground(vendorSelectBG);
        list.setSelectionForeground(vendorSelectFG);


        //button customize
        okButton.setForeground(Color.GREEN);
        cancelButton.setForeground(Color.RED);
        okButton.setBackground(buttonBGColor);
        cancelButton.setBackground(buttonBGColor);




        
    }

    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        MobileDeviceV4 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.addComponents();
        mdv6.setFrameFeatures();
        mdv6.addMenus();
    }
}

