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
package org.eclipse.papyrus.uml.service.types.filter;

import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * Interface for creation command filter.
 */
public interface ICommandFilter {

	/**
	 * Get the list of element type for which the creation command is visible.
	 * 
	 * @return the list of allowed element types.
	 */
	public List<IElementType> getVisibleCommands();

}
