import java.util.*; 

public class Dame extends Piece  {

    public Dame(String couleur, Case position) {
        super(couleur, position);
    }

    public boolean obstacle_fou(int nb,char ligne,int colonne,Echiquier echiquier) {
        //Position initial de la pièce
        char thligne = this.getPosition().getLigne();
        int thcolonne = this.getPosition().getColonne();

        //Vérification d'obstacle selon toute les situations possible
        //Retourne faux si il trouve un obstacle entre la position voulu et la pièce
        if ( ((int)(thligne)<(int)(ligne)) && ( thcolonne<colonne ) ) {
            int n= nb;
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n+(8*i)+i]!=null) {
                    return false; break; 
                }
            }
            return true;
        }

        else if ( ((int)(thligne)>(int)(ligne)) && ( thcolonne>colonne ) ) {
            int n= nb;
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n-(8*i)-i]!=null) {
                    return false; break; 
                }
            }
            return true;
        }

        else if ( ((int)(thligne)<(int)(ligne)) && ( thcolonne>colonne ) ) {
            int n= nb;
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n-(8*i)+i]!=null) {
                    return false; break; 
                }
            }
            return true;
        }
        else  {
            int n= nb;
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                i+=1;
                if (echiquier.getCasse()[n+(8*i)-i]!=null) {
                    return false; break; 
                }
            }
            return true;
        }
    }   

    public boolean obstacle_tour(int nb,char ligne,int colonne,Echiquier echiquier) {

        //Position actuelle de la pièce  thligne et  thcolonne
        char thligne = thligne;
        int thcolonne = thcolonne;

        //Vérification d'obstacle selon toute les situations possible
        //Retourne faux si il trouve un obstacle entre la position voulu et la pièce
        if (colonne==thcolonne) {
            int i=(int)(thligne)-(int)(ligne);
            if (i<0) {i+=1;} else {i-=1;}
            int n= nb;
            while (0!=i) {
                if (echiquier.getCasse()[n-(i)] != null) {break;}
                else if (i<0) {i+=1;} else {i-=1;}
            }
            if (i==0) {return true}
        }

        else if (ligne==thligne) {
            int i =0;
            int n= nb;
            while (((Math.abs(thcolonne-colonne))-1)!=i) {
                if (thcolonne<colonne) {n+=8;} else {n-=8;}
                if (echiquier.getCasse()[n] != null) {break;}
                else {i+=1;}                 
            }
            if (i==Math.abs(thcolonne-colonne)) {return true}

        }

        else {return false}
    }



    public void Deplacement(Echiquier echiquier) {
        boolean test = false;
        while (test==false) {

            //Initialisation
            Scanner input = new Scanner(System.in); 
            System.out.println("Ou voulez vous le déplacer ? -- format ligne colonne (ex b3)");
            //Position voulu
            char ligne = input.next().charAt(0);
            int colonne = input.nextInt();
            input.close();

            //Position actuelle de la pièce  thligne et  thcolonne
            char thligne = this.getPosition().getLigne();
            int thcolonne = this.getPosition().getColonne();
            int nb=((colonne)*8)-(8-(((int)ligne)+97)); //indice de la  position désirée dans l'échiquie  

            if (this.Verification(ligne,colonne)){
                int i=1;

                //Calcul des positions autoriser enn fonction de la ligne (si la ligne est valide la colonne l'est forcément sinon erreur)
                char s1=(char)(((int)(thligne))+(Math.abs((thcolonne)-colonne)));
                char s2=(char)(((int)(thligne))-(Math.abs((thcolonne)-colonne)));

                //Vérification de la position avec s1 et s2
                if ( ( (ligne == s1) || (ligne == s2) ) ) {
                    //Situation ou le déplacement n'est pas que de une case (si oui on vérifie les obstacles)
                    if (( (int)(ligne)!=((int)(thligne))+1 ) && ( (int)(ligne)!=((int)(thligne))-1 )) {
                        //Obstacle
                        if (this.obstacle_fou(nb, ligne, colonne, echiquier)) {
                            this.Capture(echiquier,colonne,ligne);
                            test=true;
                        }
                    }
                    //Si le déplacement est de 1 case alors on valide le déplacement sans vérifier les obstacles
                    else {this.Capture(echiquier,colonne,ligne); test=true;}
                }
                    else if ((colonne==thcolonne) && ((thligne !="b".charAt(0)) && ligne!="a".charAt(0) || (thligne!="g".charAt(0) && ligne!="h".charAt(0)))) {
                        if (this.obstacle_tour(nb, ligne, colonne,echiquier)) {this.Capture(echiquier,colonne,ligne); test=true;}
                    }

                    else if ((ligne==thligne) && (((thcolonne!=7) && colonne!=8) || ((thcolonne!=2) && colonne!=1))) {
                        if (this.obstacle_tour(nb, ligne, colonne,echiquier)) {this.Capture(echiquier,colonne,ligne); test=true;}
                    }

                    else if ((colonne==thcolonne) || (ligne==thligne)) {this.Capture(echiquier,colonne,ligne); test=true;}

                if (test==false) {System.out.println("déplacement imposssible !");}
            }
        }
    }
}