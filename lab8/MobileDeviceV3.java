package onchoysakul.badin.lab8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV3 extends MobileDeviceV2 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu,configMenu;
    protected JMenu sizeMenu,colorMenu,fontMenu;
    protected JMenuItem smallItem,mediumItem,largeItem,extraLargeItem;
    protected JMenuItem blackItem,redItem,greenItem,blueItem;
    protected JMenuItem font1Item,font2Item,font3Item;
    protected JMenuItem newMI,openMI,saveMI,exitMI;
    
    //set title
    public MobileDeviceV3(String title){
        super(title);
        menuBar = new JMenuBar();
        //file 
        fileMenu = new JMenu("File");
        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        saveMI = new JMenuItem("Save");
        exitMI = new JMenuItem("Exit");

        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.add(exitMI);
        //config
        configMenu = new JMenu("Config");
        sizeMenu = new JMenu("Size");
        colorMenu = new JMenu("Color");
        fontMenu = new JMenu("Font");
        //size menu
        smallItem = new JMenuItem("Small");
        mediumItem = new JMenuItem("Medium");
        largeItem = new JMenuItem("Large");
        extraLargeItem = new JMenuItem("Extra Large");
        //color menu
        blackItem = new JMenuItem("Black");
        redItem = new JMenuItem("Red");
        greenItem = new JMenuItem("Green");
        blueItem = new JMenuItem("Blue");
        //font menu
        font1Item = new JMenuItem("Font 1");
        font2Item = new JMenuItem("Font 2");
        font3Item = new JMenuItem("Font 3");
        //add to config menu
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);
        //add size menu
        sizeMenu.add(smallItem);
        sizeMenu.add(mediumItem);
        sizeMenu.add(largeItem);
        sizeMenu.add(extraLargeItem);
        //add color menu
        colorMenu.add(blackItem);
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);
        //add font menu
        fontMenu.add(font1Item);
        fontMenu.add(font2Item);
        fontMenu.add(font3Item);

    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    @Override
    public void addComponents(){
        super.addComponents();
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        //add menubar to frame
        setJMenuBar(menuBar);
    }
    
    public static void createAndShowGUI() {
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        mdv3.addComponents();
        mdv3.setFrameFeatures();
    }
}
