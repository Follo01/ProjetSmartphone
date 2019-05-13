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


public class HomeScreen extends MaskPhone {

    private JButton contact= new JButton();
    private JButton follotunes= new JButton();
    private JButton jeux=new JButton();
    private JButton photo= new JButton();
    private JPanelWithBackground apps = new JPanelWithBackground("C:/école HES-SO/ProjetSmartphone/img/background2.jpg") ;
    private ImageIcon contct = new ImageIcon ("C:/école HES-SO/ProjetSmartphone/img/contact.png");
    private ImageIcon app= new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/2048.png");
    private ImageIcon follo = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/follotunes.png");
    private ImageIcon phot = new ImageIcon("C:/école HES-SO/ProjetSmartphone/img/photo.png");
    private JLabel test= new JLabel("Bonjour");
    //Permet de mettre en Arial, taille, et si on veut gras, italique... les différents textes
    private Font Theure = new Font ("Arial", Font.PLAIN, 100 );

    private JPanel center = new JPanel();

    //taille texte



    //private JPanelWithBackground center= new JPanelWithBackground("C:/école HES-SO/ProjetSmartphone/img/Fond d'écran.jpeg");
    //private ... "C:/école HES-SO/ProjetSmartphone/img/Fond d'écran.jpeg"
    public HomeScreen() throws IOException {
        super();

        setTitle("Home Screen");

        center.setLayout(new BorderLayout());


        //mise en place des icon d'interface
        // contact
        contact.setMargin(new Insets( 0, 0, 0, 0));     //enlever les marges
        contact.setIcon(contct);                        //Ajout des images reprensentant le bouton
        contact.setBackground(new Color(0,0,0,0));      // taille bouton
        contact.setOpaque(false);                       // bouton est opaque
        contact.setBorder(null);                        //N'a pas de bordure
        contact.setContentAreaFilled(false);            //Enleve le cadre autour


        follotunes.setMargin(new Insets( 0, 0, 0, 0));     //enlever les marges
        follotunes.setIcon(follo);                        //Ajout des images reprensentant le bouton
        follotunes.setBackground(new Color(0,0,0,0));      // taille bouton
        follotunes.setOpaque(false);                       // bouton est opaque
        follotunes.setBorder(null);                        //N'a pas de bordure
        follotunes.setContentAreaFilled(false);            //Enleve le cadre autour

        photo.setMargin(new Insets( 0, 0, 0, 0));     //enlever les marges
        photo.setIcon(phot);                        //Ajout des images reprensentant le bouton
        photo.setBackground(new Color(0,0,0,0));      // taille bouton
        photo.setOpaque(false);                       // bouton est opaque
        photo.setBorder(null);                        //N'a pas de bordure
        photo.setContentAreaFilled(false);            //Enleve le cadre autour

        jeux.setMargin(new Insets( 0, 0, 0, 0));     //enlever les marges
        jeux.setIcon(app);                        //Ajout des images reprensentant le bouton
        jeux.setBackground(new Color(0,0,0,0));      // taille bouton
        jeux.setOpaque(false);                       // bouton est opaque
        jeux.setBorder(null);                        //N'a pas de bordure
        jeux.setContentAreaFilled(false);            //Enleve le cadre autour

        //Animation des boutons
        contact.addActionListener(new Select());
        follotunes.addActionListener(new Select());
        photo.addActionListener(new Select());
        jeux.addActionListener(new Select());


        apps.setLayout( new FlowLayout() );

        //remetre les heures sur la barre de Tache.
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);
        //Mettre l'heure centré
         //heure.setHorizontalAlignment(SwingConstants.CENTER);

        //center.add(heure, BorderLayout.NORTH);

        add(center, BorderLayout.CENTER);
        add(apps);

        apps.add(contact);
        apps.add(follotunes);
        apps.add(photo);
        apps.add(jeux);

        //Mise en page
        apps.setBackground(Color.white);
       // heure.setFont(Theure);





    }class JPanelWithBackground extends JPanel {
        private Image backgroundImage;

        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(new File(fileName));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the background image.
            g.drawImage(backgroundImage, 0, 0, this);

        }
    }





    class Select implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            HomeScreen ip = null;
            if(e.getSource() == contact){
                //ouvre la page contact lorsqu'on toujours le bouton qui y correspond
                Contact c;
                try {
                    c = new Contact();
                    c.setVisible(true);
                    dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }



            }
            if(e.getSource() == follotunes){
                folloTunes f = null;
                try {
                    f = new folloTunes();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                f.setVisible(true);
                dispose();

            }
            if(e.getSource() == photo){
                Photo p = null;
                try {
                    p = new Photo();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                p.setVisible(true);
                dispose();
            }
             if ( e.getSource()==jeux){
                Jeux2048 j= null;
                 try {
                     j = new Jeux2048();
                 } catch (IOException e1) {
                     e1.printStackTrace();
                 }
                 j.setVisible(true);
                 dispose();
            }
        }

    }
}
