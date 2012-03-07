/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation;

import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
 

public class AppliedStereotypePropertyJavaValidator extends AbstractAppliedStereotypePropertyJavaValidator {

	
	private static AppliedStereotypeProperty contextElement;
	// the namespace
	private static Namespace model;

	public static void init(AppliedStereotypeProperty _contextElement) {
		contextElement = _contextElement ;
		if (contextElement != null) {
			Element elem = contextElement.getBaseElement().getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
		}
	}
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}

}
