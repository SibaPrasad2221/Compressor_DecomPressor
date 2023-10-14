package GUI;
//certain functionality we have to import to create GUI
//We are using Java Swing in this project to create interactive GUI

import Comp_Decom.compressor;
import Comp_Decom.decompressor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

//file input stream(fetching the data): this class contains input bytes from a file
//it can also read byte oriented data like image,data,audio,video file etc
//file output stream(writing the data): it is going to write data inside a file, and the data in the form of raw bytes

//GZIP output stream: this class is useful for writing compress data, if we want to write the compressed data
//GZIP input stream: helps to decompress the file that are compressed with GZIP compression algorithm

//workflow-- get the data using File Input Stream (Compressed bytes) --> GZIP output Stream --> GZIP input stream -->File Output Stream



public class AppFrame extends JFrame implements ActionListener {
    //JFrame is already created in Java i want that functionality to use in my project that's why extend JFrame
    //actionListener is implements in this class because keep track the button what action it's doing

    //first declare two button for compressing and decompressing
    JButton compressButton;
    JButton decompressButton;


    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounxzds(20, 100, 200, 30);
//        compressButton.setSize(100 , 30);
//        compressButton.setBackground(Color.GREEN);
        compressButton.setForeground(Color.black);
        compressButton.addActionListener(this); //this will help to get the source

        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(250, 100, 200, 30);
//        decompressButton.setBackground(Color.orange);
        decompressButton.setForeground(Color.black);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.white);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){ // it just overwritten action performed function to press the button
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);

                try{
                    compressor.method(file);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }

        if(e.getSource()==decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);

                try{
                    decompressor.method(file);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
