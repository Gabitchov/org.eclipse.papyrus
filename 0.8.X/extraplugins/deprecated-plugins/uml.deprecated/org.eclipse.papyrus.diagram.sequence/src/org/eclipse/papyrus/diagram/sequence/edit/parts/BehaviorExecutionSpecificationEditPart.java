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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.commands.AnnotateNodeStyleCommand;
import org.eclipse.papyrus.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.diagram.common.commands.ReconnectToIntersectionPoints;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.policies.BehaviorExecutionSpecificationItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceDeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.sequence.util.MessageCommonUtil;

/**
 * @generated
 */
public class BehaviorExecutionSpecificationEditPart extends ShapeNodeEditPart
		implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

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
	public BehaviorExecutionSpecificationEditPart(View view) {
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
	 * /**
	 * 
	 * @author gmerin
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BehaviorExecutionSpecificationItemSemanticEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new SequenceDeleteOnlyViewComponentEditPolicy()); // changed by
		// gmerin
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.
		// EditPolicyRoles.CONNECTION_HANDLES_ROLE);
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
		BehaviourExecutionFigure figure = new BehaviourExecutionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public BehaviourExecutionFigure getPrimaryShape() {
		return (BehaviourExecutionFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		BESNodeFigure result = new BESNodeFigure(getMapMode().DPtoLP(16),
				getMapMode().DPtoLP(60));
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
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
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
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() instanceof ShapeStyle) {
			super.handleNotificationEvent(event);

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
					style.eSet((EStructuralFeature) event.getFeature(), event
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

			if (RequestConstants.REQ_CREATE.equals(type)
					&& (String.valueOf(CommentEditPart.VISUAL_ID).equals(id))) {
				return org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil
						.getDiagramEditPart(this).getCommand(_request);
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

			// Check if there is another element at the same point
			if (!MessageCommonUtil.checkFreeConnectionEnds(_request)) {
				return null;
			}

			// Modify the request with the real target anchoring point instead
			// of target mouse reference point
			ReconnectToIntersectionPoints.modifyLocation(reconnReq);

			// Create the commands with the real target anchoring point
			ccommand.add(super.getCommand(_request));

			// Creation of the re-orientation/re-anchoring command
			MessageOrderCommand msgOrderCmd = new MessageOrderCommand(reconnReq);
			ccommand.add(msgOrderCmd);

			return ccommand;
		}

		return super.getCommand(_request);
	}

	/**
	 * @NOT-generated
	 */
	public class BESNodeFigure extends DefaultSizeNodeFigure {

		public BESNodeFigure(Dimension defSize) {
			super(defSize.width, defSize.height);
		}

		public BESNodeFigure(int width, int height) {
			super(width, height);
		}

		@Override
		protected boolean isDefaultAnchorArea(PrecisionPoint p) {
			// We don't want a default anchor area for the BES Node Figure.
			return false;
		}

	}

	/**
	 * @generated
	 */
	public class BehaviourExecutionFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public BehaviourExecutionFigure() {
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(THIS_BACK);
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(1000)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(25)));
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

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 215, 174);

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
