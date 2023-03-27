package gsb.vue;

import gsb.modele.Stocker;

/**
 * @author Isabelle
 * 2 mars 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class JIFStockerFiche extends JIFStocker {

	private static final long serialVersionUID = 1L;

	public JIFStockerFiche(Stocker unStock) {
		super();
		this.remplirText(unStock);

	}
	

}
