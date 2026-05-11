# GeometryMavenProject

A Maven multi-module project demonstrating 2D/3D geometric shape calculations.

## Modules
- **geometry-core** (v1.1.0) — Circle, Rectangle, Triangle with area and perimeter
- **geometry-utils** (v1.1.0-SNAPSHOT) — Unit conversion and shape comparison utilities
- **three-dimensional-shapes** (v1.1.0-SNAPSHOT) — Cube, Sphere, Cylinder with volume and surface area
- **GeometryApp** (v1.0.0) — Console app that demonstrates all modules

## How to Run
```bash
cd GeometryLibrary && mvn install
cd ../GeometryApp && mvn clean package
java -jar target/geometry-app-1.0.0.jar
```
