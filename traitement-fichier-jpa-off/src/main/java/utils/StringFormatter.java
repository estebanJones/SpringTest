package utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringFormatter {
	/**
	 * Enleve les accents d'une string
	 * @param String s
	 * @return String
	 */
	public static String sansAccent(String s) {
        String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(strTemp).replaceAll("");
	} 
	
	/**
	 * Supprime les parenthèses
	 * @param s
	 * @return
	 */
	public static String supprimerParentheses(String s) {
		return s.replaceAll("\\)", "")
				.replaceAll("\\(", "")
				.trim()
				.toLowerCase();
	}
	
	/**
	 * Supprime les caractères spéciaux
	 * @param s
	 * @return
	 */
	public static String supprimerSpecialChars(String s) {
		return s.replaceAll("_", "") 
				.replaceAll("\\*", "")
				 .replaceAll("\\\\", "")
				 .replaceAll("\\'", "")
				 .trim()
				 .toLowerCase();
	}
	
	/**
	 * Supprime les crochets
	 * @param s
	 * @return
	 */
	public static String supprimerCrochet(String s) {
		return s.replaceAll("\\[", "").trim().toLowerCase();
	}
	
	/**
	 * Supprime les points d'interrogation
	 * @param s
	 * @return
	 */
	public static String supprimerPointInterrogation(String s) {
		return s .replaceAll("\\?", "").trim().toLowerCase();
	}
	
	public static String supprimePointFinal(String s) {
		if((char)s.charAt(s.length() - 1) == '.') {
			s = s.subSequence(0, s.length() - 1).toString();
		}
		return s;
	}
}
