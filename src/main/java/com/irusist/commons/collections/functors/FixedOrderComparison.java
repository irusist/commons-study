package com.irusist.commons.collections.functors;

import com.irusist.commons.collections.pojo.Athlete;
import com.irusist.commons.collections.pojo.PlayingCard;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.apache.commons.collections.comparators.NullComparator;

import java.util.*;

/**
 *  Comparator medalComparator = new FixedOrderComparator(medalOrder);
 *  Comparator athleteComparator = new BeanComparator("medal", medalComparator);
 *  int compare = athleteComparator.compare(athlete1, athlete2);
 *  medalOrder是一个数组，最后一句会将athlete1和athlete2这2个对象的medal的属性根据medalOrder数组的
 *  顺序进行排序，其中这2个对象的属性的值必须在medalOrder的值里面，否则会有异常。
 * User: zhulixin
 * Date: 12-12-1
 * Time: 上午10:59
 */
public class FixedOrderComparison {

    private String[] suitOrder = {"S", "C", "D", "H"};

    private String[] valueOrder = {"2", "3", "4", "5", "6", "7", "8",
                                   "9", "10", "J", "Q", "K", "A"};

    public static void main(String[] args) {
        String[] medalOrder = {"tin", "bronze", "silver", "gold", "platinum"};

        Comparator medalComparator = new FixedOrderComparator(medalOrder);
        Comparator athleteComparator = new BeanComparator("medal", medalComparator);

        Athlete athlete1 = new Athlete();
        athlete1.setMedal("bronze");
        Athlete athlete2 = new Athlete();
        athlete2.setMedal("tin");

        int compare = athleteComparator.compare(athlete1, athlete2);
        System.out.println(compare);
        System.out.println("=================================================");

        FixedOrderComparison object = new FixedOrderComparison();
        object.start();

    }

    public void start(){
        List<PlayingCard> cards = new ArrayList<PlayingCard>();
        cards.add(new PlayingCard("J", "C"));
        cards.add(new PlayingCard("2", "H"));
        cards.add(new PlayingCard(PlayingCard.JOKER_VALUE, PlayingCard.JOKER_SUIT));
        cards.add(new PlayingCard("2", "S"));
        cards.add(new PlayingCard("Q", "S"));
        cards.add(new PlayingCard("4", "C"));
        cards.add(new PlayingCard("J", "D"));
        System.out.println("Before sorting: " + printCards(cards));

        Comparator suitComparator = new FixedOrderComparator(suitOrder);
        suitComparator = new NullComparator(suitComparator);
        suitComparator = new BeanComparator("suit", suitComparator);

        Comparator valueComparator = new FixedOrderComparator(valueOrder);
        valueComparator = new NullComparator(valueComparator);
        valueComparator = new BeanComparator("value", valueComparator);

        ComparatorChain cardComparator = new ComparatorChain();
        cardComparator.addComparator(suitComparator);
        cardComparator.addComparator(valueComparator);

        Collections.sort(cards, cardComparator);

        System.out.println("After sorting: " + printCards(cards));
    }

    private String printCards(List<PlayingCard> cards){
        StringBuilder resultBuilder = new StringBuilder();
        Iterator cardIterator = cards.iterator();
        while (cardIterator.hasNext()){
            PlayingCard card = (PlayingCard) cardIterator.next();
            resultBuilder.append(" " + card);
        }

        return resultBuilder.toString();
    }
}
