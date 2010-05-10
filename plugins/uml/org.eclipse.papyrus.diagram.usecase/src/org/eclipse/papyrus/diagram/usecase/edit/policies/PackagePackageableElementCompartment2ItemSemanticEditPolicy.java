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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ActorInPackageCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ComponentInPackageCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintInPackageCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCaseInPackageCreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackagePackageableElementCompartment2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackagePackageableElementCompartment2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_3014);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Constraint_3010 == req.getElementType()) {
			return getGEFWrapper(new ConstraintInPackageCreateCommand(req));
		}
		if(UMLElementTypes.Actor_3011 == req.getElementType()) {
			return getGEFWrapper(new ActorInPackageCreateCommand(req));
		}
		if(UMLElementTypes.UseCase_3012 == req.getElementType()) {
			return getGEFWrapper(new UseCaseInPackageCreateCommand(req));
		}
		if(UMLElementTypes.Component_3013 == req.getElementType()) {
			return getGEFWrapper(new ComponentInPackageCreateCommand(req));
		}
		if(UMLElementTypes.Package_3014 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
