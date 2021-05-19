import java.util.*; 

public class Cavalier extends Piece  {

    public Cavalier(String couleur, Case position) {
        super(couleur, position);
    }

    public void Deplacement(Echiquier echiquier){
        boolean test = false;
        while (test==false) {

            //Initialisation 
            Scanner input = new Scanner(System.in); 
            System.out.println("Ou voulez vous le déplacer ? -- format ligne colonne (ex b3)");
            int ligne = (int)(input.next().charAt(0));
            int colonne = input.nextInt();
            input.close();

            //Position actuelle de la pièce à déplacer
            int thligne =(int)(this.getPosition().getLigne());
            int thcolonne =this.getPosition().getColonne();

            //Vérification du déplacement avec toute les situations possible
            //(pas besoin de vérifier les obstacles le cavalier peut sauter des pièces)
            if(this.Verification(ligne,colonne)){
                
                if ( (colonne==thcolonne+2) && ((ligne==thligne+1) || (ligne==thligne-1)) ) {
                    this.Capture(echiquier,colonne,(char)(ligne));test=true;
                } 
                else if ( (colonne==thcolonne+1) && ((ligne==thligne+2) || (ligne==thligne-2)) ) {
                    this.Capture(echiquier,colonne,(char)(ligne));test=true;
                } 
                else if ( (colonne==thcolonne-2) && ((ligne==thligne+1) || (ligne==thligne-1)) ) {
                    this.Capture(echiquier,colonne,(char)(ligne));test=true;
                } 
                else if ( (colonne==thcolonne-1) && ((ligne==thligne+2) || (ligne==thligne-2)) ) {
                    this.Capture(echiquier,colonne,(char)(ligne));test=true;
                }
            }
            if (test==false) {System.out.println("déplacement imposssible !");}
    }
}