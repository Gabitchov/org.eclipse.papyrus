package org.eclipse.papyrus.diagram.clazz.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationHelper;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 * @generated
 */
public class AssociationReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final int reorientDirection;

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
		System.err.println("-->" + getElementToEdit());
		if (false == getElementToEdit() instanceof Association) {
			return false;
		}
		System.err.println("--> Test on element to edit: ok");
		System.err.println("--> reorientDirection" + reorientDirection);
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			System.err.println("--> Test canReorientSource(): "
					+ canReorientSource());
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			System.err.println("--> Test canReorientTarget(): "
					+ canReorientTarget());
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
		// if (getLink().getEndTypes().size() != 1) {
		if (getLink().getEndTypes().size() == 1) {
			return false;
		}
		Type target = (Type) getLink().getEndTypes().get(0);
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistAssociation_4001(container, getNewSource(), target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}

		// if (getLink().getEndTypes().size() != 1) {
		if (getLink().getEndTypes().size() == 1) {
			return false;
		}
		Type source = (Type) getLink().getEndTypes().get(0);
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistAssociation_4001(container, source, getNewTarget());
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
	 * @generated
	 */
	protected Association getLink() {
		return (Association) getElementToEdit();
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
	protected Type getNewTarget() {
		return (Type) newEnd;
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
	protected Type getOldTarget() {
		return (Type) oldEnd;
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		return AssociationHelper.reconnect(AssociationHelper.source, getLink(),
				getNewSource());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		return AssociationHelper.reconnect(AssociationHelper.target, getLink(),
				getNewTarget());

	}
}
