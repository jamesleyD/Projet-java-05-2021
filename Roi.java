
public class Roi extends Piece  {

    public Roi(String couleur, Case position) {
        super(couleur, position,"Roi");
    }

    public Roi(){}

    //Unicode
    public String Afficher() {
        if (this.getCouleur().equals(new String("Blanc"))) {
            return "\u2654" ;
        }

        else return "\u265a";
    }

    //Vérification d'un déplacement à une position colonne/ligne dans un échiquier
    public boolean Deplacement(Echiquier echiquier,int colonne,char ligne){

            //Position initial  de la pièce qui appelle la méthode
            int a=(int)this.getPosition().getLigne();
            int b = this.getPosition().getColonne();

            //Vérification du déplacement retourne vrai si l'une des situations est validée
            if (this.Verification(ligne,colonne,echiquier)){ 
                System.out.println("ok");
                if ((colonne==b+1) && ((int)ligne==a+1)) {return true;}
                else if ((colonne==b+1) && ((int)ligne==a-1)) {return true;}
                else if ((colonne==b+1) && ((int)ligne==a)) {return true;}

                else if ((colonne==b-1) && ((int)ligne==a+1)) {return true;}
                else if ((colonne==b-1) && ((int)ligne==a-1)) {return true;}
                else if ((colonne==b-1) && ((int)ligne==a)) {return true;}

                else if ((colonne==b) && ((int)ligne==a+1)) {return true;}
                else if ((colonne==b) && ((int)ligne==a-1)) {return true;}

            }

            return false;

        }
}