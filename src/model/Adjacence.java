package model;

import java.util.LinkedList;

public class Adjacence {
    private Case[] sommets;
    private int rangMax;
    private int[] scores;

    public Adjacence(int tailleTab){
        this.sommets = new Case[tailleTab/2];
        this.scores = new int[tailleTab/2];
        this.rangMax = 0;
    }

    public void add(Case caseAjout, LinkedList voisinColore){
        switch(voisinColore.size()){
            case 0:
                this.sommets[rangMax] = caseAjout;
                this.scores[rangMax] = caseAjout.getValue();
                this.rangMax++;
                break;
            case 1:
                boolean estPresent = false;
                while (!estPresent) {
                estPresent = false;
                }
                break;
            case 2:

            case 3 :

            case 4:
        }
    }
}
