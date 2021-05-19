import java.util.*; 

public class Roi extends Piece  {

    public Roi(String couleur, Case position) {
        super(couleur, position);
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

            //Position initial  de la pièce
            int a=(int)this.getPosition().getLigne();
            int b = this.getPosition().getColonne();

            //Vérification du déplacement
            if (this.Verification(ligne,colonne)){ 

                if (((colonne==b+1) && ((int)ligne==a+1)) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b+1) && ((int)ligne==a-1)) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b-1) && ((int)ligne==a+1)) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b-1) && ((int)ligne==a-1)) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b+1) && ((int)ligne==a)) 
                {this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b-1) && ((int)ligne==a)) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b) && ((int)ligne==a+1)) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
                else if ((colonne==b) && ((int)ligne==a-1))) {
                    this.Capture(echiquier,colonne,ligne);test=true;
                }
            }

        }
    }
}