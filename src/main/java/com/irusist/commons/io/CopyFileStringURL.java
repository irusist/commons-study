package com.irusist.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *  FileUtils.copyFile(srcFile, destFile);将文件srcFile拷贝到文件destFile
 *  FileUtils.writeStringToFile(file, string);将string写入到文件file中
 *  FIleUtils.copyURLToFile(url, file)将url的内容拷贝到文件file中
 *
 * @author zhulixin
 */
public class CopyFileStringURL {

    public static void main(String[] args) {
        try {
            File src = new File("test.dat");
            File dest = new File("test.dat.bak");
            FileUtils.copyFile(src, dest);

            String string = "Blah blah blah";
            File dat = new File("test.tmp");
            FileUtils.writeStringToFile(dat, string);

            URL url = new URL("http://www.google.com.hk/");
            File html = new File("google.html");
            FileUtils.copyURLToFile(url, html);
        } catch (IOException e) {
            System.out.println("Problem copying file.");
        }
    }
}
