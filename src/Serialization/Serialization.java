package Serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Contact.ListeContact;

public abstract class Serialization {
    //Création de la serialisation
    public static boolean serialisation(Object object, String path){
        try{


            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bfos = new BufferedOutputStream(fos);
            ObjectOutputStream oos= new ObjectOutputStream(fos);

            oos.writeObject(object);
            oos.close();
            return true;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }

    //creation de la déserialisation
    public static Object deseralisation(String path){

        try
        {
            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bfis = new BufferedInputStream(fis);
            ObjectInputStream obfis = new ObjectInputStream(bfis);
            Object object = obfis.readObject();
            obfis.close();
            return object ;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }catch(ClassNotFoundException c){
            System.out.println("Class pas trouver");
            c.printStackTrace();
            return null;
        }
    }

}
