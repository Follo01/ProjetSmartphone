package Contact;

import java.io.Serializable;
public class InfoContact implements Serializable{
    protected String nom;
    protected String prenom;
    protected String numTelephone;
    protected int photo;

    //Donnée du contact
    public InfoContact(String nom, String prenom, String numTelephone, int photo){
        this.nom=nom;
        this.prenom=prenom;
        this.numTelephone=numTelephone;
        this.photo=photo;

    }

    //Accéder au information du contact
    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getNumTelephone()
    {
        return numTelephone;
    }
    public int getPhoto()
    {
        return photo;
    }
}
