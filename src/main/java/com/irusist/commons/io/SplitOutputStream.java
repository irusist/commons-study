package com.irusist.commons.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream output = new TeeOutputStream(fos1, fos2);
 * output.write(string.getBytes())
 * 将string写入fos1和fos2，里面的内容一样
 * 对output.close()同时也会对fos1.close()和fos2.close()
 *
 * @author zhulixin
 */
public class SplitOutputStream {

    public static void main(String[] args) {
        File test1 = new File("split1.txt");
        File test2 = new File("split2.txt");
        OutputStream output = null;
        try {
            FileOutputStream fos1 = new FileOutputStream(test1);
            FileOutputStream fos2 = new FileOutputStream(test2);
            output = new TeeOutputStream(fos1, fos2);
            output.write("One Two Three, Test".getBytes());
            output.close();
        } catch (IOException e) {
            System.out.println("Error writing to split output stream");
        } finally {
            IOUtils.closeQuietly(output);
        }
    }
}
