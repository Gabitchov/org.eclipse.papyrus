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
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockReferenceCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPartCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockValueCompartmentEditPart;

/** FIXME : ClassifierFigure to be corrected to support inheritance */
public class BlockFigure extends ClassifierFigure {

	public BlockFigure() {
		super();
	}

	protected void createContentPane(List<String> compartments) {
		super.createContentPane(updateCompartment(compartments));
	}

	private List<String> updateCompartment(List<String> compartments) {
		compartments.add(BlockConstraintCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(BlockPartCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(BlockReferenceCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(BlockValueCompartmentEditPart.COMPARTMENT_NAME);
		return compartments;
	}

	public IFigure getBlockConstraintCompartmentFigure() {
		return getCompartment(BlockConstraintCompartmentEditPart.COMPARTMENT_NAME);
	}
	
	public IFigure getBlockPartCompartmentFigure() {
		return getCompartment(BlockPartCompartmentEditPart.COMPARTMENT_NAME);
	}
	
	public IFigure getBlockReferenceCompartmentFigure() {
		return getCompartment(BlockReferenceCompartmentEditPart.COMPARTMENT_NAME);
	}
	
	public IFigure getBlockValueCompartmentFigure() {
		return getCompartment(BlockValueCompartmentEditPart.COMPARTMENT_NAME);
	}
}
