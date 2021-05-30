package ru.flendger.interview.lesson1.shapes;

public class Circle extends AbstractShape{
    private final int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("Circle draw");
    }

    @Override
    public void moveUp(int up) {
        this.y += up;
        System.out.println("Circle up");
    }

    @Override
    public void moveDown(int down) {
        this.y -= down;
        System.out.println("Circle down");
    }
}
