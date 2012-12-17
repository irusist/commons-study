package com.irusist.commons.collections.util;

import com.irusist.commons.collections.pojo.Team;
import org.apache.commons.collections.Predicate;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午2:44
 */
public class ValidTeamPredicate implements Predicate {
    public boolean evaluate(Object object) {
        Team team = (Team) object;
        return team.getName() != null;
    }
}
