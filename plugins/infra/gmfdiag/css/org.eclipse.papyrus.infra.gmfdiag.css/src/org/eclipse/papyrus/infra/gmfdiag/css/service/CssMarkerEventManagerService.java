package org.eclipse.papyrus.infra.gmfdiag.css.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.papyrus.infra.gmfdiag.css.editpolicies.MarkerEventListenerEditPolicy;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;

public class CssMarkerEventManagerService implements IMarkerEventListener {

	protected ServicesRegistry servicesRegistry ;

	protected Map<String, List<MarkerEventListenerEditPolicy>> eObjectURIToEditPolicies ; 

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry ;
		this.eObjectURIToEditPolicies = new HashMap<String, List<MarkerEventListenerEditPolicy>>() ;
	}

	public void startService() throws ServiceException {
		// Nothing specific to be done
	}

	public void disposeService() throws ServiceException {
		// Nothing specific to be done
	}

	/**
	 * Registers a MarkerEventListenerEditPolicy with this CssMarkerEventManagerService
	 * 
	 * @param editPolicy The edit policy to be registered with this CssMarkerEventManagerService
	 */
	public void registerEditPolicy(MarkerEventListenerEditPolicy editPolicy) {
		Assert.isTrue(editPolicy.getHost().getModel() instanceof View) ;
		if (editPolicy.getHost().getModel() instanceof View) {
			EObject semanticElement = ((View)editPolicy.getHost().getModel()).getElement() ;
			if (semanticElement != null) {
				String semanticElementURI = EcoreUtil.getURI(semanticElement).toString() ;
				List<MarkerEventListenerEditPolicy> correspondingGraphicalEditPolicies = eObjectURIToEditPolicies.get(semanticElementURI) ;
				if (correspondingGraphicalEditPolicies == null) {
					correspondingGraphicalEditPolicies = new ArrayList<MarkerEventListenerEditPolicy>() ;
					correspondingGraphicalEditPolicies.add(editPolicy) ;
				}
				else {
					if (! correspondingGraphicalEditPolicies.contains(editPolicy)) {
						correspondingGraphicalEditPolicies.add(editPolicy) ;
					}
				}
				eObjectURIToEditPolicies.put(semanticElementURI, correspondingGraphicalEditPolicies) ;
				
				// retrieves all markers associated with the resource of the semanticElement, and pass these markers for notification
				IResource resource = ResourceUtils.getFile(semanticElement.eResource()) ;
				if (resource != null) {
					try {
						IMarker[] allPapyrusMarkers = resource.findMarkers("org.eclipse.papyrus.modelmarker", true, IResource.DEPTH_INFINITE) ;
						List<IMarker> listOfMarkersForSemanticElement = new ArrayList<IMarker>() ;
						for (int i = 0 ; i < allPapyrusMarkers.length ; i++) {
							EObject cddSemanticElement = getEObjectOfMarker(allPapyrusMarkers[i]) ;
							if (EcoreUtil.getURI(cddSemanticElement).toString().equals(semanticElementURI))
								listOfMarkersForSemanticElement.add(allPapyrusMarkers[i]) ;
						}
						IMarker[] markersForSemanticElement = listOfMarkersForSemanticElement.toArray(new IMarker[listOfMarkersForSemanticElement.size()]);
						editPolicy.notifyMarkerChange(markersForSemanticElement, IMarkerEventListener.MARKER_ADDED) ;
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Unregisters the given MarkerEventListenerEditPolicy from this CssMarkerEventManagerService
	 * 
	 * @param editPolicy The edit policy to be unregistered from this CssMarkerEventManagerService
	 */
	public void unregisterEditPolicy(MarkerEventListenerEditPolicy editPolicy) {
		Assert.isTrue(editPolicy.getHost().getModel() instanceof View) ;
		if (editPolicy.getHost().getModel() instanceof View) {
			EObject semanticElement = ((View)editPolicy.getHost().getModel()).getElement() ;
			if (semanticElement != null) {
				String semanticElementURI = EcoreUtil.getURI(semanticElement).toString() ;
				List<MarkerEventListenerEditPolicy> correspondingGraphicalEditParts = eObjectURIToEditPolicies.get(semanticElementURI) ;
				if (correspondingGraphicalEditParts != null) {
					correspondingGraphicalEditParts.remove(editPolicy) ;
					if (correspondingGraphicalEditParts.isEmpty()) {
						eObjectURIToEditPolicies.remove(semanticElementURI) ;
					}
					else {
						eObjectURIToEditPolicies.put(semanticElementURI, correspondingGraphicalEditParts) ;
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener#notifyMarkerChange(org.eclipse.emf.ecore.EObject, org.eclipse.core.resources.IMarker, int)
	 */
	public void notifyMarkerChange(EObject semanticElement, IMarker marker, int markerState) {
		if (semanticElement != null) {
			String semanticElementURI = EcoreUtil.getURI(semanticElement).toString() ;
			List<MarkerEventListenerEditPolicy> correspondingGraphicalEditParts = eObjectURIToEditPolicies.get(semanticElementURI) ;
			if (correspondingGraphicalEditParts != null) {
				for (MarkerEventListenerEditPolicy editPart : correspondingGraphicalEditParts) {
					editPart.notifyMarkerChange(marker, markerState) ;
				}
			}
		}
	}
	
	/**
	 * Convenience method returning the EObject of a given marker (provided that it is a marker with a URI)
	 * 
	 * @param marker The marker from which eObject has to be retrieved
	 * @return The EObject associated with the given marker
	 */
	public static EObject getEObjectOfMarker(IMarker marker) {
		URI uriOfMarker = getURI(marker);
		if(uriOfMarker != null) {
			try {
				ResourceSet resourceSet = new ResourceSetImpl() ;
				resourceSet.getResource(uriOfMarker.trimFragment(), true);
				return resourceSet.getEObject(uriOfMarker, true);
			} catch (MissingResourceException e) {
				System.err.println("Missing resource");
			}
		}
		return null;
	}

	/**
	 * Convenience method returning the URI corresponding to the value of the EValidator.URI_ATTRIBUTE of a marker
	 * 
	 * @param marker The marker from which the URI corresponding to the value its EValidator.URI_ATTRIBUTE has to be constructed
	 * @return The URI corresponding to the value of the EValidator.URI_ATTRIBUTE of the given marker
	 */
	public static URI getURI(IMarker marker) {
		String uriOfMarkerStr = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if(uriOfMarkerStr != null) {
			return URI.createURI(uriOfMarkerStr);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener#isNotifiedOnInitialMarkerCheck()
	 */
	public boolean isNotifiedOnInitialMarkerCheck() {
		return false;
	}
	
}
