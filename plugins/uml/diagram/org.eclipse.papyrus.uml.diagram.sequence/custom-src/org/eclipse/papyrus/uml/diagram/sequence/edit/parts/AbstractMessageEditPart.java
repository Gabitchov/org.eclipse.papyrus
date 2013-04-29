package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLConnectionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineChildGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.MessageLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SelfMessageHelper;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Message;

public abstract class AbstractMessageEditPart extends UMLConnectionNodeEditPart {

	private List messageEventParts;

	/**
	 * Handle mouse move event to update cursors.
	 */
	private MouseMoveListener mouseMoveListener;

	private Cursor myCursor;

	private Cursor defaultCursor;

	public AbstractMessageEditPart(View view) {
		super(view);
	}

	@Override
	public void activate() {
		super.activate();
		if(getTarget() == null || getSource() == null) {
			getViewer().getControl().getDisplay().asyncExec(new Runnable() {

				public void run() {
					hookGraphicalViewer();
				}
			});
		} else {
			hookGraphicalViewer();
		}
	}

	private void hookGraphicalViewer() {
		if(SelfMessageHelper.isSelfLink(this)) {
			getViewer().getControl().addMouseMoveListener(mouseMoveListener = new MouseMoveListener() {

				public void mouseMove(org.eclipse.swt.events.MouseEvent e) {
					handleMouseMoved(e.x, e.y);
				}
			});
		}
	}

	/**
	 * Update cursor for self message.
	 */
	protected void handleMouseMoved(int x, int y) {
		myCursor = null;
		if(defaultCursor != null) {
			getViewer().setCursor(Cursors.ARROW);
			defaultCursor = null;
		}
		if(!SelfMessageHelper.isSelfLink(this)) {
			return;
		}
		UMLEdgeFigure primaryShape = getPrimaryShape();
		Point p = new Point(x, y);
		primaryShape.translateToRelative(p);
		if(!primaryShape.containsPoint(p.x, p.y)) {
			return;
		}
		PointList points = primaryShape.getPoints();
		if(points.size() <= 1) {
			return;
		}
		List lineSegments = PointListUtilities.getLineSegments(points);
		LineSeg nearestSegment = PointListUtilities.getNearestSegment(lineSegments, p.x, p.y);
		if(points.size() > 3 && (p.getDistance(points.getPoint(1)) < 5 || p.getDistance(points.getPoint(2)) < 5)) {
			myCursor = Cursors.SIZEALL;
		} else if(nearestSegment.isHorizontal()) {
			myCursor = Cursors.SIZENS;
		} else {
			myCursor = Cursors.SIZEWE;
		}
		defaultCursor = getViewer().getControl().getCursor();
		getViewer().setCursor(myCursor);
		if(SelfMessageHelper.isSelfLink(this)) {
			getPrimaryShape().setCustomCursor(myCursor);
		} else {
			getPrimaryShape().setCustomCursor(null);
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.UMLConnectionNodeEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	abstract public MessageFigure getPrimaryShape();

	@Override
	public void deactivate() {
		if(mouseMoveListener != null) {
			getViewer().getControl().removeMouseMoveListener(mouseMoveListener);
		}
		super.deactivate();
	}

	private Cursor getCustomCursor() {
		if(!SelfMessageHelper.isSelfLink(this)) {
			return null;
		}
		return myCursor;
	}

	@Override
	protected int getLineWidth() {
		int lineWidth = super.getLineWidth();
		return lineWidth < 0 ? 1 : lineWidth;
	}

	@Override
	protected void fireSelectionChanged() {
		super.fireSelectionChanged();
		UMLEdgeFigure primaryShape = getPrimaryShape();
		if(primaryShape instanceof MessageFigure) {
			((MessageFigure)primaryShape).setSelection(getSelected() != SELECTED_NONE);
		}
	}

	public View findChildByModel(EObject model) {
		List list = getModelChildren();
		if(list != null && list.size() > 0) {
			for(Object o : list) {
				if(!(o instanceof View)) {
					continue;
				}
				View view = (View)o;
				if(view.getElement() == model) {
					return view;
				}
			}
		}
		return null;
	}

	@Override
	public List getChildren() {
		if(messageEventParts == null) {
			initMessageEventPart();
		}
		return super.getChildren();
	}

	protected void initMessageEventPart() {
		messageEventParts = new ArrayList();
		
		String id = String.valueOf( MessageEndEditPart.VISUAL_ID);
		List list = this.getModelChildren();
		for(Object o : list)
			if(o instanceof Shape ){
				Shape s = (Shape) o;
				if(s.getType().equals(id ))
					return;  // if the model already persist, do not create it again
			}
		
		EObject element = this.resolveSemanticElement();
		if(!(element instanceof Message)) {
			return;
		}
		Message message = (Message)element;
		UMLEdgeFigure edgeFigure = (UMLEdgeFigure)this.getFigure();
		Diagram diagram = ((View)this.getModel()).getDiagram();
		if(!(message.getSendEvent() instanceof Gate)) {
			final MessageEndEditPart sendEventPart = new MessageEndEditPart(message.getSendEvent(), this, new ConnectionLocator(edgeFigure, ConnectionLocator.SOURCE));
			messageEventParts.add(sendEventPart);
			sendEventPart.rebuildLinks(diagram);
			addChild(sendEventPart, -1);
		}
		if(!(message.getReceiveEvent() instanceof Gate)) {
			final MessageEndEditPart receiveEventPart = new MessageEndEditPart(message.getReceiveEvent(), this, new ConnectionLocator(edgeFigure, ConnectionLocator.TARGET));
			messageEventParts.add(receiveEventPart);
			receiveEventPart.rebuildLinks(diagram);
			addChild(receiveEventPart, -1);
		}
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY, new MessageLabelEditPolicy());
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			List types = ((CreateUnspecifiedTypeConnectionRequest)request).getElementTypes();
			if(types.contains(UMLElementTypes.Message_4009) || types.contains(UMLElementTypes.Message_4008)) {
				return null;
			}
		} else if(request instanceof ReconnectRequest) {
			ConnectionEditPart con = ((ReconnectRequest)request).getConnectionEditPart();
			if(con instanceof Message7EditPart || con instanceof Message6EditPart) {
				return null;
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		MessageLabelEditPart labelPart = getMessageLabelEditPart();
		if(labelPart == null) {
			return;
		}
		if(NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			labelPart.refreshFontColor();
		} else if(NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
			labelPart.refreshFont();
		}
	}

	public MessageLabelEditPart getMessageLabelEditPart() {
		for(Object c : this.getChildren()) {
			if(c instanceof MessageLabelEditPart) {
				return (MessageLabelEditPart)c;
			}
		}
		return null;
	}

	//public abstract IFigure getPrimaryShape() ;
	@Override
	public void setLineWidth(int width) {
		if(getPrimaryShape() instanceof MessageFigure) {
			MessageFigure edge = (MessageFigure)getPrimaryShape();
			edge.setLineWidth(width);
		}
	}

	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getSource().showSourceFeedback(request);
			getTarget().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getSource().eraseSourceFeedback(request);
			getTarget().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#installRouter()
	 * 
	 */
	@Override
	protected void installRouter() {
		getConnectionFigure().setConnectionRouter(LifelineChildGraphicalNodeEditPolicy.messageRouter);
		getConnectionFigure().setCursor(org.eclipse.gmf.runtime.gef.ui.internal.l10n.Cursors.CURSOR_SEG_MOVE);
		refreshBendpoints();
	}

	/**
	 * Ignore routing style since we are using a custom router and a custom ConnectionBendpointEditPolicy.
	 */
	protected void refreshRoutingStyles() {
	}

	//	public static class MessageFigure extends UMLEdgeFigure {
	//
	//		private boolean selection;
	//
	//		/**
	//		 * Constructor.
	//		 * 
	//		 */
	//		public MessageFigure() {
	//		}
	//
	//		@Override
	//		public void setLineWidth(int w) {
	//			if(selection) {
	//				w = AbstractMessageEditPart.this.getLineWidth() * 2;
	//			}
	//			super.setLineWidth(w);
	//			if(getSourceDecoration() instanceof Shape) {
	//				((Shape)getSourceDecoration()).setLineWidth(w);
	//			}
	//			if(getTargetDecoration() instanceof Shape) {
	//				((Shape)getTargetDecoration()).setLineWidth(w);
	//			}
	//		}
	//
	//		@Override
	//		public void setForegroundColor(Color c) {
	//			super.setForegroundColor(c);
	//			if(getSourceDecoration() instanceof Shape) {
	//				((Shape)getSourceDecoration()).setForegroundColor(c);
	//				((Shape)getSourceDecoration()).setBackgroundColor(c);
	//			}
	//			if(getTargetDecoration() instanceof Shape) {
	//				((Shape)getTargetDecoration()).setForegroundColor(c);
	//				((Shape)getTargetDecoration()).setBackgroundColor(c);
	//			}
	//		}
	//
	//		@Override
	//		public Cursor getCursor() {
	//			Cursor customCursor = getCustomCursor();
	//			if(customCursor != null) {
	//				return customCursor;
	//			}
	//			return super.getCursor();
	//		}
	//
	//		/**
	//		 * @return the selection
	//		 */
	//		public boolean getSelection() {
	//			return selection;
	//		}
	//
	//		/**
	//		 * @param selection
	//		 *        the selection to set
	//		 */
	//		public void setSelection(boolean selection) {
	//			this.selection = selection;
	//			if(!selection) {
	//				setLineWidth(AbstractMessageEditPart.this.getLineWidth());
	//			}
	//			repaint();
	//		}
	//
	//		protected IMapMode getMapMode() {
	//			return AbstractMessageEditPart.this.getMapMode();
	//		}
	//	}
	static abstract class MessageLabelEditPart extends LabelEditPart {

		public MessageLabelEditPart(View view) {
			super(view);
		}

		@Override
		protected void handleNotificationEvent(Notification notification) {
			Object feature = notification.getFeature();
			if(NotationPackage.eINSTANCE.getLineStyle_LineColor().equals(feature)) {
				refreshFontColor();
			} else {
				super.handleNotificationEvent(notification);
			}
		}

		@Override
		public void refreshFontColor() {
			FontStyle style = (FontStyle)((org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart)getParent()).getPrimaryView().getStyle(NotationPackage.Literals.FONT_STYLE);
			if(style != null) {
				setFontColor(DiagramColorRegistry.getInstance().getColor(Integer.valueOf(style.getFontColor())));
			}
		}

		@Override
		protected void refreshFont() {
			super.refreshFont();
		}
	}
}
