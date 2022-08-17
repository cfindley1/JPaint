package model;

import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;
import model.interfaces.ITransformStrategy;

public class TransformMove implements ITransformStrategy {

    @Override
    public IShape transform(IShapeConfiguration shape, Point p1, Point p2, int deltaX, int deltaY) {
        p1.transformXAndY(deltaX, deltaY);
        p2.transformXAndY(deltaX, deltaY);
        return null;
    }
}
