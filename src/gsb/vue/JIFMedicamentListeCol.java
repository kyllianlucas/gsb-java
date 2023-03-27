package gsb.vue;

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


import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class JIFMedicamentListeCol extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Medicament> lesMedicaments;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedicament;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFMedicamentListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medicament dans la collection
		lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();

		int nbLignes = lesMedicaments.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][8] ;
		for(Medicament unMedicament : lesMedicaments){
			data[i][0] = unMedicament.getMED_DEPOTLEGAL();
			data[i][1] = unMedicament.getMED_NOMCOMMERCIAL();
			data[i][2] = unMedicament.getMED_COMPOSITION();
			data[i][3] = unMedicament.getMED_EFFETS();
			data[i][4] = unMedicament.getMED_CONTREINDIC();
			data[i][5] = String.valueOf(unMedicament.getMED_PrixEchantillon());
			data[i][6] = unMedicament.getFAM_CODE();
			data[i][7] = unMedicament.getFAM_LIBELLE();
			i++;
			}
		String[] columnNames = {"Depot Legal", "Nom Commercial","Composition","Effet","Contre indication","Prix Echantillon","Code famille","Libelle Famille"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedicament = new JTextField(20);
		JTcodeMedicament.setMaximumSize(JTcodeMedicament.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche médicament");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTcodeMedicament);
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
   			Medicament unMedicament = MedicamentDao.rechercher(JTcodeMedicament.getText());
   			if (unMedicament!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   			else {
   				JOptionPane.showMessageDialog(this, "Champs non remplis",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
	   		}
   		}	
	}
}