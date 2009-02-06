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

import org.eclipse.uml2.uml.NamedElement;

/**
 * 
 */
public class TemplateParameterSubstitution extends Element {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.TemplateParameterSubstitution uml2TemplateParameterSubstitution;

	/**
	 * 
	 * 
	 * @param uml2TemplateParameterSubstitution
	 */
	public TemplateParameterSubstitution(org.eclipse.uml2.uml.TemplateParameterSubstitution uml2TemplateParameterSubstitution) {
		super(uml2TemplateParameterSubstitution);
		this.uml2TemplateParameterSubstitution = uml2TemplateParameterSubstitution;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2TemplateParameter.
	 */
	public org.eclipse.uml2.uml.TemplateParameterSubstitution getUml2TemplateParameterSubstitution() {
		return uml2TemplateParameterSubstitution;
	}

	// /**
	// * Gives the type of the parameter or null for void.
	// *
	// * @return
	// */
	// public Type getType(){
	// Type result = null;
	// if (uml2TemplateParameterSubstitution.getParameteredElement()!= null){
	// result = new Type((org.eclipse.uml2.uml.Type)uml2TemplateParameterSubstitution.getParameteredElement());
	// }
	// return result;
	// }

	/**
	 * Produces a label representing the template parameter. TODO Classifier Template Parameter is the only kind of template parameter correctly displayed TODO Take into account other kinds of
	 * classifier
	 * 
	 * @return
	 */
	public String getLabel() {

		String _formal_name = ""; // name of the parameteredElement of the formal parameter
		String _actual_name = ""; // name of the parameterableElement used as an actual value

		if (uml2TemplateParameterSubstitution.getFormal() == null && uml2TemplateParameterSubstitution.getActuals().isEmpty()) {
			return "<UNDEFINED>";
		} else {
			// definition of the derived string for the formal parameter name
			if (uml2TemplateParameterSubstitution.getFormal() == null) {
				_formal_name = "<UNDEFINED>";
			} else {
				if (uml2TemplateParameterSubstitution.getFormal().getParameteredElement() == null) {
					_formal_name = "<UNDEFINED>";
				} else {
					_formal_name = "" + ((NamedElement) uml2TemplateParameterSubstitution.getFormal().getParameteredElement()).getName();
				}
			}
			// definition of the derived string for the actual value name
			if (uml2TemplateParameterSubstitution.getActuals().isEmpty()) {
				_actual_name = "<UNDEFINED>";
			} else {
				_actual_name = "" + ((NamedElement) uml2TemplateParameterSubstitution.getActuals().get(0)).getName();
			}
		}
		return _formal_name + " -> " + _actual_name;
	}

}
