/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.policies.CreateActionLocalConditionEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.DeleteActionViewEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ObjectFlowWithPinsCreationEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpaqueActionCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpaqueActionItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.figures.CenteredWrappedLabel;
import org.eclipse.papyrus.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class OpaqueActionEditPart extends

AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3007;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public OpaqueActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OpaqueActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.activity.edit.policies.OpaqueActionCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(RequestConstants.REQ_CREATE, new CreateActionLocalConditionEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ObjectFlowWithPinsCreationEditPolicy());
		installEditPolicy(RequestConstants.REQ_DELETE, new DeleteActionViewEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OpaqueActionCanonicalEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case ValuePinInOpaqueActEditPart.VISUAL_ID:
				case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
				case InputPinInOpaqueActEditPart.VISUAL_ID:
				case OutputPinInOpaqueActEditPart.VISUAL_ID:

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

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ActionFigure figure = new ActionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActionFigure getPrimaryShape() {
		return (ActionFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof OpaqueActionNameEditPart) {
			((OpaqueActionNameEditPart)childEditPart).setLabel(getPrimaryShape().getActionLabel());
			return true;
		}

		//Papyrus Gencode :Affixed Value Pin locator for OpaqueAction
		if(childEditPart instanceof ValuePinInOpaqueActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ValuePinInOpaqueActEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Action Input Pin locator for OpaqueAction
		if(childEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ActionInputPinInOpaqueActEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Input Pin locator for OpaqueAction
		if(childEditPart instanceof InputPinInOpaqueActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((InputPinInOpaqueActEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed Output Pin locator for OpaqueAction
		if(childEditPart instanceof OutputPinInOpaqueActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(((OutputPinInOpaqueActEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof OpaqueActionNameEditPart) {
			return true;
		}
		if(childEditPart instanceof ValuePinInOpaqueActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePinInOpaqueActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActionInputPinInOpaqueActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof InputPinInOpaqueActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPinInOpaqueActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof OutputPinInOpaqueActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutputPinInOpaqueActEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(targetEditPart instanceof DurationConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof ConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof ConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof DurationConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof TimeConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof InteractionConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof IntervalConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof ConstraintAsLocalPrecondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof ConstraintAsLocalPostcondEditPart) {
			types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		}
		if(targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInOpaqueActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCallBeActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInCallOpActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInCallOpActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.DurationConstraint_3034);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.DurationConstraint_3035);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.TimeConstraint_3036);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.TimeConstraint_3037);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.InteractionConstraint_3030);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.InteractionConstraint_3031);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.IntervalConstraint_3032);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.IntervalConstraint_3033);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.Constraint_3011);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPrecondition_4001) {
			types.add(UMLElementTypes.Constraint_3012);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.DurationConstraint_3034);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.DurationConstraint_3035);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.TimeConstraint_3036);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.TimeConstraint_3037);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.InteractionConstraint_3030);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.InteractionConstraint_3031);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.IntervalConstraint_3032);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.IntervalConstraint_3033);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.Constraint_3011);
		}
		if(relationshipType == UMLElementTypes.ActionLocalPostcondition_4002) {
			types.add(UMLElementTypes.Constraint_3012);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InitialNode_3004);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityFinalNode_3005);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.FlowFinalNode_3006);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OpaqueAction_3007);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3015);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3016);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3013);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3014);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallBehaviorAction_3008);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3017);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3018);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3019);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3020);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.CallOperationAction_3010);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3021);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3022);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3023);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3024);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3025);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3026);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3027);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.DecisionNode_3038);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.MergeNode_3039);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ForkNode_3040);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.JoinNode_3041);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ActionFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private CenteredWrappedLabel fActionLabel;

		/**
		 * @generated
		 */
		private Polyline fOptionalRakeFigure;

		/**
		 * @generated
		 */
		public ActionFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(16)));
			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fActionLabel = new CenteredWrappedLabel();

			this.add(fActionLabel);

			fOptionalRakeFigure = new Polyline();
			fOptionalRakeFigure.setFill(false);
			fOptionalRakeFigure.setLineWidth(2);

			this.add(fOptionalRakeFigure);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public CenteredWrappedLabel getActionLabel() {
			return fActionLabel;
		}

		/**
		 * @generated
		 */
		public Polyline getOptionalRakeFigure() {
			return fOptionalRakeFigure;
		}

	}

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("OpaqueAction", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("OpaqueAction", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("OpaqueAction", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("OpaqueAction", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}
}
