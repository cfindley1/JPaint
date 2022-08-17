package model.interfaces;

import model.Point;

public interface IShapeConfiguration {
    boolean collides(Point from, Point to);

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    Point getFirstPoint();

    Point getLastPoint();
}
