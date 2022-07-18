package model.shapes;

import model.ShapeConfiguration;
import model.interfaces.IShape;

import java.awt.*;

public class Rectangle implements IShape {
    // Fields
    public ShapeConfiguration shapeConfiguration;

    // Constructor
    public Rectangle(ShapeConfiguration shapeConfiguration) {
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void draw(Graphics2D g) {

        switch(shapeConfiguration.shapeShadingType) {
            case FILLED_IN:
                g.setColor(shapeConfiguration.shapeColorPrimary);
                g.fillRect(shapeConfiguration.firstPoint.getX(), shapeConfiguration.firstPoint.getY(), shapeConfiguration.width, shapeConfiguration.height);
                break;
            case OUTLINE:
                System.out.println("outline");
                break;
            case OUTLINE_AND_FILLED_IN:
                System.out.println("Outline and Filed in");
                break;
        }
    }
}
