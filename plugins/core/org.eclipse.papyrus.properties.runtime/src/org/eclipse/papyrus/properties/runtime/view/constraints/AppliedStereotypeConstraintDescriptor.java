/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.view.constraints;

import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Descriptor for constraints based on stereoype application
 */
public class AppliedStereotypeConstraintDescriptor implements IConstraintDescriptor {

	/** list of stereotype qualified names to be applied */
	private final List<String> stereotypeQualifiedNames;

	/**
	 * Creates a new AppliedStereotypeConstraintDescriptor.
	 * 
	 * @param stereotypeQualifiedNames
	 *        list of stereotype qualified names to be applied
	 */
	public AppliedStereotypeConstraintDescriptor(List<String> stereotypeQualifiedNames) {
		this.stereotypeQualifiedNames = stereotypeQualifiedNames;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object objectToTest) {
		// object should be a UML element 
		if(objectToTest instanceof Element) {
			Element elementToTest = (Element)objectToTest;

			// each stereotype in the list should be present
			for(String stQualifiedName : getStereotypeQualifiedNames()) {
				Stereotype st = elementToTest.getAppliedStereotype(stQualifiedName);
				if(st == null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Returns the list of stereotype Qualified Names
	 * 
	 * @return the list of stereotype Qualified Names
	 */
	public List<String> getStereotypeQualifiedNames() {
		return stereotypeQualifiedNames;
	}

}
