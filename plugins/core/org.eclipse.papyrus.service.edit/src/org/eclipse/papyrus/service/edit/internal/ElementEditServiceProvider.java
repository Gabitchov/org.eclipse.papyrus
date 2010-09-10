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
package org.eclipse.papyrus.service.edit.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.service.edit.context.TypeContext;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.service.edit.service.IElementEditServiceProvider;

/**
 * <pre>
 * 
 * This provider wrap {@link ElementTypeRegistry} especially to provide a Papyrus-like 
 * service provider.
 * This class is a singleton that may be access directly or via Papyrus service registry.
 * Note that this provider does not necessary need Papyrus to be the active editor to be available
 * (it relies on {@link ElementTypeRegistry} which is independant from Papyrus.
 * 
 * It is registered as Papyrus service with the {@link ElementEditServiceProviderFactory}.
 * 
 * </pre>
 */
public class ElementEditServiceProvider implements IElementEditServiceProvider {

	/** Papyrus shared {@link IClientContext} */
	protected IClientContext sharedClientContext;

	/** Singleton instance */
	private static IElementEditServiceProvider instance;

	/** Default constructor */
	private ElementEditServiceProvider() throws ServiceException {
		this.sharedClientContext = TypeContext.getContext();
	}

	/** Get singleton instance */
	public static synchronized IElementEditServiceProvider getInstance() throws ServiceException {
		if(instance == null) {
			instance = new ElementEditServiceProvider();
		}

		return instance;
	}

	/**
	 * <pre>
	 * 
	 * This method try to retrieve the correct edit service for an object.
	 * 
	 * It relies on GMF {@link ElementTypeRegistry} which provides the {@link IElementType} registered 
	 * in the Extensible type framework for the object passed in parameter. The found element type is returned
	 * wrapped as an {@link IElementEditService}.
	 * 
	 * The {@link IElementType} are registered in separate plug-ins (e.g. oep.uml.service.types for all types
	 * related to UML metaclasses). 
	 * 
	 * @see org.eclipse.papyrus.service.edit.service.IElementEditServiceProvider#getEditService(java.lang.Object)
	 * 
	 * @param objectToEdit the object for which this method tries to retrieve an edit service
	 * @return the {@link IElementEditService} for the passed object
	 * @throws ServiceException
	 * 
	 * </pre>
	 */
	public IElementEditService getEditService(Object objectToEdit) throws ServiceException {

		if(!(objectToEdit instanceof EObject) && !(objectToEdit instanceof EClass)) {
			throw new ServiceException("EObject or EClass expected in method parameter.");
		}

		IElementType elementType = null;

		if(objectToEdit instanceof EObject) {
			elementType = ElementTypeRegistry.getInstance().getElementType((EObject)objectToEdit, sharedClientContext);
		}

		if(objectToEdit instanceof EClass) {
			elementType = ElementTypeRegistry.getInstance().getElementType((EClass)objectToEdit, sharedClientContext);
		}

		if(elementType == null) {
			throw new ServiceException("No IElementType bound to Papyrus shared client context for " + objectToEdit + ".");
		}

		return new ElementEditService(elementType, sharedClientContext);
	}

	/**
	 * <pre>
	 * 
	 * This method returns the registered {@link IElementType} (wrapped as {@link IElementEditService}) that may be contained by
	 * the eContainer parameter for the specific reference parameter.
	 * 
	 * @see org.eclipse.papyrus.service.edit.service.IElementEditServiceProvider#getContainedTypeEditServices(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference)
	 * 
	 * @param eContainer
	 * @param reference
	 * @return the list of possibly contained {@link IElementEditService}
	 * @throws ServiceException
	 * </pre>
	 */
	public List<IElementEditService> getContainedTypeEditServices(EObject eContainer, EReference reference) throws ServiceException {
		List<IElementEditService> services = new ArrayList<IElementEditService>();

		for(IElementType type : ElementTypeRegistry.getInstance().getContainedTypes(eContainer, reference)) {
			services.add(new ElementEditService(type, sharedClientContext));
		}

		return services;
	}
}
