/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An adapter type for {@link EditingDomain}s and {@link ResourceSet}s that
 * support querying read/write permissions on the object level (not just the
 * resource level).
 */
public interface IReadOnlyProvider {

	/**
	 * Queries whether an object is read-only, which might be an individual
	 * state independent of any read/write controls on its resource.
	 * 
	 * @param eObject
	 *            an object
	 * 
	 * @return whether the object is read-only
	 */
	boolean isReadOnly(EObject eObject);
}
