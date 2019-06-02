package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import Contact.InfoContact;
import Contact.ListeContact;
import GUI.Photo;

import Serialization.Serialization;

public class Contact extends MaskPhone implements Serializable {
    private ListeContact liste;


    private JPanel pNorth = new JPanel();
    private JPanel pSouth = new JPanel();
    JPanel center = new JPanel();

    private JTable tableau;
    private JScrollPane scroll;

    JTextField nom = new JTextField( 30 );
    JTextField prenom = new JTextField( 30 );
    JTextField tel = new JTextField( 30 );

    JLabel TextNom = new JLabel("Nom :");
    JLabel TextPrenom = new JLabel("Prenom :");
    JLabel TextTel = new JLabel("Numéro de téléphone :");
    JLabel TextErreur;
    JLabel AfficherNom = new JLabel();
    JLabel AfficherPrenom = new JLabel();
    JLabel AfficherTel = new JLabel();

    private JButton ajouter = new JButton ("Ajouter");
    private JButton ajouter2 = new JButton ("Ajouter");
    private JButton supprimer= new JButton("Supprimer");
    private JButton modifier= new JButton("Modifier");
    private JButton modifier2= new JButton("Modifier");
    private JButton ok= new JButton("OK");
    private JButton okErreur= new JButton("OK");
    private JButton afficherContact= new JButton("Info");
    private JButton ajouterPhoto= new JButton("Ajouter une photo");

    JButton he = new JButton();
    JButton sr = new JButton();
    JButton si = new JButton();
    JButton vs = new JButton();

    Font taille = new Font ("Arial", Font.PLAIN, 15 );

    private FrameAdd fenetreAjout;
    private FrameEdit fenetreEdit;
    private JDialog fenetreErreur;
    private JDialog fenetreAfficher;
    private JDialog fenetrePhoto;

    private Photo ph;

    //permet de savoir si on est dans l'application de Contact ou pas... pour permettre le lien avec la galerie
    boolean siContact=true;
    //représente le chiffre de la photo séléctionné... 0 est égal à aucune photo
    int chiffrePhoto = 0;
    //empèche d'ouvrir 2 fenêtre
    boolean erreurDouble=false;
    //empèche de créer 2 fois un contact
    boolean creation=false;

    public Contact () throws IOException{
        super();

        //lien avec ListeContact
        liste = new ListeContact(this);

        //Création de la JTable
        tableau = new JTable(liste.getArray2D(), new Object[] {"Nom", "Prenom"});
        tableau.setRowHeight(40);

        //création de la JScroll
        scroll = new JScrollPane(tableau);

        //taille du scroll
        scroll.setPreferredSize( new Dimension( (int) getContentPane().getPreferredSize().getWidth()-10, 600 ) );

        setTitle("Contact");

        // Ajout du listener au bouton "Ajouter" de la fenêtre d'ajout
        ajouter.addActionListener(new SelectButton(  ));
        supprimer.addActionListener(new SelectButton(  ));
        modifier.addActionListener(new SelectButton(  ));
        afficherContact.addActionListener(new SelectButton(  ));


        //Ajout des coordonnées 1ère fenêtre
        pNorth.add(scroll);
        center.add(pNorth, BorderLayout.NORTH); // Ajout du panel pNorth dans le panel CENTER


        //Ajout des boutons
        pSouth.add(afficherContact);
        pSouth.add(ajouter);
        pSouth.add(modifier);
        pSouth.add(supprimer);
        center.add(pSouth, BorderLayout.SOUTH); // Ajout du panel pSouth dans le panel CENTER

        add(center, BorderLayout.CENTER);

        //Mise en page
        center.setBackground(Color.black);
        pSouth.setBackground(Color.black);
        pNorth.setBackground(Color.black);

        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        tableau.setBackground(Color.DARK_GRAY);
        tableau.setForeground(Color.white);
        tableau.setFont(taille);

        afficherContact.setBackground(Color.darkGray);
        afficherContact.setForeground(Color.WHITE);
        ajouter.setBackground(Color.darkGray);
        ajouter.setForeground(Color.WHITE);
        supprimer.setBackground(Color.darkGray);
        supprimer.setForeground(Color.WHITE);
        modifier.setBackground(Color.darkGray);
        modifier.setForeground(Color.WHITE);

        // mise en place de la barre des tâche pour chaque
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);




    }
    class SelectButton implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {

            //Quand on appuie sur le bouton ajouter de l'application contact
            if(e.getSource()==ajouter)
            {
                //création de la fenêtre ajouter
                fenetreAjout = new FrameAdd() ;
                fenetreAjout.setVisible(true) ;

                //remise à zero des champs
                nom.setText("");
                prenom.setText("");
                tel.setText("");
                Contact.this.chiffrePhoto=0;

                //empecher les erreurs
                Contact.this.erreurDouble=false;
                Contact.this.creation=false;


            }

            //Quand on appuie sur le bouton ajouter de la page ajouter et que tous les champs sont rempli
            if(e.getSource()==ajouter2 &&  (!nom.getText().equals("") && !prenom.getText().equals("") && !tel.getText().equals("")) )
            {
                //ajouter 1 seule fois
                if(creation==false){
                    //ajout du contact
                    liste.addContact(chiffrePhoto);
                    Contact.this.creation=true;
                }

                //réactualise la panel de la JTable
                refresh();

                //ferme la fenêtre
                fenetreAjout.dispose();


            }

            //Quand on appuie sur le bouton supprimer de Contact
            if(e.getSource()==supprimer )
            {
                //supprime le contact sélectionné
                liste.deleteContact(tableau.getSelectedRow());
                //actualise la JTable
                refresh();


            }

            //Quand tu appuies sur modifier dans la fenêtre Contact
            if(e.getSource()==modifier )
            {
                //effectue cela seulement si un contact est séléctionné
                if(tableau.getSelectedRow()!=-1){
                    //ajout de la fenêtre
                    try {
                        fenetreEdit = new FrameEdit() ;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    fenetreEdit.setVisible(true) ;
                    Contact.this.erreurDouble=false;
                }
            }

            //Quand on appuie sur modifier dans la fenêtre modifier et que tous les champs sont rempli
            if(e.getSource()==modifier2 &&  (!nom.getText().equals("") && !prenom.getText().equals("") && !tel.getText().equals("")))
            {
                //modifie le contact
                liste.editContact(tableau.getSelectedRow(), new InfoContact(nom.getText(), prenom.getText(), tel.getText(), chiffrePhoto));

                //rafraichi la JTable
                refresh();

                //ferme la fenêtre
                fenetreEdit.dispose();
            }

            //Quand tu appuie sur modifier ou ajouter et que pas tous les champs sont rempli
            if((e.getSource()==ajouter2 || e.getSource()==modifier2) &&  (nom.getText().equals("") || prenom.getText().equals("") || tel.getText().equals("")))
            {
                //ouverture de la fenêtre
                fenetreErreur = new Erreur() ;
                fenetreErreur.setModal(true);

                //permet de centré la fenêtre en fonction de la fenêtre précedante
                if(e.getSource()==ajouter2){
                    fenetreErreur.setLocationRelativeTo(fenetreAjout);
                }
                else{
                    fenetreErreur.setLocationRelativeTo(fenetreEdit);
                }

                fenetreErreur.setVisible(true);


            }

            //Quand tu appuis sur OK de la fenêtre erreur
            if(e.getSource()==okErreur)
            {
                //ferme la fenêtre
                fenetreErreur.dispose();
            }

            //Quand tu appuie sur info dans Contact
            if(e.getSource()==afficherContact )
            {
                //ouverture de la fenêtre
                fenetreAfficher = new FrameAfficher() ;
                fenetreAfficher.setModal(true);
                fenetreAfficher.setVisible(true) ;

            }
            //Quand tu appuie sur OK dans la fenêtre Afficher
            if(e.getSource()==ok)
            {
                //ferme la fenêtre
                fenetreAfficher.dispose();
            }

            //Quand tu appuies sur ajouter photo dans la fenêtre d'ajout
            if(e.getSource()==ajouterPhoto && erreurDouble==false)
            {
                //Ouvre la fenêtre
                fenetrePhoto = new FramePhoto() ;
                fenetrePhoto.setModal(true);
                fenetrePhoto.setVisible(true);
                Contact.this.erreurDouble=true;

            }

            //Quand tu appuie sur le bouton d'une photo
            if(e.getSource() == he  && siContact==true){
                //permet de savoir quel photo a été séléctionné
                Contact.this.chiffrePhoto=1;
                fenetrePhoto.dispose();
            }
            if(e.getSource() == sr  && siContact==true){
                Contact.this.chiffrePhoto=2;
                fenetrePhoto.dispose();

            }
            if(e.getSource() == si  && siContact==true){
                Contact.this.chiffrePhoto=3;
                fenetrePhoto.dispose();
            }
            if(e.getSource() == vs  && siContact==true){
                Contact.this.chiffrePhoto=4;
                fenetrePhoto.dispose();
            }
        }
    }//Création de la fenêtre d'ajout
    class FrameAdd extends BaseDialog
    {


        JPanel center = new JPanel();



        public FrameAdd(){
            super();

            setTitle("Ajouter");

            center.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 50 ) );
            add(center, BorderLayout.CENTER);

            center.add(ajouterPhoto);
            center.add(TextNom);
            center.add(nom) ;
            center.add(TextPrenom);
            center.add(prenom) ;
            center.add(TextTel);
            center.add(tel) ;
            center.add(ajouter2);
            ajouter2.addActionListener(new SelectButton(  ));
            ajouterPhoto.addActionListener(new SelectButton(  ));

            //Quand cette fenêtre est ouverte, ca indique que l'on est dans contact
            siContact=true;

            //Mise en page
            center.setBackground(Color.lightGray);      //JPanel center sera en gris clair
            TextNom.setForeground(Color.black);         //Le texteNom sera en écriture noire
            TextPrenom.setForeground(Color.black);      //Le textePrenom sera en écriture noire
            TextTel.setForeground(Color.black);         //Le texteTel sera en écriture noire

            //Le setFont permet de reprendre la ligne plus au de Font... où on a choisi la police d'écriture, type, taille
            TextNom.setFont(taille);
            TextPrenom.setFont(taille);
            TextTel.setFont(taille);

            //Les boutons ajouter et ajouter2, sont en fond noir avec écriture blanche
            ajouterPhoto.setBackground(Color.black);
            ajouterPhoto.setForeground(Color.white);

            ajouter2.setBackground(Color.black);
            ajouter2.setForeground(Color.white);
        }

    } //Création de la fenêtre d'éditage
    class FrameEdit extends MaskPhone
    {

        JPanel center = new JPanel ();


        public FrameEdit() throws IOException {
            super();

            setTitle("Modifier");

            center.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 50 ) );

            center.add(ajouterPhoto);
            center.add(TextNom);
            center.add(nom) ;
            nom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 0));

            center.add(TextPrenom);
            center.add(prenom) ;
            prenom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 1));

            center.add(TextTel);
            center.add(tel) ;

            tel.setText((String)liste.getArray2D()[tableau.getSelectedRow()][2]);
            center.add(modifier2);

            add(center, BorderLayout.CENTER);

            ajouterPhoto.addActionListener(new SelectButton(  ));
            modifier2.addActionListener(new SelectButton(  ));

            //Quand cette fenêtre est ouverte, ca indique que l'on est dans contact
            siContact=true;

            // Mise en page
            center.setBackground(Color.lightGray);

            ajouterPhoto.setBackground(Color.black);
            ajouterPhoto.setForeground(Color.white);
            modifier2.setForeground(Color.white);
            modifier2.setBackground(Color.black);

            TextNom.setFont(taille);
            TextPrenom.setFont(taille);
            TextTel.setFont(taille);

        }

    }

    //Création de la fenêtre d'erreur
    class Erreur extends JDialog    {

        JPanel center = new JPanel ();


        public Erreur(){


            setTitle("Erreur");


            center.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 50 ) );


            setSize(300,250);


            TextErreur = new JLabel("Veillez remplir tous les champs du contact!");

            center.add(TextErreur);
            center.add(okErreur);
            add(center, BorderLayout.CENTER);

            //Mise en page
            center.setBackground(Color.lightGray);
            okErreur.setBackground(Color.black);
            okErreur.setForeground(Color.white);

            okErreur.addActionListener(new SelectButton(  ));

        }

    }

    //Création de la fenêtre Aficher
    class FrameAfficher extends BaseDialog
    {

        JPanel center = new JPanel ();
        Font TDetail = new Font("Arial", Font.PLAIN, 13);

        public FrameAfficher(){

            try {
                ph= new Photo();
            } catch (IOException e) {
                e.printStackTrace();
            }

            setTitle("Info");


            center.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 50 ) );


            //permet d'afficher la photo voulu
            switch((int)liste.getArray2D()[tableau.getSelectedRow()][3]){
                case 0:
                    break;
                case 1:
                    JLabel imageHes = new JLabel(ph.hes);
                    center.add(imageHes);
                    break;
                case 2:
                    JLabel imageSierre = new JLabel(ph.sierre);
                    center.add(imageSierre);
                    break;
                case 3:
                    JLabel imageSion = new JLabel(ph.sion);
                    center.add(imageSion);
                    break;
                case 4:
                    JLabel imageVS = new JLabel(ph.valais);
                    center.add(imageVS);
                    break;

            }


            center.add(TextNom);
            center.add(AfficherNom);
            AfficherNom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 0));
            center.add(TextPrenom);
            center.add(AfficherPrenom) ;
            AfficherPrenom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 1));
            center.add(TextTel);
            center.add(AfficherTel) ;
            AfficherTel.setText((String)liste.getArray2D()[tableau.getSelectedRow()][2]);
            center.add(ok);


            ok.addActionListener(new SelectButton(  ));

            add(center, BorderLayout.CENTER);

            //Mise en page
            center.setBackground(Color.lightGray);
            ok.setBackground(Color.black);
            ok.setForeground(Color.white);

            TextNom.setFont(taille);
            TextPrenom.setFont(taille);
            TextTel.setFont(taille);

            AfficherNom.setFont(TDetail);
            AfficherPrenom.setFont(TDetail);
            AfficherTel.setFont(TDetail);



        }

    }

    //Création de la fenêtre d'ajout de photo
    class FramePhoto extends BaseDialog
    {

        JPanel center = new JPanel () ;

        public FramePhoto(){
            try {
                ph= new Photo();
            } catch (IOException e) {
                e.printStackTrace();
            }

            setTitle("Galerie photo");


            center.setLayout(new GridLayout(3,2));
            center.add(he);
            center.add(sr);
            center.add(si);
            center.add(vs);

            he.setMargin(new Insets( 0, 0, 0, 0));
            he.setIcon(ph.hes);

            sr.setMargin(new Insets( 0, 0, 0, 0));
            sr.setIcon(ph.sierre);

            si.setMargin(new Insets( 0, 0, 0, 0));
            si.setIcon(ph.sion);

            vs.setMargin(new Insets( 0, 0, 0, 0));
            vs.setIcon(ph.valais);




            add(ph.south, BorderLayout.SOUTH);
            add(center, BorderLayout.CENTER);

            //Mise en page
            center.setBackground(Color.lightGray);

            he.addActionListener(new SelectButton(  ));
            sr.addActionListener(new SelectButton(  ));
            vs.addActionListener(new SelectButton(  ));
            si.addActionListener(new SelectButton(  ));

            siContact=true;

        }

    } //Permet d'accéder aux informations écritent dans les champs
    public String getTextNom()
    {
        return nom.getText();
    }
    public String getTextPrenom()
    {
        return prenom.getText();
    }
    public String getTextTel()
    {
        return tel.getText();
    }
    public int getTextPhoto()
    {

        return chiffrePhoto;
    }

    private void refresh()
    {
        pNorth.remove(scroll);
        tableau = new JTable(liste.getArray2D(), new Object[] {"Nom", "Prenom"});
        tableau.setRowHeight(40);
        scroll = new JScrollPane(tableau);
        scroll.setPreferredSize( new Dimension( (int) getContentPane().getPreferredSize().getWidth()-10, 600 ) );
        pNorth.add(scroll);
        pNorth.revalidate();
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        tableau.setBackground(Color.DARK_GRAY);
        tableau.setForeground(Color.white);
        tableau.setFont(taille);
    }

}
