package model;

import model.interfaces.IShape;
import java.util.ArrayList;
import java.util.List;

// Repository of shapes (should iterate over these and draw all of them)
public class ShapeList {

    // FIELDS //
    public static List<IShape> shapeList = new ArrayList<>();

    // METHODS //
    public static void add(IShape shape) {
        shapeList.add(shape);
    }

    public static void remove() {
        int index = shapeList.size() - 1;
        shapeList.remove(index);
    }
}
