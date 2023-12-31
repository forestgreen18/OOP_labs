package edu.labs.lab3.shape_editor.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class EllipseShape extends Shape {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private GraphicsContext gc;

    public EllipseShape(double startX, double startY, double endX, double endY, GraphicsContext gc) {
        super(startX, startY, endX, endY);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.gc = gc;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }


    @Override
    public void draw(GraphicsContext gc) {
        double centerX = (startX + endX) / 2;
        double centerY = (startY + endY) / 2;
        double width = Math.abs(startX - endX);
        double height = Math.abs(startY - endY);

        gc.setFill(Color.CYAN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeOval(centerX - width / 2, centerY - height / 2, width, height);
        gc.fillOval(centerX - width / 2, centerY - height / 2, width, height);
    }

    public void draw(GraphicsContext gc, Color strokeColor) {
        double centerX = (startX + endX) / 2;
        double centerY = (startY + endY) / 2;
        double width = Math.abs(startX - endX);
        double height = Math.abs(startY - endY);

        gc.setFill(Color.CYAN);
        gc.setStroke(strokeColor);
        gc.setLineWidth(1);
        gc.strokeOval(centerX - width / 2, centerY - height / 2, width, height);
        gc.fillOval(centerX - width / 2, centerY - height / 2, width, height);
    }

}

