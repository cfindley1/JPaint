package model;

import java.awt.*;

public class DrawRectangle {
    private Graphics2D graphics2d;

    public DrawRectangle (Graphics2D graphics) {
        this.graphics2d = graphics;
    }
    // Draw Filled in Rectangle
    public void drawShape() {
        graphics2d.setColor(Color.PINK);
        graphics2d.fillRect(12, 13, 200, 400);
    }

}
