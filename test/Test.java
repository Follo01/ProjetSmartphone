
import GUI.LockScreen;
import Serialisation.Serialisation;

import java.io.IOException;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe servant pour nos tests JUnit
 * @author Gregory (mise en forme Diogo)
 * @since 09.06.2019
 *
 */
public class Test {
    String filepath = "test/test.ser";
    TestJUNIT MonTestJunit = new TestJUNIT("Follonier", "Gregory");
    LockScreen testFrame;

    {
        try {
            testFrame = new LockScreen();
            testFrame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test de la serialisation
     */
    @org.junit.jupiter.api.Test
    public void testSerialisation() {
        //Regarde si �a bien enregistrer au bonne endroit
        assertTrue(Serialisation.serialisation(MonTestJunit, filepath));
    }

    /**
     * Test de la deserialisation
     */
    @org.junit.jupiter.api.Test
    public void testDeseralisation(){
        TestJUNIT o = (TestJUNIT) Serialisation.deseralisation(filepath);
        assertTrue(o instanceof TestJUNIT);
        assertTrue(o.nom.equals("Follonier"));   //Test si le nom est bien "Follonier"
        assertTrue (o.prenom.equals("Gregory"));
    }
    
    /**
     * Test pour l'ouverture d'une frame LockScreen
     */
    @org.junit.jupiter.api.Test
    public void testOuvertureFrame(){
        assertTrue(testFrame.isVisible()==true);
    }
}

class TestJUNIT implements Serializable{
    String nom;
    String prenom ;

    public TestJUNIT(String nom, String prenom){
        this.nom = nom ;
        this.prenom = prenom;
    }
}