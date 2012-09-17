package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.papyrus.uml.diagram.sequence.ObservationLinkMetamodelType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ObservationLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * This policy is to process observation link creating, reconnecting 
 *
 */
public class ObservationLinkPolicy extends GraphicalNodeEditPolicy {
	private final EditPart editPart;

	public ObservationLinkPolicy(EditPart editPart) {
		this.editPart = editPart;
	}

	public Command getCommand(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest){
			if(((CreateUnspecifiedTypeConnectionRequest) request).getElementTypes().contains(ObservationLinkMetamodelType.getInstance())){
				if (SequenceUtil.OBSERVATION_LINK_REQUEST_START.equals(request.getType()))
					return getConnectionCreateCommand((CreateConnectionRequest) request);
				if (SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(request.getType()))
					return getConnectionCompleteCommand((CreateConnectionRequest) request);
			}
			return null;
		}
		if(request instanceof CreateConnectionRequest){
			CreateConnectionRequest cc = (CreateConnectionRequest) request;
			if(cc.getNewObject()!=null){
				if(cc.getNewObject() instanceof ObservationLink){
					if (SequenceUtil.OBSERVATION_LINK_REQUEST_START.equals(request.getType()))
						return getConnectionCreateCommand((CreateConnectionRequest) request);
					if (SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(request.getType()))
						return getConnectionCompleteCommand((CreateConnectionRequest) request);
				}
			}
			return null;
		}
		if(request instanceof ReconnectRequest){
			ReconnectRequest rr = (ReconnectRequest) request;
			if(rr.getConnectionEditPart() instanceof ObservationLinkEditPart){
				if (SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE.equals(request.getType()))
					return getReconnectSourceCommand((ReconnectRequest) request);
				if (SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET.equals(request.getType()))
					return getReconnectTargetCommand((ReconnectRequest) request);
			}
			
		}
	
		return null;
	}

	public EditPart getTargetEditPart(Request request) {
		if (SequenceUtil.OBSERVATION_LINK_REQUEST_START.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET.equals(request.getType())){
			if (request instanceof CreateConnectionRequest) {
				if (((CreateConnectionRequest) request).getSourceEditPart() instanceof TimeObservationLabelEditPart) {
					if (getHost() instanceof AbstractMessageEditPart) {
						return null;
					}
				}
			}
			if(SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET.equals(request.getType())){
				if (request instanceof ReconnectRequest) {
					if (((ReconnectRequest) request).getConnectionEditPart().getSource() instanceof TimeObservationLabelEditPart) {
						if (getHost() instanceof AbstractMessageEditPart) {
							return null;
						}
					}
				}
			}
			return getHost();
		}
		return null;
	}

	@Override
	protected Command getConnectionCreateCommand(
			CreateConnectionRequest request) {
		EditPart host = getHost();
		if(host instanceof TimeObservationLabelEditPart){
			TimeObservationLabelEditPart timeObservationLabelEditPart = (TimeObservationLabelEditPart)host;
			if(timeObservationLabelEditPart.getSourceConnections().size()>0){
				return null;
			}
		}else if(host instanceof DurationObservationEditPart){
			DurationObservationEditPart durationObservationEditPart = (DurationObservationEditPart)host;
			if(durationObservationEditPart.getSourceConnections().size()>0){
				return null;
			}
		}else{
			return null;
		}

		CompositeCommand cc = new CompositeCommand(
				DiagramUIMessages.Commands_CreateCommand_Connection_Label);
		
		CreateObservationLinkCommand cmd = new CreateObservationLinkCommand(((GraphicalEditPart) editPart).getEditingDomain(), "Create connection command", null);
		
		cmd.setSourceEditPart(host);
		cmd.setRequest(request);
		
		cc.compose(cmd);
		Command c = new ICommandProxy(cc);
		request.setStartCommand(c);
		return c;
	}
	
	@Override
	protected Command getConnectionCompleteCommand(
			final CreateConnectionRequest request) {
		EditPart sourceEditPart = request.getSourceEditPart();

		if((sourceEditPart instanceof TimeObservationLabelEditPart)&&!(getHost() instanceof LifelineEditPart)){
			return null;
		}else if(sourceEditPart instanceof DurationObservationEditPart&&!(getHost() instanceof AbstractMessageEditPart)){
			return null;
		}

		ICommandProxy proxy = (ICommandProxy) request
				.getStartCommand();
		if (proxy == null) {
			return null;
		}

		CompositeCommand result = new CompositeCommand("Add observation link command");
		
		if(sourceEditPart instanceof TimeObservationLabelEditPart){
			result.add(new UpdateTimeObservationLinkTargetElementCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), "Update semantic model", null, request,getHost()));
		}else if(sourceEditPart instanceof DurationObservationEditPart){
			result.add(new UpdateDurationObservationLinkTargetElementCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), "Update semantic model", null, request,getHost()));
		}

		//1:
		CompositeCommand cc = (CompositeCommand) proxy.getICommand();
	    Iterator commandItr = cc.iterator();
	    CreateObservationLinkCommand createConnectorViewCommand = (CreateObservationLinkCommand) commandItr.next();
	    createConnectorViewCommand.setSourceEditPart(request.getSourceEditPart());
	    createConnectorViewCommand.setTargetEditPart(request.getTargetEditPart());
	    
	    result.add(cc);
		return new ICommandProxy(result);
	}

	@Override
	protected Command getReconnectSourceCommand(final ReconnectRequest request) {
		Command reconnectSourceCommand = super
				.getReconnectSourceCommand(request);
		ICommandProxy proxy = (ICommandProxy) reconnectSourceCommand;
		CompositeCommand cc = (CompositeCommand) proxy.getICommand();

		// update semantic model
		if(request.getConnectionEditPart().getSource() instanceof TimeObservationLabelEditPart && getHost() instanceof TimeObservationLabelEditPart){
			TimeObservationLabelEditPart timeObservationLabelEditPart = (TimeObservationLabelEditPart)getHost();
			if(timeObservationLabelEditPart.getSourceConnections().size()>0){
				return null;
			}
			cc.add(new UpdateTimeObservationLinkSourceElementCommand(
					((IGraphicalEditPart) getHost()).getEditingDomain(),
					"Update semantic model", null, request, getHost()));
		}else if(request.getConnectionEditPart().getSource() instanceof DurationObservationEditPart && getHost() instanceof DurationObservationEditPart){
			DurationObservationEditPart durationObservationEditPart = (DurationObservationEditPart)getHost();
			if(durationObservationEditPart.getSourceConnections().size()>0){
				return null;
			}
			cc.add(new UpdateDurationObservationLinkSourceElementCommand(
					((IGraphicalEditPart) getHost()).getEditingDomain(),
					"Update semantic model", null, request, getHost()));
		}
		
		return reconnectSourceCommand;
	}
	
	@Override
	protected Command getReconnectTargetCommand(final ReconnectRequest request) {
		Command reconnectTargetCommand = super
				.getReconnectTargetCommand(request);
		ICommandProxy proxy = (ICommandProxy) reconnectTargetCommand;
		CompositeCommand cc = (CompositeCommand) proxy.getICommand();

		// update semantic model
		if(request.getConnectionEditPart().getSource() instanceof TimeObservationLabelEditPart){
			 cc.add(new UpdateTimeObservationLinkTargetElementCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), "Update semantic model", null, request,getHost()));
		}else if(request.getConnectionEditPart().getSource() instanceof DurationObservationEditPart){
			 cc.add(new UpdateDurationObservationLinkTargetElementCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), "Update semantic model", null, request,getHost()));
		}
		
		return proxy;
	}

	@Override
	public void showSourceFeedback(Request request) {
		if ((SequenceUtil.OBSERVATION_LINK_REQUEST_END).equals(request.getType()))
			showCreationFeedback((CreateConnectionRequest) request);
	}

	protected FeedbackHelper getFeedbackHelper(CreateConnectionRequest request) {
		if (feedbackHelper == null) {
			feedbackHelper = new FeedbackHelper();
			Point p = request.getLocation();
			connectionFeedback = createDummyConnection(request);
			connectionFeedback
					.setConnectionRouter(getDummyConnectionRouter(request));
			connectionFeedback
					.setSourceAnchor(getSourceConnectionAnchor(request));
			connectionFeedback.setForegroundColor(ColorConstants.black);
			feedbackHelper.setConnection(connectionFeedback);
			addFeedback(connectionFeedback);
			feedbackHelper.update(null, p);
		}
		return feedbackHelper;
	}

	@Override
	public void showTargetFeedback(Request request) {
		if (SequenceUtil.OBSERVATION_LINK_REQUEST_START.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET.equals(request.getType()))
			showTargetConnectionFeedback((DropRequest) request);
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		if ( SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(request.getType()))
			eraseCreationFeedback((CreateConnectionRequest) request);
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if (SequenceUtil.OBSERVATION_LINK_REQUEST_START.equals(request.getType())
				||  SequenceUtil.OBSERVATION_LINK_REQUEST_END.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_SOURCE.equals(request.getType())
				|| SequenceUtil.OBSERVATION_LINK_REQUEST_RECONNECT_TARGET.equals(request.getType()))
			eraseTargetConnectionFeedback((DropRequest) request);
	}
	
	private class UpdateDurationObservationLinkSourceElementCommand extends
			AbstractTransactionalCommand {
		private final ReconnectRequest request;
		private EditPart hostPart;
		private DurationObservationEditPart sourceTolEP;

		List<OccurrenceSpecification> occList = Collections.emptyList();

		public UpdateDurationObservationLinkSourceElementCommand(
				TransactionalEditingDomain domain, String label,
				List affectedFiles, ReconnectRequest request, EditPart hostPart) {
			super(domain, label, affectedFiles);
			this.request = request;
			sourceTolEP = (DurationObservationEditPart) request
					.getConnectionEditPart().getSource();
			this.hostPart = hostPart;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			if (sourceTolEP == hostPart) {
				return CommandResult.newCancelledCommandResult();
			}

			View sourceView = (View) sourceTolEP.getModel();
			DurationObservation sourceDurationObservation = (DurationObservation) sourceView
					.getElement();

			DurationObservationEditPart targetDoEP = (DurationObservationEditPart) hostPart;
			View targetView = (View) targetDoEP.getModel();
			DurationObservation targetDurationObservation = (DurationObservation) targetView
					.getElement();
			targetDurationObservation.getEvents().addAll(
					sourceDurationObservation.getEvents());

			sourceDurationObservation.getEvents().clear();
			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canExecute() {
			if (hostPart instanceof DurationObservationEditPart) {
				return true;
			}
			return false;
		}

	}
	
	public class UpdateDurationObservationLinkTargetElementCommand extends
			AbstractTransactionalCommand {
		private final Request request;
		private EditPart hostPart;

		public UpdateDurationObservationLinkTargetElementCommand(
				TransactionalEditingDomain domain, String label,
				List affectedFiles, Request request, EditPart hostPart) {
			super(domain, label, affectedFiles);
			this.request = request;
			this.hostPart = hostPart;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			DurationObservationEditPart doEP = null;
			if (request instanceof CreateConnectionRequest) {
				doEP = (DurationObservationEditPart) (((CreateConnectionRequest) request).getSourceEditPart());
			} else if (request instanceof ReconnectRequest) {
				doEP = (DurationObservationEditPart) (((ReconnectRequest) request).getConnectionEditPart().getSource());
			}
			View view = (View) doEP.getModel();
			DurationObservation durationObservation = (DurationObservation) view.getElement();
			EList<NamedElement> events = durationObservation.getEvents();
			// if is reconnect operation, first remove orginal message event of DurationObservation 
			if (request instanceof ReconnectRequest) {
				events.clear();
			}
			Map<String, Object> extendedData = request.getExtendedData();
			// assign the occurrence specification
			Object paramOcc1 = extendedData
					.get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
			Object paramOcc2 = extendedData
					.get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
			if (paramOcc1 != null && paramOcc2 != null) {
				events.add((OccurrenceSpecification) paramOcc1);
				events.add((OccurrenceSpecification) paramOcc2);
			}
			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canExecute() {
			if (hostPart instanceof ConnectionNodeEditPart) {
				Map<String, Object> extendedData = request.getExtendedData();

				if (hostPart instanceof AbstractMessageEditPart) {
					AbstractMessageEditPart messageEP = (AbstractMessageEditPart) hostPart;
					View view = (View) messageEP.getModel();
					Message message = (Message) view.getElement();

					if (message.getSendEvent() != null)
						extendedData
								.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION,
										message.getSendEvent());
					if (message.getReceiveEvent() != null)
						extendedData
								.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2,
										message.getReceiveEvent());
				}

				if (extendedData
						.containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION)
						&& extendedData
								.containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
					return true;
				}
			}
			return false;
		}

	}
	
	private class UpdateTimeObservationLinkSourceElementCommand extends
			AbstractTransactionalCommand {
		private final ReconnectRequest request;
		private EditPart hostPart;
		private TimeObservationLabelEditPart sourceTolEP;

		List<OccurrenceSpecification> occList = Collections.emptyList();

		public UpdateTimeObservationLinkSourceElementCommand(
				TransactionalEditingDomain domain, String label,
				List affectedFiles, ReconnectRequest request, EditPart hostPart) {
			super(domain, label, affectedFiles);
			this.request = request;
			sourceTolEP = (TimeObservationLabelEditPart) request
					.getConnectionEditPart().getSource();
			this.hostPart = hostPart;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			if (sourceTolEP == hostPart) {
				return CommandResult.newCancelledCommandResult();
			}

			View sourceView = (View) sourceTolEP.getModel();
			TimeObservation sourceTimeObservation = (TimeObservation) sourceView
					.getElement();

			TimeObservationLabelEditPart targetTolEP = (TimeObservationLabelEditPart) hostPart;
			View targetView = (View) targetTolEP.getModel();
			TimeObservation targetTimeObservation = (TimeObservation) targetView
					.getElement();
			targetTimeObservation.setEvent(sourceTimeObservation.getEvent());

			sourceTimeObservation.setEvent(null);
			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canExecute() {
			if (hostPart instanceof TimeObservationLabelEditPart) {
				return true;
			}
			return false;
		}
	}
	
	private class UpdateTimeObservationLinkTargetElementCommand extends
			AbstractTransactionalCommand {
		private final Request request;
		private EditPart hostPart;

		List<OccurrenceSpecification> occList = Collections.emptyList();

		public UpdateTimeObservationLinkTargetElementCommand(
				TransactionalEditingDomain domain, String label,
				List affectedFiles, Request request, EditPart hostPart) {
			super(domain, label, affectedFiles);
			this.request = request;
			this.hostPart = hostPart;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			TimeObservationLabelEditPart tolEP = null;
			if (request instanceof CreateConnectionRequest) {
				tolEP = (TimeObservationLabelEditPart) (((CreateConnectionRequest) request)
						.getSourceEditPart());
			} else if (request instanceof ReconnectRequest) {
				tolEP = (TimeObservationLabelEditPart) (((ReconnectRequest) request)
						.getConnectionEditPart().getSource());
			}
			View view = (View) tolEP.getModel();
			TimeObservation timeObservation = (TimeObservation) view
					.getElement();

			// assign the occurrence specification
			if (!occList.isEmpty()) {
				for (OccurrenceSpecification occurrence : occList) {
					if (occurrence instanceof MessageOccurrenceSpecification) {
						Message mess = ((MessageOccurrenceSpecification) occurrence)
								.getMessage();
						if (mess.getReceiveEvent().equals(occurrence)
								&& MessageSort.SYNCH_CALL_LITERAL.equals(mess
										.getMessageSort())) {
							// filter receive event, we prefer the corresponding
							// start event at the same location
							continue;
						}
					}
					// otherwise, first occ is just fine
					timeObservation.setEvent(occurrence);
					break;
				}
			}

			// reset request vertical location
			if (timeObservation.getEvent() instanceof MessageOccurrenceSpecification) {
				Point messageOccurrenceLoc = SequenceUtil
						.findLocationOfMessageOccurrence(
								(GraphicalEditPart) hostPart,
								(MessageOccurrenceSpecification) timeObservation
										.getEvent());
				if (request instanceof CreateConnectionRequest) {
					CreateConnectionRequest req = (CreateConnectionRequest) request;
					req.setLocation(new Point(req.getLocation().x,
							messageOccurrenceLoc.y));
				} else if (request instanceof ReconnectRequest) {
					ReconnectRequest req = (ReconnectRequest) request;
					req.setLocation(new Point(req.getLocation().x,
							messageOccurrenceLoc.y));
				}
			} else if (timeObservation.getEvent() instanceof ExecutionOccurrenceSpecification) {
				Point executionOccurrenceLoc = SequenceUtil
						.findLocationOfExecutionOccurrence(
								(GraphicalEditPart) hostPart,
								(ExecutionOccurrenceSpecification) timeObservation
										.getEvent());
				if (request instanceof CreateConnectionRequest) {
					CreateConnectionRequest req = (CreateConnectionRequest) request;
					req.setLocation(new Point(req.getLocation().x,
							executionOccurrenceLoc.y));
				} else if (request instanceof ReconnectRequest) {
					ReconnectRequest req = (ReconnectRequest) request;
					req.setLocation(new Point(req.getLocation().x,
							executionOccurrenceLoc.y));
				}
			}

			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canExecute() {
			if (hostPart instanceof LifelineEditPart) {
				Point location = null;
				if (request instanceof CreateConnectionRequest) {
					location = ((CreateConnectionRequest) request)
							.getLocation();
				} else if (request instanceof ReconnectRequest) {
					location = ((ReconnectRequest) request).getLocation();
				}

				Entry<Point, List<OccurrenceSpecification>> eventAndLocation = SequenceUtil
						.findNearestEvent(location, (LifelineEditPart) hostPart);
				// find an event near enough to create the
				// constraint or observation
				occList = Collections.emptyList();
				if (eventAndLocation != null) {
					occList = eventAndLocation.getValue();
				}
				if (!occList.isEmpty()) {
					for (OccurrenceSpecification occurrence : occList) {
						if (occurrence instanceof MessageOccurrenceSpecification) {
							Message mess = ((MessageOccurrenceSpecification) occurrence)
									.getMessage();
							if (mess.getReceiveEvent().equals(occurrence)
									&& MessageSort.SYNCH_CALL_LITERAL
											.equals(mess.getMessageSort())) {
								// filter receive event, we prefer the
								// corresponding
								// start event at the same location
								continue;
							}
						}
						return true;
					}
				}
			}
			return false;
		}
	}
	
	private class CreateObservationLinkCommand extends AbstractTransactionalCommand {

		private EditPart sourceEditPart;
		private EditPart targetEditPart;

		private CreateConnectionRequest request;
		private ObservationLink c;
		private String newSourceTerminal;

		public CreateObservationLinkCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		public void setSourceEditPart(EditPart sourceEditPart) {
			this.sourceEditPart = sourceEditPart;
		}

		public void setTargetEditPart(EditPart targetEditPart) {
			this.targetEditPart = targetEditPart;
		}

		public void setRequest(CreateConnectionRequest request) {
			this.request = request;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			c = new ObservationLink();
			c.setType(SequenceUtil.OBSERVATION_LINK_TYPE);
			c.setElement(null);
			
			View newSourceView = (View) sourceEditPart.getModel();
			c.setSource(newSourceView);

			ViewUtil.insertChildView(newSourceView.getDiagram(), c, -1, true);

			INodeEditPart ce = (INodeEditPart) sourceEditPart;
			ConnectionAnchor sourceAnchor = ce.getSourceConnectionAnchor(request);
			newSourceTerminal = ce.mapConnectionAnchorToTerminal(sourceAnchor);
			if (newSourceTerminal != null) {
				if (newSourceTerminal.length() == 0)
					c.setSourceAnchor(null);
				else {
					IdentityAnchor a = (IdentityAnchor) c.getSourceAnchor();
					if (a == null)
						a = NotationFactory.eINSTANCE.createIdentityAnchor();
					a.setId(newSourceTerminal);
					c.setSourceAnchor(a);
				}
			}

			initCompleteCommand();

			return CommandResult.newOKCommandResult();
		}

		private void initCompleteCommand() {
			// reset the target edit-part for the request
			if (targetEditPart != null) {
				View newTargetView = ((IGraphicalEditPart) targetEditPart)
						.getNotationView();
				c.setTarget(newTargetView);
				// 3:
				INodeEditPart ce = (INodeEditPart) targetEditPart;
				
				ConnectionAnchor targetAnchor = null;
				if(ce instanceof LifelineEditPart){
					LifelineEditPart lifelinePart = (LifelineEditPart)ce;
					targetAnchor = lifelinePart.getNodeFigure().getTargetConnectionAnchorAt(request.getLocation());
				}else{
					targetAnchor = ce
							.getTargetConnectionAnchor(request);
				}
				
				String newTargetTerminal = ce
						.mapConnectionAnchorToTerminal(targetAnchor);
				if (newTargetTerminal != null) {
					if (newTargetTerminal.length() == 0)
						c.setTargetAnchor(null);
					else {
						IdentityAnchor a = (IdentityAnchor) c.getTargetAnchor();
						if (a == null)
							a = NotationFactory.eINSTANCE.createIdentityAnchor();
						a.setId(newTargetTerminal);
						c.setTargetAnchor(a);
					}
				}
				// 4:
				INodeEditPart sourceEditPart = (INodeEditPart) request
						.getSourceEditPart();
				ConnectionAnchor sourceAnchor = sourceEditPart
						.mapTerminalToConnectionAnchor(newSourceTerminal);
				PointList pointList = new PointList();
				if (request.getLocation() == null) {
					pointList.addPoint(sourceAnchor.getLocation(targetAnchor
							.getReferencePoint()));
					pointList.addPoint(targetAnchor.getLocation(sourceAnchor
							.getReferencePoint()));
				} else {
					pointList.addPoint(sourceAnchor.getLocation(request
							.getLocation()));
					pointList.addPoint(targetAnchor.getLocation(request
							.getLocation()));
				}
				List newBendpoints = new ArrayList();
				int numOfPoints = pointList.size();
				for (short i = 0; i < numOfPoints; i++) {
					Dimension s = pointList.getPoint(i).getDifference(
							sourceAnchor.getReferencePoint());
					Dimension t = pointList.getPoint(i).getDifference(
							targetAnchor.getReferencePoint());
					newBendpoints.add(new RelativeBendpoint(s.width, s.height,
							t.width, t.height));
				}

				RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
						.createRelativeBendpoints();
				bendpoints.setPoints(newBendpoints);
				c.setBendpoints(bendpoints);

			}

		}

	}
	
	public static class ObservationLink extends ConnectorImpl {
		public ObservationLink() {
			super();
		}
	}
	
}
