package model.interfaces;

import model.ShapeConfiguration;
import view.gui.PaintCanvas;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D g);

    ShapeConfiguration getShapeConfig();
}
