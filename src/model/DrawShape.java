package model;

import java.awt.*;

public class DrawShape {

    // Iterate over shape list and draw everything
    public static void draw(Graphics2D graphics2D) {
        for (Shape shape : ShapeList.shapeList) {
            graphics2D.setColor(Color.pink);
            graphics2D.fillRect(shape.firstPoint.getX(), shape.firstPoint.getY(), shape.width, shape.height);
        }
    }
}
