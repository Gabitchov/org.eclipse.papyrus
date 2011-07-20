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
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

// TODO: Auto-generated Javadoc
/**
 * The Class DependencyReorientCommand.
 *
 * @generated
 */
public class DependencyReorientCommand extends EditElementCommand {

	/** The reorient direction. @generated */
	private final int reorientDirection;

	/** The old end. @generated */
	private final EObject oldEnd;

	/** The new end. @generated */
	private final EObject newEnd;

	/**
	 * Instantiates a new dependency reorient command.
	 *
	 * @param request the request
	 * @generated
	 */
	public DependencyReorientCommand(ReorientRelationshipRequest request) {
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
		if(false == getElementToEdit() instanceof Dependency) {
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
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistDependency_4004(container, getLink(), getNewSource(), target);
	}

	/**
	 * Can reorient target.
	 *
	 * @return true, if successful
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
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistDependency_4004(container, getLink(), source, getNewTarget());
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
		getLink().getClients().remove(getOldSource());
		getLink().getClients().add(getNewSource());
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
		getLink().getSuppliers().remove(getOldTarget());
		getLink().getSuppliers().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * Gets the link.
	 *
	 * @return the link
	 * @generated
	 */
	protected Dependency getLink() {
		return (Dependency)getElementToEdit();
	}

	/**
	 * Gets the old source.
	 *
	 * @return the old source
	 * @generated
	 */
	protected NamedElement getOldSource() {
		return (NamedElement)oldEnd;
	}

	/**
	 * Gets the new source.
	 *
	 * @return the new source
	 * @generated
	 */
	protected NamedElement getNewSource() {
		return (NamedElement)newEnd;
	}

	/**
	 * Gets the old target.
	 *
	 * @return the old target
	 * @generated
	 */
	protected NamedElement getOldTarget() {
		return (NamedElement)oldEnd;
	}

	/**
	 * Gets the new target.
	 *
	 * @return the new target
	 * @generated
	 */
	protected NamedElement getNewTarget() {
		return (NamedElement)newEnd;
	}
}
