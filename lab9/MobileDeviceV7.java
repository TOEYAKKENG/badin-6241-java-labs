package onchoysakul.badin.lab9;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import javax.imageio.ImageIO;
import java.io.File;


public class MobileDeviceV7 extends MobileDeviceV6 {
    private ReadImage imagePanel;
    protected JPanel fullPanel;
    //set title
    public MobileDeviceV7(String title){
        super(title);
    }
    @Override
    public void addComponents(){
        super.addComponents();
        //prefill the form
        inputDeviceName.setText("Samsung Galaxy S25 Ultra");
        inputBrand.setText("Samsung");
        inputPrice.setText("46,900");

        //prefill the feature
        featuresArea.setText("""
            -200MP Camera
            -1TB Storage
            -Snapdragon Gen 4 Processor
            -5000mAh Battery
            -6.8-inch AMOLED Display
            -120Hz Refresh Rate
            -Fast Charging
        """);
        
        //preselect AIS
        list.setSelectedIndex(0);
        //set device rating at 9
        slide.setValue(9);

        fullPanel = new JPanel(new BorderLayout());
        fullPanel.add(doubleExtra,BorderLayout.NORTH);
        
        imagePanel = new ReadImage("./onchoysakul/badin/lab9/images/S25-ultra.jpg"); // Image path
        
        fullPanel.add(imagePanel,BorderLayout.SOUTH);
        mainPanel.add(fullPanel,BorderLayout.CENTER);
        
    

        
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
   

    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents();
        mdv7.setFrameFeatures();
        mdv7.addMenus();
    }
}
class ReadImage extends JPanel {
    protected BufferedImage img;
    protected String fileName;

    public ReadImage(String path) {
        fileName = path;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            img = null; // Ensure img is null if loading fails
        }
        this.setPreferredSize(new Dimension(400, 400)); // Set default panel size
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensure proper rendering

        if (img != null) {
            Graphics2D g2d = (Graphics2D) g;

            int imgWidth = img.getWidth() / 2;
            int imgHeight = img.getHeight() / 2;

            int x = (getWidth() - imgWidth) / 2; // Center horizontally
            int y = (getHeight() - imgHeight) / 2; // Center vertically

            g2d.drawImage(img, x, y, imgWidth, imgHeight, this);
        } else {
            g.drawString("Image not found", getWidth() / 2 - 40, getHeight() / 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400); // Set panel size to ensure enough space
    }
}
