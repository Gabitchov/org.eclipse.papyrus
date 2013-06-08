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


/**
 * overload the Generic decoration service to take in account validation on stereotyped element
 *
 * CAVEAT: this class is currently unused, since the validation mechanism already replaces a stereotype application
 *         by its base element (see org.eclipse.papyurs.uml.service.validation.StereotypeValidatorAdaptor)
 */

public class UMLDecorationService extends DecorationService {
	
	/**
	 * Gets the decoration.
	 * use "synchronized" to assure that no decoration modifications are done while this operation is running
	 * (which would result in a concurrent modification operation)
	 * 
	 * @param element
	 *        the element
	 * @param navigateToParents
	 *        the navigate to parents
	 * @return the decoration
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#getDecoration(java.lang.Object, boolean)
	 */
	/*
	public List<IPapyrusDecoration> getDecorations(Object element, boolean navigateToParents) {
		UMLDecorationUtils tool = new UMLDecorationUtils(element);
		return tool.getDecorations(this, navigateToParents);
	}
	*/
}
