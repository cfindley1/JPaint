package view.gui;

import model.SelectedShapeList;
import model.ShapeList;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class PaintCanvas extends PaintCanvasBase {
    // Singleton Design Pattern

    // Make one instance that is private
    private static PaintCanvas instance = new PaintCanvas();

    // Private constructor so that it cannot be instantiated
    private PaintCanvas() {
    }

    ;

    public static PaintCanvas getInstance() {
        return instance;
    }

    // Override paint method to run when repaint() is called
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        // Draw shapes
        for (IShape shape : ShapeList.shapeList) {
            shape.draw(graphics2d);
            System.out.println("shape List: " + shape);
        }
        // Draw outlines
        for (IShape shape : SelectedShapeList.getList()) {
            System.out.println(shape + "group: " + shape.getGroup());
            // If it has a group, then you don't need to outline it
            if (shape.getGroup() != null)
                continue;
            else
                shape.selectDraw(graphics2d);
        }
        System.out.println("repainted");
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
