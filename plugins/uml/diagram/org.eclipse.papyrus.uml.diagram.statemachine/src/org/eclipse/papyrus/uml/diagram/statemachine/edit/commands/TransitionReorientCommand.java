package org.eclipse.papyrus.uml.diagram.statemachine.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomTransitionReorientCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
public class TransitionReorientCommand extends EditElementCommand {

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
	public TransitionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof Transition) {
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
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		if(!(oldEnd instanceof Vertex && newEnd instanceof Vertex)) {
			return false;
		}
		Vertex target = getLink().getTarget();
		if(!(getLink().eContainer() instanceof Region)) {
			return false;
		}
		// TODO: avoid modifications here. Not done due to many required changes
		if (!CustomTransitionReorientCommand.isValid(newEnd, target)) {
			return false;
		}
		Region container = (Region)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistTransition_7000(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof Vertex && newEnd instanceof Vertex)) {
			return false;
		}
		Vertex source = getLink().getSource();
		if(!(getLink().eContainer() instanceof Region)) {
			return false;
		}
		// TODO: avoid modifications here. Not done due to many required changes
		if (!CustomTransitionReorientCommand.isValid(source, newEnd)) {
			return false;
		}
		Region container = (Region)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistTransition_7000(container, getLink(), source, getNewTarget());
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
	protected Transition getLink() {
		return (Transition)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Vertex getNewSource() {
		return (Vertex)newEnd;
	}

	/**
	 * @generated
	 */
	protected Vertex getNewTarget() {
		return (Vertex)newEnd;
	}

	/**
	 * @generated
	 */
	protected Vertex getOldSource() {
		return (Vertex)oldEnd;
	}

	/**
	 * @generated
	 */
	protected Vertex getOldTarget() {
		return (Vertex)oldEnd;
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		// TODO: avoid modifications here. Not done due to many required changes
		CustomTransitionReorientCommand.changeContainer(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		CustomTransitionReorientCommand.changeContainer(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}
}
