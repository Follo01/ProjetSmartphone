package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.MaskPhone.Select;

/**
 * Classe pour nos JDialog
 * @author gregory (mise en forme Diogo)
 * @since 31.05.2019
 */

public class BaseDialog extends JDialog {
	/**
	 * Panel sud et nord
	 */
    private JPanel south = new JPanel();
    private JPanel north = new JPanel();

    /**
     * Boutons principaux
     */
    private JButton retour = new JButton();
    private JButton home = new JButton();
    private JButton delete = new JButton();

    /**
     * Icones des boutons
     */
    private ImageIcon ret = new ImageIcon("img/retour.png");
    private ImageIcon hom = new ImageIcon("img/home.png");
    private ImageIcon del = new ImageIcon("img/delete.png");

    /**
     *Heure du telephone
     */
    private Date ajd;
    private JLabel heure = new JLabel(getTime());
    private Timer timer = new Timer();

    private JLabel swisscom = new JLabel("Swisscom");

    /**
     * Taille du texte
     */
    private Font taille = new Font("Arial", Font.PLAIN, 16);

    /**
     * Constructeur de BaseDialog
     */
    public BaseDialog() {

        /**
         * Reglage de la taille de l ecran
         */
        setSize(480,800);

        /**
         * ActionListeners lies aux boutons
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
        home.setPreferredSize(new Dimension(145, 45)); 
        home.setBackground(Color.WHITE);

        delete.setMargin(new Insets(0, 0, 0, 0));
        delete.setIcon(del);
        delete.setPreferredSize(new Dimension(145, 45));
        delete.setBackground(Color.WHITE);

        retour.setMargin(new Insets(0, 0, 0, 0));
        retour.setIcon(ret);
        retour.setPreferredSize(new Dimension(145, 45));
        retour.setBackground(Color.WHITE);

        /**
         * Ajout de la bar Button au sud
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
        north.add(heure, BorderLayout.EAST);
        add(north, BorderLayout.NORTH);

        /**
         * Gestion des couleurs des JPANEL + ecritures
         */
        north.setBackground(Color.darkGray);
        south.setBackground(Color.WHITE);
        swisscom.setForeground(Color.white);
        heure.setForeground(Color.white);

        swisscom.setFont(taille);
        heure.setFont(taille);

        /**
         * Le panel CENTER est ajoute separement dans les autres
         * inferfaces afin de pouvoir ajouter
         * ce que l on veut au centre.
         */
    }

    /**
     * Permet d obtenir l heure du systeme
     * @return l heure
     * 
     */
    private String getTime() {
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
                heure.setText(BaseDialog.this.getTime());
            }
        }, 1000, 1000);
    }
    
    class Select implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==retour){
                setVisible(false);
                /**
                 * Revient a la fenetre precedemment ouverte
                 */
            }
            
            if(e.getSource()==delete){
                System.exit(0);
                /**
                 * Ferme toutes les fenetres
                 */
            }
            
            if(e.getSource()==home){
                HomeScreen ip = null;
                try {
                    ip = new HomeScreen();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ip.setVisible(true);
                /**
                 * Revenir sur l interface principale
                 */
            }
        }
    }
}
