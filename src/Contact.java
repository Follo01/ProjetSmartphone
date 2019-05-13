import java.awt.*;
import java.io.IOException;

import javax.swing.*;


public class Contact extends MaskPhone {



    public Contact () throws IOException{

        // mise en place de la barre des tâche pour chaque
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);
    }


}
