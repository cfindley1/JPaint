package model.interfaces;

import model.Point;
import model.ShapeConfiguration;

public interface ITransformStrategy {
    IShape transform(ShapeConfiguration shape, Point p1, Point p2, int deltaX, int deltaY);
}
