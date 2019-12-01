package model;

import java.util.LinkedList;

public class Sommet {
    private int score;
    private Case sommet;
    private int taille;
    private LinkedList<Case> cases;

    /**
     * constructeur
     * @param newSommet case qui sert de tête à l'arbre des cases reliées
     */
    public Sommet(Case newSommet){
        this.sommet = newSommet;
        this.score = newSommet.getValeur();
        this.taille = 1;
        this.cases = new LinkedList<Case>();
        this.cases.add(newSommet);
    }

    /**
     * ajoute une case au groupe de cases reliées
     * @param newCase al case à ajouter
     */
    public void ajouterCase(Case newCase){
        this.score += newCase.getValeur();
        this.taille += 1;
        this.cases.add(newCase);
    }

    /**
     * renvoie le score de ce groupe
     * @return le score du groupe
     */
    public int getScore() {
        return score;
    }

    public void updateScore(int val){
        this.score += val;
    }

    public void updateTaille(int ajout){
        this.taille += ajout;
    }

    /**
     * renvoie la case au sommet du groupe
     * @return la case au sommet
     */
    public Case getCase() {
        return sommet;
    }

    public int getTaille(){
        return this.taille;
    }

    public void setTaille(int newTaille){
        this.taille = newTaille;
    }

    /**
     * renvoie la liste des cases du groupe
     * @return liste des cases du groupe
     */
    public LinkedList<Case> getCases(){
        return this.cases;
    }
}
