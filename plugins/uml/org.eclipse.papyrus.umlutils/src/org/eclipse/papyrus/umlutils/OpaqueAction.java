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
package org.eclipse.papyrus.umlutils;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.OpaqueAction</code><BR>
 * 
 * @author HD // TODO : modifier ensuite l'extention : extends Action au lieu de extends Element
 */
public class OpaqueAction extends Element {

	/**
     * 
     */
	private org.eclipse.uml2.uml.OpaqueAction uml2OpaqueAction;

	/**
	 * 
	 * 
	 * @param opaqueAction
	 */
	public OpaqueAction(org.eclipse.uml2.uml.OpaqueAction opaqueAction) {
		super(opaqueAction);
		this.uml2OpaqueAction = opaqueAction;
	}

	/**
	 * Get the encapsulated <code>OpaqueAction</code>.
	 * 
	 * @return Returns the uml2OpaqueAction.
	 */
	public org.eclipse.uml2.uml.OpaqueAction getUml2OpaqueAction() {
		return uml2OpaqueAction;
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueAction</code>.
	 * 
	 * @return the collection of 'Body'
	 */
	public EList getBody() {
		return uml2OpaqueAction.getBodies();
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueAction</code> at the given index.
	 * 
	 * @param index
	 * 
	 * @return the value of 'Body'at the index i
	 */
	public String getBody(int index) {
		return (String) uml2OpaqueAction.getBodies().get(index);
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueAction/code> for a given language.
	 * 
	 * @param language
	 * 
	 * @return the value of 'Body'at the index i
	 */
	public String getBody(String language) {
		int index = 0;
		String tmp = "";

		index = getBodyIndex(language);
		if ((index > -1) && (index < uml2OpaqueAction.getBodies().size())) {
			tmp = (String) uml2OpaqueAction.getBodies().get(index);
		}

		return tmp;
	}

	/**
	 * Returns the index of the body for a given language.
	 * 
	 * @param language
	 *            the language of the body to find
	 * 
	 * @return the index of the body in the list or -1 if not found
	 */
	public int getBodyIndex(String language) {
		int index = 0;
		boolean isFound = false;

		// test if the language exists
		Iterator it = uml2OpaqueAction.getLanguages().iterator();
		while (it.hasNext() && !isFound) {
			String lang = (String) it.next();
			if (lang.equalsIgnoreCase(language)) {
				isFound = true;
			} else {
				index++;
			}
		}
		// returns -1 if not found
		if (!isFound) {
			index = -1;
		}
		return index;
	}

	/**
	 * Sets the value of the 'Body' attribute for a given language.
	 * 
	 * @param value
	 *            the new value of the 'Body'
	 * @param language
	 *            the language of the body to set
	 */
	public void setBody(String value, String language) {
		// get the index of the given language
		int index = getBodyIndex(language);
		if (index == -1) {
			// this language does not exists, adds it to the end of the list
			uml2OpaqueAction.getLanguages().add(language);
			uml2OpaqueAction.getBodies().add(value);
		} else {
			// the language was found, change the value of the language
			uml2OpaqueAction.getBodies().set(index, value);
		}

	}
}
