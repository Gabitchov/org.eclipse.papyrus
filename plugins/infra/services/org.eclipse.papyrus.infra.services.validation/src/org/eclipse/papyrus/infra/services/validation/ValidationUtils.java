/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation;

import java.util.Map;
import java.util.MissingResourceException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;


public class ValidationUtils {

	/**
	 * Return the EObject retrieved from the URI attribute in the map. Retrieve it either via the marker itself
	 * or via the attribute mapping (required in case a deleted marker)
	 * 
	 * @param marker
	 *        the problem marker
	 * @param attributes
	 *        a map of the problem marker
	 * @param domain
	 *        the editing domain used for the conversion from URI to eObecjt
	 * @return
	 */
	public static EObject eObjectFromMarkerOrMap(IMarker marker, @SuppressWarnings("rawtypes") Map attributes, EditingDomain domain) {
		String uriAttribute;
		if(domain == null) {
			return null;
		}
		if(marker != null) {
			uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		} else {
			uriAttribute = (String)attributes.get(EValidator.URI_ATTRIBUTE);
		}
		if(uriAttribute != null) {
			URI uriOfMarker = URI.createURI(uriAttribute);
			try {
				return domain.getResourceSet().getEObject(uriOfMarker, true);
			} catch (MissingResourceException e) {
				// happens after renaming of the file containing the marker (or a parent folder)
				// try to retrieve eObject via fragment only (assuming that no two elements within resource-set share
				// the same fragment).
				return eObjectOfFragment(uriOfMarker, domain);
			} catch (WrappedException e) {
				// same as above, seems to depend on context which exception is thrown.
				return eObjectOfFragment(uriOfMarker, domain);
			}
		}
		return null;
	}

	/**
	 * Return an eObject from the set of resources associated with an editing domain.
	 * The first EObject whose ID corresponds to the fragment of the URI is returned.
	 * 
	 * @param uri
	 *        the URI of an element
	 * @param domain
	 *        the editing domain
	 * @return
	 */
	public static EObject eObjectOfFragment(URI uri, EditingDomain domain) {
		try {
			for(Resource resource : domain.getResourceSet().getResources()) {
				EObject eObjectOfMarker = resource.getEObject(uri.fragment());
				if(eObjectOfMarker != null) {
					return eObjectOfMarker;
				}
			}
		} catch (WrappedException e) {
		}
		return null;
	}
	
	/**
	 * Return the validation resource for a selected eObject
	 * 
	 * @return The resource on which markers should be applied.
	 */
	public static Resource getValidationResource(EObject eObject) {
		// fix for bug 397518 - assure that markers are put onto UML resource instead of delegating to domain
		return eObject.eResource();
		// TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eObject);
		// return getValidationResourceViaDomain(domain);
	}

	/**
	 * @return The resource on which markers should be applied.
	 *         Currently, the function simply returns the first resource of the resource-set which happens to be the
	 *         "notation" resource. This might change in the future.
	 */
	public static Resource getValidationResourceViaDomain(TransactionalEditingDomain domain) {
		if(domain != null) {
			Resource resource = eclipseResourcesUtil != null ? domain.getResourceSet().getResources().get(0) : null;
			return resource;
		}
		return null;
	}

	public static EclipseResourcesUtil eclipseResourcesUtil =
		EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE ? new EclipseResourcesUtil() : null;
}
