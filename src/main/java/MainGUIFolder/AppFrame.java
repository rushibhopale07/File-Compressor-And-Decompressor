/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainGUIFolder;

import CompressorDecompressor.compression;
import CompressorDecompressor.decompression;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author rushi
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compress;
    JButton decompress;
    JLabel title;
    
    AppFrame(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.setLayout(null);
        
        this.setTitle("Compression and Decompression");
        title=new JLabel("Choose one to Compression and Decompression");
        title.setBounds(80,40,350,40);
        
        compress=new JButton("Select File to Compress");
        compress.addActionListener(this);
        compress.setBounds(20,100,200,30);
        
        decompress=new JButton("Select File to Decompress");
        decompress.addActionListener(this);
        decompress.setBounds(250,100,200,30);
        
        this.add(title);
        this.add(compress);
        this.add(decompress);
        
        this.setSize(500,200);
        //this.getContentPane().setBackground(Color.white);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compress){ 
                // check what the user choose it is compress then we perform actions
          
            JFileChooser filechooser=new JFileChooser(); // we make it to choose the file
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){ 
                    //if that file is valid then we perform some operation 
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());  
                    // we get address/path of that selected file
                System.out.println("we choose"+file);
                try{
                    compression.method(file); 
                }
                catch(Exception excp){ 
                            // if we get any exception in compression.method(file) then we get error message 
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }            
        }
        if(e.getSource()==decompress){ 
                // check what the user choose it is decompress then we perform actions
            
            JFileChooser filechooser=new JFileChooser(); // we make it to choose the file
             
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){ 
                    //if that file is valid then we perform some operation 
                File file = new File(filechooser.getSelectedFile().getAbsolutePath()); // we get address/path of that selected file
                System.out.println("we choose"+file);
                try{
                    decompression.method(file);
                    
                }
                catch(Exception excp){ 
                        // if we get any exception in compression.method(file) then we get error message 
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }
            
        }
    }
}
