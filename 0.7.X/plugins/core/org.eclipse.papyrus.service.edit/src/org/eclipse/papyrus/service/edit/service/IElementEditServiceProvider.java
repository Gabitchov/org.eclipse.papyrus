/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.service.edit.service;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.service.edit.internal.ElementEditServiceProvider;

/**
 * <pre>
 * 
 * This interface shows a public API for accessing edit service related to model elements.
 * 
 * Class implementing this interface: 
 * @see ElementEditServiceProvider
 * 
 * </pre>
 */
public interface IElementEditServiceProvider {

	/**
	 * <pre>
	 * 
	 * Get the registered edit service for the object in parameter
	 * 
	 * @param objectToEdit the object to edit (an EObject of EClass)
	 * @return the edit service
	 * @throws ServiceException
	 * </pre>
	 */
	public IElementEditService getEditService(Object objectToEdit) throws ServiceException;

	/**
	 * <pre>
	 * 
	 * Get the edit services for any element registered that are possibly contained by the owner under
	 * the desired containment reference.
	 * 
	 * @param owner the owner or the element to edit
	 * @param containmentReference the containment reference
	 * @return a list of edit services
	 * @throws ServiceException
	 * </pre>
	 */
	public List<IElementEditService> getContainedTypeEditServices(EObject owner, EReference containmentReference) throws ServiceException;

}
