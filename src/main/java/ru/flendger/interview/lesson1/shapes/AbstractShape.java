package ru.flendger.interview.lesson1.shapes;

public abstract class AbstractShape implements Shape{
    protected int x;
    protected int y;

    public AbstractShape(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
