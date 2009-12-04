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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
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
import org.eclipse.papyrus.diagram.common.draw2d.PolylineContainer;
import org.eclipse.papyrus.diagram.common.edit.policies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.State4CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.State4ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class State4EditPart extends AbstractBorderedShapeEditPart implements
		PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2017;

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
	public State4EditPart(View view) {
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
				new State4ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new DeleteOnlyViewComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new State4CanonicalEditPolicy());
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
		CompositeStateComposedFigure figure = new CompositeStateComposedFigureAux();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CompositeStateComposedFigure getPrimaryShape() {
		return (CompositeStateComposedFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof StateName7EditPart) {
			((StateName7EditPart)childEditPart).setLabel(getPrimaryShape()
					.getFigureCompositeComposedFigure_name());
			return true;
		}
		if(childEditPart instanceof StateName8EditPart) {
			((StateName8EditPart)childEditPart).setLabel(getPrimaryShape()
					.getFigureCompositeSomposedStereotypesLabel());
			return true;
		}
		if(childEditPart instanceof Pseudostate9EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer()
					.add(((Pseudostate9EditPart)childEditPart).getFigure(),
					locator);
			return true;
		}
		if(childEditPart instanceof Pseudostate10EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((Pseudostate10EditPart)childEditPart).getFigure(),
					locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof Pseudostate9EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((Pseudostate9EditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof Pseudostate10EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((Pseudostate10EditPart)childEditPart).getFigure());
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
	 * @generated
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if(editPart instanceof Pseudostate9EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if(editPart instanceof Pseudostate10EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(100), getMapMode().DPtoLP(60));
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
				.getType(StateName7EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if(event.getNotifier() instanceof ShapeStyle) {
			super.handleNotificationEvent(event);

			// Propagate style
			for(Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if(!(obj instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart))
					continue;
				org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart ep = (org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)obj;

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

		} else {
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
	public class CompositeStateComposedFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureCompositeSomposedStereotypesLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureCompositeComposedFigure_name;

		/**
		 * @generated
		 */
		public CompositeStateComposedFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(16)));
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(90),
					getMapMode().DPtoLP(50)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure compositeComposedFigure_AuxBottom0 = new RectangleFigure();
			compositeComposedFigure_AuxBottom0.setFill(false);
			compositeComposedFigure_AuxBottom0.setOutline(false);

			this.add(compositeComposedFigure_AuxBottom0, BorderLayout.BOTTOM);

			BorderLayout layoutCompositeComposedFigure_AuxBottom0 = new BorderLayout();
			compositeComposedFigure_AuxBottom0
					.setLayoutManager(layoutCompositeComposedFigure_AuxBottom0);

			RectangleFigure compositeComposedFigure_AuxBottomLeft1 = new RectangleFigure();
			compositeComposedFigure_AuxBottomLeft1.setFill(false);
			compositeComposedFigure_AuxBottomLeft1.setOutline(false);

			compositeComposedFigure_AuxBottom0.add(
					compositeComposedFigure_AuxBottomLeft1, BorderLayout.RIGHT);
			compositeComposedFigure_AuxBottomLeft1
					.setLayoutManager(new StackLayout());

			PolylineContainer compositeComposedFigure_AuxIconOwner2 = new PolylineContainer();

			compositeComposedFigure_AuxIconOwner2
					.setPreferredSize(new Dimension(getMapMode().DPtoLP(35),
					getMapMode().DPtoLP(20)));

			compositeComposedFigure_AuxBottomLeft1
					.add(compositeComposedFigure_AuxIconOwner2);
			compositeComposedFigure_AuxIconOwner2
					.setLayoutManager(new XYLayout());

			Ellipse auxEllipse13 = new Ellipse();

			compositeComposedFigure_AuxIconOwner2.add(auxEllipse13,
					new Rectangle(getMapMode().DPtoLP(0), getMapMode()
					.DPtoLP(3), getMapMode().DPtoLP(13), getMapMode()
					.DPtoLP(13)));

			Ellipse auxEllipse23 = new Ellipse();

			compositeComposedFigure_AuxIconOwner2.add(auxEllipse23,
					new Rectangle(getMapMode().DPtoLP(17), getMapMode().DPtoLP(
					3), getMapMode().DPtoLP(13), getMapMode()
					.DPtoLP(13)));

			Polyline polyline3 = new Polyline();
			polyline3.addPoint(new Point(getMapMode().DPtoLP(13), getMapMode()
					.DPtoLP(9)));
			polyline3.addPoint(new Point(getMapMode().DPtoLP(17), getMapMode()
					.DPtoLP(9)));

			compositeComposedFigure_AuxIconOwner2.add(polyline3);

			RectangleFigure compositeComposedFigure_AuxCenter0 = new RectangleFigure();
			compositeComposedFigure_AuxCenter0.setFill(false);
			compositeComposedFigure_AuxCenter0.setOutline(false);

			this.add(compositeComposedFigure_AuxCenter0, BorderLayout.CENTER);

			GridLayout layoutCompositeComposedFigure_AuxCenter0 = new GridLayout();
			layoutCompositeComposedFigure_AuxCenter0.numColumns = 1;
			layoutCompositeComposedFigure_AuxCenter0.makeColumnsEqualWidth = true;
			compositeComposedFigure_AuxCenter0
					.setLayoutManager(layoutCompositeComposedFigure_AuxCenter0);

			fFigureCompositeSomposedStereotypesLabel = new WrappingLabel();
			fFigureCompositeSomposedStereotypesLabel.setText("");

			fFigureCompositeSomposedStereotypesLabel
					.setFont(FFIGURECOMPOSITESOMPOSEDSTEREOTYPESLABEL_FONT);

			fFigureCompositeSomposedStereotypesLabel
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2)));

			GridData constraintFFigureCompositeSomposedStereotypesLabel = new GridData();
			constraintFFigureCompositeSomposedStereotypesLabel.verticalAlignment = GridData.CENTER;
			constraintFFigureCompositeSomposedStereotypesLabel.horizontalAlignment = GridData.CENTER;
			constraintFFigureCompositeSomposedStereotypesLabel.horizontalIndent = 0;
			constraintFFigureCompositeSomposedStereotypesLabel.horizontalSpan = 1;
			constraintFFigureCompositeSomposedStereotypesLabel.verticalSpan = 1;
			constraintFFigureCompositeSomposedStereotypesLabel.grabExcessHorizontalSpace = true;
			constraintFFigureCompositeSomposedStereotypesLabel.grabExcessVerticalSpace = false;
			compositeComposedFigure_AuxCenter0.add(
					fFigureCompositeSomposedStereotypesLabel,
					constraintFFigureCompositeSomposedStereotypesLabel);

			fFigureCompositeComposedFigure_name = new WrappingLabel();
			fFigureCompositeComposedFigure_name.setText("");

			fFigureCompositeComposedFigure_name
					.setFont(FFIGURECOMPOSITECOMPOSEDFIGURE_NAME_FONT);

			fFigureCompositeComposedFigure_name.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			GridData constraintFFigureCompositeComposedFigure_name = new GridData();
			constraintFFigureCompositeComposedFigure_name.verticalAlignment = GridData.CENTER;
			constraintFFigureCompositeComposedFigure_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureCompositeComposedFigure_name.horizontalIndent = 0;
			constraintFFigureCompositeComposedFigure_name.horizontalSpan = 1;
			constraintFFigureCompositeComposedFigure_name.verticalSpan = 1;
			constraintFFigureCompositeComposedFigure_name.grabExcessHorizontalSpace = true;
			constraintFFigureCompositeComposedFigure_name.grabExcessVerticalSpace = true;
			compositeComposedFigure_AuxCenter0.add(
					fFigureCompositeComposedFigure_name,
					constraintFFigureCompositeComposedFigure_name);

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
		public WrappingLabel getFigureCompositeSomposedStereotypesLabel() {
			return fFigureCompositeSomposedStereotypesLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCompositeComposedFigure_name() {
			return fFigureCompositeComposedFigure_name;
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
	static final Font FFIGURECOMPOSITESOMPOSEDSTEREOTYPESLABEL_FONT = new Font(
			Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECOMPOSITECOMPOSEDFIGURE_NAME_FONT = new Font(
			Display.getCurrent(), "SANS", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	public class CompositeStateComposedFigureAux extends
			CompositeStateComposedFigure {

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
		public CompositeStateComposedFigureAux() {
			super();
			stereotypeParent = super
					.getFigureCompositeSomposedStereotypesLabel().getParent();
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			if(stereotypeParent.getChildren().contains(
					super.getFigureCompositeSomposedStereotypesLabel())) {
				stereotypeParent.getChildren().remove(
						super.getFigureCompositeSomposedStereotypesLabel());
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
		public WrappingLabel getFigureCompositeSomposedStereotypesLabel() {
			return figureStereotypeLabel;
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void reorderChild(EditPart child, int index) {
		// Save the constraint of the child so that it does not
		// get lost during the remove and re-add.
		IFigure childFigure = ((GraphicalEditPart)child).getFigure();
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart)child)
				.getLayoutManager();
		Object constraint = null;
		if(layout != null) {
			constraint = layout.getConstraint(childFigure);
		}
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
					if(gEP instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart
							&& ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)gEP)
							.resolveSemanticElement() == resolveSemanticElement()) {
						return false;
					}
					return true;
				} else {
					// Check if it is a child figure of the editpart
					for(java.lang.Object child : gEP.getChildren()) {
						if(child instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) {
							org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart childEP = (org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)child;
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
