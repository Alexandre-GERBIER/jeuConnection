package view;

import controler.*;

import javax.swing.*;
import java.awt.*;

public class VueJeu extends JFrame {

    private GestionJeu jeu;

    public VueJeu(GestionJeu _jeu) {
        this.jeu = _jeu;

        //Panel initial
        JPanel panel = new JPanel();

        //Paramètres de la JFrame
        this.setTitle("Choix du mode de jeu");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

}
