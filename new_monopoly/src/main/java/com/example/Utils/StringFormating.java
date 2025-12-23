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
        int paddingTotal = width - content.length();
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
    public static String box(int width, int height, String... contentLines) {
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
        return boxBuilder.toString();
    }
}
