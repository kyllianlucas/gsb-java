
package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import gsb.modele.Visiteur;



public class JIFVisiteur extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLMATRICULE;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLLOGIN;
	protected JLabel JLMDP;
	protected JLabel JLADRESSE;
	protected JLabel JLcp;
    protected JLabel JLville;
    protected JLabel JLtelephone;
    protected JLabel JLPrime;
    protected JLabel JLDATEENTREE;
    protected JLabel JLCODEUNIT;
    protected JLabel JLNOMUNIT;
    
	protected JTextField JTMATRICULE;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTLOGIN;
	protected JTextField JTMDP;
	protected JTextField JTADRESSE;
	protected JTextField JTcp;
    protected JTextField JTville;
    protected JTextField JTtelephone;
    protected JTextField JTPrime;
    protected JTextField JTDATEENTREE;
    protected JTextField JTCODEUNIT;
    protected JTextField JTNOMUNIT;
	
    public JIFVisiteur() {
    	 setSize(300,200);
    	 p = new JPanel();  // panneau principal de la fenêtre
         pBoutons = new JPanel();    // panneau supportant les boutons
         pTexte = new JPanel(new GridLayout(13,1));
    	
    	 JLMATRICULE = new JLabel("Matricule");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
         JLLOGIN = new JLabel("Login");
         JLMDP = new JLabel("Mot De Passe");
         JLADRESSE = new JLabel("Adresse rue");
         JLcp = new JLabel("Code postal");
         JLville = new JLabel("Ville");
         JLtelephone = new JLabel("Téléphone");
         JLPrime = new JLabel("Prime");
         JLDATEENTREE = new JLabel("Date entrée");
         JLCODEUNIT = new JLabel("Code unité");
         JLNOMUNIT = new JLabel("Nom unité");
         
         JTMATRICULE = new JTextField(20);
         JTMATRICULE.setMaximumSize(JTMATRICULE.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTLOGIN = new JTextField();    
         JTMDP = new JPasswordField();
         JTADRESSE = new JTextField();
         JTcp = new JTextField();
         JTville = new JTextField();
         JTtelephone = new JTextField();
         JTPrime = new JTextField();
         JTDATEENTREE = new JTextField();
         JTCODEUNIT = new JTextField();
         JTNOMUNIT = new JTextField();
         
         pTexte.add(JLMATRICULE);
         pTexte.add(JTMATRICULE);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLLOGIN);
         pTexte.add(JTLOGIN);
         pTexte.add(JLMDP);
         pTexte.add(JTMDP);
         pTexte.add(JLADRESSE);
         pTexte.add(JTADRESSE);
         pTexte.add(JLcp);
         pTexte.add(JTcp);
         pTexte.add(JLville);
         pTexte.add(JTville);
         pTexte.add(JLtelephone);
         pTexte.add(JTtelephone);
         pTexte.add(JLPrime);
         pTexte.add(JTPrime);
         pTexte.add(JLDATEENTREE);
         pTexte.add(JTDATEENTREE);
         pTexte.add(JLCODEUNIT);
         pTexte.add(JTCODEUNIT);
         pTexte.add(JLNOMUNIT);
         pTexte.add(JTNOMUNIT);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Visiteur unVisiteur) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTMATRICULE.setText(unVisiteur.getMATRICULE());        
        JTnom.setText(unVisiteur.getNOM());
        JTprenom.setText(unVisiteur.getPRENOM());
        JTLOGIN.setText(unVisiteur.getLOGIN());
        JTMDP.setText(unVisiteur.getMDP());
        JTcp.setText(unVisiteur.getUneLocalite().getCodePostal());
        JTville.setText(unVisiteur.getUneLocalite().getVille());
        JTtelephone.setText(unVisiteur.getTelephone());
        JTPrime.setText(Integer.toString(unVisiteur.getPrime()));
        JTDATEENTREE.setText(unVisiteur.getDATEENTREE());
        JTCODEUNIT.setText(unVisiteur.getCODEUNIT());
        JTNOMUNIT.setText(unVisiteur.getNOMUNIT());
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTMATRICULE.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTLOGIN.setText("");   
        JTMDP.setText("");
        JTcp.setText("");
        JTville.setText("");
        JTtelephone.setText("");
        JTPrime.setText("");
        JTDATEENTREE.setText("");
        JTCODEUNIT.setText("");
        JTNOMUNIT.setText("");
    }


    
}
