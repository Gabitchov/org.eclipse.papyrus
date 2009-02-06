/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.ids.ReorientLinkIDs;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;

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
	private View node;

	/**
	 * @generated
	 */
	private View link;

	/**
	 * @generated
	 */
	public ExceptionHandlerReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();

		if (request.getParameter(ReorientLinkIDs.nodeEditPart) != null) {
			node = (View) request.getParameter(ReorientLinkIDs.nodeEditPart);
		}
		if (request.getParameter(ReorientLinkIDs.linkEditPart) != null) {
			link = (View) request.getParameter(ReorientLinkIDs.linkEditPart);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof ExceptionHandler) {
			return false;
		}
		if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof ExecutableNode && newEnd instanceof ExecutableNode)) {
			return false;
		}
		ExecutableNode target = getLink().getHandlerBody();
		if (!(getLink().eContainer() instanceof ExecutableNode)) {
			return false;
		}
		ExecutableNode container = (ExecutableNode) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistExceptionHandler_3004(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ExecutableNode && newEnd instanceof ExecutableNode)) {
			return false;
		}
		ExecutableNode source = getLink().getProtectedNode();
		if (!(getLink().eContainer() instanceof ExecutableNode)) {
			return false;
		}
		ExecutableNode container = (ExecutableNode) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistExceptionHandler_3004(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setProtectedNode(getNewSource());
		if (link != null && node != null)
			((Edge) link).setSource(node);
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setHandlerBody(getNewTarget());
		if (link != null && node != null)
			((Edge) link).setTarget(node);
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected ExceptionHandler getLink() {
		return (ExceptionHandler) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ExecutableNode getOldSource() {
		return (ExecutableNode) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ExecutableNode getNewSource() {
		return (ExecutableNode) newEnd;
	}

	/**
	 * @generated
	 */
	protected ExecutableNode getOldTarget() {
		return (ExecutableNode) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ExecutableNode getNewTarget() {
		return (ExecutableNode) newEnd;
	}
}
