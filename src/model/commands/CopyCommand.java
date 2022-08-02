package model.commands;

import model.CopyShapeList;
import model.SelectedShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CopyCommand implements ICommand {
    public void execute() {
        for (IShape shape : SelectedShapeList.selectedShapeList)
            CopyShapeList.add(shape);
    }
}
