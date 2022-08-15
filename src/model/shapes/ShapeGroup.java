package model.shapes;

import model.ShapeGroupConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class ShapeGroup implements IShape {

    // Fields

    private ShapeGroupConfiguration groupedShapes;

    // Constructor
    public ShapeGroup() {
        this.groupedShapes = new ShapeGroupConfiguration();
    }

    // Composite Pattern Methods
    public void add(IShape s) {
        groupedShapes.add(s);
    }

    public void remove(IShape s) {
        groupedShapes.remove(s);
    }

    @Override
    public void draw(Graphics2D g) {}

    @Override
    public void selectDraw(Graphics2D g) {}

    @Override
    public ShapeGroupConfiguration getShapeConfig() {
        return groupedShapes;
    }

    public int getSize() {
        int size = 0;
        for (IShape shape : groupedShapes.getList()) {
            size++;
        }
        return size;
    }
}
