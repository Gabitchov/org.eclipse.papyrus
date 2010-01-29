/*****************************************************************************
 * Copyright (c) 2009 CEA
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

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.draw2d.LifelineDotLineFigure;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.diagram.sequence.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineCreationEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.sequence.figures.LifelineAnchor;
import org.eclipse.papyrus.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.diagram.sequence.util.NotificationHelper;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class LifelineEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * True if the lifeline is in inline mode
	 */
	private boolean inlineMode;

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifier = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * Layout role for inline mode
	 */
	private LayoutEditPolicy inlineModeLayoutRole = createLayoutEditPolicy();;

	/**
	 * Layout role for normal mode
	 */
	private LayoutEditPolicy normalModeLayoutRole = new LifelineXYLayoutEditPolicy();

	/**
	 * Layout role for drag drop
	 */
	private DragDropEditPolicy dragDropEditPolicy = new DragDropEditPolicy();

	/**
	 * @generated
	 */
	public LifelineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LifelineItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new LifelineXYLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new LifelineCreationEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SequenceGraphicalNodeEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
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
		LifelineFigure figure = new LifelineFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public LifelineFigure getPrimaryShape() {
		return (LifelineFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof LifelineNameEditPart) {
			((LifelineNameEditPart)childEditPart).setLabel(getPrimaryShape().getFigureLifelineLabelFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof LifelineNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		// Execution specification handling
		if(editPart instanceof BehaviorExecutionSpecificationEditPart || editPart instanceof ActionExecutionSpecificationEditPart) {
			return getPrimaryShape().getFigureLifelineDotLineFigure();
		}

		return getContentPane();
	}

	/**
	 * Overrides to disable the defaultAnchorArea. The edge is now more stuck with the middle of the
	 * figure.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 250) {

			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}
		};
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
	 * @generated NOT
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}

		// Execution specification handling
		if(nodeShape instanceof LifelineFigure) {
			LifelineFigure lFigure = (LifelineFigure)nodeShape;
			return lFigure.getFigureLifelineDotLineFigure();
		}

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
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
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
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
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
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
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
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Comment_3009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
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
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Comment_3009);
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
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Comment_3009);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.Constraint_3008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class LifelineFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLifelineLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureLifelineNameContainerFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureExecutionsContainerFigure;

		/**
		 * @generated
		 */
		private LifelineDotLineCustomFigure fFigureLifelineDotLineFigure;

		/**
		 * @generated
		 */
		public LifelineFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(200)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLifelineNameContainerFigure = new RectangleFigure();
			fFigureLifelineNameContainerFigure.setLineWidth(1);

			fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));

			this.add(fFigureLifelineNameContainerFigure, BorderLayout.TOP);
			fFigureLifelineNameContainerFigure.setLayoutManager(new StackLayout());

			fFigureLifelineLabelFigure = new WrappingLabel();

			fFigureLifelineLabelFigure.setText("<...>");

			fFigureLifelineLabelFigure.setTextWrap(true);

			fFigureLifelineLabelFigure.setAlignment(PositionConstants.CENTER);

			fFigureLifelineNameContainerFigure.add(fFigureLifelineLabelFigure);

			fFigureExecutionsContainerFigure = new RectangleFigure();
			fFigureExecutionsContainerFigure.setFill(false);
			fFigureExecutionsContainerFigure.setOutline(false);
			fFigureExecutionsContainerFigure.setLineWidth(1);

			this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);
			fFigureExecutionsContainerFigure.setLayoutManager(new StackLayout());

			fFigureLifelineDotLineFigure = new LifelineDotLineCustomFigure();

			fFigureExecutionsContainerFigure.add(fFigureLifelineDotLineFigure);

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

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLifelineLabelFigure() {
			return fFigureLifelineLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureLifelineNameContainerFigure() {
			return fFigureLifelineNameContainerFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureExecutionsContainerFigure() {
			return fFigureExecutionsContainerFigure;
		}

		/**
		 * @generated
		 */
		public LifelineDotLineCustomFigure getFigureLifelineDotLineFigure() {
			return fFigureLifelineDotLineFigure;
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
				prefColor = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_GRADIENT);
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

	/**
	 * This operation returns the ExecutionSpecification EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @return the list of ExecutionSpecification EditParts
	 */
	public List<ShapeNodeEditPart> getExecutionSpecificationList() {
		List<ShapeNodeEditPart> executionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		for(Object obj : getChildren()) {
			if(obj instanceof BehaviorExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			} else if(obj instanceof ActionExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			}
		}
		return executionSpecificationList;
	}

	/**
	 * This operation returns the InnerConnectableElement EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @return the list of InnerConnectableElement EditParts
	 */
	public List<LifelineEditPart> getInnerConnectableElementList() {
		List<LifelineEditPart> propertyList = new ArrayList<LifelineEditPart>();
		for(Object obj : getChildren()) {
			if(obj instanceof LifelineEditPart) {
				propertyList.add((LifelineEditPart)obj);
			}
		}
		return propertyList;
	}

	/**
	 * Handle lifeline covered by and destruction event
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();

		if(UMLPackage.eINSTANCE.getLifeline_CoveredBy().equals(feature)) {
			// Handle coveredBy attribute
			Object newValue = notification.getNewValue();
			if(notification.getOldValue() instanceof MessageOccurrenceSpecification) {
				notifier.unlistenObject((Notifier)notification.getOldValue());
				if(newValue == null) {
					updateCrossEnd();
				}
			}
			if(newValue instanceof MessageOccurrenceSpecification) {
				MessageOccurrenceSpecification newMessageOccurrenceSpecification = (MessageOccurrenceSpecification)newValue;
				notifier.listenObject(newMessageOccurrenceSpecification);
				if(newMessageOccurrenceSpecification.getEvent() instanceof DestructionEvent) {
					getPrimaryShape().getFigureLifelineDotLineFigure().setCrossAtEnd(true);
					getPrimaryShape().repaint();
				}
			}
		} else if(UMLPackage.eINSTANCE.getOccurrenceSpecification_Event().equals(feature)) {
			// Handle destruction event
			Object newValue = notification.getNewValue();
			if(notification.getOldValue() instanceof DestructionEvent && newValue instanceof DestructionEvent == false) {
				updateCrossEnd();
			}
			if(newValue instanceof DestructionEvent) {
				getPrimaryShape().getFigureLifelineDotLineFigure().setCrossAtEnd(true);
				getPrimaryShape().repaint();
			}
		} else if(notification.getNotifier() instanceof Bounds) {
			updateCoveredByLifelines((Bounds)notification.getNotifier());
		}

		super.handleNotificationEvent(notification);
	}

	/**
	 * Update covered lifelines of a Interaction fragment
	 * 
	 * @param newBounds
	 *        The new bounds of the lifeline
	 */
	public void updateCoveredByLifelines(Bounds newBounds) {
		Rectangle rect = new Rectangle(newBounds.getX(), newBounds.getY(), newBounds.getWidth(), newBounds.getHeight());

		// Get the valid rectangle bounds representing the lifeline
		updateRectangleBounds(rect);

		Lifeline lifeline = (Lifeline)resolveSemanticElement();
		EList<InteractionFragment> coveredByLifelines = lifeline.getCoveredBys();

		List<InteractionFragment> coveredByLifelinesToAdd = new ArrayList<InteractionFragment>();
		List<InteractionFragment> coveredByLifelinesToRemove = new ArrayList<InteractionFragment>();
		for(Object child : getParent().getChildren()) {
			if(child instanceof InteractionFragmentEditPart) {
				InteractionFragmentEditPart interactionFragmentEditPart = (InteractionFragmentEditPart)child;
				InteractionFragment interactionFragment = (InteractionFragment)interactionFragmentEditPart.resolveSemanticElement();
				if(rect.intersects(interactionFragmentEditPart.getFigure().getBounds())) {
					if(!coveredByLifelines.contains(interactionFragment)) {
						coveredByLifelinesToAdd.add(interactionFragment);
					}
				} else if(coveredByLifelines.contains(interactionFragment)) {
					coveredByLifelinesToRemove.add(interactionFragment);
				}
			}
		}

		if(!coveredByLifelinesToAdd.isEmpty()) {
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), coveredByLifelinesToAdd));
		}
		if(!coveredByLifelinesToRemove.isEmpty()) {
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), coveredByLifelinesToRemove));
		}
	}

	/**
	 * Update the rectangle bounds.
	 * In case of a creation, the lifeline width and height will be 0. Get the preferred size
	 * In case of a move, when the lifeline has not be resize, the width or height may be set to -1. Get the according figure bounds.
	 * 
	 * @param rect
	 *        the rectangle to update
	 */
	private void updateRectangleBounds(Rectangle rect) {

		// When moving the lifeline
		if(rect.width == -1) {
			rect.width = getFigure().getBounds().width;
		}
		if(rect.height == -1) {
			rect.height = getFigure().getBounds().height;
		}
		if(rect.x == -1) {
			rect.x = getFigure().getBounds().x;
		}
		if(rect.y == -1) {
			rect.y = getFigure().getBounds().y;
		}

		// When creating the lifeline
		if(rect.width == 0) {
			rect.width = getFigure().getPreferredSize().width;
		}
		if(rect.height == 0) {
			rect.height = getFigure().getPreferredSize().height;
		}
	}

	/**
	 * Update the cross end
	 */
	private void updateCrossEnd() {
		LifelineDotLineFigure figureLifelineDotLineFigure = getPrimaryShape().getFigureLifelineDotLineFigure();
		if(figureLifelineDotLineFigure != null) {
			figureLifelineDotLineFigure.setCrossAtEnd(false);
			Lifeline lifeline = (Lifeline)resolveSemanticElement();
			if(lifeline != null) {
				for(InteractionFragment interactionFragment : lifeline.getCoveredBys()) {
					if(interactionFragment instanceof MessageOccurrenceSpecification) {
						MessageOccurrenceSpecification messageOccurrenceSpecification = (MessageOccurrenceSpecification)interactionFragment;
						notifier.listenObject(messageOccurrenceSpecification);
						if(messageOccurrenceSpecification.getEvent() instanceof DestructionEvent) {
							figureLifelineDotLineFigure.setCrossAtEnd(true);
						}
					}
				}
				getPrimaryShape().repaint();
			}
		}
	}

	/**
	 * Overrides to return the DashLineFigure instead of this figure. This is necessary for the
	 * connections anchor.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getNodeFigure()
	 */
	@Override
	protected NodeFigure getNodeFigure() {
		return getDashLineFigure();
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	protected void setBackgroundColor(Color c) {
		NodeFigure fig = (NodeFigure)getFigure();
		fig.setBackgroundColor(c);
		fig.setIsUsingGradient(false);
		fig.setGradientData(-1, -1, 0);
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setGradient(org.eclipse.gmf.runtime.notation.datatype.GradientData)
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		NodeFigure fig = (NodeFigure)getFigure();
		if(gradient != null) {
			fig.setIsUsingGradient(true);
			fig.setGradientData(gradient.getGradientColor1(), gradient.getGradientColor2(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setTransparency(int)
	 */
	@Override
	protected void setTransparency(int transp) {
		NodeFigure fig = (NodeFigure)getFigure();
		fig.setTransparency(transp);
	}

	/**
	 * Create specific anchor to handle connection on top, on center and on bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof Message4EditPart) {
			// Create message
			return new LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
		} else if(connEditPart instanceof Message5EditPart) {
			// Delete message
			AbstractConnectionAnchor anchor = (AbstractConnectionAnchor)super.getTargetConnectionAnchor(connEditPart);
			anchor.setOwner(getCrossFigure());
			return anchor;
		} else {
			return super.getTargetConnectionAnchor(connEditPart);
		}

	}

	/**
	 * Create specific anchor to handle connection on top, on center and on bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(UMLElementTypes.Message_4006.equals(obj)) {
					// Create Message
					return new LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
				} else if(UMLElementTypes.Message_4007.equals(obj)) {
					// Delete Message
					AbstractConnectionAnchor anchor = (AbstractConnectionAnchor)super.getTargetConnectionAnchor(request);
					anchor.setOwner(getCrossFigure());
					return anchor;
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof Message4EditPart) {
				// Create
				return new LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
			} else if(connectionEditPart instanceof Message5EditPart) {
				// Delete
				AbstractConnectionAnchor anchor = (AbstractConnectionAnchor)super.getTargetConnectionAnchor(request);
				anchor.setOwner(getCrossFigure());
				return anchor;
			}
		}

		return super.getTargetConnectionAnchor(request);
	}

	/**
	 * Create the dashLine figure
	 */
	private NodeFigure getDashLineFigure() {
		NodeFigure centerFigure = null;
		if(getContentPane() instanceof LifelineDotLineCustomFigure) {
			centerFigure = ((LifelineDotLineCustomFigure)getContentPane()).getDashLineRectangle();
		}
		return centerFigure;
	}

	/**
	 * Get the cross figure
	 */
	private IFigure getCrossFigure() {
		IFigure bottomCenterFigure = getContentPane();
		if(bottomCenterFigure instanceof LifelineDotLineCustomFigure) {
			bottomCenterFigure = ((LifelineDotLineCustomFigure)bottomCenterFigure).getCrossAtEndRectangle();
		}
		return bottomCenterFigure;
	}

	/**
	 * Handle message creation for execution specification
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof CreateConnectionRequest) {

			CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest)request;
			EditPart target = createConnectionRequest.getTargetEditPart();
			if(target instanceof LifelineEditPart) {
				LifelineEditPart lifelineEditPart = (LifelineEditPart)target;
				Rectangle lifelineBounds = lifelineEditPart.getContentPane().getBounds();
				for(ShapeNodeEditPart executionSpecificationEditPart : lifelineEditPart.getExecutionSpecificationList()) {
					IFigure executionSpecificationFigure = executionSpecificationEditPart.getFigure();
					Rectangle esBounds = executionSpecificationFigure.getBounds().getCopy();
					esBounds.x = lifelineBounds.x;
					esBounds.width = lifelineBounds.width;
					if(createConnectionRequest.getLocation() != null) {
						Point location = createConnectionRequest.getLocation().getCopy();
						executionSpecificationFigure.translateToRelative(location);
						if(esBounds.contains(location)) {
							createConnectionRequest.setTargetEditPart(executionSpecificationEditPart);
							return executionSpecificationEditPart.getCommand(request);
						}
					}
				}
			} else {
				return target.getCommand(request);
			}

		}
		return super.getCommand(request);
	}

	/**
	 * Activate listeners for Lifeline to handle notification in the message occurence specification
	 */
	@Override
	public void activate() {
		updateCrossEnd();
		super.activate();
	}

	/**
	 * Desactivate listeners for Lifeline to handle notification in the message occurence
	 * specification
	 */
	@Override
	public void deactivate() {
		notifier.unlistenAll();
		super.deactivate();
	}

	/**
	 * Remove listeners for Lifeline to handle notification in the message occurence specification
	 */
	@Override
	public void removeNotify() {
		notifier.unlistenAll();
		super.removeNotify();
	}

	/**
	 * Configure inline mode
	 */
	@Override
	protected void refreshChildren() {
		super.refreshChildren();
		configure(isInlineMode());
	}

	/**
	 * Determine inline capability
	 * 
	 * @return True if inline mode is possible
	 */
	public boolean isInlineCapability() {
		List<Property> properties = getAvailableProperties();
		if(properties != null && !properties.isEmpty()) {
			return inlineMode || getChildren().size() < 2;
		}

		return false;
	}

	/**
	 * Get the inline mode
	 * 
	 * @return True if the lifeline is in inline mode and if there are properties, else false
	 */
	private boolean isInlineMode() {
		for(Object o : getChildren()) {
			if(o instanceof LifelineEditPart) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Configure the lifeline
	 * 
	 * @param inlineMode
	 *        True if the lifeline is in inline mode
	 */
	private void configure(boolean inlineMode) {
		(getPrimaryShape().getFigureLifelineDotLineFigure()).configure(inlineMode, getInnerConnectableElementList().size());
		if(this.inlineMode != inlineMode) {
			this.inlineMode = inlineMode;
			if(inlineMode) {
				installEditPolicy(EditPolicy.LAYOUT_ROLE, inlineModeLayoutRole);
				removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);
			} else {
				installEditPolicy(EditPolicy.LAYOUT_ROLE, normalModeLayoutRole);
				installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, dragDropEditPolicy);
			}
			refreshVisuals();
		}
	}

	/**
	 * Return the inner ConnectableElements of the lifeline
	 * 
	 * @return inner ConnectableElements
	 */
	public List<Property> getProperties() {
		Lifeline lifeline = (Lifeline)resolveSemanticElement();
		return getProperties(lifeline);
	}

	/**
	 * Get available properties
	 * 
	 * @return Only not already used properties
	 */
	public List<Property> getAvailableProperties() {
		List<Property> properties = getProperties();
		if(properties != null) {
			for(EditPart editPart : (List<EditPart>)getChildren()) {
				if(editPart instanceof LifelineEditPart) {
					Lifeline lifeline = (Lifeline)((LifelineEditPart)editPart).resolveSemanticElement();
					ConnectableElement represents = lifeline.getRepresents();
					if(properties.contains(represents)) {
						properties.remove(represents);
					}
				}
			}
		}
		return properties;
	}

	/**
	 * Return the inner ConnectableElements of the lifeline
	 * 
	 * @param lifeline
	 *        The lifeline
	 * @return inner ConnectableElements
	 */
	// TODO Extract in a helper
	public static List<Property> getProperties(Lifeline lifeline) {
		if(lifeline != null) {
			ConnectableElement represents = lifeline.getRepresents();
			if(represents != null) {
				Type type = represents.getType();
				if(type instanceof StructuredClassifier) {
					StructuredClassifier structuredClassifier = (StructuredClassifier)type;

					if(!structuredClassifier.getAllAttributes().isEmpty()) {
						return new ArrayList<Property>(((StructuredClassifier)type).getAllAttributes());
					}
				}
			}
		}

		return null;
	}

}
