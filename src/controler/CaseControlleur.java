package controler;

import model.Case;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaseControlleur implements ActionListener {

    private Case caseAssociee;
    private GestionJeu jeu;
    private JButton boutonAssocie;

    public CaseControlleur(Case newCase, GestionJeu newJeu, JButton bouton){
        this.caseAssociee = newCase;
        this.jeu = newJeu;
        this.boutonAssocie = bouton;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean valide = this.jeu.colorerCase(this.caseAssociee,jeu.getJoueurCourant());
        this.boutonAssocie.setBackground(this.caseAssociee.getCouleur());
        if(valide){
            this.jeu.nouveauTour();
        }
    }
}
