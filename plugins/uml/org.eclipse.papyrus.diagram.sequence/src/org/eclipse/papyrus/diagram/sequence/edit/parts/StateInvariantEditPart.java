package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
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
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.diagram.sequence.edit.policies.StateInvariantItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class StateInvariantEditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3017;

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
	public StateInvariantEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new StateInvariantItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
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
		ContinuationFigure figure = new ContinuationFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ContinuationFigure getPrimaryShape() {
		return (ContinuationFigure)primaryShape;
	}



	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateInvariantNameEditPart) {
			((StateInvariantNameEditPart)childEditPart).setLabel(getPrimaryShape().getFigureContinuationNameLabel());
			return true;
		}


		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateInvariantNameEditPart) {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateInvariantNameEditPart.VISUAL_ID));
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
		if(targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart) {
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
		if(targetEditPart instanceof ContinuationEditPart) {
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
			types.add(UMLElementTypes.StateInvariant_3017);
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
			types.add(UMLElementTypes.Continuation_3016);
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
	public class ContinuationFigure extends RoundedRectangle {


		/**
		 * @generated
		 */
		private CenteredWrappedLabel fFigureContinuationNameLabel;


		/**
		 * @generated
		 */
		public ContinuationFigure() {

			CenterLayout layoutThis = new CenterLayout();


			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(50), getMapMode().DPtoLP(50)));
			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fFigureContinuationNameLabel = new CenteredWrappedLabel();



			this.add(fFigureContinuationNameLabel);


		}




		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

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
		public CenteredWrappedLabel getFigureContinuationNameLabel() {
			return fFigureContinuationNameLabel;
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
				prefColor = PreferenceConstantHelper.getElementConstant("StateInvariant", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("StateInvariant", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("StateInvariant", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("StateInvariant", PreferenceConstantHelper.COLOR_GRADIENT);
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
