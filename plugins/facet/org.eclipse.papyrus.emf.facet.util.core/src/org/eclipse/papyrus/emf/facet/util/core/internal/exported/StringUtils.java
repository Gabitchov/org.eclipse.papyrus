/*******************************************************************************
 * Copyright (c) 2008, 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gabriel Barbier (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software)
 *    Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/

package org.eclipse.papyrus.emf.facet.util.core.internal.exported;


import org.eclipse.papyrus.emf.facet.util.core.internal.Messages;

import com.ibm.icu.lang.UCharacter;

/**
 * @author Gabriel Barbier
 * @since 0.2
 */
// Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.StringUtils
public final class StringUtils {
	public static final String ELLIPSIS = Messages.StringUtils_ellipsis;
	private static final int TRUNCATE_AFTER = 150;

	private StringUtils() {
		// prevent instantiation
	}

	public static String firstLetterToLowerCase(final String source) {
		String result;
		if (source.length() == 0) {
			result = source;
		} else if (source.length() == 1) {
			result = source.toLowerCase();
		} else {
			result = source.substring(0, 1).toLowerCase() + source.substring(1);
		}
		return result;
	}

	public static String firstLetterToUpperCase(final String source) {
		String result;
		if (source.length() == 0) {
			result = source;
		} else if (source.length() == 1) {
			result = source.toUpperCase();
		} else {
			result = source.substring(0, 1).toUpperCase() + source.substring(1);
		}
		return result;
	}

	/**
	 * Truncate the given String before the first newline or a maximum number of
	 * characters, whichever comes first. Adds an ellipsis ("...") if it was
	 * effectively truncated.
	 * 
	 * @param str
	 *            the string to truncate
	 * @return the part of the given string before the first newline
	 */
	public static String truncateBeforeNewline(final String str) {
		int endIndex = str.indexOf('\r');
		if (endIndex == -1) {
			endIndex = str.indexOf('\n');
		}
		if (endIndex != -1 && endIndex <= StringUtils.TRUNCATE_AFTER) {
			return str.substring(0, endIndex) + StringUtils.ELLIPSIS;
		}
		if (endIndex == -1) {
			endIndex = str.length();
		}

		if (endIndex > StringUtils.TRUNCATE_AFTER) {
			return str.substring(0, StringUtils.TRUNCATE_AFTER / 2) + StringUtils.ELLIPSIS
					+ str.substring(str.length() - StringUtils.TRUNCATE_AFTER / 2, endIndex);
		}
		return str;
	}

	/**
	 * Get a name suitable for a Java class from the given name. Capitalizes the
	 * first letter and each letter after a space, and removes spaces.
	 */
	public static String inferJavaClassName(final String name) {
		String upperName = StringUtils.firstLetterToUpperCase(name.trim());
		StringBuilder javaName = new StringBuilder();
		boolean space = false;
		for (int i = 0; i < upperName.length(); i++) {
			char c = upperName.charAt(i);
			if (c == ' ') {
				space = true;
			} else if (space) {
				javaName.append(UCharacter.toUpperCase(c));
				space = false;
			} else {
				javaName.append(c);
			}
		}
		return javaName.toString();
	}
}
