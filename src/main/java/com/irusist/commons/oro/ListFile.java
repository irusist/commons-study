package com.irusist.commons.oro;

import org.apache.oro.io.GlobFilenameFilter;
import org.apache.oro.io.Perl5FilenameFilter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * FilenameFilter xmlFilter = new GlobFilenameFilter("*.xml");
 * 用于过滤.xml文件
 * FilenameFilter regexFilter = new Perl5FilenameFilter("^dev.*.tld$");
 * 用于过滤dev开始，.tld结尾的文件
 *
 * @author zhulixin
 */
public class ListFile {

    public static void main(String[] args) {
        File dataDir = new File("dataDir");
        FilenameFilter xmlFilter = new GlobFilenameFilter("*.xml");
        File[] xmlFiles = dataDir.listFiles(xmlFilter);

        FilenameFilter regexFilter = new Perl5FilenameFilter("^dev.*.tld$");
        File[] tldFiles = dataDir.listFiles(regexFilter);
    }
}
