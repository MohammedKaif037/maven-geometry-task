package com.geometry.utils;

import com.geometry.shapes.Shape;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for comparing and sorting geometric shapes.
 * v1.0.0-SNAPSHOT: compareByArea, compareByPerimeter.
 * v1.1.0-SNAPSHOT: sortByArea, sortByPerimeter, largestByArea, statistics.
 */
public final class ShapeComparator {

    private ShapeComparator() { /* static utility class */ }

    /** Comparators */
    public static final Comparator<Shape> BY_AREA      =
        Comparator.comparingDouble(Shape::calculateArea);
    public static final Comparator<Shape> BY_PERIMETER =
        Comparator.comparingDouble(Shape::calculatePerimeter);

    // ── Comparison (v1.0.0-SNAPSHOT) ─────────────────────────────────

    /**
     * Returns negative if a &lt; b, 0 if equal, positive if a &gt; b (by area).
     */
    public static int compareByArea(Shape a, Shape b) {
        return Double.compare(a.calculateArea(), b.calculateArea());
    }

    public static int compareByPerimeter(Shape a, Shape b) {
        return Double.compare(a.calculatePerimeter(), b.calculatePerimeter());
    }

    /** Returns the shape with the larger area, or a if equal. */
    public static Shape largerByArea(Shape a, Shape b) {
        return compareByArea(a, b) >= 0 ? a : b;
    }

    // ── Sorting (v1.1.0-SNAPSHOT) ─────────────────────────────────────

    public static List<Shape> sortByArea(List<Shape> shapes, boolean ascending) {
        Comparator<Shape> c = ascending ? BY_AREA : BY_AREA.reversed();
        return shapes.stream().sorted(c).collect(Collectors.toList());
    }

    public static List<Shape> sortByPerimeter(List<Shape> shapes, boolean ascending) {
        Comparator<Shape> c = ascending ? BY_PERIMETER : BY_PERIMETER.reversed();
        return shapes.stream().sorted(c).collect(Collectors.toList());
    }

    public static Shape largestByArea(List<Shape> shapes) {
        return shapes.stream()
            .max(BY_AREA)
            .orElseThrow(() -> new IllegalArgumentException("Shape list is empty"));
    }

    // ── Statistics (v1.1.0-SNAPSHOT) ──────────────────────────────────

    public static double totalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::calculateArea).sum();
    }

    public static double averageArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::calculateArea).average().orElse(0);
    }

    public static double totalPerimeter(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::calculatePerimeter).sum();
    }
}
