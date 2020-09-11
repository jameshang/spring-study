package com.jh.study.hanoi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hanoi {

    private int size;
    private int step;

    public Hanoi(int size) {
        this.size = Math.max(size, 1);
    }

    private void move(int n, String from, String to) {
        log.info("Step {}: move {} from {} to {}", ++step, n, from, to);
    }

    private void goPriv(int n, String startPos, String transPos, String endPos) {
        if (n == 1) {
            move(n, startPos, endPos);
        } else {
            goPriv(n - 1, startPos, endPos, transPos);
            move(n, startPos, endPos);
            goPriv(n - 1, transPos, startPos, endPos);
        }
    }

    public void go(String startPos, String transPos, String endPos) {
        goPriv(size, startPos, transPos, endPos);
    }

}
