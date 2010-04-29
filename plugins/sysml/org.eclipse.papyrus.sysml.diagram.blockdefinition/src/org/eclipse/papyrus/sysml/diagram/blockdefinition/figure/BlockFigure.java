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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.figure;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.diagram.common.figure.node.ClassifierFigure;

/** FIXME : ClassifierFigure to be corrected to support inheritance */
public class BlockFigure extends ClassifierFigure {

	/** The NestedClassifier Compartment */
	private final static String BLOC_CONSTRAINT_COMPARTMENT = "blockConstraintCompartment";

	public BlockFigure() {
		super();
	}

	protected void createContentPane(List<String> compartments) {
		super.createContentPane(updateCompartment(compartments));

	}

	private List<String> updateCompartment(List<String> compartments) {
		compartments.add(BLOC_CONSTRAINT_COMPARTMENT);
		return compartments;
	}

	public IFigure getBlockConstraintCompartmentFigure() {
		return getCompartment(BLOC_CONSTRAINT_COMPARTMENT);
	}
}
