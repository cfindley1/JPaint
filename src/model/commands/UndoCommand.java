package model.commands;

import model.CommandHistory;
import model.interfaces.ICommand;

public class UndoCommand implements ICommand {

    @Override
    public void execute() {
        CommandHistory.undo();
    }
}
