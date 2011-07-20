/*
 * 
 */

package org.eclipse.papyrus.diagram.deployment.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstraintConstrainedElementReorientCommand.
 *
 * @generated
 */
public class ConstraintConstrainedElementReorientCommand extends EditElementCommand {

	/** The reorient direction. @generated */
	private final int reorientDirection;

	/** The reference owner. @generated */
	private final EObject referenceOwner;

	/** The old end. @generated */
	private final EObject oldEnd;

	/** The new end. @generated */
	private final EObject newEnd;

	/**
	 * Instantiates a new constraint constrained element reorient command.
	 *
	 * @param request the request
	 * @generated
	 */
	public ConstraintConstrainedElementReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * Can execute.
	 *
	 * @return true, if successful
	 * @generated
	 */
	public boolean canExecute() {
		if(false == referenceOwner instanceof Constraint) {
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
	 * Can reorient source.
	 *
	 * @return true, if successful
	 * @generated
	 */
	protected boolean canReorientSource() {
		if(!(oldEnd instanceof Element && newEnd instanceof Constraint)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistConstraintConstrainedElement_4009(getNewSource(), getOldTarget());
	}

	/**
	 * Can reorient target.
	 *
	 * @return true, if successful
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistConstraintConstrainedElement_4009(getOldSource(), getNewTarget());
	}

	/**
	 * Do execute with result.
	 *
	 * @param monitor the monitor
	 * @param info the info
	 * @return the command result
	 * @throws ExecutionException the execution exception
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
	 * Reorient source.
	 *
	 * @return the command result
	 * @throws ExecutionException the execution exception
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getConstrainedElements().remove(getOldTarget());
		getNewSource().getConstrainedElements().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * Reorient target.
	 *
	 * @return the command result
	 * @throws ExecutionException the execution exception
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getConstrainedElements().remove(getOldTarget());
		getOldSource().getConstrainedElements().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * Gets the old source.
	 *
	 * @return the old source
	 * @generated
	 */
	protected Constraint getOldSource() {
		return (Constraint)referenceOwner;
	}

	/**
	 * Gets the new source.
	 *
	 * @return the new source
	 * @generated
	 */
	protected Constraint getNewSource() {
		return (Constraint)newEnd;
	}

	/**
	 * Gets the old target.
	 *
	 * @return the old target
	 * @generated
	 */
	protected Element getOldTarget() {
		return (Element)oldEnd;
	}

	/**
	 * Gets the new target.
	 *
	 * @return the new target
	 * @generated
	 */
	protected Element getNewTarget() {
		return (Element)newEnd;
	}
}
