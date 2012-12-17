package com.irusist.commons.xml.rules;

import com.irusist.commons.xml.pojo.Message;
import org.apache.commons.digester3.Rule;
import org.apache.commons.lang3.StringUtils;

/**
 * description
 *
 * @author zhulixin
 */
public class LowerRule extends Rule {

    @Override
    public void body(String namespace, String name, String text) throws Exception {
        Message message = (Message) getDigester().getRoot();
        String lower = StringUtils.lowerCase(message.getText());
        message.setText(lower);
    }
}
