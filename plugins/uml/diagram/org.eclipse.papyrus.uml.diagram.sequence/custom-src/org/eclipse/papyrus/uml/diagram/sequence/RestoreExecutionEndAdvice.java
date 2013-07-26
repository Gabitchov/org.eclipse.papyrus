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
package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationHelper;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Update execution ends after the connected message was removed.
 * 
 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=402975
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class RestoreExecutionEndAdvice extends AbstractEditHelperAdvice {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getAfterDestroyElementCommand(DestroyElementRequest request) {
		EObject elementToDestroy = request.getElementToDestroy();
		if(elementToDestroy instanceof Message) {
			final Message message = (Message)elementToDestroy;
			MessageEnd receiveEvent = message.getReceiveEvent();
			MessageEnd sendEvent = message.getSendEvent();
			CompositeCommand command = new CompositeCommand("Restore Execution End");
			if(receiveEvent instanceof MessageOccurrenceSpecification) {
				OccurrenceSpecification end = (OccurrenceSpecification)receiveEvent;
				addRestoreExecutionEndCcommand(command, request.getEditingDomain(), end, true);
				addRestoreExecutionEndCcommand(command, request.getEditingDomain(), end, false);
			}
			if(sendEvent instanceof MessageOccurrenceSpecification) {
				OccurrenceSpecification end = (OccurrenceSpecification)sendEvent;
				addRestoreExecutionEndCcommand(command, request.getEditingDomain(), end, true);
				addRestoreExecutionEndCcommand(command, request.getEditingDomain(), end, false);
			}
			if(command.canExecute()) {
				return command.reduce();
			}
		}
		//Try to restore the end of execution when the message end has been removed.
		else if(elementToDestroy instanceof MessageOccurrenceSpecification) {
			CompositeCommand command = new CompositeCommand("Restore Execution End");
			MessageOccurrenceSpecification end = (MessageOccurrenceSpecification)elementToDestroy;
			addRestoreExecutionEndCcommand(command, request.getEditingDomain(), end, true);
			addRestoreExecutionEndCcommand(command, request.getEditingDomain(), end, false);
			if(command.canExecute()) {
				return command.reduce();
			}
		}
		return super.getAfterDestroyElementCommand(request);
	}

	private void addRestoreExecutionEndCcommand(CompositeCommand command, TransactionalEditingDomain editingDomain, OccurrenceSpecification end, boolean isStart) {
		ExecutionSpecification execution = OccurrenceSpecificationHelper.findExecutionWith(end, isStart);
		if(execution == null) {
			return;
		}
		RestoreExecutionEndCommand cmd = new RestoreExecutionEndCommand(editingDomain, execution, isStart);
		cmd.setContainer((InteractionFragment)end.eContainer());
		cmd.setCovered(end.getCovered());
		//Add index support.
		int executionIndex = getIndex(execution);
		int index = getIndex(end);
		if(isStart && index > executionIndex) {
			index = executionIndex;
		} else if(!isStart && index <= executionIndex) {
			index = executionIndex + 1;
		}
		cmd.setIndex(index);
		command.add(cmd);
	}

	private int getIndex(InteractionFragment fragment) {
		if(fragment == null || fragment.eContainer() == null) {
			return -1;
		}
		EObject parent = fragment.eContainer();
		if(parent instanceof Interaction) {
			return ((Interaction)parent).getFragments().indexOf(fragment);
		} else if(parent instanceof InteractionOperand) {
			return ((InteractionOperand)parent).getFragments().indexOf(fragment);
		}
		return -1;
	}

	private class RestoreExecutionEndCommand extends AbstractTransactionalCommand {

		private ExecutionSpecification execution;

		private boolean isStart;

		private InteractionFragment container;

		private Lifeline covered;

		private int index;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 * @param isStart
		 */
		public RestoreExecutionEndCommand(TransactionalEditingDomain domain, ExecutionSpecification execution, boolean isStart) {
			super(domain, "Restore Execution Ends when Message Destroied", null);
			this.execution = execution;
			this.isStart = isStart;
		}

		/**
		 * @param index
		 */
		public void setIndex(int index) {
			this.index = index;
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
			//Once the execution has been removed, ignore it.
			if(execution.eContainer() == null) {
				return CommandResult.newOKCommandResult();
			}
			ExecutionOccurrenceSpecification newEnd = null;
			InteractionFragment container = (InteractionFragment)getContainer();
			EList<InteractionFragment> fragments = null;
			if(container instanceof Interaction) {
				newEnd = (ExecutionOccurrenceSpecification)((Interaction)container).createFragment(null, UMLPackage.eINSTANCE.getExecutionOccurrenceSpecification());
				fragments = ((Interaction)container).getFragments();
			} else if(container instanceof InteractionOperand) {
				newEnd = (ExecutionOccurrenceSpecification)((InteractionOperand)container).createFragment(null, UMLPackage.eINSTANCE.getExecutionOccurrenceSpecification());
				fragments = ((InteractionOperand)container).getFragments();
			}
			if(newEnd == null) {
				return CommandResult.newCancelledCommandResult();
			}
			newEnd.setExecution(execution);
			newEnd.setCovered(getCovered());
			if(isStart) {
				newEnd.setName(execution.getName() + "Start");
				execution.setStart(newEnd);
			} else {
				newEnd.setName(execution.getName() + "Finish");
				execution.setFinish(newEnd);
			}
			//Index support.
			if(index != -1 && fragments != null && index >= 0 && index < fragments.size() && fragments.indexOf(newEnd) != index) {
				fragments.move(index, newEnd);
			}
			return CommandResult.newOKCommandResult();
		}

		/**
		 * @return the container
		 */
		public InteractionFragment getContainer() {
			if(container == null && execution != null) {
				return (InteractionFragment)execution.eContainer();
			}
			return container;
		}

		/**
		 * @param container
		 *        the container to set
		 */
		public void setContainer(InteractionFragment container) {
			this.container = container;
		}

		/**
		 * @return the covered
		 */
		public Lifeline getCovered() {
			if(covered == null && execution != null) {
				EList<Lifeline> covereds = execution.getCovereds();
				return covereds.size() != 0 ? covereds.get(0) : null;
			}
			return covered;
		}

		/**
		 * @param covered
		 *        the covered to set
		 */
		public void setCovered(Lifeline covered) {
			this.covered = covered;
		}
	}
}
