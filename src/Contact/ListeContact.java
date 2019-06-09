package Contact;

import GUI.Contact;
import Serialisation.Serialisation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        contacts = (List<InfoContact>) Serialisation.deseralisation("./src/Contact/contact.txt");
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
        Serialisation.serialisation(contacts, "./src/Contact/contact.txt");
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
        Serialisation.serialisation(contacts, "./src/Contact/contact.txt");
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
        Serialisation.serialisation(contacts, "./src/Contact/contact.txt");
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
        File fichier = new File("./src/Contact/contact.txt");
        if(fichier.exists()==false) {
            Serialisation.serialisation(new ArrayList<InfoContact>(), "./src/Contact/contact.txt");
        }
    }
}
