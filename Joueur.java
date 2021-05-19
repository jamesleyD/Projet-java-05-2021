public class Joueur {
    private String couleur;
    private String nom;

    public Joueur(String couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
}
