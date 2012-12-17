package com.irusist.commons.xml;

import com.irusist.commons.xml.pojo.Page;
import com.irusist.commons.xml.pojo.Pages;
import com.irusist.commons.xml.util.PageRuleSet;
import com.irusist.commons.xml.util.PersonRuleSet;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;

import java.io.InputStream;

/**
 * 多个命名空间用java代码表示
 * 如何用xml的形式表示？
 *
 * @author zhulixin
 */
public class NameSpaceAwareParse {

    public static void main(String[] args) throws Exception {
        Pages pages = new Pages();

        Digester digester = new Digester();
        // 设置命名空间
        digester.setNamespaceAware(true);

        // 添加2个RuleSet
        digester.addRuleSet(new PageRuleSet());
        digester.addRuleSet(new PersonRuleSet());

        digester.push(pages);
        InputStream input = NameSpaceAwareParse.class.getResourceAsStream("/xml/config/content.xml");
        digester.parse(input);

        // 获取数据
        Page page = pages.getPages().get(0);
        System.out.println(page.getType());
        System.out.println(page.getPersons().get(0).getFirstName() + ", "
            + page.getPersons().get(0).getLastName());
        System.out.println(page.getPersons().get(1).getFirstName() + ", "
            + page.getPersons().get(1).getLastName());

        System.out.println("===============================");
        /*Pages pages1 = new Pages();
        Digester digester1 = new Digester();

        DigesterLoader loader = DigesterLoader.newLoader(new FromXmlRulesModule() {
            @Override
            protected void loadRules() {
                loadXMLRules();
                this.
            }
        });*/

        /*loader.setNamespaceAware(true);

        digester1.setRuleNamespaceURI("http://discursive.com/page");
        URL pageRules = NameSpaceAwareParse.class.getResource("xml/config/page-rules.xml");
        digester1.addRuleSet(new FromxmlRuleSet);*/
    }
}
