import java.util.*; 

public class Tours extends Piece  {

    public Tours(String couleur, Case position) {
        super(couleur, position);
    }

    public boolean obstacle(int nb,char ligne,int colonne,Echiquier echiquier) {

        //Position actuelle de la pièce  thligne et  thcolonne
        char thligne = thligne;
        int thcolonne = thcolonne;

//Pas sur mais je crois que y'a un pb avec la majorité des déplacements
//En gros c'est pas bon si il détecte un obstacle à la position voulu 
//Faut vérifier uniquement les positions entre l'inital et le voulu mais négliger le voulu

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



    public void Deplacement(Echiquier echiquier){
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
            char thligne = thligne;
            int thcolonne = thcolonne;
            //indice de la  position désirée dans l'échiquier 
            int nb=((colonne)*8)-(8-(((int)ligne)+97)); 

            //Vérification de la validitité du déplacement
            if (this.Verification(ligne,colonne)) {

                if ((colonne==thcolonne) && ((thligne !="b".charAt(0)) && ligne!="a".charAt(0) || (thligne!="g".charAt(0) && ligne!="h".charAt(0)))) {
                    if (this.obstacle(nb, ligne, colonne,echiquier)) {this.Capture(echiquier,colonne,ligne); test=true;}
                }

                else if ((ligne==thligne) && (((thcolonne!=7) && colonne!=8) || ((thcolonne!=2) && colonne!=1))) {
                    if (this.obstacle(nb, ligne, colonne,echiquier)) {this.Capture(echiquier,colonne,ligne); test=true;}
                }

                else if ((colonne==thcolonne) || (ligne==thligne)) {this.Capture(echiquier,colonne,ligne); test=true;}
            }

            if (test==false) {System.out.println("déplacement imposssible !");}
        }
    }
}   

