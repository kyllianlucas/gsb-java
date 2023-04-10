package gsb.vue;



import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * @author Isabelle
 * 17 nov. 2014
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFVisiteurCons extends JIFVisiteur  implements ActionListener {
	
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private JButton premier;
    private JButton suivant;
    private JButton precedent; 
    private JButton dernier; 
    private ArrayList<Visiteur> lesVisiteurs;
	private int indiceEnCours;
        
    public JIFVisiteurCons() {
        super();
        premier = new JButton("Premier");
        pBoutons.add(premier);
        suivant = new JButton("Suivant");
        pBoutons.add(suivant);
        precedent = new JButton("Precedent");
        pBoutons.add(precedent);
        dernier = new JButton("Dernier");
        pBoutons.add(dernier);
        // d�claration des sources d'�v�nements
        premier.addActionListener(this);
        suivant.addActionListener(this);
        precedent.addActionListener(this);
        dernier.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Consultation donn�es Visiteur");
        
        // r�cup�ration des donn�es Medecin dans la collection
        lesVisiteurs = VisiteurDao.retournerCollectionDesVisiteurs();
        indiceEnCours = 0;
        
        if (lesVisiteurs.size()!=0){ // si collection non vide, affichage des donn�es du premier Medecin
        	Visiteur leVisiteur = lesVisiteurs.get(0);
	    	remplirText(leVisiteur);
	    	}
        
        // ajout d'un �couteur d'�v�nement pour la fermeture de la fen�tre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {
                          //le code que tu veux ex�cuter � la fermeture de la JInternalFrame
            }
        });
    }
	
    public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
   		if (source == premier){
				indiceEnCours = 0;
				Visiteur leVisiteur = lesVisiteurs.get(indiceEnCours);
		    	remplirText(leVisiteur);				}
		 else if (source == dernier){
				indiceEnCours = lesVisiteurs.size() - 1;
				Visiteur leVisiteur = lesVisiteurs.get(indiceEnCours);
		    	remplirText(leVisiteur);
				}
		 else if (source == precedent){
				if (indiceEnCours > 0) indiceEnCours = indiceEnCours - 1;
				Visiteur leVisiteur = lesVisiteurs.get(indiceEnCours);
		    	remplirText(leVisiteur);				}
		 else if (source == suivant){
				if (indiceEnCours < (lesVisiteurs.size() - 1)) indiceEnCours = indiceEnCours + 1;
				Visiteur leVisiteur = lesVisiteurs.get(indiceEnCours);
		    	remplirText(leVisiteur);		    	}
 } // fin actionPerformed

}
