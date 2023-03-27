/*
 * Cr�� le 29 oct. 2014
 *
 */
package gsb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Isabelle
 * 29 oct. 2014
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class ValidationUtils {

    private ValidationUtils() {

    }

    public static boolean isEmailValide(String email) {
    	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
    	Matcher m = p.matcher(email.toUpperCase());
    	return m.matches();
    }

    public static boolean isTelephoneValide(String telephone) {
    	// num�ro de t�l�phone sous la forme XXXXXXXXXX ou XX XX XX XX XX ou XX-XX-XX-XX-XX ou XX.XX.XX.XX.XX
    	Pattern p = Pattern.compile("^0([1-9]{10})$");
    	Matcher m = p.matcher(telephone.toUpperCase());
    	return m.matches();
    }
    
    public static boolean isCodePostalValide(String codePostal) {
    	Pattern p = Pattern.compile("^([0-9]{5})$");
    	Matcher m = p.matcher(codePostal.toUpperCase());
    	return m.matches();
    }
    
    public static boolean isDateValide(String uneDate) {
    	boolean resultat = false;
    	 try {
    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		 sdf.setLenient(false);
    		 sdf.parse(uneDate);
    		 resultat = true;
    		 } catch (Exception e) {
    			 resultat = false;
    		 }
    	return resultat;
    }
    
    public static boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
    
        	
    }
    

