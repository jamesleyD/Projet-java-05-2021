public class Echiquier {
    private Case[] casse;

    public Case[] getCasse() {
        return this.casse;
    }

    public void setCasse(Case[] casse) {
        this.casse = casse;
    }

    public Echiquier(Case[] casse) {
        if (casse.length == 63) {this.casse=casse;}
        else {System.out.println("Taille du tableaux invalide.");}
    }
     
}
