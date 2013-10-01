/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AssociationReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationHelper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 * command to reorient an assocation
 */
public class CAssociationReorientCommand extends AssociationReorientCommand {

	protected EObject newEnd;

	protected EObject oldEnd;

	protected int reorientDirection;

	public CAssociationReorientCommand(ReorientRelationshipRequest request) {
		super(request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if(!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}
		// if (getLink().getEndTypes().size() != 1) {
		if(getLink().getEndTypes().size() == 0) {
			return false;
		}
		Type target = (Type)getLink().getEndTypes().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistAssociation_4001(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof Type && newEnd instanceof Type)) {
			return false;
		}
		//if getLink().getEndTypes().size() == 1 the source and the target is the same classe
		if(getLink().getEndTypes().size() == 0) {
			return false;
		}
		Type source = (Type)getLink().getEndTypes().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistAssociation_4001(container, getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		return AssociationHelper.reconnect(AssociationHelper.source, getLink(), getNewSource());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		return AssociationHelper.reconnect(AssociationHelper.target, getLink(), getNewTarget());
	}
}
