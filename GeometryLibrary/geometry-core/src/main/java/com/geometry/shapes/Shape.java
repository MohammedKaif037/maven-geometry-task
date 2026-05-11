package com.geometry.shapes;

/**
 * Common interface for all geometric shapes.
 * Defines the contract for area and perimeter calculations.
 */
public interface Shape {
    /**
     * Calculates the area of the shape.
     * @return area as a double
     */
    double calculateArea();

    /**
     * Calculates the perimeter of the shape.
     * @return perimeter as a double
     */
    double calculatePerimeter();

    /**
     * Returns the name of the shape.
     * @return shape name
     */
    String getShapeName();

    /**
     * Returns a formatted description with area and perimeter.
     */
    default String describe() {
        return String.format(
            "%s -> Area: %.4f | Perimeter: %.4f",
            getShapeName(),
            calculateArea(),
            calculatePerimeter()
        );
    }
}
