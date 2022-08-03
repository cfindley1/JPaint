package model.interfaces;

import model.ShapeConfiguration;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D graphics2D);

    void selectDraw(Graphics2D g);

    ShapeConfiguration getShapeConfig();
}
