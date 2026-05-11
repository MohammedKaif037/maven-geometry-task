package com.geometry.utils;

/**
 * Utility class for converting between common measurement units.
 * v1.0.0-SNAPSHOT: basic length/area conversions.
 * v1.1.0-SNAPSHOT: added volume conversions and generic scaling.
 */
public final class UnitConverter {

    private UnitConverter() { /* static utility class */ }

    // ── Length conversions ────────────────────────────────────────────
    public static double metersToCentimeters(double meters)   { return meters * 100; }
    public static double centimetersToMeters(double cm)       { return cm / 100; }
    public static double metersToInches(double meters)        { return meters * 39.3701; }
    public static double inchesToMeters(double inches)        { return inches / 39.3701; }
    public static double metersToFeet(double meters)          { return meters * 3.28084; }
    public static double feetToMeters(double feet)            { return feet / 3.28084; }

    // ── Area conversions ─────────────────────────────────────────────
    public static double squareMetersToSquareFeet(double sqm) { return sqm * 10.7639; }
    public static double squareFeetToSquareMeters(double sqft){ return sqft / 10.7639; }
    public static double squareMetersToCm2(double sqm)        { return sqm * 10_000; }

    // ── Volume conversions (v1.1.0-SNAPSHOT) ─────────────────────────
    public static double cubicMetersToCubicFeet(double m3)    { return m3 * 35.3147; }
    public static double cubicFeetToCubicMeters(double ft3)   { return ft3 / 35.3147; }
    public static double cubicMetersToCubicCm(double m3)      { return m3 * 1_000_000; }

    // ── Generic scaling (v1.1.0-SNAPSHOT) ────────────────────────────
    /**
     * Scales any measurement by a given factor.
     * Useful for converting between arbitrary unit systems.
     */
    public static double scale(double value, double factor)   { return value * factor; }
}
