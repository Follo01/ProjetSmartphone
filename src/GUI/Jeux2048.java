package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Jeux2048 extends MaskPhone {
        public Jeux2048() throws IOException {
            // mise en place de la barre des tâche pour chaque
            north.add(swisscom, BorderLayout.WEST);
            north.add(Heure, BorderLayout.CENTER);
            Heure.setHorizontalAlignment(JLabel.CENTER);
            Heure.setFont(taille);
            swisscom.setForeground(Color.white);

        }
}
