/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.util.Map;

import org.eclipse.core.runtime.IPath;


public interface IVersionableModel extends IModel {

	/**
	 * Saves a copy of this model to the specified path. The model itself
	 * shouldn't be modified in the operation
	 * 
	 * @param targetWithoutExtension
	 */
	public void saveCopy(IPath targetPathWithoutExtension, Map<Object, Object> targetMap);

	public void fillTargetMap(IPath targetPathWithoutExtension, Map<Object, Object> targetMap);
}
