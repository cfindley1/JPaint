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

    public static boolean collides(Point from, Point to, Shape shapeConfig) {

        ShapeConfiguration shape = shapeConfig.getShapeConfig();
        Point firstPoint = shape.getFirstPoint();
        Point lastPoint = shape.getLastPoint();
        int x1 = firstPoint.getX();
        int x2 = lastPoint.getX();
        int y1 = firstPoint.getY();
        int y2 = lastPoint.getY();

        int s_l_x = Math.min(x1, x2);
        int s_t_y = Math.min(y1, y2);
        int s_r_x = Math.max(x1, x2);
        int s_b_y = Math.max(y1, y2);

        int d_l_x = Math.min(from.x, to.x);
        int d_t_y = Math.min(from.y, to.y);
        int d_r_x = Math.max(from.x, to.x);
        int d_b_y = Math.max(from.y, to.y);

        return ((d_r_x > s_l_x) && (d_b_y > s_t_y)
                && (s_r_x > d_l_x) && (s_b_y > d_t_y));
    }
}
