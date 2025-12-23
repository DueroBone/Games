package com.example.Utils;

public class StringFormating {

    /** Add | to each side and center/clip content as needed */
    private static String middleBox(String content, int width) {
        if (content.length() > width - 4) {
            content = content.substring(0, width - 5) + "...";
        }
        int paddingTotal = width - content.length() - 2;
        int paddingLeft = paddingTotal / 2;
        int paddingRight = paddingTotal - paddingLeft;
        return " ".repeat(paddingLeft) + content + " ".repeat(paddingRight);
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
        for (int i = 0; i < height; i++) {
            String content = "";
            if (i < contentLines.length) {
                content = contentLines[i];
            }
            boxBuilder.append(middleBox(content, width)).append("\n");
        }
        return boxBuilder.toString().split("\n");
    }

    public static String[] box(String... contentLines) {
        return box(23, 6, contentLines);
    }

    public static String circleBoxes(int numWide, int numTall, String[][] props) {
        StringBuilder sb = new StringBuilder();

        // Determine dimensions from content
        final int CONTENT_HEIGHT = props[0].length;
        int globalInnerWidth = 0;
        for (String[] p : props) {
            for (String line : p) {
                globalInnerWidth = Math.max(globalInnerWidth, line.length());
            }
        }

        final int BOX_INNER = globalInnerWidth; // interior width for each box
        final int BOX_WIDTH = BOX_INNER + 2; // includes vertical bars
        final int BOX_HEIGHT = CONTENT_HEIGHT + 1; // includes top+bottom borders

        // Build boxed representation for each property (uniform size)
        String[][] boxed = new String[props.length][BOX_HEIGHT];
        // │ ┼ ─
        String top = "┼" + "─".repeat(BOX_INNER) + "┼";
        // String bottom = "┴" + "─".repeat(BOX_INNER) + "┴";
        // String sides = "├" + " ".repeat(BOX_INNER) + "┤";

        for (int i = 0; i < props.length; i++) {
            boxed[i][0] = top;
            for (int r = 0; r < CONTENT_HEIGHT; r++) {
                String content = props[i][r] == null ? "" : props[i][r];
                int padTotal = BOX_INNER - content.length();
                int padLeft = padTotal / 2;
                int padRight = padTotal - padLeft;
                boxed[i][r + 1] = "│" + " ".repeat(padLeft) + content + " ".repeat(padRight) + "│";
            }
            // boxed[i][BOX_HEIGHT - 1] = bottom;
        }

        // Compute inner gap width between left and right columns (9 boxes across)
        final int MIDDLE_BOX_COUNT = 9;
        final int INNER_GAP_WIDTH = MIDDLE_BOX_COUNT * BOX_WIDTH - (MIDDLE_BOX_COUNT - 1) - 2;

        // ─── Bottom row: 0 → 10 ───────────────────────────
        for (int line = 0; line < BOX_HEIGHT; line++) {
            for (int i = 0; i <= 10; i++) {
                if (i == 0) {
                    sb.append(boxed[i][line]);
                } else {
                    // skip the leading vertical/corner char to avoid duplicates
                    sb.append(boxed[i][line].substring(1));
                }
            }
            sb.append('\n');
        }

        // ─── Middle rows ─────────────────────────────────
        for (int row = 0; row < 9; row++) {
            // Left side: 39 → 31 (bottom → top) (uses 39 - row)
            String[] left = boxed[39 - row];

            // Right side: 11 → 19 (top → bottom) (uses 11 + row)
            String[] right = boxed[11 + row];

            for (int line = 0; line < BOX_HEIGHT; line++) {
                sb.append(left[line]);
                if ((line == 0) && row == 0) {
                    String divider = top.substring(1, top.length()).repeat(MIDDLE_BOX_COUNT);
                    sb.append(divider.substring(0, divider.length() - 1));
                } else {
                    sb.append(" ".repeat(INNER_GAP_WIDTH));
                }
                sb.append(right[line]);
                sb.append('\n');
            }
        }

        // ─── Top row: 30 → 20 ────────────────────────────
        for (int line = 0; line < BOX_HEIGHT; line++) {
            for (int i = 30; i >= 20; i--) {
                if (i == 30) {
                    sb.append(boxed[i][line]);
                } else {
                    // skip the leading vertical/corner char to avoid duplicates
                    sb.append(boxed[i][line].substring(1));
                }
            }
            sb.append('\n');
        }
        sb.append(top.substring(0, top.length() - 1).repeat(11) + "┼");

        return sb.toString();
    }
}
