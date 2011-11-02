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

import java.util.Observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.decoration.util.IDecoration;


// TODO: Auto-generated Javadoc
/**
 * The Interface IDecorationService.
 */
public interface IDecorationService extends IService {

	/**
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	
	void startService() throws ServiceException;

	/**
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	
	void disposeService() throws ServiceException;

	/**
	 * Adds the listener.
	 *
	 * @param o the o
	 */
	void addListener(Observer o);

	/**
	 * Delete listener.
	 *
	 * @param o the o
	 */
	void deleteListener(Observer o);

	/**
	 * Notify listeners.
	 *
	 * @param decorationService the decoration service
	 */
	void notifyListeners(DecorationService decorationService);

	/**
	 * Adds the decoration.
	 *
	 * @param id the id
	 * @param element the element
	 * @param severity the severity
	 * @param message the message
	 */
	void addDecoration(String id, EObject element, int severity, String message);

	/**
	 * Adds the decoration.
	 *
	 * @param id the id
	 * @param element the element
	 * @param decoration the decoration
	 * @param message the message
	 */
	void addDecoration(String id, EObject element, ImageDescriptor decoration, String message);

	/**
	 * Removes the decoration.
	 *
	 * @param id the id
	 */
	void removeDecoration(String id);

	/**
	 * Gets the decoration.
	 *
	 * @param element the element
	 * @param navigateToParents the navigate to parents
	 * @return the decoration
	 */
	IDecoration getDecoration(Object element, boolean navigateToParents);


}
