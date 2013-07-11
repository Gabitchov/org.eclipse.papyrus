/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.regex;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 
 * Singleton helper class used to find pattern queries in strings
 * 
 */
public class PatternHelper {

	private static PatternHelper instance = null;

	private PatternHelper() {
		super();
	}

	/**
	 * Singleton
	 * 
	 * @return the helper
	 */
	public final static PatternHelper getInstance() {

		if(PatternHelper.instance == null) {
			synchronized(PatternHelper.class) {
				if(PatternHelper.instance == null) {
					PatternHelper.instance = new PatternHelper();
				}
			}
		}
		return PatternHelper.instance;
	}

	/**
	 * Create a pattern
	 * 
	 * @param query
	 *        the query text
	 * @param isCaseSensitive
	 *        if it is a case sensitive pattern
	 * @param isRegularExpression
	 *        if it i a regular expression pattern
	 * @return
	 *         the pattern corresponding to the query text and the parameters
	 * @throws PatternSyntaxException
	 */
	public Pattern createPattern(String query, boolean isCaseSensitive, boolean isRegularExpression) throws PatternSyntaxException {
		int options = Pattern.MULTILINE;

		if(!isRegularExpression) {
			//			query = ".*" + Pattern.quote(query); //$NON-NLS-1$
			query = Pattern.quote(query); //$NON-NLS-1$
		}

		if(!isCaseSensitive) {
			options |= Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
		}

		Pattern pattern = Pattern.compile(query, options);
		return pattern;

	}

	//	/**
	//	 * Check whether a string matches a certain pattern in a matcher
	//	 * 
	//	 * @param m
	//	 *        the matcher
	//	 * @param isRegularExpression
	//	 *        specify if it is a regular expression pattern
	//	 * @return
	//	 *         true if the text matches the pattern, else false
	//	 */
	//	public boolean evaluate(Matcher m, boolean isRegularExpression) {
	//
	//
	//		if(isRegularExpression) {
	//			return m.matches();
	//		} else {
	//			return m.lookingAt();
	//		}
	//	}

}
