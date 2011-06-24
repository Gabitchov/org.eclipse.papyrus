/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.draw2d;

/**
 * Constraint to use with {@link CenteredColumnLayout}. Specifies whether figure fills extra space
 */
public class CenteredColumnConstraint {

	private boolean fill;

	/**
	 * Constructor.
	 * 
	 * @param fillAvailableSpace
	 *        whether available space is filled by this figure
	 */
	public CenteredColumnConstraint(boolean fillAvailableSpace) {
		fill = fillAvailableSpace;
	}

	public boolean isAvailableSpaceFilled() {
		return fill;
	}

}
