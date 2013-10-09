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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.Dependency2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

/**
 * because of the nature of this relation the test about can execute has to be change
 * 
 */
public class BranchDependenctReorientCommand extends Dependency2ReorientCommand {

	private EObject oldNamedElementEnd;

	private EObject newNamedElementEnd;

	public BranchDependenctReorientCommand(ReorientRelationshipRequest request) {
		super(request);
		oldNamedElementEnd = request.getOldRelationshipEnd();
		newNamedElementEnd = request.getNewRelationshipEnd();
	}

	@Override
	protected boolean canReorientSource() {
		if(!(oldNamedElementEnd instanceof NamedElement && newNamedElementEnd instanceof NamedElement)) {
			return false;
		}
		//modification from the generated code
		if(getLink().getSuppliers().size() < 1) {
			return false;
		}
		NamedElement target = (NamedElement)getLink().getSuppliers().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistDependency_4018(container, getLink(), getNewSource(), target);
	}

	@Override
	protected boolean canReorientTarget() {
		if(!(oldNamedElementEnd instanceof NamedElement && newNamedElementEnd instanceof NamedElement)) {
			return false;
		}
		//modification from the generated code
		if(getLink().getClients().size() < 1) {
			return false;
		}
		NamedElement source = (NamedElement)getLink().getClients().get(0);
		if(!(getLink().eContainer() instanceof Package)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistDependency_4018(container, getLink(), source, getNewTarget());
	}
}
