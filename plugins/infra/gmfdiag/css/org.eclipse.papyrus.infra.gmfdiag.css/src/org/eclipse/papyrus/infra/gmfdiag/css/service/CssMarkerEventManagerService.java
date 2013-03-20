/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - gracefully handle resources not in the workspace (CDO)
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.editpolicies.MarkerEventListenerEditPolicy;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.MarkersMonitorService;

public class CssMarkerEventManagerService implements IMarkerEventListener {

	protected ServicesRegistry servicesRegistry;

	protected Map<String, List<MarkerEventListenerEditPolicy>> eObjectURIToEditPolicies;

	protected MarkersMonitorService monitorService;

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry;
		this.eObjectURIToEditPolicies = new HashMap<String, List<MarkerEventListenerEditPolicy>>();
		this.monitorService = servicesRegistry.getService(MarkersMonitorService.class);
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
	 * @param editPolicy
	 *        The edit policy to be registered with this CssMarkerEventManagerService
	 */
	public void registerEditPolicy(MarkerEventListenerEditPolicy editPolicy) {
		Assert.isTrue(editPolicy.getHost().getModel() instanceof View);
		if(editPolicy.getHost().getModel() instanceof View) {
			EObject semanticElement = ((View)editPolicy.getHost().getModel()).getElement();
			if(semanticElement != null) {
				String semanticElementURI = EcoreUtil.getURI(semanticElement).toString();
				List<MarkerEventListenerEditPolicy> correspondingGraphicalEditPolicies = eObjectURIToEditPolicies.get(semanticElementURI);
				if(correspondingGraphicalEditPolicies == null) {
					correspondingGraphicalEditPolicies = new ArrayList<MarkerEventListenerEditPolicy>();
					correspondingGraphicalEditPolicies.add(editPolicy);
				} else {
					if(!correspondingGraphicalEditPolicies.contains(editPolicy)) {
						correspondingGraphicalEditPolicies.add(editPolicy);
					}
				}
				eObjectURIToEditPolicies.put(semanticElementURI, correspondingGraphicalEditPolicies);

				// retrieves all markers associated with the resource of the semanticElement, and pass these markers for notification
				Resource resource = semanticElement.eResource();
				if(resource != null) {
					try {
						Collection<? extends IPapyrusMarker> allPapyrusMarkers = monitorService.getMarkers(resource, "org.eclipse.papyrus.modelmarker", true);
						List<IPapyrusMarker> listOfMarkersForSemanticElement = new ArrayList<IPapyrusMarker>();
						for(IPapyrusMarker next : allPapyrusMarkers) {
							URI cddSemanticElementURI = getURI(next);
							if(cddSemanticElementURI == null) {
								return;
							}
							if(cddSemanticElementURI.toString().equals(semanticElementURI)) {
								listOfMarkersForSemanticElement.add(next);
							}
						}
						IPapyrusMarker[] markersForSemanticElement = listOfMarkersForSemanticElement.toArray(new IPapyrusMarker[listOfMarkersForSemanticElement.size()]);
						editPolicy.notifyMarkerChange(markersForSemanticElement, IMarkerEventListener.MARKER_ADDED);
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
	 * @param editPolicy
	 *        The edit policy to be unregistered from this CssMarkerEventManagerService
	 */
	public void unregisterEditPolicy(MarkerEventListenerEditPolicy editPolicy) {
		Assert.isTrue(editPolicy.getHost().getModel() instanceof View);
		if(editPolicy.getHost().getModel() instanceof View) {
			EObject semanticElement = ((View)editPolicy.getHost().getModel()).getElement();
			if(semanticElement != null) {
				String semanticElementURI = EcoreUtil.getURI(semanticElement).toString();
				List<MarkerEventListenerEditPolicy> correspondingGraphicalEditParts = eObjectURIToEditPolicies.get(semanticElementURI);
				if(correspondingGraphicalEditParts != null) {
					correspondingGraphicalEditParts.remove(editPolicy);
					if(correspondingGraphicalEditParts.isEmpty()) {
						eObjectURIToEditPolicies.remove(semanticElementURI);
					} else {
						eObjectURIToEditPolicies.put(semanticElementURI, correspondingGraphicalEditParts);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener#notifyMarkerChange(org.eclipse.emf.ecore.EObject,
	 * org.eclipse.core.resources.IMarker, int)
	 */
	public void notifyMarkerChange(EObject semanticElement, IPapyrusMarker marker, int markerState) {
		if(semanticElement != null) {
			String semanticElementURI = EcoreUtil.getURI(semanticElement).toString();
			List<MarkerEventListenerEditPolicy> correspondingGraphicalEditParts = eObjectURIToEditPolicies.get(semanticElementURI);
			if(correspondingGraphicalEditParts != null) {
				for(MarkerEventListenerEditPolicy editPart : correspondingGraphicalEditParts) {
					editPart.notifyMarkerChange(marker, markerState);
				}
			}
		}

	}

	/**
	 * Convenience method returning the EObject of a given marker (provided that it is a marker with a URI)
	 * 
	 * @param marker
	 *        The marker from which eObject has to be retrieved
	 * @return The EObject associated with the given marker
	 */
	public static EObject getEObjectOfMarker(IPapyrusMarker marker) {
		URI uriOfMarker = getURI(marker);
		if(uriOfMarker != null) {
			try {
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResource(uriOfMarker.trimFragment(), true);
				return resourceSet.getEObject(uriOfMarker, true);
			} catch (MissingResourceException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}

	/**
	 * Convenience method returning the URI corresponding to the value of the EValidator.URI_ATTRIBUTE of a marker
	 * 
	 * @param marker
	 *        The marker from which the URI corresponding to the value its EValidator.URI_ATTRIBUTE has to be constructed
	 * @return The URI corresponding to the value of the EValidator.URI_ATTRIBUTE of the given marker
	 */
	public static URI getURI(IPapyrusMarker marker) {
		String uriOfMarkerStr = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if(uriOfMarkerStr != null) {
			return URI.createURI(uriOfMarkerStr);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener#isNotifiedOnInitialMarkerCheck()
	 */
	public boolean isNotifiedOnInitialMarkerCheck() {
		return false;
	}

}
