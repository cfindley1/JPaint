package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.shapes.ShapeGroup;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class UngroupShapeCommand implements IUndoable, ICommand {

    // Fields
    List<IShape> ungroupedShapes = new ArrayList<>();
    List<ShapeGroup> groupList = new ArrayList<>();

    @Override
    public void execute() {
        for (IShape shape : SelectedShapeList.selectedShapeList) {
            if (shape.getGroup() != null) {
                groupList.add(shape.getGroup());
                ungroupedShapes.add(shape);
                ShapeList.remove(shape.getGroup());
                shape.setGroup(null);
            }
        }
        PaintCanvas.getInstance().repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (ShapeGroup group : groupList) {
            for (IShape shape : ungroupedShapes) {
                shape.setGroup(group);
                if (!ShapeList.contains(shape))
                    ShapeList.add(group);
            }
        }
        PaintCanvas.getInstance().repaint();
    }

    @Override
    public void redo() {
        for (IShape shape : ungroupedShapes) {
            ShapeList.remove(shape.getGroup());
            shape.setGroup(null);
        }
        PaintCanvas.getInstance().repaint();
    }
}
