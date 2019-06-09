package GUI;

import Musique.Son;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class folloTunes extends MaskPhone {
    protected JPanel centre = new JPanel();

    protected File firstFile= new File("musique/Canton of Valais (Switzerland  Suiza ).wav");
    protected JButton firstButton = new JButton(firstFile.getName());



    protected File secondFile= new File("musique/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton secondButton = new JButton(secondFile.getName());


    protected File thirdFile= new File("musique/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton thirdButton = new JButton(thirdFile.getName());


    protected File fourthFile= new File("musique/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton fourthButton = new JButton(fourthFile.getName());


    protected File fifthFile= new File("musique/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton fifthButton = new JButton(fifthFile.getName());


    protected File sixthFile= new File("musique/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton sixthButton = new JButton(sixthFile.getName());


    protected JButton stop = new JButton();
    protected ImageIcon retourIcon = new ImageIcon("img/Stop.png");

    protected JButton play=new JButton();
    protected ImageIcon playIcon= new ImageIcon("img/Play.png");

    retourmusique retour1, retour2, retour3, retour4, retour5, retour6;

    public folloTunes() throws IOException{
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //centre.setLayout(new GridLayout(5,0,0,0));

        firstButton.setPreferredSize(new Dimension(480, 45));
        //firstpanel.setLayout(new FlowLayout());
        centre.add(firstButton);

        secondButton.setPreferredSize(new Dimension(480, 45));
        //secondPanel.setLayout(new FlowLayout());
        centre.add(secondButton);

        thirdButton.setPreferredSize(new Dimension(480, 45));
        //thirdPanel.setLayout(new FlowLayout());
        centre.add(thirdButton);

        fourthButton.setPreferredSize(new Dimension(480, 45));
        centre.add(fourthButton);


        fifthButton.setPreferredSize(new Dimension(480, 45));
        centre.add(fifthButton);


        sixthButton.setPreferredSize(new Dimension(480, 45));
        centre.add(sixthButton);


        firstButton.setContentAreaFilled(false);
        firstButton.setBorder(null);


        secondButton.setContentAreaFilled(false);
        secondButton.setBorder(null);


        thirdButton.setContentAreaFilled(false);
        thirdButton.setBorder(null);


        fourthButton.setContentAreaFilled(false);
        fourthButton.setBorder(null);


        fifthButton.setContentAreaFilled(false);
        fifthButton.setBorder(null);


        sixthButton.setContentAreaFilled(false);
        sixthButton.setBorder(null);

        firstButton.addActionListener(new Select());
        secondButton.addActionListener(new Select());
        thirdButton.addActionListener(new Select());
        fourthButton.addActionListener(new Select());
        fifthButton.addActionListener(new Select());
        sixthButton.addActionListener(new Select());
        add(centre);
    }
    class Select implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == firstButton) {
                try {
                    retour1 = new retourmusique(firstFile.getPath());

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour1.setVisible(true);
                retour1.pack();
            }

            if (e.getSource() == secondButton) {
                try {
                    retour2 = new retourmusique(secondFile.getPath());

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour2.setVisible(true);
                retour2.pack();
            }

            if (e.getSource() == thirdButton) {
                try {
                    retour3 = new retourmusique(thirdFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour3.setVisible(true);
                retour3.pack();
            }

            if (e.getSource() == fourthButton) {
                try {
                    retour4 = new retourmusique(fourthFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour4.setVisible(true);
                retour4.pack();
            }

            if (e.getSource() == fifthButton) {
                try {
                    retour5 = new retourmusique(fifthFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour5.setVisible(true);
                retour5.pack();
            }

            if (e.getSource() == sixthButton) {
                try {
                    retour6 = new retourmusique(sixthFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour6.setVisible(true);
                retour6.pack();
            }

        }
    }

    class retourmusique extends folloTunes {
        String chemin;
        ImageIcon icone;
        JLabel label;
        JLabel description;
        JPanel milieu;
        JPanel ButtonPanel = new JPanel();
        int cpt;



        /**
         * @param chemin le chemin d'accès de l'image.
         */
        public retourmusique(String chemin) throws IOException {

            System.out.println(chemin);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            this.chemin = chemin;

            icone = new ImageIcon("img/iconmusic.png");
            label = new JLabel(icone);
            milieu = new JPanel();
            File fichier= new File(chemin);
            description = new JLabel(fichier.getName());
            milieu.add(label);

            add(milieu, BorderLayout.NORTH);
            milieu.setBackground(Color.white);
            add(description,BorderLayout.CENTER);

            stop.setIcon(retourIcon);
            stop.setContentAreaFilled(false);
            stop.setBorder(null);

            play.setIcon(playIcon);
            play.setContentAreaFilled(false);
            play.setBorder(null);

            ButtonPanel.setLayout(new FlowLayout());
            ButtonPanel.setBackground(Color.LIGHT_GRAY);
            ButtonPanel.add(stop);
            ButtonPanel.add(play);

            play.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Son music= new Son(chemin);
                    InputStream stream=new ByteArrayInputStream(music.getSamples());
                    music.play(stream);
                }
            });

            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Son music= new Son(chemin);
                    InputStream stream=new ByteArrayInputStream(music.getSamples());
                    music.stop(stream);
                    dispose();
                }
            });

            add(ButtonPanel, BorderLayout.SOUTH);


        }/**
         *
         * @return le chemin d'accès de l'image.
         *
         */
        public String getPath() {
            return this.chemin;
        }
        public int getCpt(){
            return this.cpt;
        }
        public void  setCpt(int cpt){
            this.cpt=cpt;
        }
    }
}
