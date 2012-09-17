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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.editparts.AbstractCommentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CommentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class CommentEditPart extends

AbstractCommentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3009;

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
	public CommentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CommentItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * Papyrus codeGen
	 * 
	 * @generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

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
		return primaryShape = new HTMLCornerBentFigure();
	}

	/**
	 * @generated
	 */
	public HTMLCornerBentFigure getPrimaryShape() {
		return (HTMLCornerBentFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CommentBodyEditPart) {
			((CommentBodyEditPart)childEditPart).setLabel(getPrimaryShape().getCornerBentFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof CommentBodyEditPart) {
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
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "Comment";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));

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
	protected NodeFigure createNodeFigure() {
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
		if(primaryShape instanceof NodeFigure){
			((NodeFigure)primaryShape).setLineWidth(width);
		}else if(primaryShape instanceof Shape) {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(8);
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionEditPart) {
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
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(9);
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
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Comment_3009);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.DurationConstraint_3023);
		}
		return types;
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
				prefColor = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Comment", PreferenceConstantHelper.COLOR_GRADIENT);
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
