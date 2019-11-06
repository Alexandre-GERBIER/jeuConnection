package model;

import java.awt.*;

public class Sommet {
    private int score;
    private Case sommet;

    public Sommet(Case newSommet){
        this.sommet = newSommet;
        this.score = newSommet.getValue();
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int val){
        this.score += val;
    }
}
