/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.resource.ResourceFactory;

/**
 * This class provides static methods to help users using Resources
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class ResourceUtil {

	/**
	 * Get in the EMF Resource of the eobject e the Resource Papyrus If it doesn't exist, it adds it
	 * 
	 * @param e
	 *            the eobject contained in the resource browsed
	 * @return the Resource or null if the parameter is null or if the eobject in parameter doesn't
	 *         have an EMF Resource
	 */
	public static Resource getResource(EObject e) {
		if (e == null || e.eResource() == null) {
			return null;
		}
		return getResource(e.eResource());
	}

	/**
	 * Get in the EMF Resource the Resource papyrus If it doesn't exist, it adds it
	 * 
	 * @param eResource
	 *            the Papyrus Resource browsed
	 * @return the Resource or null if the parameter is null
	 */
	public static Resource getResource(org.eclipse.emf.ecore.resource.Resource eResource) {
		if (eResource == null) {
			return null;
		}
		Resource result = null;
		for (EObject e : eResource.getContents()) {
			if (e instanceof Resource) {
				result = (Resource) e;
				break;
			}
		}
		if (result == null) {
			result = ResourceFactory.eINSTANCE.createResource();
			eResource.getContents().add(result);
		}
		return result;
	}

	/**
	 * Remove the Papyrus Resource from the EMF Resource of e
	 * 
	 * @param e
	 */
	public static void removeResource(EObject e) {
		if (e == null || e.eResource() == null) {
			return;
		}
		removeResource(e.eResource());
	}

	/**
	 * Remove the Papyrus Resource from the EMF Resource eResource
	 * 
	 * @param eResource
	 */
	public static void removeResource(org.eclipse.emf.ecore.resource.Resource eResource) {
		if (eResource == null) {
			return;
		}
		Iterator<EObject> i = eResource.getContents().iterator();
		while (i.hasNext()) {
			EObject current = i.next();
			if (current instanceof Resource) {
				i.remove();
			}
		}
	}
}
