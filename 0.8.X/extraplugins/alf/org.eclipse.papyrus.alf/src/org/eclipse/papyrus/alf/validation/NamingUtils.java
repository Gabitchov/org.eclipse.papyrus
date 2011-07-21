package org.eclipse.papyrus.alf.validation;

public class NamingUtils {
	
	
	/**
	 * Checks if a string represents a valid Java-name:
	 * - it starts with a letter or "_"
	 * - other characters are either letters, figures or "_"
	 * 
	 * @param name
	 * @return true if the name is Java-compliant, false otherwise
	 */
	public static boolean isJavaCompliant(String name) {
		if (name.length() == 0)
			return false ;
		int firstChar = 0 ;
		char[] dst = new char[name.length()] ;
		name.getChars(0, name.length(), dst, firstChar) ;
		if (dst[0] >= 'a' && dst[0] <= 'z')
			;
		else if (dst [0] >= 'A' && dst[0] <= 'Z')
			;
		else if (dst [0] == '_')
			;
		else
			return false ;
		for (int i = 1 ; i<dst.length ; i++) {
			if (dst[i] >= 'a' && dst[i] <= 'z')
				;
			else if (dst [i] >= 'A' && dst[i] <= 'Z')
				;
			else if (dst [i] >= '0' && dst[i] <= '9')
				;
			else if (dst [i] == '_')
				;
			else
				return false ;
		}
		return true ;
	}
	
}
