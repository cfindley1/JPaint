package model.interfaces;

import model.Point;

public interface ITransformStrategy {
     void transform(Point p1, Point p2, int deltaX, int deltaY);
}
