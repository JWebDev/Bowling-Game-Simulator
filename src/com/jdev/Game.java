package com.jdev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDev on 10.05.2017.
 */
public class Game {
    private final int FRAMES = 10;
    private List<Frame> frames = new ArrayList<>();

    public void play() {
        for (int i = 0; i < FRAMES; i++) {
            Frame frame = new Frame(i + 1);
            if (i == FRAMES - 1) {
                frame.lastFrameThrow();
            } else {
                frame.startFrameThrows();
            }
            frames.add(frame);
        }
    }

    public void calculateAndPrintResults() {

        int total = 0;
        int pointer = 0;

        List<Integer> allThrows = new ArrayList<>();

        for (Frame frame : frames) {
            allThrows.addAll(frame.getPinsProRound());
        }

        for (Frame frame : frames) {
            if (frame.isStrike()) {
                total += allThrows.get(pointer) + allThrows.get(pointer + 1) + allThrows.get(pointer + 2);
                pointer++;
            } else if (frame.isSpare()) {
                total += allThrows.get(pointer) + allThrows.get(pointer + 1) + allThrows.get(pointer + 2);
                pointer = pointer + 2;
            } else {
                total += allThrows.get(pointer) + allThrows.get(pointer + 1);
                pointer = pointer + 2;
            }
            frame.printFrameResults();
            System.out.printf(" -> %s\n\n", total);
        }
        System.out.printf("TOTAL PINS:%s ", total);
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
