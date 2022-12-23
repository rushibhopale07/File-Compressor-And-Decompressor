/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompressorDecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author rushi
 */
public class decompression {
    
    public static void method(File file) throws IOException
    {
        String path= file.getParent();  // we store the address of the given file
        FileInputStream fis= new FileInputStream(file);  //we make it in binary format
        GZIPInputStream gip= new GZIPInputStream(fis);  // we make it in their original format
        FileOutputStream fos= new FileOutputStream(path+"/originalFile"); //we make a new file and make it to original 
        // we choose .qz file to return it back don't choose any other it gives an exception
        byte[] temp= new byte[1024];
        int len;
        
        while((len=gip.read(temp))!=-1)
        {
            fos.write(temp, 0, len);  
        }
        gip.close(); fos.close(); fis.close();
         System.out.print("We get Back file in original format");
    }
   
}

