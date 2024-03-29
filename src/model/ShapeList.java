package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;
import model.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

// Repository of shapes (should iterate over these and draw all of them)
public class ShapeList {

    // FIELDS //
    public static List<IShape> shapeList = new ArrayList<>();

    // METHODS //
    public static void add(IShape shape) {
        if (!shapeList.contains(shape)) shapeList.add(shape);
    }

    public static void remove(IShape shape) {
        shapeList.remove(shape);
    }

    public static boolean collides(Point from, Point to, IShape shape) {
        IShapeConfiguration shapeConfiguration = shape.getShapeConfig();
        boolean collides = shapeConfiguration.collides(from, to);
        return collides;
    }

    public static boolean contains(IShape shape) {
        return shapeList.contains(shape);
    }
}
