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
 * This class encapsulates an <code>org.eclipse.uml2.uml.OpaqueBehavior</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class OpaqueBehavior extends Behavior {

	/**
     * 
     */
	private org.eclipse.uml2.uml.OpaqueBehavior uml2OpaqueBehavior;

	/**
	 * 
	 * 
	 * @param opaqueBehavior
	 */
	public OpaqueBehavior(org.eclipse.uml2.uml.OpaqueBehavior opaqueBehavior) {
		super(opaqueBehavior);
		this.uml2OpaqueBehavior = opaqueBehavior;
	}

	/**
	 * Get the encapsulated <code>OpaqueBehavior</code>.
	 * 
	 * @return Returns the uml2OpaqueBehavior.
	 */
	public org.eclipse.uml2.uml.OpaqueBehavior getUml2OpaqueBehavior() {
		return uml2OpaqueBehavior;
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueBehavior</code>.
	 * 
	 * @return the collection of 'Body'
	 */
	public EList getBody() {
		return uml2OpaqueBehavior.getBodies();
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueBehavior</code> at the given index.
	 * 
	 * @param index
	 * 
	 * @return the value of 'Body'at the index i
	 */
	public String getBody(int index) {
		return (String) uml2OpaqueBehavior.getBodies().get(index);
	}

	/**
	 * Gets the value of the 'Body' attribute for the <code>OpaqueBehavior</code> for a given language.
	 * 
	 * @param language
	 * 
	 * @return the value of 'Body'at the index i
	 */
	public String getBody(String language) {
		int index = 0;
		String tmp = "";

		index = getBodyIndex(language);
		if ((index > -1) && (index < uml2OpaqueBehavior.getBodies().size())) {
			tmp = (String) uml2OpaqueBehavior.getBodies().get(index);
		}

		return tmp;
	}

	/**
	 * Returns the index of the body for a given langauge.
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
		Iterator it = uml2OpaqueBehavior.getLanguages().iterator();
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
     * 
     */
	/**
	 * Creates a Parameter.
	 * 
	 * @param operationParameter
	 * @param name
	 *            the name of the object
	 * 
	 * @return the created Parameter
	 */
	public org.eclipse.papyrus.umlutils.Parameter createParameter(String name, Parameter operationParameter) {
		org.eclipse.uml2.uml.Parameter uml2Parameter = (uml2OpaqueBehavior.createOwnedParameter(name, operationParameter.getType().getUml2Type()));
		uml2Parameter.setDirection(operationParameter.getUml2Parameter().getDirection());
		uml2Parameter.setEffect(operationParameter.getUml2Parameter().getEffect());

		return new org.eclipse.papyrus.umlutils.Parameter(uml2Parameter);
	}

	/**
	 * Sets the value of the 'Body' attribute for a given language.
	 * 
	 * @param value
	 *            the new value of the 'Body'
	 * @param language
	 *            the langauge of the body to set
	 */
	public void setBody(String value, String language) {
		// get the index of the given language
		int index = getBodyIndex(language);
		if (index == -1) {
			// this language does not exists, adds it to the end of the list
			uml2OpaqueBehavior.getLanguages().add(language);
			uml2OpaqueBehavior.getBodies().add(value);
		} else {
			// the language was found, change the value of the language
			uml2OpaqueBehavior.getBodies().set(index, value);
		}
	}

}
