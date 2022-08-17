package model.interfaces;

import model.shapes.ShapeGroup;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D g);

    void selectDraw(Graphics2D g);

    int getSize();

    ShapeGroup getGroup();

    void setGroup(ShapeGroup shapeGroup);

    void removeGroup(ShapeGroup shapeGroup);

    IShapeConfiguration getShapeConfig();
}
