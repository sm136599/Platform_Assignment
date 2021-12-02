package edu.pnu.shape;

public class Circle extends Shape{
    private final Point center;
    private final int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return radius*radius*(float)Math.PI;
    }

    @Override
    public String toString() {
        return String.format("[Circle [%d, %d], radius: %d area: %.2f]", center.getX(), center.getY(), radius, getArea());
    }
}
