package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.EllipseDecoration;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class HighlightEditPolicy extends GraphicalEditPolicy {

	public static final String HIGHLIGHT_ROLE = "Highlight Edit Policy";

	private static final String DURATION_CONSTRAINT_ON_LIFELINE_HINT = ((IHintedType)UMLElementTypes.DurationConstraint_3021).getSemanticHint();

	private static final String TIME_CONSTRAINT_ON_LIFELINE_HINT = ((IHintedType)UMLElementTypes.TimeConstraint_3019).getSemanticHint();

	protected Indicator sourceIndicator;

	protected Indicator targetIndicator;

	public void showSourceFeedback(Request request) {
		EditPolicy editPolicy = null;
		Object type = request.getType();
		if(REQ_CONNECTION_END.equals(type)) {
			editPolicy = getHost().getEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE);
		} else if(SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(type)) {
			editPolicy = getHost().getEditPolicy("observationlink");
		}
		if(editPolicy != null) {
			EditPart targetEditPart = ((CreateConnectionRequest)request).getTargetEditPart();
			boolean canExecute = targetEditPart != null;
			if(targetEditPart != null) {
				Command command = targetEditPart.getCommand(request);
				canExecute = command != null && command.canExecute();
			}
			editPolicy.showSourceFeedback(request);
			PolylineConnection connectionFeedback = (PolylineConnection)getConnectionFeedback(editPolicy);
			if(connectionFeedback != null) {
				if(canExecute) {
					EllipseDecoration dec = new EllipseDecoration();
					dec.setPreferredSize(10, 10);
					dec.setSize(10, 10);
					dec.setLineWidth(2);
					dec.setAntialias(SWT.ON);
					connectionFeedback.setTargetDecoration(dec);
				} else {
					connectionFeedback.setTargetDecoration(null);
				}
			}
		}
		if(REQ_RECONNECT_SOURCE.equals(type) || SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE.equals(type)) {
			editPolicy = getHost().getEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE);
			if(editPolicy != null) {
				editPolicy.showSourceFeedback(request);
			}
			ConnectionEditPart connection = ((ReconnectRequest)request).getConnectionEditPart();
			EditPart target = ((ReconnectRequest)request).getTarget();
			boolean highlight = target != null;
			if(target != null) {
				Command command = target.getCommand(request);
				highlight = command != null && command.canExecute();
			}
			if(highlight) {
				Connection conn = (Connection)connection.getFigure();
				PointList line = conn.getPoints().getCopy();
				conn.translateToAbsolute(line);
				IFigure sourceFeedback = getSourceIndicator();
				setFeedbackLocation(sourceFeedback, line.getFirstPoint());
			} else {
				safeRemoveFeedback(sourceIndicator);
			}
		} else if(REQ_RECONNECT_TARGET.equals(type) || SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET.equals(type)) {
			editPolicy = getHost().getEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE);
			if(editPolicy != null) {
				editPolicy.showSourceFeedback(request);
			}
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connection = reconnectRequest.getConnectionEditPart();
			EditPart target = reconnectRequest.getTarget();
			boolean highlight = target != null;
			if(target != null) {
				Command command = target.getCommand(reconnectRequest);
				highlight = command != null && command.canExecute();
			}
			if(highlight) {
				Connection conn = (Connection)connection.getFigure();
				PointList line = conn.getPoints().getCopy();
				conn.translateToAbsolute(line);
				IFigure targetFeedback = getTargetIndicator();
				setFeedbackLocation(targetFeedback, line.getLastPoint());
			} else {
				safeRemoveFeedback(targetIndicator);
			}
		}
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void showTargetFeedback(Request request) {
		EditPart host = getHost();
		if(request instanceof GroupRequest) {
			List editParts = ((GroupRequest)request).getEditParts();
			for(Object object : editParts) {
				highlight((EditPart)object);
			}
		} else if(request instanceof CreateConnectionRequest) {
			CreateConnectionRequest req = (CreateConnectionRequest)request;
			EditPart sourceEditPart = req.getSourceEditPart();
			EditPart targetEditPart = req.getTargetEditPart();
			highlight(sourceEditPart);
			highlight(targetEditPart);
		} else if(request instanceof ReconnectRequest) {
			highlight(((ReconnectRequest)request).getTarget());
			highlight(((ReconnectRequest)request).getConnectionEditPart());

			// for message end
			if(host instanceof MessageEndEditPart) {
				highlightMessageEnd(request);
			} else {
				Object type = request.getType();
				if(host instanceof LifelineEditPart && (SequenceUtil.OBSERVATION_LINK_REQUEST_END).equals(type)) {
					highlightObservationEvent(request);
				}
			}
		} else {
			highlight(host);
		}
		// for Duration Constraint and Time Constraint.
		if(isCreating(request, DURATION_CONSTRAINT_ON_LIFELINE_HINT) || isCreating(request, TIME_CONSTRAINT_ON_LIFELINE_HINT)) {
			Command command = getHost().getCommand(request);
			if(command != null && command.canExecute()) {
				highlightEventsAboutConstraints(request);
			}
		}
	}

	/**
	 * Highlight, subclass can override it.
	 */
	protected void highlight(EditPart object) {
		HighlightUtil.highlight(object);
	}

	/**
	 * Erase highlighted figure, subclass can override it.
	 */
	protected void unhighlight(EditPart object) {
		HighlightUtil.unhighlight(object);
	}

	/**
	 * Erase all highlighted figures, subclass can override it.
	 */
	protected void unhighlight() {
		HighlightUtil.unhighlight();
	}

	private Connection getConnectionFeedback(EditPolicy policy) {
		if(policy != null) {
			try {
				Field f = GraphicalNodeEditPolicy.class.getDeclaredField("connectionFeedback");
				f.setAccessible(true);
				return (Connection)f.get(policy);
			} catch (Exception e) {
			}
		}
		return null;
	}

	/**
	 * Highlight message end when connecting to it.
	 */
	private void highlightMessageEnd(Request request) {
		Point location = getConnectiveLocation(request);
		if(location == null) {
			// not connection request.
			return;
		}
		MessageEndEditPart host = (MessageEndEditPart)getHost();
		ConnectionNodeEditPart parent = (ConnectionNodeEditPart)host.getParent();
		Point p = getNearestEndOfConnection(location, parent);
		IFigure feedback = getSourceIndicator();
		setFeedbackLocation(feedback, p);
	}

	/**
	 * Highlight target event when creating Observation from Time Observation to
	 * Lifeline event.
	 */
	private void highlightObservationEvent(Request request) {
		Point location = getConnectiveLocation(request);

		Entry<Point, List<OccurrenceSpecification>> eventAndLocation = SequenceUtil.findNearestEvent(location, (LifelineEditPart)getHost());
		OccurrenceSpecification event = null;
		if(eventAndLocation != null) {
			List<OccurrenceSpecification> events = eventAndLocation.getValue();
			for(OccurrenceSpecification occurrence : events) {
				if(occurrence instanceof MessageOccurrenceSpecification) {
					Message mess = ((MessageOccurrenceSpecification)occurrence).getMessage();
					if(occurrence.equals(mess.getReceiveEvent()) && MessageSort.SYNCH_CALL_LITERAL.equals(mess.getMessageSort())) {
						continue;
					}
				}
				event = occurrence;
				break;
			}
		}
		if(event != null) {
			Point p = fixLocationOfEventOnLifeline(getHost(), event, location.getCopy());
			IFigure feedback = getTargetIndicator();
			setFeedbackLocation(feedback, p);
		}
	}

	/**
	 * Get location from connective request.
	 */
	private Point getConnectiveLocation(Request request) {
		Point location = null;
		if(request instanceof CreateConnectionRequest) {
			location = ((CreateConnectionRequest)request).getLocation();
		} else if(request instanceof ReconnectRequest) {
			location = ((ReconnectRequest)request).getLocation();
		}
		return location;
	}

	/**
	 * Highlight source event and target event of creating Duration Constraint.
	 */
	private void highlightEventsAboutConstraints(Request request) {
		Object locTop = request.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION);
		Object topEvents = request.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		if(locTop instanceof Point && topEvents != null && topEvents instanceof Collection<?> && !((Collection<?>)topEvents).isEmpty()) {
			Point referenceTop = ((Point)locTop).getCopy();
			OccurrenceSpecification event = (OccurrenceSpecification)((Collection<?>)topEvents).iterator().next();
			if(event instanceof MessageOccurrenceSpecification) {
				referenceTop = fixLocationOfEventOnLifeline(null, event, referenceTop);
			}
			IFigure sourceIndicator = getSourceIndicator();
			setFeedbackLocation(sourceIndicator, referenceTop);
		}
		Object bottomEvents = request.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		Object locBottom = request.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2);
		if(locBottom instanceof Point && bottomEvents != null && bottomEvents instanceof Collection<?> && !((Collection<?>)bottomEvents).isEmpty()) {
			Point referenceBottom = ((Point)locBottom).getCopy();
			OccurrenceSpecification event = (OccurrenceSpecification)((Collection<?>)bottomEvents).iterator().next();
			if(event instanceof MessageOccurrenceSpecification) {
				referenceBottom = fixLocationOfEventOnLifeline(null, event, referenceBottom);
			}
			IFigure targetIndicator = getTargetIndicator();
			setFeedbackLocation(targetIndicator, referenceBottom);
		}
	}

	private Point fixLocationOfEventOnLifeline(EditPart lifeline, OccurrenceSpecification event, Point location) {

		if(lifeline == null) {
			lifeline = findLifelineAt(location);
		}
		if(lifeline == null) {
			return location;
		}
		Point loc = SequenceUtil.findLocationOfEvent((LifelineEditPart)lifeline, event);
		if(loc != null) {
			return loc;
		}
		EditPart linkedEditPart = SequenceUtil.getLinkedEditPart(lifeline, event);
		if(linkedEditPart instanceof ConnectionNodeEditPart) {
			ConnectionNodeEditPart connection = ((ConnectionNodeEditPart)linkedEditPart);
			return getNearestEndOfConnection(location, connection);
		}
		return location;
	}

	private Point getNearestEndOfConnection(Point location, ConnectionNodeEditPart connection) {
		Connection msgFigure = connection.getConnectionFigure();
		if(msgFigure instanceof AbstractPointListShape) {
			Point start = ((AbstractPointListShape)msgFigure).getStart().getCopy();
			msgFigure.translateToAbsolute(start);
			Point end = ((AbstractPointListShape)msgFigure).getEnd().getCopy();
			msgFigure.translateToAbsolute(end);
			if(location.getDistance(start) < location.getDistance(end)) {
				return start;
			} else {
				return end;
			}
		}
		return location;
	}

	private boolean isCreating(Request request, String sementicHint) {
		if(request == null || sementicHint == null) {
			return false;
		}
		String hint = getSementicHint(request);
		return sementicHint.equals(hint);
	}

	/**
	 * @param request
	 * @return
	 */
	private String getSementicHint(Request request) {
		String hint = null;
		if(request instanceof CreateViewRequest) {
			ViewDescriptor viewDesc = ((CreateViewRequest)request).getViewDescriptors().iterator().next();
			hint = viewDesc.getSemanticHint();
		} else if(request instanceof CreateUnspecifiedTypeRequest) {
			Object elementType = ((CreateUnspecifiedTypeRequest)request).getElementTypes().iterator().next();
			if(elementType instanceof IHintedType) {
				hint = ((IHintedType)elementType).getSemanticHint();
			}
		}
		return hint;
	}

	@SuppressWarnings("rawtypes")
	private EditPart findLifelineAt(Point pt) {
		Collection values = getHost().getViewer().getEditPartRegistry().values();
		for(Object object : values) {
			if(!(object instanceof LifelineEditPart)) {
				continue;
			}
			LifelineEditPart lifeline = ((LifelineEditPart)object);
			LifelineFigure primaryShape = lifeline.getPrimaryShape();
			Point p = pt.getCopy();
			primaryShape.translateToRelative(p);
			if(primaryShape.containsPoint(p)) {
				return lifeline;
			}
		}
		return null;
	}

	protected Indicator getSourceIndicator() {
		if(sourceIndicator == null || sourceIndicator.getParent() == null) {
			sourceIndicator = createCircleFeedback();
		}
		return sourceIndicator;
	}

	protected Indicator getTargetIndicator() {
		if(targetIndicator == null || targetIndicator.getParent() == null) {
			targetIndicator = createCircleFeedback();
		}
		return targetIndicator;
	}

	private Indicator createCircleFeedback() {
		Indicator feedback = new Indicator();
		getFeedbackLayer().add(feedback);
		return feedback;
	}

	protected void setFeedbackLocation(IFigure feedback, Point location) {
		if(feedback == null || location == null) {
			return;
		}
		Point p = location.getCopy();
		Dimension d = feedback.getSize();
		p.x = p.x - d.width / 2;
		p.y = p.y - d.height / 2;
		feedback.translateToRelative(p);
		feedback.setLocation(p);
	}

	private void safeRemoveFeedback(IFigure feedback) {
		if(feedback == null || feedback.getParent() == null) {
			return;
		}
		feedback.getParent().remove(feedback);
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		unhighlight();
		safeRemoveFeedback(sourceIndicator);
		sourceIndicator = null;
		safeRemoveFeedback(targetIndicator);
		targetIndicator = null;
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		super.eraseSourceFeedback(request);
		safeRemoveFeedback(sourceIndicator);
		sourceIndicator = null;
		safeRemoveFeedback(targetIndicator);
		targetIndicator = null;
	}

	private static class Indicator extends Ellipse {

		/**
		 * Constructor.
		 * 
		 */
		public Indicator() {
			setLineWidth(2);
			setAntialias(SWT.ON);
			setSize(10, 10);
		}

	}
}
