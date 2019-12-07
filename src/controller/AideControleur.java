package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AideControleur implements ActionListener {

    public AideControleur() {}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String message = "La fonction colorerCase() s'utilise en cliquant sur une case blanche.\n" +
                         "Les fonctions afficherComposante() et afficherScore() s'utilisent en cliquant sur une case colorée.\n" +
                         "La fonction relierComposante() s'utilise en effectuant un clic droit sur une case.\n" +
                         "La fonction existeCheminCases() s'utile à l'aide du bouton Existe Chemin.";
        JOptionPane.showMessageDialog(new JFrame("Aide"), message);
    }
}
