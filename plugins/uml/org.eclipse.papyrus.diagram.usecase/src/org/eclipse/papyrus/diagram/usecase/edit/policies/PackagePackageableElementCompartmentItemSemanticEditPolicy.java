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
import org.eclipse.papyrus.diagram.usecase.edit.commands.Actor3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Comment2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Component3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Constraint3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Package2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCase4CreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackagePackageableElementCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackagePackageableElementCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_2016);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Constraint_3010 == req.getElementType()) {
			return getGEFWrapper(new Constraint3CreateCommand(req));
		}
		if (UMLElementTypes.Actor_3011 == req.getElementType()) {
			return getGEFWrapper(new Actor3CreateCommand(req));
		}
		if (UMLElementTypes.UseCase_3012 == req.getElementType()) {
			return getGEFWrapper(new UseCase4CreateCommand(req));
		}
		if (UMLElementTypes.Component_3013 == req.getElementType()) {
			return getGEFWrapper(new Component3CreateCommand(req));
		}
		if (UMLElementTypes.Package_3014 == req.getElementType()) {
			return getGEFWrapper(new Package2CreateCommand(req));
		}
		if (UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new Comment2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
