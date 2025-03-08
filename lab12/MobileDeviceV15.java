package onchoysakul.badin.lab12;

import javax.swing.*;
import onchoysakul.badin.lab7.MobileDevice;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MobileDeviceV15 extends MobileDeviceV14  {
    protected JMenu formatMenu; 
    protected JRadioButtonMenuItem textMI,binaryMI;
    //set title
    public MobileDeviceV15(String title){
        super(title);
    }

    @Override
    public void addComponents(){
        super.addComponents();
        //add new menu
        formatMenu = new JMenu("Format");
        textMI = new JRadioButtonMenuItem("Text");
        binaryMI = new JRadioButtonMenuItem("Binary");
        //add to group
        ButtonGroup group = new ButtonGroup();
        group.add(textMI);
        group.add(binaryMI);
        //add to menu
        formatMenu.add(textMI);
        formatMenu.add(binaryMI);
        configMenu.add(formatMenu);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    @Override
    public void handleMenuSave(){
        //check if text is selected
        if(textMI.isSelected()){ 
            super.handleMenuSave();
        }
        //check if binary is selected
        else if(binaryMI.isSelected()){
            File file;
            JFileChooser fcs = new JFileChooser(); //create file chooser
            int selectedFile = fcs.showSaveDialog(this); //show dialog
            if(selectedFile == JFileChooser.APPROVE_OPTION){ //if file is selected
                    file = fcs.getSelectedFile(); //get file
                    try{
                        String filePath = file.getAbsolutePath(); //get file path
                        //write to file
                        FileOutputStream fos = new FileOutputStream(file); 
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        String textToWrite = displayDevice(); //get text to write
                        oos.writeObject(textToWrite);
                        JOptionPane.showMessageDialog(null, "Data is saved to " + filePath +" successfully!", "Save", JOptionPane.INFORMATION_MESSAGE); //show message
                        oos.close();
                    //read to file
                        FileInputStream fis = new FileInputStream(file);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        ois.close();
                    }catch(IOException e){
                        System.out.println("Error is " + e);
                        JOptionPane.showMessageDialog(null, "Error in saving to file : " + file.getName() , "Error", JOptionPane.ERROR_MESSAGE); //show error message
                    }
            }
        }
    }
    @Override
    public void handleMenuOpen(){
        //check if text is selected
        if(textMI.isSelected()){
            super.handleMenuOpen();
        }
        //check if binary is selected
        else if(binaryMI.isSelected()){
            File file;
            JFileChooser fcs = new JFileChooser();
            int selectedFile = fcs.showOpenDialog(this);
            if(selectedFile == JFileChooser.APPROVE_OPTION){
                file = fcs.getSelectedFile();
                String infoOfDevices = "";
                try{
                    String filePath = file.getAbsolutePath(); //get file path
                    JOptionPane.showMessageDialog(null, "Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE); //show message
                    //read file
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    String infoAdd = String.format("Read devices from the file %s are as follows:\n", filePath);
                    String readInfo = (String) ois.readObject(); //read object
                    infoAdd += readInfo; //add info of devices
                    JOptionPane.showMessageDialog(null, infoAdd, "Message", JOptionPane.INFORMATION_MESSAGE);
                    ois.close();
                }catch(IOException | ClassNotFoundException e){
                    System.err.println("Exception is " + e);
                    JOptionPane.showMessageDialog(null, "Error to read file: " + file.getName(), "Error", JOptionPane.ERROR_MESSAGE); //show error message
                }
            }
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
        mdv15.addComponents();
        mdv15.addMenus();
        mdv15.addListeners();
        mdv15.setFrameFeatures();
    }
}



