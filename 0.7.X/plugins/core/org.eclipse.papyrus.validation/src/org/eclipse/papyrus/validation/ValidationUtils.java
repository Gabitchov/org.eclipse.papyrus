package org.eclipse.papyrus.validation;

import java.util.Map;
import java.util.MissingResourceException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;


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
}
