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
package org.eclipse.papyrus.cdo.core.importer;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

/**
 * This is the IModelTransferNode type. Enjoy.
 */
public interface IModelTransferNode {

	String getName();

	URI getPrimaryResourceURI();

	Collection<URI> getResourceURIs();

	Collection<IModelTransferNode> getDependencies();

	Collection<IModelTransferNode> getDependents();

	/**
	 * Queries whether an{@code other} node represents a model sub-unit of me.
	 * 
	 * @param other
	 *        another model unit
	 * 
	 * @return whether the {@code other} it is a logical model sub-unit of me
	 */
	boolean isModelSubUnit(IModelTransferNode other);

	/**
	 * Queries whether an{@code other} node represents my model super-unit.
	 * 
	 * @param other
	 *        another model unit
	 * 
	 * @return whether the {@code other} it is the logical model super-unit of me
	 */
	boolean isModelParentUnit(IModelTransferNode other);
}
