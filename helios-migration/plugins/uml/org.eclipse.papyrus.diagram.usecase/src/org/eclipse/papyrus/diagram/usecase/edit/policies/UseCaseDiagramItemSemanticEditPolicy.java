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
import org.eclipse.papyrus.diagram.usecase.edit.commands.PackageCreateCommandTN;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ShortCutDiagramCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCase2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCaseCreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class UseCaseDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public UseCaseDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Actor_2011 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		if(UMLElementTypes.Actor_2012 == req.getElementType()) {
			return getGEFWrapper(new Actor2CreateCommand(req));
		}
		if(UMLElementTypes.UseCase_2013 == req.getElementType()) {
			return getGEFWrapper(new UseCaseCreateCommand(req));
		}
		if(UMLElementTypes.UseCase_2014 == req.getElementType()) {
			return getGEFWrapper(new UseCase2CreateCommand(req));
		}
		if(UMLElementTypes.Component_2015 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommand(req));
		}
		if(UMLElementTypes.Package_2016 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommandTN(req));
		}
		if(UMLElementTypes.Constraint_2017 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if(UMLElementTypes.Comment_2018 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if(UMLElementTypes.Diagram_2019 == req.getElementType()) {
			return getGEFWrapper(new ShortCutDiagramCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		Diagram currentDiagram = null;
		if(getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart)getHost()).getNotationView().getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req, currentDiagram));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req, Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
			this.diagram = currentDiagram;
		}
	}

}
