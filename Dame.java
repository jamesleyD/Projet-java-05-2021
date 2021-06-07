

public class Dame extends Piece  {

    public Dame(String couleur, Case position) {
        super(couleur, position,"Dame");
    }

    public Dame(){}

    //Unicode
    public String Afficher() {
        if (this.getCouleur().equals(new String("Blanc"))) {
            return "\u2655" ;
        }

        else return "\u265b";
    }

    //Importation de la méthode obstacle du fou pour la dame
    //Méthode de détection d'obstacle
    private boolean obstacle_fou(char ligne,int colonne,Echiquier echiquier) {
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

    //Importation de la méthode obstacle de la tour pour la dame
    private boolean obstacle_tour(char ligne,int colonne,Echiquier echiquier) {

        //Position actuelle de la pièce  thligne et  thcolonne
        char thligne = this.getPosition().getLigne();
        int thcolonne = this.getPosition().getColonne();
        int n= ((thcolonne*8)-1)-(((int)(thligne))-97);


        //Vérification d'obstacle selon toute les situations possible
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
                        if (this.obstacle_fou(ligne, colonne, echiquier)) {return true;}
                    }
                    //Si le déplacement est de 1 case alors on valide le déplacement sans vérifier les obstacles
                    else {return true;}

                }        

                else if ((colonne==thcolonne) && ((thligne !="b".charAt(0)) && ligne!="a".charAt(0) || (thligne!="g".charAt(0) && ligne!="h".charAt(0)))) {
                    if (this.obstacle_tour(ligne, colonne,echiquier)) {return true;}
                }
                    
                else if ((ligne==thligne) && (((thcolonne!=7) && colonne!=8) || ((thcolonne!=2) && colonne!=1))) {
                    if (this.obstacle_tour(ligne, colonne,echiquier)) {return true;}
                }
    
                else if ((colonne==thcolonne) || (ligne==thligne)) {return true;}
            } return false;
    }
}

