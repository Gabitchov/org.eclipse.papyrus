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
 * A specific parser for displaying the selection behavior associated to an object node.
 */
public class ObjectNodeSelectionParser extends AssociatedBehaviorParser {

	/** The format for displaying Data Store selection */
	private static final String SELECTION_FORMAT = "<<selection>>".concat(System.getProperty("line.separator")).concat("%s");

	/**
	 * Get the format for displaying Input decision
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.parser.custom.AssociatedBehaviorParser#getFormatString()
	 * @return format string
	 */
	@Override
	protected String getFormatString() {
		return SELECTION_FORMAT;
	}

	/**
	 * Get the feature referencing the decision input
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.parser.custom.AssociatedBehaviorParser#getReferenceFeature()
	 * @return feature
	 */
	@Override
	protected EStructuralFeature getReferenceFeature() {
		return UMLPackage.eINSTANCE.getObjectNode_Selection();
	}

}
