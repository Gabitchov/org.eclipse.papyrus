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

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.common.commands.EObjectInheritanceCopyCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message5CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.MessageConnectionHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessage5CreateCommand extends Message5CreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 * @param source
	 * @param target
	 */
	public CustomMessage5CreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	/**
	 * Add a condition on the MOS container
	 * 
	 * @Override
	 */
	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Element) {
			return false;
		}
		if(target != null && false == target instanceof Element) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		if(getSource() != null && getTarget() != null) {
			if(!CommandHelper.hasValidContainer(getRequest())) {
				return false;
			}
		}
		if(!UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateMessage_4007(getContainer(), getSource(), getTarget())) {
			return false;
		}
		return MessageConnectionHelper.canExist(MessageSort.DELETE_MESSAGE_LITERAL, getSource(), getTarget());
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
		Lifeline lifeline = null;
		// the Receive Message End
		MessageOccurrenceSpecification receiveMessageEnd = null;
		if(getTarget() instanceof DestructionOccurrenceSpecification) {
			receiveMessageEnd = getReceiveMessageEnd();
			if(receiveMessageEnd != null) {
				lifeline = receiveMessageEnd.getCovereds().get(0);
			} else {
				lifeline = ((DestructionOccurrenceSpecification)getTarget()).getCovereds().get(0);
			}
		} else {
			lifeline = (Lifeline)getTarget();
		}
		// Create the message
		Message message = CommandHelper.doCreateMessage(container, MessageSort.DELETE_MESSAGE_LITERAL, getSource(), lifeline, sourceContainer, targetContainer, null, receiveMessageEnd);
		if(message != null) {
			doConfigure(message, monitor, info);
			((CreateElementRequest)getRequest()).setNewElement(message);
			return CommandResult.newOKCommandResult(message);
		}
		return CommandResult.newErrorCommandResult("There is now valid container for events"); //$NON-NLS-1$
	}

	/**
	 * Get a messageOccurrenceSpecification associated with the existing DestructionEvent :
	 * -> Retrieve the associated occurrenceSpecification
	 * -> Transform it into a mos
	 * 
	 * @return the mos
	 * @throws ExecutionException
	 */
	private MessageOccurrenceSpecification getReceiveMessageEnd() throws ExecutionException {
		MessageOccurrenceSpecification mosResult = null;
		OccurrenceSpecification os = null;
		// Get the occurrence specification associated with the destructionEvent
		Collection<Setting> settings = UML2Util.getInverseReferences(getTarget());
		for(Setting setting : settings) {
			if(setting.getEObject() instanceof OccurrenceSpecification) {
				os = (OccurrenceSpecification)setting.getEObject();
			}
		}
		if(os != null) {
			// Transform the occurrenceSpecification into a mos (conserving its properties).
			EObjectInheritanceCopyCommand cmd = new EObjectInheritanceCopyCommand(os, UMLPackage.eINSTANCE.getMessageOccurrenceSpecification(), getEditingDomain());
			if(cmd.canExecute()) {
				IStatus status = cmd.execute(null, null);
				if(status.isOK()) {
					// Destroy the old os
					os.destroy();
					// Get the result MessageOccurrenceSpecification
					mosResult = (MessageOccurrenceSpecification)cmd.getResultEobject();
				}
			}
		}
		return mosResult;
	}
}
