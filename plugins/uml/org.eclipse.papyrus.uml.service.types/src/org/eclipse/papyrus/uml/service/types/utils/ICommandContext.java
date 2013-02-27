/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Interface for creation command context holder.
 */
public interface ICommandContext {

	/**
	 * Get the container of the created element.
	 * 
	 * @return the container.
	 */
	public EObject getContainer();

	/**
	 * Get the reference the created element relates.
	 * 
	 * @return the EReference.
	 */
	public EReference getReference();
}
