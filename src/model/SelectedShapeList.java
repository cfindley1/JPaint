package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class SelectedShapeList {

    // FIELDS //
    public static List<IShape> selectedShapeList = new ArrayList<>();

    // METHODS //
    public static void add(IShape shape) {
        PaintCanvas paintCanvas = PaintCanvas.getInstance();
        selectedShapeList.add(shape);
        paintCanvas.repaint();
    }

    public static void remove(Object shape) {
        PaintCanvas paintCanvas = PaintCanvas.getInstance();
        selectedShapeList.remove(shape);
        paintCanvas.repaint();
    }

    public static void print() {
        System.out.println(selectedShapeList.size());
        for (IShape shape : selectedShapeList)
            System.out.println(shape);
    }
}
