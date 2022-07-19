package model.shapes;

import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Ellipse implements IShape {
    public ShapeConfiguration shape;

    // Constructor
    public Ellipse(ShapeConfiguration shape) {
        this.shape = shape;
    }
    @Override
    public void draw(Graphics2D g) {
        // Local Variables
        int x = shape.x;
        int y = shape.y;
        int width = shape.width;
        int height = shape.height;

        // Determine Shading Mode and Draw
        switch(shape.shapeShadingType) {
            case FILLED_IN:
                g.setColor(shape.shapeColorPrimary);
                g.fillOval(x, y, width, height);
                break;
            case OUTLINE:
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorPrimary);
                g.drawOval(x, y, width, height);
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(shape.shapeColorPrimary);
                g.fillOval(x, y, width, height);
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorSecondary);
                g.drawOval(x, y, width, height);
                break;
        }

    }
}
