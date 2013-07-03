/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.AssociationBranchReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationHelper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * this class is used to allow reconnecting a association branch on elements
 * 
 */
public class CustomAssociationBranchReorientCommand extends AssociationBranchReorientCommand {

	private EObject oldNamedElementEnd;

	private EObject newNamedElementEnd;

	protected View connection = null;

	public CustomAssociationBranchReorientCommand(ReorientRelationshipRequest request) {
		super(request);
		oldNamedElementEnd = request.getOldRelationshipEnd();
		newNamedElementEnd = request.getNewRelationshipEnd();
		connection = (View)request.getParameters().get("graphical_edge");
	}

	/**
	 * it is impossible to retarget the source ( remove the association node)
	 */
	protected boolean canReorientSource() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean canReorientTarget() {
		if(!(oldNamedElementEnd instanceof Type && newNamedElementEnd instanceof Type)) {
			return false;
		}
		if(getLink().getEndTypes().size() < 1) {
			return false;
		}
		Type source = (Type)getLink().getEndTypes().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistAssociation_4019(container, getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {

		/* look for end for the given type */
		int i = 0;

		Property end = null;
		if(MultiAssociationHelper.getSemanticBranchEnd(connection) != null) {
			end = MultiAssociationHelper.getSemanticBranchEnd(connection);
			i = getLink().getMemberEnds().indexOf(end);
		} else {
			end = getLink().getMemberEnds().get(i);
			while(!end.getType().equals(getOldTarget())) {
				i++;
				end = getLink().getMemberEnds().get(i);
			}
		}
		return AssociationHelper.reconnect(i, getLink(), getNewTarget());

	}
}
