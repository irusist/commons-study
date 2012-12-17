package com.irusist.commons.betwixt;

import com.irusist.commons.betwixt.pojo.Play;
import com.irusist.commons.betwixt.pojo.Character;
import org.apache.commons.betwixt.XMLIntrospector;
import org.apache.commons.betwixt.io.BeanWriter;
import org.apache.commons.betwixt.strategy.CapitalizeNameMapper;
import org.apache.commons.betwixt.strategy.HyphenatedNameMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * BeanWriter beanWriter = new BeanWriter();
 * beanWriter.enablePrettyPrint();
 * beanWriter.write(play);
 * 将对象生成xml的形式，
 * 创建一个play元素对应的Play对象的的Play.betwixt(即className.betwixt),
 * 创建一个character元素对应的Character对象的Character.betwixt(即className.betwixt),
 * 该文件要放在Play对象同一目录下，在文件中可以定义哪些属性作为元素的属性
 *
 * @author zhulixin
 */
public class CustomizeXMLGeneratedFromObject {

    public static void main(String[] args) throws Exception {
        CustomizeXMLGeneratedFromObject bean = new CustomizeXMLGeneratedFromObject();
        Play play = bean.generateObject();

        BeanWriter beanWriter = new BeanWriter();
        beanWriter.enablePrettyPrint();

        XMLIntrospector introspector = beanWriter.getXMLIntrospector();
        // 去掉characters元素
        introspector.getConfiguration().setWrapCollectionsInElement(false);
        // 用连字符连接
        introspector.getConfiguration().setAttributeNameMapper(new HyphenatedNameMapper());
        // 首字母大写
        introspector.getConfiguration().setElementNameMapper(new CapitalizeNameMapper());
        beanWriter.write(play);
    }

    protected Play generateObject() {
        Play play = new Play();
        play.setAuthor("William Shakespeare");
        play.setGenre("tragedy");
        play.setLanguage("english");
        play.setName("Hamlet");
        play.setSummary("Price of Denmark (Hamlet) freaks not, talks to\n" +
                "father's ghost, and finally dies in a duel");
        play.setYear("1603");
        List<Character> characters = new ArrayList<Character>();

        Character character1 = new Character();
        character1.setDescription("King of Denmark");
        character1.setName("Claudius");
        character1.setProtagonist(false);
        characters.add(character1);

        Character character2 = new Character();
        character2.setDescription("Son to the late, and nephew of the present king");
        character2.setName("Hamlet");
        character2.setProtagonist(true);
        characters.add(character2);

        Character character3 = new Character();
        character3.setDescription("friend to Hamlet");
        character3.setName("Horatio");
        character3.setProtagonist(false);
        characters.add(character3);

        play.setCharacters(characters);
        return play;
    }
}
