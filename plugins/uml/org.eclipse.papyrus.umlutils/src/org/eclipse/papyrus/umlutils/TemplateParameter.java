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

import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.OperationTemplateParameter;

/**
 * 
 */
public class TemplateParameter extends Element {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.TemplateParameter uml2TemplateParameter;

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.TemplateableElement context;

	/**
	 * 
	 * 
	 * @param uml2TemplateParameter
	 */
	public TemplateParameter(org.eclipse.uml2.uml.TemplateParameter uml2TemplateParameter, org.eclipse.uml2.uml.TemplateableElement context) {
		super(uml2TemplateParameter);
		this.uml2TemplateParameter = uml2TemplateParameter;
		this.context = context;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2TemplateParameter.
	 */
	public org.eclipse.uml2.uml.TemplateParameter getUml2TemplateParameter() {
		return uml2TemplateParameter;
	}

	/**
	 * Gives the type of the parameter or null for void.
	 * 
	 * @return
	 */
	public Type getType() {
		Type result = null;
		if (uml2TemplateParameter.getParameteredElement() != null) {
			result = new Type((org.eclipse.uml2.uml.Type) uml2TemplateParameter.getParameteredElement());
		}
		return result;
	}

	/**
	 * Produces a label representing the template parameter. TODO Classifier Template Parameter is the only kind of template parameter correctly displayed TODO Take into account other kinds of
	 * classifier
	 * 
	 * @return
	 */
	public String getLabel() {
		// Strings used to produce a label for every kind of TemplateParameter
		String _name = ""; // name is the name of the parameteredElement
		String _kind = ""; // kind is derived from the type of the parameteredElement
		String _default = "";
		String _description = ""; // sentence describing the kind of TemplateParameter
		String _reference = ")"; // string describing the element where this template parameter is referenced from (if any)
		// Strings specific to ClassifierTemplateParameter
		String _constrainingClassifier = "";

		if (!context.getOwnedTemplateSignature().getOwnedParameters().contains(uml2TemplateParameter)) {
			_reference = " referenced from the signature of " + ((org.eclipse.uml2.uml.NamedElement) uml2TemplateParameter.getSignature().getTemplate()).getQualifiedName() + ")";
		}

		if (uml2TemplateParameter.getParameteredElement() == null) {
			_name = "<UNDEFINED>";
			if (uml2TemplateParameter instanceof ClassifierTemplateParameter) {
				_description = " (This is a ClassifierTemplateParameter";
			} else if (uml2TemplateParameter instanceof OperationTemplateParameter) {
				_description = " (This is an OperationTemplateParameter";
			} else if (uml2TemplateParameter instanceof ConnectableElementTemplateParameter) {
				_description = " (This is a ConnectableElementTemplateParameter";
			} else {// uml2TemplateParameter instanceof TemplateParameter
				_description = " (This is a TemplateParameter";
			}

		} else {
			_name = new org.eclipse.papyrus.umlutils.NamedElement((org.eclipse.uml2.uml.NamedElement) uml2TemplateParameter.getParameteredElement()).getName();
			_kind = " : " + uml2TemplateParameter.getParameteredElement().eClass().getName();
			// TODO Complete the cases for the other template parameters
			if (uml2TemplateParameter instanceof ClassifierTemplateParameter) {
				_description = " (This is a ClassifierTemplateParameter)";
				if (((ClassifierTemplateParameter) uml2TemplateParameter).getDefaultClassifier() != null) {
					_default = " = " + ((ClassifierTemplateParameter) uml2TemplateParameter).getDefaultClassifier().getName();
				}
				if (((ClassifierTemplateParameter) uml2TemplateParameter).getConstrainingClassifier() != null) {
					_constrainingClassifier = " > " + ((ClassifierTemplateParameter) uml2TemplateParameter).getConstrainingClassifier().getName();
				}
			} else if (uml2TemplateParameter instanceof OperationTemplateParameter) {
				_description = " (This is an OperationTemplateParameter";
			} else if (uml2TemplateParameter instanceof ConnectableElementTemplateParameter) {
				_description = " (This is a ConnectableElementTemplateParameter";
			} else {// uml2TemplateParameter instanceof TemplateParameter
				_description = " (This is a TemplateParameter";
			}
		}

		return _name + _kind + _constrainingClassifier + _default + _description + _reference;
	}

}
