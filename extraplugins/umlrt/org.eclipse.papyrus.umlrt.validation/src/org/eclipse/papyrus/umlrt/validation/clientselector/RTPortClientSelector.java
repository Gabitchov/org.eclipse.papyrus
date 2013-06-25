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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.validation.clientselector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;


public class RTPortClientSelector implements IClientSelector {

	public boolean selects(Object object) {
		if(!(object instanceof EObject)) {
			return false;
		}

		if(object instanceof Element) {
			return false;
		}

		EObject stereotypeApplication = ((EObject)object);
		Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
		if(stereotype == null) {
			return false;
		}

		if("RTPort".equals(stereotype.getName())) {
			return true;
		}

		return false;
	}

}

