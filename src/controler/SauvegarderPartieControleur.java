package controler;
import model.GestionJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SauvegarderPartieControleur implements ActionListener {

    private GestionJeu jeu;

    public SauvegarderPartieControleur(GestionJeu _jeu) {
        this.jeu = _jeu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            this.jeu.getGrille().ecrireFichier();
            JOptionPane.showMessageDialog(new JFrame("Sauvegarde réussie"), "La partie a bien été sauvegardée dans " + new File("").getAbsolutePath() + "\\saves");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Erreur dans la sauvegarde de la partie");
            e.printStackTrace();
        }
    }
}
