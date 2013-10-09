/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Patrick Tessier (CEA LIST)- initial implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.services.decoration;

import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.uml2.uml.NamedElement;


/**
 * overload the Generic decoration service to take in account validation on stereotyped element
 *
 * CAVEAT: this class is currently unused, since the validation mechanism already replaces a stereotype application
 *         by its base element (see org.eclipse.papyurs.uml.service.validation.StereotypeValidatorAdaptor)
 */

public class UMLDecorationService extends DecorationService {
		
	/**
	 * Initial message for UML elements
	 * @return the qualified name of the element, if it is a named element
	 */
	@Override
	public String initialMessage(Object element) {
		if (element instanceof NamedElement) {
			NamedElement ne = (NamedElement) element;
			return ne.getQualifiedName();
		}
		return super.initialMessage(element);
	}
}
