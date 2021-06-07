
public class Tours extends Piece  {

    public Tours(String couleur, Case position) {
        super(couleur, position,"Tour");
    }

    public Tours(){}

    //Unicode
    public String Afficher() {
        if (this.getCouleur().equals(new String("Blanc"))) {
            return "\u2656" ;
        }

        else return "\u265c";
    }

    //Vérification d'obstacle selon toute les situations possible
    private boolean obstacle(char ligne,int colonne,Echiquier echiquier) {

        //Position actuelle de la pièce  thligne et  thcolonne
        char thligne = this.getPosition().getLigne();
        int thcolonne = this.getPosition().getColonne();
        int n= ((thcolonne*8)-1)-(((int)(thligne))-97);


        //Retourne faux si il trouve un obstacle entre la position voulu et la pièce
        if (colonne==thcolonne) {
            int i=(int)(thligne)-(int)(ligne);
            if (i<0) {i+=1;} else {i-=1;}
            while (0!=i) {
                if (echiquier.getCasse()[n-(i)] != null) {break;}
                else if (i<0) {i+=1;} else {i-=1;}
            }
            if (i==0) {return true;}
        }

        else if (ligne==thligne) {
            int i =0;
            while ((Math.abs(thcolonne-colonne)-1)!=i) {
                System.out.println(n);
                if (thcolonne<colonne) {n+=8;} else {n-=8;}
                System.out.println(n);
                if (echiquier.getCasse()[n]==null) {i+=1;} else {break;}     
            }
            if (i==(Math.abs(thcolonne-colonne)-1)) {return true;}

        }

        return false;
    }

    //Vérification d'un déplacement à une position colonne/ligne dans un échiquier
    public boolean Deplacement(Echiquier echiquier,int colonne,char ligne){

            //Position actuelle de la pièce qui appelle la méthode  thligne et  thcolonne
            char thligne = this.getPosition().getLigne();
            int thcolonne = this.getPosition().getColonne();

            //Vérification de la validitité du déplacement
            if (this.Verification(ligne,colonne,echiquier)) {
                if ((colonne==thcolonne) && ((thligne !="b".charAt(0)) && ligne!="a".charAt(0) || (thligne!="g".charAt(0) && ligne!="h".charAt(0)))) {
                    if (this.obstacle(ligne, colonne,echiquier)) {return true;}
                }
                
                else if ((ligne==thligne) && (((thcolonne!=7) && colonne!=8) || ((thcolonne!=2) && colonne!=1))) {
                    if (this.obstacle(ligne, colonne,echiquier)) {return true;}
                }

                else if ((colonne==thcolonne) || (ligne==thligne)) {return true;}

            }return false;

    }

}   

