package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;
import gsb.service.VisiteurService;
import gsb.utils.ValidationUtils;

public class JIFMedicamentAjout extends JIFMedicament implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton Ajouter;
	private Medicament unMedicament;
	private int result;
	
	public JIFMedicamentAjout() {
		super();
		Ajouter = new JButton("Ajouter");
		pBoutons.add(Ajouter);
		Ajouter.addActionListener(this);
		setTitle("Ajout d'un médicament");
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source =e.getSource();
		if (source == Ajouter) {
			if (JTMED_DEPOTLEGAL.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le dépot légal dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTMED_NOMCOMMERCIAL.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le nom commercial dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTMED_COMPOSITION.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "La composition dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTMED_EFFETS.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Les effets dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTMED_CONTREINDIC.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Les contre indications dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTMED_PrixEchantillon.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le Prix echantillon dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTFAM_CODE.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le Code Famille dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTFAM_LIBELLE.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le libelle de la famille dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (MedicamentDao.rechercher(JTMED_DEPOTLEGAL.getText())!=null) {
				// clé primaire duppliquée
				JOptionPane.showMessageDialog(this, "Le depot légal existe déjà dans la base de données",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			
			else {
				unMedicament = new Medicament(JTMED_DEPOTLEGAL.getText(), JTMED_NOMCOMMERCIAL.getText(), JTMED_COMPOSITION.getText(), JTMED_EFFETS.getText(), 
						JTMED_CONTREINDIC.getText(), Integer.parseInt(JTMED_PrixEchantillon.getText()),JTFAM_CODE.getText(), JTFAM_LIBELLE.getText());
				result = MedicamentService.creer(unMedicament);
				if (result ==1) {
					JFrame ajout = new JFrame();
					JOptionPane.showMessageDialog(ajout,"Insertion réussis");
				}
		}
		
		}
	}
}