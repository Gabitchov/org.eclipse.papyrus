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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
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
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
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
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.SendSignalActionCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.SendSignalActionItemSemanticEditPolicy;
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
public class SendSignalActionEditPart extends

AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3052;

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
	public SendSignalActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SendSignalActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());


		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.activity.edit.policies.SendSignalActionCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(RequestConstants.REQ_CREATE, new CreateActionLocalConditionEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ObjectFlowWithPinsCreationEditPolicy());
		installEditPolicy(RequestConstants.REQ_DELETE, new DeleteActionViewEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new SendSignalActionCanonicalEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case ActionInputPinInSendSigActEditPart.VISUAL_ID:
				case ValuePinInSendSigActEditPart.VISUAL_ID:
				case InputPinInSendSigActEditPart.VISUAL_ID:
				case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
				case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:

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
		SendSignalActionFigure figure = new SendSignalActionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SendSignalActionFigure getPrimaryShape() {
		return (SendSignalActionFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof SendSignalActionNameEditPart) {
			((SendSignalActionNameEditPart)childEditPart).setLabel(getPrimaryShape().getSendSignalActionLabel());
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof ActionInputPinInSendSigActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ActionInputPinInSendSigActEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof ValuePinInSendSigActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ValuePinInSendSigActEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof InputPinInSendSigActEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((InputPinInSendSigActEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(((ValuePinInSendSigActAsTargetEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(((ActionInputPinInSendSigActAsTargetEditPart)childEditPart).getFigure(), locator);
			return true;
		}





		//Papyrus Gencode :Affixed Pin locator for Actions
		if(childEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			IBorderItemLocator locator = new PinPositionLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(((InputPinInSendSigActAsTargetEditPart)childEditPart).getFigure(), locator);
			return true;
		}




		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof SendSignalActionNameEditPart) {
			return true;
		}
		if(childEditPart instanceof ActionInputPinInSendSigActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActionInputPinInSendSigActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ValuePinInSendSigActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePinInSendSigActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof InputPinInSendSigActEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPinInSendSigActEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePinInSendSigActAsTargetEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActionInputPinInSendSigActAsTargetEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPinInSendSigActAsTargetEditPart)childEditPart).getFigure());
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(SendSignalActionNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ActionLocalPrecondition_4001);
		types.add(UMLElementTypes.ActionLocalPostcondition_4002);
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
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
		if(targetEditPart instanceof OpaqueActionEditPart) {
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
		if(targetEditPart instanceof SendObjectActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
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
		if(targetEditPart instanceof OpaqueActionEditPart) {
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
		if(targetEditPart instanceof SendObjectActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsReqEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendObjActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendSigActEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ValuePinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActionInputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof InputPinInSendSigActAsTargetEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
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
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
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
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
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
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
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
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendObjectAction_3042);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3046);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3047);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3048);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3049);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3050);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3051);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.SendSignalAction_3052);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3053);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3054);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3055);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ValuePin_3060);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActionInputPin_3061);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.InputPin_3062);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.ActivityParameterNode_3059);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class SendSignalActionFigure extends Shape {

		/**
		 * @generated
		 */
		private CenteredWrappedLabel fSendSignalActionLabel;

		/**
		 * @generated NOT
		 */
		private final Insets marginTemplate;

		/**
		 * @generated NOT make margin border relative
		 */
		public SendSignalActionFigure() {

			CenterLayout layoutThis = new CenterLayout();


			this.setLayoutManager(layoutThis);

			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(150), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(200), getMapMode().DPtoLP(25)));
			this.addPoint(new Point(getMapMode().DPtoLP(150), getMapMode().DPtoLP(50)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(50)));
			this.setFill(true);
			this.setLineWidth(1);
			// make margin border relative
			marginTemplate = new Insets(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(50));
			this.setBorder(new MarginBorder(marginTemplate));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fSendSignalActionLabel = new CenteredWrappedLabel();



			this.add(fSendSignalActionLabel);


			CenteredWrappedLabel sendSignalActionLabel1 = new CenteredWrappedLabel();



			fSendSignalActionLabel.add(sendSignalActionLabel1);



		}

		/**
		 * @generated
		 */
		private final PointList myTemplate = new PointList();

		/**
		 * @generated
		 */
		private Rectangle myTemplateBounds;

		/**
		 * @generated
		 */
		public void addPoint(Point point) {
			myTemplate.addPoint(point);
			myTemplateBounds = null;
		}

		/**
		 * @generated NOT refresh relative margin
		 */
		protected void fillShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.fillPolygon(scalePointList());
			graphics.popState();
			// refresh relative margin
			this.setBorder(new MarginBorder(scaleMargin()));
		}

		/**
		 * @generated
		 */
		protected void outlineShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.drawPolygon(scalePointList());
			graphics.popState();
		}

		/**
		 * @generated NOT
		 */
		private Insets scaleMargin() {
			Rectangle pointsBounds = getTemplateBounds();
			Rectangle actualBounds = getBounds();

			float xScale = ((float)actualBounds.width) / pointsBounds.width;
			float yScale = ((float)actualBounds.height) / pointsBounds.height;

			if(xScale == 1 && yScale == 1) {
				return marginTemplate;
			}
			Insets scaled = new Insets(marginTemplate);
			scaled.top = (int)Math.floor(scaled.top * yScale);
			scaled.left = (int)Math.floor(scaled.left * xScale);
			scaled.bottom = (int)Math.floor(scaled.bottom * yScale);
			scaled.right = (int)Math.floor(scaled.right * xScale);
			return scaled;
		}

		/**
		 * @generated
		 */
		private Rectangle getTemplateBounds() {
			if(myTemplateBounds == null) {
				myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
				//just safety -- we are going to use this as divider 
				if(myTemplateBounds.width < 1) {
					myTemplateBounds.width = 1;
				}
				if(myTemplateBounds.height < 1) {
					myTemplateBounds.height = 1;
				}
			}
			return myTemplateBounds;
		}

		/**
		 * @generated
		 */
		private int[] scalePointList() {
			Rectangle pointsBounds = getTemplateBounds();
			Rectangle actualBounds = getBounds();

			float xScale = ((float)actualBounds.width) / pointsBounds.width;
			float yScale = ((float)actualBounds.height) / pointsBounds.height;

			if(xScale == 1 && yScale == 1) {
				return myTemplate.toIntArray();
			}
			int[] scaled = (int[])myTemplate.toIntArray().clone();
			for(int i = 0; i < scaled.length; i += 2) {
				scaled[i] = (int)Math.floor(scaled[i] * xScale);
				scaled[i + 1] = (int)Math.floor(scaled[i + 1] * yScale);
			}
			return scaled;
		}

		/**
		 * @generated
		 */
		public CenteredWrappedLabel getSendSignalActionLabel() {
			return fSendSignalActionLabel;
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
				prefColor = PreferenceConstantHelper.getElementConstant("SendSignalAction", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("SendSignalAction", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("SendSignalAction", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("SendSignalAction", PreferenceConstantHelper.COLOR_GRADIENT);
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
