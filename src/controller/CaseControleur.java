package controller;

import model.Bot;
import model.Case;
import model.GestionJeu;
import model.Joueur;
import view.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaseControleur implements ActionListener {

    private Case caseAssociee;
    private GestionJeu jeu;
    private JButton boutonAssocie;
    private VueJeu vue;

    public CaseControleur(Case newCase, GestionJeu newJeu, JButton bouton, VueJeu newVue){
        this.caseAssociee = newCase;
        this.jeu = newJeu;
        this.boutonAssocie = bouton;
        this.vue = newVue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        boolean valide = this.jeu.colorerCase(this.caseAssociee,jeu.getJoueurCourant());
        this.boutonAssocie.setBackground(this.caseAssociee.getCouleur());

        if(valide) {

            if(this.jeu.getJoueurCourant().getCouleur() == Color.BLUE)
                this.vue.setJ1points(this.jeu.getJoueurCourant().getPoints());
            else
                this.vue.setJ2points(this.jeu.getJoueurCourant().getPoints());

            this.jeu.nouveauTour();

            this.vue.getLabelJoueurCourant().setText("Tour de " + this.jeu.getJoueurCourant().getPseudo());
            this.vue.getLabelJoueurCourant().setForeground(this.jeu.getJoueurCourant().getCouleur());
            this.vue.getLabelNombreTours().setText(this.jeu.getTour() + " / " + this.jeu.getGrille().getTaille()*this.jeu.getGrille().getTaille());

            if(this.jeu.getJoueurCourant() instanceof Bot) {

                int[] coords = ((Bot) this.jeu.getJoueurCourant()).jouer(this.jeu.getTour());
                Case caseAJouer = this.jeu.getGrille().get(coords[0], coords[1]);
                boolean valideBot = this.jeu.colorerCase(caseAJouer, this.jeu.getJoueurCourant());

                if(valideBot) {

                    this.vue.getJbuttonGrid()[coords[0]][coords[1]].setBackground(caseAJouer.getCouleur());
                    this.vue.setJ2points(this.jeu.getJoueurCourant().getPoints());

                    this.jeu.nouveauTour();

                    this.vue.getLabelJoueurCourant().setText("Tour de " + this.jeu.getJoueurCourant().getPseudo());
                    this.vue.getLabelJoueurCourant().setForeground(this.jeu.getJoueurCourant().getCouleur());
                    this.vue.getLabelNombreTours().setText(this.jeu.getTour() + " / " + this.jeu.getGrille().getTaille()*this.jeu.getGrille().getTaille());

                }

            }

        } else {

            Joueur possedeCase;
            if(this.caseAssociee.getCouleur().equals(Color.BLUE)) {
                possedeCase = this.jeu.getP1();
            } else {
                if(this.jeu.isMultiplayer()) {
                    possedeCase = this.jeu.getP2();
                } else {
                    possedeCase = this.jeu.getBot();
                }
            }
            this.vue.afficherComposante(this.caseAssociee, possedeCase);
            int result = JOptionPane.showConfirmDialog(new JFrame("Score zone"), "score : " + possedeCase.scoreGroupe(this.caseAssociee));
            if(result == JOptionPane.OK_OPTION) {
                this.vue.resetComposante(this.caseAssociee, possedeCase);
            }

        }

    }
}
