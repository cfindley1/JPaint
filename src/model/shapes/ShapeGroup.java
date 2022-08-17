package model.shapes;

import model.GroupList;
import model.ShapeGroupConfiguration;
import model.interfaces.IShape;

import java.awt.*;
import java.util.ArrayList;

public class ShapeGroup implements IShape {

    // Fields

    private ShapeGroupConfiguration groupedShapes = new ShapeGroupConfiguration();;

    private GroupList groupList = new GroupList();

    private ShapeGroup head;

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
        // If there is parent group, draw that instead
        if (this.getGroup() != null)
            currentGroup = this.getGroup().groupedShapes;
        // Drawing outline
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
        return 2;
    }

    @Override
    public ShapeGroup getGroup() {
        if (groupList.getSize() == 0)
            return null;
        return groupList.getHead();
    }

    public void setGroup(ShapeGroup shapeGroup) {
        // If its already in a group then add the new group to the parent list
        this.head = shapeGroup;
        groupList.add(shapeGroup);
    }

    public void removeGroup(ShapeGroup shapeGroup) {
        groupList.remove(shapeGroup);
    }
}
