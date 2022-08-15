package model.shapes;

import model.ShapeGroupConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class ShapeGroup implements IShape {

    // Fields

    private ShapeGroupConfiguration groupedShapes;
    private ShapeGroup parentShapeGroup;

    // Constructor
    public ShapeGroup(ShapeGroupConfiguration groupedShapes) {
        this.groupedShapes = groupedShapes;
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
    public void selectDraw(Graphics2D g) {
        ShapeGroupConfiguration currentGroup = groupedShapes;
        if (this.getGroup() != null)
            currentGroup = this.getGroup().groupedShapes;
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        int[] c = currentGroup.getCoordinates();
        g.drawRect(c[0], c[1], c[2], c[3]);
    }

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

    @Override
    public ShapeGroup getGroup() {
        if (parentShapeGroup == null)
            return null;
        // Travel up tree to reach parent
        ShapeGroup cursor = parentShapeGroup;
        while (cursor.parentShapeGroup != null)
            cursor = parentShapeGroup.parentShapeGroup;
        return cursor;
    }

    public void setGroup(ShapeGroup shapeGroup) {
        this.parentShapeGroup = shapeGroup;
    }
}
