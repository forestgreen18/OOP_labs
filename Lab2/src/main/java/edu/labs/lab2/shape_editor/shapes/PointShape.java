package edu.labs.lab2.shape_editor.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PointShape extends Shape {
    private double x;
    private double y;
    private GraphicsContext gc;

    public PointShape(double x, double y, GraphicsContext gc) {
        super(x, y, x, y); // For a point, startX = endX and startY = endY
        this.x = x;
        this.y = y;
        this.gc = gc;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillOval(x - 2.5, y - 2.5, 5, 5); // Draw a small circle to represent the point
    }
}
