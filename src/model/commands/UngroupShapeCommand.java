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

    @Override
    public void execute() {
        for (IShape shape : SelectedShapeList.getList()) {
            ShapeGroup shapeGroup = shape.getGroup();
            // If shape is in a group, save a reference
            if (shapeGroup != null) {
                ungroupedList.add(shapeGroup);
                ShapeList.remove(shapeGroup);
                SelectedShapeList.remove(shapeGroup);
                shape.removeGroup(shapeGroup);
            }
        }
        PaintCanvas.getInstance().repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() { /*
        for (int i = 0; i < ungroupedList.size(); i++) {
            IShape shape = ungroupedList.get(i);
            shape.setGroup();
            if (!ShapeList.contains(shape)) {
                ShapeList.add(group);
                SelectedShapeList.add(group);
            }
            }
        PaintCanvas.getInstance().repaint();
  */  }

    @Override
    public void redo() { /*
        for (IShape shape : ungroupedShapes) {
            ShapeList.remove(shape.getGroup());
            SelectedShapeList.remove(shape.getGroup());
            shape.setGroup(null);
        }
        PaintCanvas.getInstance().repaint();
    */}
}
