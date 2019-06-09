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

public class BaseDialog extends JDialog {
    private JPanel south = new JPanel ();
    private JPanel north = new JPanel ();


    //Button bar
    private JButton retour = new JButton();
    private JButton home = new JButton();
    private JButton delete = new JButton();


    private ImageIcon ret = new ImageIcon ("./src/img/retour.png");
    private ImageIcon hom = new ImageIcon ("./src/img/home.png");
    private ImageIcon del = new ImageIcon ("./src/img/delete.png");

    /**
     * Heure
     * L'heure on va l'insérer dans un JLabel et pour la récupérer en utilise une méthode.
     * On a également une méthode pour la rafraîchir
     */

    private Date ajd;
    private JLabel heure = new JLabel(getTime());
    private Timer timer = new Timer();


    private JLabel swisscom = new JLabel ("Swisscom");

    //taille texte
    private Font taille = new Font ("Arial", Font.PLAIN, 16 );

    public BaseDialog()
    {

        //Taille de l'écran smartphone
        setSize(480,800);


        //Bar Button avec les animations des boutons
        retour.addActionListener(new Select());
        delete.addActionListener(new Select());
        home.addActionListener(new Select());

        //Incorporé les images aux boutons avec certains réglages comme la taille et couleur
        home.setMargin(new Insets( 0, 0, 0, 0));         // Enlever les marges
        home.setIcon(hom);                              // ajout image représentant le home dans le bouton home
        home.setPreferredSize(new Dimension(145, 45)); // taille bouton
        home.setBackground(Color.WHITE);             //couleur du bouton

        delete.setMargin(new Insets( 0, 0, 0, 0));
        delete.setIcon(del);
        delete.setPreferredSize(new Dimension(145, 45));
        delete.setBackground(Color.WHITE);

        retour.setMargin(new Insets( 0, 0, 0, 0));
        retour.setIcon(ret);
        retour.setPreferredSize(new Dimension(145, 45));
        retour.setBackground(Color.WHITE);

        south.add(delete);
        south.add(home);
        south.add(retour);

        add(south, BorderLayout.SOUTH);

        //Heure
        setTimer();


        //Ajout de l'heure et Swisscon au north
        north.setLayout(new BorderLayout());
        north.add(swisscom, BorderLayout.WEST);
        north.add(heure, BorderLayout.EAST);
        add(north, BorderLayout.NORTH);

        //Gestion des couleurs fond + écritures
        north.setBackground(Color.BLACK);
        south.setBackground(Color.WHITE);
        swisscom.setForeground(Color.WHITE);
        heure.setForeground(Color.WHITE);

        swisscom.setFont(taille);
        heure.setFont(taille);



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
                heure.setText(BaseDialog.this.getTime());
            }
        }, 1000, 1000);
    }
    /**
     * Ces lignes de code concerne la selection des différents boutons de la Button Bar
     *
     */
    class Select implements ActionListener{


        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == retour){
                setVisible(false);
                //revient à la fenêtre precedente ouverte

            }
            if(e.getSource() == delete){
                System.exit(0);
                // quitte complètement le smartphone
            }
            if(e.getSource() == home){

                HomeScreen ip = null;
                try {
                    ip = new HomeScreen();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ip.setVisible(true);
                //reouvre la page de l'interface principale
            }

        }

    }

}
