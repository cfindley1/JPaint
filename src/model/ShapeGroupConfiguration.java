package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ShapeGroupConfiguration implements IShapeConfiguration {

    // Fields
    private List<IShape> groupedShapes;

    //Constructor
    public ShapeGroupConfiguration() {
        this.groupedShapes = new ArrayList<IShape>();
    }

    // Methods
    public List<IShape> getList() {
        return groupedShapes;
    }

    public void add(IShape shape) {
        groupedShapes.remove(shape);
    }

    public void remove(IShape shape) {
        groupedShapes.remove(shape);
    }

    @Override
    public boolean collides(Point from, Point to) {
        System.out.println("ShapeGroup");
        if (groupedShapes.size() == 0)
            return false;
        boolean collides = false;
        for (IShape child : groupedShapes) {
            ShapeConfiguration shape = (ShapeConfiguration) child.getShapeConfig();
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

            int d_l_x = Math.min(from.getX(), to.getX());
            int d_t_y = Math.min(from.getY(), to.getY());
            int d_r_x = Math.max(from.getX(), to.getX());
            int d_b_y = Math.max(from.getY(), to.getY());

            if ((d_r_x > s_l_x) && (d_b_y > s_t_y) && (s_r_x > d_l_x) && (s_b_y > d_t_y)) {
                collides = true;
                break;
            }
        }
        return collides;
    }
}
