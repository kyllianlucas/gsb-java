package gsb.vue;

import gsb.modele.Stocker;

/**
 * @author Isabelle
 * 2 mars 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFStockerFiche extends JIFStocker {

	private static final long serialVersionUID = 1L;

	public JIFStockerFiche(Stocker unStock) {
		super();
		this.remplirText(unStock);

	}
	

}
