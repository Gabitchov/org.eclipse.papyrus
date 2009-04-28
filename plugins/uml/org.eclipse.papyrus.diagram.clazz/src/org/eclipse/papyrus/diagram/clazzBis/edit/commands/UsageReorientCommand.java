package org.eclipse.papyrus.diagram.clazzBis.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Usage;

/**
 * @generated
 */
public class UsageReorientCommand extends EditElementCommand {

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
	public UsageReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Usage) {
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
		if (!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		if (getLink().getSuppliers().size() != 1) {
			return false;
		}
		NamedElement target = (NamedElement) getLink().getSuppliers().get(0);
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		return org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistUsage_3010(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		if (getLink().getClients().size() != 1) {
			return false;
		}
		NamedElement source = (NamedElement) getLink().getClients().get(0);
		if (!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package) getLink().eContainer();
		return org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy.LinkConstraints.canExistUsage_3010(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
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
	protected Usage getLink() {
		return (Usage) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldSource() {
		return (NamedElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewSource() {
		return (NamedElement) newEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldTarget() {
		return (NamedElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewTarget() {
		return (NamedElement) newEnd;
	}
}
