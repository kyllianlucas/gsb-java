package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {
	public static Stocker rechercher(String codeMedicament){
		Stocker unStock = null;
		Medicament unMedicament= null;
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from Stocker");
		try {
			if (reqSelection.next()) {
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(1));
				unMedicament = MedicamentDao.rechercher(reqSelection.getString(2));
				unStock = new Stocker( unVisiteur,unMedicament,reqSelection.getInt(3));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select MED_DEPOTLEGAL from Stocker");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBdd();
		return unStock;
	}
	
	public static ArrayList<Stocker> retournerCollectionDesStocks(){
		ArrayList<Stocker> collectionDesStocks = new ArrayList<Stocker>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select QTESTOCK from Stocker");
		try{
		while (reqSelection.next()) {
			String codeStock = reqSelection.getString(1);
			collectionDesStocks.add(StockerDao.rechercher(codeStock));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesStocks()");
		}
		return collectionDesStocks;
	}
	public static HashMap<String,Stocker> retournerDictionnaireDesStocks(){
		HashMap<String, Stocker> diccoDesStocks = new HashMap<String, Stocker>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select QTESTOCK from STOCKER");
		try{
		while (reqSelection.next()) {
			String codeStock = reqSelection.getString(1);
		    diccoDesStocks.put(codeStock,StockerDao.rechercher(codeStock));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesStocks()");
		}
		return diccoDesStocks;
	}

	public static int creer(Stocker unStock){
		String requeteInsertion;
		int result = 0;
		int qteStock = unStock.getQteStock();
		Medicament unMedicament =  unStock.getUnMedicament();
		Visiteur unVisiteur =unStock.getUnVisiteur();
		requeteInsertion = "insert into STOCKER values("+unVisiteur.getMATRICULE()+",'"+unMedicament.getMED_DEPOTLEGAL()+"','"+qteStock+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e){
			System.out.println("echec insertion : "+requeteInsertion);
		}
		ConnexionMySql.fermerConnexionBdd();	
		return result;
}
}

