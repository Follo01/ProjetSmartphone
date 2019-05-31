package photophoto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class Photo extends JFrame {
	protected JPanel centre = new JPanel();
	JPanel center;
	
	protected JPanel panelPourBoutton = new JPanel();
	
	protected JButton firstButton = new JButton();
	protected ImageIcon firstImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/Greg.jfif");
	
	protected JButton secondButton = new JButton();
	protected ImageIcon secondImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/DiogoDraw.png");
	
	protected JButton thirdButton = new JButton();
	protected ImageIcon thirdImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
	
	protected JButton fourthButton = new JButton();
	protected ImageIcon fourthImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
	
	protected JButton fifthButton = new JButton();
	protected ImageIcon fifthImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
	
	protected JButton sixthButton = new JButton();
	protected ImageIcon sixthImage = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
	
	protected JButton addButton = new JButton();
	protected ImageIcon addIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/add.png");
	
	protected JButton delete = new JButton();
	protected ImageIcon deleteIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/delete.png");
	
	protected JButton retour = new JButton();
	protected ImageIcon retourIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/return-button.png");
	
	protected JButton nouvelle = new JButton(); 
	protected retourImage essai;
	
	protected retourImage retour1, retour2, retour3, retour4, retour5, retour6;
	private int compteur;
	
	public Photo() {

		setSize(480,700);
		setTitle("Galerie");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		centre.setLayout(new GridLayout(5,2,15,15));
		centre.add(firstButton);
		centre.add(secondButton);
		centre.add(thirdButton);
		centre.add(fourthButton);
		centre.add(fifthButton);
		centre.add(sixthButton);
			
		firstButton.setIcon(firstImage);
		firstButton.setContentAreaFilled(false);
		firstButton.setBorder(null);
		
		secondButton.setIcon(secondImage);
		secondButton.setContentAreaFilled(false);
		secondButton.setBorder(null);	
		
		thirdButton.setIcon(fourthImage);
		thirdButton.setContentAreaFilled(false);
		thirdButton.setBorder(null);
		
		fourthButton.setIcon(fourthImage);
		fourthButton.setContentAreaFilled(false);
		fourthButton.setBorder(null);
		
		fifthButton.setIcon(fourthImage);
		fifthButton.setContentAreaFilled(false);
		fifthButton.setBorder(null);
		
		sixthButton.setIcon(sixthImage);
		sixthButton.setContentAreaFilled(false);
		sixthButton.setBorder(null);
		
		delete.setIcon(deleteIcon);
	    delete.setContentAreaFilled(false);
	    delete.setBorder(null);
		
		addButton.setIcon(addIcon);
		addButton.setContentAreaFilled(false);
		addButton.setBorder(null);
		addButton.setForeground(Color.white);
		
		
		panelPourBoutton.add(addButton);
		panelPourBoutton.add(delete);
		panelPourBoutton.setBackground(Color.white);
		
		add(centre, BorderLayout.CENTER);
		add(panelPourBoutton, BorderLayout.SOUTH);
		centre.setBackground(Color.white);
		
		
		
		firstButton.addActionListener(new Select());
		secondButton.addActionListener(new Select());
		thirdButton.addActionListener(new Select());
		fourthButton.addActionListener(new Select());
		fifthButton.addActionListener(new Select());
		sixthButton.addActionListener(new Select());
		addButton.addActionListener(new Select());
		delete.addActionListener(new Select());
		retour.addActionListener(new Select());
	
	}
	
	private void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	class tempFrame extends JDialog{
		private JButton bouton1 = new JButton("image 1");
		private JButton bouton2 = new JButton("image 2");
		private JButton bouton3 = new JButton("image 3");
		private JButton bouton4 = new JButton("image 4");
		private JButton bouton5 = new JButton("image 5");
		private JButton bouton6 = new JButton("image 6");
		
		private JLabel phrase = new JLabel("Quelle image voulez-vous supprimer ?");
		
		private JPanel buttonPanel = new JPanel();
		private JPanel globalPanel = new JPanel();
		
		public tempFrame() {
			
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(bouton1);
			buttonPanel.add(bouton2);
			buttonPanel.add(bouton3);
			buttonPanel.add(bouton4);
			buttonPanel.add(bouton5);
			buttonPanel.add(bouton6);
			
			bouton1.addActionListener(new DialogEvent());
			bouton2.addActionListener(new DialogEvent());
			bouton3.addActionListener(new DialogEvent());
			bouton4.addActionListener(new DialogEvent());
			bouton5.addActionListener(new DialogEvent());
			bouton6.addActionListener(new DialogEvent());
			
			globalPanel.add(phrase, BorderLayout.CENTER);
			globalPanel.add(buttonPanel);
					
			globalPanel.setLayout(new GridLayout(2,1));
			add(globalPanel);
			
			pack();
			
		}
		
		class DialogEvent implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==bouton1) {
					centre.remove(firstButton);
					centre.updateUI();
					dispose();
				}
				
				if(e.getSource()==bouton2) {
					centre.remove(secondButton);
					centre.updateUI();
					dispose();
				}
				
				if(e.getSource()==bouton3) {
					centre.remove(thirdButton);
					centre.updateUI();
					dispose();
				}
				
				if(e.getSource()==bouton4) {
					centre.remove(fourthButton);
					centre.updateUI();
					dispose();
				}
				
				if(e.getSource()==bouton5) {
					centre.remove(fifthButton);
					centre.updateUI();
					dispose();
				}
				
				if(e.getSource()==bouton6) {
					centre.remove(sixthButton);
					centre.updateUI();
					dispose();
				}
							
			}
		}
		
	}
	
	class Select implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			Photo tesst = new Photo();
			JFileChooser test = new JFileChooser();
			
			
			
			retour1 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/Greg.jfif");
			retour2 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/DiogoDraw.png");
			retour3 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
			retour4 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
			retour5 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
			retour6 = new retourImage("C:/Users/dalme/workspace/AA_PROJET_PROG/src/ookami.jpg");
			
			if(e.getSource()==firstButton) {
				
				retour1.setVisible(true);
				retour1.pack();			
			}
			
			if(e.getSource()==secondButton) {
				
				retour2.setVisible(true);				
				retour2.pack();
				
			}
			
			if(e.getSource()==thirdButton) {
				
				retour3.setVisible(true);				
				retour3.pack();

			}
			
			if(e.getSource()==fourthButton) {
				
				retour4.setVisible(true);				
				retour4.pack();

			}

			if(e.getSource()==fifthButton) {
				
				retour5.setVisible(true);				
				retour5.pack();

			}

			if(e.getSource()==sixthButton) {
				
				retour6.setVisible(true);				
				retour6.pack();

			}
			
			if(e.getSource()==retour) {	
				
				dispose();
			}
			
			if(e.getSource()==delete) {
				tempFrame temp = new tempFrame();
				temp.setVisible(true);
			}
			
			if(e.getSource()==addButton) {
				String path="";
				int retourVal = test.showOpenDialog(Photo.this);
				if(retourVal== JFileChooser.APPROVE_OPTION) {
					File file = test.getSelectedFile();
					path = file.getPath();
					nouvelle = new JButton();
					ImageIcon nouvelleIcon = new ImageIcon(path);
					essai = new retourImage(path);
					
					nouvelle.setIcon(nouvelleIcon);
					nouvelle.setContentAreaFilled(false);
					nouvelle.setBorder(null);
					
					centre.add(nouvelle);
					centre.updateUI();
					
					nouvelle.addActionListener(new Ajout());	
				}
			}
			
			
			
			
		}
		
		class Ajout extends Select implements ActionListener {	
			public void actionPerformed(ActionEvent f) {
				if(f.getSource()== nouvelle) {
					essai.setVisible(true);
					essai.pack();
					System.out.println("coucou");
				}
				
			}
			
		}
	}	
	
	


	class retourImage extends Photo {
	String chemin;
	ImageIcon icone;
	JLabel label;	
	JPanel milieu;
	JPanel ButtonPanel = new JPanel();
	
	public retourImage(String chemin){
	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.chemin = chemin;
		icone = new ImageIcon(chemin);
		label = new JLabel(icone);
		milieu = new JPanel();
			
		milieu.add(label);		
		
		add(milieu, BorderLayout.CENTER);
	    milieu.setBackground(Color.lightGray);	    
	    
	    
	   // delete.addActionListener(new Selects());
	    
	    retour.setIcon(retourIcon);
	    retour.setContentAreaFilled(false);
	    retour.setBorder(null);
	       
	    ButtonPanel.setLayout(new FlowLayout());
	   
	    ButtonPanel.add(retour);

	    add(ButtonPanel, BorderLayout.SOUTH);
	    
	    
			
	}
	
	public String getPath() {
		return this.chemin;
	}
	
	/*class Selects implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Photo r = new Photo();
			if(e.getSource()==delete) {
				retour1.dispose();
				milieu.remove(firstButton);
				milieu.updateUI();
				
				
				
			}
		}
	}*/
	
	
}

}

