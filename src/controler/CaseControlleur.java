package controler;

import model.Case;
import view.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaseControlleur implements ActionListener {

    private Case caseAssociee;
    private GestionJeu jeu;
    private JButton boutonAssocie;
    private VueJeu vue;

    public CaseControlleur(Case newCase, GestionJeu newJeu, JButton bouton, VueJeu newVue){
        this.caseAssociee = newCase;
        this.jeu = newJeu;
        this.boutonAssocie = bouton;
        this.vue = newVue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean valide = this.jeu.colorerCase(this.caseAssociee,jeu.getJoueurCourant());
        this.boutonAssocie.setBackground(this.caseAssociee.getCouleur());
        if(valide){
            if(this.jeu.getJoueurCourant().getCouleur() == Color.BLUE)
                this.vue.setJ1points(this.jeu.getJoueurCourant().getPoints());
            else
                this.vue.setJ2points(this.jeu.getJoueurCourant().getPoints());
            this.jeu.nouveauTour();
        }
    }
}
