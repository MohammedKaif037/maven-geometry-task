package com.geometry.shapes;

/**
 * Represents a Circle shape.
 * Version 1.1.0: Added validation and improved toString.
 */
public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive, got: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getShapeName() {
        return "Circle(radius=" + radius + ")";
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return describe();
    }
}
