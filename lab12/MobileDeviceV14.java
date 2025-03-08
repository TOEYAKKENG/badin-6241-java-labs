package onchoysakul.badin.lab12;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceV14 extends MobileDeviceV13  {
   private JFileChooser fcs;
    //set title
    public MobileDeviceV14(String title){
        super(title);
    }
    
    @Override
    public void addComponents(){
        super.addComponents();
    
    }
    //add listeners
    @Override
    public void addListeners(){
        super.addListeners();
        
        
    }
    //handle action event
    @Override
    public void actionPerformed(ActionEvent event) {
        Object srcObj = event.getSource();
        if (srcObj == openMI) {
            handleMenuOpen();
        } else if (srcObj == saveMI) {
            handleMenuSave();
        } else {
            super.actionPerformed(event);
        }
    }
    //handle save menu
    public void handleMenuSave(){
        //create file chooser
        fcs = new JFileChooser();
        File file; 
        int selectedFile = fcs.showSaveDialog(this); //show dialog
        if(selectedFile == JFileChooser.APPROVE_OPTION){ //if file is selected
            file = fcs.getSelectedFile();
            try{
                //write to file
                FileWriter fw = new FileWriter(file);
                String textToWrite = displayDevice(); //get text to write
                fw.write(textToWrite); //write to file
                fw.close(); //close file
            }
            catch(IOException e){
                System.out.println("Error is " + e);
                JOptionPane.showMessageDialog(null, "Error in writing to file : " + file.getName() , "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //handle open menu
    public void handleMenuOpen() {
        fcs = new JFileChooser();
        int selectedFile = fcs.showOpenDialog(null);
        File file;
        if(selectedFile == JFileChooser.APPROVE_OPTION){
            file = fcs.getSelectedFile();
            String infoOfDevices = ""; //store info of devices
            try{
                String filePath = file.getAbsolutePath(); //get file path
                JOptionPane.showMessageDialog(null, "Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE); //show message
                //read file
                Scanner fileReader = new Scanner(file); 
                while (fileReader.hasNextLine()) {
                    infoOfDevices += fileReader.nextLine() + "\n";
                }
                fileReader.close();
                String readInfo = String.format("Read devices from the file %s are as follows:\n", filePath);
                readInfo += infoOfDevices; //add info of devices
                JOptionPane.showMessageDialog(null, readInfo, "Message", JOptionPane.INFORMATION_MESSAGE);
            }catch(FileNotFoundException e){
                System.err.println("Exception is " + e);
                JOptionPane.showMessageDialog(null, "Error to read file: " + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");
        mdv14.addComponents();
        mdv14.addMenus();
        mdv14.addListeners();
        mdv14.setFrameFeatures();
    }
}

