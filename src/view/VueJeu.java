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

        //Panel SOUTH, infos joueurs
        JPanel panelJoueurs = new JPanel(new GridLayout(2, 1));
        panel.add(panelJoueurs, BorderLayout.SOUTH);

        //Panel joueurs
        JPanel panelInfosJoueurs = new JPanel(new GridLayout(2, 1));
        panelJoueurs.add(panelInfosJoueurs);

        //Panel J1
        JPanel panelJ1 = new JPanel(new GridLayout(2, 1));
        panelInfosJoueurs.add(panelJ1);
        JTextArea j1pseudo = new JTextArea(jeu.getP1().getPseudo());
        j1pseudo.setMargin(new Insets(this.getHeight()/10, this.getWidth()/10, this.getHeight()/10, this.getWidth()/10));
        j1pseudo.setForeground(jeu.getP1().getCouleur());
        j1pseudo.setOpaque(false);
        j1pseudo.setEditable(false);
        panelJ1.add(j1pseudo);
        JTextArea j1points = new JTextArea(String.valueOf(jeu.getP1().getPoints()));
        j1points.setOpaque(false);
        j1points.setEditable(false);
        panelJ1.add(j1points);

        //Panel J2
        JPanel panelJ2 = new JPanel(new GridLayout(2, 1));
        panelInfosJoueurs.add(panelJ2);
        JTextArea j2pseudo = new JTextArea(jeu.getP2().getPseudo());
        j2pseudo.setMargin(new Insets(this.getHeight()/10, this.getWidth()/10, this.getHeight()/10, this.getWidth()/10));
        j2pseudo.setForeground(jeu.getP2().getCouleur());
        j2pseudo.setOpaque(false);
        j2pseudo.setEditable(false);
        panelJ2.add(j2pseudo);
        JTextArea j2points = new JTextArea(String.valueOf(jeu.getP2().getPoints()));
        j2points.setOpaque(false);
        j2points.setEditable(false);
        panelJ2.add(j2points);

        //Panel Options
        JPanel panelOptions = new JPanel();
        panelJoueurs.add(panelOptions);

        for(int i=0; i<tailleGrille; i++) {
            for(int j=0; j<tailleGrille; j++) {
                Case caseActuelle = jeu.getGrille().get(i, j);
                JButton bouton = new JButton(String.valueOf(caseActuelle.getValeur()));
                bouton.addActionListener(new CaseControlleur(caseActuelle,jeu,bouton));
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
