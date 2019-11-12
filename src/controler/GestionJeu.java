package controler;

import model.Adjacence;
import model.Case;
import model.Grille;
import model.Joueur;

import java.awt.*;

import static java.awt.Color.white;

public class GestionJeu {
    private Grille grille;
    private Joueur J1,J2;
    public GestionJeu(Grille _grille){
        this.grille = _grille;
        //this.bleu = new Adjacence(this.grille.taille());
        //this.rouge = new Adjacence(this.grille.taille());
    }


    public void initJeu(){

    }

    //TODO boolean ou exception pour case déjà colorée ?
    public boolean colorerCase(int x, int y, Joueur joueur){
        Case currentCase = grille.get(x,y);
        if (currentCase.getColor() != Color.white){
            return false;
        } else {
            currentCase.setColor(joueur.getCouleur());

            return true ;
        }
    }
}
