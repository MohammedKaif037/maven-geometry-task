package com.geometry.threed;

/**
 * Interface for three-dimensional geometric shapes.
 * Extends the notion of Shape with volume and surface area.
 * v1.1.0-SNAPSHOT: added default describe() override including volume.
 */
public interface SolidShape {
    /** Surface area of the 3D shape. */
    double calculateSurfaceArea();

    /** Volume of the 3D shape. */
    double calculateVolume();

    /** Name of the solid shape. */
    String getShapeName();

    default String describe() {
        return String.format(
            "%s -> Surface Area: %.4f | Volume: %.4f",
            getShapeName(),
            calculateSurfaceArea(),
            calculateVolume()
        );
    }
}
