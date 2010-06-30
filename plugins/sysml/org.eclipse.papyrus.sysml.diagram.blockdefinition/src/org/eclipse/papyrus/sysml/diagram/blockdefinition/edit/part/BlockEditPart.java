/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.BlockItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.figure.BlockFigure;

public class BlockEditPart extends ClassEditPart {

	public BlockEditPart(View view) {
		super(view);
	}
	
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockItemSemanticEditPolicy());
	}

	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockConstraintCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockConstraintCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockValueCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockValueCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockValueCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockPartCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockPartCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockPartCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockReferenceCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockReferenceCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockReferenceCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockPropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockPropertyCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		return super.addFixedChild(childEditPart);
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof BlockConstraintCompartmentEditPart) {
			return getPrimaryShape().getBlockConstraintCompartmentFigure();
		} else if(editPart instanceof BlockValueCompartmentEditPart) {
			return getPrimaryShape().getBlockValueCompartmentFigure();
		} else if(editPart instanceof BlockReferenceCompartmentEditPart) {
			return getPrimaryShape().getBlockReferenceCompartmentFigure();
		} else if(editPart instanceof BlockPartCompartmentEditPart) {
			return getPrimaryShape().getBlockPartCompartmentFigure();
		} else if(editPart instanceof BlockPropertyCompartmentEditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}

		return super.getContentPaneFor(editPart);
	}

	protected IFigure createNodeShape() {
		return primaryShape = new BlockFigure();
	}

	public BlockFigure getPrimaryShape() {
		return (BlockFigure)primaryShape;
	}
}
