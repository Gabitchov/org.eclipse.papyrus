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
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ControlFlow;

/**
 * @generated
 */
public class ControlFlowReorientCommand extends EditElementCommand {

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
	public ControlFlowReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof ControlFlow) {
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
		if(!(oldEnd instanceof ActivityNode && newEnd instanceof ActivityNode)) {
			return false;
		}
		ActivityNode target = getLink().getTarget();
		if(!(getLink().eContainer() instanceof Activity)) {
			return false;
		}
		Activity container = (Activity)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistControlFlow_4004(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof ActivityNode && newEnd instanceof ActivityNode)) {
			return false;
		}
		ActivityNode source = getLink().getSource();
		if(!(getLink().eContainer() instanceof Activity)) {
			return false;
		}
		Activity container = (Activity)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistControlFlow_4004(container, getLink(), source, getNewTarget());
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
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected ControlFlow getLink() {
		return (ControlFlow)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ActivityNode getOldSource() {
		return (ActivityNode)oldEnd;
	}

	/**
	 * @generated
	 */
	protected ActivityNode getNewSource() {
		return (ActivityNode)newEnd;
	}

	/**
	 * @generated
	 */
	protected ActivityNode getOldTarget() {
		return (ActivityNode)oldEnd;
	}

	/**
	 * @generated
	 */
	protected ActivityNode getNewTarget() {
		return (ActivityNode)newEnd;
	}
}
