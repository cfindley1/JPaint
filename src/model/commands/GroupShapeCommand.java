package model.commands;

import model.CommandHistory;
import model.SelectedShapeList;
import model.ShapeGroupConfiguration;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.shapes.ShapeGroup;

import java.util.ArrayList;


public class GroupShapeCommand implements IUndoable, ICommand {

    // Fields
    ShapeGroup shapeGroupReference;

    // Constructor
    public GroupShapeCommand() {}

    // Methods
    @Override
    public void execute() {
        ShapeGroupConfiguration groupedShapes = new ShapeGroupConfiguration();
        for (IShape shape : SelectedShapeList.selectedShapeList) {
            groupedShapes.add(shape);
        }
        ShapeGroup shapeGroup = new ShapeGroup(groupedShapes);
        shapeGroupReference = shapeGroup;
        for (IShape shape : groupedShapes.getList())
            shape.setGroup(shapeGroup);
        ShapeList.add(shapeGroup);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : shapeGroupReference.getShapeConfig().getList()) {
            shape.setGroup();
        }
        ShapeList.remove(shapeGroupReference);
    }

    @Override
    public void redo() {
        ShapeList.add(shapeGroupReference);
    }
}
