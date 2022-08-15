package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;
import model.persistence.ApplicationState;

import java.awt.*;

public class ShapeConfiguration implements IShapeConfiguration {

    // FIELDS //

    // Functional
    public ApplicationState appState;

    // Shape Coordinates
    private Point firstPoint;
    private Point lastPoint;
    public int width;
    public int height;

    // Shape Aesthetics
    public ShapeType shapeType;
    public Color shapeColorPrimary;
    public Color shapeColorSecondary;
    public ShapeShadingType shapeShadingType;


    // CONSTRUCTOR //
    public ShapeConfiguration(Point firstPoint, Point lastPoint, ApplicationState appState) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.width = Math.abs(lastPoint.getX() - firstPoint.getX());
        this.height = Math.abs(lastPoint.getY() - firstPoint.getY());
        this.appState = appState;
        this.shapeType = appState.getActiveShapeType();
        this.shapeColorPrimary = ColorConverter.getColor(appState.getActivePrimaryColor());
        this.shapeColorSecondary = ColorConverter.getColor(appState.getActiveSecondaryColor());
        this.shapeShadingType = appState.getActiveShapeShadingType();
    }

    public ShapeConfiguration(Point firstPoint, Point lastPoint) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.width = Math.abs(lastPoint.getX() - firstPoint.getX());
        this.height = Math.abs(lastPoint.getY() - firstPoint.getY());
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getLastPoint() {
        return lastPoint;
    }


    public int getX() {
        return Math.min(lastPoint.getX(), firstPoint.getX());
    }

    public int getY() {
        return Math.min(lastPoint.getY(), firstPoint.getY());
    }

    public IShape shapeCopy(Point firstPoint, Point lastPoint) {
        ShapeConfiguration copy = new ShapeConfiguration(firstPoint, lastPoint);
        copy.shapeType = this.shapeType;
        copy.shapeShadingType = this.shapeShadingType;
        copy.shapeColorPrimary = this.shapeColorPrimary;
        copy.shapeColorSecondary = this.shapeColorSecondary;
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape newShape = shapeFactory.getShape(copy);
        return newShape;
    }

    @Override
    public boolean collides(Point from, Point to) {
        int x1 = firstPoint.getX();
        int x2 = lastPoint.getX();
        int y1 = firstPoint.getY();
        int y2 = lastPoint.getY();

        int s_l_x = Math.min(x1, x2);
        int s_t_y = Math.min(y1, y2);
        int s_r_x = Math.max(x1, x2);
        int s_b_y = Math.max(y1, y2);

        int d_l_x = Math.min(from.getX(), to.getX());
        int d_t_y = Math.min(from.getY(), to.getY());
        int d_r_x = Math.max(from.getX(), to.getX());
        int d_b_y = Math.max(from.getY(), to.getY());

        return ((d_r_x > s_l_x) && (d_b_y > s_t_y)
                && (s_r_x > d_l_x) && (s_b_y > d_t_y));
    }
}