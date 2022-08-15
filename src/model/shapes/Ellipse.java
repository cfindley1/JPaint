package model.shapes;

import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Ellipse extends Shape implements IShape {
    private ShapeConfiguration shape;
    private int x;
    private int y;
    private int width;
    private int height;

    // Constructor
    public Ellipse(ShapeConfiguration shape) {
        super();
        this.shape = shape;
        this.x = shape.getX();
        this.y = shape.getY();
        this.width = shape.width;
        this.height = shape.height;
    }

    @Override
    public void draw(Graphics2D g) {
        // Determine Shading Mode and Draw
        switch (shape.shapeShadingType) {
            case FILLED_IN -> {
                g.setColor(shape.shapeColorPrimary);
                g.fillOval(x, y, width, height);
            }
            case OUTLINE -> {
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorPrimary);
                g.drawOval(x, y, width, height);
            }
            case OUTLINE_AND_FILLED_IN -> {
                g.setColor(shape.shapeColorPrimary);
                g.fillOval(x, y, width, height);
                g.setStroke(new BasicStroke(5));
                g.setColor(shape.shapeColorSecondary);
                g.drawOval(x, y, width, height);
            }
        }
    }

    public void selectDraw(Graphics2D g) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
    }

    public ShapeConfiguration getShapeConfig() {
        return this.shape;
    }
}
