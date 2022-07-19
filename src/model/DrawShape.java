package model;

import model.interfaces.IShape;

import java.awt.*;

public class DrawShape {

    // Iterate over shape list and draw everything
    public static void draw(Graphics2D g) {
        System.out.println("begin repaint");
        for (IShape shape : ShapeList.shapeList) {
            System.out.println(shape.toString());
            shape.draw(g);
        }
    }
}
