

public class Fous extends Piece {

    public Fous(String couleur, Case position) {
        super(couleur, position,"Fou");
    }

    public Fous(){}

    public String Afficher() {
        if (this.getCouleur().equals(new String("Blanc"))) {
            return "\u2657" ;
        }

        else return "\u265D";
    }


    //Méthode de détection d'obstacle
    private boolean obstacle(char ligne,int colonne,Echiquier echiquier) {
        //Position initial de la pièce
        char thligne = this.getPosition().getLigne();
        int thcolonne = this.getPosition().getColonne();
        int n= ((thcolonne*8)-1)-(((int)(thligne))-97);
        int i =0;
        //Vérification d'obstacle selon toute les situations possible
        //Retourne faux si il trouve un obstacle entre la position voulu et la pièce

        if ( ((int)(thligne)<(int)(ligne)) && ( thcolonne<colonne ) ) {
            System.out.println("Ok1");
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n+(8*i)-i]!=null) {
                    return false;  
                }
            }
            return true;
        }

        else if ( ((int)(thligne)>(int)(ligne)) && ( thcolonne>colonne ) ) {
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n-(8*i)+i]!=null) {
                    return false; 
                }
            }
            return true;
        }

        else if ( ((int)(thligne)<(int)(ligne)) && ( thcolonne>colonne ) ) {
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n-(8*i)-i]!=null) {
                    return false; 
                }
            }
            return true;
        }
        else  {
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n+(8*i)+i]!=null) {
                    return false; 
                }
            }
            return true;
        }
    }    
 


    //Vérification d'un déplacement à une position colonne/ligne dans un échiquier
    public boolean Deplacement(Echiquier echiquier,int colonne,char ligne) {


            //Position actuelle de la pièce  thligne et  thcolonne
            char thligne = this.getPosition().getLigne();
            int thcolonne = this.getPosition().getColonne();

            if (this.Verification(ligne,colonne,echiquier)){

                //Calcul des positions autoriser enn fonction de la ligne (si la ligne est valide la colonne l'est forcément sinon erreur)
                char s1=(char)(((int)(thligne))+(Math.abs((thcolonne)-colonne)));
                char s2=(char)(((int)(thligne))-(Math.abs((thcolonne)-colonne)));

                //Vérification de la position avec s1 et s2
                if ( ( (ligne == s1) || (ligne == s2) ) ) {
                    //Situation ou le déplacement n'est pas que de une case (si oui on vérifie les obstacles)
                    if (( (int)(ligne)!=((int)(thligne))+1 ) && ( (int)(ligne)!=((int)(thligne))-1 )) {
                        //Obstacle
                        if (this.obstacle(ligne, colonne, echiquier)) {
                            return true;
                        }
                    }
                    //Si le déplacement est de 1 case alors on valide le déplacement sans vérifier les obstacles
                    else {return true;}

                }
            }return false;
    }

}


