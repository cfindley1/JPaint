package model.interfaces;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D g);

    void selectDraw(Graphics2D g);

    int getSize();

    IShapeConfiguration getShapeConfig();
}
