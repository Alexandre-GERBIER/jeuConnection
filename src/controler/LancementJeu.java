package controler;

import model.Grille;
import model.Joueur;
import view.VueChoixMode;
import view.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LancementJeu implements ActionListener {

    private VueChoixMode infos;

    public LancementJeu(VueChoixMode _infos) {
        this.infos = _infos;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String p1name = infos.getP1name().getText().trim();
        String p2name = infos.getP2name().getText().trim();

        if(p1name.isEmpty() || p2name.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Les deux joueurs doivent avoir un nom");
        } else {
            Joueur p1 = new Joueur(p1name, 0, Color.BLUE);
            Joueur p2 = new Joueur(p2name, 0, Color.RED);
            GestionJeu jeu = new GestionJeu(new Grille(10, 10), p1, p2);

            VueJeu vueJeu = new VueJeu(jeu);
            infos.dispose();
        }

    }

}
