/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.utils.ClassifierUtils;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * <pre>
 * Re-orient command for binary {@link Association}.
 * 
 * Expected behavior:
 * When the association is re-oriented, the type of the property on the opposite side
 * of the re-oriented association end has to be modified accordingly to the new end 
 * (from a graphical point of view - its a Classifier).
 * </pre>
 */
public class AssociationReorientCommand extends EditElementCommand {

	private final int reorientDirection;

	private final EObject oldEnd;

	private final EObject newEnd;

	/**
	 * Constructor.
	 */
	public AssociationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * Test if the command can be executed.
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof Association) {
			return false;
		}

		if(getLink().getMemberEnds().size() != 2) {
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
	 * <pre>
	 * This method test if the {@link Association} can be re-oriented to a new source.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new source
	 */
	protected boolean canReorientSource() {
		// Verify possible type of new source

		// The re-orient of the graphical source of the link also results in the
		// modification of the semantic source of the association (if not owned by the association)
		// the new parent of the semantic source has to be the new graphical source.
		if(!getLink().getOwnedEnds().contains(getSemanticSource())) {

			// The semantic source should be moved to a new parent (a Classifier that can hold
			// attributes), ensure the new parent (new graphical source) match following kind of
			// Classifier: Artifact, DataType, Interface, Signal, StructuredClassifier, Class.
			if(!((getNewSource() instanceof Artifact) || (getNewSource() instanceof DataType) || (getNewSource() instanceof Interface) || (getNewSource() instanceof Signal) || (getNewSource() instanceof StructuredClassifier) || (getNewSource() instanceof Class))) {
				return false;
			}

			return true;
		}

		// Semantic source is owned by the Association, only ensure the graphical source is a Classifier.
		if(!(getNewSource() instanceof Classifier)) {
			return false;
		}

		return true;
	}

	/**
	 * <pre>
	 * This method test if the {@link Association} can be re-oriented to a new target.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new source
	 */
	protected boolean canReorientTarget() {
		// Verify possible type of new target

		// The re-orient of the graphical target of the link also results in the
		// modification of the semantic target of the association (if not owned by the association)
		// the new parent of the semantic target has to be the new graphical target.
		if(!getLink().getOwnedEnds().contains(getSemanticTarget())) {

			// The semantic target should be moved to a new parent (a Classifier that can hold
			// attributes), ensure the new parent (new graphical target) match following kind of
			// Classifier: Artifact, DataType, Interface, Signal, StructuredClassifier, Class.
			if(!((getNewTarget() instanceof Artifact) || (getNewTarget() instanceof DataType) || (getNewTarget() instanceof Interface) || (getNewTarget() instanceof Signal) || (getNewTarget() instanceof StructuredClassifier) || (getNewTarget() instanceof Class))) {
				return false;
			}

			return true;
		}

		// Semantic target is owned by the Association, only ensure the graphical target is a Classifier.
		if(!(getNewTarget() instanceof Classifier)) {
			return false;
		}

		return true;
	}

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

	protected CommandResult reorientSource() throws ExecutionException {
		// The re-orient of the graphical source of the link results in the
		// modification of the semantic target of the association.
		// Let the advice do the property move via edit service
		//reorientEnd(getSemanticTarget(), (Classifier)getNewSource());

		// The re-orient of the graphical source of the link also results in the
		// modification of the semantic source of the association (if not owned by the association)
		// the new parent of the semantic source has to be the new graphical source.
		if(!getLink().getOwnedEnds().contains(getSemanticSource())) {
			// Let the advice do the property move via edit service
			//moveEnd(getSemanticSource(), (Classifier)getNewSource());
		}

		return CommandResult.newOKCommandResult(getLink());
	}

	protected CommandResult reorientTarget() throws ExecutionException {
		// The re-orient of the graphical target of the link results in the
		// modification of the semantic source of the association.		
		// Let the advice do the property move via edit service
		//reorientEnd(getSemanticSource(), (Classifier)getNewTarget());

		// The re-orient of the graphical target of the link also results in the
		// modification of the semantic target of the association (if not owned by the association)
		// the new parent of the semantic target has to be the new graphical target.
		if(!getLink().getOwnedEnds().contains(getSemanticTarget())) {
			// Let the advice do the property move via edit service
			//moveEnd(getSemanticTarget(), (Classifier)getNewTarget());
		}

		return CommandResult.newOKCommandResult(getLink());
	}

	@Deprecated
	private void reorientEnd(Property end, Classifier newEndType) throws ExecutionException {
		end.setType(newEndType);
	}

	@Deprecated
	private void moveEnd(Property end, Classifier newOwner) throws ExecutionException {
		boolean added = ClassifierUtils.addOwnedAttribute(newOwner, end);

		if(!added) {
			throw new UnsupportedOperationException("Cannot add a Property on Classifier " + newOwner.getQualifiedName());
		}
	}

	/**
	 * Get the link to re-orient.
	 * 
	 * @return the edited {@link Association}
	 */
	protected Association getLink() {
		return (Association)getElementToEdit();
	}

	/**
	 * Get the old {@link Association} source.
	 * 
	 * @return the previous {@link Association} source.
	 */
	protected Element getOldSource() {
		return (Element)oldEnd;
	}

	/**
	 * Get the new {@link Association} source.
	 * 
	 * @return the new {@link Association} source.
	 */
	protected Element getNewSource() {
		return (Element)newEnd;
	}

	/**
	 * Get the old {@link Association} target.
	 * 
	 * @return the previous {@link Association} target.
	 */
	protected Element getOldTarget() {
		return (Element)oldEnd;
	}

	/**
	 * Get the new {@link Association} target.
	 * 
	 * @return the new {@link Association} target.
	 */
	protected Element getNewTarget() {
		return (Element)newEnd;
	}


	/**
	 * Get the {@link Association} semantic source.
	 * 
	 * @return the {@link Association} semantic source.
	 */
	protected Property getSemanticSource() {
		return getLink().getMemberEnds().get(0);
	}

	/**
	 * Get the {@link Association} semantic target.
	 * 
	 * @return the {@link Association} semantic target.
	 */
	protected Property getSemanticTarget() {
		return getLink().getMemberEnds().get(1);
	}
}
