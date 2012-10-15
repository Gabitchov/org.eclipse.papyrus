/*****************************************************************************
 * Copyright (c) 2012 ATOS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Olivier Mélois (ATOS) - Initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.figure;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;

public class RequirementFigure extends ClassifierFigure {

	/** The Attribute Compartment */
	private final static String ATTRIBUTE_COMPARTMENT = "attributeCompartment";

	/** The Operation Compartment */
	private final static String OPERATION_COMPARTMENT = "operationCompartment";

	/** The NestedClassifier Compartment */
	private final static String NESTEDCLASSIFIER_COMPARTMENT = "nestedClassifierCompartment";

	/** The RequirementIdInformation Compartment */
	private final static String REQUIREMENT_ID_INFO_COMPARTMENT = "requirementIdInformationCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(ATTRIBUTE_COMPARTMENT);
			add(OPERATION_COMPARTMENT);
			add(NESTEDCLASSIFIER_COMPARTMENT);
			add(REQUIREMENT_ID_INFO_COMPARTMENT);
		}
	};

	public RequirementFigure() {
		super();
		createContentPane(COMPARTMENT);
	}


	public IFigure getRequirementIdInformationCompartmentFigure() {
		return getCompartment(REQUIREMENT_ID_INFO_COMPARTMENT);
	}
}
