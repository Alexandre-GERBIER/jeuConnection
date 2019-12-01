package model;

import java.awt.*;

public class Case {

    private int x, y, valeur;
    private Color couleur;
    private Case parent;

    public Case(int _x, int _y, int _value, Color _color) {
        this.x = _x;
        this.y = _y;
        this.valeur = _value;
        this.couleur = _color;
        this.parent = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int _value) {
        this.valeur = _value;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color _color) {
        this.couleur = _color;
    }

    public void setParent(Case newParent){
        this.parent = newParent;
    }

    public Case getParent(){
        return this.parent;
    }

}
