package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * Classe servant de template pour le telephone
 * @author Gregory (mise en forme Diogo)
 * @since 15.04.2019
 */
public class MaskPhone extends JFrame {
    /**
     * Batterie du systeme
     */
    Kernel32.SYSTEM_POWER_STATUS batt = new Kernel32.SYSTEM_POWER_STATUS();
  
    
    /**
     * Creation des differents panels et boutons
     */
    JPanel south = new JPanel();
    JPanel north = new JPanel();

    JButton home = new JButton();
    JButton delete = new JButton();
    JButton retour = new JButton();

    /**
     * Icone des boutons
     */
    ImageIcon ret = new ImageIcon("img/back.png");
    ImageIcon hom = new ImageIcon("img/home.png");
    ImageIcon del = new ImageIcon("img/power.png");

    JLabel swisscom = new JLabel("Swisscom");
    
    /**
     * Creation de la batterie dans une interface externe
     */
    public JLabel battery = new JLabel(getbatterypourcentPercent());

    /**
     * Heure et date du systeme
     */
    Date ajd;
    DateFormat dateFormat = new SimpleDateFormat("d MMMM YYYY");
    Date dateform = new Date();

    /**
     * Creation du label pour l heure et la date
     * et des polices
     */
    public JLabel Heure = new JLabel(getTime());
    java.util.Timer timer = new Timer();
    Font THeure = new Font("Arial", Font.PLAIN, 100);
    Font taille = new Font("Arial", Font.BOLD, 16);
    JLabel Date=new JLabel(dateFormat.format(dateform));

    /**
     * Constructeur de MaskPhone
     * @throws IOException
     */
    public MaskPhone() throws IOException {
    	/**
    	 * Mise en forme
    	 */
        setSize(480,700);
        setResizable(false);

        /**
         * Liaision des listeners aux boutons
         */
        retour.addActionListener(new Select());
        delete.addActionListener(new Select());
        home.addActionListener(new Select());

        /**
         * Incorpore les images aux boutons avec comme reglages:
         * la suppression des marges
         * l icone du bouton
         * sa taille
         * sa couleur
         */
        home.setMargin(new Insets(0, 0, 0, 0));        
        home.setIcon(hom);                              
        home.setPreferredSize(new Dimension(45, 45));
        home.setBackground(Color.black);             
        home.setBorder(null);

        delete.setMargin(new Insets(0, 0, 0, 0));
        delete.setIcon(del);
        delete.setPreferredSize(new Dimension(45, 45));
        delete.setBackground(Color.black);
        delete.setBorder(null);

        retour.setMargin(new Insets(0, 0, 0, 0));
        retour.setIcon(ret);
        retour.setPreferredSize(new Dimension(45, 45));
        retour.setBackground(Color.black);
        retour.setBorder(null);

        /**
         * Ajout des boutons dans le panel sud
         */
        south.add(delete);
        south.add(home);
        south.add(retour);
        add(south, BorderLayout.SOUTH);

        /**
         * Ajout de l heure et Swisscom dans le panel nord
         */
        north.setLayout(new BorderLayout());
        north.add(swisscom, BorderLayout.WEST);
        north.add(battery,BorderLayout.EAST);
        add(north, BorderLayout.NORTH);

        /**
         * Mise en forme des panels et labels
         */
        north.setBackground(Color.black);
        south.setBackground(Color.black);
        swisscom.setForeground(Color.white);
        battery.setForeground(Color.white);
    }

    class Select implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeScreen ip = null;
            try {
                ip = new HomeScreen();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if(e.getSource()==retour) {
            	/**
                 * Revient a la fenetre precedemment ouverte
                 */
                setVisible(false);
                ip.setVisible(true);
            }
            
            if(e.getSource()==delete) {
            	/**
                 * Ferme toutes les fenetres
                 */
                System.exit(0);
            }
            
            if(e.getSource()==home) {
            	/**
                 * Revenir sur l interface principale
                 */
                ip.setVisible(true);
                dispose();
            }
        }
    }
    
    /**
     * Classe permettant la creation 
     * du fond d ecran
     */
    public class JPanelWithBackground extends JPanel {
        private Image backgroundImage;

        /**
         * Permet d initialiser le fond d ecran
         * @param fileName, le chemin systeme du fond d'écran
         *
         * @throws IOException
         */
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(new File(fileName));
        }

        /**
         * Permet de dessiner notre fond d ecran
         * @param une variable temporaire Graphics
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
    
    /**
     * Permet d obtenir la date du systeme
     * @return la date avec le format souhaite
     */
    private String getTime() {
        ajd = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(ajd);
    }
    
    /**
     * Permet d obtenir le pourcentage de batterie restant
     * @return le pourcentage
     */
    private String getbatterypourcentPercent() {
        Kernel32.INSTANCE.GetSystemPowerStatus(batt);
        return batt.getBatteryLifePercent() ;
    }
}
