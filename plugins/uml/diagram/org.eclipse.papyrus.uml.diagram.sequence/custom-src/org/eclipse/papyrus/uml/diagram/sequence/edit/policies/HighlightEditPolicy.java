package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
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

	private static final String DURATION_CONSTRAINT_ON_LIFELINE_HINT = ((IHintedType) UMLElementTypes.DurationConstraint_3021)
			.getSemanticHint();

	private static final String HIGHLIGHT_CONNECT_START_LOCATION_DATA = "Highlight connection start location";

	private IFigure sourceIndicator;

	private IFigure targetIndicator;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void showTargetFeedback(Request request) {
		EditPart host = getHost();
		if (request instanceof GroupRequest) {
			List editParts = ((GroupRequest) request).getEditParts();
			for (Object object : editParts) {
				HighlightUtil.highlight((EditPart) object);
			}
		} else if (request instanceof CreateConnectionRequest) {
			CreateConnectionRequest req = (CreateConnectionRequest) request;
			EditPart sourceEditPart = req.getSourceEditPart();
			EditPart targetEditPart = req.getTargetEditPart();
			HighlightUtil.highlight(sourceEditPart);
			HighlightUtil.highlight(targetEditPart);
		} else if (request instanceof ReconnectRequest) {
			HighlightUtil.highlight(((ReconnectRequest) request).getTarget());
			HighlightUtil.highlight(((ReconnectRequest) request)
					.getConnectionEditPart());
		} else {
			HighlightUtil.highlight(host);
		}
		// for Duration Constraint
		if (isCreating(request, DURATION_CONSTRAINT_ON_LIFELINE_HINT)) {
			highlightDurationConstraintEvents(request);
		} else if (request instanceof CreateConnectionRequest
				|| request instanceof ReconnectRequest) {
			// for message end
			if (host instanceof MessageEndEditPart) {
				highlightMessageEnd(request);
			} else {
				Object type = request.getType();
				if (host instanceof LifelineEditPart
						&& (SequenceUtil.OBSERVATION_LINK_REQUEST_END)
								.equals(type)) {
					highlightTimeObservationEvent(request);
				} else if (host instanceof NodeEditPart) {
					if (REQ_CONNECTION_START.equals(type)) {
						ConnectionAnchor sourceAnchor = ((NodeEditPart) host)
								.getSourceConnectionAnchor(request);
						// Point location =
						// sourceAnchor.getLocation(sourceAnchor
						// .getReferencePoint());
						request.getExtendedData().put(
								HIGHLIGHT_CONNECT_START_LOCATION_DATA,
								sourceAnchor.getReferencePoint().getCopy());
						// IFigure feedback = getSourceIndicator();
						// setFeedbackLocation(feedback, location);
					} else if (REQ_CONNECTION_END.equals(type)) {
						EditPart sourceEditPart = ((CreateConnectionRequest) request)
								.getSourceEditPart();
						if (sourceEditPart instanceof NodeEditPart) {

							ConnectionAnchor targetAnchor = ((NodeEditPart) host)
									.getTargetConnectionAnchor(request);

							Point reference = null;
							Object object = request.getExtendedData().get(
									HIGHLIGHT_CONNECT_START_LOCATION_DATA);
							if (object instanceof Point) {
								reference = ((Point) object);
							} else {
								ConnectionAnchor sourceAnchor = ((NodeEditPart) sourceEditPart)
										.getSourceConnectionAnchor(request);
								reference = sourceAnchor.getReferencePoint();
							}
							Point targetLoc = targetAnchor
									.getLocation(reference);
							IFigure targetFeedback = getTargetIndicator();
							setFeedbackLocation(targetFeedback, targetLoc);
						}
					} else if (REQ_RECONNECT_SOURCE.equals(type)) {
						ConnectionEditPart connection = ((ReconnectRequest) request)
								.getConnectionEditPart();
						EditPart target = connection.getTarget();
						if (target instanceof NodeEditPart) {
							ConnectionAnchor targetAnchor = ((NodeEditPart) target)
									.getTargetConnectionAnchor(connection);
							Point reference = targetAnchor.getReferencePoint();
							ConnectionAnchor sourceAnchor = ((NodeEditPart) host)
									.getSourceConnectionAnchor(request);
							Point location = sourceAnchor
									.getLocation(reference);
							IFigure feedback = getSourceIndicator();
							setFeedbackLocation(feedback, location);
						}
					} else if (REQ_RECONNECT_TARGET.equals(type)) {
						ConnectionEditPart connection = ((ReconnectRequest) request)
								.getConnectionEditPart();
						EditPart source = connection.getSource();
						if (source instanceof NodeEditPart) {
							ConnectionAnchor sourceAnchor = ((NodeEditPart) source)
									.getSourceConnectionAnchor(connection);
							Point reference = sourceAnchor.getReferencePoint();
							ConnectionAnchor targetAnchor = ((NodeEditPart) host)
									.getTargetConnectionAnchor(request);
							Point location = targetAnchor
									.getLocation(reference);
							IFigure feedback = getTargetIndicator();
							setFeedbackLocation(feedback, location);
						}
					}
				}
			}
		}
	}

	/**
	 * Highlight message end when connecting to it.
	 */
	private void highlightMessageEnd(Request request) {
		Point location = getConnectiveLocation(request);
		if (location == null) {
			// not connection request.
			return;
		}
		MessageEndEditPart host = (MessageEndEditPart) getHost();
		ConnectionNodeEditPart parent = (ConnectionNodeEditPart) host
				.getParent();
		Point p = getNearestEndOfConnection(location, parent);
		IFigure feedback = getSourceIndicator();
		setFeedbackLocation(feedback, p);
	}

	/**
	 * Highlight target event when creating Observation from Time Observation to
	 * Lifeline event.
	 */
	private void highlightTimeObservationEvent(Request request) {
		Point location = getConnectiveLocation(request);

		Entry<Point, List<OccurrenceSpecification>> eventAndLocation = SequenceUtil
				.findNearestEvent(location, (LifelineEditPart) getHost());
		OccurrenceSpecification event = null;
		if (eventAndLocation != null) {
			List<OccurrenceSpecification> events = eventAndLocation.getValue();
			for (OccurrenceSpecification occurrence : events) {
				Message mess = ((MessageOccurrenceSpecification) occurrence)
						.getMessage();
				if (occurrence.equals(mess.getReceiveEvent())
						&& MessageSort.SYNCH_CALL_LITERAL.equals(mess
								.getMessageSort())) {
					continue;
				}
				event = occurrence;
				break;
			}
		}
		if (event != null) {
			Point p = fixLocationOfEventOnLifeline(getHost(), event,
					location.getCopy());
			IFigure feedback = getTargetIndicator();
			setFeedbackLocation(feedback, p);
		}
	}

	/**
	 * Get location from connective request.
	 */
	private Point getConnectiveLocation(Request request) {
		Point location = null;
		if (request instanceof CreateConnectionRequest) {
			location = ((CreateConnectionRequest) request).getLocation();
		} else if (request instanceof ReconnectRequest) {
			location = ((ReconnectRequest) request).getLocation();
		}
		return location;
	}

	/**
	 * Highlight source event and target event of creating Duration Constraint.
	 */
	private void highlightDurationConstraintEvents(Request request) {
		Object locTop = request.getExtendedData().get(
				SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION);
		Object topEvents = request.getExtendedData().get(
				SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		if (locTop instanceof Point && topEvents != null
				&& topEvents instanceof Collection<?>
				&& !((Collection<?>) topEvents).isEmpty()) {
			Point referenceTop = ((Point) locTop).getCopy();
			OccurrenceSpecification event = (OccurrenceSpecification) ((Collection<?>) topEvents)
					.iterator().next();
			if (event instanceof MessageOccurrenceSpecification) {
				referenceTop = fixLocationOfEventOnLifeline(null, event,
						referenceTop);
			}
			IFigure sourceIndicator = getSourceIndicator();
			setFeedbackLocation(sourceIndicator, referenceTop);
		}
		Object bottomEvents = request.getExtendedData().get(
				SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		Object locBottom = request.getExtendedData().get(
				SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2);
		if (locBottom instanceof Point && bottomEvents != null
				&& bottomEvents instanceof Collection<?>
				&& !((Collection<?>) bottomEvents).isEmpty()) {
			Point referenceBottom = ((Point) locBottom).getCopy();
			OccurrenceSpecification event = (OccurrenceSpecification) ((Collection<?>) bottomEvents)
					.iterator().next();
			if (event instanceof MessageOccurrenceSpecification) {
				referenceBottom = fixLocationOfEventOnLifeline(null, event,
						referenceBottom);
			}
			IFigure targetIndicator = getTargetIndicator();
			setFeedbackLocation(targetIndicator, referenceBottom);
		}
	}

	private Point fixLocationOfEventOnLifeline(EditPart lifeline,
			OccurrenceSpecification event, Point location) {

		if (lifeline == null) {
			lifeline = findLifelineAt(location);
		}
		if (lifeline == null) {
			return location;
		}
		EditPart linkedEditPart = SequenceUtil.getLinkedEditPart(lifeline,
				event);
		if (linkedEditPart instanceof ConnectionNodeEditPart) {
			ConnectionNodeEditPart connection = ((ConnectionNodeEditPart) linkedEditPart);
			return getNearestEndOfConnection(location, connection);
		}
		return location;
	}

	private Point getNearestEndOfConnection(Point location,
			ConnectionNodeEditPart connection) {
		Connection msgFigure = connection.getConnectionFigure();
		if (msgFigure instanceof AbstractPointListShape) {
			Point start = ((AbstractPointListShape) msgFigure).getStart()
					.getCopy();
			msgFigure.translateToAbsolute(start);
			Point end = ((AbstractPointListShape) msgFigure).getEnd().getCopy();
			msgFigure.translateToAbsolute(end);
			if (location.getDistance(start) < location.getDistance(end)) {
				return start;
			} else {
				return end;
			}
		}
		return location;
	}

	private boolean isCreating(Request request, String sementicHint) {
		if (request == null || sementicHint == null) {
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
		if (request instanceof CreateViewRequest) {
			ViewDescriptor viewDesc = ((CreateViewRequest) request)
					.getViewDescriptors().iterator().next();
			hint = viewDesc.getSemanticHint();
		} else if (request instanceof CreateUnspecifiedTypeRequest) {
			Object elementType = ((CreateUnspecifiedTypeRequest) request)
					.getElementTypes().iterator().next();
			if (elementType instanceof IHintedType) {
				hint = ((IHintedType) elementType).getSemanticHint();
			}
		}
		return hint;
	}

	@SuppressWarnings("rawtypes")
	private EditPart findLifelineAt(Point pt) {
		Collection values = getHost().getViewer().getEditPartRegistry()
				.values();
		for (Object object : values) {
			if (!(object instanceof LifelineEditPart)) {
				continue;
			}
			LifelineEditPart lifeline = ((LifelineEditPart) object);
			LifelineFigure primaryShape = lifeline.getPrimaryShape();
			Point p = pt.getCopy();
			primaryShape.translateToRelative(p);
			if (primaryShape.containsPoint(p)) {
				return lifeline;
			}
		}
		return null;
	}

	private IFigure getSourceIndicator() {
		if (sourceIndicator == null) {
			sourceIndicator = createCircleFeedback();
		}
		return sourceIndicator;
	}

	private IFigure getTargetIndicator() {
		if (targetIndicator == null) {
			targetIndicator = createCircleFeedback();
		}
		return targetIndicator;
	}

	private IFigure createCircleFeedback() {
		Ellipse feedback = new Ellipse();
		feedback.setLineWidth(2);
		feedback.setAntialias(SWT.ON);
		feedback.setSize(10, 10);
		getFeedbackLayer().add(feedback);
		return feedback;
	}

	private void setFeedbackLocation(IFigure feedback, Point location) {
		if (feedback == null || location == null) {
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
		if (feedback == null || feedback.getParent() == null) {
			return;
		}
		feedback.getParent().remove(feedback);
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		HighlightUtil.unhighlight();
		safeRemoveFeedback(sourceIndicator);
		sourceIndicator = null;
		safeRemoveFeedback(targetIndicator);
		targetIndicator = null;
	}
}
