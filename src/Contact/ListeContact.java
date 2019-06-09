package Contact;

import GUI.Contact;
import Serialization.Serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListeContact {
    Contact Cont;

    //Création de l'ArrayList
    private List<InfoContact> contacts ;
    public ListeContact( Contact Cont ) throws IOException{

        //Création du fichier .txt
        creationFichier();

        this.Cont = Cont;

        //Déséralisation
        contacts = (List<InfoContact>) Serialization.deseralisation("src/Contact/contact.txt");

    }

    //Ajouter un Contact
    public void  addContact (int chiffre){
        contacts.add(new InfoContact(Cont.getTextNom(), Cont.getTextPrenom(), Cont.getTextTel(), chiffre));
        //Serialisation
        Serialization.serialisation(contacts, "src/Contact/contact.txt");
    }

    //Suprimer un Contact
    public void deleteContact (int chiffre){
        contacts.remove(chiffre);
        //Serialisation
        Serialization.serialisation(contacts, "src/Contact/contact.txt");
    }

    //Editer un Contact
    public void editContact (int chiffre, InfoContact ic){
        contacts.set(chiffre, ic);
        //Serialisation
        Serialization.serialisation(contacts, "src/Contact/contact.txt");
    }

    //Inserer l'Arraylist dans un tableau pour pouvoir y accéder avec la JTable
    public Object[][] getArray2D(){
        Object[][] data = new Object[ contacts.size() ][ 4 ];

        int i = 0;
        while (i < contacts.size()){
            data[i][0] = contacts.get(i).getNom();
            data[i][1] = contacts.get(i).getPrenom();
            data[i][2] = contacts.get(i).getNumTelephone();
            data[i][3] = contacts.get(i).getPhoto();
            i++;
        }
        return data;
    }

    //Création d'un fichier .txt pour faire la sérialisation (si fichier inexistant)
    private void creationFichier()
    {
        File fichier = new File("src/Contact/contact.txt") ;
        if (fichier.exists()==false)
        {
            Serialization.serialisation(new ArrayList<InfoContact>(), "src/Contact/contact.txt");
        }
    }
}
