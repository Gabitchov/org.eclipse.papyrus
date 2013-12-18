/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.uml2.uml.Element;


/**
 * Matcher for UML elements that should be stereotypes
 */
public class StereotypedElementMatcher implements IElementMatcher {

	private String stereotypedQualifiedName;

	/**
	 * @param stereotypedQualifiedName
	 */
	public StereotypedElementMatcher(String stereotypedQualifiedName) {
		this.setStereotypedQualifiedName(stereotypedQualifiedName);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		if(!(eObject instanceof Element)) {
			return false;	
		}
		
		return ((Element)eObject).getAppliedStereotype(getStereotypedQualifiedName()) != null;
		
	}

	/**
	 * @return the stereotypedQualifiedName
	 */
	public String getStereotypedQualifiedName() {
		return stereotypedQualifiedName;
	}

	/**
	 * @param stereotypedQualifiedName the stereotypedQualifiedName to set
	 */
	public void setStereotypedQualifiedName(String stereotypedQualifiedName) {
		this.stereotypedQualifiedName = stereotypedQualifiedName;
	}
}
