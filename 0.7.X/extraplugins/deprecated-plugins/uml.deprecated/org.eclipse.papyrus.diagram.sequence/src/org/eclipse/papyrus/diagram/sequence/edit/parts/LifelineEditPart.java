/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IPolygonAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.commands.AnnotateNodeStyleCommand;
import org.eclipse.papyrus.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.diagram.common.commands.ReconnectToIntersectionPoints;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.draw2d.LifelineDotLineFigure;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceDeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.util.MessageCommonUtil;

/**
 * @generated
 */
public class LifelineEditPart extends ShapeNodeEditPart implements
		PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
	 * This is to modify the feedback if anchors are going to be preserved
	 * 
	 * @author gmerin
	 * @NOT-generated
	 */
	@Override
	public void showSourceFeedback(Request request) {
		super.showSourceFeedback(PreserveAnchorsPositionCommand
				.getNewSourceFeedbackRequest(request, this));
	}

	/**
	 * This operation returns the BES EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @author gmerin
	 * @NOT-generated
	 * @return the list of BES EditParts
	 */
	public List<BehaviorExecutionSpecificationEditPart> getBESList() {
		List<BehaviorExecutionSpecificationEditPart> besList = new ArrayList<BehaviorExecutionSpecificationEditPart>();
		for (Object obj : getChildren()) {
			if (obj instanceof BehaviorExecutionSpecificationEditPart) {
				besList.add((BehaviorExecutionSpecificationEditPart) obj);
			}

		}
		return besList;
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		// Check if exists any MessageOccurrenceSpecification covered by this
		// Lifeline and with a DestructionEvent
		Lifeline lifeline = (Lifeline) this.resolveSemanticElement();
		if (lifeline == null) {
			return;
		}
		EList<InteractionFragment> list = lifeline.getCoveredBys();
		boolean drawCrossAtEnd = false;
		for (InteractionFragment fragment : list) {
			if (fragment instanceof MessageOccurrenceSpecification) {
				MessageOccurrenceSpecification msg = (MessageOccurrenceSpecification) fragment;
				if ((msg.getEvent() != null)
						&& (msg.getEvent() instanceof DestructionEvent))
					drawCrossAtEnd = true;
			}
		}
		this.getPrimaryShape().getFigureDotLineFigure().setCrossAtEnd(
				drawCrossAtEnd);
	}

	/**
	 * @author Gabriel Merin
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

		// Added code
		if (notification.getNewValue() instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification msgNew = (MessageOccurrenceSpecification) notification
					.getNewValue();
			if (msgNew.getEvent() instanceof DestructionEvent) {
				// If the MessageOccurrenceSpecification is covered by this
				// Lifeline, set the cross at the end of the Lifeline
				if (msgNew.getCovereds()
						.contains(this.resolveSemanticElement())) {
					refreshVisuals();
				}
			}
		}

		if (notification.getOldValue() instanceof MessageOccurrenceSpecification) {
			refreshVisuals();
		}
		// end added code

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		DiagramEditPartsUtil.handleNotificationForDiagram(this, notification,
				features);
	}

	/**
	 * @author Gabriel Merin
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());

		// super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new GraphicalNodeEditPolicy());

		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LifelineItemSemanticEditPolicy());
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.
		// EditPolicyRoles.DRAG_DROP_ROLE,
		// new
		//org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new SequenceDeleteOnlyViewComponentEditPolicy()); // changed by
		// gmerin
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new LifelineCanonicalEditPolicy());
		// installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// Changed policy
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new LifelineXYLayoutEditPolicy());

		// Added by gmerin to have a BES shortcut on Lifelines
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE,
				new PopupBarEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
			((LifelineNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLifelineLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

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
	 * @generated NOT
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof BehaviorExecutionSpecificationEditPart) {
			return getPrimaryShape().getFigureDotLineFigure();
		}

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		LifelineNodeFigure result = new LifelineNodeFigure(getMapMode().DPtoLP(
				100), getMapMode().DPtoLP(250));
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
	protected NodeFigure createNodeFigure() {
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
	 * @generated NOT
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}

		if (nodeShape instanceof LifelineFigure) {
			LifelineFigure lFigure = (LifelineFigure) nodeShape;
			return lFigure.getFigureDotLineFigure();
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
				.getType(LifelineNameEditPart.VISUAL_ID));
	}

	/**
	 * @NOT-generated
	 */
	@Override
	public Command getCommand(Request _request) {
		// can create comments by clicking into the compartment
		if (_request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutr = (CreateUnspecifiedTypeRequest) _request;
			String type = (String) cutr.getType();
			IHintedType iet = (IHintedType) cutr.getElementTypes().get(0);
			String id = iet.getSemanticHint();

			// To allow creation of Comments over a Lifeline
			if (RequestConstants.REQ_CREATE.equals(type)
					&& (String.valueOf(CommentEditPart.VISUAL_ID).equals(id))) {
				return org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil
						.getDiagramEditPart(this).getCommand(_request);
			}

			// To allow creation of CombinedFragments over a Lifeline
			if (RequestConstants.REQ_CREATE.equals(type)
					&& (String.valueOf(CombinedFragmentEditPart.VISUAL_ID)
							.equals(id))) {
				return this.getParent().getCommand(_request);
			}
		}// end

		if (_request instanceof CreateConnectionViewAndElementRequest) {

			CreateConnectionViewAndElementRequest createViewAndElemReq = (CreateConnectionViewAndElementRequest) _request;

			// Only order Message connections
			if (!MessageCommonUtil.isMessageEditPart(createViewAndElemReq
					.getConnectionViewDescriptor().getSemanticHint()))
				return super.getCommand(_request);

			CompoundCommand ccommand = new CompoundCommand();

			// Needed to add the start command to the request
			ccommand.add(super.getCommand(_request));

			// Check if there is another element at the same point
			if (!MessageCommonUtil.checkFreeConnectionEnds(_request)) {
				return null;
			}

			// Add a command to swap between created anchors (points where the
			// user clicked and dropped the connection) with the real
			// intersection points
			ccommand
					.add(new ReconnectToIntersectionPoints(createViewAndElemReq));

			// Creation of the ordering command
			MessageOrderCommand msgOrderCmd = new MessageOrderCommand(
					createViewAndElemReq);
			ccommand.add(msgOrderCmd);

			return ccommand;
		}

		if (_request instanceof ReconnectRequest) {

			ReconnectRequest reconnReq = (ReconnectRequest) _request;

			// Only order Message connections
			if (!MessageCommonUtil.isMessageEditPart(reconnReq
					.getConnectionEditPart()))
				return super.getCommand(_request);

			CompoundCommand ccommand = new CompoundCommand();

			// Check if there is another element at the same point and
			if (!MessageCommonUtil.checkFreeConnectionEnds(_request)) {
				return null;
			}

			// Modify the request with the real target anchoring point instead
			// of target mouse reference point
			ReconnectToIntersectionPoints.modifyLocation(reconnReq);

			// Create the commands with the real target anchoring point
			ccommand.add(super.getCommand(_request));

			// Creation of the ordering command
			MessageOrderCommand msgOrderCmd = new MessageOrderCommand(reconnReq);
			ccommand.add(msgOrderCmd);

			return ccommand;
		}

		return super.getCommand(_request);
	}

	/**
	 * @NOT-generated
	 */
	public class LifelineNodeFigure extends DefaultSizeNodeFigure implements
			IPolygonAnchorableFigure {

		public LifelineNodeFigure(Dimension defSize) {
			super(defSize.width, defSize.height);
		}

		public LifelineNodeFigure(int width, int height) {
			super(width, height);
		}

		@Override
		public PointList getPolygonPoints() {
			PointList polygonList = new PointList();

			Rectangle r = getBounds();

			Point pStart = new Point();
			Point pEnd = new Point();

			pStart.x = r.x + r.width / 2;
			pStart.y = r.y + 1;

			pEnd.x = pStart.x;
			pEnd.y = pStart.y + r.height - 1;

			polygonList.addPoint(pStart);
			polygonList.addPoint(pEnd);

			return polygonList;
		}

		@Override
		protected boolean isDefaultAnchorArea(PrecisionPoint p) {
			// We don't want a default anchor area for the Lifeline Node Figure.
			return false;
		}

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
		private RectangleFigure fFigureExecutionsContainerFigure;

		/**
		 * @generated
		 */
		public LifelineFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100),
					getMapMode().DPtoLP(200)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			RectangleFigure lifelineNameContainerFigure0 = new RectangleFigure();
			lifelineNameContainerFigure0
					.setForegroundColor(ColorConstants.black);
			lifelineNameContainerFigure0
					.setBackgroundColor(LIFELINENAMECONTAINERFIGURE0_BACK);

			this.add(lifelineNameContainerFigure0, BorderLayout.TOP);

			lifelineNameContainerFigure0.setLayoutManager(new StackLayout());

			fFigureLifelineLabelFigure = new WrapLabel();
			fFigureLifelineLabelFigure.setText("Lifeline");

			fFigureLifelineLabelFigure.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7),
					getMapMode().DPtoLP(7)));

			fFigureLifelineLabelFigure.setFont(FFIGURELIFELINELABELFIGURE_FONT);

			lifelineNameContainerFigure0.add(fFigureLifelineLabelFigure);

			fFigureExecutionsContainerFigure = new RectangleFigure();
			fFigureExecutionsContainerFigure.setOutline(false);
			fFigureExecutionsContainerFigure.setFill(false);

			this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);

			fFigureExecutionsContainerFigure
					.setLayoutManager(new StackLayout());

			LifelineDotLineFigure lifelineLineFigure1 = new LifelineDotLineFigure();
			// test
			lifelineLineFigure1.setLayoutManager(new XYLayout());

			fFigureExecutionsContainerFigure.add(lifelineLineFigure1);

			// added
			// lifelineLineFigure1.setLayoutManager(new XYLayout());
			setFigureDotLineFigure(lifelineLineFigure1);

			fFigureExecutionsContainerFigure.add(lifelineLineFigure1);

		}

		/**
		 * @generated NOT
		 */
		private LifelineDotLineFigure fLifelinDotLineFigure;

		/**
		 * @generated NOT
		 */
		public void setFigureDotLineFigure(LifelineDotLineFigure dlFigure) {
			fLifelinDotLineFigure = dlFigure;
		}

		/**
		 * @generated NOT
		 */
		public LifelineDotLineFigure getFigureDotLineFigure() {
			return fLifelinDotLineFigure;
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
		public WrappingLabel getFigureLifelineLabelFigure() {
			return fFigureLifelineLabelFigure;
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
	static final Color LIFELINENAMECONTAINERFIGURE0_BACK = new Color(null, 253,
			253, 221);

	/**
	 * @generated
	 */
	static final Font FFIGURELIFELINELABELFIGURE_FONT = new Font(Display
			.getCurrent(), "SANS", 10, SWT.BOLD);

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
