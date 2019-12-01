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

    public int getPoints() { return adjacence.getScore(); }

    public Color getCouleur() {
        return couleur;
    }

    public int scoreGroupe(Case composante){
        return this.adjacence.afficherScore(composante);
    }

    public void ajouterCase(Case newCase, LinkedList<Case> voisins){
        this.adjacence.add(newCase,voisins);
    }

    public Adjacence getAdjacence() { return adjacence; }

}
