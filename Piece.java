public class Piece {
    private String couleur;
    private Case position;

    public Piece() {
    }

    public Piece(String couleur, Case position) {
        this.couleur = couleur;
        this.position = position;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Case getPosition() {
        return this.position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public Piece couleur(String couleur) {
        setCouleur(couleur);
        return this;
    }

    public Piece position(Case position) {
        setPosition(position);
        return this;
    }

    public void Capture(Echiquier echiquier,int colonne,char ligne) {
        int nb=((colonne)*8)-(8-(((int)ligne)+97));
        //gauche à droite,97=a et 104=h
        Case n = new Case(ligne,colonne,this);
        this.setPosition(n);
        echiquier.getCasse()[nb]= n ;       
    }

    public boolean Verification(char ligne,int colonne,Echiquier echiquier,int nb){
        boolean test1= false;
        boolean test2= false;
        boolean test3;
        if (colonne>0 && colonne<9 ) {test1=true;}
        if ((int)ligne>96 && (int)ligne<105 ) {test1=true;}
        if ( echiquier.getCasse()[nb].getPiece().getCouleur().equals(this.getCouleur()) ) {test3=false;}
            else {test3=true;}
        return test1 && test2 && test3;
    }

}
