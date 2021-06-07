

public class Pions extends Piece  {

    public Pions(String couleur, Case position) {
        super(couleur, position,"Pion");
    }

    public Pions(){}

    //Unicode
    public String Afficher() {
        if (this.getCouleur().equals(new String("Blanc"))) {
            return "\u2659" ;
        }

        else return "\u265F";
    }


    private boolean obstacle(int nb,Echiquier echiquier) {
        // Vérification d'obstacle, retourne faux si obstacle trouver
        if (echiquier.getCasse()[nb]==null) { 
            return true;
        } else {return false;}
    }

    //Promotion d'un pion selon le type choisis
    public void promotion(String type,Echiquier echiquier) {

        char thligne = this.getPosition().getLigne();
        int thcolonne = this.getPosition().getColonne();
        int nb=((thcolonne*8)-1)-(((int)(thligne))-97);

        if (type.toLowerCase().equals("dame")) {
            Case c=new Case(thligne,thcolonne);
            if (this.getCouleur().equals("Noir")) {
                Dame r=new Dame("Noir",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            } 
            else {
                Dame r=new Dame("Blanc",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            }
        }

        else if (type.toLowerCase().equals("roi")) {
            Case c=new Case(thligne,thcolonne);
            if (this.getCouleur().equals("Noir")) {
                Roi r=new Roi("Noir",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            } 
            else {
                Roi r=new Roi("Blanc",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            }
        }


        else if (type.toLowerCase().equals("cavalier")) {
            Case c=new Case(thligne,thcolonne);
            if (this.getCouleur().equals("Noir")) {
                Cavalier r=new Cavalier("Noir",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            } 
            else {
                Cavalier r=new Cavalier("Blanc",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            }
        }

        else if (type.toLowerCase().equals("fou")) {
            Case c=new Case(thligne,thcolonne);
            if (this.getCouleur().equals("Noir")) {
                Fous r=new Fous("Noir",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            } 
            else {
                Fous r=new Fous("Blanc",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            }
        }


        else if (type.toLowerCase().equals("tour")) {
            Case c=new Case(thligne,thcolonne);
            if (this.getCouleur().equals("Noir")) {
                Tours r=new Tours("Noir",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            } 
            else {
                Tours r=new Tours("Blanc",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            }
        }

        else {
            Case c=new Case(thligne,thcolonne);
            if (this.getCouleur().equals("Noir")) {
                Pions r=new Pions("Noir",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            } 
            else {
                Pions r=new Pions("Blanc",c);
                c.setPiece(r);
                echiquier.getCasse()[nb]=c;
            }
        } 

    }

    //Vérification d'un déplacement à une position colonne/ligne dans un échiquier
    public boolean Deplacement(Echiquier echiquier,int colonne,char ligne) {

            //Position actuelle de la pièce  thligne et  thcolonne
            char thligne = this.getPosition().getLigne();
            int thcolonne = this.getPosition().getColonne();
            int nb=((colonne*8)-1)-(((int)(ligne))-97); //indice de la  position désirée dans l'échiquier
        
            //Calcul des diagonales de la pièce
            char s1= (char)(((int)(thligne))+1);
            char s2= (char)(((int)(thligne))-1);

            if (this.Verification(ligne,colonne,echiquier)){
                if (this.getCouleur().equals(new String("Blanc")) ){
                    //Situation ou le pions est dans sa position de départ (blanc) (possibiliter de ce déplacer de 2 case)

                    if ( (2 ==thcolonne) && (colonne==thcolonne+2) && (thligne==ligne) && this.obstacle((nb+8),echiquier) ) 
                        {return true;} 
                    //Déplacement simple de 1 case
                    else if ( (colonne==thcolonne+1) && (thligne==ligne) && (this.obstacle(nb,echiquier)) ) 
                        {return true;}
                    //Déplacement en diagonale de 1 case pour une capture
                    else if ( ( ligne == s1 || ligne== s2) && (thcolonne+1 == colonne) && echiquier.getCasse()[nb]!=null )
                        {return true;}
                }
                else {
            
                    //Situation ou le pions est dans sa position de départ (noir) (possibiliter de ce déplacer de 2 case)               
                    if ( (7 ==thcolonne) && (colonne==thcolonne-2) && (thligne==ligne) && this.obstacle((nb-16),echiquier) ) 
                        {return true;} 
                    //Déplacement simple de 1 case 
                    else if ( (colonne==thcolonne-1) && (thligne==ligne) && (this.obstacle(nb,echiquier)) ) 
                        {return true;}
                    //Déplacement en diagonale de 1 case pour une capture
                    else if ( ( ligne == s1 || ligne== s2) && (thcolonne-1 == colonne) && echiquier.getCasse()[nb]!=null)
                        {return true;}  
                }   
            }

            return false;             
            
    }

}

                
