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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;

/**
 * Figure for Composite representation of InformationItem.
 */
public class InformationItemFigure extends CompartmentFigure {

	/** Value of the textual tag added to the figure. */
	private static String TAG_LABEL = "Information"; //$NON-NLS-1$

	/** The List of Compartment */
	private final static List<String> NO_COMPARTMENT = new ArrayList<String>();

	/**
	 * Creates a new InformationItemFigure.
	 */
	public InformationItemFigure() {
		super(NO_COMPARTMENT, TAG_LABEL);
	}
}
