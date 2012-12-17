package com.irusist.commons.collections.util;

import org.apache.commons.collections.Buffer;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 上午11:37
 */
public class BufferListener implements Runnable {

    private Buffer buffer;

    public BufferListener(Buffer buffer){
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            String message = (String) buffer.remove();
            System.out.println(message);
        }
    }
}
