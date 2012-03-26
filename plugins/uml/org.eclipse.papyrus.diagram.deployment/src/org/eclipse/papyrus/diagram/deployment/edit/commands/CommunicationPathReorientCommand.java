package org.eclipse.papyrus.diagram.deployment.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * @generated
 */
public class CommunicationPathReorientCommand extends EditElementCommand {

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
	public CommunicationPathReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof CommunicationPath) {
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
		if(!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}
		//if(getLink().getEndTypes().size() != 1) {
		if(getLink().getEndTypes().size() == 0) {
			return false;
		}
		Type target = (Type)getLink().getEndTypes().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistCommunicationPath_4010(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}
		//if getLink().getEndTypes().size() == 1 the source and the target is the same class
		if(getLink().getEndTypes().size() == 0) {
			return false;
		}
		Type source = (Type)getLink().getEndTypes().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistCommunicationPath_4010(container, getLink(), source, getNewTarget());
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
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		changePropertyEndType(getOldSource(), getNewSource());
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		changePropertyEndType(getOldTarget(), getNewTarget());
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @generated
	 */
	protected CommunicationPath getLink() {
		return (CommunicationPath)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Type getOldSource() {
		return (Type)oldEnd;
	}

	/**
	 * @generated
	 */
	protected Type getNewSource() {
		return (Type)newEnd;
	}

	/**
	 * @generated
	 */
	protected Type getOldTarget() {
		return (Type)oldEnd;
	}

	/**
	 * @generated
	 */
	protected Type getNewTarget() {
		return (Type)newEnd;
	}

	protected void changePropertyEndType(Type oldType, Type newType) {
		if(oldType != null && newType != null) {
			Property propertyToChange = null;
			for(Property end : getLink().getMemberEnds()) {
				if(oldType.equals(end.getType())) {
					propertyToChange = end;
					break;
				}
			}
			if(propertyToChange != null) {
				propertyToChange.setType(newType);
			}
		}
	}
}
