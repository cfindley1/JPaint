package model;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class ShapeConfiguration {

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


}