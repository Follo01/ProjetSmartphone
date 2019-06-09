
package GUI;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe pour l ecran verrouille
 * @author gregory
 * @since 30.04.2019
 *
 */
public class LockScreen extends MaskPhone {
    /**
     * South : tous les boutons retour, home, delete
     * North : l heure et le texte "Swisscom"
     */	
    JPanel south = new JPanel();
    JPanel north = new JPanel();
    JPanelWithBackground center= new JPanelWithBackground("img/background.jpg");
    JPanelWithBackground background=new JPanelWithBackground("img/background.jpg");
    JPanel centerNorth= new JPanel();
    
    /**
     * Barre des boutons avec leurs icones
     */
    JButton retour = new JButton();
    JButton home = new JButton();
    JButton delete = new JButton();

    ImageIcon ret = new ImageIcon ("img/back.png");
    ImageIcon hom = new ImageIcon ("img/home.png");
    ImageIcon del = new ImageIcon ("img/power.png");

    /**
     * Heure et date
     */
    Date ajd;
    DateFormat dateFormat= new SimpleDateFormat("d MMMM YYYY");
    Date dateform=new Date();

    JLabel heure = new JLabel(getTime());
    java.util.Timer timer = new Timer();
    private Font Theure = new Font ("Arial", Font.PLAIN, 100 );

    JLabel swisscom = new JLabel ("Swisscom");
    JLabel Date=new JLabel(dateFormat.format(dateform));
    
    /**
     * Taille du texte
     */
    Font taille = new Font ("Arial", Font.BOLD, 16 );


    /**
     * 
     * @throws IOException
     */
    public LockScreen() throws IOException {

        /**
         * Reglage de la taille de l ecran
         */
        setSize(480,700);
        setResizable(false);

        /**
         * ActionListener lies aux boutons
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
        home.setMargin(new Insets( 0, 0, 0, 0));         
        home.setIcon(hom);                             
        home.setPreferredSize(new Dimension(45, 45)); 
        home.setBackground(Color.black);             
        home.setBorder(null);

        delete.setMargin(new Insets( 0, 0, 0, 0));
        delete.setIcon(del);
        delete.setPreferredSize(new Dimension(45, 45));
        delete.setBackground(Color.black);
        delete.setBorder(null);

        retour.setMargin(new Insets( 0, 0, 0, 0));
        retour.setIcon(ret);
        retour.setPreferredSize(new Dimension(45, 45));
        retour.setBackground(Color.black);
        retour.setBorder(null);
        
        /**
         * Ajout de la barre Button au sud
         */
        south.add(delete);
        south.add(home);
        south.add(retour);

        add(south, BorderLayout.SOUTH);

        setTimer();



        /**
         * Ajout de l heure et Swisscom au north
         */
        north.setLayout(new BorderLayout());
        north.add(swisscom, BorderLayout.WEST);
        north.add(battery,BorderLayout.EAST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Date.setHorizontalAlignment(JLabel.CENTER);
        add(north, BorderLayout.NORTH);

        add(center,BorderLayout.CENTER);


        /**
         * Gestion des couleurs des JPANEL + ecritures
         */
        north.setBackground(Color.darkGray);
        south.setBackground(Color.black);
        centerNorth.setOpaque(false);
        center.add(centerNorth,BorderLayout.NORTH);
        center.add(background);
        background.setLayout(new BorderLayout());
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);
        Date.setForeground(Color.white);
        swisscom.setFont(taille);
        Heure.setFont(Theure);
        Date.setFont(taille);


        /**
         * Heure centre et date
         */
        centerNorth.setLayout(new BorderLayout());
        centerNorth.add(Heure, BorderLayout.CENTER);
        centerNorth.add(Date, BorderLayout.SOUTH);
        
        /**
         * Le panel CENTER est ajoute separement dans les autres
         * inferfaces afin de pouvoir ajouter
         * ce que l on veut au centre
         */
    }
    
    /**
     * Permet d obtenir l heure du systeme
     * @return l heure
     * 
     */
    private String getTime(){
        ajd = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(ajd);
    }

    /**
     * Permet de modifier l heure
     */
    private void setTimer(){
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Heure.setText(LockScreen.this.getTime());
            }
        }, 1000, 1000);
    }


    class Select implements ActionListener {	
        public void actionPerformed(ActionEvent e) {
            HomeScreen ip = null;
            try {
                ip = new HomeScreen();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if(e.getSource() == retour){
                /**
                 * Revient a la fenetre precedemment ouverte
                 */
                setVisible(false);
                ip.setVisible(true);

            }
            if(e.getSource() == delete){
                /**
                 * Ferme toutes les fenetres
                 */
                System.exit(0);
            }
            
            if(e.getSource() == home){
                /**
                 * Revenir sur l interface principale
                 */
               ip.setVisible(true);
               dispose();
            }
        }
    }
    
    /**
     * 
     * Classe permettant la creation 
     * du fond d ecran
     *
     */
    public class JPanelWithBackground extends JPanel {
        private Image backgroundImage;

        /**
         * Permet d initialiser le fond d écran.
         * @param fileName, le chemin systeme du fond d ecran
         *
         * @throws IOException
         */
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(new File(fileName));
        }

        /**
         * Permet de dessiner notre fond d ecran
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
}