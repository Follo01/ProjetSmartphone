package GUI;

import javax.swing.*;
import java.io.IOException;

/**
 * Classe pour demarrer le telephone
 * @author Gregory (mise en forme Diogo)
 * @since 15.04.2019
 */
public class MainGui extends JFrame {
    public static void main(String[] args) throws IOException {
    	/**
    	 * Affichage du telephone
    	 */
    	LockScreen lockScreen = new LockScreen();
		lockScreen.setVisible(true);
    }
}
