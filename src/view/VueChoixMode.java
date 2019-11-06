package view;

import javax.swing.*;
import java.awt.*;

public class VueChoixMode extends JFrame {

    public VueChoixMode() {

        //Panel initial
        JPanel panel = new JPanel(new BorderLayout());

        //Partie haute du grid layout initial. Panel du game mode
        JPanel gameModePanel = new JPanel();
        gameModePanel.setLayout(new BoxLayout(gameModePanel, BoxLayout.X_AXIS));
        gameModePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(gameModePanel, BorderLayout.NORTH);

        //Partie basse du grid layout initial. Panel des players
        JPanel playersPanel = new JPanel(new GridLayout(1, 2));
        panel.add(playersPanel, BorderLayout.CENTER);

        //Panel du P1
        JPanel p1panel = new JPanel();
        p1panel.setLayout(new BoxLayout(p1panel, BoxLayout.Y_AXIS));
        playersPanel.add(p1panel);

        //Panel du P2
        JPanel p2panel = new JPanel();
        p2panel.setLayout(new BoxLayout(p2panel, BoxLayout.Y_AXIS));
        playersPanel.add(p2panel);

        //Boutons de choix du mode de jeu
        ButtonGroup gameModeButtonGroup = new ButtonGroup();
        JRadioButton multiplayer = new JRadioButton("Multiplayer");
        gameModeButtonGroup.add(multiplayer);
        JRadioButton bot = new JRadioButton("Bot");
        gameModeButtonGroup.add(bot);

        gameModePanel.add(multiplayer);
        gameModePanel.add(bot);

        //Joueur 1
        JPanel p1labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea p1text = new JTextArea("Joueur 1");
        p1text.setOpaque(false);
        p1text.setEditable(false);
        p1labelPanel.add(p1text);
        p1panel.add(p1labelPanel);

        JTextField p1 = new JTextField();
        p1panel.add(p1);

        JPanel p1colorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton p1color = new JButton("Couleur");
        p1colorPanel.add(p1color);
        p1panel.add(p1colorPanel);

        //Joueur 2
        JPanel p2labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea p2text = new JTextArea("Joueur 2");
        p2text.setOpaque(false);
        p2text.setEditable(false);
        p2labelPanel.add(p2text);
        p2panel.add(p2labelPanel);

        JTextField p2 = new JTextField();
        p2panel.add(p2);

        JPanel p2colorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton p2color = new JButton("Couleur");
        p2colorPanel.add(p2color);
        p2panel.add(p2colorPanel);

        //Paramètres de la JFrame
        this.setTitle("Choix du mode de jeu");
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

}
