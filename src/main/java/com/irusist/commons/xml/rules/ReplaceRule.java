package com.irusist.commons.xml.rules;

import com.irusist.commons.xml.pojo.Message;
import org.apache.commons.digester3.Rule;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

/**
 * description
 *
 * @author zhulixin
 */
public class ReplaceRule extends Rule {

    @Override
    public void begin(String namespace, String name, Attributes attributes) throws Exception {
        Message message = (Message) getDigester().getRoot();
        String repl = attributes.getValue("search");
        String with = attributes.getValue("replace");
        String text = message.getText();

        String translated = StringUtils.replace(text, repl, with);
        message.setText(translated);
    }
}
