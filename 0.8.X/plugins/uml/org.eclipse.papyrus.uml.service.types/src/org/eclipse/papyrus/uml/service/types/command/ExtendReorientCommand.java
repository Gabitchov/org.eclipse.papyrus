/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.UseCase;

/**
 * <pre>
 * Re-orient command for {@link Extend} elements.
 * </pre>
 */
public class ExtendReorientCommand extends EditElementCommand {

	private final int reorientDirection;

	private final EObject oldEnd;

	private final EObject newEnd;

	/**
	 * <pre>
	 * Constructor.
	 * 
	 * @param request the re-orient relationship request.
	 * </pre>
	 */
	public ExtendReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * <pre>
	 * @see org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand#canExecute()
	 * 
	 * @return true if the command is executable.
	 * </pre>
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof Extend) {
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

	protected boolean canReorientSource() {
		if(!(oldEnd instanceof UseCase && newEnd instanceof UseCase)) {
			return false;
		}
		if(!(getLink().eContainer() instanceof UseCase)) {
			return false;
		}
		return true;
	}

	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof UseCase && newEnd instanceof UseCase)) {
			return false;
		}
		if(!(getLink().eContainer() instanceof UseCase)) {
			return false;
		}
		return true;
	}

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

	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setExtension(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setExtendedCase(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	protected Extend getLink() {
		return (Extend)getElementToEdit();
	}

	protected UseCase getOldSource() {
		return (UseCase)oldEnd;
	}

	protected UseCase getNewSource() {
		return (UseCase)newEnd;
	}

	protected UseCase getOldTarget() {
		return (UseCase)oldEnd;
	}

	protected UseCase getNewTarget() {
		return (UseCase)newEnd;
	}
}
