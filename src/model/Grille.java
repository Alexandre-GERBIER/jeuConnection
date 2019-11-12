package model;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

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
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());
            this.grille = new Case[n][n];

            int i = 0;

            while (i<n) {
                int j=0;
                String ligne = sc.nextLine();
                String[] cases = ligne.split(" ");
                for(String courant : cases){
                    this.grille[i][j].setValeur(Integer.parseInt(courant));
                    j++;
                }
                i++;
            }

            i = 0;
            while (i<n) {
                int j=0;
                String ligne = sc.nextLine();
                String[] cases = ligne.split(" ");
                for(String courant : cases){
                    switch(Integer.parseInt(courant)){
                        case 0:
                            this.grille[i][j].setCouleur(Color.WHITE);
                            break;

                        case 1:
                            this.grille[i][j].setCouleur(Color.BLUE);
                            break;

                        case 2:
                            this.grille[i][j].setCouleur(Color.RED);
                            break;
                    }
                    j++;
                }
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getTaille() {
        return taille;
    }

    public int getValMax() {
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
                this.grille[i][j] = new Case(i,j,caseValue(),Color.WHITE);
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
            if(dessus.getCouleur() == origine.getCouleur()){
                voisins.add(dessus);
            }
        }
        if(yOrigine+1 < this.taille) {
            Case dessous = this.grille[xOrigine][yOrigine + 1];
            if(dessous.getCouleur() == origine.getCouleur()){
                voisins.add(dessous);
            }
        }
        if(xOrigine+1 < this.taille) {
            Case droite = this.grille[xOrigine + 1][yOrigine];
            if(droite.getCouleur() == origine.getCouleur()){
                voisins.add(droite);
            }
        }
        if(xOrigine-1 >=0 ) {
            Case gauche = this.grille[xOrigine-1][yOrigine];
            if(gauche.getCouleur() == origine.getCouleur()){
                voisins.add(gauche);
            }
        }

        return voisins;
    }
}
