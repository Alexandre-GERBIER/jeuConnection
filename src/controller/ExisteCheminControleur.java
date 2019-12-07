package controller;

import model.GestionJeu;
import view.VueExisteChemin;
import view.VueJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExisteCheminControleur implements ActionListener {

    private GestionJeu jeu;
    private VueJeu vue;

    public ExisteCheminControleur(GestionJeu _jeu, VueJeu _vue) {
        this.jeu = _jeu;
        this.vue = _vue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new VueExisteChemin(this.jeu, this.vue);
    }
}
