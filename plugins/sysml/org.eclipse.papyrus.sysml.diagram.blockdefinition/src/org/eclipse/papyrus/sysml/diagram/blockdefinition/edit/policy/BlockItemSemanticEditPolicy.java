/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic.CustomClassItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.composite.edit.commands.PortCreateCommand;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;


public class BlockItemSemanticEditPolicy extends CustomClassItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Port_3069 == req.getElementType()) {
			return getGEFWrapper(new PortCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
