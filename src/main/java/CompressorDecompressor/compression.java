/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompressorDecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author rushi
 */
public class compression {
    public static void method(File file) throws IOException
    {
        String path1=file.getParent();
        
            // we store the address of the given file
        FileInputStream fis= new FileInputStream(file); // we make it in binary format
        FileOutputStream fos= new FileOutputStream(path1+"/compressed.qz"); // make a new file and return it in that path with name compressed
        GZIPOutputStream gos= new GZIPOutputStream(fos); //pass that compressed file to perform some operation on it
        
        byte[] temp= new byte[1024];
        int len;
        
        while((len=fis.read(temp))!=-1)
        {
           gos.write(temp, 0, len); 
        }
        gos.close(); fos.close(); fis.close();
        System.out.print("Compressed file has been created");
    }
}
