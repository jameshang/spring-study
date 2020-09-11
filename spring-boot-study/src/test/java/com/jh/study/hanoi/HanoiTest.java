package com.jh.study.hanoi;

import org.junit.Test;

public class HanoiTest {

    @Test
    public void testHanoi() {
        Hanoi hanoi = new Hanoi(5);
        hanoi.go("A", "B", "C");
    }

}
