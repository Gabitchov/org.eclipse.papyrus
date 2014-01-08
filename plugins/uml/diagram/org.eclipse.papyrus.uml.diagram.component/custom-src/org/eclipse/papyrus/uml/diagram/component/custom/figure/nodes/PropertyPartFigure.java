/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST)- Initial API and implementation
 /*****************************************************************************/

package org.eclipse.papyrus.uml.diagram.component.custom.figure.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;

/**
 * Figure for Composite representation of Class.
 */
public class PropertyPartFigure extends CompartmentFigure {

	/** The Internal Structure Compartment */
	private final static String COMPOSITE_COMPARTMENT = "compositeCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(COMPOSITE_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor
	 */
	public PropertyPartFigure() {
		this(null);
	}

	/**
	 * Create a new Classifier figure with the given tag
	 * 
	 * @param tagLabel
	 *        a String that will be displayed at the top of the figure
	 */
	public PropertyPartFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
	}

	/**
	 * Get the attribute's compartment figure
	 * 
	 * @return
	 */
	public IFigure getCompositeCompartmentFigure() {
		return getCompartment(COMPOSITE_COMPARTMENT);
	}
}
