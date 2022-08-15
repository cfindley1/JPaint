package model.interfaces;

import model.Point;

public interface IShapeConfiguration {
    boolean collides(Point from, Point to);
}
