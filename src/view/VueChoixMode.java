package view;

import javax.swing.*;
import java.awt.*;

public class VueChoixMode extends JFrame {

    public VueChoixMode() {

        JTextArea j1text = new JTextArea("Joueur 1 :");
        JTextField j1 = new JTextField();
        JTextArea j2text = new JTextArea("Joueur 2 :");
        JTextField j2 = new JTextField();

        this.setTitle("Choix du mode de jeu");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
