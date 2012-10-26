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

package org.eclipse.papyrus.infra.services.markerlistener;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class MarkersMonitorService.
 */
public class MarkersMonitorService implements IService {

	/** The services registry. */
	private ServicesRegistry servicesRegistry;

	/** The decoration service. */
	private DecorationService decorationService;

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

	/** The file observer. */
	protected MarkerObserver fileObserver;


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
		this.fileObserver = new MarkerObserver(ServiceUtils.getInstance().getModelSet(servicesRegistry).getTransactionalEditingDomain());
		try {
			decorationService = servicesRegistry.getService(DecorationService.class);
			checkMarkers();
		} catch (ServiceException e) {
			Activator.log.error(e.getMessage(), e);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */

	public void startService() throws ServiceException {
		//Start Listening
		FileChangeManager.getInstance().addFileObserver(this.fileObserver);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */

	public void disposeService() throws ServiceException {
		//Stop Listening
		FileChangeManager.getInstance().removeFileObserver(this.fileObserver);
	}

	/**
	 * Initial Checking for existing markers in notation.uml.
	 */
	void checkMarkers() {
		IMarker[] markers = null;

		try {
			EList<Resource> resources = ServiceUtils.getInstance().getModelSet(servicesRegistry).getResources();
			// create a copy of the list, see bug 392194 (avoid concurrent modification exceptions)
			EList<Resource> resourcesCopy = new BasicEList<Resource>(resources);
			// loop over all resources (e.g. error markers are on notation, breakpoints on UML model)
			for(Resource resource : resourcesCopy) {
				URI uri = resource.getURI();
				String platformResourceString = uri.toPlatformString(true);
				IFile file = (platformResourceString != null ? ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourceString)) : null);
				if(file != null) {
					try {
						markers = file.findMarkers(null /* all markers */, true, 0);

						for(int i = 0; i < markers.length; i++) {
							EObject eObjectFromMarker = MarkerListenerUtils.eObjectFromMarkerOrMap(markers[i], null, ServiceUtils.getInstance().getModelSet(servicesRegistry).getTransactionalEditingDomain());
							if(eObjectFromMarker != null) {
								decorationService.addDecoration(markers[i], eObjectFromMarker);
							}
						}
					} catch (CoreException e) {
						Activator.log.error(e.getMessage(), e);
					}
				}
			}

		} catch (ServiceException e1) {
			Activator.log.error(e1.getMessage(), e1);
		}
	}



	// 	File Listening Functions

	/**
	 * An asynchronous update interface for receiving notifications
	 * about Marker information as the Marker is constructed.
	 */
	class MarkerObserver implements IFileObserver {


		/** The domain. */
		private final TransactionalEditingDomain domain;

		/**
		 * This method is called when information about an Marker
		 * which was previously requested using an asynchronous
		 * interface becomes available.
		 * 
		 * @param domain
		 *        the domain
		 */
		public MarkerObserver(TransactionalEditingDomain domain) {
			this.domain = domain;
		}

		/**
		 * handle changes of file name.
		 * 
		 * @param oldFile
		 *        the old file
		 * @param file
		 *        the file
		 */
		public void handleFileRenamed(IFile oldFile, IFile file) {
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.ui.resources.IFileObserver#handleFileMoved(org.eclipse.core.resources.IFile,
		 *      org.eclipse.core.resources.IFile)
		 * 
		 * @param oldFile
		 * @param file
		 */

		public void handleFileMoved(IFile oldFile, IFile file) {
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.ui.resources.IFileObserver#handleFileDeleted(org.eclipse.core.resources.IFile)
		 * 
		 * @param file
		 */

		public void handleFileDeleted(IFile file) {
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.ui.resources.IFileObserver#handleFileChanged(org.eclipse.core.resources.IFile)
		 * 
		 * @param file
		 */

		public void handleFileChanged(IFile file) {
		}

		/**
		 * A marker has been added, treat as change.
		 * 
		 * @param marker
		 *        the marker
		 */
		public void handleMarkerAdded(IMarker marker) {
			handleMarkerChanged(marker);
		}

		/**
		 * A marker has been deleted. Need to treat separately from change, since old values are not stored in
		 * marker, but in attribute map
		 * 
		 * @param marker
		 *        the marker
		 * @param attributes
		 *        the attributes
		 */
		public void handleMarkerDeleted(IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
			EObject eObjectFromMarker = MarkerListenerUtils.eObjectFromMarkerOrMap(null, attributes, domain);
			if(eObjectFromMarker != null) {
				decorationService.removeDecoration(marker.toString());
			}
		}

		/**
		 * A marker has changed.
		 * 
		 * @param marker
		 *        the marker
		 */
		public void handleMarkerChanged(IMarker marker) {
			EObject eObjectFromMarker = MarkerListenerUtils.eObjectFromMarkerOrMap(marker, null, domain);
			if(eObjectFromMarker != null) {
				decorationService.addDecoration(marker, eObjectFromMarker);
			}
		}
	}

}
