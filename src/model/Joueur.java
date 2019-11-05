package model;

import java.awt.Color;

public class Joueur {

    private String pseudo;
    private int points;
    private Color couleur;

    public Joueur(String pseudo_, int points_, Color couleur_) {
        this.pseudo = pseudo_;
        this.points = points_;
        this.couleur = couleur_;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo_) {
        this.pseudo = pseudo_;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points_) {
        this.points = points_;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur_) {
        this.couleur = couleur_;
    }

}
