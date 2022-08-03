package model.shapes;

import model.Point;
import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

abstract public class Shape implements IShape {

    public ShapeConfiguration shape;
    private int x;
    private int y;
    private int width;
    private int height;
    private Point firstPoint;
    private Point lastPoint;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int[] xPoints;
    private int[] yPoints;


    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }

    public void selectDraw(Graphics2D g) {}

    public Graphics2D setOutline(Graphics2D g) {
        return g;
    }

    public Graphics2D setOutlineAndFilledIn(Graphics2D g) {
        return g;
    }

    public Graphics2D setSelect(Graphics2D g) {
        g.setStroke(new BasicStroke(5));
        g.setColor(shape.shapeColorPrimary);
        return g;
    }



}
