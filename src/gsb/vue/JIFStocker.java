
package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import gsb.modele.Stocker;




public class JIFStocker extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLqteStock;
	protected JLabel JLMATRICULE;
	protected JLabel JLMED_DEPOTLEGAL;
	
	protected JTextField JTqteStock;
	protected JTextField JTMATRICULE;
	protected JTextField JTMED_DEPOTLEGAL;
	
	
    public JIFStocker() {
    	 setSize(300,200);
    	 p = new JPanel();  // panneau principal de la fen�tre
         pBoutons = new JPanel();    // panneau supportant les boutons
         pTexte = new JPanel(new GridLayout(4,2));
    	
    	 
         JLMATRICULE = new JLabel("Matricule");
         JLMED_DEPOTLEGAL = new JLabel("D�pot l�gal");
         JLqteStock = new JLabel("Quantit�");
         
         JTqteStock = new JTextField(20);
         JTqteStock.setMaximumSize(JTqteStock.getPreferredSize());
         JTMATRICULE = new JTextField();
         JTMED_DEPOTLEGAL = new JTextField();
         
         
         
         pTexte.add(JLqteStock);
         pTexte.add(JTqteStock);
         pTexte.add(JLMATRICULE);
         pTexte.add(JTMATRICULE);
         pTexte.add(JLMED_DEPOTLEGAL);
         pTexte.add(JTMED_DEPOTLEGAL);
         
		
        // mise en forme de la fen�tre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Stocker unStock) 	
    {  // m�thode qui permet de remplir les zones de texte � partir des valeurs pass�es en param�tres
    	JTqteStock.setText(String.valueOf(unStock.getQteStock()));
    	JTMATRICULE.setText(unStock.getUnVisiteur().getMATRICULE());        
        JTMED_DEPOTLEGAL.setText(unStock.getUnMedicament().getMED_DEPOTLEGAL());
        
     }
     
      public void viderText() 	
    {  // m�thode qui permet de vider les zones de texte 
        JTqteStock.setText("");
    	JTMATRICULE.setText("");        
    	JTMED_DEPOTLEGAL.setText("");
        
    }


    
}
