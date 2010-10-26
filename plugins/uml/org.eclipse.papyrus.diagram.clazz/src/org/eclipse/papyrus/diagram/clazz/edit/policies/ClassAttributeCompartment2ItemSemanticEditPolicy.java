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
 */
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Property4CreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ClassAttributeCompartment2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassAttributeCompartment2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2008);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Property_3012 == req.getElementType()) {
			return getGEFWrapper(new Property4CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
