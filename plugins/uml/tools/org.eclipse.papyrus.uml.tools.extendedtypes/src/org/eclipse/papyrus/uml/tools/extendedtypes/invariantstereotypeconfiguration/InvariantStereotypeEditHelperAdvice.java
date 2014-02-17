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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantEditHelperAdvice;


/**
 * EditHelperAdvice for Stereotype application invariant
 */
public class InvariantStereotypeEditHelperAdvice extends AbstractEditHelperAdvice implements IInvariantEditHelperAdvice<InvariantStereotypeConfiguration> {

	private String stereotypeQualifiedName;

	/**
	 * 
	 */
	public InvariantStereotypeEditHelperAdvice() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantStereotypeConfiguration ruleConfiguration) {
		setStereotypeQualifiedName(ruleConfiguration.getStereotypeQualifiedName());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		// check for stereotype application. Possible in the request system ?!
		return super.approveRequest(request);
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
