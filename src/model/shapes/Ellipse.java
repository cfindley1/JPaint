package model.shapes;

import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Ellipse implements IShape {
    // Fields
    public ShapeConfiguration shapeConfiguration;

    // Constructor
    public Ellipse(ShapeConfiguration shapeConfiguration) {
        this.shapeConfiguration = shapeConfiguration;
    }
    @Override
    public void draw(Graphics2D g) {
        System.out.println("Ellipse");
    }
}
