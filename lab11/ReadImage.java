package onchoysakul.badin.lab11;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;


public class ReadImage extends JPanel {
    BufferedImage img;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        int imageWidth = img.getWidth(this);
        int imageHeight = img.getHeight(this);
    
        // Calculate scaling factor to fit image
        double widthScale = (double) panelWidth / imageWidth;
        double heightScale = (double) panelHeight / imageHeight;
        double scale = Math.min(widthScale, heightScale);
    
        // Calculate new width and height
        int newWidth = (int) (imageWidth * scale);
        int newHeight = (int) (imageHeight * scale);
    
        // Calculate top-left corner position for centering
        int x = (panelWidth - newWidth) / 2;
        int y = (panelHeight - newHeight) / 2;
    
        // Draw the scaled image centered
        g.drawImage(img, x, y, newWidth, newHeight, this);
    }
    

    public ReadImage() {
        try {
            img = ImageIO.read(getClass().getResource("./onchoysakul/badin/lab9/images/S25-ultra.jpg"));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
    }

    public ReadImage(String fileName) {
        String name = "./images/" + fileName;
        try {
            img = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
    }
}