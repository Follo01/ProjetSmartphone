package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class HomeScreen extends MaskPhone {

    private JButton contact= new JButton();
    private JButton follotunes= new JButton();
    private JButton photo= new JButton();
    private JPanelWithBackground apps = new JPanelWithBackground("img/background2.jpg") ;
    private ImageIcon contct = new ImageIcon ("img/contact.png");
    private ImageIcon follo = new ImageIcon("img/follotunes.png");
    private ImageIcon phot = new ImageIcon("img/photo.png");

    private JLabel test= new JLabel("Bonjour");
    //Permet de mettre en Arial, taille, et si on veut gras, italique... les différents textes
    private Font Theure = new Font ("Arial", Font.PLAIN, 100 );

    private JPanel center = new JPanel();

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



        //Animation des boutons
        contact.addActionListener(new Select());
        follotunes.addActionListener(new Select());
        photo.addActionListener(new Select());

        apps.setLayout( new FlowLayout() );

        //remetre les heures sur la barre de Tache.
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


        //Mise en page
        apps.setBackground(Color.white);


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

        }

    }
}
