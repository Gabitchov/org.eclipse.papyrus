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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantElementMatcher;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


/**
 * @author RS211865
 */
public class InvariantStereotypeElementMatcher implements IInvariantElementMatcher<InvariantStereotypeConfiguration> {

	private String stereotypeQualifiedName;
	
	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		
		if(!(eObject instanceof Element)) {
			return false;
		}
		
		Stereotype appliedStereotype = ((Element)eObject).getAppliedStereotype(getStereotypeQualifiedName());
		return appliedStereotype !=null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantStereotypeConfiguration ruleConfiguration) {
		setStereotypeQualifiedName(ruleConfiguration.getStereotypeQualifiedName());
	}
	
	/**
	 * @return the stereotypeQualifiedName
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}

	/**
	 * @param stereotypeQualifiedName the stereotypeQualifiedName to set
	 */
	public void setStereotypeQualifiedName(String stereotypeQualifiedName) {
		this.stereotypeQualifiedName = stereotypeQualifiedName;
	}
}
