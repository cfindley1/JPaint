package view.gui;

import model.ShapeList;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class PaintCanvas extends PaintCanvasBase {

    @Override
    public void paint(Graphics g) {
        for (IShape shape : ShapeList.shapeList) {
            shape.draw(this);
        }
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
