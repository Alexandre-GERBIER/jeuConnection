package controler;

import model.*;

import javax.swing.*;
import java.awt.*;

public class GestionJeu {

    private Grille grille;
    private Joueur p1, p2, joueurCourant;
    private int tour = 0;

    public GestionJeu(Grille _grille, Joueur _p1, Joueur _p2) {
        this.grille = _grille;
        this.p1 = _p1;
        this.p2 = _p2;
        this.joueurCourant = this.p1;
    }

    //TODO boolean ou exception pour case déjà colorée ?
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
            joueur.ajouterCase(caseAColorer, this.grille.getVoisinCouleur(caseAColorer));
            return true;
        }

    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille _grille) {
        this.grille = _grille;
    }

    public Joueur getP1() {
        return p1;
    }

    public void setP1(Joueur _p1) {
        this.p1 = _p1;
    }

    public Joueur getP2() {
        return p2;
    }

    public void setP2(Joueur _p2) {
        this.p2 = _p2;
    }

    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }

    public int getTour() { return this.tour; }

    public void nouveauTour() {
        if (tour < (this.grille.getTaille() * this.grille.getTaille())-1) {
            if (joueurCourant.equals(p1)) {
                joueurCourant = p2;
            } else {
                joueurCourant = p1;
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
