package com.jdev;

/**
 * Created by JDev on 10.05.2017.
 */
public class Main {

    public static void main(String[] args) {

//        for (int j = 0; j < 30; j++) {
        Game bowlingGame = new Game();
        bowlingGame.play();
        bowlingGame.calculateAndPrintResults();
//            System.out.println("\n---------------------------\n");
//        }
    }
}
