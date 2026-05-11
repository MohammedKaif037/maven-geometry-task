package com.geometry.threed;

/**
 * Represents a Sphere.
 * v1.0.0-SNAPSHOT: initial implementation.
 * v1.1.0-SNAPSHOT: implements SolidShape interface.
 */
public class Sphere implements SolidShape {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be positive, got: " + radius);
        this.radius = radius;
    }

    /** Surface area = 4 * π * r^2 */
    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    /** Volume = (4/3) * π * r^3 */
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public String getShapeName() {
        return "Sphere(radius=" + radius + ")";
    }

    public double getRadius() { return radius; }

    @Override
    public String toString() {
        return describe();
    }
}
