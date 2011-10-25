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
import org.eclipse.ui.ISelectionListener;

/**
 * This class provides the toggle state for the Oblique Line Style
 * 
 * 
 * 
 */
public class ObliqueToggleState extends AbstractLineStyleToggleState implements ISelectionListener {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ObliqueToggleState() {
		super(LineStyleAction.OBLIQUE);
	}
}
