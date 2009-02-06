/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.sash;

/**
 * Implementation of this interface allows to create ITilePart nodes.
 * 
 * @author dumoulin
 * 
 */
public interface ITilePartFactory <T> {

	/**
	 * Create the ITilePart node suitable for the specified model. The node is attached to the specified parent.
	 * 
	 * @param parent
	 * @param model
	 * @return sashwindow.proposedArch.TilePart
	 */
	public ITilePart<T> createTilePart(ITilePart<T> parent, T model);

}