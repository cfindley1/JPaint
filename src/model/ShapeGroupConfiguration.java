package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;
import model.Point;

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
        groupedShapes.add(shape);
    }

    public void remove(IShape shape) {
        groupedShapes.remove(shape);
    }

    @Override
    public boolean collides(Point from, Point to) {
        if (groupedShapes.size() == 0)
            return false;
        int[] c = this.getCoordinates();
        boolean collides = false;
        for (IShape child : groupedShapes) {
            System.out.println(child);
            ShapeConfiguration shape = (ShapeConfiguration) child.getShapeConfig();
            Point firstPoint = shape.getFirstPoint();
            Point lastPoint = shape.getLastPoint();
            int x1 = c[0];
            int x2 = c[0] + c[2];
            int y1 = c[1];
            int y2 = c[1] + c[3];

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
        System.out.println(collides);
        return collides;
    }

    public int[] getCoordinates() {
        ShapeConfiguration shapeConfig;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (IShape child : groupedShapes) {
            shapeConfig = (ShapeConfiguration) child.getShapeConfig();
            // Origin of select shape
            if (shapeConfig.getX() < minX)
                minX = shapeConfig.getX();
            if (shapeConfig.getY() < minY)
                minY = shapeConfig.getY();
            // Width and height
            if ((shapeConfig.getX() + shapeConfig.width) > maxX)
               maxX = shapeConfig.getX() + shapeConfig.width;
            if ((shapeConfig.getY() + shapeConfig.height) > maxY)
                maxY = shapeConfig.getY() + shapeConfig.height;
        }
        int width = maxX - minX;
        int height = maxY - minY;
        int[] coordinateArray = new int[]{minX, minY, width, height};
        return coordinateArray;
    }
}
