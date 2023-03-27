package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

public class JIFStockerListDic extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//private ArrayList<Stocker> lesStocks;
	private HashMap<String,Stocker> diccoStocker;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeStocker;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFStockerListDic(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		//int nbLignes = lesMedecins.size();
		diccoStocker = StockerDao.retournerDictionnaireDesStocks();
		int nbLignes= diccoStocker.size();
		
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][3] ;
		//for(Stocker unStock : lesStocks){
		
		for (Map.Entry<String,Stocker> uneEntree : diccoStocker.entrySet()){
			data[i][0] = uneEntree.getValue().getUnVisiteur().getMATRICULE();
			data[i][1] = uneEntree.getValue().getUnMedicament().getMED_DEPOTLEGAL();
			data[i][2] = String.valueOf(uneEntree.getValue().getQteStock());
			i++;
			}
		pSaisie = new JPanel();
		JTcodeStocker = new JTextField(20);
		JTcodeStocker.setMaximumSize(JTcodeStocker.getPreferredSize());
		// source d'évenement
		pSaisie.add(JTcodeStocker);
		p.add(pSaisie);
		String[] columnNames = {"Code", "Nom","stock",};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		
		
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
   			if (diccoStocker.containsKey(JTcodeStocker.getText())){
   				Stocker unStock = diccoStocker.get(JTcodeStocker.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFStockerFiche(unStock));
   			}
   		}
   		if(source == table){
   			JTcodeStocker.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
   			
   		}
	}
}