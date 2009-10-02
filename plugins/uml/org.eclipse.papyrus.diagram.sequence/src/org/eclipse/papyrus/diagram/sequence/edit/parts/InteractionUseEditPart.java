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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
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
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.diagram.sequence.edit.policies.InteractionUseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.sequence.figures.InteractionUseRectangleFigure;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.Notifier;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT
 */
public class InteractionUseEditPart extends InteractionFragmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated NOT
	 */
	private Interaction myInteraction;

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
	 * @generated
	 */
	public InteractionUseEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InteractionUseItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new InteractionUseRectangleFigure();
	}

	/**
	 * @generated
	 */
	public InteractionUseRectangleFigure getPrimaryShape() {
		return (InteractionUseRectangleFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InteractionUseName2EditPart) {
			((InteractionUseName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureInteractionUseName());
			return true;
		}
		if (childEditPart instanceof InteractionUseNameEditPart) {
			((InteractionUseNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureInteractionUseRef());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InteractionUseName2EditPart) {
			return true;
		}
		if (childEditPart instanceof InteractionUseNameEditPart) {
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
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
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
	 * @generated-Not
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InteractionUseNameEditPart.VISUAL_ID));
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
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionUse",
						PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionUse",
						PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("InteractionUse",
						PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("InteractionUse",
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
	 * @generated NOT
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {

		Object feature = notification.getFeature();

		if (UMLPackage.eINSTANCE.getInteractionUse_RefersTo().equals(feature)) {
			if (notification.getOldValue() instanceof Interaction) {
				notifier.unlistenEObject((Interaction) notification.getOldValue());
			}
			if (notification.getNewValue() instanceof Interaction) {
				myInteraction = (Interaction) notification.getNewValue();
				notifier.listenEObject(myInteraction);
			}
		}
		if (UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature)) {
			activate();
			resizeInteractionFragmentFigure();
		}
		if (notification.getEventType() == Notification.SET) {
			Object notifier = notification.getNotifier();
			if (notifier instanceof Interaction) {
				setInteracionUseName((Interaction) notifier);
			}
		}
		super.handleNotificationEvent(notification);
	}

	/**
	 *Activate a listener for the interactionUse to Handle notification in the refered Interaction
	 * 
	 * @generated NOT
	 */
	public void activate() {
		super.activate();
		Object obj = getModel();// get the InteractionUse associated to this editpart
		if (obj != null && obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
			EObject element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
			if (element instanceof InteractionUse) {
				notifier.listenEObject(((InteractionUse) element).getRefersTo());// activate the
				// listener on
				// the referred interaction
			}
		}
	}

	/**
	 *Deactivate a listener for the interactionUse to Handle notification in the refered
	 * Interaction
	 * 
	 * @generated NOT
	 */
	public void deactivate() {
		super.deactivate();
		Object obj = getModel();
		if (obj != null && obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
			EObject element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
			if (element instanceof InteractionUse) {
				notifier.unlistenEObject(((InteractionUse) element).getRefersTo());
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void removeNotify() {
		notifier.unlistenEObject(myInteraction);
		super.removeNotify();

	}

	/**
	 * @generated NOT
	 */
	private void setInteracionUseName(Interaction myInteraction) {
		if (getPrimaryShape() != null && getPrimaryShape().getFigureInteractionUseName() != null) {
			getPrimaryShape().getFigureInteractionUseName().setText(myInteraction.getName());
			getPrimaryShape().getFigureInteractionUseName().repaint();
			refresh();
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
