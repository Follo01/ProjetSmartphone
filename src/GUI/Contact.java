
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;

import Contact.InfoContact;
import Contact.ListeContact;

/**
 * Classe de l'application Contact
 * @author Gregory (mise en forme Diogo)
 * @since 31.05.2019
 */
public class Contact extends MaskPhone implements Serializable {
    private ListeContact liste;


    /**
     * Panel nord, sud et centre
     */
    private JPanel pNorth = new JPanel();
    private JPanel pSouth = new JPanel();
    JPanel center = new JPanel();

    /**
     * Tableau et scroll barre 
     */
    private JTable tableau;
    private JScrollPane scroll;

    /**
     * Creation et reglages des champs
     */
    JTextField nom = new JTextField(30);
    JTextField prenom = new JTextField(30);
    JTextField tel = new JTextField(30);

    /**
     * Principaux labels de l application
     */
    JLabel TextNom = new JLabel("Nom :");
    JLabel TextPrenom = new JLabel("Prenom :");
    JLabel TextTel = new JLabel("Numero de telephone :");
    JLabel TextErreur;
    JLabel AfficherNom = new JLabel();
    JLabel AfficherPrenom = new JLabel();
    JLabel AfficherTel = new JLabel();

    /**
     * Principaux boutons de l application
     */
    private JButton ajouter = new JButton("Ajouter");
    private JButton ajouter2 = new JButton("Ajouter");
    private JButton supprimer = new JButton("Supprimer");
    private JButton modifier = new JButton("Modifier");
    private JButton modifier2 = new JButton("Modifier");
    private JButton ok = new JButton("OK");
    private JButton okErreur = new JButton("OK");
    private JButton afficherContact = new JButton("Info");
    private JButton ajouterPhoto = new JButton("Ajouter une photo");

    JButton image1 = new JButton();
    JButton image2 = new JButton();
    JButton image3 = new JButton();
    JButton image4 = new JButton();
    JButton image5 = new JButton();
    JButton image6 = new JButton();

    /**
     * Police du texte
     */
    Font taille = new Font("Arial", Font.PLAIN, 15);

    /**
     * Les differentes classes et frames
     */
    private FrameAdd fenetreAjout;
    private FrameEdit fenetreEdit;
    private JDialog fenetreErreur;
    private JDialog fenetreAfficher;
    private JDialog fenetrePhoto;

    private Photo ph;
    
    /**
     * Permet de savoir si l utilisateur se trouve
     * dans l application Contact ou non.
     * Lien avec la galerie d image
     */
    boolean siContact = true;
        
    /**
     * Represente le chiffre de la photo selectionnee,
     * 0 etant egale a aucune photo
     */
    int chiffrePhoto = 0;
    
    /**
     * Empeche l utilisateur d ouvrir 
     * deux fenetres
     */
    boolean erreurDouble = false;
      
    /**
     * Empeche l utilisateur de creer
     * deux fois un contact
     */
    boolean creation = false;

    /**
     * Constructeur de Contact
     * @throws IOException
     */
    public Contact () throws IOException{
        super();

        /**
         * Lien avec ListeContact
         */
        liste = new ListeContact(this);

        /**
         * Creation de la table
         */
        tableau = new JTable(liste.getArray2D(), new Object[] {"Nom", "Prenom"});
        tableau.setRowHeight(40);

        /**
         * Creation de la scroll barre
         */
        scroll = new JScrollPane(tableau);

        /**
         * Reglages de la scroll barre
         */
        scroll.setPreferredSize(new
        Dimension((int) getContentPane().getPreferredSize().getWidth()-10, 500));
        setTitle("Contact");
       
        /**
         * Liaison des listeners aux boutons y relatifs
         */
        ajouter.addActionListener(new SelectButton());
        supprimer.addActionListener(new SelectButton());
        modifier.addActionListener(new SelectButton());
        afficherContact.addActionListener(new SelectButton());
  
        /**
         * Ajout de la scroll barre dans le panel nord
         * et ce dernier dans le panel centre
         */
        pNorth.add(scroll);
        center.add(pNorth, BorderLayout.NORTH); 

        /**
         * Ajout des boutons dans le panel sud
         * et ce dernier dans le panel centre
         */
        pSouth.add(afficherContact);
        pSouth.add(ajouter);
        pSouth.add(modifier);
        pSouth.add(supprimer);
        center.add(pSouth, BorderLayout.SOUTH); 
        
        add(center, BorderLayout.CENTER);

        /**
         * Mise en forme
         */
        center.setBackground(Color.LIGHT_GRAY);
        pSouth.setBackground(Color.LIGHT_GRAY);
        pNorth.setBackground(Color.GRAY);

        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        tableau.setBackground(Color.DARK_GRAY);
        tableau.setForeground(Color.WHITE);
        tableau.setFont(taille);

        afficherContact.setBackground(Color.darkGray);
        afficherContact.setForeground(Color.WHITE);
        ajouter.setBackground(Color.darkGray);
        ajouter.setForeground(Color.WHITE);
        supprimer.setBackground(Color.DARK_GRAY);
        supprimer.setForeground(Color.WHITE);
        modifier.setBackground(Color.DARK_GRAY);
        modifier.setForeground(Color.WHITE);

        
        /**
         * Ajout de la barre des taches
         */
        north.add(swisscom,BorderLayout.WEST);
        north.add(Heure, BorderLayout.CENTER);
        Heure.setHorizontalAlignment(JLabel.CENTER);
        Heure.setFont(taille);
        swisscom.setForeground(Color.white);
        Heure.setForeground(Color.white);
    }
    
    class SelectButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        	/**
        	 * Lorsque l utilisateur appuie sur le bouton ajouter
        	 * de l application Contact
        	 */
            if(e.getSource()==ajouter) {
                /**
                 * Creation de la fenetre Ajouter
                 */
                try {
                    fenetreAjout = new FrameAdd() ;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                fenetreAjout.setVisible(true) ;

                /**
                 * Remise a zero des differents champs
                 */
                nom.setText("");
                prenom.setText("");
                tel.setText("");


                /**
                 * Empeche les erreurs
                 */
                Contact.this.erreurDouble = false;
                Contact.this.creation = false;
            }

           
            /**
             * Lorsque l utilisateur appuie sur le bouton ajouter
             * de la page Ajouter et que tous les champs
             * sont remplis
             */
            if(e.getSource()==ajouter2 && (!nom.getText().equals("") && !prenom.getText().equals("") && !tel.getText().equals(""))) {
                /**
                 * Ajoute une seule fois
                 */
                if(creation==false) {
                    /**
                     * Ajout du contact
                     */
                    liste.addContact(chiffrePhoto);
                    Contact.this.creation = true;
                }
                
                /**
                 * Actualise le panel de la table
                 */
                refresh();
                tableau.repaint();

                /**
                 * Ferme la fenetre
                 */
                fenetreAjout.dispose();
            }

            /**
             * Lorsque l utilisateur appuie sur le bouton supprimer
             * de l application Contact
             */
            if(e.getSource()==supprimer) {
            	/**
            	 * Supprime le contact selectionne
            	 */
                liste.deleteContact(tableau.getSelectedRow());
                
                /**
                 * Actualisation
                 */
                refresh();
            }

          
            /**
             * Lorsque l utilisateur appuie sur modifier 
             * de l application Contact
             */
            if(e.getSource()==modifier) {
            	/**
            	 * Effectue seulement si un contact est selectionne
            	 */
                if(tableau.getSelectedRow()!=-1) {
                	/**
                	 * Ajout de la fenetre
                	 */
                    try {
                        fenetreEdit = new FrameEdit();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    fenetreEdit.setVisible(true);
                    Contact.this.erreurDouble = false;
                }
            }

            /**
             * Lorsque l utilisateur appuie sur modifier 
             * de la fenetre Modifier et que tous les champs
             * sont remplis
             */
            if(e.getSource()==modifier2 && (!nom.getText().equals("") && !prenom.getText().equals("") && !tel.getText().equals(""))) {            
            	/**
            	 * Modifie le contact
            	 */
                liste.editContact(tableau.getSelectedRow(), new InfoContact(nom.getText(), prenom.getText(), tel.getText(), chiffrePhoto));

                /**
                 * Actualisation
                 */
                refresh();

                /**
                 * Ferme la fenetre
                 */
                fenetreEdit.dispose();
            }

            /**
             * Lorsque l utilisateur appuie sur modifier ou ajouter
             * et les champs ne sont pas tous remplis
             */
            if((e.getSource()==ajouter2 || e.getSource()==modifier2) && (nom.getText().equals("") || prenom.getText().equals("") || tel.getText().equals(""))) {
                /**
                 * Ouverture de la fenetre
                 */
                fenetreErreur = new Erreur();
                fenetreErreur.setModal(true);

                /**
                 * Permet de positionner la fenetre
                 * en fonction de la fenetre precedente
                 */
                if(e.getSource()==ajouter2) {
                    fenetreErreur.setLocationRelativeTo(fenetreAjout);
                }
                else {
                    fenetreErreur.setLocationRelativeTo(fenetreEdit);
                }

                fenetreErreur.setVisible(true);
            }

            /**
             * Lorsque l utilisateur appuie sur OK 
             * de la fenetre erreur
             */
            if(e.getSource()==okErreur) {
                /**
                 * Ferme la fenetre
                 */
                fenetreErreur.dispose();
            }

            /**
             * Lorsque l utilisateur appuie sur info
             * dans l application Contact
             */
            if(e.getSource()==afficherContact) {
                /**
                 * Ouverture de la fenetre
                 */
                fenetreAfficher = new FrameAfficher();
                fenetreAfficher.setModal(true);
                fenetreAfficher.setVisible(true) ;
            }
            
            /**
             * Lorsque l utilisateur appuie sur OK
             * de la fenetre Afficher
             */
            if(e.getSource()==ok) {

            	/**
            	 * Ferme la fenetre
            	 */
                fenetreAfficher.dispose();
            }

            /**
             * Lorsque l utilisateur appuie sur ajouter photo
             * de la fenetre Ajouter
             */
            if(e.getSource()==ajouterPhoto && erreurDouble==false) {
                /**
                 * Ouvre la fenetre
                 */
                fenetrePhoto = new FramePhoto();
                fenetrePhoto.setModal(true);
                fenetrePhoto.setVisible(true);
                Contact.this.erreurDouble=true;
            }

            /**
             * Lorsque l utilisateur appuie sur le bouton
             * d une photo
             */
            if(e.getSource()==image1 && siContact==true) {
                
            	/**
            	 * Permet de savoir quelle photo 
            	 * a ete selectionnee
            	 */
                Contact.this.chiffrePhoto = 1;
                fenetrePhoto.dispose();
            }
            
            if(e.getSource()==image2 && siContact==true) {
                Contact.this.chiffrePhoto = 2;
                fenetrePhoto.dispose();
            }
            
            if(e.getSource()==image3 && siContact==true) {
                Contact.this.chiffrePhoto = 3;
                fenetrePhoto.dispose();
            }
            
            if(e.getSource()==image4 && siContact==true) {
                Contact.this.chiffrePhoto = 4;
                fenetrePhoto.dispose();
            }
            
            if(e.getSource()==image5 && siContact==true) {
            	Contact.this.chiffrePhoto = 5;
            	fenetrePhoto.dispose();        	
            }
            
            if(e.getSource()==image6 && siContact==true) {
            	Contact.this.chiffrePhoto = 6;
            	fenetrePhoto.dispose();
            }
        }
    }
    
    /**
    * Creation de la fenetre Ajouter
    */
    class FrameAdd extends MaskPhone {
    	/**
    	 * Panel principal de cette fenetre
    	 */
        JPanel center = new JPanel();

        /**
         * Constructeur de FrameAdd
         * @throws IOException
         */
        public FrameAdd() throws IOException {
            super();

            /**
             * Mise en forme
             */
            setTitle("Ajouter");

            center.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
            add(center, BorderLayout.CENTER);

            /**
             * Ajout des différents boutons, labels
             * et listeners
             */
            center.add(ajouterPhoto);
            center.add(TextNom);
            center.add(nom);
            center.add(TextPrenom);
            center.add(prenom);
            center.add(TextTel);
            center.add(tel);
            center.add(ajouter2);
            ajouter2.addActionListener(new SelectButton());
            ajouterPhoto.addActionListener(new SelectButton());

            /**
             * Lorsque cette fenetre est ouverte,
             * cela indique que l utilisateur
             * se trouve dans l application contact
             */
            siContact = true;

           
            /**
             * Mise en page comme suit:
             * Panel principal en gris clair
             * Police des differents champs selon
             * la variable taille predefinie
             * 
             * @see Font taille
             */
            center.setBackground(Color.lightGray);     
            TextNom.setForeground(Color.black);         
            TextPrenom.setForeground(Color.black);
            TextTel.setForeground(Color.black); 

            TextNom.setFont(taille);
            TextPrenom.setFont(taille);
            TextTel.setFont(taille);

            /**
             * Mise en forme des boutons comme suit:
             * Fond noir
             * Police blanche
             */
            ajouterPhoto.setBackground(Color.black);
            ajouterPhoto.setForeground(Color.white);

            ajouter2.setBackground(Color.black);
            ajouter2.setForeground(Color.white);
        }
    }
   
    /**
     * Creation de la fenetre d editage
     */
    class FrameEdit extends MaskPhone {

    	/**
    	 * Panel principal de cette fenetre
    	 */
        JPanel center = new JPanel();

        /**
         * Constructeur de FrameEdit
         * @throws IOException
         */
        public FrameEdit() throws IOException {
            super();

            /**
             * Mise en forme
             */
            setTitle("Modifier");

            center.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

            /**
             * Ajout des differents boutons et labels
             * avec leurs formats ainsi que 
             * les differents listeners
             */
            center.add(ajouterPhoto);
            center.add(TextNom);
            center.add(nom);
            nom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 0));

            center.add(TextPrenom);
            center.add(prenom);
            prenom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 1));

            center.add(TextTel);
            center.add(tel);

            tel.setText((String)liste.getArray2D()[tableau.getSelectedRow()][2]);
            center.add(modifier2);

            add(center, BorderLayout.CENTER);

            ajouterPhoto.addActionListener(new SelectButton());
            modifier2.addActionListener(new SelectButton());

            /**
             * Lorsque cette fenetre est ouverte,
             * cela indique que l utilisateur
             * se trouve dans l application contact
             */
            siContact = true;

            /**
             * Mise en page comme suit:
             * Panel principal en gris clair
             * Police des differents champs selon
             * la variable taille predefinie
             * 
             * @see Font taille
             */
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

    /**
     * Creation de la fenetre d erreur
     */
    class Erreur extends JDialog {

    	/**
    	 * Panel principal de cette fenetre
    	 */
        JPanel center = new JPanel();

        /**
         * Constructeur d Erreur
         */
        public Erreur() {
        	/**
        	 * Mise en forme
        	 */
            setTitle("Erreur");

            center.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

            setSize(300,250);

            TextErreur = new JLabel("Veuillez remplir tous les champs du contact!");
            
            /**
             * Ajout du label et du bouton
             */
            center.add(TextErreur);
            center.add(okErreur);
            add(center, BorderLayout.CENTER);

            /**
             * Mise en forme comme suit:
             * Panel principal gris clair
             * Fond du bouton en noir
             * Premier plan du bouton en blanc
             */
            center.setBackground(Color.lightGray);
            okErreur.setBackground(Color.black);
            okErreur.setForeground(Color.white);

            okErreur.addActionListener(new SelectButton());
        }
    }

    /**
     * Creation de la fenetre Afficher
     */
    class FrameAfficher extends BaseDialog {
    	
    	/**
    	 * Panel et police de cette fenetre
    	 */
        JPanel center = new JPanel();
        Font TDetail = new Font("Arial", Font.PLAIN, 13);

        public FrameAfficher() {
        	/**
        	 * Creation de la galerie d image
        	 */
            try {
                ph = new Photo();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /**
             * Mise en forme
             */
            setTitle("Info");

            center.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

            /**
             * Permet d afficher la photo souhaitee
             */
            switch((int)liste.getArray2D()[tableau.getSelectedRow()][3]) {
                case 0:
                    break;
                case 1:
                    JLabel image1 = new JLabel(ph.firstImage);
                    center.add(image1);
                    break;
                case 2:
                    JLabel image2 = new JLabel(ph.secondImage);
                    center.add(image2);
                    break;
                case 3:
                    JLabel image3 = new JLabel(ph.thirdImage);
                    center.add(image3);
                    break;
                case 4:
                    JLabel image4 = new JLabel(ph.fourthImage);
                    center.add(image4);
                    break;
                case 5:
                	JLabel image5 = new JLabel(ph.fifthImage);
                	center.add(image5);
                    break;
                case 6:	
                	JLabel image6 = new JLabel(ph.sixthImage);
                    center.add(image6);
                    break;
            }

            /**
             * Ajout des differents boutons et labels
             * avec leurs formats ainsi que 
             * le listener
             */
            center.add(TextNom);
            center.add(AfficherNom);
            AfficherNom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 0));
            center.add(TextPrenom);
            center.add(AfficherPrenom);
            AfficherPrenom.setText((String)tableau.getValueAt(tableau.getSelectedRow(), 1));
            center.add(TextTel);
            center.add(AfficherTel);
            AfficherTel.setText((String)liste.getArray2D()[tableau.getSelectedRow()][2]);
            center.add(ok);

            ok.addActionListener(new SelectButton());

            add(center, BorderLayout.CENTER);

            /**
             * Mise en page comme suit:
             * Panel principal en gris clair
             * Fond du bouton ok en noir
             * Premier plan du bouton ok en blanc
             * Police des champs Text. selon
             * la variable taille predefinie
             * Police des champs Afficher. selon
             * la variable TDetail predefinie
             * 
             * @see Font taille
             * @see Font TDetail
             * 
             */
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

    /**
     * Creation de la fenetre d ajout photo
     */
    class FramePhoto extends BaseDialog {
    	/**
    	 * Panel de la fenetre
    	 */
        JPanel center = new JPanel();

        /**
         * Constructeur de FramePhoto
         */
        public FramePhoto() {
            try {
                ph = new Photo();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /**
             * Mise en forme de la fenetre
             * et des images
             */
            setTitle("Galerie photo");

            center.setLayout(new GridLayout(3,2));
            center.add(image1);
            center.add(image2);
            center.add(image3);
            center.add(image4);
            center.add(image5);
            center.add(image6);

            image1.setMargin(new Insets(0, 0, 0, 0));
            image1.setIcon(ph.firstImage);

            image2.setMargin(new Insets(0, 0, 0, 0));
            image2.setIcon(ph.secondImage);

            image3.setMargin(new Insets(0, 0, 0, 0));
            image3.setIcon(ph.thirdImage);

            image4.setMargin(new Insets(0, 0, 0, 0));
            image4.setIcon(ph.fourthImage);
            
            image5.setMargin(new Insets(0, 0, 0, 0));
            image5.setIcon(ph.fifthImage);
            
            image6.setMargin(new Insets(0, 0, 0, 0));
            image6.setIcon(ph.sixthImage);

            add(ph.south, BorderLayout.SOUTH);
            add(center, BorderLayout.CENTER);

            /**
             * Mise en forme du panel avec
             * comme fond du gris clair
             */
            center.setBackground(Color.lightGray);

            /**
             * Liaision des listeners aux boutons y relatifs
             */
            image1.addActionListener(new SelectButton());
            image2.addActionListener(new SelectButton());
            image3.addActionListener(new SelectButton());
            image4.addActionListener(new SelectButton());
            image5.addActionListener(new SelectButton());
            image6.addActionListener(new SelectButton());
            

            /**
             * Lorsque cette fenetre est ouverte,
             * cela indique que l utilisateur
             * se trouve dans l application contact
             */
            siContact = true;
        }
    } 
    
    /**
     * Permet d obtenir le nom
     * @return le texte de Nom
     */
    public String getTextNom() {
        return nom.getText();
    }
    
    /**
     * Permet d obtenir le prenom
     * @return le texte de Prenom
     */
    public String getTextPrenom() {
        return prenom.getText();
    }
    
    /**
     * Permet d obtenir le telephone
     * @return le texte de Tel
     */
    public String getTextTel() {
        return tel.getText();
    }
    
    /**
     * Permet d obtenir le numero de la photo
     * @return le numero de la photo
     */
    public int getTextPhoto() {
        return chiffrePhoto;
    }

    /**
     * Permet de rafraichir l affichage
     * ainsi que les differents elements de 
     * l application
     */
    private void refresh() {
        pNorth.remove(scroll);
        tableau = new JTable(liste.getArray2D(), new Object[] {"Nom", "Prenom"});
        tableau.setRowHeight(40);
        scroll = new JScrollPane(tableau);
        scroll.setPreferredSize(new Dimension((int) getContentPane().getPreferredSize().getWidth()-10, 500));
        pNorth.add(scroll);
        pNorth.revalidate();
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        tableau.setBackground(Color.DARK_GRAY);
        tableau.setForeground(Color.WHITE);
        tableau.setFont(taille);
    }
}
