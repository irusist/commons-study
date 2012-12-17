package com.irusist.commons.collections.pojo;

/**
 * User: zhulixin
 * Date: 12-12-1
 * Time: 上午11:25
 */
public class PlayingCard {

    public static String JOKER_VALUE = null;

    public static String JOKER_SUIT = null;

    private String value;

    private String suit;

    public PlayingCard(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        String cardString = "JOKER";
        if(value != null && suit != null){
            cardString = value + suit;
        }

        return cardString;
    }
}
