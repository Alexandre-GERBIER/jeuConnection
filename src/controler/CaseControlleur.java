package controler;

import model.Adjacence;
import model.Case;
import model.Joueur;
import view.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
        if(valide) {
            if(this.jeu.getJoueurCourant().getCouleur() == Color.BLUE)
                this.vue.setJ1points(this.jeu.getJoueurCourant().getPoints());
            else
                this.vue.setJ2points(this.jeu.getJoueurCourant().getPoints());
            this.jeu.nouveauTour();
            this.vue.getLabelJoueurCourant().setText("Tour de " + this.jeu.getJoueurCourant().getPseudo());
            this.vue.getLabelJoueurCourant().setForeground(this.jeu.getJoueurCourant().getCouleur());
            this.vue.getLabelNombreTours().setText(this.jeu.getTour() + " / " + this.jeu.getGrille().getTaille()*this.jeu.getGrille().getTaille());
        } else {
            Joueur possedeCase;
            if(this.caseAssociee.getCouleur().equals(Color.BLUE)) {
                possedeCase = this.jeu.getP1();
                LinkedList<Case> composante = possedeCase.getAdjacence().getCasesComposante(this.caseAssociee);
                for(Case c : composante) {
                    JButton jButtonAssocie = this.vue.getJbuttonGrid()[c.getX()][c.getY()];
                    jButtonAssocie.setBackground(Color.BLACK);
                }
            } else {
                possedeCase = this.jeu.getP2();
                LinkedList<Case> composante = possedeCase.getAdjacence().getCasesComposante(this.caseAssociee);
                for(Case c : composante) {
                    JButton jButtonAssocie = this.vue.getJbuttonGrid()[c.getX()][c.getY()];
                    jButtonAssocie.setBackground(Color.BLACK);
                }
            }
            int result = JOptionPane.showConfirmDialog(new JFrame("Score zone"), "score : " + possedeCase.scoreGroupe(this.caseAssociee));
            if(result == JOptionPane.OK_OPTION) {
                if(possedeCase.equals(this.jeu.getP1())) {
                    LinkedList<Case> composante = possedeCase.getAdjacence().getCasesComposante(this.caseAssociee);
                    for(Case c : composante) {
                        JButton jButtonAssocie = this.vue.getJbuttonGrid()[c.getX()][c.getY()];
                        jButtonAssocie.setBackground(Color.BLUE);
                    }
                } else {
                    LinkedList<Case> composante = possedeCase.getAdjacence().getCasesComposante(this.caseAssociee);
                    for(Case c : composante) {
                        JButton jButtonAssocie = this.vue.getJbuttonGrid()[c.getX()][c.getY()];
                        jButtonAssocie.setBackground(Color.RED);
                    }
                }
            }
        }
    }
}
