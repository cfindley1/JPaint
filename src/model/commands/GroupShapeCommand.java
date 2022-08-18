package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
import model.ShapeGroupConfiguration;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.shapes.ShapeGroup;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;


public class GroupShapeCommand implements IUndoable, ICommand {

    // Fields
    ShapeGroup shapeGroupReference;
    List<IShape> groupedShapeList = new ArrayList<>();

    PaintCanvas paintCanvas = PaintCanvas.getInstance();

    // Constructor
    public GroupShapeCommand() {}

    // Methods
    @Override
    public void execute() {
        ShapeGroup newShapeGroup = new ShapeGroup();
        // There's no point in grouping 1 shape -- thus return
        if (SelectedShapeList.getList().size() <= 1) return;

        for (IShape shape : SelectedShapeList.getList()) {
            // Set the new group for each IShape
            shape.setGroup(newShapeGroup);
            // Add shapes to group and record which shapes added
            newShapeGroup.add(shape);
            groupedShapeList.add(shape);
        }
        shapeGroupReference = newShapeGroup;
        ShapeList.add(newShapeGroup);
        SelectedShapeList.add(newShapeGroup);
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : groupedShapeList) {
            shape.removeGroup(shapeGroupReference);
        }
        ShapeList.remove(shapeGroupReference);
        SelectedShapeList.remove(shapeGroupReference);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (IShape shape : groupedShapeList) {
            shape.setGroup(shapeGroupReference);
        }
        ShapeList.add(shapeGroupReference);
        SelectedShapeList.add(shapeGroupReference);
        paintCanvas.repaint();
    }
}
