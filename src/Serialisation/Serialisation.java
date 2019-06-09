package Serialisation;

import java.io.*;

/**
 * Classe permettant la serialisation
 * @author Gregory (mise en forme Diogo)
 * @since
 */
public abstract class Serialisation {
    /**
     * Creation de la serialisation
     * @param object l objet
     * @param path le chemin systeme
     * @return true ou false selon l exception
     */
    public static boolean serialisation(Object object, String path) {
        try{
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bfos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(object);
            oos.close();
            return true;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }
    
    /**
     * Creation de la deserialisation
     * @param path le chemin systeme
     * @return null lors d une exception
     * @return un objet
     */
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