package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.awt.*;

public class VueChoixMode extends JFrame {

    public VueChoixMode() {

        //Panel initial
        JPanel panel = new JPanel(new BorderLayout());

        //Partie haute du grid layout initial. Panel du game mode
        JPanel gameModePanel = new JPanel();
        gameModePanel.setLayout(new BoxLayout(gameModePanel, BoxLayout.X_AXIS));
        panel.add(gameModePanel, BorderLayout.NORTH);

        //Partie basse du grid layout initial. Panel des players
        JPanel playersPanel = new JPanel(new GridLayout(1, 2));
        panel.add(playersPanel, BorderLayout.CENTER);

        //Panel du P1
        JPanel p1panel = new JPanel(new GridLayout(3, 1));
        playersPanel.add(p1panel);

        //Panel du P2
        JPanel p2panel = new JPanel(new GridLayout(3, 1));
        playersPanel.add(p2panel);

        //Boutons de choix du mode de jeu
        ButtonGroup gameModeButtonGroup = new ButtonGroup();
        JRadioButton multiplayer = new JRadioButton("Multiplayer");
        multiplayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameModeButtonGroup.add(multiplayer);
        JRadioButton bot = new JRadioButton("Bot");
        bot.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameModeButtonGroup.add(bot);

        gameModePanel.add(multiplayer);
        gameModePanel.add(bot);

        //Joueur 1
        JPanel p1label = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea p1text = new JTextArea("Joueur 1");
        p1text.setAlignmentY(Component.CENTER_ALIGNMENT);
        p1text.setOpaque(false);
        p1text.setEditable(false);
        p1label.add(p1text);
        p1panel.add(p1label);

        JTextField p1 = new JTextField();
        p1panel.add(p1);

        JButton p1color = new JButton("Couleur");
        p1color.setSize(new Dimension(50, 20));
        p1panel.add(p1color);

        //Joueur 2
        JPanel p2label = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea p2text = new JTextArea("Joueur 2");
        p2text.setOpaque(false);
        p2text.setEditable(false);
        p2label.add(p2text);
        p2panel.add(p2label);

        JTextField p2 = new JTextField();
        p2panel.add(p2);

        JButton p2color = new JButton("Couleur");
        p2color.setSize(new Dimension(50, 20));
        p2panel.add(p2color);

        //Paramètres de la JFrame
        this.setTitle("Choix du mode de jeu");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

}
