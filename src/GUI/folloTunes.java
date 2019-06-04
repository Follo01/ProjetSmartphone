package GUI;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;


public class folloTunes extends MaskPhone {
    protected JPanel centre = new JPanel();

    protected JButton firstButton = new JButton();
    protected ImageIcon firstImage = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/Greg.jfif");
    protected JLabel firstlabel= new JLabel("wsh");
    protected JPanel firstpanel= new JPanel();

    protected JButton secondButton = new JButton();
    protected ImageIcon secondImage = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/Greg.jfif");
    protected JLabel secondLabel= new JLabel("asdf");
    protected JPanel secondPanel= new JPanel();

    protected JButton thirdButton = new JButton();
    protected ImageIcon thirdImage = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/Greg.jfif");
    protected JLabel thirdLabel= new JLabel("dsaf");
    protected JPanel thirdPanel= new JPanel();

    protected JButton fourthButton = new JButton();
    protected ImageIcon fourthImage = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/Greg.jfif");
    protected JLabel fourthLabel= new JLabel("adsfa");
    protected JPanel fourthPanel= new JPanel();

    protected JButton fifthButton = new JButton();
    protected ImageIcon fifthImage = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/Greg.jfif");
    protected JLabel fifthLabel= new JLabel("asdfa");
    protected JPanel fifthPanel= new JPanel();

    protected JButton sixthButton = new JButton();
    protected ImageIcon sixthImage = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/Greg.jfif");
    protected JLabel sixthLabel= new JLabel("asfd");
    protected JPanel sixthPanel= new JPanel();

    protected JButton retour = new JButton();
    protected ImageIcon retourIcon = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/return-button.png");



    public folloTunes() throws IOException{
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        centre.setLayout(new GridLayout(5,1,15,15));

        firstpanel.setLayout(new FlowLayout());
        firstpanel.add(firstButton);
        firstpanel.add(firstlabel, BorderLayout.EAST);

        secondPanel.setLayout(new FlowLayout());
        secondPanel.add(secondButton);
        secondPanel.add(secondLabel,BorderLayout.EAST);

        thirdPanel.setLayout(new FlowLayout());
        thirdPanel.add(thirdButton);
        thirdPanel.add(thirdLabel,BorderLayout.EAST);

        thirdPanel.setLayout(new FlowLayout());
        fourthPanel.add(fourthButton);
        fourthPanel.add(fourthLabel,BorderLayout.EAST);

        fifthPanel.setLayout(new FlowLayout());
        fifthPanel.add(fifthButton);
        fifthPanel.add(fifthLabel,BorderLayout.EAST);


        sixthPanel.add(sixthButton);
        sixthPanel.add(sixthLabel,BorderLayout.EAST);

        centre.add(firstpanel);
        centre.add(secondPanel);
        centre.add(thirdPanel);
        centre.add(fourthPanel);
        centre.add(fifthPanel);
        centre.add(sixthPanel);


        firstButton.setIcon(firstImage);
        firstButton.setContentAreaFilled(false);
        firstButton.setBorder(null);

        secondButton.setIcon(secondImage);
        secondButton.setContentAreaFilled(false);
        secondButton.setBorder(null);

        thirdButton.setIcon(fourthImage);
        thirdButton.setContentAreaFilled(false);
        thirdButton.setBorder(null);

        fourthButton.setIcon(fourthImage);
        fourthButton.setContentAreaFilled(false);
        fourthButton.setBorder(null);

        fifthButton.setIcon(fourthImage);
        fifthButton.setContentAreaFilled(false);
        fifthButton.setBorder(null);

        sixthButton.setIcon(sixthImage);
        sixthButton.setContentAreaFilled(false);
        sixthButton.setBorder(null);





        add(centre);
    }


    class retourImage extends folloTunes {
        String chemin;
        ImageIcon icone;
        JLabel label;
        JPanel milieu;
        JPanel ButtonPanel = new JPanel();

        /**
         * @param chemin le chemin d'accès de l'image.
         */
        public retourImage(String chemin) throws IOException {


            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.chemin = chemin;
            icone = new ImageIcon(chemin);
            label = new JLabel(icone);
            milieu = new JPanel();

            milieu.add(label);

            add(milieu, BorderLayout.CENTER);
            milieu.setBackground(Color.lightGray);

            retour.setIcon(retourIcon);
            retour.setContentAreaFilled(false);
            retour.setBorder(null);

            ButtonPanel.setLayout(new FlowLayout());
            ButtonPanel.add(retour);


            add(ButtonPanel, BorderLayout.SOUTH);
        }/**
         *
         * @return le chemin d'accès de l'image.
         *
         */
        public String getPath() {
            return this.chemin;
        }
    }
}
