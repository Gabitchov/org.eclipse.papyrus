/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LinesBorder;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper.FixedAnchorEx;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeCommentCreationEditPolicyEx;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomDurationConstraintItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentCreationEditPolicy;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * Add implementing IPapyrusEditPart to displaying Stereotypes.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationConstraintEditPart extends DurationConstraintEditPart implements IPapyrusEditPart {

	private static final String ARROW = "Arrow";

	private static final String DIRECTION = "Direction";

	private static final String VERTICAL = "vertical";

	private static final String HORIZONTAL = "horizontal";

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomDurationConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDurationConstraintItemSemanticEditPolicy());
		//install a editpolicy to display stereotypes, there's a bug on super class.
		installEditPolicy(AppliedStereotypeCommentCreationEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicyEx());
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 * 
	 * @param request
	 *        The request
	 * @return The anchor
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		IHintedType type = (IHintedType)UMLElementTypes.CommentAnnotatedElement_4010;
		if(request instanceof CreateConnectionViewRequest) {
			String hint = ((CreateConnectionViewRequest)request).getConnectionViewDescriptor().getSemanticHint();
			if(hint.equals(type.getSemanticHint())) {
				return new RotateAnchor(getFigure(), computeAnchorLocation(((CreateConnectionViewRequest)request).getLocation()));
			}
		} else if(request instanceof ReconnectRequest) {
			ConnectionEditPart linkPart = ((ReconnectRequest)request).getConnectionEditPart();
			if(linkPart instanceof CommentAnnotatedElementEditPart) {
				return new RotateAnchor(getFigure(), computeAnchorLocation(((ReconnectRequest)request).getLocation()));
			}
		}
		return super.getSourceConnectionAnchor(request);
	}

	protected int computeAnchorLocation(Point location) {
		Rectangle box = getBox();
		if(isArrowVertical()) {
			if(location.getDistance2(box.getTop()) > location.getDistance2(box.getBottom()))
				return PositionConstants.BOTTOM;
			return PositionConstants.TOP;
		} else {
			if(location.getDistance2(box.getLeft()) > location.getDistance2(box.getRight()))
				return PositionConstants.RIGHT;
			return PositionConstants.LEFT;
		}
	}

	protected Rectangle getBox() {
		Rectangle rBox = getFigure() instanceof HandleBounds ? new PrecisionRectangle(((HandleBounds)getFigure()).getHandleBounds()) : new PrecisionRectangle(getFigure().getBounds());
		getFigure().translateToAbsolute(rBox);
		return rBox;
	}

	public boolean canCreateLink(Point point) {
		DurationConstraint dc = (DurationConstraint)this.resolveSemanticElement();

		int count = 0; // link counts
		List list = this.getSourceConnections();
		for(Object o : list)
			if(o instanceof CustomCommentAnnotatedElementEditPart) {
				count++;
			}
		if(count >= 2)
			return false;

		if(count < 1)
			return true;

		int targetPosition = computeAnchorLocation(point);
		if(findLinkAtPosition(targetPosition))
			return false;
		return true;
	}

	//	protected void refreshSourceConnections() {
	//		super.refreshSourceConnections();
	//		Display.getDefault().asyncExec(new Runnable(){
	//			public void run() {
	//				refreshBorder();
	//			}
	//		});
	//	}
	//	
	//	public void refresh(){
	//		super.refresh();
	//		refreshBorder();
	//	}
	//
	//	private void refreshBorder() {
	//		if(getPrimaryShape() instanceof CustomDurationConstraintFigure){
	//			CustomDurationConstraintFigure fig = (CustomDurationConstraintFigure)getPrimaryShape();
	//			fig.setBorderVisible(hasTopLink(), hasBottomLink());
	//		}
	//	}

	public boolean hasTopLink() {
		return findLinkAtPosition(PositionConstants.TOP);
	}

	public boolean hasBottomLink() {
		return findLinkAtPosition(PositionConstants.BOTTOM);
	}

	protected boolean findLinkAtPosition(int targetPos) {
		List list = this.getSourceConnections();
		for(Object o : list)
			if(o instanceof CustomCommentAnnotatedElementEditPart) {
				CustomCommentAnnotatedElementEditPart connPart = (CustomCommentAnnotatedElementEditPart)o;
				if((targetPos & getSourceAnchorPosition(connPart)) > 0)
					return true;

			}
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 * 
	 * @param connEditPart
	 *        The connection edit part.
	 * @return The anchor.
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		ConnectionAnchor anchor = null;
		if(connEditPart instanceof CommentAnnotatedElementEditPart) {
			anchor = new RotateAnchor(getFigure(), getSourceAnchorPosition((CommentAnnotatedElementEditPart)connEditPart));
		} else {
			anchor = super.getSourceConnectionAnchor(connEditPart);
		}

		return anchor;
	}

	private int getSourceAnchorPosition(CommentAnnotatedElementEditPart connEditPart) {
		String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, true);
		if(terminal.length() > 0) {
			return parseLocation(terminal);
		}
		return PositionConstants.TOP;
	}

	@Override
	protected void refreshBounds() {
		super.refreshBounds();

		int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
		// restore to default size
		if(width == -1)
			width = getFigure().getPreferredSize().width;
		if(height == -1)
			height = getFigure().getPreferredSize().height;

		if(width != -1 && height != -1) {
			Dimension size = primaryShape.getBounds().getSize();
			//if(size.width != width || size.height != height) { // if resize bounds
			primaryShape.setBounds(new Rectangle(primaryShape.getBounds().getLocation(), new Dimension(width, height)));
			//}
		}

		//fix combined fragment move
		this.getFigure().getParent().getLayoutManager().layout(this.getFigure().getParent());
		relocateLabelEditPart();
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new CustomDurationConstraintFigure();
	}

	/**
	 * This method creates a specific edit policy for time realted elements
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#getPrimaryDragEditPolicy()
	 * 
	 * @return <code>EditPolicy</code>
	 * @Override
	 */
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy policy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		return policy != null ? policy : new ResizableShapeEditPolicy() {

			protected Command getResizeCommand(ChangeBoundsRequest request) {
				ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_RESIZE_CHILDREN);
				req.setEditParts(getHost());
				req.setMoveDelta(request.getMoveDelta());
				req.setSizeDelta(request.getSizeDelta());
				req.setLocation(request.getLocation());
				req.setExtendedData(request.getExtendedData());
				req.setResizeDirection(request.getResizeDirection());
				return getHost().getParent().getCommand(req);
			}

			protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
				IFigure feedback = getDragSourceFeedbackFigure();

				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());

				IFigure f = getHostFigure();
				Dimension max = f.getMaximumSize().getCopy();
				IMapMode mmode = MapModeUtil.getMapMode(f);
				max.height = mmode.LPtoDP(max.height);
				max.width = mmode.LPtoDP(max.width);

				// no minimal size
				if(max.width < rect.width)
					rect.width = max.width;

				if(max.height < rect.height)
					rect.height = max.height;

				feedback.translateToRelative(rect);
				feedback.setBounds(rect);
			}
		};
	}

	/**
	 * @Override use ExternalLabelPrimaryDragRoleEditPolicy
	 */
	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case DurationConstraintLabelEditPart.VISUAL_ID:
				case DurationConstraintAppliedStereotypeEditPart.VISUAL_ID:
					// use ExternalLabelPrimaryDragRoleEditPolicy
					return new ExternalLabelPrimaryDragRoleEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
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
	 * @Override use ExternalLabelPositionLocator
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof DurationConstraintLabelEditPart) {
			DurationConstraintLabelLocator locator = new DurationConstraintLabelLocator(getMainFigure());
			locator.setParentEditPart(this);
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else if(borderItemEditPart instanceof DurationConstraintAppliedStereotypeEditPart) {
			//use ExternalLabelPositionLocator
			IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			return getParent().getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if((getModel() != null) && (getModel() == notification.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			}
		}

		if(notification.getNewValue() instanceof EAnnotation && ARROW.equals(((EAnnotation)notification.getNewValue()).getSource())) {
			refreshArrowDirection((EAnnotation)notification.getNewValue());
		} else if(notification.getNotifier() instanceof EAnnotation && ARROW.equals(((EAnnotation)notification.getNotifier()).getSource())) {
			refreshArrowDirection((EAnnotation)notification.getNotifier()); //notification.getEventType() == 
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshArrowDirection(null);
		refreshLineWidth();
	}

	private void relocateLabelEditPart() {
		List list = this.getChildren();
		for(Object o : list) {
			if(o instanceof DurationConstraintLabelEditPart) {
				DurationConstraintLabelEditPart label = (DurationConstraintLabelEditPart)o;
				if(label.getBorderItemLocator() != null) {
					IBorderItemLocator loc = label.getBorderItemLocator();
					loc.relocate(label.getFigure());
				}
			}
		}
	}

	public Rectangle updateMoveBounds(Rectangle newBounds) {
		if(getCurrentSideOfParent() == PositionConstants.WEST) {
			Rectangle bounds = this.getFigure().getBounds();
			return newBounds.translate(-bounds.width, 0); // keep bounds in left side
		}
		return newBounds;
	}

	public int getCurrentSideOfParent() {
		IBorderItemLocator locator = this.getBorderItemLocator();
		if(locator != null) {
			return locator.getCurrentSideOfParent();
		}
		return PositionConstants.EAST;
	}

	public class CustomDurationConstraintFigure extends DurationConstraintFigure {

		/**
		 * Height of the arrow end
		 * 
		 */
		private static final int ARROW_HEIGHT = 8;

		/**
		 * Width of the half of the arrow end
		 * 
		 */
		private static final int ARROW_SEMI_WIDTH = 7;

		boolean vertical = true;

		public CustomDurationConstraintFigure() {
			setBorder(createBorder0());
			setDashBorder();
		}

		private Border createBorder0() {
			LinesBorder result = new LinesBorder() {

				@Override
				public void paint(IFigure figure, Graphics graphics, Insets insets) {
					tempRect.setBounds(getPaintRectangle(figure, insets));

					int one = MapModeUtil.getMapMode(figure).DPtoLP(1);
					int widthInDP = getWidth() / one;

					int halfWidthInLP = MapModeUtil.getMapMode(figure).DPtoLP(widthInDP / 2);

					graphics.setLineWidth(getWidth());
					graphics.setLineStyle(getStyle());
					// adapt tempRect so that borders do not overflow the initial bounds
					tempRect.x += halfWidthInLP;
					tempRect.width -= getWidth();
					tempRect.y += halfWidthInLP;
					tempRect.height -= getWidth();

					if((getPositions() & PositionConstants.TOP) > 0) {
						//graphics.drawLine(tempRect.getTopLeft(), tempRect.getTopRight());
						graphics.drawLine(new Point(tempRect.getTopLeft().x(), tempRect.getTopLeft().y() + 1), new Point(tempRect.getTopRight().x(), tempRect.getTopRight().y() + 1));
					}
					if((getPositions() & PositionConstants.LEFT) > 0) {
						//graphics.drawLine(tempRect.getTopLeft(), tempRect.getBottomLeft());
						graphics.drawLine(new Point(tempRect.getTopLeft().x() + 1, tempRect.getTopLeft().y()), new Point(tempRect.getBottomLeft().x() + 1, tempRect.getBottomLeft().y()));
					}
					if((getPositions() & PositionConstants.BOTTOM) > 0) {
						graphics.drawLine(tempRect.getBottomLeft(), tempRect.getBottomRight());
					}
					if((getPositions() & PositionConstants.RIGHT) > 0) {
						graphics.drawLine(tempRect.getTopRight(), tempRect.getBottomRight());
					}
				}
			};
			result.setSides(PositionConstants.TOP | PositionConstants.BOTTOM);
			return result;
		}

		protected void setDashBorder() {
			if(this.getBorder() instanceof LinesBorder) {
				LinesBorder lb = (LinesBorder)this.getBorder();
				lb.setStyle(Graphics.LINE_DASH);
				if(vertical)
					lb.setSides(PositionConstants.TOP | PositionConstants.BOTTOM);
				else
					lb.setSides(PositionConstants.LEFT | PositionConstants.RIGHT);
			}
		}

		@Override
		public Insets getInsets() {
			if(getBorder() != null)
				return getBorder().getInsets(this);
			return NO_INSETS;
		}

		public void setVertical(boolean val) {
			if(val != vertical) {
				vertical = val;
				setDashBorder();
				revalidate();
			}
		}

		//		public void setBorderVisible(boolean top, boolean bottom){
		//			if(this.getBorder() instanceof LinesBorder){
		//				LinesBorder lb = (LinesBorder) this.getBorder();
		//				if(top){
		//					int value = bottom ? PositionConstants.TOP | PositionConstants.BOTTOM : PositionConstants.TOP;
		//					lb.setSides(value);
		//				}else{
		//					int value = bottom ? PositionConstants.BOTTOM : PositionConstants.NONE;
		//					lb.setSides(value);
		//				}
		//				this.repaint();
		//			}
		//		}

		/**
		 * Sets the bounds of this Figure to the Rectangle <i>rect</i>.
		 * This also updates sub-figures.
		 * 
		 * @see Figure#setBounds(Rectangle)
		 * @param rect
		 *        The new bounds
		 */
		@Override
		public void setBounds(Rectangle rect) {
			updateArrow(rect.width, rect.height);

			Rectangle c = rect.getCopy();
			this.getParent().translateToAbsolute(c);

			super.setBounds(rect);
		}

		/**
		 * Update the arrow polyline taking in account new figure's size
		 * 
		 * @param figureWidth
		 *        the new figure width
		 * @param figureHeight
		 *        the new figure height
		 */
		public void updateArrow(int figureWidth, int figureHeight) {
			// handle insets to avoid figure growing indefinitely
			figureWidth -= getInsets().left + getInsets().right;
			figureHeight -= getInsets().top + getInsets().bottom;
			if(getDurationArrow() != null) {
				int halfLineWidth = getLineWidth() / 2;
				if(vertical) {
					PointList points = new PointList(8);
					int centerX = figureWidth / 2;
					points.addPoint(centerX - ARROW_SEMI_WIDTH, halfLineWidth + ARROW_HEIGHT);
					points.addPoint(centerX, halfLineWidth);
					points.addPoint(centerX + ARROW_SEMI_WIDTH, halfLineWidth + ARROW_HEIGHT);
					points.addPoint(centerX, halfLineWidth);
					points.addPoint(centerX, figureHeight - halfLineWidth);
					points.addPoint(centerX - ARROW_SEMI_WIDTH, figureHeight - halfLineWidth - ARROW_HEIGHT);
					points.addPoint(centerX, figureHeight - halfLineWidth);
					points.addPoint(centerX + ARROW_SEMI_WIDTH, figureHeight - halfLineWidth - ARROW_HEIGHT);
					getDurationArrow().setPoints(points);
					Point topLeft = getLocation().getTranslated(getInsets().left, getInsets().top);
					getDurationArrow().setBounds(new Rectangle(topLeft, new Dimension(figureWidth, figureHeight)));
				} else {
					PointList points = new PointList(8);
					int centerY = figureHeight / 2;
					points.addPoint(halfLineWidth + ARROW_HEIGHT, centerY - ARROW_SEMI_WIDTH);
					points.addPoint(halfLineWidth, centerY);
					points.addPoint(halfLineWidth + ARROW_HEIGHT, centerY + ARROW_SEMI_WIDTH);
					points.addPoint(halfLineWidth, centerY);
					points.addPoint(figureWidth - halfLineWidth, centerY);

					points.addPoint(figureWidth - halfLineWidth - ARROW_HEIGHT, centerY - ARROW_SEMI_WIDTH);
					points.addPoint(figureWidth - halfLineWidth, centerY);
					points.addPoint(figureWidth - halfLineWidth - ARROW_HEIGHT, centerY + ARROW_SEMI_WIDTH);

					getDurationArrow().setPoints(points);
					Point topLeft = getLocation().getTranslated(getInsets().left, getInsets().top);
					getDurationArrow().setBounds(new Rectangle(topLeft, new Dimension(figureWidth, figureHeight)));
				}
			}
		}

		@Override
		public boolean containsPoint(int x, int y) {
			boolean containsPoint = super.containsPoint(x, y);
			if(!containsPoint) {
				return false;
			}
			PolylineShape durationArrow = getDurationArrow();
			if(durationArrow != null) {
				return PointListUtilities.containsPoint(durationArrow.getPoints(), new Point(x, y));
				//				return fDurationArrow.containsPoint(x, y);
			}
			return containsPoint;
		}

		public void paintFigure(Graphics graphics) {
			graphics.setLineWidth(lineWidth);
			super.paintFigure(graphics);
		}

		@Override
		public void setLineWidth(int w) {
			LinesBorder lb = (LinesBorder)getBorder();
			lb.setWidth(w);
			getDurationArrow().setLineWidth(w);
			super.setLineWidth(w);
		}
	}

	public static Rectangle fixMessageBounds(Rectangle newBounds, Request cvr, LifelineEditPart host) {
		Object oc1 = getFirstElement(cvr.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION));
		Object oc2 = getFirstElement(cvr.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2));
		if(oc1 != null && oc2 != null && (oc1 instanceof MessageOccurrenceSpecification || oc2 instanceof MessageOccurrenceSpecification)) {
			Point start = null, end = null;
			Rectangle bounds = null;
			if(oc1 instanceof InteractionFragment) {
				start = SequenceUtil.findLocationOfEvent(host, (InteractionFragment)oc1, true);
			}
			if(oc2 instanceof InteractionFragment) {
				end = SequenceUtil.findLocationOfEvent(host, (InteractionFragment)oc2, true);
			}
			if(start != null && end != null) {
				bounds = (start.y < end.y) ? new Rectangle(start, end) : new Rectangle(end, start);
			}
			if(bounds != null) {
				IFigure parentFigure = host.getFigure();
				Point parentFigDelta = parentFigure.getBounds().getLocation().getCopy().negate();
				parentFigure.translateToRelative(bounds);
				bounds.translate(parentFigDelta);
				if(bounds.y != newBounds.y || newBounds.height != bounds.height) {
					newBounds.y = bounds.y;
					newBounds.height = bounds.height;
				}
			}
		}
		return newBounds;
	}

	static class DurationConstraintLabelLocator extends ExternalLabelPositionLocator {

		private CustomDurationConstraintEditPart durationConstraintEditPart;

		public DurationConstraintLabelLocator(IFigure mainFigure) {
			super(mainFigure);
		}

		public void setParentEditPart(CustomDurationConstraintEditPart durationConstraintEditPart) {
			this.durationConstraintEditPart = durationConstraintEditPart;
		}

		@Override
		public void relocate(IFigure target) {
			if(constraint.y == 0) {
				if(durationConstraintEditPart.getCurrentSideOfParent() == PositionConstants.WEST) {
					Point r = parentFigure.getBounds().getLeft().translate(-20, -5);
					target.setBounds(new Rectangle(r, target.getPreferredSize()));
				} else {
					Point r = parentFigure.getBounds().getRight().translate(5, -5);
					target.setBounds(new Rectangle(r, target.getPreferredSize()));
				}
			} else
				super.relocate(target);
		}
	}

	static Object getFirstElement(Object obj) {
		if(obj != null && obj instanceof List) {
			List list = (List)obj;
			if(list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}


	protected void refreshArrowDirection(EAnnotation newValue) {
		CustomDurationConstraintFigure dc = (CustomDurationConstraintFigure)getPrimaryShape();
		dc.setVertical(isArrowVertical());
		refreshBounds();
	}

	public void setArrowDirection(String dir) {
		View view = this.getNotationView();
		if(view == null)
			return;

		EAnnotation ea = view.getEAnnotation(ARROW);
		if(ea == null) {
			ea = EcoreFactory.eINSTANCE.createEAnnotation();
			ea.setSource(ARROW);
			ea.getDetails().put(DIRECTION, dir);
			view.getEAnnotations().add(ea);
		} else {
			ea.getDetails().clear();
			ea.getDetails().put(DIRECTION, dir);
		}
	}

	public String getArrowDirection() {
		View view = this.getNotationView();
		if(view == null)
			return "";
		EAnnotation ea = view.getEAnnotation(ARROW);
		if(ea != null) {
			String pos = ea.getDetails().get(DIRECTION);
			if(pos != null) {
				return pos;
			}
		}
		return VERTICAL;
	}

	public boolean isArrowVertical() {
		return VERTICAL.equals(getArrowDirection());
	}

	public void rotateArrow() {
		if(isArrowVertical()) {
			setArrowDirection(HORIZONTAL);
		} else {
			setArrowDirection(VERTICAL);
		}
	}

	private Object getStructuralFeatureValue(View view, EStructuralFeature feature) {
		return ViewUtil.getPropertyValue(view, feature, feature.getEContainingClass());
	}

	public Rectangle getBounds() {
		View view = this.getNotationView();
		int width = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height())).intValue();
		int x = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		String prefElementId = ViewUtil.resolveSemanticElement(view).eClass().getName();
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(view, prefElementId, PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(view, prefElementId, PreferencesConstantsHelper.HEIGHT);
		if(width <= 0) {
			width = store.getInt(preferenceConstantWitdh);
		}
		if(height <= 0) {
			height = store.getInt(preferenceConstantHeight);
		}
		return new Rectangle(x, y, width, height);
	}

	public static class RotateArrowCommand extends org.eclipse.emf.transaction.RecordingCommand {

		private CustomDurationConstraintEditPart part;

		public RotateArrowCommand(TransactionalEditingDomain domain, CustomDurationConstraintEditPart part) {
			super(domain);
			this.part = part;
		}

		@Override
		protected void doExecute() {
			List list = part.getSourceConnections();
			if(part.isArrowVertical()) {
				part.setArrowDirection(HORIZONTAL);
			} else {
				part.setArrowDirection(VERTICAL);
			}
		}
	}

	class RotateAnchor extends FixedAnchorEx {

		public RotateAnchor(IFigure f, int location) {
			super(f, location);
		}

		public Point getLocation(Point reference) {
			double zoom = 0;
			if(CustomDurationConstraintEditPart.this.getRoot() instanceof RenderedDiagramRootEditPart) {
				RenderedDiagramRootEditPart render = (RenderedDiagramRootEditPart)CustomDurationConstraintEditPart.this.getRoot();
				zoom = render.getZoomManager().getZoom();
			}
			if(position == PositionConstants.TOP) {
				return new PrecisionPoint(getBox().getTop().preciseX(), getBox().getTop().preciseY() + 1 * zoom);
			} else if(position == PositionConstants.BOTTOM) {
				if(zoom > 1) {
					zoom = zoom - 1;
				}
				return new PrecisionPoint(getBox().getBottom().preciseX(), getBox().getBottom().preciseY() - 1 * zoom);
			} else if(position == PositionConstants.LEFT) {
				if(zoom > 1) {
					zoom = zoom - 1;
				}
				return new PrecisionPoint(getBox().getLeft().preciseX(), getBox().getLeft().preciseY() + 1 * zoom);
			} else if(position == PositionConstants.RIGHT) {
				if(zoom > 1) {
					zoom = zoom - 1;
				}
				return new PrecisionPoint(getBox().getRight().preciseX(), getBox().getRight().preciseY() + 1 * zoom);
			}
			return super.getLocation(reference);
		}

		public String getTerminal() {
			if(isDefaultAnchor())
				return StringStatics.BLANK;
			if(position == PositionConstants.TOP) {
				return "(0.5,0){T}";
			} else if(position == PositionConstants.BOTTOM) {
				return "(0.5,1){D}";
			} else if(position == PositionConstants.LEFT) {
				return "(0,0.5){L}";
			} else if(position == PositionConstants.RIGHT) {
				return "(1,0.5){R}";
			}
			return "(0.5,0){T}";
		}

	}

	private int parseLocation(String terminal) {
		if(terminal.length() > 0) {
			int start = terminal.indexOf("{") + 1;
			if(start > 0) {
				char ch = Character.toUpperCase(terminal.charAt(start));
				switch(ch) {
				case 'L':
					return PositionConstants.LEFT;
				case 'R':
					return PositionConstants.RIGHT;
				case 'D':
					return PositionConstants.BOTTOM;
				default:
					return PositionConstants.TOP;
				}
			}
		}
		return PositionConstants.TOP;
	}
}
