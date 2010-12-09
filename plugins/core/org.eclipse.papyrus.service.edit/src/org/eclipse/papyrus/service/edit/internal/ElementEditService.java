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

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * <pre>
 * 
 * This class implements {@link IElementEditService}.
 * 
 * @see org.eclipse.papyrus.service.edit.service.IElementEditService
 * 
 * This class is the service in charge of providing edit command for
 * a specific type of element.
 * 
 * This class relies for a large part on the GMF ExtensibleType framework,
 * mostly as a wrapper of {@link IElementType} for Papyrus. No added value 
 * for Papyrus is expected in using this wrapper, except the fact that it ensures
 * Papyrus shared {@link IClientContext} is always explicitly used or set in 
 * request while retrieving commands.
 * 
 * </pre>
 */
public class ElementEditService implements IElementEditService {

	/** The registered {@link IElementType} used to provide edit commands. */
	protected IElementType elementType;

	/** Papyrus shared {@link IClientContext} */
	protected IClientContext sharedClientContext;

	/**
	 * <pre>
	 * 
	 * Constructor.
	 * 
	 * @param elementType the {@link IElementType} this service will use to provide edit commands
	 * @param sharedClientContext the shared {@link IClientContext}
	 * 
	 * </pre>
	 */
	public ElementEditService(IElementType elementType, IClientContext sharedClientContext) {
		super();
		this.elementType = elementType;
		this.sharedClientContext = sharedClientContext;
	}

	/**
	 * <pre>
	 * 
	 * This method creates an edit command in response to an edit request.
	 * This method directly uses the ElementType framework (through {@link IElementType} api,
	 * making sure that the Papyrus shared {@link IClientContext} is explicitly set in the request.
	 * 
	 * @see org.eclipse.papyrus.service.edit.service.IElementEditService#getEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request the edit request
	 * @return the edit command corresponding to the edit request
	 * 
	 * </pre>
	 */
	public ICommand getEditCommand(IEditCommandRequest request) {
		// Make sure the share client context in passed in the request
		request.setClientContext(sharedClientContext);

		// Retrieve the desired edit command using GMF ExtensibleType API
		ICommand editCommand = elementType.getEditCommand(request);

		return editCommand;
	}

	/**
	 * <pre>
	 * 
	 * Get the display name of the element type.
	 * 
	 * @see org.eclipse.papyrus.service.edit.service.IElementEditService#getDisplayName()
	 * 
	 * @return the display name of the {@link IElementType} used by current service.
	 * 
	 * </pre>
	 */
	public String getDisplayName() {
		return elementType.getDisplayName();
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * 
	 * @param adapter
	 * @return the adapted object
	 */
	public Object getAdapter(Class adapter) {
		if(adapter == IElementType.class) {
			return elementType;
		}
		return null;
	}

	/**
	 * <pre>
	 * 
	 * Test if current service can provide an edit command in response to the request.
	 * 
	 * @see org.eclipse.papyrus.service.edit.service.IElementEditService#canEdit(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param req the edit request to test
	 * @return true is this service can provide edit command for the request
	 * 
	 * </pre>
	 */
	public boolean canEdit(IEditCommandRequest req) {
		// Make sure the share client context in passed in the request
		req.setClientContext(sharedClientContext);

		return elementType.canEdit(req);
	}
}
