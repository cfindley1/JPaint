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

        return ((d_r_x > s_l_x) && (d_b_y > s_t_y)
                && (s_r_x > d_l_x) && (s_b_y > d_t_y));
    }

    @Override
    public int getX() {
        int[] coordinates = getCoordinates();
        return coordinates[0];
    }

    @Override
    public int getY() {
        int[] coordinates = getCoordinates();
        return coordinates[1];
    }

    @Override
    public int getWidth() {
        int[] coordinates = getCoordinates();
        return coordinates[2];
    }

    @Override
    public int getHeight() {
        int[] coordinates = getCoordinates();
        return coordinates[3];
    }


    public int[] getCoordinates() {
        IShapeConfiguration shapeConfig;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (IShape child : groupedShapes) {
            shapeConfig = child.getShapeConfig();
            // Origin of select shape
            if (shapeConfig.getX() < minX)
                minX = shapeConfig.getX();
            if (shapeConfig.getY() < minY)
                minY = shapeConfig.getY();
            // Width and height
            int width = shapeConfig.getWidth();
            int height = shapeConfig.getHeight();
            if ((shapeConfig.getX() + width) > maxX)
               maxX = shapeConfig.getX() + width;
            if ((shapeConfig.getY() + height) > maxY)
                maxY = shapeConfig.getY() + height;
        }
        int width = maxX - minX;
        int height = maxY - minY;
        int[] coordinateArray = new int[]{minX, minY, width, height};
        return coordinateArray;
    }
}
