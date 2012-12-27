package com.irusist.commons.io;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * IOUtils.closeQuietly(reader);相当于
 * try {
 *     if (reader != null) {
 *         reader.close();
 *     }
 * } catch(IOException e) {
 *     // ignore
 * }
 *
 *
 * @author zhulixin
 */
public class CloseStreamReaderWriter {

    public static void main(String[] args) {
        Reader reader = null;
        String result = "";
        try {
            File file = new File("test.dat");
            reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            result = IOUtils.toString(reader);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Unable to copy file test.dat to a string");
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }
}
