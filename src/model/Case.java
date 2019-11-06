package model;

import java.awt.*;

public class Case {

    private int x, y, value;
    private Color color;
    private Case parent;

    public Case(int _x, int _y, int _value, Color _color) {
        this.x = _x;
        this.y = _y;
        this.value = _value;
        this.color = _color;
        this.parent = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int _x) {
        this.x = _x;
    }

    public int getY() {
        return y;
    }

    public void setY(int _y) {
        this.y = _y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int _value) {
        this.value = _value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color _color) {
        this.color = _color;
    }

    public void setParent(Case newParent){
        this.parent = newParent;
    }

    public Case getParent(){
        return this.parent;
    }

}
