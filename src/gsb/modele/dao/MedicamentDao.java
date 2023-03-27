
package gsb.modele.dao;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import gsb.modele.Medicament;




/**
 * @author Isabelle
 * 22 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedicamentDao {
	
	public static Medicament rechercher(String codeMedicament){
		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL='"+codeMedicament+"'");
		try {
			if (reqSelection.next()) {

				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getInt(6),reqSelection.getString(7), reqSelection.getString(8));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDICAMENT where MED_DEPOTLEGAL='"+codeMedicament+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBdd();
		return unMedicament;
	}
	
	public static ArrayList<Medicament> retournerCollectionDesMedicaments(){
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
		    collectionDesMedicaments.add(MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}
	
	public static HashMap<String,Medicament> retournerDictionnaireDesMedicaments(){
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
		    diccoDesMedicaments.put(codeMedicament,MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedicaments;
	}

		public static int creer(Medicament unMedicament){
		String requeteInsertion;
		int result = 0;
		String MED_DEPOTLEGAL =unMedicament.getMED_DEPOTLEGAL();
		String MED_NOMCOMMERCIAL = unMedicament.getMED_NOMCOMMERCIAL();
		String MED_COMPOSITION = unMedicament.getMED_COMPOSITION();
		String MED_EFFETS =  unMedicament.getMED_EFFETS();
		String MED_CONTREINDIC =unMedicament.getMED_CONTREINDIC();
		double MED_PrixEchantillion = unMedicament.getMED_PrixEchantillon();
		String FAM_CODE = unMedicament.getFAM_CODE();
		String FAM_LIBELLE = unMedicament.getFAM_LIBELLE();
		requeteInsertion = "insert into MEDICAMENT values('"+MED_DEPOTLEGAL+"','"+MED_NOMCOMMERCIAL+"','"+MED_COMPOSITION+"','"+MED_EFFETS+"','"+MED_CONTREINDIC+"','"+MED_PrixEchantillion+"','"+FAM_CODE+"','"+FAM_LIBELLE+"')";
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