package com.geometry.shapes;

/**
 * Represents a Rectangle shape.
 * Version 1.1.0: Added validation and isSquare() helper.
 */
public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                "Width and height must be positive, got: width=" + width + ", height=" + height);
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getShapeName() {
        return "Rectangle(width=" + width + ", height=" + height + ")";
    }

    public double getWidth()  { return width; }
    public double getHeight() { return height; }

    /** Returns true if this rectangle is a square. */
    public boolean isSquare() {
        return Double.compare(width, height) == 0;
    }

    @Override
    public String toString() {
        return describe() + (isSquare() ? " [Square]" : "");
    }
}
