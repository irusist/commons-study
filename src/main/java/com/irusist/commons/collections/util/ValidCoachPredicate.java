package com.irusist.commons.collections.util;

import com.irusist.commons.collections.pojo.Team;
import org.apache.commons.collections.Predicate;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午2:46
 */
public class ValidCoachPredicate implements Predicate {
    public boolean evaluate(Object object) {
        boolean validCoach = false;
        Team team = (Team) object;
        if(team.getCoach() != null && team.getCoach().getFirstName() != null &&
                team.getCoach().getLastName() != null) {
            validCoach = true;
        }
        return validCoach;
    }
}
