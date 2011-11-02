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
import org.eclipse.papyrus.diagram.usecase.edit.commands.ActorInComponentCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ComponentInComponentCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintInComponentCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCaseInComponentCreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentUsecases3ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentUsecases3ItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_3013);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.UseCase_3009 == req.getElementType()) {
			return getGEFWrapper(new UseCaseInComponentCreateCommand(req));
		}
		if(UMLElementTypes.Component_3016 == req.getElementType()) {
			return getGEFWrapper(new ComponentInComponentCreateCommand(req));
		}
		if(UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if(UMLElementTypes.Constraint_3017 == req.getElementType()) {
			return getGEFWrapper(new ConstraintInComponentCreateCommand(req));
		}
		if(UMLElementTypes.Actor_3018 == req.getElementType()) {
			return getGEFWrapper(new ActorInComponentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
