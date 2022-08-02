package model.commands;

import model.Point;
import model.SelectedShapeList;
import model.CopyShapeList;
import model.Shape;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CopyCommand implements ICommand {
    public void execute() {
        for (IShape shape : SelectedShapeList.selectedShapeList)
            CopyShapeList.add(shape);
    }
}
