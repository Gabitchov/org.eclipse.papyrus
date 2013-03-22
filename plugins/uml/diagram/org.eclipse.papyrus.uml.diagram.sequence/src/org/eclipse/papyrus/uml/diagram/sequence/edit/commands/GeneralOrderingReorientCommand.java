package org.eclipse.papyrus.uml.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * @generated
 */
public class GeneralOrderingReorientCommand extends EditElementCommand {

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
	public GeneralOrderingReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof GeneralOrdering) {
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
		if(!(oldEnd instanceof OccurrenceSpecification && newEnd instanceof OccurrenceSpecification)) {
			return false;
		}
		OccurrenceSpecification target = getLink().getAfter();
		if(!(getLink().eContainer() instanceof InteractionFragment)) {
			return false;
		}
		InteractionFragment container = (InteractionFragment)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistGeneralOrdering_4012(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof OccurrenceSpecification && newEnd instanceof OccurrenceSpecification)) {
			return false;
		}
		OccurrenceSpecification source = getLink().getBefore();
		if(!(getLink().eContainer() instanceof InteractionFragment)) {
			return false;
		}
		InteractionFragment container = (InteractionFragment)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistGeneralOrdering_4012(container, getLink(), source, getNewTarget());
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
		getLink().setBefore(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setAfter(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected GeneralOrdering getLink() {
		return (GeneralOrdering)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected OccurrenceSpecification getOldSource() {
		return (OccurrenceSpecification)oldEnd;
	}

	/**
	 * @generated
	 */
	protected OccurrenceSpecification getNewSource() {
		return (OccurrenceSpecification)newEnd;
	}

	/**
	 * @generated
	 */
	protected OccurrenceSpecification getOldTarget() {
		return (OccurrenceSpecification)oldEnd;
	}

	/**
	 * @generated
	 */
	protected OccurrenceSpecification getNewTarget() {
		return (OccurrenceSpecification)newEnd;
	}
}
