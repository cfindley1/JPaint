package model;

import model.persistence.ApplicationState;
import java.awt.*;

public class ShapeConfiguration {

    // FIELDS //

    // Functional
    public ApplicationState appState;

    // Shape Coordinates
    public Point firstPoint;
    public Point lastPoint;
    public int width;
    public int height;
    public int x;
    public int y;


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
        this.x = Math.min(lastPoint.getX(), firstPoint.getX());
        this.y = Math.min(lastPoint.getY(), firstPoint.getY());
        this.appState = appState;
        this.shapeType = appState.getActiveShapeType();
        this.shapeColorPrimary = ColorConverter.getColor(appState.getActivePrimaryColor());
        this.shapeColorSecondary = ColorConverter.getColor(appState.getActiveSecondaryColor());
        this.shapeShadingType = appState.getActiveShapeShadingType();
    }
}