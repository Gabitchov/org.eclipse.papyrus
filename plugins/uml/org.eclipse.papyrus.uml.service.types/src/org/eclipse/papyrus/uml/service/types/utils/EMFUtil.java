/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Utility class use to retrieve stereotype applications.
 * 
 * Copied from oep.infra.emf.EMFHelper to avoid dependency toward this plug-in.
 * 
 */
public class EMFUtil {

	/**
	 * Tests if an EObject is read only
	 * Delegates to the EObject's editing domain if it can be found
	 * 
	 * @param eObject
	 * @return
	 *         True if the EObject is read only
	 */
	public static boolean isReadOnly(EObject eObject) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		return isReadOnly(eObject, domain);
	}

	/**
	 * Tests if an EObject is read only
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param eObject
	 * @param domain
	 * @return
	 *         True if the EObject is read only
	 */
	public static boolean isReadOnly(EObject eObject, EditingDomain domain) {
		return isReadOnly(eObject.eResource(), domain);
	}

	/**
	 * Tests if the Resource is read only
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param resource
	 * @param domain
	 * @return
	 *         True if the Resource is read only
	 */
	public static boolean isReadOnly(Resource resource, EditingDomain domain) {
		if(domain instanceof AdapterFactoryEditingDomain) {
			return ((AdapterFactoryEditingDomain)domain).isReadOnly(resource);
		}

		if(resource == null) {
			return false;
		}

		ResourceSet resourceSet = resource.getResourceSet();

		if(resourceSet == null) {
			return false;
		}

		Map<String, ?> attributes = resourceSet.getURIConverter().getAttributes(resource.getURI(), null);
		Boolean readOnly = (Boolean)attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);

		return readOnly == null ? false : readOnly;
	}
}
