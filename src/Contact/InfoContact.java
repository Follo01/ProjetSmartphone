package Contact;

import java.io.Serializable;

/**
 * Classe regroupant les informations des Contacts
 * @author Gregory (mise en forme Diogo)
 * @since 31.05.2019
 */
public class InfoContact implements Serializable {
    protected String nom;
    protected String prenom;
    protected String numTelephone;
    protected int photo;

    /**
     * Constructeur d InfoContact
     * @param nom
     * @param prenom
     * @param numTelephone
     * @param photo
     *
     * Les infos du contact
     */
    public InfoContact(String nom, String prenom, String numTelephone, int photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTelephone = numTelephone;
        this.photo = photo;
    }

    /**
     * Permet d obtenir le nom du contact
     * @return son nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Permet d obtenir le prenom du contact
     * @return son prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Permet d obtenir le numero de telephone
     * du contact
     * @return son numero de telephone
     */
    public String getNumTelephone() {
        return numTelephone;
    }
    
    /**
     * Permet d obtenir le numero de la photo
     * du contact
     * @return le numero de la photo
     */
    public int getPhoto() {
        return photo;
    }
}
