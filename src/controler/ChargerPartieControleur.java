package controler;

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
                Joueur j1 = new Joueur(this.vue.getJ1name().getText(), Color.BLUE);
                Joueur j2 = new Joueur(this.vue.getJ2name().getText(), Color.RED);
                Grille grille = new Grille(fileExplorer.getSelectedFile().getAbsolutePath(), j1, j2);
                GestionJeu jeu = new GestionJeu(grille, j1, j2, grille.getTaille()*grille.getTaille()-grille.getNbCasesBlanches());
                new VueJeu(jeu);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(new JFrame("Erreur"), "Le fichier choisi n'est pas au bon format");
            }
        }
    }
}
