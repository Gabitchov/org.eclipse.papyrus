/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.policies.SysmlBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * @generated
 */
public class ConnectorReorientCommand extends EditElementCommand {

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
	public ConnectorReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Connector) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof ConnectableElement && newEnd instanceof ConnectableElement)) {
			return false;
		}
		ConnectableElement target = null;
		EList<ConnectorEnd> ends = getLink().getEnds();
		if (ends != null && !ends.isEmpty()) {
			target = ends.get(1).getRole();
		}
		if (!(getLink().eContainer() instanceof StructuredClassifier)) {
			return false;
		}
		StructuredClassifier container = (StructuredClassifier) getLink().eContainer();
		return SysmlBaseItemSemanticEditPolicy.LinkConstraints
				.canExistConnector_4001(container, getNewSource(), target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ConnectableElement && newEnd instanceof ConnectableElement)) {
			return false;
		}
		ConnectableElement source = null;
		EList<ConnectorEnd> ends = getLink().getEnds();
		if (ends != null && !ends.isEmpty()) {
			source = ends.get(0).getRole();
		}
		if (!(getLink().eContainer() instanceof StructuredClassifier)) {
			return false;
		}
		StructuredClassifier container = (StructuredClassifier) getLink().eContainer();
		return SysmlBaseItemSemanticEditPolicy.LinkConstraints
				.canExistConnector_4001(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		EList<ConnectorEnd> ends = getLink().getEnds();
		if (ends != null && !ends.isEmpty()) {
			ends.get(0).setRole(getNewSource());
			return CommandResult.newOKCommandResult(getLink());
		} else {
			return CommandResult.newCancelledCommandResult();
		}
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		EList<ConnectorEnd> ends = getLink().getEnds();
		if (ends != null && !ends.isEmpty()) {
			ends.get(1).setRole(getNewTarget());
			return CommandResult.newOKCommandResult(getLink());
		} else {
			return CommandResult.newCancelledCommandResult();
		}
	}

	/**
	 * @generated
	 */
	protected Connector getLink() {
		return (Connector) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getOldSource() {
		return (ConnectableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getNewSource() {
		return (ConnectableElement) newEnd;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getOldTarget() {
		return (ConnectableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getNewTarget() {
		return (ConnectableElement) newEnd;
	}
}
