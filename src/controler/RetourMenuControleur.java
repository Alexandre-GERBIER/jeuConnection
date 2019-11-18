package controler;

import view.VueChoixMode;
import view.VueJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuControleur implements ActionListener {

    private VueJeu vue;

    public RetourMenuControleur(VueJeu _vue) {
        this.vue = _vue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.vue.dispose();
        new VueChoixMode();
    }
}
