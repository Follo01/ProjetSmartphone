
import GUI.LockScreen;
import Serialization.Serialization;

import java.io.IOException;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @org.junit.jupiter.api.Test
    public void testSerialisation() {
        //Regarde si ça bien enregistrer au bonne endroit
        assertTrue(Serialization.serialisation(MonTestJunit, filepath));
    }

    @org.junit.jupiter.api.Test
    public void testDeseralisation(){
        TestJUNIT o = (TestJUNIT) Serialization.deseralisation(filepath);
        assertTrue(o instanceof TestJUNIT);
        assertTrue(o.nom.equals("Follonier"));   //Test si le nom est bien "Follonier"
        assertTrue (o.prenom.equals("Gregory"));
    }

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
