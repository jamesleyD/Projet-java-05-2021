import java.util.Scanner;

public class Jeu {


    public static void main(String[] args) {

        Partie p = new Partie();
        p.init();
        p.charger("test.txt");
        boolean victoireN=false;
        boolean victoireB=false;
        int compte_tour=0;
        Scanner input = new Scanner(System.in);

        p.Afficher();
        
        //Boucle principale qui s'arrête uniquement en cas de victoire ou d'égalité
        while (victoireN==false || victoireB==false) {

            //Initialisation
            boolean test=false;
            System.out.println("Au blanc de jouer.");
            int nb=0;
            int thcolonne=0;
            char thligne;
            
            //Vérification de la valider de la pièce sélectionnée (couleur et format)
            while (test==false) {

                System.out.println("Qui voulez vous déplacer : -- format ligne colonne (ex b3)");
    
                //Ligne et colonne de la pièce à déplacer
                thligne = input.next().charAt(0); 
                thcolonne= input.nextInt();
               
                nb=((thcolonne*8)-1)-(((int)(thligne))-97); //Position dans le tableaux de l'échiquier
                
                //Vérification de la couleur et du format
                if (p.getEchiquier().getCasse()[nb].getPiece().getCouleur().equals("Blanc") && (thcolonne>0 && thcolonne<9) && ((int)thligne>96 && (int)thligne<105) ) {
                    test=true;
                } else {System.out.println("Déplacement impossible !!");}
            }

            test=false;
            while (test==false) {
                //Initialisation
                System.out.println("Ou voulez vous le déplacer ? -- format ligne colonne (ex b3)");
                input=new Scanner(System.in);

                //Position voulu
                char ligne = input.next().charAt(0);
                int colonne = input.nextInt();

                int nb2=((colonne*8)-1)-(((int)(ligne))-97); //Position dans l'échiquier de la pièce qui va etre capturée
                //On vérifie la validiter du déplacement

                System.out.println(nb);
                System.out.println(p.getEchiquier().getCasse()[nb].getPiece().getPosition().getLigne());
                System.out.println(p.getEchiquier().getCasse()[nb].getPiece().getPosition().getColonne());

                if (p.getEchiquier().getCasse()[nb].getPiece().Deplacement(p.getEchiquier(), colonne, ligne)) {
                    test=true;//Pour arréter la boucle
                    compte_tour+=1;
                    //On capture la position si la validation est bonne et en même temps on vérifie si la pièce capturée n'est pas le roi
                    if (p.getEchiquier().getCasse()[nb].getPiece().Capture(p.getEchiquier(), colonne, ligne).getNom().equals("Roi")) { 
                        victoireB=true;break;}

                    //Si la pièce déplacer est un pion et que ce pion est en dernière colonne on le promouvoie
                    if (p.getEchiquier().getCasse()[nb2].getPiece().getNom().equals("Pion") && colonne==8) {
                        System.out.println("En quoi voulez vous promouvoir votre pion:");
                        ((Pions) p.getEchiquier().getCasse()[nb2].getPiece()).promotion(input.next(),p.getEchiquier());}
                } 
                else {System.out.println("Déplacement impossible !!");}
            }p.Afficher(); if (victoireB) {break;}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //Initialisation
            test=false;
            System.out.println("Au Noir de jouer.");
            nb=0;
            thcolonne=0;
            

            //Vérification de la valider de la pièce sélectionnée (couleur et format)
            while (test==false) {

                System.out.println("Qui voulez vous déplacer : -- format ligne colonne (ex b3)");
    
                //Ligne et colonne de la pièce à déplacer
                thligne = input.next().charAt(0); 
                thcolonne= input.nextInt();
               
                nb=((thcolonne*8)-1)-(((int)(thligne))-97); //Position dans le tableaux de l'échiquier
                
                //Vérification de la couleur et du format
                if (p.getEchiquier().getCasse()[nb].getPiece().getCouleur().equals("Noir") && (thcolonne>0 && thcolonne<9) && ((int)thligne>96 && (int)thligne<105) ) {
                    test=true;
                } else {System.out.println("Déplacement impossible !!");}
            }

            test=false;
            while (test==false) {
                //Initialisation
                System.out.println("Ou voulez vous le déplacer ? -- format ligne colonne (ex b3)");
                input=new Scanner(System.in);

                //Position voulu
                char ligne = input.next().charAt(0);
                int colonne = input.nextInt();

                int nb2=((colonne*8)-1)-(((int)(ligne))-97); //Position dans l'échiquier de la pièce qui va etre capturée
                //On vérifie la validiter du déplacement

                System.out.println(nb);
                System.out.println(p.getEchiquier().getCasse()[nb].getPiece().getPosition().getLigne());
                System.out.println(p.getEchiquier().getCasse()[nb].getPiece().getPosition().getColonne());

                if (p.getEchiquier().getCasse()[nb].getPiece().Deplacement(p.getEchiquier(), colonne, ligne)) {
                    test=true;//Pour arréter la boucle
                    compte_tour+=1;
                    //On capture la position si la validation est bonne et en même temps on vérifie si la pièce capturée n'est pas le roi
                    if (p.getEchiquier().getCasse()[nb].getPiece().Capture(p.getEchiquier(), colonne, ligne).getNom().equals("Roi")) { 
                        victoireN=true;break;}

                    //Si la pièce déplacer est un pion et que ce pion est en dernière colonne on le promouvoie
                    if (p.getEchiquier().getCasse()[nb2].getPiece().getNom().equals("Pion") && colonne==1) {
                        System.out.println("En quoi voulez vous promouvoir votre pion:");
                        ((Pions) p.getEchiquier().getCasse()[nb2].getPiece()).promotion(input.next(),p.getEchiquier());}
                } 
                else {System.out.println("Déplacement impossible !!");}
            }p.Afficher();if (victoireN) {break;}

            if (compte_tour==50) {System.out.println("Egaliter ---> plus de 50 tours ont été joué");break;}
        }input.close();

        if (victoireN) {System.out.println("Victour au noir");} else System.out.println("Victoire au blanc");
 


    }
}
