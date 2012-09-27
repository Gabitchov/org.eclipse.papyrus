package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.ConnectionEndpointHandle;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.ConnectionEndpointTracker;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * Observation link editpart used by time observation and duration observation
 *
 */
public class ObservationLinkEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	public ObservationLinkEditPart(View view) {
		super(view);
	}

	protected Connection createConnectionFigure() {
		return new ConstraintLinkDescriptor();
	}

	public ConstraintLinkDescriptor getPrimaryShape() {
		return (ConstraintLinkDescriptor) getFigure();
	}

	public class ConstraintLinkDescriptor extends PolylineConnectionEx {

		public ConstraintLinkDescriptor() {
			this.setLineStyle(Graphics.LINE_DASH);
		}

	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,  new CustomComponentEditPolicy());
		//installEditPolicy(EditPolicy.COMPONENT_ROLE, new CustomComponentEditPolicy());
		//SequenceUtil.OBSERVATION_LINK_TYPE
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,new CustomConnectionEndpointEditPolicy());
	}

	private final class CustomComponentEditPolicy extends SemanticEditPolicy {
		@Override
		protected Command getSemanticCommand(IEditCommandRequest request) {
			Command semanticCommand = super.getSemanticCommand(request);
			if (semanticCommand != null) {
				if (semanticCommand instanceof ICommandProxy) {
					ICommandProxy proxy = (ICommandProxy) semanticCommand;
					if (proxy.getICommand() instanceof CompositeTransactionalCommand) {
						CompositeTransactionalCommand compositeCommand = (CompositeTransactionalCommand) proxy
								.getICommand();
						// update TimeObservation or DurationObservation model
						final ObservationLinkEditPart link = (ObservationLinkEditPart) getHost();
						AbstractTransactionalCommand updateLinkSourceModelCmd = new AbstractTransactionalCommand(
								link.getEditingDomain(), "", null) {
							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								EditPart source = link.getSource();
								if (source instanceof TimeObservationLabelEditPart) {
									TimeObservation timeObservation = (TimeObservation) ((TimeObservationLabelEditPart) source)
											.resolveSemanticElement();
									timeObservation.setEvent(null);
								} else if (source instanceof DurationObservationEditPart) {
									DurationObservation durationObservation = (DurationObservation) ((DurationObservationEditPart) source)
											.resolveSemanticElement();
									durationObservation.getEvents().clear();
								}

								return CommandResult.newOKCommandResult();
							}
						};
						compositeCommand.add(updateLinkSourceModelCmd);
					}
				}
			}
			return semanticCommand;
		}
	}

	private final class CustomConnectionEndpointEditPolicy extends
			org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy {
		protected List createSelectionHandles() {
			List list = new ArrayList();
			list.add(new CustomConnectionEndpointHandle(
					(ConnectionEditPart) getHost(),
					ConnectionLocator.SOURCE));
			list.add(new CustomConnectionEndpointHandle(
					(ConnectionEditPart) getHost(),
					ConnectionLocator.TARGET));
			return list;
		}
		
		protected void showConnectionMoveFeedback(ReconnectRequest request) {
			if (request.getConnectionEditPart().getSource() instanceof TimeObservationLabelEditPart
					&& request.getTarget() instanceof AbstractMessageEditPart) {
				return;
			}
			super.showConnectionMoveFeedback(request);
		}

		public void showSourceFeedback(Request request) {
			if (SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE
					.equals(request.getType())
					|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET
							.equals(request.getType()))
				showConnectionMoveFeedback((ReconnectRequest) request);
		}

		public void eraseSourceFeedback(Request request) {
			if (SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE
					.equals(request.getType())
					|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET
							.equals(request.getType()))
				eraseConnectionMoveFeedback((ReconnectRequest) request);
		}
	}
	
	private class CustomConnectionEndpointHandle extends ConnectionEndpointHandle{

		public CustomConnectionEndpointHandle(ConnectionEditPart owner, int endPoint) {
			super(owner, endPoint);
		}
		
		public CustomConnectionEndpointHandle(ConnectionEditPart owner,
				boolean fixed, int endPoint) {
			super(owner, fixed, endPoint);
		}

		public CustomConnectionEndpointHandle(int endPoint) {
			super(endPoint);
		}

		protected DragTracker createDragTracker() {
			if (isFixed())
				return null;
			ConnectionEndpointTracker tracker;
			tracker = new ConnectionEndpointTracker((ConnectionEditPart) getOwner()){
				protected Request createTargetRequest() {
					ReconnectRequest request = new ReconnectRequest(
							getCommandName()){
						public boolean isMovingStartAnchor() {
							return SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE.equals(getType());
						}
					};
					request.setConnectionEditPart(getConnectionEditPart());
					return request;
				}
			};
			if (getEndPoint() == ConnectionLocator.SOURCE) {
				tracker.setCommandName(SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE);
			} else {
				tracker.setCommandName(SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET);
			}
			tracker.setDefaultCursor(getCursor());
			return tracker;
		}
	}
	
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
			refreshLineWidth();
		}
	}
	
	protected void setLineWidth(int width) {
		getPrimaryShape().setLineWidth(width);
	}
}
