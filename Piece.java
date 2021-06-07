public abstract class  Piece {
    private String couleur;
    private Case position;
    private String nom;

    public Piece() {}

    public Piece(String couleur, Case position,String nom) {
        this.couleur = couleur;
        this.position = position;
        this.nom = nom;
    }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }


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

    public Piece(Piece p) {
        this.position = new Case (p.getPosition().getLigne(),p.getPosition().getColonne(),this);
        this.couleur = new String (p.getCouleur());
    }    

    //Affiche la position de la pièce ex h2  
    public void Afficher_position() {System.out.println(this.position.getLigne()) ;System.out.print(this.position.getColonne());}

    //Va capturer une pièce cad réinitialiser la pièce qui est déplacer et la transférer dans la case capturer 
    //La méthode renvoie une pièce pour savoir si la pièce capturée n'est pas le roi
    public Piece Capture(Echiquier echiquier,int colonne,char ligne) {

        //Ligne et colonne de la pièce qui appelle la méthode
        char thligne = this.getPosition().getLigne();
        int thcolonne = this.getPosition().getColonne();
        int position=((thcolonne*8)-1)-(((int)(thligne))-97); //Position initial dans l'échiquier de la pièce 
        int nb=((colonne*8)-1)-(((int)(ligne))-97); //Position dans l'échiquier de la pièce qui va etre capturée

        //Initialisation de la pièce qui va etre renvoyer
        Piece p;
        if (echiquier.getCasse()[nb]==null) {p = null;} else  {p = echiquier.getCasse()[nb].getPiece();}

        //Va réinitialiser la case initial de la pièce et la transférer toute les informations dans la case capturer
        echiquier.getCasse()[position]=null;

        this.setPosition(new Case(ligne,colonne,this));
        echiquier.setCasse(nb,this.getPosition());

        if (p==null) return new Pions("none",null); else return p;
    }

    //Va faire 3 test pr savoir si une position voulu est correct au niveau du format et que si cette position n'est pas vide qu'elle n'habrite pas de pièce allier
    public boolean Verification(char ligne,int colonne,Echiquier echiquier){
        int nb=((colonne*8)-1)-(((int)(ligne))-97);;
        boolean test1= false;
        boolean test2= false;
        boolean test3= false;
        if (colonne>0 && colonne<9 ) {test1=true;}
        if ((int)ligne>96 && (int)ligne<105 ) {test2=true;}
        if ( echiquier.getCasse()[nb]==null) {test3=true;}
        else if (echiquier.getCasse()[nb].getPiece().getCouleur().equals(this.getCouleur()) == false) {test3=true;}
        return test1 && test2 && test3;
    }

    public abstract boolean Deplacement(Echiquier echiquier,int colonne,char ligne); //Vérification déplacement
    public abstract String Afficher() ; //Affichage unicode

}
