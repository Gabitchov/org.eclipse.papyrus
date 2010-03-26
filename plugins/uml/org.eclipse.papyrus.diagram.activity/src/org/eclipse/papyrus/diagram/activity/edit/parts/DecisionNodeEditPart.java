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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.policies.BehaviorPropertyNodeEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.DecisionNodeItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.locator.LinkedBehaviorLocator;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class DecisionNodeEditPart extends

AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3038;

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
	public DecisionNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DecisionNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated NOT use BehaviorPropertyNodeEditPolicy
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case DecisionInputEditPart.VISUAL_ID:
					return new BehaviorPropertyNodeEditPolicy();
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
		DiamondFigure figure = new DiamondFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public DiamondFigure getPrimaryShape() {
		return (DiamondFigure)primaryShape;
	}

	/**
	 * @generated NOT use custom locator
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof DecisionInputEditPart) {
			// use custom locator
			BorderItemLocator locator = new LinkedBehaviorLocator(getMainFigure(), PositionConstants.NORTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated NOT use a diamond figure instead
	 */
	protected NodeFigure createNodePlate() {
		NodeFigure result = new org.eclipse.gmf.runtime.gef.ui.internal.figures.DiamondFigure(new Dimension(20, 30));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(DecisionInputEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.ObjectFlow_4003);
		types.add(UMLElementTypes.ControlFlow_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
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
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart) {
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
		if(targetEditPart instanceof SendSignalActionEditPart) {
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
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ObjectFlow_4003);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
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
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart) {
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
		if(targetEditPart instanceof SendSignalActionEditPart) {
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
		if(targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		if(targetEditPart instanceof OutputPinInAcceptEventActionEditPart) {
			types.add(UMLElementTypes.ControlFlow_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
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
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3064);
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
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3064);
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
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ObjectFlow_4003) {
			types.add(UMLElementTypes.OutputPin_3064);
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
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.AcceptEventAction_3063);
		}
		if(relationshipType == UMLElementTypes.ControlFlow_4004) {
			types.add(UMLElementTypes.OutputPin_3064);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class DiamondFigure extends Shape {

		/**
		 * @generated
		 */
		public DiamondFigure() {
			this.setFill(true);
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(20), getMapMode().DPtoLP(30)));
			this.setSize(getMapMode().DPtoLP(20), getMapMode().DPtoLP(30));
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
		 * @generated
		 */
		protected void fillShape(Graphics graphics) {
			Rectangle bounds = getBounds();
			graphics.pushState();
			graphics.translate(bounds.x, bounds.y);
			graphics.fillPolygon(scalePointList());
			graphics.popState();
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
				prefColor = PreferenceConstantHelper.getElementConstant("DecisionNode", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("DecisionNode", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("DecisionNode", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("DecisionNode", PreferenceConstantHelper.COLOR_GRADIENT);
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
