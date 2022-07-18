package model;

import model.interfaces.IShape;

import java.awt.*;

public class DrawShape {

    // Iterate over shape list and draw everything
    public static void draw(Graphics2D g) {
        for (IShape shape : ShapeList.shapeList) {
            shape.draw(g);
        }
    }
}
