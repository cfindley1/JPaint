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
    List<IShape> ungroupedList = new ArrayList<>();
    ShapeGroup shapeGroupReference;

    @Override
    public void execute() {
        // Find highest level group to delete
        for (IShape shape : SelectedShapeList.getList()) {
            ShapeGroup shapeGroup = shape.getGroup();
            if (shapeGroup != null) {
                shapeGroupReference = shapeGroup;
                break;
            }
        }
        for (IShape shape : SelectedShapeList.getList()) {
            ShapeGroup shapeGroup = shape.getGroup();
            // If shape is in a group, save a reference
            if (shapeGroup != null) {
                shape.removeGroup(shapeGroupReference);
                ungroupedList.add(shape);
            }
        }
        ShapeList.remove(shapeGroupReference);
        SelectedShapeList.remove(shapeGroupReference);
        PaintCanvas.getInstance().repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : ungroupedList) {
            shape.setGroup(shapeGroupReference);
        }
        ShapeList.add(shapeGroupReference);
        SelectedShapeList.add(shapeGroupReference);
        PaintCanvas.getInstance().repaint();
    }

    @Override
    public void redo() {
        for (IShape shape : ungroupedList) {
            shape.removeGroup(shapeGroupReference);
        }
        ShapeList.remove(shapeGroupReference);
        SelectedShapeList.remove(shapeGroupReference);
        PaintCanvas.getInstance().repaint();
    }
}
