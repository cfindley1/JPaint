package view.gui;

<<<<<<< Updated upstream
import model.DrawShape;
=======
import model.SelectedShapeList;
import model.ShapeList;
import model.interfaces.IShape;
>>>>>>> Stashed changes
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class PaintCanvas extends PaintCanvasBase {

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
<<<<<<< Updated upstream
        DrawShape.draw(graphics2d);
=======
        for (IShape shape : ShapeList.shapeList)
            shape.draw(graphics2d);
        for (IShape shape : SelectedShapeList.selectedShapeList)
            shape.selectDraw(graphics2d);
>>>>>>> Stashed changes
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
