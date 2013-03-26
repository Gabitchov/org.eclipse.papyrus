/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - filter out EObjects that are Resources (CDO)
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.ui.CustomizedContentProviderUtils;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;

/**
 * A Helper class for manipulating EMF Objects
 * 
 * @author Camille Letavernier
 */
//TODO : Check implementations. Most of them are old and don't always match the specification
public class EMFHelper extends org.eclipse.papyrus.infra.tools.util.EMFHelper {

	/**
	 * Returns the EObject corresponding to the input object
	 * Tests if the input is an EObject, or if it is Adaptable
	 * to an EObject
	 * 
	 * @param source
	 * @return An EObject corresponding to the input source, or null
	 *         if the EObject could not be resolved
	 */
	public static EObject getEObject(final Object source) {

		//Support for EMF 0.2 CustomizedTree: The TreeElements are EObjects, and do not implement IAdatapble.
		//FIXME: Use an AdapterFactory instead, to remove the dependency to EMF Facet 0.2
		Object resolved = CustomizedContentProviderUtils.resolve(source);
		if(resolved != source && isEMFModelElement(resolved)) {
			return (EObject)resolved;
		}

		//General case
		if(isEMFModelElement(source)) {
			return (EObject)source;
		} else if(source instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)source).getAdapter(EObject.class);
			if(eObject == null) { //EMF Facet 0.1
				eObject = (EObject)((IAdaptable)source).getAdapter(EReference.class);
			}
			return asEMFModelElement(eObject); // in case the adapter is a CDOResource
		}

		return null;
	}

	/**
	 * Retrieve the EditingDomain for the given source object. The object is first
	 * resolved to an EObject through #getEObject when possible.
	 * 
	 * @param source
	 * @return
	 *         The source object's editing domain, or null if it couldn't be found
	 */
	public static EditingDomain resolveEditingDomain(final Object source) {
		return resolveEditingDomain(getEObject(source));
	}

	/**
	 * Retrieve the EditingDomain for the given source EObject
	 * 
	 * @param source
	 * @return
	 *         The source eObject's editing domain, or null if it couldn't be found
	 */
	public static EditingDomain resolveEditingDomain(final EObject source) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
		if(domain == null) {
			try {
				domain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
			} catch (ServiceException e) {
				//Ignore: We cannot find the domain
			}
		}
		return domain;
	}

	/**
	 * Tests if an EObject is read only
	 * Delegates to the EObject's editing domain if it can be found
	 * 
	 * @param eObject
	 * @return
	 *         True if the EObject is read only
	 */
	public static boolean isReadOnly(final EObject eObject) {
		EditingDomain domain = resolveEditingDomain(eObject);
		return isReadOnly(eObject, domain);
	}

	/**
	 * Tests if an EObject is read only
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param eObject
	 * 
	 * @param domain
	 * @return
	 *         True if the EObject is read only
	 */
	public static boolean isReadOnly(final EObject eObject, final EditingDomain domain) {
		if(domain != null) {
			Object handler = PlatformHelper.getAdapter(domain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler) {
				return ((IReadOnlyHandler)handler).isReadOnly(eObject).get();
			}

			if(eObject.eResource() != null) {
				return domain.isReadOnly(eObject.eResource());
			}
		}
		return false;
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
	public static boolean isReadOnly(final Resource resource, final EditingDomain domain) {
		if(resource == null) {
			return false;
		}

		if(domain != null && resource.getURI() != null) {
			Object handler = PlatformHelper.getAdapter(domain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler) {
				return ((IReadOnlyHandler)handler).anyReadOnly(new URI[]{ resource.getURI() }).get();
			}
			return domain.isReadOnly(resource);
		}

		// no editing domain : use file system attribute
		ResourceSet resourceSet = resource.getResourceSet();

		if(resourceSet == null) {
			return false;
		}

		Map<String, ?> attributes = resourceSet.getURIConverter().getAttributes(resource.getURI(), null);
		Boolean readOnly = (Boolean)attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);

		return readOnly == null ? false : readOnly;
	}

}
