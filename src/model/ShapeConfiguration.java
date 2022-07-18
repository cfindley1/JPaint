package model;

import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;

public class ShapeConfiguration {

    // FIELDS //

    // Functional
    public PaintCanvas paintCanvas;
    public Graphics graphics2D;
    public ApplicationState appState;


    // Shape Aesthetics
    public ShapeType shapeType;
    public Color shapeColorPrimary;
    public Color shapeColorSecondary;
    public ShapeShadingType shapeShadingType;

    // Shape Coordinates
    public Point firstPoint;
    public Point lastPoint;
    public int width;
    public int height;



    // CONSTRUCTOR //
    public ShapeConfiguration(Point firstPoint, Point lastPoint, PaintCanvas paintCanvas, ApplicationState appState) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.graphics2D = paintCanvas.getGraphics2D();
        this.shapeType = appState.getActiveShapeType();
        this.shapeColorPrimary = ColorConverter.getColor(appState.getActivePrimaryColor());
        this.shapeColorSecondary = ColorConverter.getColor(appState.getActiveSecondaryColor());
        this.shapeShadingType = appState.getActiveShapeShadingType();
        this.width = lastPoint.getX() - firstPoint.getX();
        this.height = lastPoint.getY() - firstPoint.getY();
    }
}