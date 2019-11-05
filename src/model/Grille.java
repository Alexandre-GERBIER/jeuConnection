package model;

import static java.awt.Color.white;

public class Grille {

    private int taille, valMax;
    private Case[][] grille;

    public Grille(int n, int k) {
        this.taille = n;
        this.valMax = k;
        this.grille = new Case[n][n];
        remplissage(grille);
    }

    public int getN() {
        return taille;
    }

    public int getvalMax() {
        return valMax;
    }

    public Case[][] getGrille() {
        return grille;
    }

    private int caseValue(){
        return (int) (Math.random()*(this.valMax-1)+1);
    }

    private void remplissage(Case[][] grille){
        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++){
                grille[i][j] = new Case(i,j,caseValue(),white);
            }
        }
    }
}
