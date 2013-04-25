/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Helper for control command
 * 
 * @author adaussy
 * 
 */
public class ControlHelper {

	/**
	 * Return true if the object is an controlled object
	 * 
	 * @param eObject
	 * @return
	 */
	public static boolean isRootControlledObject(EObject eObject) {
		if(eObject != null) {
			Resource resource = eObject.eResource();
			if(resource != null) {
				return resource.getContents().contains(eObject);
			}
		}
		return false;
	}
}
