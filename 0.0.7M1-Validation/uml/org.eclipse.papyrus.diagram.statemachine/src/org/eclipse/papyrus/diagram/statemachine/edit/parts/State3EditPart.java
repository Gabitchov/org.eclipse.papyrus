/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.AnnotateNodeStyleCommand;
import org.eclipse.papyrus.diagram.common.edit.policies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.State3CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.State3ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class State3EditPart extends AbstractBorderedShapeEditPart implements
		PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

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
	public State3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new State3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new DeleteOnlyViewComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new State3CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				// Commented to show the "virtual" link that links the two nodes
				// if (child instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart) {
				// 	return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
				// }
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		SubmachineStateFigure figure = new SubmachineStateFigureAux();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SubmachineStateFigure getPrimaryShape() {
		return (SubmachineStateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateName5EditPart) {
			((StateName5EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureSubmachineState_machineName());
			return true;
		}
		if (childEditPart instanceof StateName6EditPart) {
			((StateName6EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureSubmachineStereotypesLabal());
			return true;
		}
		if (childEditPart instanceof ConnectionPointReferenceEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((ConnectionPointReferenceEditPart) childEditPart)
							.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof ConnectionPointReference2EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((ConnectionPointReference2EditPart) childEditPart)
							.getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ConnectionPointReferenceEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((ConnectionPointReferenceEditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof ConnectionPointReference2EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((ConnectionPointReference2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof ConnectionPointReferenceEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof ConnectionPointReference2EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(60), getMapMode().DPtoLP(30));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry
				.getType(StateName5EditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations()
						.equals(notification.getFeature())) {
			handleMajorSemanticChange();
		} else if (notification.getNotifier() instanceof ShapeStyle) {
			super.handleNotificationEvent(notification);

			// Propagate style
			for (Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if (!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart) obj;

				if (ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle) ((View) ep.getModel())
						.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if (style != null) {
					style.eSet((EStructuralFeature) notification.getFeature(),
							notification.getNewValue());
					ep.refresh();
				}
			}

		}

		else {
			super.handleNotificationEvent(notification);
		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		DiagramEditPartsUtil
				.handleNotificationForDiagram(this, notification, features);

		if (notification.getEventType() == Notification.SET
				&& UMLPackage.eINSTANCE.getState_Submachine() == notification
						.getFeature()) {
			DiagramEditPartsUtil.updateEditPart((IGraphicalEditPart) this
					.getParent());
		}
	}

	/**
	 * @generated
	 */
	public class SubmachineStateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSubmachineStereotypesLabal;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSubmachineState_machineName;

		/**
		 * @generated
		 */
		public SubmachineStateFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(18),
					getMapMode().DPtoLP(18)));
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(60),
					getMapMode().DPtoLP(30)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureSubmachineStereotypesLabal = new WrappingLabel();
			fFigureSubmachineStereotypesLabal.setText("");

			fFigureSubmachineStereotypesLabal
					.setFont(FFIGURESUBMACHINESTEREOTYPESLABAL_FONT);

			fFigureSubmachineStereotypesLabal.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));

			GridData constraintFFigureSubmachineStereotypesLabal = new GridData();
			constraintFFigureSubmachineStereotypesLabal.verticalAlignment = GridData.CENTER;
			constraintFFigureSubmachineStereotypesLabal.horizontalAlignment = GridData.CENTER;
			constraintFFigureSubmachineStereotypesLabal.horizontalIndent = 0;
			constraintFFigureSubmachineStereotypesLabal.horizontalSpan = 1;
			constraintFFigureSubmachineStereotypesLabal.verticalSpan = 1;
			constraintFFigureSubmachineStereotypesLabal.grabExcessHorizontalSpace = true;
			constraintFFigureSubmachineStereotypesLabal.grabExcessVerticalSpace = false;
			this.add(fFigureSubmachineStereotypesLabal,
					constraintFFigureSubmachineStereotypesLabal);

			WrappingLabel simpleStateFigure_Submachine0 = new WrappingLabel();
			simpleStateFigure_Submachine0.setText("Submachine:");

			simpleStateFigure_Submachine0
					.setFont(SIMPLESTATEFIGURE_SUBMACHINE0_FONT);

			GridData constraintSimpleStateFigure_Submachine0 = new GridData();
			constraintSimpleStateFigure_Submachine0.verticalAlignment = GridData.CENTER;
			constraintSimpleStateFigure_Submachine0.horizontalAlignment = GridData.CENTER;
			constraintSimpleStateFigure_Submachine0.horizontalIndent = 0;
			constraintSimpleStateFigure_Submachine0.horizontalSpan = 1;
			constraintSimpleStateFigure_Submachine0.verticalSpan = 1;
			constraintSimpleStateFigure_Submachine0.grabExcessHorizontalSpace = true;
			constraintSimpleStateFigure_Submachine0.grabExcessVerticalSpace = true;
			this.add(simpleStateFigure_Submachine0,
					constraintSimpleStateFigure_Submachine0);

			fFigureSubmachineState_machineName = new WrappingLabel();
			fFigureSubmachineState_machineName.setText("");

			fFigureSubmachineState_machineName
					.setFont(FFIGURESUBMACHINESTATE_MACHINENAME_FONT);

			fFigureSubmachineState_machineName.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));

			GridData constraintFFigureSubmachineState_machineName = new GridData();
			constraintFFigureSubmachineState_machineName.verticalAlignment = GridData.CENTER;
			constraintFFigureSubmachineState_machineName.horizontalAlignment = GridData.CENTER;
			constraintFFigureSubmachineState_machineName.horizontalIndent = 0;
			constraintFFigureSubmachineState_machineName.horizontalSpan = 1;
			constraintFFigureSubmachineState_machineName.verticalSpan = 1;
			constraintFFigureSubmachineState_machineName.grabExcessHorizontalSpace = true;
			constraintFFigureSubmachineState_machineName.grabExcessVerticalSpace = false;
			this.add(fFigureSubmachineState_machineName,
					constraintFFigureSubmachineState_machineName);

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
		public WrappingLabel getFigureSubmachineStereotypesLabal() {
			return fFigureSubmachineStereotypesLabal;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSubmachineState_machineName() {
			return fFigureSubmachineState_machineName;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 0, 0, 0);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 253, 253, 221);

	/**
	 * @generated
	 */
	static final Font FFIGURESUBMACHINESTEREOTYPESLABAL_FONT = new Font(Display
			.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font SIMPLESTATEFIGURE_SUBMACHINE0_FONT = new Font(Display
			.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESUBMACHINESTATE_MACHINENAME_FONT = new Font(
			Display.getCurrent(), "SANS", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	public class SubmachineStateFigureAux extends SubmachineStateFigure {
		/**
		 * @generated
		 */
		private WrappingLabel figureStereotypeLabel;

		/**
		 * @generated
		 */
		private IFigure stereotypeParent;

		/**
		 * @generated
		 */
		public SubmachineStateFigureAux() {
			super();
			stereotypeParent = super.getFigureSubmachineStereotypesLabal()
					.getParent();
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			if (stereotypeParent.getChildren().contains(
					super.getFigureSubmachineStereotypesLabal())) {
				stereotypeParent.getChildren().remove(
						super.getFigureSubmachineStereotypesLabal());
			}

			figureStereotypeLabel = new WrappingLabel() {
				@Override
				public void setText(String text) {
					if (stereotypeParent == null || text == null) {
						super.setText(text);
						return;
					}

					if (text.equals("")) {
						super.setText(text);
						if (stereotypeParent.getChildren().contains(this)) {
							stereotypeParent.remove(this);
						}
					} else {
						super.setText(text);
						if (!stereotypeParent.getChildren().contains(this)) {
							stereotypeParent.add(this, 0);
						}
					}
				}
			};
			figureStereotypeLabel.setText("");

			Font stereotypeLabelFont = new Font(Display.getCurrent(), "SANS",
					9, SWT.NORMAL);
			figureStereotypeLabel.setFont(stereotypeLabelFont);

			figureStereotypeLabel.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2)));

			GridData stereotypeLabelConstraint = new GridData();
			stereotypeLabelConstraint.verticalAlignment = GridData.CENTER;
			stereotypeLabelConstraint.horizontalAlignment = GridData.CENTER;
			stereotypeLabelConstraint.horizontalIndent = 0;
			stereotypeLabelConstraint.horizontalSpan = 1;
			stereotypeLabelConstraint.verticalSpan = 1;
			stereotypeLabelConstraint.grabExcessHorizontalSpace = true;
			stereotypeLabelConstraint.grabExcessVerticalSpace = false;
			stereotypeParent.add(figureStereotypeLabel,
					stereotypeLabelConstraint, 0);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSubmachineStereotypesLabal() {
			return figureStereotypeLabel;
		}
	}

	/**
	 * @generated not
	 */
	@Override
	protected void reorderChild(EditPart child, int index) {
		// Save the constraint of the child so that it does not
		// get lost during the remove and re-add.
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		// the only change is here! getContentPaneFor() is used instead of
		// getContentPane()
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart) child)
				.getLayoutManager();
		Object constraint = null;
		if (layout != null)
			constraint = layout.getConstraint(childFigure);

		super.reorderChild(child, index);
		setLayoutConstraint(child, childFigure, constraint);
	}

	/**
	 * @generated
	 */
	protected EAnnotation getAppearenceEAnnotation() {
		EAnnotation eAnn = getPrimaryView().getEAnnotation(
				AnnotateNodeStyleCommand.APPEARANCE_EANNOTATION_NAME);
		return eAnn;
	}

	/**
	 * @generated
	 */
	private List<EObject> changesFromDefaultStyle() {
		EAnnotation eAnn = getAppearenceEAnnotation();
		if (eAnn == null)
			return new ArrayList<EObject>();
		else
			return eAnn.getReferences();
	}

	/**
	 * @generated
	 */
	public static boolean isLabel(IFigure figure) {
		if (figure instanceof Label) {
			return true;
		}
		if (figure instanceof WrappingLabel) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean isFigureFromChildEditPart(IFigure figure) {
		for (Iterator i = getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if (obj instanceof AbstractGraphicalEditPart) {
				AbstractGraphicalEditPart gEP = (AbstractGraphicalEditPart) obj;
				if (gEP.getFigure() == figure) {
					// Check if semantic elements are different
					if (gEP instanceof GraphicalEditPart
							&& ((GraphicalEditPart) gEP)
									.resolveSemanticElement() == resolveSemanticElement()) {
						return false;
					}
					return true;
				} else {
					// Check if it is a child figure of the editpart
					for (java.lang.Object child : gEP.getChildren()) {
						if (child instanceof GraphicalEditPart) {
							GraphicalEditPart childEP = (GraphicalEditPart) child;
							if (childEP.getFigure() == figure) {
								if (childEP.resolveSemanticElement() != resolveSemanticElement())
									return true;
								else
									return false;
							}
						}
					}
				} // end else
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if (changesFromDefaultStyle().contains(
				NotationPackage.Literals.FILL_STYLE__FILL_COLOR)) {
			setOwnedFiguresBackgroundColor(getFigure(), color);
		} else
			super.setBackgroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresBackgroundColor(IFigure parent, Color color) {
		parent.setBackgroundColor(color);
		for (Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof IFigure
					&& !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresBackgroundColor((IFigure) obj, color);
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if (changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresForegroundColor(getFigure(), color);
		} else
			super.setForegroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresForegroundColor(IFigure parent, Color color) {
		if (!isLabel(parent))
			parent.setForegroundColor(color);
		for (Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if (obj instanceof IFigure && !isLabel((IFigure) obj)
					&& !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresForegroundColor((IFigure) obj, color);
			}
		}
	}

	/**
	 * @generated
	 */

	@Override
	protected void setFontColor(Color color) {
		// Only update if the Node doesn't have the default style
		if (changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresFontColor(getFigure(), color);
		} else
			super.setFontColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresFontColor(IFigure parent, Color color) {
		if (isLabel(parent))
			parent.setForegroundColor(color);
		for (Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof IFigure && isLabel((IFigure) obj)
					&& !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresFontColor((IFigure) obj, color);
			}
		}
	}

}
