package model;

import java.awt.Color;
import java.util.LinkedList;

public class Joueur {

    private String pseudo;
    private Color couleur;
    private Adjacence adjacence;

    public Joueur(String _pseudo, Color _couleur) {
        this.pseudo = _pseudo;
        this.couleur = _couleur;
        this.adjacence = new Adjacence();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String _pseudo) {
        this.pseudo = _pseudo;
    }

    public int getPoints() {
        return adjacence.getScore();
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color _couleur) {
        this.couleur = _couleur;
    }

    public int scoreGroupe(Case composante){
        return this.adjacence.getScore(composante);
    }

    public void ajouterCase(Case newCase, LinkedList<Case> voisins){
        this.adjacence.add(newCase,voisins);
    }

}
