package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.service.MedicamentService;
import gsb.service.StockerService;

public class JIFStockerAjout extends JIFStocker implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton Ajouter;
	private Stocker unStock;
	private int result;
	
	public JIFStockerAjout() {
		super();
		Ajouter = new JButton("Ajouter");
		pBoutons.add(Ajouter);
		Ajouter.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source =e.getSource();
		if (source == Ajouter) {
			int quantite = Integer.parseInt(JTqteStock.getText());
			unStock = new Stocker(JTMATRICULE.getText(),JTMED_DEPOTLEGAL.getText(),quantite);
			result = StockerService.creer(unStock);
		}
	}
}