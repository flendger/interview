package ru.flendger.interview.lesson1.shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapesDemo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(1, 1, 10));
        shapes.add(new Triangle(1, 1, 4, 1, 2, 4));
        shapes.add(new Square(1, 1, 15));
        shapes.forEach(shape -> {
            shape.draw();
            shape.moveDown(10);
            shape.moveUp(5);
        });
    }
}
