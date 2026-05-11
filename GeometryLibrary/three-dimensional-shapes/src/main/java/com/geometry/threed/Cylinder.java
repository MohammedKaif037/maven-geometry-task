package com.geometry.threed;

/**
 * Represents a Cylinder.
 * Added in v1.1.0-SNAPSHOT.
 */
public class Cylinder implements SolidShape {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                "Radius and height must be positive, got: radius=" + radius + ", height=" + height);
        }
        this.radius = radius;
        this.height = height;
    }

    /** Surface area = 2πr(r + h) */
    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    /** Volume = π * r^2 * h */
    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String getShapeName() {
        return "Cylinder(radius=" + radius + ", height=" + height + ")";
    }

    public double getRadius() { return radius; }
    public double getHeight() { return height; }

    @Override
    public String toString() {
        return describe();
    }
}
