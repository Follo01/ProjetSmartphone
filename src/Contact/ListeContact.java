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

/**
 * Classe pour la sauvegarde des Contacts
 * @author Gregory (mise en forme Diogo)
 * @since 01.06.2019
 */

public class ListeContact {
    Contact Cont;

    /**
     * Creation de l ArrayList
     */
    private List<InfoContact> contacts;
    
    /**
     * Constructeur de ListeContact
     * @param Cont le contact
     * @throws IOException
     */
    public ListeContact(Contact Cont) throws IOException {

        /**
         * Creation d un fichier .txt
         */
        creationFichier();

        this.Cont = Cont;

        /**
         * Deserialisation
         */
        contacts = (List<InfoContact>) Serialization.deseralisation("src/Contact/contact.txt");
    }

    /**
     * Permet d ajouter un contact
     * @param chiffre du contact
     */
    public void addContact(int chiffre) {
        contacts.add(new InfoContact(Cont.getTextNom(), Cont.getTextPrenom(), Cont.getTextTel(), chiffre));
        
        /**
         * Serialisation
         */
        Serialization.serialisation(contacts, "src/Contact/contact.txt");
    }

    /**
     * Permet de supprimer un contact
     * @param chiffre du contact
     */
    public void deleteContact(int chiffre) {
        contacts.remove(chiffre);
        
        /**
         * Serialisation
         */
        Serialization.serialisation(contacts, "src/Contact/contact.txt");
    }

    /**
     * Permet d editer un contact
     * @param chiffre du contact
     * @param ic
     * 
     * Le chiffre et l'info du contact
     */
    public void editContact(int chiffre, InfoContact ic) {
        contacts.set(chiffre, ic);

        /**
         * Serialisation
         */
        Serialization.serialisation(contacts, "src/Contact/contact.txt");
    }

    /**
     * Permet d inserer l ArrayList dans un tableau
     * pour pouvoir y acceder avec la JTable
     * @return les donnees y relatives
     */
    public Object[][] getArray2D() {
        Object[][] data = new Object[contacts.size()][4];

        int i = 0;
        while (i < contacts.size()) {
            data[i][0] = contacts.get(i).getNom();
            data[i][1] = contacts.get(i).getPrenom();
            data[i][2] = contacts.get(i).getNumTelephone();
            data[i][3] = contacts.get(i).getPhoto();
            i++;
        }
        return data;
    }

    /**
     * Permet de creer un fichier .txt
     * pour serialiser si le fichier
     * est inexistant
     */
    private void creationFichier() {
        File fichier = new File("src/Contact/contact.txt");
        if(fichier.exists()==false) {
            Serialization.serialisation(new ArrayList<InfoContact>(), "src/Contact/contact.txt");
        }
    }
}
