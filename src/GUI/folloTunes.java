package GUI;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;


public class folloTunes extends MaskPhone {
    protected JPanel centre = new JPanel();
    protected JButton firstButton = new JButton();
    protected ImageIcon firstImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/Greg.jfif");

    protected JButton secondButton = new JButton();
    protected ImageIcon secondImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/DiogoDraw.png");

    protected JButton thirdButton = new JButton();
    protected ImageIcon thirdImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");

    protected JButton fourthButton = new JButton();
    protected ImageIcon fourthImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");

    protected JButton fifthButton = new JButton();
    protected ImageIcon fifthImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");

    protected JButton sixthButton = new JButton();
    protected ImageIcon sixthImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");

    public folloTunes() throws IOException{
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        centre.setLayout(new GridLayout(5,2,15,15));

        centre.add(firstButton);
        centre.add(secondButton);
        centre.add(thirdButton);
        centre.add(fourthButton);
        centre.add(fifthButton);
        centre.add(sixthButton);





    }
}
