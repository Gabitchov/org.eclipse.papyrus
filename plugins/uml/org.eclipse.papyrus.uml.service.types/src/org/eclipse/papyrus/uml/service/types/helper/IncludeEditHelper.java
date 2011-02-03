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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.IncludeReorientCommand;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper provides edit commands for UML {@link Include}.
 */
public class IncludeEditHelper extends DirectedRelationshipEditHelper {

	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getInclude_IncludingCase();
	}

	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getInclude_Addition();
	}

	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new IncludeReorientCommand(req);
	}
}
