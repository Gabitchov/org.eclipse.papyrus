/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 *  Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr (major revision in context of bug 400593)
 *   
 *  Arnaud Cuccuru (CEA LIST) - arnaud.cuccuru@cea.fr
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.decoration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.decoration.DecorationChange.DecorationChangeKind;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.DecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.DecorationUtils;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * The Class DecorationService.
 */
public class DecorationService extends Observable implements IDecorationService {

	/** The services registry. */
	private ServicesRegistry servicesRegistry;

	/** The decorations. */
	private final Map<String, Decoration> decorations = new HashMap<String, Decoration>();

	/**
	 * Inits the.
	 * 
	 * @param servicesRegistry
	 *        the services registry
	 * @throws ServiceException
	 *         the service exception
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 */

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 * Instantiates a new decoration service.
	 */
	public DecorationService() {
	}

	/**
	 * Start service.
	 * 
	 * @throws ServiceException
	 *         the service exception
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#startService()
	 */

	public void startService() throws ServiceException {
	}

	/**
	 * Dispose service.
	 * 
	 * @throws ServiceException
	 *         the service exception
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#disposeService()
	 */

	public void disposeService() throws ServiceException {
	}

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
	 * Gets the decorations.
	 * 
	 * @return the decorations
	 */
	public Map<String, Decoration> getDecorations() {
		return decorations;
	}

	/**
	 * Adds the listener.
	 * 
	 * @param o
	 *        the o
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#addListener(java.util.Observer)
	 */

	public synchronized void addListener(Observer o) {
		addObserver(o);
	}

	/**
	 * Delete listener.
	 * 
	 * @param o
	 *        the o
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#deleteListener(java.util.Observer)
	 */

	public synchronized void deleteListener(Observer o) {
		deleteObserver(o);
	}

	/**
	 * Removes the decoration.
	 * 
	 * @param id
	 *        the id
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#removeDecoration(java.lang.String)
	 */

	public synchronized void removeDecoration(String id) {

		Decoration decoration = decorations.get(id);
		if(decoration != null) {

			decorations.remove(id);
			setChanged();
			notifyObservers(new DecorationChange(DecorationChangeKind.DecorationRemoved, decoration));
		}
	}

	/**
	 * Adds the decoration from a marker
	 * 
	 * @param id
	 *        the id
	 * @param element
	 *        the element
	 * @param decoration
	 *        the decoration
	 * @param message
	 *        the message
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#addDecoration(java.lang.String, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.jface.resource.ImageDescriptor, java.lang.String)
	 */
	public synchronized IPapyrusDecoration addDecoration(IPapyrusMarker marker, EObject element) {

		try {
			// obtain marker type specific function
			IDecorationSpecificFunctions infoUtil = DecorationSpecificFunctions.getDecorationInterface(marker.getType());
			if(infoUtil != null) {
				ImageDescriptor imageForGE = infoUtil.getImageDescriptorForGE(marker);
				ImageDescriptor imageForME = infoUtil.getImageDescriptorForME(marker);
				PreferedPosition position = infoUtil.getPreferedPosition(marker);
				int priority = infoUtil.getPriority(marker);
				IPapyrusDecoration decoration = addDecoration(marker.toString(), marker.getType(), element, imageForGE, imageForME, position, infoUtil.getMessage(marker), priority);

				return decoration;
			}
		} catch (CoreException e) {
			Activator.log.error(e.getMessage(), e);
		}
		return null;
	}


	/**
	 * Adds the decoration.
	 * 
	 * @param id
	 *        the id
	 * @param type
	 *        the decoration type, currently corresponding to the marker type
	 * @param element
	 *        the element
	 * @param decoration
	 *        the decoration
	 * @param message
	 *        the message
	 * @param priority
	 *        the priority
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#addDecoration(java.lang.String, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.jface.resource.ImageDescriptor, java.lang.String)
	 */
	public synchronized IPapyrusDecoration addDecoration(String id, String type, EObject element, ImageDescriptor decorationImageForGE, ImageDescriptor decorationImageForME, PreferedPosition position, String message, int priority) {

		Decoration decoration = decorations.get(id);
		if(decoration == null) {
			decoration = new Decoration(id, type, decorationImageForGE, decorationImageForME, message, element, priority);
			decorations.put(id, decoration);
		} else {
			decoration.setDecorationImageForGE(decorationImageForGE);
			decoration.setDecorationImageForME(decorationImageForME);
			decoration.setMessage(message);
			decoration.setPriority(priority);
		}
		decoration.setPosition(position);

		// notifyListeners(this);
		setChanged();
		notifyObservers(new DecorationChange(DecorationChangeKind.DecorationAdded, decoration));
		return decoration;
	}

	/**
	 * Gets the decoration.
	 * use "synchronized" to assure that no decoration modifications are done while this operation is running
	 * (which would result in a concurrent modification operation)
	 * 
	 * @param element
	 *        the element
	 * @param navigateToParents
	 *        the navigate to parents
	 * @return the decoration
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationService#getDecoration(java.lang.Object, boolean)
	 */
	public List<IPapyrusDecoration> getDecorations(Object element, boolean navigateToParents) {
		DecorationUtils tool = new DecorationUtils(element);
		tool.tryChildIfEmpty();
		if(tool.getEObject() != null) {
			return tool.getDecorations(this, navigateToParents);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener#notifyMarkerChange(org.eclipse.emf.ecore.EObject, org.eclipse.core.resources.IMarker, int)
	 */
	public void notifyMarkerChange(EObject eObjectOfMarker, IPapyrusMarker marker, int addedOrRemoved) {
		if (addedOrRemoved == IMarkerEventListener.MARKER_ADDED) {
			this.addDecoration(marker, eObjectOfMarker) ;
		}
		else { // IMarkerEventListener.MARKER_REMOVED
			this.removeDecoration(marker.toString()) ;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener#isNotifiedOnInitialMarkerCheck()
	 */
	public boolean isNotifiedOnInitialMarkerCheck() {
		return true;
	}


}
