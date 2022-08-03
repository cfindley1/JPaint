package model.shapes;

import model.Point;
import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Triangle extends Shape implements IShape {
    // Fields
    private ShapeConfiguration shape;
    private Point firstPoint;
    private Point lastPoint;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int[] xPoints;
    private int[] yPoints;


    // Constructor
    public Triangle(ShapeConfiguration shape) {
        this.shape = shape;
        this.firstPoint = shape.getFirstPoint();
        this.lastPoint = shape.getLastPoint();
        this.x1 = firstPoint.getX();
        this.x2 = lastPoint.getX();
        this.y1 = firstPoint.getY();
        this.y2 = lastPoint.getY();
        this.xPoints = new int[]{x1, x2, x1};
        this.yPoints = new int[]{y1, y2, y2};
    }

    @Override
    public void draw(Graphics2D g) {
        // Determine Shading Mode and Draw
        switch (shape.shapeShadingType) {
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

    public void selectDraw(Graphics2D g) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 3);
    }

    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }
}
