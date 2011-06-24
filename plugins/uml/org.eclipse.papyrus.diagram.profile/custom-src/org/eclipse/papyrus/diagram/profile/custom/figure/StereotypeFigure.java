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
 *    Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.figure;

import org.eclipse.papyrus.diagram.common.figure.node.ClassifierFigure;

/**
 * Figure for representation of Stereotype
 */
public class StereotypeFigure extends ClassifierFigure {

	/**
	 * the tag
	 */
	private static String TAG_LABEL = "Stereotype"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public StereotypeFigure() {
		super(TAG_LABEL);

	}
}
