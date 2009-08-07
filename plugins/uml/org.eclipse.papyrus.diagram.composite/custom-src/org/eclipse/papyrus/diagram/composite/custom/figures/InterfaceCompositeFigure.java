/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.composite.custom.figures;

/**
 * Figure for Composite representation of Class.
 */
public class InterfaceCompositeFigure extends CompositeFigure {

	private static String TAG_LABEL_INTERFACE = "Interface";

	public InterfaceCompositeFigure() {
		super();

		// Add an "Interface" tag on this figure
		createTagLabel(TAG_LABEL_INTERFACE);
	}
}
