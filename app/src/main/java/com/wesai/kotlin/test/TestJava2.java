package com.wesai.kotlin.test;

/**
 * Created by long
 * on 2018/1/29.
 */

public class TestJava2 {

    static String world() {
        return "World!";
    }

    static class A {
        public String say() {
            return "Hello" + world();
        }
    }

    class B {
        public String ring() {
            return "Hello ring!" + world();
        }
    }
}
