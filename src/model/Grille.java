package model;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import static java.awt.Color.white;

public class Grille {

    private int taille, valMax;
    private Case[][] grille;

    public Grille(int n, int k) {
        this.taille = n;
        this.valMax = k;
        this.grille = new Case[n][n];
        remplirGrilleAléatoire();
    }

    public Grille(String fichier) {

        File file = new File(fichier);

        try {
            Scanner sc = new Scanner(file);


            while (sc.hasNextLine()) {
                int i = sc.nextInt();
                System.out.println(i);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int taille() {
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

    private void remplirGrilleAléatoire(){
        for(int i=0; i<this.taille; i++){
            for(int j=0; j<this.taille; j++){
                this.grille[i][j] = new Case(i,j,caseValue(),white);
            }
        }
    }

    public Case get(int x, int y){
        return grille[x][y];
    }

    public LinkedList<Case> getVoisinCouleur(Case origine){
        LinkedList<Case> voisins = new LinkedList<Case>();
        int xOrigine = origine.getX();
        int yOrigine = origine.getY();

        if(yOrigine-1 >= 0) {
            Case dessus = this.grille[xOrigine][yOrigine - 1];
            if(dessus.getColor() == origine.getColor()){
                voisins.add(dessus);
            }
        }
        if(yOrigine+1 < this.taille) {
            Case dessous = this.grille[xOrigine][yOrigine + 1];
            if(dessous.getColor() == origine.getColor()){
                voisins.add(dessous);
            }
        }
        if(xOrigine+1 < this.taille) {
            Case droite = this.grille[xOrigine + 1][yOrigine];
            if(droite.getColor() == origine.getColor()){
                voisins.add(droite);
            }
        }
        if(xOrigine-1 >=0 ) {
            Case gauche = this.grille[xOrigine-1][yOrigine];
            if(gauche.getColor() == origine.getColor()){
                voisins.add(gauche);
            }
        }

        return voisins;
    }
}
