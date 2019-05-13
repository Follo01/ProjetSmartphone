public class Jeux2048 {
    public static void main(String[] args) {
        final int [][]tab = new int[4][4];



        randomPosition(tab);
        affiche(tab);


		/*System.out.println("");
		deplacementHaut(tab);
		affiche(tab);

		System.out.println("");
		deplacementGauche(tab);
		affiche(tab);
		*/

        System.out.println("");
        deplacementBas(tab);
        affiche(tab);





    }

    public static int randomNumber() {
        int a = (int) (Math.random()*3+1);

        if(a==1) {
            a+=1;
        } else {
            if(a==3) {
                a+=1;
            }
        }

        return a;
    }

    public static void affiche(int [][]tab) {
        for(int i = 0; i<tab.length; i++) {
            System.out.println();
            for(int j = 0; j<tab[0].length;j++) {
                System.out.print(tab[i][j]+"\t");
            }
        }
    }

    public static void randomPosition(int [][]tab) {
        int tempLignes, tempColonnes, temp = 0;
        for(temp = 0; temp<2; temp++) {
            tempLignes = (int) (Math.random()*3)+1;
            tempColonnes = (int) (Math.random()*3)+1;
            tab[tempLignes][tempColonnes] = randomNumber();
        }
    }

    public static void deplacementGauche(int [][]tab) {
        int temp = 0;
        do {
            for(int i = 0; i<tab.length; i++) {
                for(int j = 0; j<3; j++) {
                    if(tab[i][j] == tab[i][j+1]||tab[i][j]==0) {
                        tab[i][j] += tab[i][j+1];
                        tab[i][j+1] =0;
                    }
                }
            }
            temp+=1;

        }while(temp<3);
    }

    public static void deplacementHaut(int [][]tab) {
        int temp = 0;
        do {
            for(int i = 0; i<3; i++) {
                for(int j = 0; j<tab[0].length; j++) {
                    if(tab[i][j] == tab[i+1][j]||tab[i][j]==0) {

                        tab[i][j] += tab[i+1][j];
                        tab[i+1][j] =0;
                    }
                }
            }
            temp+=1;
        }while(temp<3);
    }
    // ------ PROBLEME -------
    public static void deplacementBas(int [][]tab) {

        for(int i = 3; i>0; i--) {
            for(int j = 3; j>0; j--) {
                if( tab[i][j] == tab[i][j+1]||tab[i][j]==0) {

                    tab[i+1][j] += tab[i][j];
                    tab[i][j] =0;
                }
            }
        }

    }

    // ------ PROBLEME -------
    public static void deplacementDroite(int [][]tab) {
        int temp = 0;
        do {
            for(int i = 3; i>tab.length; i--) {
                for(int j = 3; j<3; j--) {
                    if( tab[i][j] == tab[i][j+1]||tab[i][j]==0) {
                        tab[i][j] += tab[i][j-1];
                        tab[i][j] =0;
                    }
                }
            }
        }while(temp>3);
    }
}
