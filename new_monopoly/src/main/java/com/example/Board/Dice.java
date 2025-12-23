package com.example.Board;

import java.util.Random;

public class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public RollResults roll() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return new RollResults(die1, die2);
    }

    public class RollResults {
        final int total;
        final boolean isDouble;
        final boolean isSnakeEyes;

        public RollResults(int die1, int die2) {
            this.total = die1 + die2;
            this.isDouble = die1 == die2;
            this.isSnakeEyes = die1 == 1 && die2 == 1;
        }

        public int getTotal() {
            return total;
        }

        public boolean isDouble() {
            return isDouble;
        }

        public boolean isSnakeEyes() {
            return isSnakeEyes;
        }
    }
}