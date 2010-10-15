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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.edit.policies.StructuredClassifierLayoutEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.locators.PortPositionLocator;
import org.eclipse.papyrus.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.BlockItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.figure.BlockFigure;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;

public class BlockEditPart extends ClassEditPart {

	public BlockEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new StructuredClassifierLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockItemSemanticEditPolicy());
	}

	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case PortEditPart.VISUAL_ID:

					return new BorderItemResizableEditPolicy();

				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	protected boolean addFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof PortEditPart) {
			IBorderItemLocator locator = new PortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((PortEditPart)childEditPart).getFigure(), locator);
			return true;
		}

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

	protected boolean removeFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof PortEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((PortEditPart)childEditPart).getFigure());
			return true;
		}

		if(childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockConstraintCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockConstraintCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockValueCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockValueCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockValueCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockPartCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockPartCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockPartCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockReferenceCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getBlockReferenceCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockReferenceCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof BlockPropertyCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane);
			pane.remove(((BlockPropertyCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		return super.removeFixedChild(childEditPart);
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

	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
			if(type == BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN) {
				return getChildBySemanticHint(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT);
			}
			if(type == BlockDefinitionDiagramElementTypes.BLOCK_PART_CLN) {
				return getChildBySemanticHint(BlockDefinitionDiagramElementTypes.BLOCK_PART_COMPARTMENT_HINT);
			}
		}
		return super.getTargetEditPart(request);
	}

	protected IFigure createNodeShape() {
		return primaryShape = new BlockFigure();
	}

	public BlockFigure getPrimaryShape() {
		return (BlockFigure)primaryShape;
	}
}
