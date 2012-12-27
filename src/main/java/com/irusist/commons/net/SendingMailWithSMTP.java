package com.irusist.commons.net;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

import java.io.Writer;

/**
 * 用SMTPClient来发送邮件
 *
 * @author zhulixin
 */
public class SendingMailWithSMTP {

    public static void main(String[] args) {
//        SMTPClient client = new SMTPClient();
//        try {
//            client.connect("mail.163.com");
//            client.sendSimpleMessage("zhuiqiu87521@163.com", "zhulixin@360buy.com", "Hello,test");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                client.disconnect();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

        SMTPClient client = new SMTPClient();

        try {
            client.connect("smtp.163.com");

            int response = client.getReplyCode();
            if (SMTPReply.isPositiveCompletion(response)) {
                client.login("smtp.163.com");
                client.setSender("zhuiqiu87521@163.com");
                client.addRecipient("zhulixin@360buy.com");

                Writer message = client.sendMessageData();
                message.write("Test222");
                message.close();

                boolean success = client.completePendingCommand();
                if (success) {
                    System.out.println("message sent");
                }
            } else {
                System.out.println("Error communicating with SMTP server");
            }
        } catch (Exception e) {
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
