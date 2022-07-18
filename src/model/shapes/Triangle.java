package model.shapes;

import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Triangle implements IShape {
    // Fields
    public ShapeConfiguration shapeConfiguration;

    // Constructor
    public Triangle(ShapeConfiguration shapeConfiguration) {
        this.shapeConfiguration = shapeConfiguration;
    }
    
    @Override
    public void draw(Graphics2D g) {
        System.out.println("Triangle");
    }
}
