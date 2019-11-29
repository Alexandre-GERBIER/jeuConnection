package model;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Grille {

    private int taille, valMax;
    private Case[][] grille;
    private int nbCasesBlanches = 0;

    public Grille(int n, int k) {
        this.taille = n;
        this.valMax = k;
        this.grille = new Case[n][n];
        this.nbCasesBlanches = n*n;
        remplirGrilleAléatoire();
    }

    public Grille(String fichier, Joueur j1, Joueur j2) {
        File file = new File(fichier);

        try {
            Scanner sc = new Scanner(file);
            String[] firstLine = sc.nextLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            this.taille = n;
            int k = Integer.parseInt(firstLine[1]);
            this.valMax = k;
            this.grille = new Case[n][n];

            int i = 0;

            while (i<n) {
                int j=0;
                String ligne = sc.nextLine();
                String[] cases = ligne.split(" ");
                for(String courant : cases){
                    this.grille[i][j] = new Case(i, j, Integer.parseInt(courant), Color.WHITE);
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
                            this.nbCasesBlanches++;
                            break;
                        case 1:
                            this.grille[i][j].setCouleur(Color.BLUE);
                            j1.ajouterCase(this.grille[i][j], this.getVoisinCouleur(this.grille[i][j]));
                            break;
                        case 2:
                            this.grille[i][j].setCouleur(Color.RED);
                            j2.ajouterCase(this.grille[i][j], this.getVoisinCouleur(this.grille[i][j]));
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

    public int getNbCasesBlanches() { return this.nbCasesBlanches; }

    private int caseValue(){
        return (int) (Math.random()*(this.valMax)+1);
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

    public void ecrireFichier() throws Exception{
        String entete =""+this.taille+" "+this.valMax;
        String valeurs = "";
        String couleurs = "";

        for(int i=0; i<this.taille; i++){
            couleurs = couleurs.concat("\n");
            valeurs = valeurs.concat("\n");
            for(int j=0;j<this.taille; j++){
                Case courante = this.grille[i][j];
                int couleur = 0;
                if(courante.getCouleur().equals(Color.WHITE)) {
                    couleur = 0;
                } else {
                    if(courante.getCouleur().equals(Color.RED)){
                        couleur = 1;
                    } else {
                        if(courante.getCouleur().equals(Color.BLUE)){
                            couleur = 2;
                        }
                    }
                }
                couleurs = couleurs.concat("" + couleur);
                valeurs = valeurs.concat("" + courante.getValeur());
            }
        }
        //TODO ajouter dossier de sauvegardes et timestamp dans le nom du fichier
        String fileContent = entete + valeurs + couleurs;
        FileWriter fileWriter = new FileWriter("sauv/fichier.txt");
        fileWriter.write(fileContent);
        fileWriter.close();
    }
}
