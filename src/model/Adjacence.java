package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Adjacence {
    private ArrayList<Sommet> sommets;
    private int score;

    //TODO pb quand lecture valeur adjacence depuis sommet (1ere case) , pb depuis modif pour maj sommet lors de fusion dans recherche et non à l'ajout
    //TODO complexité


    public Adjacence(){
        this.sommets = new ArrayList<Sommet>();
    }

    /**
     * @param origine case
     * @return le sommet associé à cette case
     */
    public Sommet sommet(Case origine){
        if(origine.getParent() == null){
            return this.findCase(origine);
        } else {
            return this.sommet(origine.getParent());
        }
    }


    public void updateSommet(Sommet origine){
        Sommet nouveauSommet = this.sommet(origine.getCase().getParent());
        LinkedList<Case> filsCourant = origine.getCases();
        while (!filsCourant.isEmpty()) {
            nouveauSommet.ajouterCase(filsCourant.pop());
        }
        this.sommets.remove(origine);
    }

    /**
     * renvoie le score de la composante à laquelle la case appartient et si la case n'est pas réliée au sommet du groupe, mets à jour le lien de toutes les cases
     * @param composante la case d'origine
     * @return le score de la composante
     */
    public int getScore(Case composante){
        Sommet sommet = this.sommet(composante);
        if((!sommet.getCase().equals(composante.getParent())) && composante.getParent() != null){
            this.updateSommet(this.sommet(composante.getParent()));
        }
        return sommet.getScore();
    }

    /**
     * cherche si une case est dans le tableau de sommet et renvoie le sommet associé
     * @param recherche
     * @return
     */
    private Sommet findCase(Case recherche){
        for(int i=0;i<this.sommets.size();i++){
            Sommet current = this.sommets.get(i);
            if(current.getCase().equals(recherche) ){
                return current;
            }
        }
        return null;
    }

    /**
     * fonction renvoyant le sommet ayant le plus de fils et l'enlevant du tableau
     * @param sommets un tableau de sommets
     * @return le sommet aynt le plus de fils
     */
    private Sommet getSommetMax(ArrayList<Sommet> sommets){
        Sommet max = sommets.get(0);
        for(Sommet courant : sommets){
            if(courant.getScore() > max.getScore()){
                max = courant;
            }
        }
        sommets.remove(max);
        return max;
    }

    /**
     * fusione les sommets contenu dans le tableau en prennant pour racine le plus gros groupe et ajoute également la case à ce groupe
     * @param sommets tableau de sommets à fusionner trié par ordre décroissant du nombre de case par sommet
     * @param caseAjout case à ajouter au groupe obtenu
     * @param taille nombre de sommets dans le tableau
     */
    private void fusion(ArrayList<Sommet> sommets,Case caseAjout, int taille){
        Sommet nouveauSommet = this.getSommetMax(sommets);
        Case nouveauSommetAssocie = nouveauSommet.getCase();

        caseAjout.setParent(nouveauSommetAssocie);
        nouveauSommet.ajouterCase(caseAjout);

        for(int i=1; i<taille; i++){
            Sommet courant = this.getSommetMax(sommets);
            if(!courant.equals(nouveauSommet)) {
                Case caseOldSommet = courant.getCase();
                caseOldSommet.setParent(nouveauSommetAssocie);
                nouveauSommet.ajouterCase(caseOldSommet);
            }
        }
    }

    /**
     * renvoie le score maximum d'une zone du joueur
     * @return score
     */
    public int getScore(){
        return this.score;
    }

    /**
     * fonction d'ajout d'une case au tableau d'adjacence du joueur et mise à jour du score associé au groupe
     * @param caseAjout la case qui vient d'être colorée à ajouter au tableau
     * @param voisinColore liste des voisins de la même couleur que la case à ajouter
     */
    public void add(Case caseAjout, LinkedList<Case> voisinColore){
        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        Case voisinSommet, autreVoisin1,autreVoisin2;
        switch(voisinColore.size()){
            case 0:
                this.sommets.add(new Sommet(caseAjout));
                break;

            case 1:
                Case voisin = voisinColore.getFirst();
                Sommet sommetVoisin = this.sommet(voisin);
                caseAjout.setParent(sommetVoisin.getCase());
                sommetVoisin.ajouterCase(caseAjout);

                break;

            case 2:

                voisinSommet = voisinColore.getFirst();
                sommets.add(this.sommet(voisinSommet));

                Case autreVoisin = voisinColore.getLast();
                sommets.add(this.sommet(autreVoisin));

                this.fusion(sommets, caseAjout,2);
                break;

            case 3 :

                voisinSommet = voisinColore.getFirst();
                sommets.add(this.sommet(voisinSommet));

                autreVoisin1 = voisinColore.get(1);
                sommets.add(this.sommet(autreVoisin1));;

                autreVoisin2 = voisinColore.get(2);
                sommets.add(this.sommet(autreVoisin2));

                this.fusion(sommets,caseAjout,3);
                break;

            case 4:

                voisinSommet = voisinColore.getFirst();
                sommets.add(this.sommet(voisinSommet));

                autreVoisin1 = voisinColore.get(1);
                sommets.add(this.sommet(autreVoisin1));

                autreVoisin2 = voisinColore.get(2);
                sommets.add(this.sommet(autreVoisin2));

                Case autreVoisin3 = voisinColore.get(3);
                sommets.add(this.sommet(autreVoisin3));

                this.fusion(sommets,caseAjout,4);
        }

        int max = 0;
        for (Sommet courant : this.sommets){
           if(courant.getScore() > max ){
               max = courant.getScore();
           }
        }
        this.score = max;
    }
}
