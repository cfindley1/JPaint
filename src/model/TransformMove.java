package model;

import model.interfaces.ITransformStrategy;

public class TransformMove implements ITransformStrategy {

    @Override
    public void transform(Point p1, Point p2, int deltaX, int deltaY) {
        p1.transformXAndY(deltaX, deltaY);
        p2.transformXAndY(deltaX, deltaY);
    };
}
