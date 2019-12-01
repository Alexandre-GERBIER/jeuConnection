package model;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * constructeur avec un fichier contenant une partie sauvegardée en parametre
     * @param fichier fichier de sauvegarde d'une partie
     * @param j1 joueur 1
     * @param j2 joueur 2
     */
    public Grille(String fichier, Joueur j1, Joueur j2) {
        this.remplirGrilleFichier(fichier,  j1,  j2);
    }

    /**
     * renvoe la taille de la grille
     * @return la taille de la grille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * renvoie le nombre de cases libres
     * @return le nombre de cases blanches(libres)
     */
    public int getNbCasesBlanches() { return this.nbCasesBlanches; }

    /**
     * renvoie une valeur aléatoire inférieure ou égale au max sspécifié lors du lancement de la partie,
     * cette valeur sera attribuée à une case
     */
    private int caseValue(){
        return (int) (Math.random()*(this.valMax)+1);
    }

    /**
     * rempli la grille de cases non colorées(blanche) après leur avoir attribué une valeur aléatoire
     */
    private void remplirGrilleAléatoire(){
        for(int i=0; i<this.taille; i++){
            for(int j=0; j<this.taille; j++){
                this.grille[i][j] = new Case(i,j,caseValue(),Color.WHITE);
            }
        }
    }

    /**
     * rempli la grille avec les valeurs du fichier de sauvegarde spécifié
     * @param fichier fichier de sauvegarde où se trouvent les paramètres du jeu
     * @param j1 joueur 11
     * @param j2 joueur 2
     */
    private void remplirGrilleFichier(String fichier, Joueur j1, Joueur j2){
        File file = new File(fichier);

        try {
            Scanner sc = new Scanner(file);
            String[] firstLine = sc.nextLine().split("");
            int n = Integer.parseInt(firstLine[0]);
            this.taille = n;
            int k = Integer.parseInt(firstLine[1]);
            this.valMax = k;
            this.grille = new Case[n][n];

            int i = 0;

            while (i<n) {
                int j=0;
                String ligne = sc.nextLine();
                String[] cases = ligne.split("");
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
                String[] cases = ligne.split("");
                for(String courant : cases){
                    switch(Integer.parseInt(courant)){
                        case 0:
                            this.grille[i][j].setCouleur(Color.WHITE);
                            this.nbCasesBlanches++;
                            break;
                        case 1:
                            this.grille[i][j].setCouleur(Color.BLUE);
                            j1.ajouterCase(this.grille[i][j], this.relierComposantes(this.grille[i][j]));
                            break;
                        case 2:
                            this.grille[i][j].setCouleur(Color.RED);
                            j2.ajouterCase(this.grille[i][j], this.relierComposantes(this.grille[i][j]));
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

    /**
     * renvoie un booléen exprimant si la cae est libre (pas colorée par une joueur
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return la case peut être jouée
     */
    public boolean libre(int x, int y){
        return this.grille[x][y].getCouleur() == Color.white;
    }

    /**
     * renvoie la case se trouvant aux coordonnées spécifiées
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return la case demandée
     */
    public Case get(int x, int y){
        return this.grille[x][y];
    }

    /**
     * renvoie une liste des voisins libre d'une case
     * @param origine la case dont on veut les voisins libres
     * @return la liste de voisins libre
     */
    public LinkedList<Case> voisinsDispo(Case origine){
        LinkedList<Case> voisins = new LinkedList<Case>();
        int xOrigine = origine.getX();
        int yOrigine = origine.getY();

        if(yOrigine-1 >= 0) {
            Case dessus = this.grille[xOrigine][yOrigine - 1];
            if(dessus.getCouleur() == Color.WHITE){
                voisins.add(dessus);
            }
        }
        if(yOrigine+1 < this.taille) {
            Case dessous = this.grille[xOrigine][yOrigine + 1];
            if(dessous.getCouleur() == Color.WHITE){
                voisins.add(dessous);
            }
        }
        if(xOrigine+1 < this.taille) {
            Case droite = this.grille[xOrigine + 1][yOrigine];
            if(droite.getCouleur() == Color.WHITE){
                voisins.add(droite);
            }
        }
        if(xOrigine-1 >=0 ) {
            Case gauche = this.grille[xOrigine-1][yOrigine];
            if(gauche.getCouleur() == Color.WHITE){
                voisins.add(gauche);
            }
        }

        return voisins;
    }

    /**
     * renvoie la liste des voisins de la même couleur quela case spécifiée
     * @param origine la case dont on veut connaître les voisins de la même couleur
     * @return la liste des voisins de la même couleur
     */
    public LinkedList<Case> relierComposantes(Case origine){
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

    /**
     * fonction qui sauvegarde la partie dans un fichier
     * @throws Exception si un problème survient pendant l'écriture du fichier
     */
    public void ecrireFichier() throws Exception {
        String entete = this.taille + "" + this.valMax;
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

        //TODO pb slash pour arborescence selon windows ou linux
        String fileContent = entete + valeurs + couleurs;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String[] timeStamp = dateFormat.format(new Date()).split(" ");
        String[] date = timeStamp[0].split("/");
        String[] time = timeStamp[1].split(":");
        String fileName = "save" + date[2] + date[1] + date[0] + "_" + time[0] + time[1] + time[2] + ".txt";
        File savesDirectory = new File(new File("").getAbsolutePath().concat("//saves"));
        if(!savesDirectory.exists()) {
            savesDirectory.mkdir();
        }
        FileWriter fileWriter = new FileWriter(new File(savesDirectory.getName().concat("//" + fileName)));
        fileWriter.write(fileContent);
        fileWriter.close();
    }
}
