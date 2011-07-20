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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;

// TODO: Auto-generated Javadoc
/**
 * The Class GeneralizationReorientCommand.
 *
 * @generated
 */
public class GeneralizationReorientCommand extends EditElementCommand {

	/** The reorient direction. @generated */
	private final int reorientDirection;

	/** The old end. @generated */
	private final EObject oldEnd;

	/** The new end. @generated */
	private final EObject newEnd;

	/**
	 * Instantiates a new generalization reorient command.
	 *
	 * @param request the request
	 * @generated
	 */
	public GeneralizationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
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
		if(false == getElementToEdit() instanceof Generalization) {
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
		if(!(oldEnd instanceof Classifier && newEnd instanceof Classifier)) {
			return false;
		}
		Classifier target = getLink().getGeneral();
		if(!(getLink().eContainer() instanceof Classifier)) {
			return false;
		}
		Classifier container = (Classifier)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistGeneralization_4003(container, getLink(), getNewSource(), target);
	}

	/**
	 * Can reorient target.
	 *
	 * @return true, if successful
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof Classifier && newEnd instanceof Classifier)) {
			return false;
		}
		Classifier source = getLink().getSpecific();
		if(!(getLink().eContainer() instanceof Classifier)) {
			return false;
		}
		Classifier container = (Classifier)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistGeneralization_4003(container, getLink(), source, getNewTarget());
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
		getLink().setSpecific(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * Reorient target.
	 *
	 * @return the command result
	 * @throws ExecutionException the execution exception
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setGeneral(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * Gets the link.
	 *
	 * @return the link
	 * @generated
	 */
	protected Generalization getLink() {
		return (Generalization)getElementToEdit();
	}

	/**
	 * Gets the old source.
	 *
	 * @return the old source
	 * @generated
	 */
	protected Classifier getOldSource() {
		return (Classifier)oldEnd;
	}

	/**
	 * Gets the new source.
	 *
	 * @return the new source
	 * @generated
	 */
	protected Classifier getNewSource() {
		return (Classifier)newEnd;
	}

	/**
	 * Gets the old target.
	 *
	 * @return the old target
	 * @generated
	 */
	protected Classifier getOldTarget() {
		return (Classifier)oldEnd;
	}

	/**
	 * Gets the new target.
	 *
	 * @return the new target
	 * @generated
	 */
	protected Classifier getNewTarget() {
		return (Classifier)newEnd;
	}
}
