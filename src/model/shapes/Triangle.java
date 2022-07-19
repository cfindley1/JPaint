package model.shapes;

import model.Point;
import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Triangle implements IShape {
    // Fields
    public ShapeConfiguration shape;

    // Constructor
    public Triangle(ShapeConfiguration shape) {
        this.shape = shape;
    }
    
    @Override
    public void draw(Graphics2D g) {

        // Local Variables
        Point firstPoint = shape.firstPoint;
        Point lastPoint = shape.lastPoint;
        int x1 = firstPoint.getX();
        int x2 = lastPoint.getX();
        int y1 = firstPoint.getY();
        int y2 = lastPoint.getY();
        int[] xPoints = new int[] {x1, x2, x1};
        int[] yPoints = new int[] {y1, y2, y2};

        // Determine Shading Mode and Draw
        switch(shape.shapeShadingType) {
            case FILLED_IN:
                g.setColor(shape.shapeColorPrimary);
                g.fillPolygon(xPoints, yPoints, 3);
                break;
            case OUTLINE:
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorPrimary);
                g.drawPolygon(xPoints, yPoints, 3);
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(shape.shapeColorPrimary);
                g.fillPolygon(xPoints, yPoints, 3);
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorSecondary);
                g.drawPolygon(xPoints, yPoints, 3);
                break;
        }

    }
}
