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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.draw2d.LifelineDotLineFigure;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.Notifier;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
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
	 * @generated
	 */
	public LifelineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LifelineItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE,
		// new org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new LifelineXYLayoutEditPolicy());
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
	 * This operation returns the ExecutionSpecification EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @generated NOT
	 * @return the list of ExecutionSpecification EditParts
	 */
	public List<ShapeNodeEditPart> getExecutionSpecificationList() {
		List<ShapeNodeEditPart> executionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		for (Object obj : getChildren()) {
			if (obj instanceof BehaviorExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart) obj);
			} else if (obj instanceof ActionExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart) obj);
			}
		}
		return executionSpecificationList;
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
		return (LifelineFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LifelineNameEditPart) {
			((LifelineNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureLifelineLabelFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LifelineNameEditPart) {
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
	 * @generated NOT
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		// BES : Added
		if (editPart instanceof BehaviorExecutionSpecificationEditPart) {
			return getPrimaryShape().getFigureLifelineDotLineFigure();
		} else if (editPart instanceof ActionExecutionSpecificationEditPart) {
			// AES : Added
			return getPrimaryShape().getFigureLifelineDotLineFigure();
		}

		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 250);
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
	 * @generated NOT
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}

		// BES : Added
		if (nodeShape instanceof LifelineFigure) {
			LifelineFigure lFigure = (LifelineFigure) nodeShape;
			return lFigure.getFigureLifelineDotLineFigure();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
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
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if (targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart) {
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
		if (targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if (targetEditPart instanceof InteractionOperandEditPart) {
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
																							 * emf.
																							 * type
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
		private LifelineDotLineFigure fFigureLifelineDotLineFigure;

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
		public LifelineDotLineFigure getFigureLifelineDotLineFigure() {
			return fFigureLifelineDotLineFigure;
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLifelineNameContainerFigure = new RectangleFigure();
			fFigureLifelineNameContainerFigure.setLineWidth(1);

			fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode()
					.DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));

			this.add(fFigureLifelineNameContainerFigure, BorderLayout.TOP);
			fFigureLifelineNameContainerFigure.setLayoutManager(new StackLayout());

			fFigureLifelineLabelFigure = new WrappingLabel();
			fFigureLifelineLabelFigure.setText("<...>");

			fFigureLifelineNameContainerFigure.add(fFigureLifelineLabelFigure);

			fFigureExecutionsContainerFigure = new RectangleFigure();
			fFigureExecutionsContainerFigure.setFill(false);
			fFigureExecutionsContainerFigure.setOutline(false);
			fFigureExecutionsContainerFigure.setLineWidth(1);

			this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);
			fFigureExecutionsContainerFigure.setLayoutManager(new StackLayout());

			fFigureLifelineDotLineFigure = new LifelineDotLineFigure();

			fFigureExecutionsContainerFigure.add(fFigureLifelineDotLineFigure);
			fFigureLifelineDotLineFigure.setLayoutManager(new XYLayout());

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
				prefColor = PreferenceConstantHelper
						.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_LINE);
			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper
						.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_FONT);
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper
						.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore,
					prefColor));
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()
				|| feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Lifeline",
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

	@Override
	protected void handleNotificationEvent(Notification notification) {

		Object feature = notification.getFeature();

		if (UMLPackage.eINSTANCE.getLifeline_Represents().equals(feature))// handle the case when
		// the represent is set
		// , and update the name
		// of Lifeline
		{
			if (getModelEObject() instanceof Lifeline) {
				if (notification.getNewValue() instanceof Property) {

					notifier.listenEObject(((Property) notification.getNewValue()).getType());// handle
					// the
					// notification
					// if there
					// is
					// changement
					// in the
					// class
					// wich type
					// the
					// propertie

					notifier.listenEObject((Property) notification.getNewValue());// get a listener
					// in the
					// property to handle
					// the typed class is
					// changed

					setLifelineName(((Property) notification.getNewValue()).getType());
				}
				if (notification.getOldValue() instanceof Property) {
					notifier.unlistenEObject((((Property) notification.getOldValue()).getType()));
					notifier.unlistenEObject(((Property) notification.getOldValue()));

				}

			}
		}

		if (UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature)) {
			if (notification.getNewValue() instanceof Type) {// create a listener in the classs wich
				// type the property
				notifier.listenEObject((Type) notification.getNewValue());
				setLifelineName((Type) notification.getNewValue());

			}
			if (notification.getOldValue() instanceof Type) {
				notifier.unlistenEObject(((Type) notification.getOldValue()));

			}
			setLifelineName((Type) notification.getNewValue());
		}

		if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature)
				&& notification.getNotifier().equals(getRepresentsTypeElement())) {

			setLifelineName(getRepresentsTypeElement());// set the name in the lifeline if the the
			// name of the class wich type the property
			// is changed.

		}

		super.handleNotificationEvent(notification);

		if (NotationPackage.eINSTANCE.getSize_Width().equals(feature)) {
			autoResize();

		}

	}

	// TODO need to be refactored in super class

	/**
	 * get the Object Associated to the edit part
	 * 
	 * @return the object Associated to the edit part
	 */
	private EObject getModelEObject() {
		EObject element = null;
		Object obj = getModel();
		if (obj != null && obj instanceof org.eclipse.gmf.runtime.notation.Shape) {
			element = ((org.eclipse.gmf.runtime.notation.Shape) obj).getElement();
		}
		return element;

	}

	/**
	 * Gets the represents type element.
	 * 
	 * @return the type of the represented element in the lifeline
	 */
	private Type getRepresentsTypeElement() {
		Type type = null;
		EObject modelEObject = getModelEObject();
		if (modelEObject != null && modelEObject instanceof Lifeline) {
			if (((Lifeline) modelEObject).getRepresents() != null) {
				type = ((Lifeline) modelEObject).getRepresents().getType();
			}
		}
		return type;
	}

	/**
	 *Deactivate a listener for the Lifeline to Handle notification in the typed element of the
	 * represent Interaction
	 * 
	 */

	// private void listenEObject(EObject eObject) {
	// // Only listen the object if it isn't yet listened
	// if (eObject != null && !eObject.eAdapters().contains(modelListener)) {
	// eObject.eAdapters().add(modelListener);
	// }
	// }
	//
	// private void unlistenEObject(EObject object) {
	// // Only listen the object if it isn't yet listened
	// if (object != null && object.eAdapters().contains(modelListener)) {
	// object.eAdapters().remove(modelListener);
	// }
	// }

	/**
	 *Activate a listener for the interactionUse to Handle notification in the refered Interaction
	 * 
	 */

	public void activate() {
		super.activate();
		notifier.listenEObject(getRepresentsTypeElement());
		if (getModelEObject() != null && getModelEObject() instanceof Lifeline) {
			notifier.listenEObject(((Lifeline) (getModelEObject())).getRepresents());
		}

	}

	public void deactivate() {

		notifier.listenEObject(getRepresentsTypeElement());// activate the listener on
		// the typed object in the repesent
		if (getModelEObject() != null && getModelEObject() instanceof Lifeline) {
			notifier.unlistenEObject((((Lifeline) (getModelEObject())).getRepresents()));
		}

		super.deactivate();

	}

	private Notifier notifier = new Notifier(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	private void setLifelineName(Type type) {

		StringBuffer sb = new StringBuffer();
		if (((Lifeline) getModelEObject()).getName() != null) {
			sb.append(((Lifeline) getModelEObject()).getName());
		}
		if (type != null) {
			if (type.getName() != null && type.getName().length() > 0) {
				sb.append(" : ");
				sb.append(type.getName());
			}

		} else {
			sb.append("");

		}

		getPrimaryShape().getFigureLifelineLabelFigure().setText(sb.toString());
		refresh();

	}

	protected void autoResize() {

		Font font = getPrimaryShape().getFigureLifelineLabelFigure().getFont();
		String text = getPrimaryShape().getFigureLifelineLabelFigure().getText();

		Dimension d = FigureUtilities.getTextExtents(text, font);

		int newSize = d.width + 2;

		Dimension size = new Dimension(newSize, getFigure().getBounds().height);

		Point loc = new Point(getFigure().getBounds().x, getFigure().getBounds().y);

		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

}
