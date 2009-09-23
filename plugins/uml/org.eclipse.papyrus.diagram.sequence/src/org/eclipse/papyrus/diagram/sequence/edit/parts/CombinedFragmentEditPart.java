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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.sequence.edit.policies.CombinedFragmentItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.figures.CombinedFragmentFigure;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT
 */
public class CombinedFragmentEditPart extends InteractionFragmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3004;

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
	public CombinedFragmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CombinedFragmentItemSemanticEditPolicy());
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
				if (result == null) {
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
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		primaryShape = new CombinedFragmentFigure();
		updateOperatorKind();
		return primaryShape;
	}

	/**
	 * @generated NOT
	 */
	private void updateOperatorKind() {
		String operatorKind;
		Object obj = getModel();
		if (obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
			EObject element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
			if (element instanceof CombinedFragment) {
				CombinedFragment combinedFragment = (CombinedFragment) element;
				if (combinedFragment.getInteractionOperator() == null) {
					combinedFragment.setInteractionOperator(InteractionOperatorKind.SEQ_LITERAL);
				}
				operatorKind = combinedFragment.getInteractionOperator().getName();
				getPrimaryShape().setOperatorKindValue(operatorKind);
			}
		}
	}

	/**
	 * @generated
	 */
	public CombinedFragmentFigure getPrimaryShape() {
		return (CombinedFragmentFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
			// own way
			pane.add(((CombinedFragmentCombinedFragmentCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his
			// own way
			pane.remove(((CombinedFragmentCombinedFragmentCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			return getPrimaryShape().getCompartmentFigure();
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
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
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
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.InteractionOperand_3005) {
				return getChildBySemanticHint(UMLVisualIDRegistry
						.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore) getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()
				|| feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("CombinedFragment",
						PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("CombinedFragment",
						PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("CombinedFragment",
						PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("CombinedFragment",
					PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore
					.getString(prefGradient));
			if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if (result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}

	/**
	 * Handle for interaction operator and operator kind
	 * 
	 * @generated NOT
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();

		if (UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator().equals(feature)) {
			CombinedFragment combinedFragment = (CombinedFragment) resolveSemanticElement();
			EList<InteractionOperand> operands = combinedFragment.getOperands();
			// If CombinedFragment have no operand, we can change the OperatorKind
			if (operands == null || operands.isEmpty()) {
				getPrimaryShape().setOperatorKindValue(notification.getNewStringValue());
			} else if (notification.getOldValue() instanceof InteractionOperatorKind
					&& !notification.getNewStringValue().equals(
							getPrimaryShape().getFigureInteractionLabelFigure().getText())) {
				// TODO Improve cancelation method
				combinedFragment.setInteractionOperator((InteractionOperatorKind) notification.getOldValue());
			}
		} else if (UMLPackage.eINSTANCE.getCombinedFragment_Operand().equals(feature)) {
			CombinedFragment combinedFragment = (CombinedFragment) resolveSemanticElement();
			InteractionOperatorKind interactionOperator = combinedFragment.getInteractionOperator();
			Object newValue = notification.getNewValue();
			if (interactionOperator != null && newValue != null) {
				if (InteractionOperatorKind.OPT_LITERAL.equals(interactionOperator)
						|| InteractionOperatorKind.LOOP_LITERAL.equals(interactionOperator)
						|| InteractionOperatorKind.BREAK_LITERAL.equals(interactionOperator)
						|| InteractionOperatorKind.NEG_LITERAL.equals(interactionOperator)) {
					EList<InteractionOperand> operands = combinedFragment.getOperands();
					if (operands != null && operands.size() > 1) {
						// Case of there is already an operand on opt, loop, break and neg
						// CombinedFragment type
						combinedFragment.getOperands().remove(newValue);
						return;
					}
				}
			}
		} else if (UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature)) {
			resizeInteractionFragmentFigure();
		}

		super.handleNotificationEvent(notification);
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.Message_4003);
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		types.add(UMLElementTypes.Message_4003);
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
																							 * emf.
																							 * type
																							 * .
																							 * core.
																							 * IElementType
																							 * >
																							 */();
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		return types;
	}

}
