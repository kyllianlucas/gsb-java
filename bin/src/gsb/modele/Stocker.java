package gsb.modele;


public class Stocker {
	
	protected int qteStock;
	protected Visiteur unVisiteur;
	protected Medicament unMedicament;
	
	public Stocker(Visiteur MATRICULE , Medicament unMedicament,int qteStockVisiteur) {
		this.unVisiteur= unVisiteur;
		this.unMedicament= unMedicament;
		this.qteStock= qteStock;
		
		
	}
	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	public Medicament getUnMedicament() {
		return unMedicament;
	}

	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	
	
	
}