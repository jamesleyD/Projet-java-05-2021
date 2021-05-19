public class Case {
    private char ligne;
    private int colonne;
    private Piece piece;

    public Case(char ligne, int colonne,Piece piece) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.piece=piece;
    }

    public Case(char ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.piece=null;
    }

    

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public char getLigne() {
        return this.ligne;
    }

    public void setLigne(char ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return this.colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

}
