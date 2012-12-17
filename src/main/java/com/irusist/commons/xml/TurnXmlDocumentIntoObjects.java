package com.irusist.commons.xml;

import com.irusist.commons.xml.pojo.Character;
import com.irusist.commons.xml.pojo.Play;
import org.apache.commons.digester3.*;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zhulixin
 */
public class TurnXmlDocumentIntoObjects {
    public static void main(String[] args) throws Exception {
        List plays = new ArrayList();

        DigesterLoader loader = DigesterLoader.newLoader(new FromXmlRulesModule() {
            @Override
            protected void loadRules() {
                loadXMLRules(TurnXmlDocumentIntoObjects.class.getResource("/xml/config/play-rules.xml"));
            }
        });

        Digester digester = loader.newDigester();
        digester.push(plays);

        InputStream input = TurnXmlDocumentIntoObjects.class.getResourceAsStream("/xml/config/play.xml");
        Object root = digester.parse(input);
        Play hamlet = (Play) plays.get(0);
        List<Character> characters = (List<Character>) hamlet.getCharacters();
        for(Character character : characters) {
            System.out.println(character.getName() + ",description: " + character.getDescription());
        }

        Digester digester1 = new Digester();
        Rules rules = digester1.getRules();
        rules.add("plays/play", new ObjectCreateRule("com.irusist.commons.xml.pojo.Play"));
        rules.add("plays/play", new SetNextRule("add", "java.lang.Object"));
        rules.add("plays/play", new SetPropertiesRule());
        rules.add("plays/play/name", new BeanPropertySetterRule("name"));
        rules.add("plays/play/summary", new BeanPropertySetterRule("summary"));
        rules.add("plays/play/author", new BeanPropertySetterRule("author"));

        rules.add("plays/play/characters/character", new ObjectCreateRule("com.irusist.commons.xml.pojo.Character"));
        rules.add("plays/play/characters/character", new SetNextRule("addCharacter", "com.irusist.commons.xml.pojo.Character"));
        rules.add("plays/play/characters/character", new SetPropertiesRule());
        rules.add("plays/play/characters/character/name", new BeanPropertySetterRule("name"));
        rules.add("plays/play/characters/character/descr", new BeanPropertySetterRule("description"));

    }
}
