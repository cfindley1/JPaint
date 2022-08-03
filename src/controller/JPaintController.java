package controller;

import model.commands.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private PaintCanvas paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, PaintCanvas paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
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
            PasteCommand command = new PasteCommand(paintCanvas);
            command.execute();
        });
        uiModule.addEvent(EventName.DELETE, () -> {
            DeleteCommand command = new DeleteCommand(paintCanvas);
            command.execute();
        });
        uiModule.addEvent(EventName.GROUP, () -> {

        });
        uiModule.addEvent(EventName.UNGROUP, () -> {

        });
    }
}
