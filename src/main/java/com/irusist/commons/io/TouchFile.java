package com.irusist.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * FileUtils.touch(testFile):
 * 如果testFile不存在，则创建文件，如果存在则更新文件的上次修改时间
 *
 * @author zhulixin
 */
public class TouchFile {

    public static void main(String[] args) {
        try {
            File testFile = new File("testFile.txt");
            FileUtils.touch(testFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
