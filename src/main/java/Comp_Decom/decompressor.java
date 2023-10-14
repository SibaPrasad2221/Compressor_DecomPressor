package Comp_Decom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();

        //first read those compressed file before decompressing
        FileInputStream fis = new FileInputStream(file);

        //decompress it
        GZIPInputStream decompressor_ = new GZIPInputStream(fis);

        //write them back to a file
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\DecompressedFile");

        byte[] buffer = new byte[1024];
        int len;

        while((len=decompressor_.read(buffer))!= -1){
            fos.write(buffer, 0, len);
        }

        decompressor_.close();
        fos.close();
        fis.close();

    }

    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\sahoo\\OneDrive\\Desktop\\CompressedFile.gz");
        method(path);
    }
}
