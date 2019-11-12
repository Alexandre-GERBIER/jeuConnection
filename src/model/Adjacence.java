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
    private Sommet sommet(Case origine){
        while(origine.getParent() != null){
            origine = origine.getParent();
        }
        return this.findCase(origine);
    }

    /**
     * supprime un sommet de la liste d'adjacence et renvoie le score qui lui était associé
     * @param sommet le sommet à supprimer
     * @return le score associé au sommet supprimé
     */
    private int supprimer(Case sommet){
        Sommet sommetAssocie = this.findCase(sommet);
        int score = sommetAssocie.getScore();
        this.sommets.remove(sommetAssocie);
        return score;
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
     * ajout dans l'ordre décroissant de la taille le sommet passé en paramètre au tableau
     * @param sommets tableau de sommets
     * @param nouveau sommet à ajouter au tableau
     * @param taille taille du tableau de sommet (nombre de sommets contenu)
     * @return un tableau trié contenant les sommets du tableau d'origine et le sommet ajouté
     */
    private Sommet[] ajoutTrie(Sommet[] sommets, Sommet nouveau,int taille){
        Sommet[] tri = new Sommet[taille+1];
        int j=0;
        for(int i=0;i<taille; i++){
            if(sommets[i].getTaille() > nouveau.getTaille()){
                tri[j++] = sommets[i];
            } else {
                tri[j++] = nouveau;
                nouveau.setTaille(0);
            }
        }
        return tri;
    }

    /**
     * fusione les sommets contenu dans le tableau en prennant pour racine le plus gros groupe et ajoute également la case à ce groupe
     * @param sommets tableau de sommets à fusionner trié par ordre décroissant du nombre de case par sommet
     * @param caseAjout case à ajouter au groupe obtenu
     * @param taille nombre de sommets dans le tableau
     */
    private void fusion(Sommet[] sommets,Case caseAjout, int taille){
        Sommet nouveauSommet = sommets[0];
        Case nouveauSommetAssocie = nouveauSommet.getCase();

        caseAjout.setParent(nouveauSommetAssocie);
        nouveauSommet.ajouterCase(caseAjout);

        for(int i=1; i<taille; i++){
            Sommet courant = sommets[i];
            courant.getCase().setParent(nouveauSommetAssocie);
            LinkedList<Case> filsCourant = courant.getCases();
            while(!filsCourant.isEmpty()){
                nouveauSommet.ajouterCase(filsCourant.pop());
            }
            this.sommets.remove(courant);
        }
    }

    public int getScore(){
        return this.score;
    }

    /**
     * fonction d'ajout d'une case au tableau d'adjacence du joueur et mise à jour du score associé au groupe
     * @param caseAjout la case qui vient d'être colorée à ajouter au tableau
     * @param voisinColore liste des voisins de la même couleur que la case à ajouter
     */
    public void add(Case caseAjout, LinkedList<Case> voisinColore){
        Sommet[] sommets;
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
                sommets = new Sommet[2];

                voisinSommet = voisinColore.getFirst();
                sommets[0] = this.sommet(voisinSommet);

                Case autreVoisin = voisinColore.getLast();
                sommets = this.ajoutTrie(sommets, this.sommet(autreVoisin),1);

                this.fusion(sommets, caseAjout,2);
                break;

            case 3 :
                sommets = new Sommet[3];

                voisinSommet = voisinColore.getFirst();
                sommets[0] = this.sommet(voisinSommet);

                autreVoisin1 = voisinColore.get(1);
                sommets = this.ajoutTrie(sommets, this.sommet(autreVoisin1),1);;

                autreVoisin2 = voisinColore.get(2);
                sommets = this.ajoutTrie(sommets, this.sommet(autreVoisin2),2);

                this.fusion(sommets,caseAjout,3);
                break;

            case 4:
                sommets = new Sommet[4];

                voisinSommet = voisinColore.getFirst();
                sommets[0] = this.sommet(voisinSommet);

                autreVoisin1 = voisinColore.get(1);
                sommets = this.ajoutTrie(sommets, this.sommet(autreVoisin1),1);

                autreVoisin2 = voisinColore.get(2);
                sommets = this.ajoutTrie(sommets, this.sommet(autreVoisin2),2);

                Case autreVoisin3 = voisinColore.get(3);
                sommets = this.ajoutTrie(sommets, this.sommet(autreVoisin3),3);

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
