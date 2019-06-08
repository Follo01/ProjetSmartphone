package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import Musique.Son;


public class folloTunes extends MaskPhone {
    protected JPanel centre = new JPanel();

    protected File firstFile= new File("musique/Canton of Valais  Cantón del Valais (Switzerland  Suiza ).wav");
    protected JButton firstButton = new JButton(firstFile.getName());



    protected File secondFile= new File("img/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton secondButton = new JButton(secondFile.getName());


    protected File thirdFile= new File("img/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton thirdButton = new JButton(thirdFile.getName());


    protected File fourthFile= new File("img/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton fourthButton = new JButton(fourthFile.getName());


    protected File fifthFile= new File("img/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
    protected JButton fifthButton = new JButton(fifthFile.getName());


    protected File sixthFile= new File("img/Lifelight (Main Theme Song) [Japanese] - Super Smash Bros. Ultimate Soundtrack.wav");
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
        stop.addActionListener(new Select());
        play.addActionListener(new Select());

        add(centre);
    }
    class Select implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Son music1=new Son(firstFile.getPath());
            Son music2=new Son(secondFile.getPath());
            Son music3=new Son(thirdFile.getPath());
            Son music4=new Son(fourthFile.getPath());
            Son music5=new Son(fifthFile.getPath());
            Son music6=new Son(sixthFile.getPath());
            InputStream stream ;


            try {
                retour1 = new retourmusique(firstFile.getPath());
                retour1.setCpt(1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour2 = new retourmusique(secondFile.getPath());
                retour2.setCpt(2);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour3 = new retourmusique(thirdFile.getPath());
                retour3.setCpt(3);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour4 = new retourmusique(fourthFile.getPath());
                retour4.setCpt(4);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour5 = new retourmusique(fifthFile.getPath());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour6 = new retourmusique(sixthFile.getPath());
            } catch (IOException e1) {
                e1.printStackTrace();
            }


            if (e.getSource() == firstButton) {


                retour1.setVisible(true);
                retour1.pack();
            }

            if (e.getSource() == secondButton) {

                retour2.setVisible(true);
                retour2.pack();
            }

            if (e.getSource() == thirdButton) {

                retour3.setVisible(true);
                retour3.pack();
            }

            if (e.getSource() == fourthButton) {
                retour4.setCpt(4);
                retour4.setVisible(true);
                retour4.pack();

            }

            if (e.getSource() == fifthButton) {
                retour5.setCpt(5);
                retour5.setVisible(true);
                retour5.pack();
            }

            if (e.getSource() == sixthButton) {
                retour6.setCpt(6);
                retour6.setVisible(true);
                retour6.pack();

            }



            if (e.getSource() == stop) {

                if (retour1.getCpt() == 1) {
                    stream = new ByteArrayInputStream(music1.getSamples());
                    music1.stop(stream);

                    dispose();
                }
                if (retour2.getCpt() == 2) {
                    stream = new ByteArrayInputStream(music2.getSamples());
                    music2.stop(stream);
                    dispose();
                }
                if (retour3.getCpt() == 3) {
                    stream = new ByteArrayInputStream(music3.getSamples());
                    music3.stop(stream);
                    dispose();
                }
                if (retour4.getCpt() == 4){
                    stream = new ByteArrayInputStream(music4.getSamples());
                music4.stop(stream);
                dispose();
                }
                if(retour5.getCpt()==5) {
                    stream = new ByteArrayInputStream(music5.getSamples());
                    music5.stop(stream);
                    dispose();
                }
                if(retour6.getCpt()==6) {
                    stream = new ByteArrayInputStream(music6.getSamples());
                    music6.stop(stream);
                    dispose();
                }
            }

            if (e.getSource() == play) {

                    if(retour1.getCpt()==1) {
                        stream = new ByteArrayInputStream(music1.getSamples());
                        music1.play(stream);
                    }
                    if(retour2.getCpt()==2) {
                        stream = new ByteArrayInputStream(music2.getSamples());
                        music2.play(stream);
                    }
                    if(retour3.getCpt()==3) {
                        stream = new ByteArrayInputStream(music3.getSamples());
                        music3.play(stream);
                    }
                    if(retour4.getCpt()==4) {
                        stream = new ByteArrayInputStream(music4.getSamples());
                        music4.play(stream);
                    }
                    if(retour5.getCpt()==5) {
                        stream = new ByteArrayInputStream(music5.getSamples());
                        music5.play(stream);
                    }
                    if(retour6.getCpt()==6) {
                        stream = new ByteArrayInputStream(music6.getSamples());
                        music6.play(stream);
                    }
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
