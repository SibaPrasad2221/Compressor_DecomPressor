package Comp_Decom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent(); //get the parent path like where/which path we use to compress there we should decompress

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\CompressedFile.gz");
        GZIPOutputStream make_it_compress = new GZIPOutputStream(fos); //help me writing compress data

        byte[] buffer = new byte[1024]; //byte array to read the data

        int len;
        while((len = fis.read(buffer) )!= -1){//it will read until reach the last character
            make_it_compress.write(buffer, 0, len);
        }
        make_it_compress.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\sahoo\\OneDrive\\Desktop\\File_dummy.txt");
        method(path);
    }
}
