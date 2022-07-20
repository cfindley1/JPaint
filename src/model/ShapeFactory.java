package model;

import model.interfaces.IShape;
import model.shapes.Ellipse;
import model.shapes.Rectangle;
import model.shapes.Triangle;

public class ShapeFactory extends AbstractFactory {
    @Override
    public IShape getShape(ShapeConfiguration shapeConfiguration) {
        switch (shapeConfiguration.shapeType) {
            case RECTANGLE:
                return new Rectangle(shapeConfiguration);
            case ELLIPSE:
                return new Ellipse(shapeConfiguration);
            case TRIANGLE:
                return new Triangle(shapeConfiguration);
            default:
                return null;
        }
    }
}
