# JPaint

## “MS Paint”-like application in Java


## Link to Repository:
[JPaint Repository](hhttps://github.com/cfindley1/JPaint)


## Design Patterns:

### 1. Command Pattern

**Interfaces:**
- ICommand in src/model/interfaces

**Classes:**
- All classes that implement ICommand are in src/model/commands



### 2. Abstract Factory Pattern

**Abstract Class:**
- AbstractFactory in src/model

**Classes:**
- ShapeFactory extends AbstractFactory



### 3. Strategy Pattern

**Interfaces:**
- ITransformStrategy in src/model/interfaces

**Implementing Classes:**
- TransformContext, TransformMove, and TransformPaste in src/model

**Classes that use pattern:**
- PasteCommand and MoveCommand in src/model/commands



### 4. Singleton Pattern

Class with Singleton Instance:
- PaintCanvas in src/view/gui

Classes that use Singleton:
- Main
- ICommands: DeleteCommand, DrawShapeCommand, GroupShapeCommand, MoveCommand, PasteCommand, SelectCommand, and UngroupShapeCommand in src/model/commands



### 5. Composite Pattern

**Interfaces:**
- IShape in src/model/interfaces

**Classes that implement IShape:**
- Shape and ShapeGroup in src/model/shapes

**Classes that use IShape and demonstrate pattern:**
- SelectCommand in src/model/commands
- SelectShapeList in src/model
- Method PaintCanvas.paint() in src/view/gui

