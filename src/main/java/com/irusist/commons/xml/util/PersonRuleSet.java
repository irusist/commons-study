package com.irusist.commons.xml.util;

import com.irusist.commons.xml.pojo.Person;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.RuleSetBase;

/**
 * description
 *
 * @author zhulixin
 */
public class PersonRuleSet extends RuleSetBase {

    public PersonRuleSet() {
        super("http://discursive.com/person");
    }

    @Override
    public void addRuleInstances(Digester digester) {
        digester.addObjectCreate("*/person", Person.class);
        digester.addSetNext("*/person", "addPerson");
        digester.addSetProperties("*/person");
        digester.addBeanPropertySetter("*/person/role", "role");
    }
}
