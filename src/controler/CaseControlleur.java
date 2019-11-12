package controler;

import model.Case;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaseControlleur implements ActionListener {

    private Case caseAssociee;

    public CaseControlleur(Case newCase){
        this.caseAssociee = newCase;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
