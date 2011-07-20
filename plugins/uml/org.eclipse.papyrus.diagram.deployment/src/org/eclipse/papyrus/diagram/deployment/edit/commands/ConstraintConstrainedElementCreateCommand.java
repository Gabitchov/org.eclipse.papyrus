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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstraintConstrainedElementCreateCommand.
 *
 * @generated
 */
public class ConstraintConstrainedElementCreateCommand extends EditElementCommand {

	/** The source. @generated */
	protected final EObject source;

	/** The target. @generated */
	protected final EObject target;

	/**
	 * Instantiates a new constraint constrained element create command.
	 *
	 * @param request the request
	 * @param source the source
	 * @param target the target
	 * @generated
	 */
	public ConstraintConstrainedElementCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
	}

	/**
	 * Can execute.
	 *
	 * @return true, if successful
	 * @generated
	 */
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Constraint) {
			return false;
		}
		if(target != null && false == target instanceof Element) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateConstraintConstrainedElement_4009(getSource(), getTarget());
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
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		if(getSource() != null && getTarget() != null) {
			getSource().getConstrainedElements().add(getTarget());
		}
		return CommandResult.newOKCommandResult();

	}



	/**
	 * Sets the element to edit.
	 *
	 * @param element the new element to edit
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 * @generated
	 */
	protected Constraint getSource() {
		return (Constraint)source;
	}

	/**
	 * Gets the target.
	 *
	 * @return the target
	 * @generated
	 */
	protected Element getTarget() {
		return (Element)target;
	}
}
