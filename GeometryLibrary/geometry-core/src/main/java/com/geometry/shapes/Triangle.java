package com.geometry.shapes;

/**
 * Represents a Triangle shape (defined by three sides).
 * Version 1.1.0: Added triangle validity check and type detection.
 */
public class Triangle implements Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("All sides must be positive.");
        }
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException(
                "Invalid triangle: sides " + sideA + ", " + sideB + ", " + sideC +
                " do not satisfy the triangle inequality.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    /** Uses Heron's formula. */
    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getShapeName() {
        return "Triangle(a=" + sideA + ", b=" + sideB + ", c=" + sideC + ")";
    }

    /** Returns the triangle type: Equilateral, Isosceles, or Scalene. */
    public String getType() {
        if (sideA == sideB && sideB == sideC) return "Equilateral";
        if (sideA == sideB || sideB == sideC || sideA == sideC) return "Isosceles";
        return "Scalene";
    }

    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }

    @Override
    public String toString() {
        return describe() + " [" + getType() + "]";
    }
}
