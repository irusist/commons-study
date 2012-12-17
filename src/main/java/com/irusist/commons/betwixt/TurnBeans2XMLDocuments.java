package com.irusist.commons.betwixt;

import com.irusist.commons.xml.pojo.Play;
import com.irusist.commons.xml.pojo.Character;
import org.apache.commons.betwixt.io.BeanWriter;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * BeanWriter beanWriter = new BeanWriter();
 * beanWriter.enablePrettyPrint();
 * beanWriter.write(play);
 * 将play对象转化为xml形式
 *
 * @author zhulixin
 */
public class TurnBeans2XMLDocuments {

    public static void main(String[] args) throws Exception {
        TurnBeans2XMLDocuments bean = new TurnBeans2XMLDocuments();
        Play play = bean.generateObject();

        BeanWriter beanWriter = new BeanWriter();
        beanWriter.enablePrettyPrint();
        beanWriter.write(play);

        System.out.println("============================");
        // 将xml内容写入文件
        Writer outputWriter = new FileWriter("test.dat");

        BeanWriter beanWriter1 = new BeanWriter(outputWriter);
        beanWriter1.setEndOfLine("\r\n");
        beanWriter1.setIndent("t");
        beanWriter1.enablePrettyPrint();
        beanWriter1.write(play);
        outputWriter.close();
        System.out.println("写入完成!");
        //System.out.println(beanWriter.toString());
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
