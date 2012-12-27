package com.irusist.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * FileUtils.byteCountToDisplaySize(bytes)将文件的长度转化成下面的格式：
 * ...  bytes
 * ...  KB
 * ...  MB
 * ...  GB
 * ...  TB
 * ...  PB
 * ...  EB
 * 转化成的格式是整数是截取的，不是四舍五入的，如2.9 MB会输出2 MB
 *
 * @author zhulixin
 */
public class PrintReadableFileSize {

    public static void main(String[] args) {
            File file = new File("commons-study/src/main/java/com/irusist/commons/io/PrintReadableFileSize.java");
            // 如果文件不存在,file.length()返回0
            Long bytes = file.length();
            String display = FileUtils.byteCountToDisplaySize(bytes);
            System.out.println("File: test.dat");
            System.out.println(" bytes: " + bytes);
            System.out.println(" size: " + display);
    }
}
