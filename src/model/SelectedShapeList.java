package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class SelectedShapeList {

    // FIELDS //
    public static List<IShape> selectedShapeList = new ArrayList<>();
    public static List<IShape>selectedGroupList = new ArrayList<>();

    // METHODS //
    public static void add(IShape shape) {
        PaintCanvas paintCanvas = PaintCanvas.getInstance();
        if (shape.getSize() > 1 && !selectedGroupList.contains(shape)) selectedGroupList.add(shape);
        else if (!selectedShapeList.contains(shape)) selectedShapeList.add(shape);
        paintCanvas.repaint();
    }

    public static void remove(IShape shape) {
        if (!SelectedShapeList.getList().contains(shape))
            return;
        PaintCanvas paintCanvas = PaintCanvas.getInstance();
        if (shape.getSize() > 1) selectedGroupList.remove(shape);
        else selectedShapeList.remove(shape);
        selectedShapeList.remove(shape);
        paintCanvas.repaint();
    }

    public static List<IShape> getList() {
        List<IShape> selectedList = new ArrayList<>(selectedShapeList);
        selectedList.addAll(selectedGroupList);
        return selectedList;
    }

    public static void print() {
        System.out.println(selectedShapeList.size());
        for (IShape shape : selectedShapeList)
            System.out.println("selected: " + shape);
    }
}
