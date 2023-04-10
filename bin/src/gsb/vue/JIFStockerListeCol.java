package gsb.vue;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JInternalFrame;
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
public class JIFStockerListeCol extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Stocker> lesStocks;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeStock;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFStockerListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Stocker dans la collection
		lesStocks = StockerDao.retournerCollectionDesStocks();

		int nbLignes = lesStocks.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][3] ;
		for(Stocker unStock : lesStocks){
			data[i][0] = String.valueOf(unStock.getQteStock());
			data[i][1] = unStock.getUnVisiteur().getMATRICULE();
			data[i][2] = unStock.getUnMedicament().getMED_DEPOTLEGAL();
			i++;
			}
		String[] columnNames = {"Quantiter", "Matricule","Depot legal"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeStock = new JTextField(20);
		JTcodeStock.setMaximumSize(JTcodeStock.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Stock");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTcodeStock);
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
   			Stocker unStock = StockerDao.rechercher(JTcodeStock.getText());
   			if (unStock!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFStockerFiche(unStock));
   			}
   		}	
	}
}
