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
package org.eclipse.papyrus.uml.alf.validation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class TypeInferenceException extends Exception {

	protected String errorMessage = "" ;
	public String getErrorMessage() {
		return errorMessage;
	}

	protected EObject errorSource = null ;
	public EObject getErrorSource() {
		return errorSource;
	}

	protected EStructuralFeature errorFeature = null ;
	public EStructuralFeature getErrorFeature() {
		return errorFeature;
	}

	public TypeInferenceException(TypeExpression typeOfArgument) {
		// TODO Auto-generated constructor stub
		if (typeOfArgument != null && typeOfArgument.getTypeFacade() != null) {
			if (typeOfArgument.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade e = (ErrorTypeFacade)typeOfArgument.getTypeFacade() ;
				this.errorMessage += e.getLabel() ;
				this.errorSource = e.getErrorSource() ;
				this.errorFeature = e.getStructuralFeature() ;
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -152485940032266338L;

	
}
