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
import java.util.TimerTask;
import javax.imageio.ImageIO;
import java.io.File;

public class LockScreen extends MaskPhone {
    /*
     * South : tous les boutons retour, home, delete
     * North : l'heure et le texte "Swisscon"
     */
    JPanel south = new JPanel ();
    JPanel north = new JPanel ();
    JPanelWithBackground center= new JPanelWithBackground("C:/école HES-SO/ProjetSmartphone/img/background.jpg");
    JPanelWithBackground background=new JPanelWithBackground("C:/école HES-SO/ProjetSmartphone/img/background.jpg");
    JPanel centerNorth= new JPanel();
    //Button bar + image
    JButton retour = new JButton();
    JButton home = new JButton();
    JButton delete = new JButton();


    ImageIcon ret = new ImageIcon ("C:/école HES-SO/ProjetSmartphone/img/back.png");
    ImageIcon hom = new ImageIcon ("C:/école HES-SO/ProjetSmartphone/img/home.png");
    ImageIcon del = new ImageIcon ("C:/école HES-SO/ProjetSmartphone/img/power.png");

    //Heure et date
    Date ajd;
    DateFormat dateFormat= new SimpleDateFormat("d MMMM YYYY");
    Date dateform=new Date();

    JLabel heure = new JLabel(getTime());
    java.util.Timer timer = new Timer();
    private Font Theure = new Font ("Arial", Font.PLAIN, 100 );

    JLabel swisscom = new JLabel ("Swisscom");
    JLabel Date=new JLabel(dateFormat.format(dateform));
    //taille texte
    Font taille = new Font ("Arial", Font.BOLD, 16 );


    public LockScreen() throws IOException {

        //Taille de l'écran smartphone
        setSize(480,700);
        setResizable(false);

        //Bar Button avec les animations (ActionListener)
        retour.addActionListener(new Select());
        delete.addActionListener(new Select());
        home.addActionListener(new Select());

        //Incorporé les images aux boutons avec certains réglages comme la taille et couleur
        home.setMargin(new Insets( 0, 0, 0, 0));         // Enlever les marges
        home.setIcon(hom);                              // ajout image représentant le home dans le bouton home
        home.setPreferredSize(new Dimension(45, 45)); // taille bouton
        home.setBackground(Color.black);             //couleur du bouton
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
        //Ajout de la bar Button au sud
        south.add(delete);
        south.add(home);
        south.add(retour);

        add(south, BorderLayout.SOUTH);

        //Heure
        setTimer();



        //Ajout de l'heure et Swisscon au north
        north.setLayout(new BorderLayout());
        north.add(swisscom, BorderLayout.WEST);
        north.add(battery,BorderLayout.EAST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Date.setHorizontalAlignment(JLabel.CENTER);
        add(north, BorderLayout.NORTH);

        add(center,BorderLayout.CENTER);


        //Gestion des couleurs des JPANEL + écritures

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
        Heure.setFont(THeure);
        Date.setFont(taille);


        // heure centrale et date
        centerNorth.setLayout(new BorderLayout());
       centerNorth.add(Heure, BorderLayout.CENTER);
        centerNorth.add(Date, BorderLayout.SOUTH);
// Le panel CENTER est ajouté séparéement dans les autres inferfaces afin de pouvoir ajouter ce que l'on veut au centre.

    }




    /**
     * ça nous permet de récupérer l'heure ainsi que le rafaîchir
     * @return le format de l'heure
     */
    private String getTime(){
        ajd = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(ajd);
    }

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
                //revient à la fenêtre précèdemment ouverte
                setVisible(false);
                ip.setVisible(true);

            }
            if(e.getSource() == delete){
                //ferme toutes les fenêtres
                System.exit(0);
            }
           if(e.getSource() == home){
                //revenir sur l'interface principale

               ip.setVisible(true);
               dispose();
            }

        }

    }public class JPanelWithBackground extends JPanel {

        private Image backgroundImage;

        // Some code to initialize the background image.
        // Here, we use the constructor to load the image. This
        // can vary depending on the use case of the panel.
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(new File(fileName));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the background image.
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
}
