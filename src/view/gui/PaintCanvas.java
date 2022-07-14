package view.gui;

import model.DrawShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class PaintCanvas extends PaintCanvasBase {

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        DrawShape.draw(graphics2d);
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
