package photophoto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

import javax.swing.*;
/**
 * 
 * @author Diogo
 *
 */

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
	
	protected JButton retour = new JButton();
	protected ImageIcon retourIcon = new ImageIcon("C:/Users/dalme/workspace/AA_PROJET_PROG/src/return-button.png");
	
	protected JButton nouvelle = new JButton(); 
	protected retourImage essai;
	
	protected retourImage retour1, retour2, retour3, retour4, retour5, retour6;

	
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
			
		addButton.setIcon(addIcon);
		addButton.setContentAreaFilled(false);
		addButton.setBorder(null);
		addButton.setForeground(Color.white);
			
		panelPourBoutton.add(addButton);
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
		retour.addActionListener(new Select());
		
		firstButton.addMouseListener(new MERDE());
		secondButton.addMouseListener(new MERDE());
		thirdButton.addMouseListener(new MERDE());
		fourthButton.addMouseListener(new MERDE());
		fifthButton.addMouseListener(new MERDE());
		sixthButton.addMouseListener(new MERDE());	
	}
	
	class Select implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
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
					nouvelle.addMouseListener(new MERDE());
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
		
		class MERDE implements MouseListener{		
			private Date pressedTime;
			private long timeClicked;
			private int a;
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				pressedTime = new Date();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				timeClicked = new Date().getTime() - pressedTime.getTime();
				tempFrame cheh = new tempFrame();
				if(timeClicked>=1000) {
					a = JOptionPane.showConfirmDialog(cheh, "Voulez-vous supprimer cette image ?", "Confirmation", JOptionPane.YES_NO_OPTION);
					cheh.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					cheh.pack();
					
					if(arg0.getSource()==firstButton) {
						if(a==JOptionPane.YES_OPTION) {
							retour1.dispose();
							centre.remove(firstButton);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}
					
					if(arg0.getSource()==secondButton) {
						if(a==JOptionPane.YES_OPTION) {
							retour2.dispose();
							centre.remove(secondButton);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}

					if(arg0.getSource()==thirdButton) {
						if(a==JOptionPane.YES_OPTION) {
							retour3.dispose();
							centre.remove(thirdButton);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}
					
					if(arg0.getSource()==fourthButton) {
						if(a==JOptionPane.YES_OPTION) {
							retour4.dispose();
							centre.remove(fourthButton);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}
					
					if(arg0.getSource()==fifthButton) {
						if(a==JOptionPane.YES_OPTION) {
							retour5.dispose();
							centre.remove(fifthButton);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}

					if(arg0.getSource()==sixthButton) {
						if(a==JOptionPane.YES_OPTION) {
							retour6.dispose();
							centre.remove(sixthButton);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}
					
					if(arg0.getSource()==nouvelle) {
						if(a==JOptionPane.YES_OPTION) {
							essai.dispose();
							centre.remove(nouvelle);
							centre.updateUI();
						}
						if(a==JOptionPane.NO_OPTION) {
							cheh.dispose();
						}
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
}

}

