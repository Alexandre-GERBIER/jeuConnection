package model;

import java.util.LinkedList;

public class Sommet {
    private int score;
    private Case sommet;
    private int taille;
    private LinkedList<Case> cases;

    public Sommet(Case newSommet){
        this.sommet = newSommet;
        this.score = newSommet.getValue();
        this.taille = 1;
        this.cases = new LinkedList<Case>();
    }

    public void ajouterCase(Case newCase){
        this.score += newCase.getValue();
        this.taille += 1;
        this.cases.add(newCase);
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int val){
        this.score += val;
    }

    public void updateTaille(int ajout){
        this.taille += ajout;
    }

    public Case getCase() {
        return sommet;
    }

    public int getTaille(){
        return this.taille;
    }

    public void setTaille(int newTaille){
        this.taille = newTaille;
    }

    public LinkedList<Case> getCases(){
        return this.cases;
    }
}
