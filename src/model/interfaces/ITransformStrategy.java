package model.interfaces;

import model.Point;
import model.ShapeConfiguration;
import model.persistence.ApplicationState;

public interface ITransformStrategy {
     IShape transform(ShapeConfiguration shape, Point p1, Point p2, int deltaX, int deltaY);
}
