package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;


public class folloTunes extends MaskPhone {

    public folloTunes() throws IOException{
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);
    }
}
