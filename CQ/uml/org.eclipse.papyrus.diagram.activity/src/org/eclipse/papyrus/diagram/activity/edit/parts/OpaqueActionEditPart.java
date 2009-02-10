/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.parts;

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
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
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
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpaqueActionCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpaqueActionItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.edit.policies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;

/**
 * @generated
 */
public class OpaqueActionEditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2014;

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
	public OpaqueActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OpaqueActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DeleteOnlyViewComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OpaqueActionCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				// Commented to show the "virtual" link that links the two nodes
				// if (child instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart) {
				// return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
				// }
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
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
		ActionBaseFigure figure = new ActionBaseFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActionBaseFigure getPrimaryShape() {
		return (ActionBaseFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof OpaqueActionNameEditPart) {
			((OpaqueActionNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureActionBaseFigure_name());
			return true;
		}
		if (childEditPart instanceof OpaqueActionName2EditPart) {
			((OpaqueActionName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureActionBaseFigure_stereotypes());
			return true;
		}
		if (childEditPart instanceof ValuePin2EditPart) {
			IBorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((ValuePin2EditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof InputPin4EditPart) {
			IBorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(((InputPin4EditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof OutputPin2EditPart) {
			IBorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(((OutputPin2EditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * Modified to remove the pins from the BorderItemContainer
	 * 
	 * @generated NOT
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ValuePin2EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ValuePin2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InputPin4EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InputPin4EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof OutputPin2EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutputPin2EditPart) childEditPart).getFigure());
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
	 * Modified to return the BorderITemContainer for pins
	 * 
	 * @generated NOT
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof ValuePin2EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof InputPin4EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof OutputPin2EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(160), getMapMode().DPtoLP(60));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated figure.
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() instanceof ShapeStyle) {
			addChangesToAppearenceEAnnotation((EAttribute) event.getFeature());
			super.handleNotificationEvent(event);

			// Propagate style
			for (Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if (!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart) obj;

				if (ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle) ((View) ep.getModel()).getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if (style != null) {
					style.eSet((EStructuralFeature) event.getFeature(), event.getNewValue());
					ep.refresh();
				}
			}

		} else {
			super.handleNotificationEvent(event);
		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getExecutableNode_Handler());
		features.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		DiagramEditPartsUtil.handleNotificationForDiagram(this, event, features);
	}

	/**
	 * @generated
	 */
	public class ActionBaseFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureActionBaseFigure_stereotypes;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureActionBaseFigure_name;

		/**
		 * @generated
		 */
		public ActionBaseFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(16)));
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(THIS_BACK);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(6)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureActionBaseFigure_stereotypes = new WrappingLabel();
			fFigureActionBaseFigure_stereotypes.setText("");

			fFigureActionBaseFigure_stereotypes.setFont(FFIGUREACTIONBASEFIGURE_STEREOTYPES_FONT);

			fFigureActionBaseFigure_stereotypes.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5), getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			GridData constraintFFigureActionBaseFigure_stereotypes = new GridData();
			constraintFFigureActionBaseFigure_stereotypes.verticalAlignment = GridData.CENTER;
			constraintFFigureActionBaseFigure_stereotypes.horizontalAlignment = GridData.CENTER;
			constraintFFigureActionBaseFigure_stereotypes.horizontalIndent = 0;
			constraintFFigureActionBaseFigure_stereotypes.horizontalSpan = 1;
			constraintFFigureActionBaseFigure_stereotypes.verticalSpan = 1;
			constraintFFigureActionBaseFigure_stereotypes.grabExcessHorizontalSpace = false;
			constraintFFigureActionBaseFigure_stereotypes.grabExcessVerticalSpace = false;
			this.add(fFigureActionBaseFigure_stereotypes, constraintFFigureActionBaseFigure_stereotypes);

			fFigureActionBaseFigure_name = new WrappingLabel();
			fFigureActionBaseFigure_name.setText("");

			fFigureActionBaseFigure_name.setFont(FFIGUREACTIONBASEFIGURE_NAME_FONT);

			fFigureActionBaseFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5), getMapMode().DPtoLP(2), getMapMode().DPtoLP(5)));

			GridData constraintFFigureActionBaseFigure_name = new GridData();
			constraintFFigureActionBaseFigure_name.verticalAlignment = GridData.CENTER;
			constraintFFigureActionBaseFigure_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureActionBaseFigure_name.horizontalIndent = 0;
			constraintFFigureActionBaseFigure_name.horizontalSpan = 1;
			constraintFFigureActionBaseFigure_name.verticalSpan = 1;
			constraintFFigureActionBaseFigure_name.grabExcessHorizontalSpace = true;
			constraintFFigureActionBaseFigure_name.grabExcessVerticalSpace = true;
			this.add(fFigureActionBaseFigure_name, constraintFFigureActionBaseFigure_name);

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
		public WrappingLabel getFigureActionBaseFigure_stereotypes() {
			return fFigureActionBaseFigure_stereotypes;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureActionBaseFigure_name() {
			return fFigureActionBaseFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 253, 253, 221);

	/**
	 * @generated
	 */
	static final Font FFIGUREACTIONBASEFIGURE_STEREOTYPES_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREACTIONBASEFIGURE_NAME_FONT = new Font(Display.getCurrent(), "SANS", 10, SWT.BOLD);

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
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart) child).getLayoutManager();
		Object constraint = null;
		if (layout != null)
			constraint = layout.getConstraint(childFigure);

		super.reorderChild(child, index);
		setLayoutConstraint(child, childFigure, constraint);
	}

	/**
	 * @generated
	 */
	public static final String APPEARANCE_EANNOTATION_NAME = "org.eclipse.papyrus.diagram.common.gmfextension.appearance";

	/**
	 * @generated
	 */
	protected EAnnotation getAppearenceEAnnotation() {
		EAnnotation eAnn = getPrimaryView().getEAnnotation(APPEARANCE_EANNOTATION_NAME);
		return eAnn;
	}

	/**
	 * @generated
	 */
	protected EAnnotation createAppearenceEAnnotation() {
		EAnnotation eAnn = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnn.setSource(APPEARANCE_EANNOTATION_NAME);
		getPrimaryView().getEAnnotations().add(eAnn);
		return eAnn;
	}

	/**
	 * @generated
	 */
	protected void addChangesToAppearenceEAnnotation(EAttribute attribute) {
		// Get the EAnnotation
		EAnnotation eAnn = getAppearenceEAnnotation();

		// If there is no EAnnotation, create it
		if (eAnn == null) {
			eAnn = createAppearenceEAnnotation();
		}

		// If change is already added, don't continue
		if (eAnn.getReferences().contains(attribute))
			return;

		// Background
		if (NotationPackage.eINSTANCE.getFillStyle_FillColor().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FILL_STYLE__FILL_COLOR);
		}

		// Foreground
		if (NotationPackage.eINSTANCE.getLineStyle_LineColor().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.LINE_STYLE__LINE_COLOR);
		}

		// Font
		if (NotationPackage.eINSTANCE.getFontStyle_FontName().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FONT_STYLE__FONT_NAME);
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FONT_STYLE__FONT_COLOR);
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT);
		} else if (NotationPackage.eINSTANCE.getFontStyle_Bold().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FONT_STYLE__BOLD);
		} else if (NotationPackage.eINSTANCE.getFontStyle_Italic().equals(attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FONT_STYLE__ITALIC);
		}
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
					if (gEP instanceof GraphicalEditPart && ((GraphicalEditPart) gEP).resolveSemanticElement() == resolveSemanticElement()) {
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
		if (changesFromDefaultStyle().contains(NotationPackage.Literals.FILL_STYLE__FILL_COLOR)) {
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
			if (obj instanceof IFigure && !isFigureFromChildEditPart((IFigure) obj)) {
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
		if (changesFromDefaultStyle().contains(NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
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
			if (obj instanceof IFigure && !isLabel((IFigure) obj) && !isFigureFromChildEditPart((IFigure) obj)) {
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
		if (changesFromDefaultStyle().contains(NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
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
			if (obj instanceof IFigure && isLabel((IFigure) obj) && !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresFontColor((IFigure) obj, color);
			}
		}
	}

}
