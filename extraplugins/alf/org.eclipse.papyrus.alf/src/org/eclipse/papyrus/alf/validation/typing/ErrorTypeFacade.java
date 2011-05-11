/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.alf.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ErrorTypeFacade extends TypeFacade {

	private String errorMessage = "" ;
	private EStructuralFeature structuralFeature ;
	private EObject errorSource ;
	
	@Override
	public String getLabel() {
		return errorMessage ;
	}
	
	public void setMessage(String message) {
		errorMessage = "" + message ;
	}

	public EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}

	public void setStructuralFeature(EStructuralFeature structuralFeature) {
		this.structuralFeature = structuralFeature ;
	}
	
	public EObject getErrorSource() {
		return errorSource;
	}
	
	public void setErrorSource(EObject errorSource) {
		this.errorSource = errorSource ;
	}
	
}
