/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.figure;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.PartPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ReferencePropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ValuePropertyCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.OperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;

public class BlockFigure extends ClassifierFigure {

	public BlockFigure() {
		super("block"); //$NON-NLS-1$
	}

	protected void createContentPane(List<String> compartments) {
		super.createContentPane(getUpdatedListOfCompartments(compartments));
	}

	/**
	 * Get the list of compartments, updated with specific ones
	 * 
	 * @param compartments
	 *        the original list of compartments (untouched)
	 * @return the new completed list of compartments
	 */
	private List<String> getUpdatedListOfCompartments(List<String> compartments) {
		compartments = new ArrayList<String>(compartments);
		compartments.add(BlockPropertyCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(PartPropertyCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(ReferencePropertyCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(PortCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(FlowPortCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(OperationCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(BlockConstraintCompartmentEditPart.COMPARTMENT_NAME);
		compartments.add(ValuePropertyCompartmentEditPart.COMPARTMENT_NAME);
		return compartments;
	}

	public IFigure getBlockPropertyCompartmentFigure() {
		return getCompartment(BlockPropertyCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getPartPropertyCompartmentFigure() {
		return getCompartment(PartPropertyCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getReferencePropertyCompartmentFigure() {
		return getCompartment(ReferencePropertyCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getPortCompartmentFigure() {
		return getCompartment(PortCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getFlowPortCompartmentFigure() {
		return getCompartment(FlowPortCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getOperationCompartmentFigure() {
		return getCompartment(OperationCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getBlockConstraintCompartmentFigure() {
		return getCompartment(BlockConstraintCompartmentEditPart.COMPARTMENT_NAME);
	}

	public IFigure getValuePropertyCompartmentFigure() {
		return getCompartment(ValuePropertyCompartmentEditPart.COMPARTMENT_NAME);
	}
}
