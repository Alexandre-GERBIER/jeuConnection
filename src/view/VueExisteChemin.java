package view;

import controller.ExisteCheminValidationControleur;
import model.GestionJeu;

import javax.swing.*;
import java.awt.*;

public class VueExisteChemin extends JFrame {

    private JTextField x1, x2, y1, y2;

    public VueExisteChemin(GestionJeu jeu, VueJeu vue) {
        //Panel initial
        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelInfos = new JPanel(new GridLayout(4, 1));
        panel.add(panelInfos, BorderLayout.CENTER);

        //Partie basse du border layout initial. Panel bouton valider
        JPanel panelValidation = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(panelValidation, BorderLayout.SOUTH);

        x1 = new JTextField("x1");
        panelInfos.add(x1);
        y1 = new JTextField("y1");
        panelInfos.add(y1);
        x2 = new JTextField("x2");
        panelInfos.add(x2);
        y2 = new JTextField("y2");
        panelInfos.add(y2);

        //Validation
        JButton validation = new JButton("Valider");
        validation.addActionListener(new ExisteCheminValidationControleur(jeu, vue, this));
        panelValidation.add(validation);

        //Paramètres de la JFrame
        this.setTitle("ExisteCheminCases");
        this.setSize(350, 220);
        this.setMinimumSize(new Dimension(350, 220));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public JTextField getX1() {
        return x1;
    }

    public JTextField getX2() {
        return x2;
    }

    public JTextField getY1() {
        return y1;
    }

    public JTextField getY2() {
        return y2;
    }

}
