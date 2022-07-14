package model;

import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

// Repository of shapes (should iterate over these and draw all of them)
public class ShapeList {

    //Fields
    public static List<Shape> shapeList = new ArrayList<>();
    private PaintCanvas paintCanvas;

    // Constructor
    public ShapeList(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas; // for future better implementations (cant use since static class)
    }


    // Methods
    public static void add(Shape shape, PaintCanvas paintCanvas) {
        shapeList.add(shape);
    }

    public static void remove(Shape shape, PaintCanvas paintCanvas) {
        int index = shapeList.size() - 1;
        shapeList.remove(index);
    }
}
