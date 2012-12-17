package com.irusist.commons.xml;

import com.irusist.commons.xml.pojo.Email;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.Substitutor;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.substitution.MultiVariableExpander;
import org.apache.commons.digester3.substitution.VariableSubstitutor;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 替换xml中的数据
 * 在digester.parse()之前
 * MultiVariableExpander expander = new MultiVariableExpander();
 * expander.addSource("$", vars);
 * Substitutor substitutor = new VariableSubstitutor(expander);
 * digester.setSubstitutor(substitutor);
 * InputStream input = VariableSubstitutionXMLParse.class.getResourceAsStream("/xml/config/email.xml");
 * digester.parse(input);
 *
 * @author zhulixin
 */
public class VariableSubstitutionXMLParse {

    public static void main(String[] args) throws Exception {

        // 根据xml文件生成digester对象
        DigesterLoader loader = DigesterLoader.newLoader(new FromXmlRulesModule() {
            @Override
            protected void loadRules() {
                loadXMLRules(VariableSubstitutionXMLParse.class.getResource("/xml/config/email-rules.xml"));
            }
        });
        Digester digester = loader.newDigester();
        // 将emails压入栈
        List<Email> emails = new ArrayList<Email>();
        digester.push(emails);

        // 定义要替换变量的值
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("email.to", "ldavid@bbo.com");
        vars.put("user.name", "Tim");
        vars.put("order.id", "1RR2E223WVS");
        vars.put("product.name", "Foundation");

        MultiVariableExpander expander = new MultiVariableExpander();
        expander.addSource("$", vars);

        Substitutor substitutor = new VariableSubstitutor(expander);
        digester.setSubstitutor(substitutor);

        InputStream input = VariableSubstitutionXMLParse.class.getResourceAsStream("/xml/config/email.xml");
        digester.parse(input);

        Email email = emails.get(0);
        System.out.println("Email Subject: " + email.getSubject());
        System.out.println("Email To: " + email.getTo());
    }
}
