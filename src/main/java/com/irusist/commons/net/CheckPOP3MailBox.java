package com.irusist.commons.net;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.IOException;
import java.io.Reader;

/**
 * description
 *
 * @author zhulixin
 */
public class CheckPOP3MailBox {

    public static void main(String[] args) {
        POP3Client client = new POP3Client();
        try {
            client.connect("pop3.163.com");
            client.login("username@host", "password");

            POP3MessageInfo[] messages = client.listMessages();
            for (POP3MessageInfo message : messages) {
                int messageNum = message.number;
                System.out.println("************* Message number: " + messageNum);
                Reader reader = client.retrieveMessage(messageNum);
                System.out.println("Message:\n" + IOUtils.toString(reader));
                IOUtils.closeQuietly(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.logout();
                client.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
