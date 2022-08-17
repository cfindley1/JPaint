package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;
import model.interfaces.ITransformStrategy;

public class TransformContext {
    private ITransformStrategy strategy;

    public TransformContext(ITransformStrategy strategy) {
        this.strategy = strategy;
    }

    public IShape execute(IShape shape, int deltaX, int deltaY) {
        IShapeConfiguration shapeConfig =  shape.getShapeConfig();
        Point p1 = shapeConfig.getFirstPoint();
        Point p2 = shapeConfig.getLastPoint();
        return strategy.transform(shapeConfig, p1, p2, deltaX, deltaY);
    }
}
