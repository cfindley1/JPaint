package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;
import java.util.ArrayList;
import java.util.List;

public class CopyShapeList {
    // FIELDS //
    public static List<IShape> copyShapeList = new ArrayList<>();

    // METHODS //
    public static void add(IShape shape) {
        copyShapeList.add(shape);
    }

    public static void remove(Object shape, PaintCanvas paintCanvas) {
        copyShapeList.remove(shape);
    }
}
