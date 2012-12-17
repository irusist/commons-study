package com.irusist.commons.collections.functors;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.IfClosure;
import org.apache.commons.collections.functors.NOPClosure;

/**
 * IfClosure(Predicate predicate, Closure closure1, Closure closure2).execute(object)
 * 会执行predicate的evalute方法，如果返回true，则执行closure1,否则执行closure2
 * 其中closure1，closure2也可以是IfClosure
 * NOPClosure.getInstance()的execute方法什么都不操作。
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午6:28
 */
public class ClosureConditionalStatement {

    public static void main(String[] args) {
        Closure sell = new Closure(){
            public void execute(Object input) {
                //
            }
        };

        Closure bought = new Closure() {
            public void execute(Object input) {
                //
            }
        };

        Predicate predicate = new Predicate() {
            public boolean evaluate(Object object) {
                //
                return true;
            }
        };

        Closure action = new IfClosure(predicate, NOPClosure.getInstance(), bought);
        Closure action2 = new IfClosure(predicate, sell, action);
        action.execute(new Object());
    }
}
