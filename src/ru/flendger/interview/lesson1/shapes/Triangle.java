package ru.flendger.interview.lesson1.shapes;

public class Triangle extends AbstractShape {
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public Triangle(int x, int y, int x2, int y2, int x3, int y3) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw() {
        System.out.println("Triangle draw");
    }

    @Override
    public void moveUp(int up) {
        this.y -= up;
        this.y2 -= up;
        this.y3 -= up;
        System.out.println("Triangle up");
    }

    @Override
    public void moveDown(int down) {
        this.y += down;
        this.y2 += down;
        this.y3 += down;
        System.out.println("Triangle down");
    }
}
