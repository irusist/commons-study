package com.irusist.commons.net;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * FTPClient client = new FTPClient();
 * client.connect(hostname);
 * client.login(username, password);
 * client.retrieveFile(remoteFile, outputStream);可以获取ftp的remoteFile路径下的文件
 * 并写入到outputStream当中
 * client.listFiles(remoteDirectory);可以得到remoteDirectory目录下所有文件的一个FTPFile[]
 *
 * @author zhulixin
 */
public class WriteFtpClient {

    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        OutputStream outputStream = null;
        try {
            client.connect("rtfm.mit.edu");
//            client.connect("sunsite.unc.edu");
            client.login("anonymous", "");

            String remoteFile = "/pub/arpaprob.txt";
            outputStream = new FileOutputStream("arpaprob.txt");
            client.retrieveFile(remoteFile, outputStream);

            String remoteDirectory = "/pub/net";
            FTPFile[] remoteFiles = client.listFiles(remoteDirectory);
            System.out.println("Files in " + remoteDirectory);
            for (FTPFile file : remoteFiles) {
                String name = file.getName();
                long length = file.getSize();
                String readableLength = FileUtils.byteCountToDisplaySize(length);
                System.out.println(name + ":\t\t" + readableLength);
            }
        } catch (IOException e) {
            System.out.println("Error communicating with FTP server.");
        } finally {
            IOUtils.closeQuietly(outputStream);
            try {
                client.disconnect();
            } catch (IOException e) {
                System.out.println("Problem disconnecting from FTP Server");
            }
        }
    }
}
