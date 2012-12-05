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
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.figure.ConstraintBlockFigure;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;

public class ConstraintBlockEditPart extends AbstractElementEditPart {

	public ConstraintBlockEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		// Start of user code custom policies
		// End of user code
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ConstraintBlockLabelNameEditPart) {
			((ConstraintBlockLabelNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof ParameterCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getParameterCompartmentFigure();
			setupContentPane(pane);
			pane.add(((ParameterCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockConstraintCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockConstraintCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ConstraintBlockLabelNameEditPart) {
			return true;
		}
		if(childEditPart instanceof ParameterCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getParameterCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((ParameterCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockConstraintCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockConstraintCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof ParameterCompartmentEditPart) {
			return getPrimaryShape().getParameterCompartmentFigure();
		}
		if(editPart instanceof BlockConstraintCompartmentEditPart) {
			return getPrimaryShape().getBlockConstraintCompartmentFigure();
		}
		return getContentPane();
	}

	//	public EditPart getTargetEditPart(Request request) {
	//		if(request instanceof CreateViewAndElementRequest) {
	//			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
	//			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
	//			if(type == CustomBlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN) {
	//				return getChildBySemanticHint(CustomBlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT);
	//			}
	//		}
	//		return super.getTargetEditPart(request);
	//	}
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new ConstraintBlockFigure();
	}

	@Override
	public ConstraintBlockFigure getPrimaryShape() {
		return (ConstraintBlockFigure)primaryShape;
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(SysMLGraphicalTypes.LABEL_SYSML_CONSTRAINTBLOCK_NAME_ID);
	}
}
