package com.jdev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by JDev on 10.05.2017.
 */
public class Frame {

    private int stepNumber = 0;
    private final int MAX_PINS = 10;
    private List<Integer> pinsProRound = new ArrayList<>();

    public Frame(final int step) {
        this.stepNumber = step;
    }

    public void startFrameThrows() {
        int firstPins = getFirstThrowPins();
        pinsProRound.add(firstPins);
        if (firstPins < 10) {
            pinsProRound.add(getSecondThrowPins(firstPins));
        }
    }

    public void lastFrameThrow() {
        checkStrikeOrSplitByLastThrow(getFirstThrowPins());
    }

    private void checkStrikeOrSplitByLastThrow(int i) {
        pinsProRound.add(i);
        if (i == MAX_PINS) {
            checkStrikeOrSplitByLastThrow(getFirstThrowPins());
        }
        int secondPins = getSecondThrowPins(i);
        pinsProRound.add(secondPins);
        if (i + secondPins == MAX_PINS) {
            pinsProRound.add(getFirstThrowPins());
        }
    }

    public boolean isStrike() {
        boolean isStrike = false;
        if (!pinsProRound.isEmpty()) {
            isStrike = pinsProRound.get(0) == MAX_PINS;
        }
        return isStrike;
    }

    public boolean isSpare() {
        boolean isSpare = false;
        if (pinsProRound.size() >= 2) {
            isSpare = pinsProRound.get(0) + pinsProRound.get(1) == MAX_PINS;
        }
        return isSpare;
    }

    private int getFirstThrowPins() {
        return ThreadLocalRandom.current().nextInt(0, MAX_PINS + 1);
    }

    private int getSecondThrowPins(int firstPin) {
        return ThreadLocalRandom.current().nextInt(0, MAX_PINS - firstPin + 1);
    }

    public void printFrameResults() {
        StringBuilder sb = new StringBuilder("( ");
        for (Integer pins : pinsProRound) {
            sb.append(pins == MAX_PINS ? "/" : pins).append(" ");
        }

        System.out.printf("Frame_%s:%s%s", stepNumber, sb, ")");
    }

    public List<Integer> getPinsProRound() {
        return pinsProRound;
    }

    public void setPinsProRound(List<Integer> pinsProRound) {
        this.pinsProRound = pinsProRound;
    }

}
