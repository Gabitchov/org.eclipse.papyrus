/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.property.editor.xtext.validation;


import org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.xtext.validation.Check;
 

/**
 * Class for customized java validation
 *
 */
public class UmlPropertyJavaValidator extends AbstractUmlPropertyJavaValidator {

	private static Namespace model ;
	private static Element contextElement ;
	
	public static void init(Element _contextElement) {
		contextElement = _contextElement ;
		if (contextElement != null) {
			Element elem = contextElement.getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
		}
	}

	public static Namespace getModel() {
		return model ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
	/**
	 * Custom validation for multiplicities. Raises an error in the case where the lower bound is upper than the upper bound.
	 * 
	 */
	@Check
	public void checkMultiplicityRule (MultiplicityRule rule) {
		int lowerValue = 0 ;
		int upperValue = 0 ;
		String errorMessage = "The upper bound of a multiplicity cannot be lower than the lower bound." ;
		try {
			if (rule.getBounds().size() == 2) {
				lowerValue = rule.getBounds().get(0).getValue().equals("*") ? -1 : Integer.valueOf(rule.getBounds().get(0).getValue()) ;
				upperValue = rule.getBounds().get(1).getValue().equals("*") ? -1 : Integer.valueOf(rule.getBounds().get(1).getValue()) ;
				if ((lowerValue == -1 && upperValue != -1) ||
					(lowerValue > upperValue && upperValue != -1))
					error(errorMessage, rule, UmlPropertyPackage.BOUND_SPECIFICATION__VALUE) ;
			}
		}
		catch (Exception e) {
			// An exception may be raised only in the case where the syntax for multiplicities is not respected.
			// No error needs to be generated (the syntax error is automatically handled by XText)
		}
	}
	
}
