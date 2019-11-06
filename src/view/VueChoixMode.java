package view;

import javax.swing.*;
import java.awt.*;

public class VueChoixMode extends JFrame {

    public VueChoixMode() {

        //Panel initial

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        //Partie haute du grid layout initial. Panel du game mode

        JPanel gameModePanel = new JPanel();
        gameModePanel.setLayout(new FlowLayout());
        panel.add(gameModePanel);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton multiplayer = new JRadioButton();
        bg.add(multiplayer);
        JRadioButton bot = new JRadioButton();
        bg.add(bot);

        gameModePanel.add(multiplayer);
        JTextArea multiplayerText = new JTextArea("Multijoueurs");
        gameModePanel.add(multiplayerText);
        gameModePanel.add(bot);
        JTextArea botText = new JTextArea("Bot");
        gameModePanel.add(botText);

        //Partie basse du grid layout initial. Panel des players

        JPanel playersPanel = new JPanel();
        playersPanel.setLayout(new GridLayout(2, 3));
        panel.add(playersPanel);

        JTextArea j1text = new JTextArea("Joueur 1 :");
        j1text.setEditable(false);
        playersPanel.add(j1text);
        JTextField j1 = new JTextField();
        playersPanel.add(j1);
        JButton j1color = new JButton("Couleur");
        playersPanel.add(j1color);

        JTextArea j2text = new JTextArea("Joueur 2 :");
        playersPanel.add(j2text);
        j2text.setEditable(false);
        JTextField j2 = new JTextField();
        playersPanel.add(j2);
        JButton j2color = new JButton("Couleur");
        playersPanel.add(j2color);

        //Paramètres de la JFrame

        this.setTitle("Choix du mode de jeu");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }

}
