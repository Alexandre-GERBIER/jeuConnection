package view;

import controler.*;
import model.Case;

import javax.swing.*;
import java.awt.*;

public class VueJeu extends JFrame {

    private GestionJeu jeu;
    private JLabel j1points, j2points, labelJoueurCourant, labelNombreTours;

    public VueJeu(GestionJeu _jeu) {
        this.jeu = _jeu;

        //Panel initial
        JPanel panel = new JPanel(new BorderLayout());

        //Panel central, grid layout de JButton
        int tailleGrille = jeu.getGrille().getTaille();

        JPanel panelGrilleBoutons = new JPanel(new GridLayout(tailleGrille, tailleGrille));
        panel.add(panelGrilleBoutons, BorderLayout.CENTER);

        //Panel SOUTH, infos joueurs
        JPanel panelJoueurs = new JPanel(new GridLayout(1, 3));
        panel.add(panelJoueurs, BorderLayout.SOUTH);

        //Panel NORTH, infos partie
        JPanel panelInfosPartie = new JPanel(new GridLayout(1, 2));
        panel.add(panelInfosPartie, BorderLayout.NORTH);

        //Panel J1
        JPanel panelJ1 = new JPanel(new GridLayout(2, 1));
        panelJ1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelJoueurs.add(panelJ1);

        JLabel j1pseudo = new JLabel(this.jeu.getP1().getPseudo());
        j1pseudo.setForeground(this.jeu.getP1().getCouleur());
        j1pseudo.setFont(j1pseudo.getFont().deriveFont(20f));
        j1pseudo.setHorizontalAlignment(JLabel.CENTER);
        panelJ1.add(j1pseudo);

        this.j1points = new JLabel(String.valueOf(this.jeu.getP1().getPoints()));
        this.j1points.setFont(this.j1points.getFont().deriveFont(24f));
        this.j1points.setHorizontalAlignment(JLabel.CENTER);
        panelJ1.add(this.j1points);

        //Panel J2
        JPanel panelJ2 = new JPanel(new GridLayout(2, 1));
        panelJ2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelJoueurs.add(panelJ2);

        JLabel j2pseudo = new JLabel(this.jeu.getP2().getPseudo());
        j2pseudo.setForeground(this.jeu.getP2().getCouleur());
        j2pseudo.setFont(j2pseudo.getFont().deriveFont(20f));
        j2pseudo.setHorizontalAlignment(JLabel.CENTER);
        panelJ2.add(j2pseudo);

        this.j2points = new JLabel(String.valueOf(this.jeu.getP2().getPoints()));
        this.j2points.setFont(this.j2points.getFont().deriveFont(24f));
        this.j2points.setHorizontalAlignment(JLabel.CENTER);
        panelJ2.add(this.j2points);

        //Panel Options
        JPanel panelOptions = new JPanel(new GridLayout(3, 1));
        panelJoueurs.add(panelOptions);

        JButton recommencerPartie = new JButton("Recommencer");
        panelOptions.add(recommencerPartie);

        JButton chargerPartie = new JButton("Charger");
        panelOptions.add(chargerPartie);

        JButton sauvegarderPartie = new JButton("Sauvegarder");
        panelOptions.add(sauvegarderPartie);

        //Panel infos partie
        JPanel panelJoueurCourant = new JPanel();
        panelJoueurCourant.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.labelJoueurCourant = new JLabel("Tour de " + this.jeu.getJoueurCourant().getPseudo());
        this.labelJoueurCourant.setForeground(this.jeu.getJoueurCourant().getCouleur());
        this.labelJoueurCourant.setFont(this.labelJoueurCourant.getFont().deriveFont(20f));
        panelJoueurCourant.add(labelJoueurCourant);

        JPanel panelInfosTour = new JPanel();
        panelInfosTour.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.labelNombreTours = new JLabel("Tour " + this.jeu.getTour() + " / " + this.jeu.getGrille().getTaille()*this.jeu.getGrille().getTaille());
        this.labelNombreTours.setFont(this.labelNombreTours.getFont().deriveFont(20f));
        panelInfosTour.add(labelNombreTours);

        panelInfosPartie.add(panelJoueurCourant);
        panelInfosPartie.add(panelInfosTour);

        for(int i=0; i<tailleGrille; i++) {
            for(int j=0; j<tailleGrille; j++) {
                Case caseActuelle = jeu.getGrille().get(i, j);
                JButton bouton = new JButton(String.valueOf(caseActuelle.getValeur()));
                bouton.addActionListener(new CaseControlleur(caseActuelle, jeu, bouton, this));
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

    public void setJ1points(int _j1points) {
        this.j1points.setText(String.valueOf(_j1points));
    }

    public void setJ2points(int _j2points) {
        this.j2points.setText(String.valueOf(_j2points));
    }

    public JLabel getLabelJoueurCourant() { return this.labelJoueurCourant; }

    public JLabel getLabelNombreTours() { return this.labelNombreTours; }

}
