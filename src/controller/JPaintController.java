package controller;

import model.commands.CopyCommand;
import model.commands.PasteCommand;
import model.commands.RedoCommand;
import model.commands.UndoCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> {
            UndoCommand command = new UndoCommand();
            command.execute();
        });
        uiModule.addEvent(EventName.REDO, () -> {
            RedoCommand command = new RedoCommand();
            command.execute();
        });
        uiModule.addEvent(EventName.COPY, () -> {
            CopyCommand command = new CopyCommand();
            command.execute();
        });
        uiModule.addEvent(EventName.PASTE, () -> {
            PasteCommand command = new PasteCommand();
            command.execute();
        });
        uiModule.addEvent(EventName.GROUP, () -> {

        });
        uiModule.addEvent(EventName.UNGROUP, () -> {

        });
    }
}
