package com.geometry.threed;

/**
 * Represents a Cube (all sides equal).
 * v1.0.0-SNAPSHOT: initial implementation.
 * v1.1.0-SNAPSHOT: implements SolidShape interface.
 */
public class Cube implements SolidShape {
    private final double side;

    public Cube(double side) {
        if (side <= 0) throw new IllegalArgumentException("Side must be positive, got: " + side);
        this.side = side;
    }

    /** Surface area = 6 * side^2 */
    @Override
    public double calculateSurfaceArea() {
        return 6 * side * side;
    }

    /** Volume = side^3 */
    @Override
    public double calculateVolume() {
        return side * side * side;
    }

    @Override
    public String getShapeName() {
        return "Cube(side=" + side + ")";
    }

    public double getSide() { return side; }

    @Override
    public String toString() {
        return describe();
    }
}
