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
import java.io.IOException;


public  class MaskPhone extends JFrame {
    JPanel south = new JPanel ();
    JPanel north = new JPanel ();

    JButton home = new JButton();
    JButton delete = new JButton();
    JButton retour= new JButton();

    ImageIcon ret = new ImageIcon ("C:/école HES-SO/Java/Cours beuchat/MonGUi/Retour.png");
    ImageIcon hom = new ImageIcon ("C:/école HES-SO/Java/Cours beuchat/MonGUi/Maison.png");
    ImageIcon del = new ImageIcon ("C:/école HES-SO/Java/Cours beuchat/MonGUi/Supp.png");

    JLabel swisscom = new JLabel ("Swisscom");

    //Heure et date
    Date ajd;
    DateFormat dateFormat= new SimpleDateFormat("d MMMM YYYY");
    Date dateform=new Date();

    JLabel Heure = new JLabel(getTime());
    java.util.Timer timer = new Timer();
    Font THeure = new Font ("Arial", Font.PLAIN, 100 );
    Font taille = new Font ("Arial", Font.BOLD, 16 );
    JLabel Date=new JLabel(dateFormat.format(dateform));

    public MaskPhone() throws IOException{
        setSize(480,700);
        setResizable(false);

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

        south.add(delete);
        south.add(home);
        south.add(retour);
        add(south, BorderLayout.SOUTH);

        north.setLayout(new BorderLayout());
        north.add(swisscom, BorderLayout.WEST);
        add(north, BorderLayout.NORTH);

        north.setBackground(Color.black);
        south.setBackground(Color.black);
        swisscom.setForeground(Color.white);



    }class Select implements ActionListener {


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
    } private String getTime(){
        ajd = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(ajd);
    }
}
