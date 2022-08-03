package model;

import model.interfaces.IShape;
import model.interfaces.ITransformStrategy;
import model.persistence.ApplicationState;

public class TransformMove implements ITransformStrategy {

    @Override
    public IShape transform(ShapeConfiguration shape, Point p1, Point p2, int deltaX, int deltaY) {
        p1.transformXAndY(deltaX, deltaY);
        p2.transformXAndY(deltaX, deltaY);
        return null;
    };
}
