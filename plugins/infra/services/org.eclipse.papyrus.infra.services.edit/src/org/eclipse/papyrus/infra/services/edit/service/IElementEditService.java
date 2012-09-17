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
package org.eclipse.papyrus.infra.services.edit.service;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * <pre>
 * 
 * This interface provide the public API for edit service in Papyrus.
 * 
 * Currently the implementation mostly rely on GMF extensible type framework,
 * which was used as the basis to identify methods in this interface (also, it is 
 * currently the only proposed implementation of the edit service for Papyrus.
 * 
 * @see org.eclipse.gmf.runtime.emf.type.core.IElementType
 * 
 * </pre>
 */
public interface IElementEditService extends IAdaptable {

	/**
	 * <pre>
	 * 
	 * Test if the service can fulfill the request in parameter.
	 * 
	 * @see {@link IElementType#canEdit(IEditCommandRequest)}
	 * 
	 * @param req the edit request
	 * @return true if the service can fulfill the request in parameter
	 * 
	 * </pre>
	 */
	public boolean canEdit(IEditCommandRequest req);

	/**
	 * <pre>
	 * 
	 * Get the edit command that fulfills the edit request 
	 * 
	 * @see {@link IElementType#getEditCommand(IEditCommandRequest)}
	 * 
	 * @param request the edit request 
	 * @return the edit command
	 * 
	 * </pre>
	 */
	public ICommand getEditCommand(IEditCommandRequest request);

	/**
	 * <pre>
	 * 
	 * Get the display name associated to the element related to the edit service.
	 * 
	 * @see {@link IElementType#getDisplayName()}
	 * 
	 * @return the display name
	 * 
	 * </pre>
	 */
	public String getDisplayName();

}
