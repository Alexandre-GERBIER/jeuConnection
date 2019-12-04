package model;

import java.awt.*;
import java.util.LinkedList;

public class Bot extends Joueur {

    Grille grille;
    int[][] previsions;
    int taille;
    LinkedList<Case> casesJouee;

    public Bot(String _pseudo, Color _couleur, Grille _grille) {
        super(_pseudo, _couleur);
        this.casesJouee = new LinkedList<Case>();
            this.grille = _grille;
            this.taille = this.grille.getTaille();
            this.initGrilleJeu();
    }

    public Bot(String _pseudo, Color _couleur) {
        super(_pseudo, _couleur);
        this.casesJouee = new LinkedList<Case>();
    }

    public void setGrille(Grille _grille){
        this.grille = _grille;
        this.taille = this.grille.getTaille();
        this.initGrilleJeu();
    }

    /**
     * lance le tour d'un bot
     * @param tourN le numéro du tour dans la partie
     * @return un tableau contenant les coordonées de la case que le bot joue
     */
    public int[] jouer(int tourN){
        boolean moov_valid = false;
        int[] coordAjouer = new int[2];
        int xMax = 0, yMax = 0, valMax = 0;
        if(tourN<2){
            int milieu = taille/2;

            for(int i=milieu-2; i<milieu+2; i++) {
                for (int j = milieu - 2; j < milieu + 2; j++) {
                    if (this.previsions[i][j] > valMax) {
                        xMax = i;
                        yMax = j;
                        valMax = this.previsions[i][j];
                    }
                }
            }

        } else {
            for (Case courant: this.casesJouee) {
                LinkedList<Case> voisinsCourant = this.grille.voisinsDispo(courant);
                for(Case voisinCourant : voisinsCourant){
                    int xCourant = voisinCourant.getX();
                    int yCourant = voisinCourant.getY();
                    if(this.previsions[xCourant][yCourant]>valMax){
                        xMax = xCourant;
                        yMax = yCourant;
                        valMax = this.previsions[xCourant][yCourant];
                        moov_valid = true;
                    }
                }
            }
            if(!moov_valid){
                for(int i=0; i<this.taille; i++) {
                    for (int j = 0; j < this.taille; j++) {
                        if (this.previsions[i][j] > valMax && this.grille.libre(i,j)) {
                            xMax = i;
                            yMax = j;
                            valMax = this.previsions[i][j];
                        }
                    }
                }
            }

        }
        coordAjouer[0] = xMax;
        coordAjouer[1] = yMax;
        this.casesJouee.add(this.grille.get(xMax,yMax));
        return coordAjouer;
    }

    /**
     * rempli la grille de calcul des valeurs de chaque case,
     * la valeur d'une ase représente l'interêt de la jouer, calculer par la somme de sa valeur et de la valeur de ses voisins
     */
    private void initGrilleJeu(){
        this.previsions = new int[this.taille][this.taille];
        for(int i=0; i<this.taille; i++){
            for(int j=0; j<this.taille; j++){
                this.previsions[i][j] = this.sommeVoisins(this.grille.get(i,j));
            }
        }
    }

    /**
     * renvoie la somme des valeurs des voisins d'une case passée en paramètre et de sa valeur
     * @param origine la case dont on veut connnaitre la somme
     * @return la somme des cases accessible depuis la case passée en paramètre
     */
    private int sommeVoisins(Case origine){
        int somme = 0;
        int xOrigine = origine.getX();
        int yOrigine = origine.getY();

        if(yOrigine-1 >= 0) {
            Case dessus = this.grille.get(xOrigine,yOrigine - 1);
            somme += dessus.getValeur();
        }
        if(yOrigine+1 < this.taille) {
            Case dessous = this.grille.get(xOrigine,yOrigine + 1);
            somme += dessous.getValeur();
        }
        if(xOrigine+1 < this.taille) {
            Case droite = this.grille.get(xOrigine + 1,yOrigine);
            somme += droite.getValeur();
        }
        if(xOrigine-1 >=0 ) {
            Case gauche = this.grille.get(xOrigine-1,yOrigine);
            somme += gauche.getValeur();
        }
        return somme+origine.getValeur();
    }
}
