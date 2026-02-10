package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class MyFirstTest {

    @Test
    void myFirstTest() {
        int result = sum(2, 3);
        Assertions.assertEquals(5, result);
    }

    static int sum(int a, int b) {
        return a + b;
    }
    @Test
    public static void main(String[] args) {
        System.out.println("hello world!");
        System.out.println("postJira2");
        System.out.println("postJira3");
        System.out.println("postJira4");
        System.out.println("postJira5");
    }
}
