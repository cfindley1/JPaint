package model.shapes;

import model.Shape;
import model.ShapeConfiguration;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;

public class Ellipse extends Shape implements IShape {
    public ShapeConfiguration shape;

    // Constructor
    public Ellipse(ShapeConfiguration shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics2D g) {
        // Local Variables
        int x = shape.getX();
        int y = shape.getY();
        int width = shape.width;
        int height = shape.height;

        // Determine Shading Mode and Draw
        switch (shape.shapeShadingType) {
            case FILLED_IN -> {
                g.setColor(shape.shapeColorPrimary);
                g.fillOval(x, y, width, height);
            }
            case OUTLINE -> {
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorPrimary);
                g.drawOval(x, y, width, height);
            }
            case OUTLINE_AND_FILLED_IN -> {
                g.setColor(shape.shapeColorPrimary);
                g.fillOval(x, y, width, height);
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorSecondary);
                g.drawOval(x, y, width, height);
            }
        }
    }

    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }
}
