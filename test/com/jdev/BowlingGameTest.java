package com.jdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JDev on 10.05.2017.
 */
public class BowlingGameTest {

    private List<List<Integer>> pinsForTest = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(1, 4), Arrays
            .asList(4, 5), Arrays.asList(6, 4), Arrays.asList(5, 5), Arrays.asList(10), Arrays.asList(0, 1), Arrays
            .asList(7, 3), Arrays.asList(6, 4), Arrays.asList(10), Arrays.asList(2, 8, 6)));

    public BowlingGameTest() {

        Game bowlingGame = new Game();
        for (int i = 0; i < 10; i++) {
            Frame testFrame = new Frame(i + 1);
            testFrame.setPinsProRound(pinsForTest.get(i));
            bowlingGame.getFrames().add(testFrame);
        }

        bowlingGame.calculateAndPrintResults();
    }

    public static void main(String[] args) {
        new BowlingGameTest();
    }
}
