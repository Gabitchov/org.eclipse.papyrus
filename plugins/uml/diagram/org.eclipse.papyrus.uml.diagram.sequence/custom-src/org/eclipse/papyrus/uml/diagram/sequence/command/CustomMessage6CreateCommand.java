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
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message6CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.MessageConnectionHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessage6CreateCommand extends Message6CreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 * @param source
	 * @param target
	 */
	public CustomMessage6CreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	/**
	 * Add a condition on the MOS container
	 * 
	 * @Override
	 */
	@Override
	public boolean canExecute() {
		if(!super.canExecute()) {
			return false;
		}
		if(getSource() != null && getTarget() != null) {
			if(!CommandHelper.hasValidContainer(getRequest())) {
				return false;
			}
		}
		return MessageConnectionHelper.canExist(MessageSort.ASYNCH_SIGNAL_LITERAL, getSource(), null);
	}

	/**
	 * Create a MessageOccurenceSpecification and the call event when a message is created
	 * 
	 * @Override
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		InteractionFragment sourceContainer = (InteractionFragment)getRequest().getParameters().get(SequenceRequestConstant.SOURCE_MODEL_CONTAINER);
		InteractionFragment targetContainer = (InteractionFragment)getRequest().getParameters().get(SequenceRequestConstant.TARGET_MODEL_CONTAINER);
		Message message = CommandHelper.doCreateMessage(container, MessageSort.ASYNCH_SIGNAL_LITERAL, getSource(), null, sourceContainer, targetContainer);
		if(message != null) {
			doConfigure(message, monitor, info);
			((CreateElementRequest)getRequest()).setNewElement(message);
			return CommandResult.newOKCommandResult(message);
		}
		return CommandResult.newErrorCommandResult("There is now valid container for events"); //$NON-NLS-1$
	}
}
