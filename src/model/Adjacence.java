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

    private Case sommet(Case origine){
        while(origine.getParent() != null){
            origine = origine.getParent();
        }
        return origine;
    }

    private int findCase(Case recherche){
        for(int i=0;i<this.rangMax;i++){
            if(this.sommets.equals(recherche)){
                return i;
            }
        }
        return -1;
    }

    public void add(Case caseAjout, LinkedList<Case> voisinColore){
        int rangSommet, rangOldSommet1, rangOldSommet2;
        Case newSommet, voisinSommet, autreVoisin1,autreVoisin2,oldSommet1,oldSommet2;
        switch(voisinColore.size()){
            case 0:
                this.sommets[rangMax] = caseAjout;
                this.scores[rangMax] = caseAjout.getValue();
                this.rangMax++;
                break;

            case 1:
                Case voisin = voisinColore.getFirst();
                caseAjout.setParent(voisin);
                Case sommetVoisin = this.sommet(voisin);
                rangSommet = this.findCase(sommetVoisin);
                this.scores[rangSommet] += caseAjout.getValue();
                break;

            case 2:
                voisinSommet = voisinColore.getFirst();
                caseAjout.setParent(voisinSommet);
                newSommet = this.sommet(voisinSommet);
                rangSommet = this.findCase(newSommet);
                this.scores[rangSommet] += caseAjout.getValue();

                Case autreVoisin = voisinColore.getLast();
                Case oldSommet = this.sommet(autreVoisin);
                oldSommet.setParent(newSommet);
                int rangOldSommet = this.findCase(oldSommet);
                this.scores[rangSommet] += this.scores[rangOldSommet];
                this.scores[rangOldSommet] = 0;
                this.sommets[rangOldSommet] = null;
                break;

            case 3 :
                voisinSommet = voisinColore.getFirst();
                caseAjout.setParent(voisinSommet);
                newSommet = this.sommet(voisinSommet);
                rangSommet = this.findCase(newSommet);
                this.scores[rangSommet] += caseAjout.getValue();

                autreVoisin1 = voisinColore.get(1);
                oldSommet1 = this.sommet(autreVoisin1);
                oldSommet1.setParent(newSommet);
                rangOldSommet1 = this.findCase(oldSommet1);
                this.scores[rangSommet] += this.scores[rangOldSommet1];
                this.scores[rangOldSommet1] = 0;
                this.sommets[rangOldSommet1] = null;

                autreVoisin2 = voisinColore.get(2);
                oldSommet2 = this.sommet(autreVoisin2);
                oldSommet2.setParent(newSommet);
                rangOldSommet2 = this.findCase(oldSommet2);
                this.scores[rangSommet] += this.scores[rangOldSommet2];
                this.scores[rangOldSommet2] = 0;
                this.sommets[rangOldSommet2] = null;

            case 4:
                voisinSommet = voisinColore.getFirst();
                caseAjout.setParent(voisinSommet);
                newSommet = this.sommet(voisinSommet);
                rangSommet = this.findCase(newSommet);
                this.scores[rangSommet] += caseAjout.getValue();

                autreVoisin1 = voisinColore.get(1);
                oldSommet1 = this.sommet(autreVoisin1);
                oldSommet1.setParent(newSommet);
                rangOldSommet1 = this.findCase(oldSommet1);
                this.scores[rangSommet] += this.scores[rangOldSommet1];
                this.scores[rangOldSommet1] = 0;
                this.sommets[rangOldSommet1] = null;

                autreVoisin2 = voisinColore.get(2);
                oldSommet2 = this.sommet(autreVoisin2);
                oldSommet2.setParent(newSommet);
                rangOldSommet2 = this.findCase(oldSommet2);
                this.scores[rangSommet] += this.scores[rangOldSommet2];
                this.scores[rangOldSommet2] = 0;
                this.sommets[rangOldSommet2] = null;

                Case autreVoisin3 = voisinColore.get(3);
                Case oldSommet3 = this.sommet(autreVoisin3);
                oldSommet3.setParent(newSommet);
                int rangOldSommet3 = this.findCase(oldSommet3);
                this.scores[rangSommet] += this.scores[rangOldSommet3];
                this.scores[rangOldSommet3] = 0;
                this.sommets[rangOldSommet3] = null;
        }
    }
}
