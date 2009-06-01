/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Comment2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Component2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Constraint2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCase3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentUsecasesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentUsecasesItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_2015);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.UseCase_3009 == req.getElementType()) {
			return getGEFWrapper(new UseCase3CreateCommand(req));
		}
		if (UMLElementTypes.Component_3016 == req.getElementType()) {
			return getGEFWrapper(new Component2CreateCommand(req));
		}
		if (UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new Comment2CreateCommand(req));
		}
		if (UMLElementTypes.Constraint_3017 == req.getElementType()) {
			return getGEFWrapper(new Constraint2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
