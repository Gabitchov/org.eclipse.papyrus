package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class HighlightEditPolicy extends GraphicalEditPolicy {

	private IFigure sourceIndicator;

	private IFigure targetIndicator;

	@SuppressWarnings("rawtypes")
	@Override
	public void showTargetFeedback(Request request) {
		if (request instanceof GroupRequest) {
			List editParts = ((GroupRequest) request).getEditParts();
			for (Object object : editParts) {
				HighlightUtil.highlight((EditPart) object);
			}
		} else if (request instanceof CreateConnectionRequest) {
			CreateConnectionRequest req = (CreateConnectionRequest) request;
			HighlightUtil.highlight(req.getSourceEditPart());
			HighlightUtil.highlight(req.getTargetEditPart());
		} else if (request instanceof ReconnectRequest) {
			HighlightUtil.highlight(((ReconnectRequest) request).getTarget());
			HighlightUtil.highlight(((ReconnectRequest) request)
					.getConnectionEditPart());
		} else {
			HighlightUtil.highlight(getHost());
		}
		// for Duration Constraint
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
				EditPart lifeline = findLifelineAt(referenceTop);
				EditPart linkedEditPart = SequenceUtil.getLinkedEditPart(
						lifeline, event);
				if (linkedEditPart instanceof ConnectionNodeEditPart) {
					ConnectionNodeEditPart connection = ((ConnectionNodeEditPart) linkedEditPart);
					Connection msgFigure = connection.getConnectionFigure();
					if (msgFigure instanceof AbstractPointListShape) {
						Point start = ((AbstractPointListShape) msgFigure)
								.getStart().getCopy();
						msgFigure.translateToAbsolute(start);
						Point end = ((AbstractPointListShape) msgFigure)
								.getEnd().getCopy();
						msgFigure.translateToAbsolute(end);
						if (referenceTop.getDistance(start) < referenceTop
								.getDistance(end)) {
							referenceTop = start;
						} else {
							referenceTop = end;
						}
					}
				}
			}
			IFigure sourceIndicator = getSourceIndicator();
			Dimension d = sourceIndicator.getSize();
			referenceTop.x = referenceTop.x - d.width / 2;
			referenceTop.y = referenceTop.y - d.height / 2;
			sourceIndicator.translateToRelative(referenceTop);
			sourceIndicator.setLocation(referenceTop);
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
				EditPart lifeline = findLifelineAt(referenceBottom);
				EditPart linkedEditPart = SequenceUtil.getLinkedEditPart(
						lifeline, event);
				if (linkedEditPart instanceof ConnectionNodeEditPart) {
					ConnectionNodeEditPart connection = ((ConnectionNodeEditPart) linkedEditPart);
					Connection msgFigure = connection.getConnectionFigure();
					if (msgFigure instanceof AbstractPointListShape) {
						Point start = ((AbstractPointListShape) msgFigure)
								.getStart().getCopy();
						msgFigure.translateToAbsolute(start);
						Point end = ((AbstractPointListShape) msgFigure)
								.getEnd().getCopy();
						msgFigure.translateToAbsolute(end);
						if (referenceBottom.getDistance(start) < referenceBottom
								.getDistance(end)) {
							referenceBottom = start;
						} else {
							referenceBottom = end;
						}
					}
				}
			}
			IFigure targetIndicator = getTargetIndicator();
			Dimension d = targetIndicator.getSize();
			referenceBottom.x = referenceBottom.x - d.width / 2;
			referenceBottom.y = referenceBottom.y - d.height / 2;
			targetIndicator.translateToRelative(referenceBottom);
			targetIndicator.setLocation(referenceBottom);
		}
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
			sourceIndicator = new Ellipse();
			sourceIndicator.setSize(10, 10);
			((Ellipse) sourceIndicator).setLineWidth(2);
			((Ellipse) sourceIndicator).setAntialias(SWT.ON);
			getFeedbackLayer().add(sourceIndicator);
		}
		return sourceIndicator;
	}

	private IFigure getTargetIndicator() {
		if (targetIndicator == null) {
			targetIndicator = new Ellipse();
			((Ellipse) targetIndicator).setLineWidth(2);
			((Ellipse) targetIndicator).setAntialias(SWT.ON);
			targetIndicator.setSize(10, 10);
			getFeedbackLayer().add(targetIndicator);
		}
		return targetIndicator;
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
