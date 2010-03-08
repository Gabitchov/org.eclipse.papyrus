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
package org.eclipse.papyrus.diagram.activity.parser.custom;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for displaying the input decision behavior associated to a decision node.
 */
public class InputDecisionParser extends AssociatedBehaviorParser {

	/** The format for displaying Input decision */
	private static final String DECISION_INPUT_FORMAT = "<<decisionInput>>%s";

	/**
	 * Get the format for displaying Input decision
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.parser.custom.AssociatedBehaviorParser#getFormatString()
	 * @return format string
	 */
	@Override
	protected String getFormatString() {
		return DECISION_INPUT_FORMAT;
	}

	/**
	 * Get the feature referencing the decision input
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.parser.custom.AssociatedBehaviorParser#getReferenceFeature()
	 * @return feature
	 */
	@Override
	protected EStructuralFeature getReferenceFeature() {
		return UMLPackage.eINSTANCE.getDecisionNode_DecisionInput();
	}

}
