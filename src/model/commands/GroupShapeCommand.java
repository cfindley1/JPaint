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
    List<ShapeGroup> groupList = new ArrayList<ShapeGroup>();

    PaintCanvas paintCanvas = PaintCanvas.getInstance();

    // Constructor
    public GroupShapeCommand() {}

    // Methods
    @Override
    public void execute() {
        ShapeGroupConfiguration groupedShapes = new ShapeGroupConfiguration();
        for (IShape shape : SelectedShapeList.selectedShapeList) {
            System.out.println(shape);
            groupedShapes.add(shape);
            groupList.add(shape.getGroup());
        }
        ShapeGroup shapeGroup = new ShapeGroup(groupedShapes);
        shapeGroupReference = shapeGroup;
        for (IShape shape : groupedShapes.getList()) {
            System.out.println(shape);
            shape.setGroup(shapeGroup);
        }
        ShapeList.add(shapeGroup);
        paintCanvas.repaint();
        CommandHistory.add(this);
        System.out.println("execute done");
    }

    @Override
    public void undo() {
        for (ShapeGroup group : groupList) {
            for (IShape shape : shapeGroupReference.getShapeConfig().getList()) {
                shape.setGroup(group);
            }
        }
        ShapeList.remove(shapeGroupReference);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (ShapeGroup group : groupList) {
            for (IShape shape : shapeGroupReference.getShapeConfig().getList()) {
                shape.setGroup(group);
            }
        }
        ShapeList.add(shapeGroupReference);
        paintCanvas.repaint();
    }
}
