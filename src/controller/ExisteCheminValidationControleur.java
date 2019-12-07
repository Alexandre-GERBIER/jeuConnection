package controller;

import model.Case;
import model.GestionJeu;
import view.VueExisteChemin;
import view.VueJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExisteCheminValidationControleur implements ActionListener {

    private GestionJeu jeu;
    private VueJeu vue;
    private VueExisteChemin vueChemin;

    public ExisteCheminValidationControleur(GestionJeu _jeu, VueJeu _vue, VueExisteChemin _vueChemin) {
        this.jeu = _jeu;
        this.vue = _vue;
        this.vueChemin = _vueChemin;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        try {
            x1 = Integer.parseInt(this.vueChemin.getX1().getText());
            y1 = Integer.parseInt(this.vueChemin.getY1().getText());
            x2 = Integer.parseInt(this.vueChemin.getX2().getText());
            y2 = Integer.parseInt(this.vueChemin.getY2().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Les coordonnées doivent être des entiers positifs");
            return;
        }
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Les coordonnées doivent être des entiers positifs");
            return;
        }
        Case c1 = this.jeu.getGrille().get(y1, x1);
        Case c2 = this.jeu.getGrille().get(y2, x2);
        boolean result = this.jeu.existeCheminCases(c1, c2);
        String toStringCases = "Case("+c1.getY()+";"+c1.getX()+") et Case("+c2.getY()+";"+c2.getX()+").";
        String msg = "Il n'existe pas de chemin entre " + toStringCases;
        if(result) {
            msg = "Il existe un chemin entre " + toStringCases;
        }
        JOptionPane.showMessageDialog(new JFrame("ExisteCheminCases"), msg);
    }
}
