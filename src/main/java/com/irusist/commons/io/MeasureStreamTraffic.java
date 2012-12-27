package com.irusist.commons.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CountingInputStream;
import org.apache.commons.io.output.CountingOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * CountingInputStream input = new CountingInputStream(fis)
 * input.getCount()获取到输入的字节数
 * CountingOutputStream output = new CountingOutputStream(fos)
 * output.getCount()获取输出的字节数
 *
 * @author zhulixin
 */
public class MeasureStreamTraffic {

    public static void main(String[] args) {
        File test = new File("test.dat");
        CountingOutputStream countStream = null;

        try {
            FileOutputStream fos = new FileOutputStream(test);
            countStream = new CountingOutputStream(fos);
            countStream.write("Hello".getBytes());
        } catch (IOException e) {
            System.out.println("Error writing bytes to file.");
        } finally {
            IOUtils.closeQuietly(countStream);
        }

        if (countStream != null) {
            int bytesWritten = countStream.getCount();
            System.out.println("Wrote " + bytesWritten + " bytes to dest.dat");
        }

        CountingInputStream countingInputStream = null;
        try {
            FileInputStream fis = new FileInputStream(test);
            countingInputStream = new CountingInputStream(fis);
            String contents = IOUtils.toString(countingInputStream);
            System.out.println(contents);
        } catch (IOException e) {
            System.out.println("Error reading bytes from file");
        } finally {
            IOUtils.closeQuietly(countingInputStream);
        }

        if (countingInputStream != null) {
            int bytesRead = countingInputStream.getCount();
            System.out.println("Read " + bytesRead + " bytes from test.dat");
        }

    }
}



