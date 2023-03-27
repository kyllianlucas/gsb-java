package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class JIFMedicamentListDic extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//private ArrayList<Medicament> lesMedicaments;
	private HashMap<String,Medicament> diccoMedicament;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedicament;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFMedicamentListDic(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medicament dans la collection
		//lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();

		//int nbLignes = lesMedecins.size();
		diccoMedicament = MedicamentDao.retournerDictionnaireDesMedicaments();
		int nbLignes= diccoMedicament.size();
		
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][8] ;
		//for(Medicament unMedicament : lesMedicaments){
		
		for (Map.Entry<String,Medicament> uneEntree : diccoMedicament.entrySet()){
			data[i][0] = uneEntree.getValue().getMED_DEPOTLEGAL();
			data[i][1] = uneEntree.getValue().getMED_NOMCOMMERCIAL();
			data[i][2] = uneEntree.getValue().getMED_COMPOSITION();
			data[i][3] = uneEntree.getValue().getMED_EFFETS();
			data[i][4] = uneEntree.getValue().getMED_CONTREINDIC();
			data[i][5] = String.valueOf(uneEntree.getValue().getMED_PrixEchantillon());
			data[i][6] = uneEntree.getValue().getFAM_CODE();
			data[i][7] = uneEntree.getValue().getFAM_LIBELLE();
			
			
			i++;
			setTitle("Liste des médicaments");
			}
		String[] columnNames = {"Code", "Nom","Famille"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedicament = new JTextField(20);
		JTcodeMedicament.setMaximumSize(JTcodeMedicament.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche médicament");
		JBafficherFiche.addActionListener(this); // source d'évenement
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
   			if (diccoMedicament.containsKey(JTcodeMedicament.getText())){
   				Medicament unMedicament = diccoMedicament.get(JTcodeMedicament.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   		}
   		if(source == table){
   			JTcodeMedicament.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
   			
   		}
   		else {
   			JOptionPane.showMessageDialog(this, "Champs non remplis",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
  		}
	}
}