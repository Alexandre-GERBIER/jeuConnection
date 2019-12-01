package controler;

import view.VueChoixMode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeJeuPseudoControleur implements ActionListener {

    private VueChoixMode vue;

    public ModeJeuPseudoControleur(VueChoixMode _vue) {
        this.vue = _vue;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(this.vue.getMultiplayer().isSelected()) {
            this.vue.getJ2name().setEnabled(true);
            this.vue.getJ2name().setText("J2");
        } else {
            this.vue.getJ2name().setEnabled(false);
            this.vue.getJ2name().setText("Ordinateur");
        }
    }
}
