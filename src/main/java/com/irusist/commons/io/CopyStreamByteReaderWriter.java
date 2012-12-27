package com.irusist.commons.io;

import org.apache.commons.io.IOUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;

/**
 * IOUtils.copy(InputStream, Writer)    利用4k的缓存来复制
 * IOUtils.toString(InputStream)
 *
 * @author zhulixin
 */
public class CopyStreamByteReaderWriter {

    public static void main(String[] args) {
        try {
            // 文件不存在时会创建
            Writer writer = new FileWriter("test.dat");
            InputStream inputStream = CopyStreamByteReaderWriter.class.getResourceAsStream("/io/config/test.resource");
            IOUtils.copy(inputStream, writer);
            writer.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error copying data");
        }

        try {
            URL url = new URL("http://www.slashdot.org");
            InputStream inputStream = url.openStream();
            String contents = IOUtils.toString(inputStream);
            System.out.println("Slashot: " + contents);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
