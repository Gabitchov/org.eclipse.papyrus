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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * 
 * Edit helper class for {@link ProtocolStateMachine}
 * 
 * Expected behavior:
 * - Remove any related {@link ProtocolConformance}
 * 
 * </pre>
 */
public class ProtocolStateMachineEditHelper extends ClassEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest req) {

		ProtocolStateMachine elementToDelete = (ProtocolStateMachine)req.getElementToDestroy();

		List<DirectedRelationship> relationships = new ArrayList<DirectedRelationship>();
		// Get related ProtocolConformance
		relationships.addAll(elementToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getProtocolConformance()));
		relationships.addAll(elementToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getProtocolConformance()));

		// Return the command to destroy all these ProtocolConformance
		if(!relationships.isEmpty()) {
			return req.getDestroyDependentsCommand(relationships);
		}

		return super.getDestroyDependentsCommand(req);
	}
}
