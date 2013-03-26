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
 *  Arnaud Cuccuru (CEA LIST) - arnaud.cuccuru@cea.fr
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *  
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.markerlistener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerMonitor;
import org.eclipse.papyrus.infra.services.markerlistener.providers.MarkerMonitorRegistry;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class MarkersMonitorService.
 */
public class MarkersMonitorService implements IService {

	/** The services registry. */
	private ServicesRegistry servicesRegistry;

	/**
	 * The list of registered Marker Event Listeners
	 */
	protected List<IMarkerEventListener> registeredMarkerEventListeners ;

	private List<IMarkerMonitor> monitorExtensions;

	private final IMarkerEventListener relay = createRelayListener();

	/**
	 * Gets the services registry.
	 * 
	 * @return the services registry
	 */
	public ServicesRegistry getServicesRegistry() {
		return servicesRegistry;
	}


	/**
	 * Sets the services registry.
	 * 
	 * @param servicesRegistry
	 *        the new services registry
	 */
	public void setServicesRegistry(ServicesRegistry servicesRegistry) {
		this.servicesRegistry = servicesRegistry;
	}


	/**
	 * Instantiates a new markers monitor service.
	 */
	public MarkersMonitorService() {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry;
		this.registeredMarkerEventListeners = this.getRegisteredMarkerEventListeners() ;
		this.monitorExtensions = new MarkerMonitorRegistry().getMarkerMonitors();

		checkMarkers() ;
	}

	protected List<IMarkerEventListener> getRegisteredMarkerEventListeners() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(IMarkerEventListener.MARKER_EVENT_LISTENER_EXTENSION_POINT_ID) ;
		this.registeredMarkerEventListeners = new ArrayList<IMarkerEventListener>() ;
		try {
			for (int i = 0 ; i < config.length ; i++) {
				Object o = config[i].createExecutableExtension("class") ;
				try {
					this.registeredMarkerEventListeners.add((IMarkerEventListener)servicesRegistry.getService(o.getClass())) ;
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}  
		return this.registeredMarkerEventListeners ;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(
				servicesRegistry);

		for (IMarkerMonitor next : monitorExtensions) {
			try {
				next.initialize(modelSet);
				next.addMarkerEventListener(relay);
			} catch (Exception e) {
				Activator.log.error(
						"Uncaught exception in initialization of marker monitor.",
						e);
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
		for (IMarkerMonitor next : monitorExtensions) {
			try {
				next.removeMarkerEventListener(relay);
				next.dispose();
			} catch (Exception e) {
				Activator.log.error(
						"Uncaught exception in initialization of marker monitor.",
						e);
			}
		}
	}

	/**
	 * Initial Checking for existing markers in notation.uml.
	 */
	void checkMarkers() {
		try {
			EList<Resource> resources = ServiceUtils.getInstance().getModelSet(servicesRegistry).getResources();
			// create a copy of the list, see bug 392194 (avoid concurrent modification exceptions)
			EList<Resource> resourcesCopy = new BasicEList<Resource>(resources);
			// loop over all resources (e.g. error markers are on notation, breakpoints on UML model)
			for (Resource resource : resourcesCopy) {
				try {
					Collection<? extends IPapyrusMarker> markers = getMarkers(resource, null /* all markers */, true);
					for (IPapyrusMarker next : markers) {
						EObject eObjectFromMarker = next.getEObject();
						if (eObjectFromMarker != null && this.registeredMarkerEventListeners != null) {
							for (IMarkerEventListener listener : this.registeredMarkerEventListeners) {
								if (listener.isNotifiedOnInitialMarkerCheck()) {
									listener.notifyMarkerChange(eObjectFromMarker, next, IMarkerEventListener.MARKER_ADDED) ;
								}
							}
						}
					}
				} catch (CoreException e) {
					Activator.log.error(e.getMessage(), e);
				}
			}
		} catch (ServiceException e1) {
			Activator.log.error(e1.getMessage(), e1);
		}
	}

	public Collection<? extends IPapyrusMarker> getMarkers(Resource resource,
			String type, boolean includeSubtypes)
					throws CoreException {

		return MarkerListenerUtils.getMarkerProvider(resource).getMarkers(
				resource, type, includeSubtypes);
	}

	private IMarkerEventListener createRelayListener() {
		return new IMarkerEventListener() {

			public void notifyMarkerChange(EObject eObjectOfMarker,
					IPapyrusMarker marker, int addedOrRemoved) {

				for (IMarkerEventListener next : registeredMarkerEventListeners) {
					try {
						next.notifyMarkerChange(eObjectOfMarker, marker, addedOrRemoved);
					} catch (Exception e) {
						Activator.log.error("Uncaught exception in marker listener.", e);
					}
				}
			}

			public void startService() {
				// not needed
			}

			public void init(ServicesRegistry servicesRegistry) {
				// not needed
			}

			public void disposeService() {
				// not needed
			}

			public boolean isNotifiedOnInitialMarkerCheck() {
				// not needed
				return false;
			}
		};
	}
}
