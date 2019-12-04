package controler;

import model.*;

import javax.swing.*;
import java.awt.*;

public class GestionJeu {

    private Grille grille;
    private Joueur p1, p2, joueurCourant;
    private Bot bot;
    private int tour = 0;

    public GestionJeu(Grille _grille, Joueur _p1, Joueur _p2, int _tour) {
        this.grille = _grille;
        this.p1 = _p1;
        this.p2 = _p2;
        this.tour = _tour;
        this.joueurCourant = this.p1;
    }

    //Constructeur de GestionJeu pour JvsJ
    public GestionJeu(Grille _grille, Joueur _p1, Joueur _p2) {
        this(_grille, _p1, _p2, 0);
    }

    //Constructeur de GestionJeu pour JvsIA
    public GestionJeu(Grille _grille, Joueur _p1, Bot _bot) {
        this(_grille, _p1, null, 0);
        this.bot = _bot;
    }

    public boolean colorerCase(Case caseAColorer, Joueur joueur) {
        if (caseAColorer.getCouleur() != Color.white) {
            return false;
        } else {
            caseAColorer.setCouleur(joueur.getCouleur());
            joueur.ajouterCase(caseAColorer, this.grille.relierComposantes(caseAColorer));
            return true;
        }

    }

    public Grille getGrille() {
        return this.grille;
    }

    public Joueur getP1() {
        return this.p1;
    }

    public Joueur getP2() {
        return this.p2;
    }

    public Bot getBot() { return this.bot; }

    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }

    public int getTour() { return this.tour; }

    public boolean isMultiplayer() {
        return this.p2 != null;
    }

    //Méthode pour passer au tour suivant après qu'un joueur ait effectué une action
    public void nouveauTour() {
        if(this.tour < (this.grille.getTaille() * this.grille.getTaille())-1) {
            if (this.joueurCourant.equals(this.p1)) {
                if(!this.isMultiplayer()) {
                    this.joueurCourant = this.bot;
                } else {
                    this.joueurCourant = this.p2;
                }

            } else {
                this.joueurCourant = this.p1;
            }
            this.tour++;
        } else {
            String message = "Égalité";
            if(this.isMultiplayer()) {
                if (this.p1.getPoints() > this.p2.getPoints()) {
                    message = this.p1.getPseudo() + " a gagné la partie";
                } else if (this.p2.getPoints() > this.p1.getPoints()) {
                    message = this.p2.getPseudo() + " a gagné la partie";
                }
            } else {
                if (this.p1.getPoints() > this.bot.getPoints()) {
                    message = this.p1.getPseudo() + " a gagné la partie";
                } else if (this.bot.getPoints() > this.p1.getPoints()) {
                    message = this.bot.getPseudo() + " a gagné la partie";
                }
            }
            JOptionPane.showMessageDialog(new JFrame("Partie terminée"), message);
        }
    }

    public Adjacence getAdjacenceCase(Case origine){
        if(origine.getCouleur().equals(Color.BLUE)){
            return p1.getAdjacence();
        }
        if(origine.getCouleur().equals(Color.RED)){
            return p2.getAdjacence();
        } else{
            return null;
        }
    }

    public boolean existeCheminCases(Case case1, Case case2){
        if(!case1.getCouleur().equals(case2.getCouleur())){
            return false;
        }
        Adjacence adj = this.getAdjacenceCase(case1);
        Sommet sommet1 = adj.getSommetAssocie(case1);
        Sommet sommet2 = adj.getSommetAssocie(case2);
        return sommet1.equals(sommet2);
    }

}
