import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

    private Joueur joueurB;
    private Joueur joueurN;
    private Echiquier echiquier;


    public Joueur getJoueurB() {
        return this.joueurB;
    }

    public void setJoueurB(Joueur joueurB) {
        this.joueurB = joueurB;
    }

    public Joueur getJoueurN() {
        return this.joueurN;
    }

    public void setJoueurN(Joueur joueurN) {
        this.joueurN = joueurN;
    }

    public Echiquier getEchiquier() {
        return this.echiquier;
    }

    public void setEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public Partie(Joueur joueurB, Joueur joueurN, Echiquier echiquier) {
        this.joueurB = joueurB;
        this.joueurN = joueurN;
        this.echiquier = echiquier;
    }

    public Partie() {}


//Méthode qui va initialiser tous les éléments d'une partie par défaut
    public void init(){

        Joueur joueurN = new Joueur("Noir");
        Joueur joueurB = new Joueur("Blanc");


        Echiquier echiquier= new Echiquier();
        Case[] cases = new Case[64];

        Tours tn1,tn2,tb1,tb2;
        Cavalier cn1,cn2,cb1,cb2;
        Fous fn1,fn2,fb1,fb2;
        Roi rn,rb;
        Dame dn,db;

        //Boucle qui initialise les pions noires
        for (int i=0;i<8;i++) {
            Pions pn = new Pions("Noir",null);
            cases[55-i]=new Case(((char)(97+i)),7,pn);
            pn.setPosition(cases[55-i]);
        }

        //Boucle qui initialise les pions blancs
        for (int i=0;i<8;i++) {
            Pions pb = new Pions("Blanc",null);
            cases[8+i]=new Case(((char)(97+i)),2,pb);
            pb.setPosition(cases[8+i]);
        }     

        //Initialisation des tours noires
        tn1=new Tours("Noir",null);
        cases[63]=new Case("a".charAt(0),8,tn1);
        tn1.setPosition(cases[63]);
        tn2=new Tours("Noir",null);
        cases[56]=new Case("h".charAt(0),8,tn2);
        tn2.setPosition(cases[56]);

        //Initialisation des tours blanches
        tb1=new Tours("Blanc",null);
        cases[0]=new Case("a".charAt(0),1,tb1);
        tb1.setPosition(cases[0]);
        tb2=new Tours("Blanc",null);
        cases[7]=new Case("h".charAt(0),1,tb2);
        tb2.setPosition(cases[7]);

        //Initialisation des cavalier noir
        cn1=new Cavalier("Noir",null);
        cases[62]=new Case("b".charAt(0),8,cn1);
        cn1.setPosition(cases[62]);
        cn2=new Cavalier("Noir",null);
        cases[57]=new Case("g".charAt(0),8,cn2);
        cn2.setPosition(cases[57]);

        //Initialisation des cavalier blancs
        cb1=new Cavalier("Blanc",null);
        cases[1]=new Case("b".charAt(0),1,cb1);
        cb1.setPosition(cases[1]);
        cb2=new Cavalier("Blanc",null);
        cases[6]=new Case("g".charAt(0),1,cb2);
        cb2.setPosition(cases[6]);

        //Initialisation des fous Noir
        fn1=new Fous("Noir",null);
        cases[61]=new Case("c".charAt(0),8,fn1);
        fn1.setPosition(cases[61]);
        fn2=new Fous("Noir",null);
        cases[58]=new Case("f".charAt(0),8,fn2);
        fn2.setPosition(cases[58]);
        
        //Initialisation des fous Blancs
        fb1=new Fous("Blanc",null);
        cases[2]=new Case("c".charAt(0),1,fb1);
        fb1.setPosition(cases[2]);
        fb2=new Fous("Blanc",null);
        cases[5]=new Case("f".charAt(0),1,fb2);
        fb2.setPosition(cases[5]);

        //Initialisation du roi noir
        rn=new Roi("Noir",null);
        cases[59]=new Case("e".charAt(0),8,rn);
        rn.setPosition(cases[59]);
        //Initialisation du roi blanc
        rb=new Roi("Blanc",null);
        cases[3]=new Case("e".charAt(0),1,rb);
        rb.setPosition(cases[3]);

        //Initialisation de la dame noir
        dn=new Dame("Noir",null);
        cases[60]=new Case("d".charAt(0),8,dn);
        dn.setPosition(cases[60]);
        //Initialisation de la dame blanche
        db=new Dame("Blanc",null);
        cases[4]=new Case("d".charAt(0),1,db);
        db.setPosition(cases[4]);

        //On affecte tout à la Partie actuelle
        echiquier.setCasse(cases);
        this.joueurB = joueurB;
        this.joueurN= joueurN;
        this.echiquier = echiquier;

    }


    //Méthode qui va charger les pièces d'un échiquier lors de l'utilisation de la méthode charger
    private Piece charger_piece(String scan,int position,Case c) {
        //Initialisation 
        String type =String.valueOf(scan.charAt(0));
        String couleur=String.valueOf(scan.charAt(1));

        //Chargement roi
        if (type.equals("R")) {
            if (couleur.equals("N")) {return new Roi("Noir",c);} else {return new Roi("Blanc",c);}
        }
        //Chargement fou
        else if (type.equals("F")) {
            if (couleur.equals("N")) {return new Fous("Noir",c);} else {return new Fous("Blanc",c);}
        }
        //Chargement cavalier
        else if (type.equals("C")) {
            if (couleur.equals("N")) {return new Cavalier("Noir",c);} else {return new Cavalier("Blanc",c);}
        }
        //Chargement dame
        else if (type.equals("D")) {
            if (couleur.equals("N")) {return new Dame("Noir",c);} else {return new Dame("Blanc",c);}
        }
        //Chargement pion
        else if (type.equals("P")) {
            if (couleur.equals("N")) {return new Pions("Noir",c); } else {return new Pions("Blanc",c) ;}
        }
        //Chargement tour
        else {
            if (couleur.equals("N")) {return new Tours("Noir",c);} else {return new Tours("Blanc",c);}
        }
    }

    //Permet de charger une partie sauvegarder avec sauver
	public void charger(String nomFichier) {

    	try {

			BufferedReader br = Files.newBufferedReader(Paths.get(nomFichier)); // On instancie un BufferedReader en fonction du chemin "nomfichier"
			
			// On instancie un String qui sera associé au contenu du fichier texte
			String ligne; 
			ligne = br.readLine();
			int a=63;
            
			//Boucle qui permet d'ajouter à  liste les variables du fichier
			while (ligne != null) {

				Scanner scan = new Scanner(ligne);
                scan.useDelimiter(" "); //La méthode sauver utilise des espaces pour délimiter les éléments donc on va utiliser un délimiteur " " avec le scanner
                int i=0;
                //Boucle qui charge chaque élément 1 par 1 en fonction du délimiteur
                while (scan.hasNext()) {
                    String scanstr= scan.next();
                    if (scanstr.equals("0")) {this.echiquier.getCasse()[a-i]=null;}
                    else{
                        char l = scanstr.charAt(2);
                        int colonne = Integer.valueOf(String.valueOf(scanstr.charAt(3)));
                        this.echiquier.getCasse()[a-i] =new Case(l,colonne);
                        this.echiquier.getCasse()[a-i].setPiece(this.charger_piece(scanstr,a-i,this.echiquier.getCasse()[a-i]));
                    }
                    i+=1;
                } 
                a-=8;
				ligne = br.readLine();
                scan.close();
			} 
 
			br.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
	





	public void sauver(String nomFichier) {

        String text=new String();
        //Parcours l'échiquier et affecte à chaque élément un texte qui va être enregistré dans un fichier
        for (int i = 1; i <65; i++) {
            if (this.echiquier.getCasse()[64-i]==null) {
                text+=0+" ";
            } //On enregistre 0 quand la position est null

            else {
                text+=this.echiquier.getCasse()[64-i].getPiece().getNom().substring(0, 1)+this.echiquier.getCasse()[64-i].getPiece().getCouleur().substring(0, 1)
                +this.echiquier.getCasse()[64-i].getLigne()+this.echiquier.getCasse()[64-i].getColonne()+" "; 
                //on enregistre dans la variable certaine information: ex FBf2 = fou blanc de position f2
            }

            if (i%8==0) {text+="\n";} //On saute une ligne quand on atteind 8 éléments pr respecter le format d'un échiquier
        } System.out.println(text);
        
        File file = new File(nomFichier); //On instancie un nouveau fichier file en fonction du chemin nomfichier
        
        try {
        	
        	BufferedWriter writer =new BufferedWriter(new FileWriter(file)); //Création d'un BufferedWriter qui va etre instancier via un FileWriter
        	
        	writer.write(text);
            writer.close(); //On ferme le scanner et le writer
        	} 
            
        catch (IOException e){
            
        	e.printStackTrace();
        }
    }

    //Affiche sous forme textuelle l'échiquier et ces éléments
    public void Afficher(){

        int i,a;
        String[] affichage = new String[64];

        //On enregistre "l'affichage" unicode de chaque élément (pièce) dans un tableau de string
        for (i = 0; i<64; i++) {
            if (this.echiquier.getCasse()[i]==null) {
                affichage[i]="   ";
            }
            else affichage[i]=" "+this.echiquier.getCasse()[i].getPiece().Afficher()+" ";
        }
        //On affiche le nom des lignes
        System.out.println(" "+" | "+" a "+" | "+" b "+" | "+" c "+" | "+" d "+" | "+" e "+" | "+" f "+" | "+" g "+" | "+" h "+" | ");
        a=64;
        //Boucle qui va former le tableau  via des prints en utilisant le tableau d'affichage unicode
        for (i=1;i<9;i++){
            System.out.println("   ___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___"+"___");
            System.out.println( 9-i+" | "+affichage[a-1]+" | "+affichage[a-2]+" | "+affichage[a-3]+" | "+affichage[a-4]+" | "+affichage[a-5]+" | "+affichage[a-6]+" | "+affichage[a-7]+" | "+affichage[a-8]+" | ");
            a-=8;
        }
    }

    public boolean VerificationPat(String couleur){
        ArrayList<Case> listePiece;

        //Ligne et colonne du roi
        char ligne=(char)this.echiquier.getPositionRoi(couleur)[1];
        int colonne=this.echiquier.getPositionRoi(couleur)[0];

        //On va récupérer les pièces adverse selon la couleur en param
        if (couleur.equals("Noir")) {listePiece= this.getEchiquier().getlistePiece("Blanc");} else {listePiece= this.getEchiquier().getlistePiece("Noir");}

        //Va récupérer la position du roi et faire une attaque avec toute les pièces adverse, si le roi est attaqué il n'y a pas de PAT (peut etre mat mais pas pat)
        if (this.echiquier.attaquerRoi(colonne,ligne,listePiece,this)) return false;
        //Si le test1 est vrai c'est que le roi n'est pas attaquer donc on continue le programme

        else {
            //Test qui validera le PAt
            boolean test1=false;
            boolean test2=false;

            ArrayList<Case> listePiece2= this.getEchiquier().getlistePiece(couleur); //Liste des pièces du roi attaqué

            int nb=((colonne*8)-1)-(((int)(ligne))-97); //Position du roi dans l'échuiquier
            //On récupère la liste de coup du roi
            int[] listecoup =this.getEchiquier().getListeDeplacement(colonne,ligne,this.echiquier.getCasse()[nb].getPiece().getNom());

            for (int i =0;i<9;i++) {
                //On sauvegarde
                this.sauver("echec.txt");

                //On regarde si le roi est attaquer si on le déplace pour valider le test 1
                if (this.echiquier.getCasse()[nb].getPiece().Deplacement(echiquier,listecoup[i],(char)listecoup[i+1])) {
                    this.getEchiquier().getCasse()[nb].getPiece().Capture(echiquier,listecoup[i],(char)listecoup[i+1]);
                    if (this.echiquier.attaquerRoi(colonne,ligne,listePiece,this)) {test1=true; this.charger("echec.txt");} else {this.charger("echec.txt");}
                } 
            }
             //On regarde si le roi est toujours attaquer meme en déplacent l'une de ces pièces
            for (int i=0;i<listePiece2.size();i++) {
                this.sauver("echec.txt");
                int nb2=((listePiece2.get(i).getColonne()*8)-1)-(((int)(listePiece2.get(i).getLigne()))-97);
                //On récupère toute les déplacements possible (possible ne veut pas dire exacte certain déplacement ne vont pas fonctionner)
                int[] listecoup2 =this.echiquier.getListeDeplacement(listePiece2.get(i).getColonne(),listePiece2.get(i).getLigne(),listePiece2.get(i).getPiece().getNom());
                
                for (int a=0;a<listecoup2.length/2;a++) {
                    if (this.echiquier.getCasse()[nb2].getPiece().Deplacement(echiquier,listecoup2[i],(char)listecoup2[i+1])) {
                        this.getEchiquier().getCasse()[nb2].getPiece().Capture(echiquier,listecoup2[i],(char)listecoup2[i+1]);
                        if (this.echiquier.attaquerRoi(colonne,ligne,listePiece,this)) {test2=true; this.charger("echec.txt");} else {this.charger("echec.txt");}
                    } 
                }
            }return test2 && test1;
        }      
    }

    //public boolean VerificationMat() {}

}
