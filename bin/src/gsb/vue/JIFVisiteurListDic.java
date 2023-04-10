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

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class JIFVisiteurListDic extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//private ArrayList<Visiteur> lesVisiteurs;
	private HashMap<String,Visiteur> diccoVisiteur;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeVisiteur;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFVisiteurListDic(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		//int nbLignes = lesMedecins.size();
		diccoVisiteur = VisiteurDao.retournerDictionnaireDesVisiteurs();
		int nbLignes= diccoVisiteur.size();
		System.out.println(nbLignes);
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][12] ;
		//for(Visiteur unVisiteur : lesVisiteurs){
		
		for (Map.Entry<String,Visiteur> uneEntree : diccoVisiteur.entrySet()){
			data[i][0] = uneEntree.getValue().getMATRICULE();
			data[i][1] = uneEntree.getValue().getNOM();
			data[i][2] = uneEntree.getValue().getPRENOM();
			data[i][3] = uneEntree.getValue().getLOGIN();
			data[i][4] = uneEntree.getValue().getMDP();
			data[i][5] = uneEntree.getValue().getADRESSE();
			data[i][6] = uneEntree.getValue().getUneLocalite().getCodePostal();
			data[i][7] = uneEntree.getValue().getTelephone();
			data[i][8] = String.valueOf(uneEntree.getValue().getPrime());
			data[i][9] = uneEntree.getValue().getDATEENTREE();
			data[i][10] = uneEntree.getValue().getCODEUNIT();
			data[i][11] = uneEntree.getValue().getNOMUNIT();
			
			i++;
			setTitle("Liste des visiteurs");
			}
		String[] columnNames = {"Matricule", "Nom","Prenom"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeVisiteur = new JTextField(20);
		JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Visiteur");
		JBafficherFiche.addActionListener(this); // source d'évenement
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
   			if (diccoVisiteur.containsKey(JTcodeVisiteur.getText())){
   				Visiteur unVisiteur = diccoVisiteur.get(JTcodeVisiteur.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFVisiteurFiche(unVisiteur));
   			}
   		}
   		if(source == table){
   			JTcodeVisiteur.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));			
   		}
   		else {
   			JOptionPane.showMessageDialog(this, "Champs non remplis",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
   		}
	}
}