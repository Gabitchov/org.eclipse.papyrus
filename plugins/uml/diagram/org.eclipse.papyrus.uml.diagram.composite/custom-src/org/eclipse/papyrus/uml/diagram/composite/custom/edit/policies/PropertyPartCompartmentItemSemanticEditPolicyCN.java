/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.command.PropertyPartCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the PropertyPartCompartment element (when used in CompositeStructure Diagram)
 * </pre>
 */
public class PropertyPartCompartmentItemSemanticEditPolicyCN extends org.eclipse.papyrus.uml.diagram.composite.edit.policies.PropertyPartCompartmentItemSemanticEditPolicyCN {

	/**
	 * <pre>
	 * Calls a custom creation command that allow the creation of a Property 
	 * on an existing Property.
	 * Semantically the Property is created owned by the type the edited Property.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Property_3070 == req.getElementType()) {
			return getGEFWrapper(new PropertyPartCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
