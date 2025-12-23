package com.example.Utils;

public class StringFormating {
    private static String topBox(int width) {
        return "┌" + "─".repeat(width) + "┐";
    }

    private static String bottomBox(int width) {
        return "└" + "─".repeat(width) + "┘";
    }

    /** Add | to each side and center/clip content as needed */
    private static String middleBox(String content, int width) {
        if (content.length() > width - 4) {
            // (...) + (| + space) + (space + |)
            // __3___+______2______+______2_____ = 7
            content = content.substring(0, width - 7) + "...";
        }
        int paddingTotal = width - content.length() - 2;
        int paddingLeft = paddingTotal / 2;
        int paddingRight = paddingTotal - paddingLeft;
        return "│ " + " ".repeat(paddingLeft) + content + " ".repeat(paddingRight) + " │";
    }

    /**
     * Put a box around the content
     * Handles centering and clipping of content
     * 
     * @param width        Will be four characters wider due to sides of box
     * @param height       Will be two lines taller due to top and bottom lines
     * @param contentLines Input multiple strings
     * @return
     */
    public static String[] box(int width, int height, String... contentLines) {
        StringBuilder boxBuilder = new StringBuilder();
        boxBuilder.append(topBox(width)).append("\n");
        for (int i = 0; i < height; i++) {
            String content = "";
            if (i < contentLines.length) {
                content = contentLines[i];
            }
            boxBuilder.append(middleBox(content, width)).append("\n");
        }
        boxBuilder.append(bottomBox(width));
        return boxBuilder.toString().split("\n");
    }

    public static String[] box(String... contentLines) {
        return box(23, 6, contentLines);
    }

    public static String circleBoxes(int numWide, int numTall, String[][] props) {
        StringBuilder sb = new StringBuilder();

        final int HEIGHT = props[0].length;
        final int WIDTH = props[0][0].length();
        final int INNER_WIDTH = 9 * WIDTH;

        // ─── Bottom row: 0 → 9 ───────────────────────────
        for (int line = 0; line < HEIGHT; line++) {
            for (int i = 0; i <= 10; i++) {
                sb.append(props[i][line]);
            }
            sb.append('\n');
        }

        // ─── Middle rows ─────────────────────────────────
        for (int row = 0; row < 9; row++) {
            // Left side: 39 → 32 (bottom → top)
            String[] left = props[39 - row];

            // Right side: 10 → 17 (top → bottom)
            String[] right = props[11 + row];

            for (int line = 0; line < HEIGHT; line++) {
                sb.append(left[line]);
                sb.append(" ".repeat(INNER_WIDTH));
                sb.append(right[line]);
                sb.append('\n');
            }
        }

        // ─── Top row: 29 → 20 ────────────────────────────
        for (int line = 0; line < HEIGHT; line++) {
            for (int i = 30; i >= 20; i--) {
                sb.append(props[i][line]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
