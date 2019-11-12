package controler;

import model.Joueur;
import view.VueChoixMode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LancementJeu implements ActionListener {

    private VueChoixMode infos;

    public LancementJeu(VueChoixMode _infos) {
        this.infos = _infos;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(!infos.getP1name().getText().trim().isEmpty() && !infos.getP2name().getText().trim().isEmpty()) {
            //Joueur j1 = new Joueur();
            //Joueur j2 = new Joueur();
        }

    }

}
