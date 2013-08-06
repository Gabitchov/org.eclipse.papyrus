/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;


/**
 * Abstract strategy class for stereotype application location
 */
public abstract class AbstractStereotypeApplicationLocationStrategy implements IStereotypeApplicationLocationStrategy {

	/**
	 * @param element
	 * @param definition
	 * @return
	 */
	protected EList<EObject> getDefaultContainmentList(Element element, EClass definition) {
		return element.eResource().getContents();
	}

}
