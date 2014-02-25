/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 * Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 * Christian W. Damus (CEA) - support marker type hierarchy in CDO problem markers (CDO)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.markerlistener.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;
import org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerProvider;
import org.eclipse.papyrus.infra.services.markerlistener.providers.MarkerProviderRegistry;


/**
 * The Class MarkerListenerUtils.
 */
public class MarkerListenerUtils {

	public static EclipseResourcesUtil eclipseResourcesUtil = EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE ? new EclipseResourcesUtil() : null;

	private static final Map<String, String> MARKER_LABELS = new java.util.HashMap<String, String>();

	private static final Map<String, Set<String>> MARKER_HIERARCHY = new java.util.HashMap<String, Set<String>>();

	static {
		loadMarkerTypes();
	}

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
		if((domain == null) || (domain.getResourceSet() == null)) {
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
				//Bug 410461: Do not load external objects in the current resource set!!
				return domain.getResourceSet().getEObject(uriOfMarker, false);
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
				if(uri.fragment() == null) {
					continue;
				}
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
	 * @param resource
	 * @return
	 * @deprecated
	 *             MarkerProviders should not be exclusive. Use #getMarkerProviders(Resource) instead
	 */
	@Deprecated
	public static IMarkerProvider getMarkerProvider(Resource resource) {
		return MarkerProviderRegistry.INSTANCE.getMarkerProvider(resource);
	}

	public static List<IMarkerProvider> getMarkerProviders(Resource resource) {
		return MarkerProviderRegistry.INSTANCE.getMarkerProviders(resource);
	}

	public static IFile getFile(Resource resource) {
		URI uri = resource.getURI();

		ResourceSet rset = resource.getResourceSet();
		if(rset != null) {
			uri = rset.getURIConverter().normalize(uri);
		}

		IFile result = uri.isPlatformResource() ? ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true))) : null;

		if((result != null) && !result.exists()) {
			result = null;
		}

		return result;
	}

	public static String getMarkerTypeLabel(String type) {
		String result = MARKER_LABELS.get(type);

		if(result == null) {
			result = type;
		}

		return result;
	}

	private static void loadMarkerTypes() {
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(ResourcesPlugin.PI_RESOURCES, ResourcesPlugin.PT_MARKERS);

		for(IExtension next : point.getExtensions()) {
			String type = next.getUniqueIdentifier();
			MARKER_LABELS.put(type, next.getLabel());

			Set<String> superTypes = new java.util.HashSet<String>();

			for(IConfigurationElement config : next.getConfigurationElements()) {
				if("super".equals(config.getName())) { //$NON-NLS-1$
					String super_ = config.getAttribute("type"); //$NON-NLS-1$
					if((super_ != null) && (super_.length() > 0)) {
						superTypes.add(super_);
					}
				}
			}

			MARKER_HIERARCHY.put(type, Collections.unmodifiableSet(superTypes));
		}
	}

	public static boolean isMarkerTypeSubtypeOf(String subtype, String supertype) {
		boolean result = false;

		Set<String> supertypes = MARKER_HIERARCHY.get(subtype);
		if(supertypes != null) {
			result = supertypes.contains(supertype);
			if(!result) {
				// recursive
				Set<String> cycleDetect = new java.util.HashSet<String>();
				cycleDetect.add(subtype);
				result = isAnyMarkerTypeSubtypeOf(supertypes, supertype, cycleDetect);
			}
		}

		return result;
	}

	private static boolean isAnyMarkerTypeSubtypeOf(Set<String> subtypes, String supertype, Set<String> cycleDetect) {
		boolean result = false;

		for(String subtype : subtypes) {
			if(cycleDetect.add(subtype)) {
				Set<String> supertypes = MARKER_HIERARCHY.get(subtype);
				if(supertypes != null) {
					result = supertypes.contains(supertype);
					if(!result) {
						result = isAnyMarkerTypeSubtypeOf(supertypes, supertype, cycleDetect);
					}
					if(result) {
						break;
					}
				}
			}
		}

		return result;
	}
}
