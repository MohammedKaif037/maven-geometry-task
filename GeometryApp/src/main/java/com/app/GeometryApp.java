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

public class GeometryApp {

    public static void main(String[] args) {
        printBanner();
        demo2DShapes();
        demoUnitConversion();
        demoShapeComparison();
        demo3DShapes();
    }

    private static void printBanner() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║            G E O M E T R Y   A P P  v1.0            ║");
        System.out.println("║  geometry-core        v1.1.0                        ║");
        System.out.println("║  geometry-utils       v1.1.0-SNAPSHOT               ║");
        System.out.println("║  three-dimensional    v1.1.0-SNAPSHOT               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static void demo2DShapes() {
        System.out.println("── 2D SHAPES (geometry-core v1.1.0) " + "─".repeat(20));
        
        Circle circle = new Circle(7.0);
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        Rectangle square = new Rectangle(4.0, 4.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        Triangle equilateralTriangle = new Triangle(6.0, 6.0, 6.0);
        
        List<Shape> shapes = Arrays.asList(circle, rectangle, square, triangle, equilateralTriangle);
        for (Shape shape : shapes) {
            System.out.println("  " + shape);
        }
        System.out.println();
    }

    private static void demoUnitConversion() {
        System.out.println("── UNIT CONVERSION (geometry-utils v1.1.0-SNAPSHOT) " + "─".repeat(7));
        
        Circle myCircle = new Circle(7.0);
        double areaInSqMeters = myCircle.calculateArea();
        System.out.printf("  Circle area: %.4f m²%n", areaInSqMeters);
        System.out.printf("    → %.4f ft²%n", UnitConverter.squareMetersToSquareFeet(areaInSqMeters));
        System.out.printf("    → %.4f cm²%n", UnitConverter.squareMetersToCm2(areaInSqMeters));
        
        double lengthValue = 2.5;
        System.out.printf("%n  Length: %.2f m%n", lengthValue);
        System.out.printf("    → %.4f cm%n", UnitConverter.metersToCentimeters(lengthValue));
        System.out.printf("    → %.4f inches%n", UnitConverter.metersToInches(lengthValue));
        System.out.printf("    → %.4f feet%n", UnitConverter.metersToFeet(lengthValue));
        
        Sphere testSphere = new Sphere(3.0);
        double sphereVolume = testSphere.calculateVolume();
        System.out.printf("%n  Sphere volume: %.4f m³%n", sphereVolume);
        System.out.printf("    → %.4f ft³%n", UnitConverter.cubicMetersToCubicFeet(sphereVolume));
        System.out.printf("    → %.4f cm³%n", UnitConverter.cubicMetersToCubicCm(sphereVolume));
        System.out.println();
    }

    private static void demoShapeComparison() {
        System.out.println("── SHAPE COMPARISON & STATISTICS (geometry-utils v1.1.0-SNAPSHOT) " + "─".repeat(2));
        
        List<Shape> sampleShapes = Arrays.asList(
            new Circle(5),
            new Rectangle(3, 8),
            new Triangle(6, 8, 10),
            new Circle(2),
            new Rectangle(7, 7)
        );
        
        System.out.println("  Sorted by area (ascending):");
        List<Shape> sortedByArea = ShapeComparator.sortByArea(sampleShapes, true);
        for (Shape shape : sortedByArea) {
            System.out.printf("    %-45s area=%.4f%n", shape.getShapeName(), shape.calculateArea());
        }
        
        System.out.println("\n  Sorted by perimeter (descending):");
        List<Shape> sortedByPerimeter = ShapeComparator.sortByPerimeter(sampleShapes, false);
        for (Shape shape : sortedByPerimeter) {
            System.out.printf("    %-45s perimeter=%.4f%n", shape.getShapeName(), shape.calculatePerimeter());
        }
        
        Shape biggestShape = ShapeComparator.largestByArea(sampleShapes);
        System.out.printf("%n  Largest by area: %s%n", biggestShape.getShapeName());
        System.out.printf("  Total area:      %.4f%n", ShapeComparator.totalArea(sampleShapes));
        System.out.printf("  Average area:    %.4f%n", ShapeComparator.averageArea(sampleShapes));
        System.out.printf("  Total perimeter: %.4f%n", ShapeComparator.totalPerimeter(sampleShapes));
        System.out.println();
    }

    private static void demo3DShapes() {
        System.out.println("── 3D SHAPES (three-dimensional-shapes v1.1.0-SNAPSHOT) " + "─".repeat(7));
        
        List<SolidShape> threeDObjects = Arrays.asList(
            new Cube(4.0),
            new Sphere(3.0),
            new Cylinder(2.5, 6.0)
        );
        
        for (SolidShape solid : threeDObjects) {
            System.out.println("  " + solid);
        }
        
        System.out.println();
        System.out.println("  Volume summary:");
        for (SolidShape solid : threeDObjects) {
            System.out.printf("    %-40s  vol=%.4f  sa=%.4f%n", 
                solid.getShapeName(), solid.calculateVolume(), solid.calculateSurfaceArea());
        }
        
        Cube exampleCube = new Cube(4.0);
        double cubeVolume = exampleCube.calculateVolume();
        System.out.printf("%n  Cube volume %.2f m³ → %.4f ft³%n", 
            cubeVolume, UnitConverter.cubicMetersToCubicFeet(cubeVolume));
        System.out.println();
    }
    
    private static void section(String title) {
        System.out.println("── " + title + " " + "─".repeat(Math.max(0, 54 - title.length())));
    }
}
