package model;

import java.awt.Color;

public class Joueur {

    private String pseudo;
    private int points;
    private Color couleur;

    public Joueur(String _pseudo, int _points, Color _couleur) {
        this.pseudo = _pseudo;
        this.points = _points;
        this.couleur = _couleur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String _pseudo) {
        this.pseudo = _pseudo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int _points) {
        this.points = _points;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color _couleur) {
        this.couleur = _couleur;
    }

}
