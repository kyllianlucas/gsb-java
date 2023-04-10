package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medicament;



public class JIFMedicament extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JLabel JLMED_DEPOTLEGAL;
	protected JLabel JLMED_NOMCOMMERCIAL;
	protected JLabel JLMED_COMPOSITION;
	protected JLabel JLMED_EFFETS;
	protected JLabel JLMED_CONTREINDIC;
	protected JLabel JLMED_PrixEchantillon;
	protected JLabel JLFAM_CODE;
	protected JLabel JLFAM_LIBELLE;
	
	protected JTextField JTMED_DEPOTLEGAL;
	protected JTextField JTMED_NOMCOMMERCIAL;
	protected JTextField JTMED_COMPOSITION;
	protected JTextField JTMED_EFFETS;
	protected JTextField JTMED_CONTREINDIC;
	protected JTextField JTMED_PrixEchantillon;
	protected JTextField JTFAM_CODE;
	protected JTextField JTFAM_LIBELLE;

	
	
    public JIFMedicament() {
    	 setSize(300,200);
    	 p = new JPanel();  // panneau principal de la fenêtre
         pBoutons = new JPanel();    // panneau supportant les boutons
         pTexte = new JPanel(new GridLayout(9,2));
    	
    	 JLMED_DEPOTLEGAL = new JLabel("DEPOT LEGAL");
         JLMED_NOMCOMMERCIAL = new JLabel("NOM COMMERCIAL");
         JLMED_COMPOSITION = new JLabel("COMPOSITION");
         JLMED_EFFETS = new JLabel("EFFETS");
         JLMED_CONTREINDIC = new JLabel("CONTREINDIC");
         JLMED_PrixEchantillon = new JLabel("Prix");
         JLFAM_CODE = new JLabel("Code Famille");
         JLFAM_LIBELLE = new JLabel("Libelle Famille");
         
         
         JTMED_DEPOTLEGAL = new JTextField(20);
         JTMED_DEPOTLEGAL.setMaximumSize(JTMED_DEPOTLEGAL.getPreferredSize());
         JTMED_NOMCOMMERCIAL = new JTextField();
         JTMED_COMPOSITION = new JTextField();
         JTMED_EFFETS = new JTextField();    
         JTMED_CONTREINDIC = new JTextField();
         JTMED_PrixEchantillon = new JTextField();
         JTFAM_CODE = new JTextField();
         JTFAM_LIBELLE = new JTextField();
        
         pTexte.add(JLMED_DEPOTLEGAL);
         pTexte.add(JTMED_DEPOTLEGAL);
         pTexte.add(JLMED_NOMCOMMERCIAL);
         pTexte.add(JTMED_NOMCOMMERCIAL);
         pTexte.add(JLMED_COMPOSITION);
         pTexte.add(JTMED_COMPOSITION);
         pTexte.add(JLMED_EFFETS);
         pTexte.add(JTMED_EFFETS);
         pTexte.add(JLMED_CONTREINDIC);
         pTexte.add(JTMED_CONTREINDIC);
         pTexte.add(JLMED_PrixEchantillon);
         pTexte.add(JTMED_PrixEchantillon);
         pTexte.add(JLFAM_CODE);
         pTexte.add(JTFAM_CODE);
         pTexte.add(JLFAM_LIBELLE);
         pTexte.add(JTFAM_LIBELLE);
         
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medicament unMedicament) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTMED_DEPOTLEGAL.setText(unMedicament.getMED_DEPOTLEGAL());        
        JTMED_NOMCOMMERCIAL.setText(unMedicament.getMED_NOMCOMMERCIAL());
        JTMED_COMPOSITION.setText(unMedicament.getMED_COMPOSITION());
        JTMED_EFFETS.setText(unMedicament.getMED_EFFETS());    
        JTMED_CONTREINDIC.setText(unMedicament.getMED_CONTREINDIC());
        JTMED_PrixEchantillon.setText(Integer.toString(unMedicament.getMED_PrixEchantillon()));
        JTFAM_CODE.setText(unMedicament.getFAM_CODE());
        JTFAM_LIBELLE.setText(unMedicament.getFAM_LIBELLE());
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTMED_DEPOTLEGAL.setText("");        
        JTMED_NOMCOMMERCIAL.setText("");
        JTMED_COMPOSITION.setText("");
        JTMED_EFFETS.setText(""); 
        JTMED_CONTREINDIC.setText("");
        JTMED_PrixEchantillon.setText("");
        JTFAM_CODE.setText("");
        JTFAM_LIBELLE.setText("");
    }


    
}
