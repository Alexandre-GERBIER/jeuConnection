package model;

public class Sommet {
    private int score;
    private Case sommet;
    private int taille;

    public Sommet(Case newSommet){
        this.sommet = newSommet;
        this.score = newSommet.getValue();
        this.taille = 1;
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
}
