/*package controler;

import model.Adjacence;
import model.Case;
import model.Grille;

import static java.awt.Color.white;

public class GestionJeu {
    private Grille grille;
    private Adjacence bleu;
    private Adjacence rouge;

    public GestionJeu(Grille _grille){
        this.grille = _grille;
        this.bleu = new Adjacence(this.grille.taille());
        this.rouge = new Adjacence(this.grille.taille());
    }


    //TODO boolean ou exception pour case déjà colorée ?
    public boolean colorerCase(int x, int y, Color couleur){
        Case currentCase = grille.get(x,y);
        if (currentCase.getColor() != Color.white){
            return false;
        } else {
            currentCase.setColor(couleur);
            if(couleur == Color.red){
                this.rouge.add(currentCase);
            } else {
                this.bleu.add(currentCase);
            }
            return true ;
        }
    }
}*/
