/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.uml2.uml.NamedElement;

/**
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class ValidationProvider {

	// @unused
	public static IStatus validateUniqueName(NamedElement element) {
		IStatus status = null;
		if(element != null) {
			boolean unique = checkUniqueName(element);
			if(!unique) {
				status = new Status(IStatus.ERROR, Activator.ID, "An element with name \"" + element.getName()
						+ "\" already exists.");
			} else {
				status = new Status(IStatus.OK, Activator.ID, "Unique name.");
			}
		} else {
			status = new Status(IStatus.WARNING, Activator.ID, "Element to validate is null");
		}
		return status;
	}

	public static boolean checkUniqueName(NamedElement namedElement) {
		if(namedElement == null) {
			return false;
		}
		String namedElementName = namedElement.getName();
		if(namedElementName == null) {
			return true;
		}
		if(namedElement.eContainer() != null) {
			for(EObject eObject : namedElement.eContainer().eContents()) {
				if(eObject != null && eObject != namedElement && eObject instanceof NamedElement) {
					String name = ((NamedElement)eObject).getName();
					if(namedElementName.equals(name)) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
