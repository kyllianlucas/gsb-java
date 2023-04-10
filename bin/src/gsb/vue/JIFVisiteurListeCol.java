package gsb.vue;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class JIFVisiteurListeCol extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Visiteur> lesVisiteurs;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeVisiteur;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFVisiteurListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Visiteur dans la collection
		lesVisiteurs = VisiteurDao.retournerCollectionDesVisiteurs();

		int nbLignes = lesVisiteurs.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][12] ;
		for(Visiteur unVisiteur : lesVisiteurs){
			data[i][0] = unVisiteur.getMATRICULE();
			data[i][1] = unVisiteur.getNOM();
			data[i][2] = unVisiteur.getPRENOM();
			data[i][3] = unVisiteur.getLOGIN();
			data[i][4] = unVisiteur.getMDP();
			data[i][5] = unVisiteur.getADRESSE();
			data[i][6] = unVisiteur.getUneLocalite().getCodePostal();
			data[i][7] = unVisiteur.getTelephone();
			data[i][8] = String.valueOf(unVisiteur.getPrime());
			data[i][9] = unVisiteur.getDATEENTREE();
			data[i][10] = unVisiteur.getCODEUNIT();
			data[i][11] = unVisiteur.getNOMUNIT();
			i++;
			}
		String[] columnNames = {"Matricule", "Nom","Prenom","Login","MDP","Adresse","Code postal","Telephone","Prime","Date entrée","Code unité","Nom unité"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(200, 400));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeVisiteur = new JTextField(20);
		JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Visiteur");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTcodeVisiteur);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Visiteur unVisiteur = VisiteurDao.rechercher(JTcodeVisiteur.getText());
   			if (unVisiteur!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFVisiteurFiche(unVisiteur));
   	   		}	
   			else {
   				JOptionPane.showMessageDialog(this, "Champs non remplis",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
   	   		}
   			
   		}	
	}
}
