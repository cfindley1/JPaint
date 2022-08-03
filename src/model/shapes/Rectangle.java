package model.shapes;

import model.Shape;
import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Rectangle extends Shape implements IShape {
    // Fields
    public ShapeConfiguration shape;


    // Constructor
    public Rectangle(ShapeConfiguration shape) {
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
        switch (shape.shapeShadingType) {
            case FILLED_IN:
                g.setColor(shape.shapeColorPrimary);
                g.fillRect(x, y, width, height);
                break;
            case OUTLINE:
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorPrimary);
                g.drawRect(x, y, width, height);
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(shape.shapeColorPrimary);
                g.fillRect(x, y, width, height);
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorSecondary);
                g.drawRect(x, y, width, height);
                break;
        }
    }

    public void selectDraw(Graphics2D g) {
        // Local Variables
        int x = shape.getX();
        int y = shape.getY();
        int width = shape.width;
        int height = shape.height;

        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }
}
