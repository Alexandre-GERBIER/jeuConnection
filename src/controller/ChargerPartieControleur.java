package controller;

import model.Bot;
import model.GestionJeu;
import model.Grille;
import model.Joueur;
import view.VueChoixMode;
import view.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChargerPartieControleur implements ActionListener {

    private VueChoixMode vue;

    public ChargerPartieControleur(VueChoixMode _vue) {
        this.vue = _vue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileExplorer = new JFileChooser();
        int res = fileExplorer.showOpenDialog(this.vue);
        if(res == JFileChooser.APPROVE_OPTION) {
            try {
                Joueur j2 = null;
                Bot b2 = null;
                Grille grille;
                GestionJeu jeu;
                Joueur j1 = new Joueur(this.vue.getJ1name().getText(), Color.BLUE);
                if(this.vue.getMultiplayer().isSelected()) {
                    j2 = new Joueur(this.vue.getJ2name().getText(), Color.RED);
                } else {
                    b2 = new Bot(this.vue.getJ2name().getText(), Color.RED);
                }
                if(b2 != null){
                    grille = new Grille(fileExplorer.getSelectedFile().getAbsolutePath(), j1, b2);
                    b2.setGrille(grille);
                    jeu = new GestionJeu(grille, j1, b2, grille.getTaille()*grille.getTaille()-grille.getNbCasesBlanches());
                } else {
                    grille = new Grille(fileExplorer.getSelectedFile().getAbsolutePath(), j1, j2);
                    jeu = new GestionJeu(grille, j1, j2, grille.getTaille()*grille.getTaille()-grille.getNbCasesBlanches());
                }

                new VueJeu(jeu);
            } catch(Exception e) {
                System.out.println((e));
                JOptionPane.showMessageDialog(new JFrame("Erreur"), "Le fichier choisi n'est pas au bon format");
            }
        }
    }
}
