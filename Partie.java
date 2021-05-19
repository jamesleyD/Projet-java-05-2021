public class Partie {
    private Joueur joueurB;
    private Joueur joueurN;
    private Echiquier echiquier;

    public Joueur getJoueurB() {
        return this.joueurB;
    }

    public void setJoueurB(Joueur joueurB) {
        this.joueurB = joueurB;
    }

    public Joueur getJoueurN() {
        return this.joueurN;
    }

    public void setJoueurN(Joueur joueurN) {
        this.joueurN = joueurN;
    }

    public Echiquier getEchiquier() {
        return this.echiquier;
    }

    public void setEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public Partie(Joueur joueurB, Joueur joueurN, Echiquier echiquier) {
        this.joueurB = joueurB;
        this.joueurN = joueurN;
        this.echiquier = echiquier;
    }

    public void init(){};

    public void Charger(){};

    public void Sauvegarder(){};

}
