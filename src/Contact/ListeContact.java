package Contact;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.table.TableModel;

import GUI.Contact;
import Serialization.Serialization;
import Contact.InfoContact;


public class ListeContact {
    Contact Cont;

    //Création de l'ArrayList
    private List<InfoContact> contacts ;
    public ListeContact( Contact Cont ) throws IOException{

        //Création du fichier .txt
        creationFichier();

        this.Cont = Cont;

        //Déséralisation
        contacts = (List<InfoContact>) Serialization.deseralisation("C:/école HES-SO/ProjetSmartphone/src/Contact/contact.txt");

    }

    //Ajouter un Contact
    public void  addContact (int chiffre){
        contacts.add(new InfoContact(Cont.getTextNom(), Cont.getTextPrenom(), Cont.getTextTel(), chiffre));
        //Serialisation
        Serialization.serialisation(contacts, "C:/école HES-SO/ProjetSmartphone/src/Contact/contact.txt");
    }

    //Suprimer un Contact
    public void deleteContact (int chiffre){
        contacts.remove(chiffre);
        //Serialisation
        Serialization.serialisation(contacts, "C:/école HES-SO/ProjetSmartphone/src/Contact/contact.txt");
    }

    //Editer un Contact
    public void editContact (int chiffre, InfoContact ic){
        contacts.set(chiffre, ic);
        //Serialisation
        Serialization.serialisation(contacts, "C:/école HES-SO/ProjetSmartphone/src/Contact/contact.txt");
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
        File fichier = new File("C:/école HES-SO/ProjetSmartphone/src/Contact/contact.txt") ;
        if (fichier.exists()==false)
        {
            Serialization.serialisation(new ArrayList<InfoContact>(), "C:/école HES-SO/ProjetSmartphone/src/Contact/contact.txt");
        }
    }
}
