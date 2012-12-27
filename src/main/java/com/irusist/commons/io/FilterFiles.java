package com.irusist.commons.io;

import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * FilenameFilter fileFilter = new SuffixFileFilter(".xml");
 * 以.xml为后缀的文件过滤器
 * PrefixFileFilter         前缀过滤器
 * NameFileFilter           文件名过滤器
 * DirectoryFileFilter      必须是文件夹的过滤器
 * AndFileFilter
 * OrFileFilter
 * NotFileFilter            组合使用
 *
 * @author zhulixin
 */
public class FilterFiles {

    public static void main(String[] args) {
        File rootDir = new File("commons-study");
        FilenameFilter fileFilter = new SuffixFileFilter(".xml");
        String[] xmlFiles = rootDir.list(fileFilter);
        System.out.println("********** XML Files");
        System.out.println(ArrayUtils.toString(xmlFiles));
    }
}
