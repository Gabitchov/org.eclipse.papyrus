/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.component.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.DefaultNamedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.DependencyNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ModelCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.RectangleInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public ComponentDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Dependency_3203 == requestElementType) {
			return getGEFWrapper(new DependencyNodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Component_2002 == requestElementType) {
			return getGEFWrapper(new ComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Model_3202 == requestElementType) {
			return getGEFWrapper(new ModelCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Package_3200 == requestElementType) {
			return getGEFWrapper(new PackageCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_3205 == requestElementType) {
			return getGEFWrapper(new RectangleInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_3201 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_3199 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.NamedElement_3204 == requestElementType) {
			return getGEFWrapper(new DefaultNamedElementCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_2003 == requestElementType) {
			return getGEFWrapper(new InterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {
		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}
	}
}
