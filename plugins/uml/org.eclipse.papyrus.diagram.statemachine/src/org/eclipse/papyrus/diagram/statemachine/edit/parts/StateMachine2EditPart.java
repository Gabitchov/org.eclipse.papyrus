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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.papyrus.diagram.common.draw2d.LaneLayout;
import org.eclipse.papyrus.diagram.common.edit.policies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.StateMachine2CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.StateMachine2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class StateMachine2EditPart extends AbstractBorderedShapeEditPart
		implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1001;

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
	public StateMachine2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 * 
	 * @author mgil
	 *         Commented to remove the default DRAG_DROP_ROLE policy
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StateMachine2ItemSemanticEditPolicy());
		//		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
		//				new DragDropEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new DeleteOnlyViewComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new StateMachine2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
		StateMachineFigure figure = new StateMachineFigureAux();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public StateMachineFigure getPrimaryShape() {
		return (StateMachineFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateMachineNameEditPart) {
			((StateMachineNameEditPart)childEditPart)
					.setLabel(getPrimaryShape()
					.getFigureStateMachineFigure_name());
			return true;
		}
		if(childEditPart instanceof StateMachineName2EditPart) {
			((StateMachineName2EditPart)childEditPart)
					.setLabel(getPrimaryShape()
					.getFigureStateMachineStereotypesLabel());
			return true;
		}
		if(childEditPart instanceof Pseudostate13EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((Pseudostate13EditPart)childEditPart).getFigure(),
					locator);
			return true;
		}
		if(childEditPart instanceof Pseudostate14EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((Pseudostate14EditPart)childEditPart).getFigure(),
					locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof Pseudostate13EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((Pseudostate13EditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof Pseudostate14EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((Pseudostate14EditPart)childEditPart).getFigure());
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
	 * @generated NOT
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if(editPart instanceof Pseudostate13EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if(editPart instanceof Pseudostate14EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		/*
		 * colocamos el elemento region dentro del rect�ngulo inferior de
		 * la figura StateMachine
		 */
		if(editPart instanceof RegionEditPart) {
			return getPrimaryShape().getFigureStateMachineFigure_Body();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(600), getMapMode().DPtoLP(400));
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
		if(contentPane != null) {
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
				.getType(StateMachineNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {

		if(event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations()
				.equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else if(event.getNotifier() instanceof ShapeStyle) {
			super.handleNotificationEvent(event);

			// Propagate style
			for(Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if(!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart)obj;

				if(ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle)((View)ep.getModel())
						.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if(style != null) {
					style.eSet((EStructuralFeature)event.getFeature(), event
							.getNewValue());
					ep.refresh();
				}
			}

		}

		else {
			super.handleNotificationEvent(event);
		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		DiagramEditPartsUtil
				.handleNotificationForDiagram(this, event, features);
	}

	/**
	 * @generated
	 */
	public class StateMachineFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateMachineStereotypesLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateMachineFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureStateMachineFigure_Body;

		/**
		 * @generated
		 */
		public StateMachineFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(18),
					getMapMode().DPtoLP(18)));
			this.setForegroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure stateMachineFigure_NameContainer0 = new RectangleFigure();
			stateMachineFigure_NameContainer0.setFill(false);
			stateMachineFigure_NameContainer0.setOutline(false);

			GridData constraintStateMachineFigure_NameContainer0 = new GridData();
			constraintStateMachineFigure_NameContainer0.verticalAlignment = GridData.FILL;
			constraintStateMachineFigure_NameContainer0.horizontalAlignment = GridData.FILL;
			constraintStateMachineFigure_NameContainer0.horizontalIndent = 0;
			constraintStateMachineFigure_NameContainer0.horizontalSpan = 1;
			constraintStateMachineFigure_NameContainer0.verticalSpan = 1;
			constraintStateMachineFigure_NameContainer0.grabExcessHorizontalSpace = true;
			constraintStateMachineFigure_NameContainer0.grabExcessVerticalSpace = false;
			this.add(stateMachineFigure_NameContainer0,
					constraintStateMachineFigure_NameContainer0);

			GridLayout layoutStateMachineFigure_NameContainer0 = new GridLayout();
			layoutStateMachineFigure_NameContainer0.numColumns = 1;
			layoutStateMachineFigure_NameContainer0.makeColumnsEqualWidth = true;
			layoutStateMachineFigure_NameContainer0.horizontalSpacing = 0;
			layoutStateMachineFigure_NameContainer0.verticalSpacing = 0;
			layoutStateMachineFigure_NameContainer0.marginWidth = 3;
			layoutStateMachineFigure_NameContainer0.marginHeight = 3;
			stateMachineFigure_NameContainer0
					.setLayoutManager(layoutStateMachineFigure_NameContainer0);

			fFigureStateMachineStereotypesLabel = new WrappingLabel();
			fFigureStateMachineStereotypesLabel.setText("");

			fFigureStateMachineStereotypesLabel
					.setFont(FFIGURESTATEMACHINESTEREOTYPESLABEL_FONT);

			GridData constraintFFigureStateMachineStereotypesLabel = new GridData();
			constraintFFigureStateMachineStereotypesLabel.verticalAlignment = GridData.CENTER;
			constraintFFigureStateMachineStereotypesLabel.horizontalAlignment = GridData.CENTER;
			constraintFFigureStateMachineStereotypesLabel.horizontalIndent = 0;
			constraintFFigureStateMachineStereotypesLabel.horizontalSpan = 1;
			constraintFFigureStateMachineStereotypesLabel.verticalSpan = 1;
			constraintFFigureStateMachineStereotypesLabel.grabExcessHorizontalSpace = true;
			constraintFFigureStateMachineStereotypesLabel.grabExcessVerticalSpace = false;
			stateMachineFigure_NameContainer0.add(
					fFigureStateMachineStereotypesLabel,
					constraintFFigureStateMachineStereotypesLabel);

			fFigureStateMachineFigure_name = new WrappingLabel();
			fFigureStateMachineFigure_name.setText("");

			fFigureStateMachineFigure_name
					.setFont(FFIGURESTATEMACHINEFIGURE_NAME_FONT);

			GridData constraintFFigureStateMachineFigure_name = new GridData();
			constraintFFigureStateMachineFigure_name.verticalAlignment = GridData.CENTER;
			constraintFFigureStateMachineFigure_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureStateMachineFigure_name.horizontalIndent = 0;
			constraintFFigureStateMachineFigure_name.horizontalSpan = 1;
			constraintFFigureStateMachineFigure_name.verticalSpan = 1;
			constraintFFigureStateMachineFigure_name.grabExcessHorizontalSpace = true;
			constraintFFigureStateMachineFigure_name.grabExcessVerticalSpace = true;
			stateMachineFigure_NameContainer0.add(
					fFigureStateMachineFigure_name,
					constraintFFigureStateMachineFigure_name);

			fFigureStateMachineFigure_Body = new RectangleFigure();
			fFigureStateMachineFigure_Body.setOutline(false);

			GridData constraintFFigureStateMachineFigure_Body = new GridData();
			constraintFFigureStateMachineFigure_Body.verticalAlignment = GridData.FILL;
			constraintFFigureStateMachineFigure_Body.horizontalAlignment = GridData.FILL;
			constraintFFigureStateMachineFigure_Body.horizontalIndent = 0;
			constraintFFigureStateMachineFigure_Body.horizontalSpan = 1;
			constraintFFigureStateMachineFigure_Body.verticalSpan = 1;
			constraintFFigureStateMachineFigure_Body.grabExcessHorizontalSpace = true;
			constraintFFigureStateMachineFigure_Body.grabExcessVerticalSpace = true;
			this.add(fFigureStateMachineFigure_Body,
					constraintFFigureStateMachineFigure_Body);

			LaneLayout layoutFFigureStateMachineFigure_Body = new LaneLayout();

			fFigureStateMachineFigure_Body
					.setLayoutManager(layoutFFigureStateMachineFigure_Body);

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
		public WrappingLabel getFigureStateMachineStereotypesLabel() {
			return fFigureStateMachineStereotypesLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateMachineFigure_name() {
			return fFigureStateMachineFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureStateMachineFigure_Body() {
			return fFigureStateMachineFigure_Body;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEMACHINESTEREOTYPESLABEL_FONT = new Font(
			Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURESTATEMACHINEFIGURE_NAME_FONT = new Font(Display
			.getCurrent(), "SANS", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	public class StateMachineFigureAux extends StateMachineFigure {

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
		public StateMachineFigureAux() {
			super();
			stereotypeParent = super.getFigureStateMachineStereotypesLabel()
					.getParent();
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			if(stereotypeParent.getChildren().contains(
					super.getFigureStateMachineStereotypesLabel())) {
				stereotypeParent.getChildren().remove(
						super.getFigureStateMachineStereotypesLabel());
			}

			figureStereotypeLabel = new WrappingLabel() {

				@Override
				public void setText(String text) {
					if(stereotypeParent == null || text == null) {
						super.setText(text);
						return;
					}

					if(text.equals("")) {
						super.setText(text);
						if(stereotypeParent.getChildren().contains(this)) {
							stereotypeParent.remove(this);
						}
					} else {
						super.setText(text);
						if(!stereotypeParent.getChildren().contains(this)) {
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
		public WrappingLabel getFigureStateMachineStereotypesLabel() {
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
		IFigure childFigure = ((GraphicalEditPart)child).getFigure();
		//the only change is here! getContentPaneFor() is used instead of getContentPane()
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart)child)
				.getLayoutManager();
		Object constraint = null;
		if(layout != null)
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
		if(eAnn == null)
			return new ArrayList<EObject>();
		else
			return eAnn.getReferences();
	}

	/**
	 * @generated
	 */
	public static boolean isLabel(IFigure figure) {
		if(figure instanceof Label) {
			return true;
		}
		if(figure instanceof WrappingLabel) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean isFigureFromChildEditPart(IFigure figure) {
		for(Iterator i = getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if(obj instanceof AbstractGraphicalEditPart) {
				AbstractGraphicalEditPart gEP = (AbstractGraphicalEditPart)obj;
				if(gEP.getFigure() == figure) {
					// Check if semantic elements are different
					if(gEP instanceof GraphicalEditPart
							&& ((GraphicalEditPart)gEP)
							.resolveSemanticElement() == resolveSemanticElement()) {
						return false;
					}
					return true;
				} else {
					// Check if it is a child figure of the editpart
					for(java.lang.Object child : gEP.getChildren()) {
						if(child instanceof GraphicalEditPart) {
							GraphicalEditPart childEP = (GraphicalEditPart)child;
							if(childEP.getFigure() == figure) {
								if(childEP.resolveSemanticElement() != resolveSemanticElement())
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
		if(changesFromDefaultStyle().contains(
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
		for(Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if(obj instanceof IFigure
					&& !isFigureFromChildEditPart((IFigure)obj)) {
				setOwnedFiguresBackgroundColor((IFigure)obj, color);
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if(changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresForegroundColor(getFigure(), color);
		} else
			super.setForegroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresForegroundColor(IFigure parent, Color color) {
		if(!isLabel(parent))
			parent.setForegroundColor(color);
		for(Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if(obj instanceof IFigure && !isLabel((IFigure)obj)
					&& !isFigureFromChildEditPart((IFigure)obj)) {
				setOwnedFiguresForegroundColor((IFigure)obj, color);
			}
		}
	}

	/**
	 * @generated
	 */

	@Override
	protected void setFontColor(Color color) {
		// Only update if the Node doesn't have the default style
		if(changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresFontColor(getFigure(), color);
		} else
			super.setFontColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresFontColor(IFigure parent, Color color) {
		if(isLabel(parent))
			parent.setForegroundColor(color);
		for(Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if(obj instanceof IFigure && isLabel((IFigure)obj)
					&& !isFigureFromChildEditPart((IFigure)obj)) {
				setOwnedFiguresFontColor((IFigure)obj, color);
			}
		}
	}

}
