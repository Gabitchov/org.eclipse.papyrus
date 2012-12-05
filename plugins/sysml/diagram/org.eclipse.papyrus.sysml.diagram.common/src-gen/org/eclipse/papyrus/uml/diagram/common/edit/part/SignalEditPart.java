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
package org.eclipse.papyrus.uml.diagram.common.edit.part;

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
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.SignalFigure;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class SignalEditPart extends AbstractElementEditPart {

	public SignalEditPart(View view) {
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
		if(childEditPart instanceof NamedElementNodeLabelNameEditPart) {
			((NamedElementNodeLabelNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof PropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPropertyCompartmentFigure();
			setupContentPane(pane);
			pane.add(((PropertyCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof OperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane);
			pane.add(((OperationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof NamedElementNodeLabelNameEditPart) {
			return true;
		}
		if(childEditPart instanceof PropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPropertyCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((PropertyCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof OperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((OperationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof PropertyCompartmentEditPart) {
			return getPrimaryShape().getPropertyCompartmentFigure();
		}
		if(editPart instanceof OperationCompartmentEditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
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
		return primaryShape = new SignalFigure();
	}

	@Override
	public SignalFigure getPrimaryShape() {
		return (SignalFigure)primaryShape;
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLGraphicalTypes.LABEL_UML_NAMEDELEMENT_NAME_ID);
	}
}
