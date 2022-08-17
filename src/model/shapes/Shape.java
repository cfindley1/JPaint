package model.shapes;

import model.GroupList;
import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

abstract public class Shape implements IShape {

    // Fields
    public ShapeConfiguration shape;

    private GroupList groupList = new GroupList();

    // Methods
    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }

    public void selectDraw(Graphics2D g) {}

    public int getSize() {
        return 1;
    }

    @Override
    public ShapeGroup getGroup() {
        if (groupList.getSize() == 0)
            return null;
        return groupList.getHead();
    }

    public void setGroup(ShapeGroup shapeGroup) {
        this.groupList.add(shapeGroup);
    }


    public void removeGroup(ShapeGroup shapeGroup) {
        System.out.println(shapeGroup + " remove in shape");
        groupList.remove(shapeGroup);

    }
}
