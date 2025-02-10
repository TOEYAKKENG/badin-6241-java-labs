package onchoysakul.badin.lab9;

import onchoysakul.badin.lab8.MobileDeviceV3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV4 extends MobileDeviceV3 {
    
    //set title
    public MobileDeviceV4(String title){
        super(title);
    }

    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
   
    public void addMenus(){
        //set Icon
        openMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./onchoysakul/badin/lab9/images/open_icon.png")));
        saveMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./onchoysakul/badin/lab9/images/save_icon.png")));
        exitMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./onchoysakul/badin/lab9/images/exit_icon.png")));
        //set font size
        smallItem.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumItem.setFont(new Font("Arial", Font.PLAIN, 14));
        largeItem.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLargeItem.setFont(new Font("Arial", Font.PLAIN, 22));
        //set fornt colour
        blackItem.setForeground(Color.BLACK);
        redItem.setForeground(Color.RED);
        greenItem.setForeground(Color.GREEN);
        blueItem.setForeground(Color.BLUE);
        //set font
        font1Item.setFont(new Font("Serif", Font.PLAIN, 14));
        font2Item.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3Item.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }

    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents();
        mdv4.setFrameFeatures();
        mdv4.addMenus();
    }
}

