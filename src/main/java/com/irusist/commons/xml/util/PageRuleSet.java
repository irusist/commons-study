package com.irusist.commons.xml.util;

import com.irusist.commons.xml.pojo.Page;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.RuleSetBase;

/**
 * description
 *
 * @author zhulixin
 */
public class PageRuleSet extends RuleSetBase {

    public PageRuleSet() {
        super("http://discursive.com/page");
    }

    @Override
    public void addRuleInstances(Digester digester) {
        digester.addObjectCreate("*/page", Page.class);
        digester.addSetNext("*/page", "addPage");
        digester.addSetProperties("*/page");
        digester.addBeanPropertySetter("*/person/summary", "summary");
    }
}
