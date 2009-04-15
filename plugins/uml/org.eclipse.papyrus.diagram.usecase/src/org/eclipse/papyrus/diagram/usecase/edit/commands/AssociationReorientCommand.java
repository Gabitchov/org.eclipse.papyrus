/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
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
package org.eclipse.papyrus.diagram.usecase.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.usecase.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * @generated
 */
public class AssociationReorientCommand extends EditElementCommand {

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
	public AssociationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Association) {
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
		if (!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		Property targetEnd = AssociationEndConvention.getTargetEnd(getLink());
		if (targetEnd == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistAssociation_4004(container, getNewSource(), targetEnd
						.getType());
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		Property sourceEnd = AssociationEndConvention.getSourceEnd(getLink());
		if (sourceEnd == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistAssociation_4004(container, sourceEnd.getType(),
						getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
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
		Association association = getLink();
		Property actualSource = AssociationEndConvention
				.getSourceEnd(association);
		actualSource.setType(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		Association association = getLink();
		Property actualTarget = AssociationEndConvention
				.getTargetEnd(association);
		actualTarget.setType(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Association getLink() {
		return (Association) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Type getOldSource() {
		return (Type) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Type getNewSource() {
		return (Type) newEnd;
	}

	/**
	 * @generated
	 */
	protected Type getOldTarget() {
		return (Type) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Type getNewTarget() {
		return (Type) newEnd;
	}
}
