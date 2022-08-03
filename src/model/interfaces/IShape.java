package model.interfaces;

import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public interface IShape {
    void draw(PaintCanvas paintCanvas);

    ShapeConfiguration getShapeConfig();
}
