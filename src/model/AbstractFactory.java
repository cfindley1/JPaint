package model;

import model.interfaces.IShape;

public abstract class AbstractFactory {
    abstract IShape getShape(ShapeConfiguration shapeConfiguration);
}
