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
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.custom.figure.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.Rectangular3DBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class NodeFigure.
 */
public class NodeFigure extends CompartmentFigure {

	/** The Internal Structure Compartment. */
	private final static String COMPOSITE_COMPARTMENT = "compositeCompartment";

	/** The effectborder. */
	private final LineBorder effectborder;

	/* to present the class as an active class */
	/** The active. Default value is false */
	private boolean active = false;

	/** The List of Compartment. */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(COMPOSITE_COMPARTMENT);
		}
	};

	/**
	 * Instantiates a new node figure.
	 */
	public NodeFigure() {
		this("node");
	}

	/**
	 * Instantiates a new node figure.
	 * 
	 * @param tagvalue
	 *        the tagvalue
	 */
	public NodeFigure(String tagvalue) {
		super(COMPARTMENT, tagvalue);
		effectborder = new Rectangular3DBorder(19, getForegroundColor());
		setBorder(getBorderedFigure(), effectborder);
	}

	/**
	 * Gets the composite compartment figure.
	 * 
	 * @return the composite compartment figure
	 */
	public IFigure getCompositeCompartmentFigure() {
		return getCompartment(COMPOSITE_COMPARTMENT);
	}

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	// @unused
	public boolean isActive() {
		return active;
	}

	/**
	 * Set the active
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
