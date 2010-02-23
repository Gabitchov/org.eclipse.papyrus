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
package org.eclipse.papyrus.diagram.common.figure.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;

/**
 * Represents a classifier.
 */
public class ClassifierFigure extends CompartmentFigure {

	/* to present the class as an active class */
	/** The active. Default value is false */
	private boolean active = false;

	/** The Attribute Compartment */
	private final static String ATTRIBUTE_COMPARTMENT = "attributeCompartment";

	/** The Operation Compartment */
	private final static String OPERATION_COMPARTMENT = "operationCompartment";

	/** The NestedClassifier Compartment */
	private final static String NESTEDCLASSIFIER_COMPARTMENT = "nestedClassifierCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(ATTRIBUTE_COMPARTMENT);
			add(OPERATION_COMPARTMENT);
			add(NESTEDCLASSIFIER_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor
	 */
	public ClassifierFigure() {
		this(null);
	}

	/**
	 * Create a new Classifier figure with the given tag
	 * 
	 * @param tagLabel
	 *        a String that will be displayed at the top of the figure
	 */
	public ClassifierFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
	}

	/**
	 * Get the attribute's compartment figure
	 * 
	 * @return
	 */
	public IFigure getAttributeCompartmentFigure() {
		return getCompartment(ATTRIBUTE_COMPARTMENT);
	}

	/**
	 * Get the Operation's compartment figure
	 * 
	 * @return
	 */
	public IFigure getOperationCompartmentFigure() {
		return getCompartment(OPERATION_COMPARTMENT);
	}

	/**
	 * Get the NestedClassifier's compartment figure
	 * 
	 * @return
	 */
	public IFigure getNestedClassifierFigure() {
		return getCompartment(NESTEDCLASSIFIER_COMPARTMENT);
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
