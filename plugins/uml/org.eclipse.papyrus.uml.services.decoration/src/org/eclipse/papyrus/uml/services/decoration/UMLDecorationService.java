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
 * Patrick Tessier (CEA LIST) - initial implementation
 * Ansgar Radermacher (CEA List) - refactored stereotype handling, support for qualified name
 *****************************************************************************/
package org.eclipse.papyrus.uml.services.decoration;

import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.uml2.uml.NamedElement;


/**
 * Providing qualified name in the tool-tip message shown in the model explorer 
 *
 * Originally, this class was intended for stereotypes, now the handling of stereotypes is done in
 * @see org.eclipse.papyrus.uml.service.validation.UMLDiagnostician.
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
