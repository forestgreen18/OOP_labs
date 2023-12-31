package edu.labs.lab4.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {

  private double startX;
  private double startY;
  private double endX;
  private double endY;

  // Constructor
  public Shape(double startX, double startY, double endX, double endY) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  // Getters and setters
  public double getStartX() {
    return startX;
  }

  public void setStartX(double x) {
    this.startX = x;
  }

  public double getStartY() {
    return startY;
  }

  public void setStartY(double y) {
    this.startY = y;
  }

  public double getEndX() {
    return endX;
  }

  public void setEndX(double x) {
    this.endX = x;
  }

  public double getEndY() {
    return endY;
  }

  public void setEndY(double y) {
    this.endY = y;
  }

  public abstract void draw(GraphicsContext gc);

  public abstract void draw(GraphicsContext gc, Color strokeColor);

  public abstract void drawPreviewShape(double startX, double startY, double endX, double endY);

  @Override
  public abstract Shape clone();
}
