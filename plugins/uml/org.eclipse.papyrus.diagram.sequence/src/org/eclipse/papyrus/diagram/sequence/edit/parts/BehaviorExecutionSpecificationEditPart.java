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
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.sequence.edit.policies.BehaviorExecutionSpecificationItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class BehaviorExecutionSpecificationEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

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
	public BehaviorExecutionSpecificationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BehaviorExecutionSpecificationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children
		// add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
		BehaviourExecutionSpecificationRectangleFigure figure = new BehaviourExecutionSpecificationRectangleFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public BehaviourExecutionSpecificationRectangleFigure getPrimaryShape() {
		return (BehaviourExecutionSpecificationRectangleFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(16, 60);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if(result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy)result;
			ep.setResizeDirections(PositionConstants.NORTH | PositionConstants.SOUTH);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
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
	@Override
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
			IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
			IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
																							 * <org.eclipse
																							 * .gmf.
																							 * runtime
																							 * .
																							 * emf.type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class BehaviourExecutionSpecificationRectangleFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public BehaviourExecutionSpecificationRectangleFigure() {
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(60)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(25)));
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		@Override
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()
				|| feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("BehaviorExecutionSpecification",
						PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("BehaviorExecutionSpecification",
						PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("BehaviorExecutionSpecification",
						PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore,
					prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("BehaviorExecutionSpecification",
					PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore
					.getString(prefGradient));
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

	/**
	 * Overrides to set the CallSync attached to the top of the BehaviorExecutionSpecification
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {

		int endOfTheFigure = getFigure().getBounds().y;

		updateRequestPosition(request, endOfTheFigure, MessageEditPart.VISUAL_ID, MessageEditPart.class);

		return super.getTargetConnectionAnchor(request);
	}

	/**
	 * Overrides to Set the Reply attached to the bottom of the BehaviorExecutionSpecification
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {

		// TODO : don't know why, but it seems we need to add twice the height of the figure to have
		// the real bottom...
		// Need more investigation to clean that !
		int endOfTheFigure = getFigure().getBounds().y + getFigure().getBounds().height
				+ getFigure().getBounds().height;

		updateRequestPosition(request, endOfTheFigure, Message3EditPart.VISUAL_ID, Message3EditPart.class);

		return super.getSourceConnectionAnchor(request);
	}

	/**
	 * @param request
	 * @param yPosition
	 * @param elementType
	 * @param semanticHint
	 */
	private void updateRequestPosition(Request request, int yPosition, int visualID, Class<?> editPart) {
		// to manage the location of the feedbackfigure
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			IElementType elementType = UMLElementTypes.getElementType(visualID);
			if(elementType != null) {
				CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
				Point location = createRequest.getLocation();
				List<?> relationshipTypes = createRequest.getElementTypes();
				for(Object obj : relationshipTypes) {
					if(elementType.equals(obj)) {
						location.y = yPosition;
					}
				}
			}
		}
		// to manage the location of the created figure
		else if(request instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest createRequest = (CreateConnectionViewAndElementRequest)request;
			ConnectionViewDescriptor connectionViewDescriptor = createRequest.getConnectionViewAndElementDescriptor();
			if(connectionViewDescriptor != null) {
				if(String.valueOf(visualID).equals(connectionViewDescriptor.getSemanticHint())) {
					Point location = createRequest.getLocation();
					location.y = yPosition;
				}
			}
		}

		// to manage reconnect
		else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(editPart.equals(connectionEditPart.getClass())) {
				Point location = reconnectRequest.getLocation();
				location.y = yPosition;
			}
		}
	}

}
