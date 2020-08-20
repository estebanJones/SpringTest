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
}
