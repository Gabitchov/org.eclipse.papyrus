package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * Observation link editpart used by time observation and duration observation
 * 
 */
public class ObservationLinkEditPart extends AnnotatedLinkEditPart {

	public ObservationLinkEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomComponentEditPolicy());
		//installEditPolicy(EditPolicy.COMPONENT_ROLE, new CustomComponentEditPolicy());
		//SequenceUtil.OBSERVATION_LINK_TYPE
		//		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,new CustomConnectionEndpointEditPolicy());
	}

	private final class CustomComponentEditPolicy extends SemanticEditPolicy {

		@Override
		protected Command getSemanticCommand(IEditCommandRequest request) {
			Command semanticCommand = super.getSemanticCommand(request);
			if(semanticCommand != null) {
				if(semanticCommand instanceof ICommandProxy) {
					ICommandProxy proxy = (ICommandProxy)semanticCommand;
					if(proxy.getICommand() instanceof CompositeTransactionalCommand) {
						CompositeTransactionalCommand compositeCommand = (CompositeTransactionalCommand)proxy.getICommand();
						// update TimeObservation or DurationObservation model
						final ObservationLinkEditPart link = (ObservationLinkEditPart)getHost();
						AbstractTransactionalCommand updateLinkSourceModelCmd = new AbstractTransactionalCommand(link.getEditingDomain(), "", null) {

							@Override
							protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								EditPart source = link.getSource();
								if(source instanceof TimeObservationLabelEditPart) {
									TimeObservation timeObservation = (TimeObservation)((TimeObservationLabelEditPart)source).resolveSemanticElement();
									timeObservation.setEvent(null);
								} else if(source instanceof DurationObservationEditPart) {
									DurationObservation durationObservation = (DurationObservation)((DurationObservationEditPart)source).resolveSemanticElement();
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
}
