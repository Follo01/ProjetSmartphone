package GUI;


import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe pour la page d accueil du telephone
 * @author Gregory (mise en forme Diogo)
 * @since 29.04.2019
 */

public class HomeScreen extends MaskPhone {
    private JButton contact = new JButton();
    private JButton follotunes = new JButton();
    private JButton photo = new JButton();
    private JPanelWithBackground apps = new JPanelWithBackground("img/background2.jpg");
    private ImageIcon contct = new ImageIcon("img/contact.png");
    private ImageIcon follo = new ImageIcon("img/follotunes.png");
    private ImageIcon phot = new ImageIcon("img/photo.png");
    
    /**
     * Format de l heure
     */
    private Font Theure = new Font ("Arial", Font.PLAIN, 100 );

    private JPanel center = new JPanel();
  
    /**
     * Constructeur de HomeScreen
     * @throws IOException
     */
    public HomeScreen() throws IOException {
        super();

        setTitle("Home Screen");

        center.setLayout(new BorderLayout());


        /**
         * Mise en place des icones d application
         * avec comme reglages :
         * Sans marge
         * Leur icone
         * Leur taille
         * L'opacité
         * Sans bordure
         * Sans cadre
         */
        contact.setMargin(new Insets( 0, 0, 0, 0));    
        contact.setIcon(contct);                     
        contact.setBackground(new Color( 0, 0, 0, 0));      
        contact.setOpaque(false);                       
        contact.setBorder(null);                        
        contact.setContentAreaFilled(false);       

        follotunes.setMargin(new Insets( 0, 0, 0, 0));     
        follotunes.setIcon(follo);                        
        follotunes.setBackground(new Color( 0, 0, 0, 0));    
        follotunes.setOpaque(false);                       
        follotunes.setBorder(null);                     
        follotunes.setContentAreaFilled(false);           

        photo.setMargin(new Insets( 0, 0, 0, 0));     
        photo.setIcon(phot);                      
        photo.setBackground(new Color( 0, 0, 0, 0));      
        photo.setOpaque(false);                     
        photo.setBorder(null);                        
        photo.setContentAreaFilled(false);            

        /**
         * Liaison des listeners aux boutons
         */
        contact.addActionListener(new Select());
        follotunes.addActionListener(new Select());
        photo.addActionListener(new Select());

        apps.setLayout( new FlowLayout() );

        /**
         * Informations generales sur la barre de taches
         */
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);

        add(center, BorderLayout.CENTER);
        add(apps);

        apps.add(contact);
        apps.add(follotunes);
        apps.add(photo);

        /**
         * Mise en page
         */
        apps.setBackground(Color.white);
    }
    
    /**
     * Classe pour le fond d ecran
     */
    class JPanelWithBackground extends JPanel {
        private Image backgroundImage;
        
        /**
         * Constructeur de JPanelWithBackgroun
         * @param le chemin systeme du fond voulu
         * @throws IOException
         */
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(new File(fileName));
        }
        
        /**
         * Permet de dessiner notre fond d ecran
         * @param variable Graphics temporaire
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(backgroundImage, 0, 0, this);
        }
    }

    class Select implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeScreen ip = null;
            
            /**
             * Ouvre l'application correspondante
             */
            if(e.getSource()==contact) { 
                Contact c;
                try {
                    c = new Contact();
                    c.setVisible(true);
                    dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            
            if(e.getSource()==follotunes) {
                folloTunes f = null;
                try {
                    f = new folloTunes();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                f.setVisible(true);
                dispose();
            }
            
            if(e.getSource()==photo){
                Photo p = null;
                try {
                    p = new Photo();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.setVisible(true);
                dispose();
            }
        }
    }
}
