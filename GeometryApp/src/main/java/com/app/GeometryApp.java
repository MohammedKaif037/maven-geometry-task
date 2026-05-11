package com.app;

import com.geometry.shapes.Circle;
import com.geometry.shapes.Rectangle;
import com.geometry.shapes.Shape;
import com.geometry.shapes.Triangle;
import com.geometry.threed.Cube;
import com.geometry.threed.Cylinder;
import com.geometry.threed.Sphere;
import com.geometry.threed.SolidShape;
import com.geometry.utils.ShapeComparator;
import com.geometry.utils.UnitConverter;

import java.util.Arrays;
import java.util.List;

/**
 * GeometryApp — demonstrates GeometryLibrary (v1.1.0) capabilities:
 *   • 2D shapes  (geometry-core  v1.1.0)
 *   • Utilities  (geometry-utils v1.1.0-SNAPSHOT)
 *   • 3D shapes  (three-dimensional-shapes v1.1.0-SNAPSHOT)
 */
public class GeometryApp {

    public static void main(String[] args) {
        printBanner();
        demo2DShapes();
        demoUnitConversion();
        demoShapeComparison();
        demo3DShapes();
    }

    // ── Banner ────────────────────────────────────────────────────────

    private static void printBanner() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║            G E O M E T R Y   A P P  v1.0            ║");
        System.out.println("║  geometry-core        v1.1.0                        ║");
        System.out.println("║  geometry-utils       v1.1.0-SNAPSHOT               ║");
        System.out.println("║  three-dimensional    v1.1.0-SNAPSHOT               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();
    }

    // ── 2D Shapes ─────────────────────────────────────────────────────

    private static void demo2DShapes() {
        section("2D SHAPES (geometry-core v1.1.0)");

        Circle    circle    = new Circle(7.0);
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        Rectangle square    = new Rectangle(4.0, 4.0);
        Triangle  triangle  = new Triangle(3.0, 4.0, 5.0);  // right triangle
        Triangle  equi      = new Triangle(6.0, 6.0, 6.0);

        List<Shape> shapes = Arrays.asList(circle, rectangle, square, triangle, equi);
        shapes.forEach(s -> System.out.println("  " + s));
        System.out.println();
    }

    // ── Unit Conversion (geometry-utils) ──────────────────────────────

    private static void demoUnitConversion() {
        section("UNIT CONVERSION (geometry-utils v1.1.0-SNAPSHOT)");

        double areaM2 = new Circle(7.0).calculateArea();
        System.out.printf("  Circle area: %.4f m²%n", areaM2);
        System.out.printf("    → %.4f ft²%n",  UnitConverter.squareMetersToSquareFeet(areaM2));
        System.out.printf("    → %.4f cm²%n",  UnitConverter.squareMetersToCm2(areaM2));

        double lengthM = 2.5;
        System.out.printf("%n  Length: %.2f m%n", lengthM);
        System.out.printf("    → %.4f cm%n",     UnitConverter.metersToCentimeters(lengthM));
        System.out.printf("    → %.4f inches%n", UnitConverter.metersToInches(lengthM));
        System.out.printf("    → %.4f feet%n",   UnitConverter.metersToFeet(lengthM));

        // v1.1.0-SNAPSHOT: volume conversion
        double volM3 = new Sphere(3.0).calculateVolume();
        System.out.printf("%n  Sphere volume: %.4f m³%n", volM3);
        System.out.printf("    → %.4f ft³%n",   UnitConverter.cubicMetersToCubicFeet(volM3));
        System.out.printf("    → %.4f cm³%n",   UnitConverter.cubicMetersToCubicCm(volM3));
        System.out.println();
    }

    // ── Shape Comparison & Statistics ─────────────────────────────────

    private static void demoShapeComparison() {
        section("SHAPE COMPARISON & STATISTICS (geometry-utils v1.1.0-SNAPSHOT)");

        List<Shape> shapes = Arrays.asList(
            new Circle(5),
            new Rectangle(3, 8),
            new Triangle(6, 8, 10),
            new Circle(2),
            new Rectangle(7, 7)
        );

        System.out.println("  Sorted by area (ascending):");
        ShapeComparator.sortByArea(shapes, true)
            .forEach(s -> System.out.printf("    %-45s area=%.4f%n",
                s.getShapeName(), s.calculateArea()));

        System.out.println("\n  Sorted by perimeter (descending):");
        ShapeComparator.sortByPerimeter(shapes, false)
            .forEach(s -> System.out.printf("    %-45s perimeter=%.4f%n",
                s.getShapeName(), s.calculatePerimeter()));

        Shape largest = ShapeComparator.largestByArea(shapes);
        System.out.printf("%n  Largest by area: %s%n", largest.getShapeName());
        System.out.printf("  Total area:      %.4f%n", ShapeComparator.totalArea(shapes));
        System.out.printf("  Average area:    %.4f%n", ShapeComparator.averageArea(shapes));
        System.out.printf("  Total perimeter: %.4f%n", ShapeComparator.totalPerimeter(shapes));
        System.out.println();
    }

    // ── 3D Shapes ─────────────────────────────────────────────────────

    private static void demo3DShapes() {
        section("3D SHAPES (three-dimensional-shapes v1.1.0-SNAPSHOT)");

        List<SolidShape> solids = Arrays.asList(
            new Cube(4.0),
            new Sphere(3.0),
            new Cylinder(2.5, 6.0)   // added in v1.1.0-SNAPSHOT
        );

        solids.forEach(s -> System.out.println("  " + s));

        System.out.println();
        System.out.println("  Volume summary:");
        solids.forEach(s -> System.out.printf("    %-40s  vol=%.4f  sa=%.4f%n",
            s.getShapeName(), s.calculateVolume(), s.calculateSurfaceArea()));

        // Unit-convert a 3D volume
        double cubeVol = new Cube(4.0).calculateVolume();
        System.out.printf("%n  Cube volume %.2f m³ → %.4f ft³%n",
            cubeVol, UnitConverter.cubicMetersToCubicFeet(cubeVol));
        System.out.println();
    }

    // ── Helper ────────────────────────────────────────────────────────

    private static void section(String title) {
        System.out.println("── " + title + " " + "─".repeat(Math.max(0, 54 - title.length())));
    }
}
