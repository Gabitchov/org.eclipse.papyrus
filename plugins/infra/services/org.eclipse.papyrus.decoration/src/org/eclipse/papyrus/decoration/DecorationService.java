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
package org.eclipse.papyrus.decoration;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.decoration.util.Decoration;
import org.eclipse.papyrus.decoration.util.DecorationUtils;
import org.eclipse.papyrus.decoration.util.IDecoration;


// TODO: Auto-generated Javadoc
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
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 */

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 * Instantiates a new decoration service.
	 */
	public DecorationService() {
		System.out.println("DecorationService created");
	}

	/**
	 * Start service.
	 * 
	 * @throws ServiceException
	 *         the service exception
	 * @see org.eclipse.papyrus.decoration.IDecorationService#startService()
	 */

	public void startService() throws ServiceException {
		System.out.println("DecorationService started");

	}

	/**
	 * Dispose service.
	 * 
	 * @throws ServiceException
	 *         the service exception
	 * @see org.eclipse.papyrus.decoration.IDecorationService#disposeService()
	 */

	public void disposeService() throws ServiceException {
		System.out.println("DecorationService stoped");

	}

	//Notify all Listeners when a marker has been added or removed
	/**
	 * Notify listeners.
	 * 
	 * @param decorationService
	 *        the decoration service
	 * @see org.eclipse.papyrus.decoration.IDecorationService#notifyListeners(org.eclipse.papyrus.decoration.DecorationService)
	 */

	public void notifyListeners(DecorationService decorationService) {
		setChanged();
		notifyObservers(decorationService);
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
	 * @see org.eclipse.papyrus.decoration.IDecorationService#addListener(java.util.Observer)
	 */

	public synchronized void addListener(Observer o) {
		addObserver(o);
	}

	/**
	 * Delete listener.
	 * 
	 * @param o
	 *        the o
	 * @see org.eclipse.papyrus.decoration.IDecorationService#deleteListener(java.util.Observer)
	 */

	public synchronized void deleteListener(Observer o) {
		deleteObserver(o);
	}

	/**
	 * Removes the decoration.
	 * 
	 * @param id
	 *        the id
	 * @see org.eclipse.papyrus.decoration.IDecorationService#removeDecoration(java.lang.String)
	 */

	public void removeDecoration(String id) {

		if(decorations.get(id) != null) {
			decorations.remove(id);
		}
		notifyListeners(this);
	}

	/**
	 * Adds the decoration.
	 * 
	 * @param id
	 *        the id
	 * @param element
	 *        the element
	 * @param severity
	 *        the severity
	 * @param message
	 *        the message
	 * @see org.eclipse.papyrus.decoration.IDecorationService#addDecoration(java.lang.String, org.eclipse.emf.ecore.EObject, int, java.lang.String)
	 */

	public void addDecoration(String id, EObject element, int severity, String message) {

		if(decorations.get(id) == null) {
			decorations.put(id, new Decoration(id, severity, message, element));
		}
		notifyListeners(this);

	}



	/**
	 * Adds the decoration.
	 * 
	 * @param id
	 *        the id
	 * @param element
	 *        the element
	 * @param decoration
	 *        the decoration
	 * @param message
	 *        the message
	 * @see org.eclipse.papyrus.decoration.IDecorationService#addDecoration(java.lang.String, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.jface.resource.ImageDescriptor, java.lang.String)
	 */

	public void addDecoration(String id, EObject element, ImageDescriptor decoration, String message) {

		if(decorations.get(id) == null) {
			decorations.put(id, new Decoration(id, decoration, message, element));
		}
		notifyListeners(this);
	}

	/**
	 * Gets the decoration.
	 * 
	 * @param element
	 *        the element
	 * @param navigateToParents
	 *        the navigate to parents
	 * @return the decoration
	 * @see org.eclipse.papyrus.decoration.IDecorationService#getDecoration(java.lang.Object, boolean)
	 */

	public IDecoration getDecoration(Object element, boolean navigateToParents) {
		DecorationUtils tool = new DecorationUtils(element);
		tool.tryChildIfEmpty();
		return tool.getDecoration(this, navigateToParents);
	}


}
