/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.strategy;

import org.eclipse.swt.graphics.Image;

/**
 * A strategy to be applied when pasting elements
 */

public interface IStrategy {

	/**
	 * A user-readable label
	 * 
	 * @return
	 */
	public String getLabel();

	/**
	 * A user-readable description
	 * 
	 * @return
	 */
	public String getDescription();

	/**
	 * An image to associate to this strategy
	 * 
	 * @return
	 */
	public Image getImage();

	/**
	 * A unique ID for this strategy
	 * 
	 * @return
	 */
	public String getID();	
	
	// TODO Remove that
	/**
	 * The default priority for this strategy. Might be overridden by a user
	 * preference.
	 * 
	 * @return
	 * @deprecated The priority mechanism isn't used anymore
	 */
	@Deprecated
	public int getPriority();
	
	
}
