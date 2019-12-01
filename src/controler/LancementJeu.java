package controler;

import model.Grille;
import model.Joueur;
import model.Bot;
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

        //Récupération des informations des joueurs
        String j1name = infos.getJ1name().getText().trim();
        String j2name = infos.getJ2name().getText().trim();
        boolean bot = !infos.getMultiplayer().isSelected();
        String tailleGrille = infos.getTailleGrille().getText();
        String valeurCases = infos.getValeurCases().getText();

        //Création de la  grille et de la GestionJeu associées aux paramètres récupérés
        if(j1name.isEmpty() || j2name.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Les deux joueurs doivent avoir un nom");
            return;
        } else if(tailleGrille.isEmpty() || valeurCases.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Les valeurs paramètres doivent être renseignées");
            return;
        } else if(!tailleGrille.matches("[0-9]+") || !valeurCases.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(new JFrame("Erreur"), "Les valeurs paramètres doivent être des entiers positifs");
            return;
        }
        //Joueur vs IA
        else if(bot){
            Joueur p1 = new Joueur(j1name, Color.BLUE);
            Grille grille = new Grille(Integer.parseInt(tailleGrille), Integer.parseInt(valeurCases));
            Bot p2 = new Bot(j2name, Color.RED, grille);
            GestionJeu jeu = new GestionJeu(grille, p1, p2);
            new VueJeu(jeu);
            infos.dispose();
        }
        //Joueur vs Joueur
        else {
            Joueur p1 = new Joueur(j1name, Color.BLUE);
            Joueur p2 = new Joueur(j2name, Color.RED);
            GestionJeu jeu = new GestionJeu(new Grille(Integer.parseInt(tailleGrille), Integer.parseInt(valeurCases)), p1, p2);
            new VueJeu(jeu);
            infos.dispose();
        }

    }

}
