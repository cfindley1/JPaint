package model;

import model.interfaces.IShape;

import java.awt.*;

abstract public class Shape implements IShape {

    public ShapeConfiguration shape;

    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }

    public void selectDraw(Graphics2D g) {}

}
