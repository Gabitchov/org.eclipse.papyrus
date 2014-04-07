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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SelectableBorderedNodeFigure;
import org.eclipse.papyrus.sysml.diagram.common.edit.policy.BlockCompositeSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.figure.BlockFigure;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.OperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.policy.StructuredClassifierCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocator;

public class BlockEditPart extends AbstractElementEditPart {

	public BlockEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockCompositeSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new StructuredClassifierCreationEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AffixedNodeAlignmentEditPolicy());
		// Start of user code custom policies
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new org.eclipse.papyrus.uml.diagram.common.edit.policy.EncapsulatedClassifierResizableShapeEditPolicy());
		// End of user code
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child instanceof IBorderItemEditPart) {
					return new BorderItemResizableEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
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
		if (childEditPart instanceof BlockLabelNameEditPart) {
			((BlockLabelNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if (childEditPart instanceof FlowPortAffixedNodeEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((FlowPortAffixedNodeEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof PortAffixedNodeEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PortAffixedNodeEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof BlockPropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockPropertyCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockPropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PartPropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPartPropertyCompartmentFigure();
			setupContentPane(pane);
			pane.add(((PartPropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ReferencePropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getReferencePropertyCompartmentFigure();
			setupContentPane(pane);
			pane.add(((ReferencePropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PortCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPortCompartmentFigure();
			setupContentPane(pane);
			pane.add(((PortCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof FlowPortCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFlowPortCompartmentFigure();
			setupContentPane(pane);
			pane.add(((FlowPortCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof OperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane);
			pane.add(((OperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockConstraintCompartmentFigure();
			setupContentPane(pane);
			pane.add(((BlockConstraintCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getValuePropertyCompartmentFigure();
			setupContentPane(pane);
			pane.add(((ValuePropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof BlockLabelNameEditPart) {
			return true;
		}
		if (childEditPart instanceof FlowPortAffixedNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((FlowPortAffixedNodeEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PortAffixedNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((PortAffixedNodeEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof BlockPropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockPropertyCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockPropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PartPropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPartPropertyCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((PartPropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ReferencePropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getReferencePropertyCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((ReferencePropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PortCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPortCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((PortCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof FlowPortCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFlowPortCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((FlowPortCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof OperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((OperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockConstraintCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockConstraintCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ValuePropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getValuePropertyCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((ValuePropertyCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof BlockPropertyCompartmentEditPart) {
			return getPrimaryShape().getBlockPropertyCompartmentFigure();
		}
		if (editPart instanceof PartPropertyCompartmentEditPart) {
			return getPrimaryShape().getPartPropertyCompartmentFigure();
		}
		if (editPart instanceof ReferencePropertyCompartmentEditPart) {
			return getPrimaryShape().getReferencePropertyCompartmentFigure();
		}
		if (editPart instanceof PortCompartmentEditPart) {
			return getPrimaryShape().getPortCompartmentFigure();
		}
		if (editPart instanceof FlowPortCompartmentEditPart) {
			return getPrimaryShape().getFlowPortCompartmentFigure();
		}
		if (editPart instanceof OperationCompartmentEditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if (editPart instanceof BlockConstraintCompartmentEditPart) {
			return getPrimaryShape().getBlockConstraintCompartmentFigure();
		}
		if (editPart instanceof ValuePropertyCompartmentEditPart) {
			return getPrimaryShape().getValuePropertyCompartmentFigure();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	// public EditPart getTargetEditPart(Request request) {
	// if(request instanceof CreateViewAndElementRequest) {
	// CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
	// IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
	// if(type == CustomBlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN) {
	// return getChildBySemanticHint(CustomBlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT);
	// }
	// }
	// return super.getTargetEditPart(request);
	// }
	@Override
	protected NodeFigure createNodeFigure() {
		return new SelectableBorderedNodeFigure(createMainFigure());
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new BlockFigure();
	}

	@Override
	public BlockFigure getPrimaryShape() {
		return (BlockFigure) primaryShape;
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID);
	}
}
