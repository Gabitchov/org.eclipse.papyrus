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


import org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule;
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
	
	/**
	 * Checks
	 * @param rule
	 */
	@Check
	public void checkPropertyRule(PropertyRule rule) {
		//TODO To be implented
	}
	
}
