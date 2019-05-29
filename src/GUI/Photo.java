package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import javax.swing.JLabel;


public class Photo extends MaskPhone {
    protected JPanel centre = new JPanel();
    protected JPanel bas = new JPanel();


    protected JPanel panelPourBoutton = new JPanel();

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

    protected JButton addButton = new JButton();
    protected ImageIcon addIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/add.png");

    protected JButton delete = new JButton();
    protected ImageIcon deleteIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/delete.png");

    protected JButton retour = new JButton();
    protected ImageIcon retourIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/return-button.png");

    retourImage retour1;
    retourImage retour2;
    retourImage retour3;
    private int compteur;

    public Photo()throws IOException{
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);

        setTitle("Galerie");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        centre.setLayout(new GridLayout(5,2,15,15));
        centre.add(firstButton);
        centre.add(secondButton);
        centre.add(thirdButton);
        centre.add(fourthButton);
        centre.add(fifthButton);
        centre.add(sixthButton);

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

        delete.setIcon(deleteIcon);
        delete.setContentAreaFilled(false);
        delete.setBorder(null);

        addButton.setIcon(addIcon);
        addButton.setContentAreaFilled(false);
        addButton.setBorder(null);
        addButton.setForeground(Color.white);


        panelPourBoutton.add(addButton);
        panelPourBoutton.add(delete);
        panelPourBoutton.add(home);
        panelPourBoutton.setBackground(Color.BLACK);
        bas.add(panelPourBoutton, BorderLayout.NORTH);

        add(centre, BorderLayout.CENTER);
        add(bas,BorderLayout.SOUTH);

        centre.setBackground(Color.white);



        firstButton.addActionListener(new Select());
        secondButton.addActionListener(new Select());
        thirdButton.addActionListener(new Select());
        addButton.addActionListener(new Select());
        delete.addActionListener(new Select());
        retour.addActionListener(new Select());



    }class tempFrame extends JDialog{ //suppression
        private JButton bouton1 = new JButton("image 1");
        private JButton bouton2 = new JButton("image 2");
        private JButton bouton3 = new JButton("image 3");

        private JLabel phrase = new JLabel("Quelle image voulez-vous supprimer ?");

        private JPanel buttonPanel = new JPanel();
        private JPanel globalPanel = new JPanel();

        public tempFrame() {

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(bouton1);
            buttonPanel.add(bouton2);
            buttonPanel.add(bouton3);

            bouton1.addActionListener(new DialogEvent());
            bouton2.addActionListener(new DialogEvent());
            bouton3.addActionListener(new DialogEvent());

            globalPanel.add(phrase, BorderLayout.CENTER);
            globalPanel.add(buttonPanel);

            globalPanel.setLayout(new GridLayout(2,1));
            add(globalPanel);

            pack();

        }

        class DialogEvent implements ActionListener{
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==bouton1) {
                    centre.remove(firstButton);
                    centre.updateUI();
                    dispose();
                }

                if(e.getSource()==bouton2) {
                    centre.remove(secondButton);
                    centre.updateUI();
                    dispose();
                }

                if(e.getSource()==bouton3) {
                    centre.remove(thirdButton);
                    centre.updateUI();
                    dispose();
                }

            }
        }

    }class Select implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {//à enlever
                Photo tesst = new Photo();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JFileChooser test = new JFileChooser(); //choisir le fichier
            try {
                retour1 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/Greg.jfif");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour2 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/DiogoDraw.png");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour3 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if(e.getSource()==firstButton) {

                retour1.setVisible(true);
                retour1.pack();


                System.out.println(compteur);

            }

            if(e.getSource()==secondButton) {

                retour2.setVisible(true);
                retour2.pack();
                setVisible(false);
                compteur=2;

            }

            if(e.getSource()==thirdButton) {

                retour3.setVisible(true);
                retour3.pack();
                setVisible(false);
                compteur=3;
            }



            if(e.getSource()==retour) {

                dispose();
            }

            if(e.getSource()==delete) {
                tempFrame temp = new tempFrame();
                temp.setVisible(true);
            }

            if(e.getSource()==addButton) {
                String path="";
                int retourVal = test.showOpenDialog(Photo.this);
                if(retourVal== JFileChooser.APPROVE_OPTION) {
                    File file = test.getSelectedFile();
                    path = file.getPath();
                    JButton nouvelle = new JButton();
                    ImageIcon nouvelleIcon = new ImageIcon(path);

                    nouvelle.setIcon(nouvelleIcon);
                    nouvelle.setContentAreaFilled(false);
                    nouvelle.setBorder(null);

                    centre.add(nouvelle);
                    centre.updateUI();

                    nouvelle.addActionListener(new Select());
                }
            }


        }
    }


    class retourImage extends Photo {
        String chemin;
        ImageIcon icone;
        JLabel label;
        JPanel milieu;
        JPanel ButtonPanel = new JPanel();

        public retourImage(String chemin) throws IOException {
            super();

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.chemin = chemin;
            icone = new ImageIcon(chemin);
            label = new JLabel(icone);
            milieu = new JPanel();

            milieu.add(label);

            add(milieu, BorderLayout.CENTER);
            milieu.setBackground(Color.lightGray);


            // delete.addActionListener(new Selects());

            retour.setIcon(retourIcon);
            retour.setContentAreaFilled(false);
            retour.setBorder(null);

            ButtonPanel.setLayout(new FlowLayout());

            ButtonPanel.add(retour);

            add(ButtonPanel, BorderLayout.SOUTH);


        }

        public String getPath() {
            return this.chemin;
        }
    }
}
