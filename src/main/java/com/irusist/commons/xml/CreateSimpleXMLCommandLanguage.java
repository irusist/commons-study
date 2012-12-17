package com.irusist.commons.xml;

import com.irusist.commons.xml.pojo.Message;
import com.irusist.commons.xml.rules.EmailRule;
import com.irusist.commons.xml.rules.LowerRule;
import com.irusist.commons.xml.rules.ReplaceRule;
import com.irusist.commons.xml.rules.ReverseRule;
import org.apache.commons.digester3.Digester;

import java.io.InputStream;

/**
 * Rule接口的begin()方法用来访问元素的属性
 * body()方法用来访问元素的命名空间（namespace），本地名（local name），和本体（body text）
 * end()方法用来处理结束标签
 * finish()方法在end()被调用之后调用，用来清理数据，或者释放资源（网络或文件）
 *
 * @author zhulixin
 */
public class CreateSimpleXMLCommandLanguage {

    public static void main(String[] args) throws Exception {
        Message message = new Message();
        message.setText("Hello World!");

        System.out.println("Initial Message: " + message.getText());

        InputStream encrypt = CreateSimpleXMLCommandLanguage.class.getResourceAsStream("/xml/config/encrypt.xml");

        Digester digester = new Digester();
        digester.addRule("*/email", new EmailRule());
        digester.addRule("*/lower", new LowerRule());
        digester.addRule("*/reverse", new ReverseRule());
        digester.addRule("*/replace", new ReplaceRule());
        digester.push(message);

        digester.parse(encrypt);

        System.out.println("Resulting Message: " + message.getText());
    }
}
