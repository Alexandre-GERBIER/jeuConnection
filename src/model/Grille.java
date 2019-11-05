package model;

public class Grille {

    //ceci est un test bis

    private int n, k;
    private Case[][] grille;

    public Grille(int n_, int k_) {
        this.n = n_;
        this.k = k_;
        this.grille = new Case[n][n];
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

}
