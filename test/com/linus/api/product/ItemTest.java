package com.linus.api.product;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("-->"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(), "Hello");
    }

    @Test
    public void add() {
        Item s = new Item();
        int s3 = s.add(1, 2);
        System.out.println("-->"+s3);
        int s2 = 3;
        Assertions.assertEquals(s.add(1, 2), 3);
    }

}