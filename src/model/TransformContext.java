package model;

import model.interfaces.ITransformStrategy;

public class TransformContext {
    private ITransformStrategy strategy;

    public TransformContext(ITransformStrategy strategy){
        this.strategy = strategy;
    }

    public void execute(Point p1, Point p2, int deltaX, int deltaY) {
        strategy.transform(p1, p2, deltaX, deltaY);
    }
}
