package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteurService;
import gsb.utils.ValidationUtils;

public class JIFVisiteurAjout extends JIFVisiteur implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton Ajouter;
	private Visiteur unVisiteur;
	
	public JIFVisiteurAjout() {
		super();
		Ajouter = new JButton("Ajouter visiteurs");
		pBoutons.add(Ajouter);
		Ajouter.addActionListener(this);
		setTitle("Ajout des visiteurs");
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source =e.getSource();
		if (source == Ajouter) {
			if (JTMATRICULE.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le matricule dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTnom.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le nom  dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTprenom.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le prénom dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTLOGIN.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le login dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTMDP.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le mot de passe dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTADRESSE.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "L'adresse dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTcp.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le code postal dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTville.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "La ville dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTtelephone.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le téléphone dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTPrime.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "La prime dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTDATEENTREE.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "La date d'entrée dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTCODEUNIT.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le code de l'unité dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (JTNOMUNIT.getText().toString().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Le nom de l'unité dois être remplis",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (VisiteurDao.rechercher(JTMATRICULE.getText())!=null) {
				// clé primaire duppliquée
				JOptionPane.showMessageDialog(this, "Le matricule existe déjà dans la base de données",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (ValidationUtils.isTelephoneValide(JTtelephone.getText())) {
			    	// numéro de téléphone sous la forme XXXXXXXXXX ou XX XX XX XX XX ou XX-XX-XX-XX-XX ou XX.XX.XX.XX.XX
			    	JOptionPane.showMessageDialog(this, "Le téléphone doit contenir que des chiffres",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
			else if (ValidationUtils.isCodePostalValide (JTcp.getText())) {
			JOptionPane.showMessageDialog(this, "Le code postal doit contenir que des chiffres",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(ValidationUtils.isDateValide(JTDATEENTREE.getText())) {
				JOptionPane.showMessageDialog(this, " la date doit être de la forme yyyy-mm-dd",
	                    "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			
			int prime = Integer.parseInt(JTPrime.getText());
			Localite loc =new Localite(JTcp.getText(),JTville.getText());
			unVisiteur = new Visiteur(JTMATRICULE.getText(), JTnom.getText(), JTprenom.getText(), JTLOGIN.getText(), 
					JTMDP.getText(),JTADRESSE.getText(),loc,JTtelephone.getText(), prime,JTDATEENTREE.getText(),JTCODEUNIT.getText(),JTNOMUNIT.getText());
			VisiteurService.creer(unVisiteur);
			if (VisiteurService.creer(unVisiteur)==1) {
				JFrame ajout = new JFrame();
				JOptionPane.showMessageDialog(ajout,"Insertion réussis");
			}
		}
	}
}