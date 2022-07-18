package model.interfaces;

public interface IShapeFactory {
    IShape createEllipse();
    IShape createTriangle();
    IShape createRectangle();
}
