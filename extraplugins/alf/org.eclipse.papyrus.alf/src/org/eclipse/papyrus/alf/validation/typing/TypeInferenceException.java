package org.eclipse.papyrus.alf.validation.typing;

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
