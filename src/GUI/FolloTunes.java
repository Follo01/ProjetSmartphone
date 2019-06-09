package GUI;

import Musique.Son2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Classe pour l'application folloTunes
 * @author Gregory et Diogo (mise en forme Diogo)
 * @since 03.06.2019
 *
 */
public class FolloTunes extends MaskPhone {
    protected JPanel centre = new JPanel();

    /**
     * Creation des boutons
     */
    protected File firstFile= new File( "musique/Canton of Valais (Switzerland  Suiza ).wav");
    protected JButton firstButton = new JButton(firstFile.getName());

    protected File secondFile= new File("musique/Lifelight (Main Theme Song) [Japanese].wav");
    protected JButton secondButton = new JButton(secondFile.getName());

    protected File thirdFile= new File("musique/Abreu Tico Tico  Barenboim  Berliner Philharmoniker.wav");
    protected JButton thirdButton = new JButton(thirdFile.getName());

    protected File fourthFile= new File("musique/George Frideric Handels - Water Music.wav");
    protected JButton fourthButton = new JButton(fourthFile.getName());

    protected File fifthFile= new File("musique/Dvorak Symphony 9,  Allegro Con Fuoco.wav");
    protected JButton fifthButton = new JButton(fifthFile.getName());

    protected File sixthFile= new File("musique/Jean Baptiste Lully -Marche pour la ceremonie des Turcs.wav");
    protected JButton sixthButton = new JButton(sixthFile.getName());

    protected JButton stop = new JButton();
    protected ImageIcon retourIcon = new ImageIcon("img/Stop.png");

    protected JButton play=new JButton();
    protected ImageIcon playIcon= new ImageIcon("img/Play.png");

    protected JButton pause = new JButton();
    protected ImageIcon pauseIcon = new ImageIcon("img/pause.png");
    
    /**
     * Attributs pour les frames d'affichage
     */
    Retourmusique retour1, retour2, retour3, retour4, retour5, retour6;

    /**
     * Constructeur de FolloTunes
     * @throws IOException
     */
    public FolloTunes() throws IOException {
    	/**
    	 * Barre du haut avec les differentes informations 
    	 * du telephone
    	 */
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //centre.setLayout(new GridLayout(5,0,0,0));

        /**
         * Mise en forme des boutons et 
         * ajout dans le panel principal
         */
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
        
        
        /**
         * Liaison des listeners avec les boutons
         */
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
        	
        	/**
        	 * Ouvrir la fenetre
        	 */
            if(e.getSource() == firstButton) {
                try {
                    retour1 = new Retourmusique(firstFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour1.setVisible(true);
                retour1.pack();
            }

            if(e.getSource() == secondButton) {
                try {
                    retour2 = new Retourmusique(secondFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour2.setVisible(true);
                retour2.pack();
            }

            if(e.getSource() == thirdButton) {
                try {
                    retour3 = new Retourmusique(thirdFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour3.setVisible(true);
                retour3.pack();
            }

            if (e.getSource() == fourthButton) {
                try {
                    retour4 = new Retourmusique(fourthFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour4.setVisible(true);
                retour4.pack();
            }

            if (e.getSource() == fifthButton) {
                try {
                    retour5 = new Retourmusique(fifthFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour5.setVisible(true);
                retour5.pack();
            }

            if (e.getSource()==sixthButton) {
                try {
                    retour6 = new Retourmusique(sixthFile.getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                retour6.setVisible(true);
                retour6.pack();
            }
        }
    }
    
    /**
     * Classe pour la fenetre d affichage
     */
    class Retourmusique extends FolloTunes {
        String chemin;
        ImageIcon icone;
        JLabel label;
        JLabel description;
        JPanel milieu;
        JPanel ButtonPanel = new JPanel();
        Son2 audioPlayer ;

        /**
         * Constructeur de RetourMusique
         * @param chemin le chemin d'accès du fichier son
         */
        public Retourmusique(String chemin) throws IOException {

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
            
            pause.setIcon(pauseIcon);
            pause.setContentAreaFilled(false);
            pause.setBorder(null);

            ButtonPanel.setLayout(new FlowLayout());
            ButtonPanel.setBackground(Color.LIGHT_GRAY);
            ButtonPanel.add(stop);
            ButtonPanel.add(pause);
            ButtonPanel.add(play);

            /**
             * ActionListeners creent pour jouer et stopper la musique
             */
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
        }
        
        /**
         * Permet d obtenir le chemin d acces du fichier
         * @return le chemin d acces de l image
         *
         */
        public String getPath() {
            return this.chemin;
        }
        
    }
}