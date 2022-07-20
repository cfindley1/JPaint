package model;

import model.interfaces.IShape;

abstract public class Shape implements IShape {

    public ShapeConfiguration shape;

    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }

}
