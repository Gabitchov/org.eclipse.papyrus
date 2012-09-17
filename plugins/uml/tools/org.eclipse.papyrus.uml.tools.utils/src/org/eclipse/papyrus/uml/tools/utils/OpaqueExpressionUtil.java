/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;


/**
 * Util class for {@link OpaqueExpression}
 */
public class OpaqueExpressionUtil {

	/**
	 * Returns the body for an OpaqueExpression for the given language
	 * 
	 * @param opaqueExpression
	 *        the opaque expression to edit.
	 * @param language
	 *        the language in which the body is written
	 * @return the body for the given language or the empty string if the language was not found
	 */
	public static String getBodyForLanguage(org.eclipse.uml2.uml.OpaqueExpression opaqueExpression, String language) {
		String body = "";
		if(language == null) {
			if(!opaqueExpression.getBodies().isEmpty()) {
				body = opaqueExpression.getBodies().get(0);
			}
		} else {
			// retrieve the index of the given language in the opaque Expression
			int index = opaqueExpression.getLanguages().indexOf(language);
			if(index != -1) {
				// language found. return the corresponding body in the bodies list.
				// List should be synchronized, ie having the same size, but be sure...
				if(index < opaqueExpression.getBodies().size()) {
					body = opaqueExpression.getBodies().get(index);
				}
			}
		}
		return body;
	}

	/**
	 * sets the body for an OpaqueExpression for the given language.
	 * <p>
	 * If the language was already defined, it replaces the corresponding body. If the language was not already defined, it adds it to the list of
	 * languages and adds the corresponding body.
	 * <p>
	 * A utility method, {@link OpaqueExpression#checkAndCorrectLists(org.eclipse.uml2.uml.OpaqueExpression)} is used to correct the language and body
	 * lists.
	 * 
	 * @param opaqueExpression
	 *        the opaque expression to edit.
	 * @param language
	 *        the language in which the body is written
	 * @param body
	 *        the body to save
	 */
	public static void setBodyForLanguage(org.eclipse.uml2.uml.OpaqueExpression opaqueExpression, String language, String body) {
		// checks both lists by size
		checkAndCorrectLists(opaqueExpression);
		// checks if language exists, if not, creates one
		if(!opaqueExpression.getLanguages().contains(language)) {
			opaqueExpression.getLanguages().add(language);
			opaqueExpression.getBodies().add(body);
		} else {
			// retrieve the index of the given language in the opaque Expression
			int index = opaqueExpression.getLanguages().indexOf(language);
			// sets the body at the given index in the list of bodies.
			opaqueExpression.getBodies().set(index, body);
		}
	}

	/**
	 * Checks body and languages list of an opaque expression.
	 * <p>
	 * It returns <code>true</code> if both lists have the same size. It returns <code>false</code> if one of the list was bigger than the other one.
	 * In this latter case, one of the list was corrected, ie enough elements where added in the list
	 * 
	 * @param opaqueExpression
	 *        the opaque expression to check
	 * @return <code>true</code> if both lists already had the same size, <code>false</code> in
	 *         other cases.
	 */
	public static boolean checkAndCorrectLists(org.eclipse.uml2.uml.OpaqueExpression opaqueExpression) {
		// both lists, languages and bodies, should have the same size
		final int bodySize = opaqueExpression.getBodies().size();
		final int languageSize = opaqueExpression.getLanguages().size();
		// check both size
		// if equals, lists are supposed synchronized, it is ok
		// if less body than languages, add bodies
		// if more body, add enough languages
		if(bodySize == languageSize) {
			return true;
		} else {
			final int difference = languageSize - bodySize;
			if(difference > 0) {
				// more languages strings than body strings, add enough bodies
				for(int i = 0; i < difference; i++) {
					opaqueExpression.getBodies().add("");
				}
			} else {
				// more body strings than language strings, add enough languages
				for(int i = 0; i < (-difference); i++) {
					opaqueExpression.getLanguages().add("");
				}
			}
			// lists had to be modified, return false...
			return false;
		}
	}
}
