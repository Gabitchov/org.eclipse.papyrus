/*****************************************************************************
 * Copyright (c) 2009 Atos Origin and CEA LIST
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Patrick Tessier (CEA LIST ) - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ObjectNode;

/**
 * @generated
 */
public class ExceptionHandlerReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public ExceptionHandlerReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof ExceptionHandler) {
			return false;
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if(!(oldEnd instanceof ExecutableNode && newEnd instanceof ExecutableNode)) {
			return false;
		}
		ObjectNode target = getLink().getExceptionInput();
		if(!(getLink().eContainer() instanceof ExecutableNode)) {
			return false;
		}
		ExecutableNode container = (ExecutableNode)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistExceptionHandler_4005(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof ObjectNode && newEnd instanceof ObjectNode)) {
			return false;
		}
		ExecutableNode source = getLink().getProtectedNode();
		if(!(getLink().eContainer() instanceof ExecutableNode)) {
			return false;
		}
		ExecutableNode container = (ExecutableNode)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistExceptionHandler_4005(container, getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setProtectedNode(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setExceptionInput(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected ExceptionHandler getLink() {
		return (ExceptionHandler)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ExecutableNode getOldSource() {
		return (ExecutableNode)oldEnd;
	}

	/**
	 * @generated
	 */
	protected ExecutableNode getNewSource() {
		return (ExecutableNode)newEnd;
	}

	/**
	 * @generated
	 */
	protected ObjectNode getOldTarget() {
		return (ObjectNode)oldEnd;
	}

	/**
	 * @generated
	 */
	protected ObjectNode getNewTarget() {
		return (ObjectNode)newEnd;
	}
}
