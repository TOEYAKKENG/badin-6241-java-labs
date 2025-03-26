package onchoysakul.badin.lab9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class MobileDeviceV5 extends MobileDeviceV4 {
    protected JLabel avalableLabel,rateLabel;
    protected JSlider slide;
    protected JScrollPane listWrap;
    protected JList<String> list;
    protected JPanel doubleExtra;
    //set title
    public MobileDeviceV5(String title){
        super(title);   
        slide = new JSlider();

    }
    @Override
    public void addComponents(){
        super.addComponents();
        
        
        //vendor list
        
        avalableLabel = new JLabel("The device is avalable at:");
        String vendors[] = {"AIS","True","DTAC","Shopee"};
        list = new JList<>(vendors); 
        list.setSelectedIndex(0);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        listWrap = new JScrollPane(list);

        //rate 
        rateLabel = new JLabel("Rate the device (0-10):");
        slide = new JSlider(0,10,5);
        slide.setPreferredSize(new Dimension(300, 50));
        
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setSnapToTicks(true);

        slide.setMajorTickSpacing(1);
        //override extrapanel
        extraPanel.setLayout(new GridLayout(4,2));
        doubleExtra = new JPanel(new BorderLayout());
        doubleExtra.add(extraPanel,BorderLayout.NORTH);
        doubleExtra.add(rateLabel,BorderLayout.CENTER);
        doubleExtra.add(slide,BorderLayout.SOUTH);

        extraPanel.add(avalableLabel);
        extraPanel.add(listWrap);
        mainPanel.add(doubleExtra,BorderLayout.CENTER);
        
        
        
        
        
    }

    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    
    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.setFrameFeatures();
        //mdv5.setIcon();
        mdv5.addMenus();
    }
}

