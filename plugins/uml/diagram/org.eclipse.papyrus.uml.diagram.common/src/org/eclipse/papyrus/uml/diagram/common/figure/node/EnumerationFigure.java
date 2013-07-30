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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;

/**
 * Represents an enumeration
 */
public class EnumerationFigure extends CompartmentFigure {

	/** The Literals Compartment */
	private static final String LITERALS_COMPARTMENT = "literalsCompartment";

	/** The list of compartments */
	private static final List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = -3949666242905478564L;

		{
			add(LITERALS_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor
	 */
	public EnumerationFigure() {
		super(COMPARTMENT, "Enumeration");
	}

	/**
	 * Get the EnumerationLiteral's compartment figure.
	 * 
	 * @return
	 */
	public IFigure getEnumerationLiteralCompartmentFigure() {
		return getCompartment(LITERALS_COMPARTMENT);
	}

}
