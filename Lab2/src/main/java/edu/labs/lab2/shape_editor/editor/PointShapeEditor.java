package edu.labs.lab2.shape_editor.editor;

import edu.labs.lab2.shape_editor.ShapeObjectsEditor;
import edu.labs.lab2.shape_editor.shapes.PointShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class PointShapeEditor extends ShapeEditor {
    private ShapeObjectsEditor shapeObjectsEditor;
    private GraphicsContext gc;
    private PointShape pointShape;


    public PointShapeEditor(ShapeObjectsEditor shapeObjectsEditor, GraphicsContext gc) {
        super(shapeObjectsEditor, gc);
        this.shapeObjectsEditor = shapeObjectsEditor;
        this.gc = gc;
        this.pointShape = new PointShape(0, 0, gc);
    }

    @Override
    public void processMouseEvent(MouseEvent event) {
        super.processMouseEvent(event);
        double x = event.getX();
        double y = event.getY();
        switch (event.getEventType().getName()) {
            case "MOUSE_PRESSED":
                shapeObjectsEditor.setDrawing(true);
                shapeObjectsEditor.setStartX(x);
                shapeObjectsEditor.setStartY(y);
                shapeObjectsEditor.setEndX(x);
                shapeObjectsEditor.setEndY(y);
                break;
            case "MOUSE_RELEASED":
                shapeObjectsEditor.setDrawing(false);
                saveShape();
                break;
        }
    }

    @Override
    public void saveShape() {
        double x = shapeObjectsEditor.getStartX();
        double y = shapeObjectsEditor.getStartY();

        PointShape point = new PointShape(x, y, gc);
        shapeObjectsEditor.addShape(point);
    }

    @Override
    public void drawSolidShape(double x, double y, double endX, double endY) {
        pointShape.setX(x);
        pointShape.setY(y);
        pointShape.draw(gc);
    }
}
