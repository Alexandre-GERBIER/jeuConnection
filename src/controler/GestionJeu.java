package controler;

import model.*;

import javax.swing.*;
import java.awt.*;

public class GestionJeu {

    private Grille grille;
    private Joueur p1, p2, joueurCourant;
    private int tour = 0;

    public GestionJeu(Grille _grille, Joueur _p1, Joueur _p2, int _tour) {
        this.grille = _grille;
        this.p1 = _p1;
        this.p2 = _p2;
        this.tour = _tour;
        this.joueurCourant = this.p1;
    }

    public GestionJeu(Grille _grille, Joueur _p1, Joueur _p2) {
        this(_grille, _p1, _p2, 0);
    }

    public boolean colorerCase(Case caseAColorer, Joueur joueur) {
        if (caseAColorer.getCouleur() != Color.white) {
            Joueur possedeCase ;
            if(caseAColorer.getCouleur().equals(Color.BLUE)){
                possedeCase = this.p1;
            } else {
                possedeCase = this.p2;
            }
            JOptionPane.showMessageDialog(new JFrame("Score zone"), "score : " + possedeCase.scoreGroupe(caseAColorer));
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
        return p1;
    }

    public Joueur getP2() {
        return p2;
    }

    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }

    public int getTour() { return this.tour; }

    public void nouveauTour() {
        if(this.tour < (this.grille.getTaille() * this.grille.getTaille())-1) {
            if (this.joueurCourant.equals(this.p1)) {
                this.joueurCourant = this.p2;
            } else {
                this.joueurCourant = this.p1;
            }
            this.tour++;
        } else {
            String message = "Égalité";
            if(this.p1.getPoints() > this.p2.getPoints())
                message = this.p1.getPseudo() + " a gagné la partie";
            else if(this.p2.getPoints() > this.p1.getPoints())
                message = this.p2.getPseudo() + " a gagné la partie";
            JOptionPane.showMessageDialog(new JFrame("Partie terminée"), message);
        }
    }

}
