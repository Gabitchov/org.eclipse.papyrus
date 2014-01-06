/*****************************************************************************
 * Copyright (c) 2009 - 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies;

import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing
 * UML elements.
 */
public class PortLabelEditPolicy extends PropertyLabelEditPolicy{

	/**
	 * Gets the default display value.
	 * 
	 * @return the default display value {@inheritDoc}
	 */
	public int getDefaultDisplayValue() {
		return ICustomAppearence.DISP_NAME;
	}
}
