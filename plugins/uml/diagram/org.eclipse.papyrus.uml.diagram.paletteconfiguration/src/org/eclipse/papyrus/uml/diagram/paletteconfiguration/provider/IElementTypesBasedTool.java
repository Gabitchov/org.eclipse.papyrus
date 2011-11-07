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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider;

import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;

/**
 * Tool based on element types
 */
public interface IElementTypesBasedTool {

	/**
	 * Returns the list of element types created by this tool
	 * @return the list of element types created by this tool
	 */
	public List<IElementType> getElementTypes();
	
	/**
	 * Returns the list of Element descriptors created by this tool
	 * @return the list of Element descriptors created by this tool
	 */
	public List<ElementDescriptor> getElementDescriptors();
}
