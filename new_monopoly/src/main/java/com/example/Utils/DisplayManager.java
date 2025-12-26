package com.example.Utils;

public class DisplayManager {
    Game game;
    int[] selectedCell = null; // x, y

    public DisplayManager(Game game) {
        this.game = game;
    }

    public void printBoard() {
        StringBuilder boardStr = new StringBuilder(game.board.toString());
        if (selectedCell != null) {
            StringFormating.highlightBoxAt(boardStr, selectedCell[0], selectedCell[1]);
        }
        System.out.println(boardStr.toString());
    }

    private void parseInput(String input) {
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'w' -> moveCursorUp();
                case 's' -> moveCursorDown();
                case 'a' -> moveCursorLeft();
                case 'd' -> moveCursorRight();
                case 'q' -> selectedCell = null;

                case 'r' -> { // roll
                }

                case 'u' -> { // upgrade
                }
                case 'b' -> { // buy
                }
                case 'm' -> { // mortgage
                }
                case 'h' -> { // help
                }
                default -> { // do nothing
                }
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void moveCursorDown() {
        if (selectedCell != null) {
            selectedCell = new int[] { 0, 0 };
            return;
        }

        if (selectedCell[1] < 10) {
            // not bottom row
            if (selectedCell[0] > 0 && selectedCell[0] < 11) {
                // Not on left/right edge
                selectedCell[1] = 10;
            } else {
                selectedCell[1]++;
            }
        }
    }

    private void moveCursorUp() {
        if (selectedCell == null) {
            selectedCell = new int[] { 0, 10 };
            return;
        }

        if (selectedCell[1] > 0) {
            // not top row
            if (selectedCell[0] > 0 && selectedCell[0] < 11) {
                // Not on left/right edge
                selectedCell[1] = 0;
            } else {
                selectedCell[1]--;
            }
        }
    }

    private void moveCursorRight() {
        if (selectedCell == null) {
            selectedCell = new int[] { 0, 0 };
            return;
        }

        if (selectedCell[0] < 10) {
            // not right column
            if (selectedCell[1] > 0 && selectedCell[1] < 11) {
                // Not on top/bottom edge
                selectedCell[0] = 10;
            } else {
                selectedCell[0]++;
            }
        }
    }

    private void moveCursorLeft() {
        if (selectedCell == null) {
            selectedCell = new int[] { 10, 0 };
            return;
        }

        if (selectedCell[0] > 0) {
            // not left column
            if (selectedCell[1] > 0 && selectedCell[1] < 11) {
                // Not on top/bottom edge
                selectedCell[0] = 0;
            } else {
                selectedCell[0]--;
            }
        }
    }
}
