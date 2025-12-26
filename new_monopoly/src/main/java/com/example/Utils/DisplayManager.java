package com.example.Utils;

import java.util.concurrent.CancellationException;

import com.example.Board.Property.PropertyBase;
import com.example.Player.PlayerBase;

public class DisplayManager {
    Game game;
    int[] selectedCell = null; // x, y
    int currentPlayerIndex = 0;

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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void moveCursorDown() {
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

    public void moveCursorUp() {
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

    public void moveCursorRight() {
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

    public void moveCursorLeft() {
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

    public PropertyBase getSelectedProperty() {
        if (selectedCell == null) {
            return null;
        }
        int propertyIndex = locationToIndex(selectedCell[0], selectedCell[1]);
        return game.board.properties[propertyIndex];
    }

    private int locationToIndex(int x, int y) {
        if (y == 0) {
            return x;
        } else if (x == 10) {
            return 10 + y;
        } else if (y == 10) {
            return 20 + (10 - x);
        } else if (x == 0) {
            return 30 + (10 - y);
        } else {
            throw new IllegalArgumentException("Invalid board coordinates");
        }
    }

}
