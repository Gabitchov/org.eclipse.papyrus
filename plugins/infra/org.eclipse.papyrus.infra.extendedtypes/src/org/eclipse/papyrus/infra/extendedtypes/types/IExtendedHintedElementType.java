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
package org.eclipse.papyrus.infra.extendedtypes.types;

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration;


/**
 * Element Type that contains a configuration for extensions (Pre/Post actions and validation) 
 */
public interface IExtendedHintedElementType extends ISpecializationType, IHintedType {
	
	/**
	 * Returns the Element Type configuration associated to the element type.
	 * @return the Element Type configuration associated to the element type.
	 */
	public ExtendedElementTypeConfiguration getConfiguration();
}
