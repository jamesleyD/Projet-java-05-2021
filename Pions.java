import java.util.*; 

public class Pions extends Piece  {

    public Pions(String couleur, Case position) {
        super(couleur, position);
    }

    public boolean obstacle(int nb,Echiquier echiquier) {
        // Vérification d'obstacle, retourne faux si obstacle trouver
        if (echiquier.getCasse()[nb]==null) { 
            return true;
        } else {return false;}
    }

    public void Deplacement(Echiquier echiquier){
        String blanc="blanc";
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
            int nb=((colonne)*8)-(8-(((int)ligne)+97)); //indice de la  position désirée dans l'échiquier
        
            //Calcul des diagonales de la pièce
            char s1= (char)(((int)(thligne))+1);
            char s2= (char)(((int)(thligne))-1);

            if (this.Verification(ligne,colonne,echiquier,nb)){
                if (this.getCouleur().equals(blanc) ){
                    //Situation ou le pions est dans sa position de départ (blanc) (possibiliter de ce déplacer de 2 case)
                    if ( (2 ==thcolonne) && (colonne==thcolonne+2) && (thligne==ligne) && this.obstacle((nb+8),echiquier) ) 
                        {this.Capture(echiquier,colonne,ligne); test=true;} 
                    //Déplacement simple de 1 case
                    else if ( (colonne==thcolonne+1) && (thligne==ligne) && (this.obstacle(nb,echiquier)) ) 
                        {this.Capture(echiquier,colonne,ligne);test=true;}
                    //Déplacement en diagonale de 1 case pour une capture
                    else if ( ( ligne == s1 || ligne== s2) && (thcolonne+1 == colonne) && echiquier.getCasse().getPiece()[nb]!=null)
                        {this.Capture(echiquier,colonne,ligne);test=true;}
                }
                else {
            
                    //Situation ou le pions est dans sa position de départ (noir) (possibiliter de ce déplacer de 2 case)
                    if ( (7 ==thcolonne) && (colonne==thcolonne-2) && (thligne==ligne) && this.obstacle((nb-8),echiquier) ) 
                        {this.Capture(echiquier,colonne,ligne);test=true;} 
                    //Déplacement simple de 1 case 
                    else if ( (colonne==thcolonne-1) && (thligne==ligne) && (this.obstacle(nb,echiquier)) ) 
                        {this.Capture(echiquier,colonne,ligne);test=true;}
                    //Déplacement en diagonale de 1 case pour une capture
                    else if ( ( ligne == s1 || ligne== s2) && (thcolonne-1 == colonne) && echiquier.getCasse().getPiece()[nb]!=null)
                        {this.Capture(echiquier,colonne,ligne);test=true;}  
                }   
            }
            //Situation ou le pion arrive à la dernière colonne (il devient une autre pièce)   
            if (((test==true) && (this.getCouleur().equals(blanc))) && (colonne==8)){
                    Case c1=new Case(ligne,colonne);
                    Dame d1=new Dame(this.getCouleur(),c1);
                    c1.setPiece(d1);
                    echiquier.getCasse()[nb]= c1;
                }

            else if ((test==true) && (colonne==1)) {
                    Case c1=new Case(ligne,colonne);
                    Dame d1=new Dame(this.getCouleur(),c1);
                    c1.setPiece(d1);
                    echiquier.getCasse()[nb]= c1;
                } 

            if (test==false) {System.out.println("déplacement imposssible !");}
            
        }
    }
}

                
