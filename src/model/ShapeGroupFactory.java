package model;

import model.interfaces.IShape;
import model.shapes.ShapeGroup;

public class ShapeGroupFactory extends AbstractFactory {
    @Override
    public IShape getShape(ShapeConfiguration shapeConfiguration) {
        ShapeGroup shapeGroup = new ShapeGroup();
        return shapeGroup;
    }
}
