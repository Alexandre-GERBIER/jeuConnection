package controler;

import model.Case;
import model.GestionJeu;
import view.VueJeu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RelierComposantesControleur implements MouseListener {

    private Case caseAssociee;
    private VueJeu vue;
    private GestionJeu jeu;

    public RelierComposantesControleur(Case _caseAssociee, VueJeu _vue, GestionJeu _jeu) {
        this.caseAssociee = _caseAssociee;
        this.vue = _vue;
        this.jeu = _jeu;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(SwingUtilities.isRightMouseButton(mouseEvent)) {
            String msg = "Cette case ne relie pas deux composantes";
            if(this.jeu.getGrille().relierComposantes(this.caseAssociee, this.jeu.getJoueurCourant())) {
                msg = "Cette case relie deux composantes";
            }
            JOptionPane.showMessageDialog(new JFrame("Connexion"), msg);
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
