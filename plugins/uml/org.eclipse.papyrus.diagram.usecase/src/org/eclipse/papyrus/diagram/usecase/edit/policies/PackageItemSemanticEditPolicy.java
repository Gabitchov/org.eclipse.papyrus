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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Actor2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ActorCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ComponentCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Package2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCase2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCaseCreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Actor_2002 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		if (UMLElementTypes.Actor_2003 == req.getElementType()) {
			return getGEFWrapper(new Actor2CreateCommand(req));
		}
		if (UMLElementTypes.UseCase_2004 == req.getElementType()) {
			return getGEFWrapper(new UseCaseCreateCommand(req));
		}
		if (UMLElementTypes.UseCase_2005 == req.getElementType()) {
			return getGEFWrapper(new UseCase2CreateCommand(req));
		}
		if (UMLElementTypes.Component_2006 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommand(req));
		}
		if (UMLElementTypes.Package_2009 == req.getElementType()) {
			return getGEFWrapper(new Package2CreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2008 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (UMLElementTypes.Comment_2010 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		Diagram currentDiagram = null;
		if (getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart) getHost()).getNotationView()
					.getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req,
				currentDiagram));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req, Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
			this.diagram = currentDiagram;
		}
	}

}
