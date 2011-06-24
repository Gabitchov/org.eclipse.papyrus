package org.eclipse.papyrus.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

import org.eclipse.papyrus.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class CommentAnnotatedElementReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

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
	public CommentAnnotatedElementReorientCommand(
			ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (false == referenceOwner instanceof Comment) {
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
		if (!(oldEnd instanceof Element && newEnd instanceof Comment)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistCommentAnnotatedElement_3008(getNewSource(),
						getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistCommentAnnotatedElement_3008(getOldSource(),
						getNewTarget());
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
	 * @generated not
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getAnnotatedElements().remove(getOldTarget());
		getNewSource().getAnnotatedElements().add(getOldTarget());

		// modify the parent of the old Comment?
		// if now it has only one annotated Element
		if (getOldSource().getAnnotatedElements().size() == 1) {
			getOldSource().getAnnotatedElements().get(0).getOwnedComments()
					.add(getOldSource());
		}
		// if now it has no annotated Elements
		if (getOldSource().getAnnotatedElements().size() == 0) {
			((Model) getOldSource().eResource().getContents().get(0))
					.getOwnedComments().add(getOldSource());
		}

		// modify the parent of the new Comment?
		// if now it has only one annotated Element
		if (getNewSource().getAnnotatedElements().size() == 1) {
			getNewSource().getAnnotatedElements().get(0).getOwnedComments()
					.add(getNewSource());
		}
		// if now it has more than one annotated Element
		if (getNewSource().getAnnotatedElements().size() > 1) {
			((Model) getNewSource().eResource().getContents().get(0))
					.getOwnedComments().add(getNewSource());
		}

		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated not
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getAnnotatedElements().remove(getOldTarget());
		getOldSource().getAnnotatedElements().add(getNewTarget());

		// if the number of annotatedElements of the Comment is 1, change the
		// container of the Comment
		if (getOldSource().getAnnotatedElements().size() == 1) {
			getNewTarget().getOwnedComments().add(getOldSource());
		}

		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Comment getOldSource() {
		return (Comment) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Comment getNewSource() {
		return (Comment) newEnd;
	}

	/**
	 * @generated
	 */
	protected Element getOldTarget() {
		return (Element) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewTarget() {
		return (Element) newEnd;
	}
}
