/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageReplyCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	protected final EObject source;

	/**
	 * @generated
	 */
	protected final EObject target;

	/**
	 * @generated
	 */
	protected Interaction container;

	/**
	 * @generated
	 */
	public MessageReplyCreateCommand(final CreateRelationshipRequest request, final EObject source, final EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		this.container = deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (this.source == null && this.target == null) {
			return false;
		}
		if (this.source != null && false == this.source instanceof MessageEnd) {
			return false;
		}
		if (this.target != null && false == this.target instanceof MessageEnd) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateMessage_41(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		final Message newElement = UMLFactory.eINSTANCE.createMessage();
		getContainer().getMessages().add(newElement);
		newElement.setReceiveEvent(getSource());
		newElement.setSendEvent(getTarget());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);

	}

	/**
	 * @generated
	 */
	protected void doConfigure(final Message newElement, final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		final ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		final ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setElementToEdit(final EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected MessageEnd getSource() {
		return (MessageEnd) this.source;
	}

	/**
	 * @generated
	 */
	protected MessageEnd getTarget() {
		return (MessageEnd) this.target;
	}

	/**
	 * @generated
	 */
	public Interaction getContainer() {
		return this.container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container. Modify with appropriate
	 * logic.
	 * 
	 * @generated
	 */
	protected Interaction deduceContainer(final EObject source, final EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof Interaction) {
				return (Interaction) element;
			}
		}
		return null;
	}

}
