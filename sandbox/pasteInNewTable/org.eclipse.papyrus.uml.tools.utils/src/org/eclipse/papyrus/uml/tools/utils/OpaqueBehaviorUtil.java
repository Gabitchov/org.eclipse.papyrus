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

import java.util.Iterator;

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.OpaqueBehavior</code><BR>
 */
public class OpaqueBehaviorUtil {

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueBehavior</code> at the given
	 * index.
	 * 
	 * @param index
	 * 
	 * @return the value of 'Body'at the index i
	 */
	// @unused
	public static String getBody(OpaqueBehavior behavior, int index) {
		return behavior.getBodies().get(index);
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueBehavior</code> for a given
	 * language.
	 * 
	 * @param language
	 *        the language in which the body is written
	 * @return the value of 'Body' at the index i
	 */
	// @unused
	public static String getBody(OpaqueBehavior behavior, String language) {
		int index = 0;
		String tmp = "";

		index = getBodyIndex(behavior, language);
		if((index > -1) && (index < behavior.getBodies().size())) {
			tmp = behavior.getBodies().get(index);
		}

		return tmp;
	}

	/**
	 * Returns the index of the body for a given langauge.
	 * 
	 * @param language
	 *        the language of the body to find
	 * @return the index of the body in the list or -1 if not found
	 */
	public static int getBodyIndex(OpaqueBehavior behavior, String language) {
		int index = 0;
		boolean isFound = false;

		// test if the language exists
		Iterator<String> it = behavior.getLanguages().iterator();
		while(it.hasNext() && !isFound) {
			String lang = it.next();
			if(lang.equalsIgnoreCase(language)) {
				isFound = true;
			} else {
				index++;
			}
		}
		// returns -1 if not found
		if(!isFound) {
			index = -1;
		}
		return index;
	}

	/**
	 * Sets the value of the 'Body' attribute for a given language.
	 * 
	 * @param value
	 *        the new value of the 'Body'
	 * @param language
	 *        the langauge of the body to set
	 */
	// @unused
	public static void setBody(OpaqueBehavior behavior, String value, String language) {
		// get the index of the given language
		int index = getBodyIndex(behavior, language);
		if(index == -1) {
			// this language does not exists, adds it to the end of the list
			behavior.getLanguages().add(language);
			behavior.getBodies().add(value);
		} else {
			// the language was found, change the value of the language
			behavior.getBodies().set(index, value);
		}
	}

}
