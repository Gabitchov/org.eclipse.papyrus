/*****************************************************************************
 * Copyright (c) 2008-2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

/**
 * A library of static helpers for string-related operations
 */
public class StringHelper {

	/**
	 * Compares two strings. Two Strings are equal if they are both null,
	 * or if s1.equals(s2)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equals(String s1, String s2) {
		if(s1 == s2) {
			return true;
		}

		if(s1 == null) {
			return false;
		}

		return s1.equals(s2);
	}

	/**
	 * Converts a camelCase name to a human-readable Label
	 * 
	 * Example: aUMLElement -> A UML element
	 * 
	 * @param camelCaseName
	 * @return
	 *         A formatted version of the given variable name
	 */
	public static String camelCaseToLabel(String camelCaseName) {
		//"CamelCase" to "Natural case"
		String formattedValue = camelCaseName;

		//replace fooBar by foo Bar
		formattedValue = formattedValue.replaceAll("([a-z])([A-Z])", "$1 $2"); //$NON-NLS-1$ //$NON-NLS-2$

		//replace FOOAndBar by FOO And Bar
		formattedValue = formattedValue.replaceAll("([A-Z]+)([A-Z])([a-z])", "$1 $2$3"); //$NON-NLS-1$ //$NON-NLS-2$

		//Capitalize the first word and lower the other ones : foo Bar -> Foo bar
		//Keep the upper case for acronyms FOO Bar -> FOO bar
		String[] words = formattedValue.split("\\s+"); //$NON-NLS-1$
		formattedValue = firstToUpper(words[0]);
		for(int i = 1; i < words.length; i++) {
			formattedValue += " "; //$NON-NLS-1$
			if(words[i].matches("^[A-Z]{2,}")) { //$NON-NLS-1$
				formattedValue += words[i];
			} else {
				formattedValue += firstToLower(words[i]);
			}
		}

		//Activator.log.debug("\"" + formattedValue + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		return formattedValue;
	}

	/**
	 * @param source
	 * @return
	 *         the given String with the first letter capitalized
	 */
	public static String firstToUpper(String source) {
		if(source.length() == 0) {
			return source;
		}
		return source.substring(0, 1).toUpperCase() + source.substring(1);
	}

	/**
	 * @param source
	 * @return
	 *         the given String with the first letter lowered
	 */
	public static String firstToLower(String source) {
		if(source.length() == 0) {
			return source;
		}
		return source.substring(0, 1).toLowerCase() + source.substring(1);
	}

	/**
	 * Returns the same string, except for "null" which is converted to the empty string
	 * 
	 * @param str
	 * @return
	 */
	public static String trimToEmpty(String str) {
		return str == null ? "" : str; //$NON-NLS-1$
	}


	/*
	 * 
	 * The following methods have been copied from UML2Util (org.eclipse.uml2.common.util/UML2Util)
	 */


	/**
	 * Obtains a valid Java identifier based on the specified name.
	 * 
	 * @param name
	 *        The name from which to obtain a valid identifier.
	 * @return A valid (Java) identifier.
	 */
	public static String toJavaIdentifier(String label) {
		return getValidJavaIdentifier(label, new StringBuffer()).toString();
	}

	/**
	 * Appends a valid Java identifier based on the specified name to the
	 * specified buffer.
	 * 
	 * @param name
	 *        The name from which to obtain the valid identifier.
	 * @param validJavaIdentifier
	 *        The buffer to which to append the valid identifier.
	 * @return The buffer.
	 */
	protected static StringBuffer getValidJavaIdentifier(String name, StringBuffer validJavaIdentifier) {

		if(isEmpty(name)) {
			validJavaIdentifier.append('_');
		} else {
			char char_0 = name.charAt(0);

			if(Character.isJavaIdentifierStart(char_0)) {
				validJavaIdentifier.append(char_0);
			} else {
				validJavaIdentifier.append('_');

				if(Character.isJavaIdentifierPart(char_0)) {
					validJavaIdentifier.append(char_0);
				}
			}

			for(int i = 1; i < name.length(); i++) {
				char char_i = name.charAt(i);

				if(Character.isJavaIdentifierPart(char_i)) {
					validJavaIdentifier.append(char_i);
				}
			}
		}

		return validJavaIdentifier;
	}

	/**
	 * Determines whether the specified string is empty, i.e. is <code>null</code> or has a length of zero.
	 * 
	 * @param string
	 *        The string in question.
	 * @return <code>true</code> if the string is empty; <code>false</code> otherwise.
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}
}
