import java.util.ArrayList;

public class Echiquier {
    private Case[] casse;

    public Case[] getCasse() {
        return this.casse;
    }

    public void setCasse(Case[] casse) {
        this.casse = casse;
    }

    public void setCasse(int i,Case c) {
        this.casse[i]=c;
    }

    public Echiquier(Case[] casse) {
        if (casse.length == 64) {this.casse=casse;}
        else {System.out.println("Taille du tableaux invalide.");}
    }
    
    public Echiquier() {}

    //Liste de toute les pièces disponible sur le jeux de couleur "couleur"
    public ArrayList<Case> getlistePiece(String couleur) {
        ArrayList<Case> listePiece = new ArrayList<Case>();
        for (int i = 0; i < 64; i++) {
            if (this.casse[i].getPiece().getCouleur().equals(couleur)) {listePiece.add(this.casse[i]);}
            }
        return listePiece;
    }

    //Cette méthode renvoie  la position du roi qui à comme couleur "couleur"
    public int[] getPositionRoi(String couleur) {
        for (int i = 0; i < 64; i++) {
            if (this.casse[i].getPiece().getCouleur().equals(couleur) && this.casse[i].getPiece().getNom().equals("Roi")) {
                return new int[]{this.casse[i].getPiece().getPosition().getColonne(),(int)this.casse[i].getPiece().getPosition().getLigne()};
            }
        } return null;
    }

    //Cette méthode renvoie toute les déplacement possible d'une pièce sous  forme d'un tableaux de int (par ex int[0]=colonne suivi de int[1] la ligne) d'une pièce
    public int[] getListeDeplacement(int colonne,char ligne,String nom) {
        int l = (int)ligne;

        if (nom.equals("Roi")) return new int[] {colonne+1,l+1,colonne+1,l-1,colonne+1,l,  colonne-1,l+1,colonne-1,l-1,colonne-1,l,   colonne,ligne+1,colonne,l-1};
        else if (nom.equals("Pion")) return new int[] {colonne+2,l,colonne+1,l,colonne+1,l-1,colonne+1,l-2};
        else if (nom.equals("Cavalier")) return new int[] {colonne+1,l+2,colonne+1,l-2,colonne+2,l+1,colonne+2,l-1};

        else if  (nom.equals("Fou")){
            int[] t= new int[31];
            for (int i=1; i <9;i++) {
                t[i-1]=colonne+i; t[i]=l+i;
                t[i+1]=colonne-i; t[i+2]=l-i;
                t[i+3]=colonne+i; t[i+4]=l-i;
                t[i+5]=colonne-i; t[i+6]=l+i;
            }return t;}
        
        else if (nom.equals("Tour")){
            int[] t= new int[31];
            for (int i=1; i <9;i++) {
                t[i-1]=colonne+i; t[i]=l;
                t[i+1]=colonne-i; t[i+2]=l;
                t[i+3]=colonne; t[i+4]=l-i;
                t[i+5]=colonne; t[i+6]=l+i;
             }return t;}

        else{
            int[] t= new int[63];
            for (int i=1; i <9;i++) {
                t[i-1]=colonne+i; t[i]=l;
                t[i+1]=colonne-i; t[i+2]=l;
                t[i+3]=colonne; t[i+4]=l-i;
                t[i+5]=colonne; t[i+6]=l+i;

                t[i+7]=colonne+i; t[i+8]=l;
                t[i+9]=colonne-i; t[i+10]=l;
                t[i+11]=colonne; t[i+12]=l-i;
                t[i+13]=colonne; t[i+14]=l+i;
            }return t;} 

    }

    //Attaque le roi de position ligne/colonne avec toute les pièces de cases retourne vrai si l'attaque réussi
    public boolean attaquerRoi(int colonne,char ligne,ArrayList<Case> cases,Partie p) {
        for (int i =0;i<cases.size();i++){
            if (cases.get(i).getPiece().Deplacement(this,colonne,ligne)){return true;}
        }return false;
    }
    
    

}

    