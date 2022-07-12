package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseHandler;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Main {
    public static void main(String[] args){

        //Instantiate GUI
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        // Add mouse handler to paint canvas GUI
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        MouseHandler mouseHandler = new MouseHandler(graphics2d);
        paintCanvas.addMouseListener(mouseHandler);
    }
}