package com.irusist.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * FileUtils.deleteDirectory(dir);用于删除dir目录及他的子目录
 * FileUtils.cleanDirectory(dir);勇于删除dir的子目录，但是dir目录自身不会被删除
 *
 * @author zhulixin
 */
public class DeleteDirectoryRecursively {

    public static void main(String[] args) {
        try {
            File dir = new File("temp");
            FileUtils.deleteDirectory(dir);
            // FileUtils.cleanDirectory(dir);
        } catch (IOException e) {
            System.out.println("Error deleting directory.");
        }
    }
}
