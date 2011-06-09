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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.figures;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.diagram.common.figure.node.ClassifierFigure;


public class BlockFigure extends ClassifierFigure {

	/** The Constraint Compartment */
	private final static String CONSTRAINT_COMPARTMENT = "constraintCompartment";

	/** The Reference Compartment */
	private final static String REFERENCE_COMPARTMENT = "referenceCompartment";

	/** The Value Compartment */
	private final static String PART_COMPARTMENT = "partCompartment";

	/** The Value Compartment */
	private final static String VALUE_COMPARTMENT = "valueCompartment";

	public BlockFigure() {
		super();
	}

	/**
	 * 
	 * @param compartmentFigure
	 */
	protected void createContentPane(List<String> compartments) {
		super.createContentPane(updateCompartment(compartments));

	}

	private List<String> updateCompartment(List<String> compartments) {
		compartments.add(CONSTRAINT_COMPARTMENT);
		compartments.add(REFERENCE_COMPARTMENT);
		compartments.add(PART_COMPARTMENT);
		compartments.add(VALUE_COMPARTMENT);
		return compartments;
	}

	/**
	 * Get the constraint's compartment figure
	 * 
	 * @return
	 */
	public IFigure getConstraintCompartmentFigure() {
		return getCompartment(CONSTRAINT_COMPARTMENT);
	}

	/**
	 * Get the Reference's compartment figure
	 * 
	 * @return
	 */
	public IFigure getReferenceCompartmentFigure() {
		return getCompartment(REFERENCE_COMPARTMENT);
	}

	/**
	 * Get the Part's compartment figure
	 * 
	 * @return
	 */
	public IFigure getPartCompartmentFigure() {
		return getCompartment(PART_COMPARTMENT);
	}

	/**
	 * Get the Value's compartment figure
	 * 
	 * @return
	 */
	public IFigure getValueCompartmentFigure() {
		return getCompartment(VALUE_COMPARTMENT);
	}
}
