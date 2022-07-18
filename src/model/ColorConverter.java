package model;


import java.awt.Color;

// Class to Convert Enums into Color object
public class ColorConverter {
    private static Color color;

    static Color getColor(ShapeColor col) {
        
        switch (col) {
            case BLACK:
                color = Color.BLACK;
                break;
            case BLUE:
                color = Color.BLUE;
                break;
            case CYAN:
                color = Color.CYAN;
                break;
            case DARK_GRAY:
                color = Color.DARK_GRAY;
                break;
            case GRAY:
                color = Color.GRAY;
                break;
            case GREEN:
                color = Color.GREEN;
                break;

            case YELLOW:
                color = Color.YELLOW;
                break;
            case LIGHT_GRAY:
                color = Color.LIGHT_GRAY;
                break;
            case MAGENTA:
                color = Color.MAGENTA;
                break;
            case ORANGE:
                color = Color.ORANGE;
                break;
            case PINK:
                color = Color.PINK;
                break;
            case RED:
                color = Color.RED;
                break;
            case WHITE:
                color = Color.WHITE;
                break;
        }
        return color;
    }
}