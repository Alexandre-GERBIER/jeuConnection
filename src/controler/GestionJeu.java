package controler;

import model.*;
import java.awt.*;

public class GestionJeu {

    private Grille grille;
    private Joueur p1, p2;

    public GestionJeu(Grille _grille, Joueur _p1, Joueur _p2) {
        this.grille = _grille;
        this.p1 = _p1;
        this.p2 = _p2;
    }

    public void initJeu() {

    }

    //TODO boolean ou exception pour case déjà colorée ?
    public boolean colorerCase(int x, int y, Joueur joueur) {
        Case currentCase = grille.get(x,y);
        if (currentCase.getCouleur() != Color.white) {
            return false;
        } else {
            currentCase.setCouleur(joueur.getCouleur());
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
}
