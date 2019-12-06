package controler;

import view.VueJeu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RelierComposantesControleur implements MouseListener {

    private VueJeu vue;
    private GestionJeu jeu;

    public RelierComposantesControleur(VueJeu _vue, GestionJeu _jeu) {
        this.vue = _vue;
        this.jeu = _jeu;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(SwingUtilities.isRightMouseButton(mouseEvent)) {
            String msg = "Cette case ne relie pas deux composantes";
            if(this.jeu.getGrille())
            JOptionPane.showMessageDialog(new JFrame("Connexion"), "Cette cas");
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}
}
