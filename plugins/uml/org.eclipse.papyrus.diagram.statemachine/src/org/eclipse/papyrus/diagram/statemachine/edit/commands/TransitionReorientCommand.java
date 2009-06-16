package org.eclipse.papyrus.diagram.statemachine.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.ids.ReorientLinkIDs;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.UMLBaseItemSemanticEditPolicy;
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
	private View node;

	/**
	 * @generated
	 */
	private View link;

	/**
	 * @generated
	 */
	public TransitionReorientCommand(ReorientRelationshipRequest request) {
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
		if (false == getElementToEdit() instanceof Transition) {
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
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Vertex && newEnd instanceof Vertex)) {
			return false;
		}
		Vertex target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof Region)) {
			return false;
		}
		Region container = (Region) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistTransition_3001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Vertex && newEnd instanceof Vertex)) {
			return false;
		}
		Vertex source = getLink().getSource();
		if (!(getLink().eContainer() instanceof Region)) {
			return false;
		}
		Region container = (Region) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistTransition_3001(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	@Override
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
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		if (link != null && node != null)
			((Edge) link).setSource(node);
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		if (link != null && node != null)
			((Edge) link).setTarget(node);
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Transition getLink() {
		return (Transition) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Vertex getOldSource() {
		return (Vertex) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Vertex getNewSource() {
		return (Vertex) newEnd;
	}

	/**
	 * @generated
	 */
	protected Vertex getOldTarget() {
		return (Vertex) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Vertex getNewTarget() {
		return (Vertex) newEnd;
	}
}
