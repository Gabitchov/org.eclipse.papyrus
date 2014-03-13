/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.figures;

import org.eclipse.draw2d.Graphics;

/**
 * Figure for Composite representation of Collaboration.
 */
public class CollaborationCompositeFigure extends CompositeFigure {

	/**
	 * Value of the textual tag added to the figure.
	 */
	private static String TAG_LABEL = "Collaboration"; //$NON-NLS-1$

	/**
	 * Creates a new CollaborationCompositeFigure.
	 */
	public CollaborationCompositeFigure() {
		super(TAG_LABEL);

		// Use custom dashed borders for Collaboration
		setCustomDash(DEFAULT_CUSTOM_DASH);
		setLineStyle(Graphics.LINE_CUSTOM);
	}
}
