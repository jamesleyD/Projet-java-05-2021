

public class Cavalier extends Piece  {

    public Cavalier(String couleur, Case position) {
        super(couleur, position,"Cavalier");
    }

    public Cavalier(){}


    //Unicode
    public String Afficher() {
        if (this.getCouleur().equals(new String("Blanc"))) {
            return "\u2658" ;
        }

        else return "\u265E";
    }

    //Vérification d'un déplacement à une position colonne/ligne dans un échiquier
    public boolean Deplacement(Echiquier echiquier,int colonne,char ligne){

            //Position actuelle de la pièce à déplacer
            int thligne =(int)(this.getPosition().getLigne());
            int thcolonne =this.getPosition().getColonne();
            
            //Vérification du déplacement avec toute les situations possible
            //(pas besoin de vérifier les obstacles le cavalier peut sauter des pièces)

            if( this.Verification(((char)(ligne)),colonne,echiquier) ){
                if ( (colonne==thcolonne+2) && ((((int)(ligne))==thligne+1) || (((int)(ligne))==thligne-1)) ) {return true;} 
                else if ( (colonne==thcolonne+1) && ((((int)(ligne))==thligne+2) || (((int)(ligne))==thligne-2)) ) {return true;} 
                else if ( (colonne==thcolonne-2) && ((((int)(ligne))==thligne+1) || (((int)(ligne))==thligne-1)) ) {return true;} 
                else if ( (colonne==thcolonne-1) && ((((int)(ligne))==thligne+2) || (((int)(ligne))==thligne-2)) ) {return true;}
            } return false;
    }
}