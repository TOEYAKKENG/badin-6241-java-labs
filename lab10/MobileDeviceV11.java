package onchoysakul.badin.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MobileDeviceV11 extends MobileDeviceV10 {

    
    public MobileDeviceV11(String title){
        super(title);
    }

    @Override
    public void addComponents(){
        super.addComponents();// Reuse components from the previous version
    }
    public void addMenus(){
        super.addMenus();
        // Set Mnemonic Keys (Alt + key)
        newMI.setMnemonic(KeyEvent.VK_N);  // Alt + N
        openMI.setMnemonic(KeyEvent.VK_O); // Alt + O
        saveMI.setMnemonic(KeyEvent.VK_S); // Alt + S
        exitMI.setMnemonic(KeyEvent.VK_X); // Alt + X
        
        // Set Accelerator Keys (Ctrl+N / Cmd+N)
        int shortcutKey = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(); // Detects Ctrl (Windows/Linux) or Cmd (Mac)
            
        newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, shortcutKey));
        openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, shortcutKey));
        saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, shortcutKey));
        exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, shortcutKey));
    }
    public void addListeners(){
        super.addListeners();
        smartphoneRadioButton.addActionListener(this); // Listener for radio button selection
        tabletRadioButton.addActionListener(this); // Listener for radio button selection
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        if (srcObject == smartphoneRadioButton) { 
            JOptionPane.showMessageDialog(this, "Smartphone is selected" , "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(srcObject == tabletRadioButton){
            JOptionPane.showMessageDialog(this, "Tablet is selected", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
  
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.addComponents();
        mdv11.addMenus();
        mdv11.addListeners();
        mdv11.setFrameFeatures();
    }
}
