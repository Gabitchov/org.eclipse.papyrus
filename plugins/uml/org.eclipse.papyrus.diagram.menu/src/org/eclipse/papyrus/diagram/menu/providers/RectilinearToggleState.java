/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.providers;

import org.eclipse.papyrus.diagram.menu.actions.LineStyleAction;

/**
 * This class provides the toggle state for the Rectilinear Line Style
 * 
 * 
 * 
 */
public class RectilinearToggleState extends AbstractLineStyleToggleState {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RectilinearToggleState() {
		super(LineStyleAction.RECTILINEAR);
	}

}
