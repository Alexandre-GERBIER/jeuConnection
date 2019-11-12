package view;

import controler.LancementJeu;

import javax.swing.*;
import java.awt.*;

public class VueChoixMode extends JFrame {

    private JTextField j1name, j2name, tailleGrille, valeurCases;

    public VueChoixMode() {
        //Panel initial
        JPanel panel = new JPanel(new BorderLayout());

        //Partie haute du border layout initial. Panel du game mode
        JPanel panelMode = new JPanel();
        panel.add(panelMode, BorderLayout.NORTH);

        //Partie centrale du border layout initial. Panel des players
        JPanel panelJoueurs = new JPanel(new GridLayout(1, 2));
        panel.add(panelJoueurs, BorderLayout.CENTER);

        //Partie basse du border layout initial. Panel bouton valider
        JPanel panelValidation = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(panelValidation, BorderLayout.SOUTH);

        //Panel du P1
        JPanel j1panel = new JPanel();
        j1panel.setLayout(new BoxLayout(j1panel, BoxLayout.Y_AXIS));
        panelJoueurs.add(j1panel);

        //Panel du P2
        JPanel j2panel = new JPanel();
        j2panel.setLayout(new BoxLayout(j2panel, BoxLayout.Y_AXIS));
        panelJoueurs.add(j2panel);

        //Panel des boutons radio
        JPanel panelRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMode.add(panelRadio);

        //Panel paramètres de la grille
        JPanel panelParams = new JPanel();
        panelParams.setLayout(new BoxLayout(panelParams, BoxLayout.Y_AXIS));
        panelMode.add(panelParams);

        //Boutons de choix du mode de jeu
        ButtonGroup groupeRadioMode = new ButtonGroup();
        JRadioButton multiplayer = new JRadioButton("Multiplayer");
        multiplayer.setSelected(true);
        groupeRadioMode.add(multiplayer);
        JRadioButton bot = new JRadioButton("Bot");
        groupeRadioMode.add(bot);

        panelMode.add(multiplayer);
        panelMode.add(bot);

        //Joueur 1
        JPanel panelJ1label = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea j1text = new JTextArea("Joueur 1");
        j1text.setOpaque(false);
        j1text.setEditable(false);
        panelJ1label.add(j1text);
        j1panel.add(panelJ1label);

        j1name = new JTextField();
        j1panel.add(j1name);

        //Joueur 2
        JPanel panelJ2label = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea j2text = new JTextArea("Joueur 2");
        j2text.setOpaque(false);
        j2text.setEditable(false);
        panelJ2label.add(j2text);
        j2panel.add(panelJ2label);

        j2name = new JTextField();
        j2panel.add(j2name);

        //Paramètres grille
        JTextArea tailleGrilleText = new JTextArea("Taille de la grille");
        tailleGrilleText.setOpaque(false);
        tailleGrilleText.setEditable(false);
        panelParams.add(tailleGrilleText);
        tailleGrille = new JTextField();
        panelParams.add(tailleGrille);
        JTextArea valeurCasesText = new JTextArea("Valeur max des cases");
        valeurCasesText.setOpaque(false);
        valeurCasesText.setEditable(false);
        panelParams.add(valeurCasesText);
        valeurCases = new JTextField();
        panelParams.add(valeurCases);

        //Validation
        JButton validation = new JButton("Valider");
        validation.addActionListener(new LancementJeu(this));
        panelValidation.add(validation);

        //Paramètres de la JFrame
        this.setTitle("Choix du mode de jeu");
        this.setSize(350, 220);
        this.setMinimumSize(new Dimension(350, 220));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public JTextField getJ1name() {
        return j1name;
    }

    public JTextField getJ2name() {
        return j2name;
    }

    public JTextField getTailleGrille() {
        return tailleGrille;
    }

    public JTextField getValeurCases() {
        return valeurCases;
    }

}
