package model.shapes;

import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

abstract public class Shape implements IShape {

    // Fields
    public ShapeConfiguration shape;
    private ShapeGroup shapeGroup;

    // Constructor
    public Shape() {
        shapeGroup = null;
    }


    // Methods
    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }

    public void selectDraw(Graphics2D g) {}

    public int getSize() {
        return 1;
    }

    @Override
    public ShapeGroup getGroup() {
        return shapeGroup;
    }

    public void setGroup(ShapeGroup shapeGroup) {
        this.shapeGroup = shapeGroup;
    }
}
