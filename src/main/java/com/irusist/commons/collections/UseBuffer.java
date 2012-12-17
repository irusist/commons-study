package com.irusist.commons.collections;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.buffer.BoundedFifoBuffer;
import org.apache.commons.collections.buffer.UnboundedFifoBuffer;

/**
 * Buffer buffer = new UnboundedFifoBuffer();
 * buffer.add("A")
 * buffer.remove()会删除第一个加进去的元素并返回他的值，如果没有可删除的则跑出BufferUnderflowException
 * Buffer buffer2 = new BoundedFifoBuffer(2);
 * buffer2.add("A")，如果buffer2中已经满了，则会跑出BufferOverflowException
 * buffer2.remove()，如果buffer2中没有元素了。则跑出BufferUnderflowException
 * User: zhulixin
 * Date: 12-12-7
 * Time: 下午4:58
 */
public class UseBuffer {

    public static void main(String[] args) {
        Buffer buffer = new UnboundedFifoBuffer();
        buffer.add("A");
        buffer.add("B");
        buffer.add("D");

        String value = (String) buffer.remove();

        buffer.add("E");
        value = (String) buffer.remove();
        System.out.println(value);

        System.out.println("======================");

        Buffer buffer2 = new BoundedFifoBuffer(2);
        buffer2.add("one");
        buffer2.add("two");

        try{
            buffer2.add("three");
        } catch (BufferOverflowException bue){
            System.out.println("buffer is Full!");
        }

        Object removed = buffer2.remove();
        System.out.println(removed);

        buffer2.add("three");

        Object remove1 = buffer2.remove();
        Object remove2 = buffer2.remove();

        try{
            Object remove3 = buffer2.remove();
        } catch (BufferUnderflowException bue){
            System.out.println("buffer is empty!");
        }
    }

}
