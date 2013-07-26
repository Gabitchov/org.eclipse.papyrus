/*****************************************************************************
 * Copyright (c) 2013 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationHelper;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * This class fixed the bug when reconnecting message from the end of an execution to the execution, at this moment, the model of the source and
 * target are not changed, but the UML2 model must be changed from message end to execution occurrence specification.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class ExecutionGraphicalNodeEditPolicy extends ElementCreationWithMessageEditPolicy {

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		Command command = super.getReconnectSourceCommand(request);
		if(command != null && command.canExecute() && !relationshipSourceHasChanged(request)) {
			command = appendUpdateExecutionEndCommand(request, command, false);
		}
		return command;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		Command command = super.getReconnectTargetCommand(request);
		if(command != null && command.canExecute() && !relationshipTargetHasChanged(request)) {
			command = appendUpdateExecutionEndCommand(request, command, true);
		}
		return command;
	}

	/**
	 * @param request
	 * @param command
	 * @return
	 */
	private Command appendUpdateExecutionEndCommand(ReconnectRequest request, Command command, boolean messageTarget) {
		EditPart target = request.getTarget();
		ExecutionSpecification execution = null;
		if(target instanceof AbstractExecutionSpecificationEditPart) {
			EObject elt = ((AbstractExecutionSpecificationEditPart)target).resolveSemanticElement();
			if(elt instanceof ExecutionSpecification) {
				execution = (ExecutionSpecification)elt;
			}
		}
		MessageEnd messageEnd = null;
		ConnectionEditPart conn = request.getConnectionEditPart();
		if(conn instanceof AbstractMessageEditPart) {
			EObject elt = ((AbstractMessageEditPart)conn).resolveSemanticElement();
			if(elt instanceof Message) {
				messageEnd = messageTarget ? ((Message)elt).getReceiveEvent() : ((Message)elt).getSendEvent();
			}
		}
		if(execution != null && messageEnd != null) {
			OccurrenceSpecification start = execution.getStart();
			OccurrenceSpecification finish = execution.getFinish();
			if(start != null && start == messageEnd) {
				command = command.chain(new ICommandProxy(new ResetExecutionEndCommand(((IGraphicalEditPart)target).getEditingDomain(), execution, true)));
			} else if(finish != null && finish == messageEnd) {
				command = command.chain(new ICommandProxy(new ResetExecutionEndCommand(((IGraphicalEditPart)target).getEditingDomain(), execution, false)));
			}
		}
		return command;
	}

	private boolean relationshipSourceHasChanged(ReconnectRequest request) {
		return !request.getConnectionEditPart().getSource().equals(request.getTarget());
	}

	private boolean relationshipTargetHasChanged(ReconnectRequest request) {
		return !request.getConnectionEditPart().getTarget().equals(request.getTarget());
	}

	private static class ResetExecutionEndCommand extends AbstractTransactionalCommand {

		private ExecutionSpecification execution;

		private boolean resetStart;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 * @param label
		 * @param affectedFiles
		 */
		public ResetExecutionEndCommand(TransactionalEditingDomain domain, ExecutionSpecification execution, boolean resetStart) {
			super(domain, "", null);
			this.execution = execution;
			this.resetStart = resetStart;
		}

		/**
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 * @param info
		 * @return
		 * @throws ExecutionException
		 */

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if(execution != null) {
				if(resetStart) {
					OccurrenceSpecificationHelper.resetExecutionStart(execution, UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
				} else {
					OccurrenceSpecificationHelper.resetExecutionFinish(execution, UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
				}
			}
			return CommandResult.newOKCommandResult();
		}

	}
}
