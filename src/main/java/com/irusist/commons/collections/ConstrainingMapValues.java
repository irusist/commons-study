package com.irusist.commons.collections;

import com.irusist.commons.beanutils.pojo.Coach;
import com.irusist.commons.collections.pojo.Person;
import com.irusist.commons.collections.pojo.Team;
import com.irusist.commons.collections.util.ValidCoachPredicate;
import com.irusist.commons.collections.util.ValidTeamPredicate;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AndPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.apache.commons.collections.map.PredicatedMap;

import java.util.HashMap;
import java.util.Map;

/**
 *  Map teamMap = PredicatedMap.decorate(new HashMap(), null, valuePredicate);
 *  其中teamMap要求他的key可以没什么要求，但是value必须满足valuePredicate
 *  valuePredicate可以是任意Predicate的组合
 *  PredicatedSortedMap, PredicatedSortedSet, PredicatedSortedBag
 *  PredicatedMap, PredicatedBug, PredicatedList, PredicatedSet, PredicatedCollection
 *  PredicatedBuffer,泛型只能限制InstanceofPredicate,但是他们可以有各种限制。
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午2:35
 */
public class ConstrainingMapValues {

    public static void main(String[] args) {
        Predicate onlyStrings = new InstanceofPredicate(String.class);

        Predicate onlyGreen = new EqualPredicate("green");
        Predicate onlyRed = new EqualPredicate("red");
        Predicate greenOrRed = new OrPredicate(onlyGreen, onlyRed);

        Map map = PredicatedMap.decorate(new HashMap(), onlyStrings, greenOrRed);

        map.put("tony", "green");
        map.put("alice", "red");
        map.put("mike", "red");
        map.put("bobby", "green");

        // 以下会跑出IllegalArgumentException
//        map.put(new Double(3.0), "green");
//        map.put("alice", "purple");
//        map.put(32L, 43L);

        ValidTeamPredicate validTeam = new ValidTeamPredicate();
        ValidCoachPredicate validCoach = new ValidCoachPredicate();
        AndPredicate valuePredicate = new AndPredicate(validTeam, validCoach);

        Map teamMap = PredicatedMap.decorate(new HashMap(), null, valuePredicate);

        Team redSox = new Team("Red Sox", new Person("Patrick", "Moloney"));
        Team yankees = new Team("Yankess", new Person("David", "McGarry"));
        Team dodgers = new Team("Dodgers", new Person("Nick", "Taylor"));
        Team twins = new Team(null, new Person("Patrick", "Moloney"));
        Team braves = new Team("Braves", null);

        teamMap.put("ReadSox", redSox);
        teamMap.put("Yankess", yankees);
        teamMap.put("Doders", dodgers);

        try {
            teamMap.put("Twins", twins);
        } catch (IllegalArgumentException iae) {
            System.out.println("Twins put failed, as expected");
        }

        try {
            teamMap.put("Braves", braves);
        } catch (IllegalArgumentException iae) {
            System.out.println("Braves put failed, as expected");
        }
    }
}
