/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.component.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class AbstractionReorientCommand extends EditElementCommand {

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
	public AbstractionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof Abstraction) {
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
		if(!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		if(getLink().getSuppliers().size() != 1) {
			return false;
		}
		NamedElement target = (NamedElement)getLink().getSuppliers().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistAbstraction_4013(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		if(getLink().getClients().size() != 1) {
			return false;
		}
		NamedElement source = (NamedElement)getLink().getClients().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistAbstraction_4013(container, getLink(), source, getNewTarget());
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
		getLink().getClients().remove(getOldSource());
		getLink().getClients().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getSuppliers().remove(getOldTarget());
		getLink().getSuppliers().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Abstraction getLink() {
		return (Abstraction)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldSource() {
		return (NamedElement)oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewSource() {
		return (NamedElement)newEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldTarget() {
		return (NamedElement)oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewTarget() {
		return (NamedElement)newEnd;
	}
}
