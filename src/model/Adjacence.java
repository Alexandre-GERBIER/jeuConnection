package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Adjacence {
    private ArrayList<Sommet> sommets;
    private int score;

    public Adjacence(){
        this.sommets = new ArrayList<Sommet>();
    }

    /**
     * @param origine case
     * @return le sommet associé à cette case
     */
    public Sommet getSommetAssocie(Case origine){
        if(origine.getParent() == null){
            return this.findCase(origine);
        } else {
            return this.getSommetAssocie(origine.getParent());
        }
    }


    /**
     * met a jour les cases appartenant aux sommet en paramètre pour les lier au sommet qui lui est associé
     * @param origine ancien sommet
     */
    public void updateSommet(Sommet origine){
        Sommet nouveauSommet = this.getSommetAssocie(origine.getCase().getParent());
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
    public int afficherScore(Case composante){
        Sommet sommet = this.getSommetAssocie(composante);
        if((!sommet.getCase().equals(composante.getParent())) && composante.getParent() != null){
            this.updateSommet(this.getSommetAssocie(composante.getParent()));
        }
        return sommet.getScore();
    }

    /**
     * cherche si une case est dans le tableau de sommet et renvoie le sommet associé
     * @param recherche
     * @return
     */
    public Sommet findCase(Case recherche){
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
            Sommet courant = sommets.remove(0);
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
                Sommet sommetVoisin = this.getSommetAssocie(voisin);
                caseAjout.setParent(sommetVoisin.getCase());
                sommetVoisin.ajouterCase(caseAjout);

                break;

            case 2:

                voisinSommet = voisinColore.getFirst();
                sommets.add(this.getSommetAssocie(voisinSommet));

                Case autreVoisin = voisinColore.getLast();
                sommets.add(this.getSommetAssocie(autreVoisin));

                this.fusion(sommets, caseAjout,2);
                break;

            case 3 :

                voisinSommet = voisinColore.getFirst();
                sommets.add(this.getSommetAssocie(voisinSommet));

                autreVoisin1 = voisinColore.get(1);
                sommets.add(this.getSommetAssocie(autreVoisin1));;

                autreVoisin2 = voisinColore.get(2);
                sommets.add(this.getSommetAssocie(autreVoisin2));

                this.fusion(sommets,caseAjout,3);
                break;

            case 4:

                voisinSommet = voisinColore.getFirst();
                sommets.add(this.getSommetAssocie(voisinSommet));

                autreVoisin1 = voisinColore.get(1);
                sommets.add(this.getSommetAssocie(autreVoisin1));

                autreVoisin2 = voisinColore.get(2);
                sommets.add(this.getSommetAssocie(autreVoisin2));

                Case autreVoisin3 = voisinColore.get(3);
                sommets.add(this.getSommetAssocie(autreVoisin3));

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

    /**
     * renvoie l'ensemble des case de la composante contenat la case passée en paramètre
     * @param origine une case dont on veut connaître l'ensemble des case de sa composante
     * @return une liste des cases de la composante
     */
    public LinkedList<Case> getCasesComposante(Case origine){
        Sommet sommetOrigine = this.getSommetAssocie(origine);
        return sommetOrigine.getCases();
    }

}
