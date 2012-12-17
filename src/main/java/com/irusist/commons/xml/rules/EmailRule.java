package com.irusist.commons.xml.rules;

import com.irusist.commons.xml.pojo.Message;
import org.apache.commons.digester3.Rule;
import org.apache.commons.net.smtp.SMTPClient;
import org.xml.sax.Attributes;

/**
 * description
 *
 * @author zhulixin
 */
public class EmailRule extends Rule {

    private String to;

    private String from;

    @Override
    public void begin(String namespace, String name, Attributes attributes) throws Exception {
        to = attributes.getValue("to");
        from = attributes.getValue("from");
    }

    @Override
    public void end(String namespace, String name) throws Exception {
        Message message = (Message) getDigester().getRoot();
        SMTPClient client = new SMTPClient();
        client.connect("mail.360buy.com");
        client.sendSimpleMessage(from, to, message.getText());
    }
}
