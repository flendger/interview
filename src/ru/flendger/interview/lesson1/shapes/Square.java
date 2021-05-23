package ru.flendger.interview.lesson1.shapes;

public class Square extends AbstractShape{
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int x4;
    private int y4;

    public Square(int x, int y, int length) {
        super(x, y);
        this.x2 = x + length;
        this.y2 = y;
        this.x3 = x + length;
        this.y3 = y + length;
        this.x4 = x;
        this.y4 = y + length;
    }

    @Override
    public void draw() {
        System.out.println("Square draw");
    }

    @Override
    public void moveUp(int up) {
        this.y += up;
        this.y2 += up;
        this.y3 += up;
        this.y4 += up;
        System.out.println("Square up");
    }

    @Override
    public void moveDown(int down) {
        this.y -= down;
        this.y2 -= down;
        this.y3 -= down;
        this.y4 -= down;
        System.out.println("Square down");
    }
}
