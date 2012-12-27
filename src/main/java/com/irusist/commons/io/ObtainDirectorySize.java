package com.irusist.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * FileUtils.sizeOfDirectory(dir)会得到dir目录及子目录所有文件的大小，
 * 如果是空文件夹返回为0
 *
 * @author zhulixin
 */
public class ObtainDirectorySize {

    public static void main(String[] args) {
        File dir = new File("temp");
        System.out.println(FileUtils.sizeOfDirectory(dir));
    }
}
