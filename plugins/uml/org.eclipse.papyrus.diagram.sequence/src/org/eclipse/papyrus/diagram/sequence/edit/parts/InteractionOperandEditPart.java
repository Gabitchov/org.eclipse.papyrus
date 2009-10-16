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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionOperandComponentEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionOperandDragDropEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionOperandItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionOperandLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.figures.InteractionOperandFigure;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.Notifier;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @generated
 */
public class InteractionOperandEditPart extends

ShapeNodeEditPart {

	/**
	 * Default value for integer.
	 * 
	 * @generated NOT
	 */
	private static final int DEFAULT_INT_VALUE = -1;

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3005;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * True if this Edit Part is the first Operand of his CombinedFragment's parent
	 * 
	 * @generated NOT
	 */
	private boolean firstOperand = false;

	/**
	 * Notfier for listen and unlistend model element.
	 * 
	 * @generated NOT
	 */
	private Notifier notifier = new Notifier(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * Specification value
	 * 
	 * @generated NOT
	 */
	private String specValue = null;

	/**
	 * Maximun value
	 * 
	 * @generated NOT
	 */
	private int maxValue = DEFAULT_INT_VALUE;

	/**
	 * Minimun value
	 * 
	 * @generated NOT
	 */
	private int minValue = DEFAULT_INT_VALUE;

	/**
	 * @generated
	 */
	public InteractionOperandEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InteractionOperandItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new InteractionOperandLayoutEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new InteractionOperandDragDropEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new InteractionOperandComponentEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children
		// add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		XYLayoutEditPolicy lep = new XYLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = super.createChildEditPolicy(child);
				if (result == null) {
					return new ResizableShapeEditPolicy();
				}
				return result;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		CustomInteractionOperandFigure figure = new CustomInteractionOperandFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CustomInteractionOperandFigure getPrimaryShape() {
		return (CustomInteractionOperandFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.SOUTH);
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
	public class CustomInteractionOperandFigure extends InteractionOperandFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fInteractionConstraintLabel;

		/**
		 * @generated
		 */
		public CustomInteractionOperandFigure() {
			this.setLayoutManager(new XYLayout());

			this.setLineStyle(Graphics.LINE_DASH);

			this.setBorder(null);

			this.setLineSeparator(!firstOperand);

			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {
			fInteractionConstraintLabel = new WrappingLabel();
			fInteractionConstraintLabel.setText("");
			updateConstraintLabel();

			this.add(fInteractionConstraintLabel, new Rectangle(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(100), getMapMode().DPtoLP(20)));

		}

		/**
		 * Update the interaction constraint value
		 * 
		 * @param interactionOperand
		 *            The UML Interaction Operand
		 * @generated NOT
		 */
		protected void updateConstraintLabel() {
			fInteractionConstraintLabel.setText("");
			Object obj = getModel();
			if (obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
				EObject element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
				if (element instanceof InteractionOperand) {
					InteractionOperand interactionOperand = (InteractionOperand) element;
					InteractionConstraint guard = interactionOperand.getGuard();
					if (guard != null) {
						ValueSpecification maxint = guard.getMaxint();
						if (maxint instanceof LiteralInteger) {
							maxValue = maxint.integerValue();
						}
						ValueSpecification minint = guard.getMinint();
						if (minint instanceof LiteralInteger) {
							minValue = minint.integerValue();
						}
						ValueSpecification specification = guard.getSpecification();
						if (specification != null) {
							specValue = specification.stringValue();
						}

						StringBuilder sb = new StringBuilder("");

						String minimun = minValue != DEFAULT_INT_VALUE ? String.valueOf(minValue) : null;
						if (minimun != null) {
							sb.append("[").append(minimun);
							String maximun = maxValue != DEFAULT_INT_VALUE ? String.valueOf(maxValue) : null;
							if (maximun != null) {
								sb.append(",").append(maxValue);
							}
							sb.append("]");
						} else if (specValue != null && specValue.length() > 0) {
							sb.append("[").append(specValue).append("]");
						}

						fInteractionConstraintLabel.setText(sb.toString());
					}
				}
			}
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
		public WrappingLabel getInteractionConstraintLabel() {
			return fInteractionConstraintLabel;
		}

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
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionOperand",
						PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionOperand",
						PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionOperand",
						PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("InteractionOperand",
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
	 * Generated not for handle guard modification and update label.
	 * 
	 * @generated NOT
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		InteractionOperand interactionOperand = (InteractionOperand) resolveSemanticElement();

		Object newValue = notification.getNewValue();
		if (UMLPackage.eINSTANCE.getInteractionOperand_Guard().equals(feature)) {
			// Case of add, change or delete guard
			if (notification.getOldValue() instanceof InteractionConstraint) {
				notifier.unlistenEObject((InteractionConstraint) notification.getOldValue());
			}
			if (newValue instanceof InteractionConstraint) {
				notifier.listenEObject((InteractionConstraint) newValue);
			}
		} else if (UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature)) {
			// Case of add, change or delete Specification
			specValue = null;
			if (notification.getOldValue() instanceof ValueSpecification) {
				notifier.unlistenEObject((ValueSpecification) notification.getOldValue());
			}
			if (newValue instanceof ValueSpecification) {
				ValueSpecification newStringValue = (ValueSpecification) newValue;
				notifier.listenEObject(newStringValue);
				specValue = newStringValue.stringValue();
			}
			getPrimaryShape().updateConstraintLabel();
		} else if (UMLPackage.eINSTANCE.getInteractionConstraint_Minint().equals(feature)) {
			// Case of add, change or delete Minint
			minValue = DEFAULT_INT_VALUE;
			if (notification.getOldValue() instanceof LiteralInteger) {
				notifier.unlistenEObject((LiteralInteger) notification.getOldValue());
			}
			if (newValue instanceof LiteralInteger
					&& InteractionOperatorKind.LOOP_LITERAL.equals(getInteractionOperator())) {
				LiteralInteger newIntegerValue = (LiteralInteger) newValue;
				notifier.listenEObject(newIntegerValue);
				if (newIntegerValue.getValue() < 0) {
					newIntegerValue.setValue(0);
				}
				// If Maxint exist, min can't be greater than max
				else if (maxValue != DEFAULT_INT_VALUE && maxValue < newIntegerValue.getValue()) {
					newIntegerValue.setValue(maxValue);
				}
				newIntegerValue.setName("min");
				minValue = newIntegerValue.getValue();
			} else if (newValue != null) {
				interactionOperand.getGuard().setMinint(null);
			}
			getPrimaryShape().updateConstraintLabel();
		} else if (UMLPackage.eINSTANCE.getInteractionConstraint_Maxint().equals(feature)) {
			// Case of add, change or delete Maxint
			maxValue = DEFAULT_INT_VALUE;
			if (notification.getOldValue() instanceof LiteralInteger) {
				notifier.unlistenEObject((LiteralInteger) notification.getOldValue());
			}
			if (newValue instanceof LiteralInteger
					&& InteractionOperatorKind.LOOP_LITERAL.equals(getInteractionOperator())) {
				LiteralInteger newIntegerValue = (LiteralInteger) newValue;
				notifier.listenEObject(newIntegerValue);

				maxValue = newIntegerValue.getValue();
				maxValue = maxValue > minValue ? maxValue : minValue;
				newIntegerValue.setValue(maxValue);

				newIntegerValue.setName("max");

				// If Minint doesn't exist, creates it
				if (interactionOperand.getGuard().getMinint() == null) {
					LiteralInteger minint = UMLFactory.eINSTANCE.createLiteralInteger();
					minint.setValue(0);
					interactionOperand.getGuard().setMinint(minint);
				}
			} else if (newValue != null) {
				interactionOperand.getGuard().setMaxint(null);
			}
			getPrimaryShape().updateConstraintLabel();
		} else if (UMLPackage.eINSTANCE.getLiteralInteger_Value().equals(feature)
				&& interactionOperand.getGuard() != null) {
			// Case of add, change or delete Maxint
			if (notification.getNotifier().equals(interactionOperand.getGuard().getMinint())
					&& newValue instanceof Integer && notification.getNewIntValue() > maxValue
					&& maxValue != DEFAULT_INT_VALUE) {
				minValue = maxValue;
				((LiteralInteger) interactionOperand.getGuard().getMinint()).setValue(minValue);
			} else if (notification.getNotifier().equals(interactionOperand.getGuard().getMaxint())
					&& newValue instanceof Integer && notification.getNewIntValue() < minValue) {
				maxValue = minValue;
				((LiteralInteger) interactionOperand.getGuard().getMaxint()).setValue(maxValue);
			}
			getPrimaryShape().updateConstraintLabel();
		} else {
			getPrimaryShape().updateConstraintLabel();
		}

		super.handleNotificationEvent(notification);
	}

	/**
	 * Get the InteractionOperator of the CombinedFragment.
	 * 
	 * @generated NOT
	 * @return The InteractionOperator
	 */
	private InteractionOperatorKind getInteractionOperator() {
		InteractionOperatorKind interactionOperatorKind = null;

		EditPart parent = getParent();
		if (parent instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			parent = parent.getParent();
			if (parent instanceof CombinedFragmentEditPart) {
				EObject element = ((CombinedFragmentEditPart) parent).resolveSemanticElement();
				if (element instanceof CombinedFragment) {
					interactionOperatorKind = ((CombinedFragment) element).getInteractionOperator();
				}
			}
		}

		return interactionOperatorKind;
	}

	/**
	 * Set if this Edit Part is the first Operand of his CombinedFragment's parent.
	 * 
	 * @generated NOT
	 */
	public void setFirstOperand(boolean firstOperand) {
		this.firstOperand = firstOperand;
		if (primaryShape != null) {
			getPrimaryShape().setLineSeparator(!firstOperand);
		}
	}

	/**
	 * Activate listeners for InteractionOperand to handle notification in the guard
	 * 
	 * @generated NOT
	 */
	@Override
	public void activate() {
		addListeners();
		super.activate();
	}

	/**
	 * Desactivate listeners for InteractionOperand to handle notification in the guard
	 * 
	 * @generated NOT
	 */
	@Override
	public void deactivate() {
		removeListeners();
		super.deactivate();
	}

	/**
	 * Remove listeners for InteractionOperand to handle notification in the guard
	 * 
	 * @generated NOT
	 */
	@Override
	public void removeNotify() {
		removeListeners();
		super.removeNotify();
	}

	/**
	 * Add listeners for InteractionOperand to handle notification in the guard
	 * 
	 * @generated NOT
	 */
	private void addListeners() {
		Object obj = getModel();// get the InteractionUse associated to this editpart
		if (obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
			EObject element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
			if (element instanceof InteractionOperand) {
				InteractionConstraint guard = ((InteractionOperand) element).getGuard();
				if (guard != null) {
					notifier.listenEObject(guard);
					notifier.listenEObject(guard.getSpecification());
					notifier.listenEObject(guard.getMaxint());
					notifier.listenEObject(guard.getMinint());
				}
			}
		}
	}

	/**
	 * Remove listeners for InteractionOperand to handle notification in the guard
	 * 
	 * @generated NOT
	 */
	private void removeListeners() {
		Object obj = getModel();
		if (obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
			EObject element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
			if (element instanceof InteractionOperand) {
				InteractionConstraint guard = ((InteractionOperand) element).getGuard();
				if (guard != null) {
					notifier.unlistenEObject(guard);
					notifier.unlistenEObject(guard.getSpecification());
					notifier.unlistenEObject(guard.getMaxint());
					notifier.unlistenEObject(guard.getMinint());
				}
			}
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
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4004);
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
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
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
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Lifeline_3001);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionUse_3002);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.CombinedFragment_3004);
		}
		if (relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.InteractionOperand_3005);
		}
		return types;
	}

}
