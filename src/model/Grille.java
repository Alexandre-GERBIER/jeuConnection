package model;

public class Grille {

    private int n, k;
    private int[][] grille;

    public Grille(int n_, int k_) {
        this.n = n_;
        this.k = k_;
        this.grille = new int[n][n];
    }

}
