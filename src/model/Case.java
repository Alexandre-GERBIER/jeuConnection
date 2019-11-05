package model;

public class Case {

    private int x, y, value, color;

    public Case(int x_, int y_, int value_, int color_) {
        this.x = x_;
        this.y = y_;
        this.value = value_;
        this.color = color_;
    }

    public int getX() {
        return x;
    }

    public void setX(int x_) {
        this.x = x_;
    }

    public int getY() {
        return y;
    }

    public void setY(int y_) {
        this.y = y_;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value_) {
        this.value = value_;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color_) {
        this.color = color_;
    }

}
