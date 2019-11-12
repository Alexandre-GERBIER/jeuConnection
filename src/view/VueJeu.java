package view;

import controler.*;
import model.Case;

import javax.swing.*;
import java.awt.*;

public class VueJeu extends JFrame {

    private GestionJeu jeu;

    public VueJeu(GestionJeu _jeu) {
        this.jeu = _jeu;

        //Panel initial
        JPanel panel = new JPanel(new BorderLayout());

        //Panel central, grid layout de JButton
        int tailleGrille = jeu.getGrille().getTaille();
        JPanel panelGrilleBoutons = new JPanel(new GridLayout(tailleGrille, tailleGrille));
        panel.add(panelGrilleBoutons, BorderLayout.CENTER);

        for(int i=0; i<tailleGrille; i++) {
            for(int j=0; j<tailleGrille; j++) {
                Case caseActuelle = jeu.getGrille().get(i, j);
                JButton bouton = new JButton(String.valueOf(caseActuelle.getValeur()));
                bouton.setBackground(caseActuelle.getCouleur());
                panelGrilleBoutons.add(bouton);
            }
        }

        //Paramètres de la JFrame
        this.setTitle("Connexion");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

}
