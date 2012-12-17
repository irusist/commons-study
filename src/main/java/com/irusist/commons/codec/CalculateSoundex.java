package com.irusist.commons.codec;

import org.apache.commons.codec.language.Soundex;

/**
 * Soundex.soundex(string)返回string的前4个辅音的字符，第一个显示字母。
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午4:52
 */
public class CalculateSoundex {

    public static void main(String[] args) {
        Soundex soundex = new Soundex();
        String obrienSoundex = soundex.soundex("D'Brien");
        String obrianSoundex = soundex.soundex("O'Brian");
        String obryanSoundex = soundex.soundex("O'Bryan");

        System.out.println("O'Brien soundex: " + obrienSoundex);
        System.out.println("O'Brian soundex: " + obrianSoundex);
        System.out.println("O'Bryan soundex: " + obryanSoundex);
    }
}
