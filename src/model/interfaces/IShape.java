package model.interfaces;

import model.ShapeConfiguration;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D graphics2D);

    ShapeConfiguration getShapeConfig();
}
