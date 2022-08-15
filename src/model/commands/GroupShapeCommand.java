package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.shapes.ShapeGroup;


public class GroupShapeCommand implements IUndoable, ICommand {

    // Fields
    ShapeGroup shapeGroup = new ShapeGroup();

    // Constructor
    public GroupShapeCommand() {
    }

    // Methods
    @Override
    public void execute() {
        for (IShape shape : SelectedShapeList.selectedShapeList) {
            shapeGroup.add(shape);
            System.out.println(shape);
        }
        ShapeList.add(shapeGroup);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ShapeList.remove(shapeGroup);
    }

    @Override
    public void redo() {
        ShapeList.add(shapeGroup);
    }
}
