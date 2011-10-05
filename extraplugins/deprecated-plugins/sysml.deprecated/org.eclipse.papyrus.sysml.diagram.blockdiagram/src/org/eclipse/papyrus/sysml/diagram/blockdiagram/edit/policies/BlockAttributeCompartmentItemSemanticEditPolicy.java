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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.commands.PropertyCreateCommand;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlElementTypes;

/**
 * @generated
 */
public class BlockAttributeCompartmentItemSemanticEditPolicy extends SysmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BlockAttributeCompartmentItemSemanticEditPolicy() {
		super(SysmlElementTypes.Block_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(SysmlElementTypes.Property_3001 == req.getElementType()) {
			return getGEFWrapper(new PropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}


}
