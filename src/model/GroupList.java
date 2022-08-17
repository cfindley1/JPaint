package model;

import model.shapes.ShapeGroup;
import java.util.LinkedList;

public class GroupList {
    // FIELDS //
    private LinkedList<ShapeGroup> groupList = new LinkedList<>();

    // METHODS //
    public void add(ShapeGroup shape) {
        if (!groupList.contains(shape))
        groupList.addFirst(shape);
    }

    public void remove(ShapeGroup shape) {
        groupList.remove(shape);
    }

    public ShapeGroup getHead() {
        return groupList.getFirst();
    }

    public int getSize() {
        return groupList.size();
    }
}
