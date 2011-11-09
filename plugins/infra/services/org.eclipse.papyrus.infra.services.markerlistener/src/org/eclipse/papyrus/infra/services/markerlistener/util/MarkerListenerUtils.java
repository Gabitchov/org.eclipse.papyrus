/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr 
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.markerlistener.util;

import java.util.Map;
import java.util.MissingResourceException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;


// TODO: Auto-generated Javadoc
/**
 * The Class MarkerListenerUtils.
 */
public class MarkerListenerUtils {

	/**
	 * E object from marker or map.
	 * 
	 * @param marker
	 *        the marker
	 * @param attributes
	 *        the attributes
	 * @param domain
	 *        the domain
	 * @return the e object
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
	 * E object of fragment.
	 * 
	 * @param uri
	 *        the uri
	 * @param domain
	 *        the domain
	 * @return the e object
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

}
