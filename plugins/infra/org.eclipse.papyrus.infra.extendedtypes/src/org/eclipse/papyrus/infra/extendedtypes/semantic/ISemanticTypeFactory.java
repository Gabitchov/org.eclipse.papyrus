/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.semantic;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * Interface that must be implemented by each factory relying on the semanticTypeFactory extension point. 
 */
public interface ISemanticTypeFactory {

	/** creates the element type from the given configuration */
	IElementType createElementType();
}
