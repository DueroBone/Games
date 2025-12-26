package com.example.Utils;

public class StringFormating {

    final static int BOX_WIDTH = 21;
    final static int BOX_HEIGHT = 8;

    /** Add | to each side and center/clip content as needed */
    private static String middleBox(String content) {
        if (content.length() > BOX_WIDTH - 4) {
            content = content.substring(0, BOX_WIDTH - 5) + "...";
        }
        int paddingTotal = BOX_WIDTH - content.length() - 2;
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
    public static String[] box(String... contentLines) {
        // It has a clean border. No touchie.
        // This is such horrendous spaghetti code that any touching WILL break it.
        StringBuilder boxBuilder = new StringBuilder();
        for (int i = 0; i < BOX_HEIGHT; i++) {
            String content = "";
            if (i < contentLines.length) {
                content = contentLines[i];
            }
            boxBuilder.append(middleBox(content)).append("\n");
        }
        return boxBuilder.toString().split("\n");
    }

    public static String circleBoxes(int numWide, int numTall, String[][] props) {
        StringBuilder sb = new StringBuilder();

        final int BOX_INNER = BOX_WIDTH - 2;

        String[][] boxed = new String[props.length][BOX_HEIGHT];
        // │ ┼ ─
        String top = "┼" + "─".repeat(BOX_INNER) + "┼";

        for (int i = 0; i < props.length; i++) {
            boxed[i][0] = top;
            for (int r = 0; r < BOX_HEIGHT - 2; r++) {
                String content = props[i][r] == null ? "" : props[i][r];
                int padTotal = BOX_INNER - content.length();
                int padLeft = padTotal / 2;
                int padRight = padTotal - padLeft;
                boxed[i][r + 1] = "│" + " ".repeat(padLeft) + content + " ".repeat(padRight) + "│";
            }
        }

        final int MIDDLE_BOX_COUNT = 9;
        final int INNER_GAP_WIDTH = MIDDLE_BOX_COUNT * BOX_WIDTH - (MIDDLE_BOX_COUNT - 1) - 2;

        // ─── Bottom row: 0 → 10 ───────────────────────────
        for (int line = 0; line < BOX_HEIGHT - 1; line++) {
            for (int i = 0; i <= 10; i++) {
                if (i == 0) {
                    sb.append(boxed[i][line]);
                } else {
                    sb.append(boxed[i][line].substring(1));
                }
            }
            sb.append('\n');
        }

        // ─── Middle rows ─────────────────────────────────
        for (int row = 0; row < 9; row++) {
            String[] left = boxed[39 - row];

            String[] right = boxed[11 + row];

            for (int line = 0; line < BOX_HEIGHT - 1; line++) {
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
        for (int line = 0; line < BOX_HEIGHT - 1; line++) {
            for (int i = 30; i >= 20; i--) {
                if (i == 30) {
                    sb.append(boxed[i][line]);
                } else {
                    sb.append(boxed[i][line].substring(1));
                }
            }
            sb.append('\n');
        }
        sb.append(top.substring(0, top.length() - 1).repeat(11) + "┼");

        // ┌ ┐ └ ┘
        // ├ ┤ ┬ ┬
        // ┼ │ ─

        // Fix edge squares
        for (int i = 0; i < 11; i++) {
            editBoxAt(sb, i, 0, '┬', '┬',
                    '┴', '┴', '─', '│'); // top row
            editBoxAt(sb, i, 10, '┬', '┬',
                    '┴', '┴', '─', '│'); // bottom row
            editBoxAt(sb, 0, i, '├', '┤',
                    '├', '┤', '─', '│'); // Left column
            editBoxAt(sb, 10, i, '├', '┤',
                    '├', '┤', '─', '│'); // Right column
        }

        // Fix corners
        editBoxAt(sb, 0, 0, '┌', '┬',
                '├', '┼', '─', '│'); // Top left
        editBoxAt(sb, 10, 0, '┬', '┐',
                '┼', '┤', '─', '│'); // Top right
        editBoxAt(sb, 0, 10, '├', '┼',
                '└', '┴', '─', '│'); // Bottom left
        editBoxAt(sb, 10, 10, '┼', '┤',
                '┴', '┘', '─', '│'); // Bottom right

        return sb.toString();
    }

    private static int[][] findCordsOfBox(int xIndex, int yIndex) {
        // Top left corner
        int startX = xIndex * (BOX_WIDTH - 1);
        int startY = yIndex * (BOX_HEIGHT - 1);

        return new int[][] { { startX, startY },
                { startX + BOX_WIDTH - 1, startY },
                { startX, startY + BOX_HEIGHT - 1 },
                { startX + BOX_WIDTH - 1, startY + BOX_HEIGHT - 1 } };
    }

    private static int findIndexOfBoxCorner(int[] XY) {
        int charPerLine = (BOX_WIDTH - 1) * 11 + 2;
        return XY[1] * charPerLine + XY[0];
    }

    private static void editBoxAt(StringBuilder sb, int xIndex, int yIndex, char topLeft, char topRight,
            char bottomLeft, char bottomRight, char horizontal, char vertical) {
        int[][] cords = findCordsOfBox(xIndex, yIndex);
        // top left
        sb.setCharAt(findIndexOfBoxCorner(cords[0]), topLeft);
        // top right
        sb.setCharAt(findIndexOfBoxCorner(cords[1]), topRight);
        // bottom left
        sb.setCharAt(findIndexOfBoxCorner(cords[2]), bottomLeft);
        // bottom right
        sb.setCharAt(findIndexOfBoxCorner(cords[3]), bottomRight);

        // horizontals
        for (int x = cords[0][0] + 1; x < cords[1][0]; x++) {
            sb.setCharAt(findIndexOfBoxCorner(new int[] { x, cords[0][1] }), horizontal);
            sb.setCharAt(findIndexOfBoxCorner(new int[] { x, cords[2][1] }), horizontal);
        }

        // verticals
        for (int y = cords[0][1] + 1; y < cords[2][1]; y++) {
            sb.setCharAt(findIndexOfBoxCorner(new int[] { cords[0][0], y }), vertical);
            sb.setCharAt(findIndexOfBoxCorner(new int[] { cords[1][0], y }), vertical);
        }
    }

    public static void highlightBoxAt(StringBuilder sb, int xIndex, int yIndex) {
        // editBoxAt(sb, xIndex, yIndex, '┏', '┓', '┗', '┛', '━', '┃');
        editBoxAt(sb, xIndex, yIndex, '╔', '╗', '╚', '╝', '═', '║');
    }
}
