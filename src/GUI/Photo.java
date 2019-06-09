package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Classe pour l'application Photo
 * 
 * @author Diogo (mise en forme Gregory)
 * @since 13.05.2019
 * 
 */
public class Photo extends MaskPhone {
	
	/**
	 * Panel de la galerie et du bouton
	 */
    protected JPanel centre = new JPanel();
    protected JPanel panelPourBoutton = new JPanel();

    /**
     * Creation des boutons pour les images
     */
    protected JButton firstButton = new JButton();
    protected ImageIcon firstImage = new ImageIcon("./img/Greg.jfif");

    protected JButton secondButton = new JButton();
    protected ImageIcon secondImage = new ImageIcon("./img/DiogoDraw.png");

    protected JButton thirdButton = new JButton();
    protected ImageIcon thirdImage = new ImageIcon("./img/ookami.jpg");

    protected JButton fourthButton = new JButton();
    protected ImageIcon fourthImage = new ImageIcon("./img/Captain_Berthouz.png");

    protected JButton fifthButton = new JButton();
    protected ImageIcon fifthImage = new ImageIcon("./img/papy.jpg");

    protected JButton sixthButton = new JButton();
    protected ImageIcon sixthImage = new ImageIcon("./img/Kevin.jfif");

    protected JButton seventhButton = new JButton();
    protected ImageIcon seventhImage = new ImageIcon("./img/Mickamorph.png");

    protected JButton eighthButton = new JButton();
    protected ImageIcon eighthImage = new ImageIcon("./img/Cake.png");

    /**
     * Boutons d ajout et de retour
     */
    protected JButton addButton = new JButton();
    protected ImageIcon addIcon = new ImageIcon("./img/add.png");

    protected JButton retour = new JButton();
    protected ImageIcon retourIcon = new ImageIcon("./img/return-button.png");

    /**
     * Bouton pour les images ajoutees
     */
    protected JButton nouvelle = new JButton();
    protected RetourImage nouvelleImage;

    /**
     * Attributs pour l affichage des images
     */
    protected RetourImage retour1, retour2, retour3, retour4, retour5, retour6, retour7, retour8;

    /**
     * Constructeur de Photo
     * @throws IOException
     */
    public Photo() throws IOException {

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

        setTitle("Galerie");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /**
         * Ajout des boutons d images dans le panel principal
         */
        centre.setLayout(new GridLayout(5,2,15,15));
        centre.add(firstButton);
        centre.add(secondButton);
        centre.add(thirdButton);
        centre.add(fourthButton);
        centre.add(fifthButton);
        centre.add(sixthButton);
        centre.add(seventhButton);
        centre.add(eighthButton);
               
        /**
         * Reglages graphiques des boutons d images
         */
        firstButton.setIcon(firstImage);
        firstButton.setContentAreaFilled(false);
        firstButton.setBorder(null);

        secondButton.setIcon(secondImage);
        secondButton.setContentAreaFilled(false);
        secondButton.setBorder(null);

        thirdButton.setIcon(thirdImage);
        thirdButton.setContentAreaFilled(false);
        thirdButton.setBorder(null);

        fourthButton.setIcon(fourthImage);
        fourthButton.setContentAreaFilled(false);
        fourthButton.setBorder(null);

        fifthButton.setIcon(fifthImage);
        fifthButton.setContentAreaFilled(false);
        fifthButton.setBorder(null);

        sixthButton.setIcon(sixthImage);
        sixthButton.setContentAreaFilled(false);
        sixthButton.setBorder(null);

        seventhButton.setIcon(seventhImage);
        seventhButton.setContentAreaFilled(false);
        seventhButton.setBorder(null);

        eighthButton.setIcon(eighthImage);
        eighthButton.setContentAreaFilled(false);
        eighthButton.setBorder(null);

        addButton.setIcon(addIcon);
        addButton.setContentAreaFilled(false);
        addButton.setBorder(null);
        addButton.setForeground(Color.white);
   
        panelPourBoutton.add(addButton);
        panelPourBoutton.add(home);
        panelPourBoutton.add(delete);
        panelPourBoutton.setBackground(Color.black);

        add(centre, BorderLayout.CENTER);
        add(panelPourBoutton, BorderLayout.SOUTH);
        centre.setBackground(Color.LIGHT_GRAY);

        /**
         * Liaison des listeners avec les boutons
         */
        firstButton.addActionListener(new Select());
        secondButton.addActionListener(new Select());
        thirdButton.addActionListener(new Select());
        fourthButton.addActionListener(new Select());
        fifthButton.addActionListener(new Select());
        sixthButton.addActionListener(new Select());
        seventhButton.addActionListener(new Select());
        eighthButton.addActionListener(new Select());
        addButton.addActionListener(new Select());
        retour.addActionListener(new Select());

        firstButton.addMouseListener(new Delete());
        secondButton.addMouseListener(new Delete());
        thirdButton.addMouseListener(new Delete());
        fourthButton.addMouseListener(new Delete());
        fifthButton.addMouseListener(new Delete());
        sixthButton.addMouseListener(new Delete());
        seventhButton.addMouseListener(new Delete());
        eighthButton.addMouseListener(new Delete());
    }

    class Select implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser selectDossier = new JFileChooser();
            
            /**
             * Try and catch pour l initialisation 
             * des images
             */
            try {
                retour1 = new RetourImage("./img/Greg.jfif");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour2 = new RetourImage("./img/DiogoDraw.png");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour3 = new RetourImage("./img/ookami.jpg");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour4 = new RetourImage("./img/Captain_Berthouz.png");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour5 = new RetourImage("./img/papy.jpg");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour6 = new RetourImage("./img/Kevin.jfif");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour7 = new RetourImage("./img/Mickamorph.png");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                retour8 = new RetourImage("./img/Cake.png");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            /**
             * Affiche l image dans une nouvelle fenetre
             */
            if(e.getSource()==firstButton) {
                retour1.setVisible(true);
                retour1.pack();
            }

            if(e.getSource()==secondButton) {
                retour2.setVisible(true);
                retour2.pack();
            }

            if(e.getSource()==thirdButton) {
                retour3.setVisible(true);
                retour3.pack();
            }

            if(e.getSource()==fourthButton) {
                retour4.setVisible(true);
                retour4.pack();
            }

            if(e.getSource()==fifthButton) {
                retour5.setVisible(true);
                retour5.pack();
            }

            if(e.getSource()==sixthButton) {
                retour6.setVisible(true);
                retour6.pack();
            }

            if(e.getSource()==seventhButton) {
                retour7.setVisible(true);
                retour7.pack();
            }

            if(e.getSource()==eighthButton) {
                retour8.setVisible(true);
                retour8.pack();
            }

            /**
             * Ferme la fenetre 
             */
            if(e.getSource()==retour) {
                dispose();
            }

            /**
             * Ajout d image
             */
            if(e.getSource()==addButton) {
                String path = "";
                int retourVal = selectDossier.showOpenDialog(Photo.this);
                
                /**
                 * Lorsque l utilisateur a choisi son image,
                 * un nouveau bouton est cree avec son icone
                 * et ses listeners.
                 * 
                 */
                if(retourVal == JFileChooser.APPROVE_OPTION) {
                    File file = selectDossier.getSelectedFile();
                    path = file.getPath();
                    nouvelle = new JButton();
                    ImageIcon nouvelleIcon = new ImageIcon(path);
                    try {
                        nouvelleImage = new RetourImage(path);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    nouvelle.setIcon(nouvelleIcon);
                    nouvelle.setContentAreaFilled(false);
                    nouvelle.setBorder(null);

                    centre.add(nouvelle);
                    centre.updateUI();

                    nouvelle.addActionListener(new Ajout());
                    nouvelle.addMouseListener(new Delete());
                }
            }
        }

        /**
         * Listener pour les boutons d images ajoutes
         *
         */
        class Ajout extends Select implements ActionListener {
            public void actionPerformed(ActionEvent f) {
                if(f.getSource()== nouvelle) {
                    nouvelleImage.setVisible(true);
                    nouvelleImage.pack();
                }
            }
        }
    }
    
    /**
     * Listener pour la suppression d image
     */
    class Delete implements MouseListener{
        private Date pressedTime;
        private long timeClicked;
        private int a;

        /**
         * Stock la duree de la pression de la souris
         */
        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            pressedTime = new Date();
        }

        /**
         * Si l utilisateur presse suffisamment longtemps
         * la souris, une boite de dialogue s ouvre
         * proposant a l utilisateur de supprimer
         * l image sur laquelle il se trouve
         */
        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
            timeClicked = new Date().getTime() - pressedTime.getTime();
            tempFrame confirmationFrame = new tempFrame();
            if(timeClicked>=1000) {
                a = JOptionPane.showConfirmDialog(confirmationFrame, "Voulez-vous supprimer cette image ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                confirmationFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                confirmationFrame.pack();

                if(arg0.getSource()==firstButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour1.dispose();
                        centre.remove(firstButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==secondButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour2.dispose();
                        centre.remove(secondButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==thirdButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour3.dispose();
                        centre.remove(thirdButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==fourthButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour4.dispose();
                        centre.remove(fourthButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==fifthButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour5.dispose();
                        centre.remove(fifthButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==sixthButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour6.dispose();
                        centre.remove(sixthButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==seventhButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour7.dispose();
                        centre.remove(seventhButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==eighthButton) {
                    if(a==JOptionPane.YES_OPTION) {
                        retour8.dispose();
                        centre.remove(eighthButton);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }

                if(arg0.getSource()==nouvelle) {
                    if(a==JOptionPane.YES_OPTION) {
                        nouvelleImage.dispose();
                        centre.remove(nouvelle);
                        centre.updateUI();
                    }
                    
                    if(a==JOptionPane.NO_OPTION) {
                        confirmationFrame.dispose();
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }


        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }

    /**
     * 
     * Classe pour la fenetre d affichage des images
     *
     */
    class RetourImage extends Photo {
        String chemin;
        ImageIcon icone;
        JLabel label;
        JPanel milieu;
        JPanel ButtonPanel = new JPanel();

        /**
         *
         * Constructeur de RetourImage
         * @param chemin
         * le chemin d acces de l image
         */
        public RetourImage(String chemin) throws IOException {
        	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        	
        	/**
        	 * L image est affiche dans un label
        	 * puis dans le panel milieu (propre a
        	 * sa classe)
        	 * 
        	 */
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
        }

        /**
         * Permet d obtenir le chemin d acces de l image
         * @return son chemin d acces
         *
         */
        public String getPath() {
            return this.chemin;
        }
    }

}