/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AssociationClassCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AssociationNodeCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ClassCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ComponentCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DataTypeCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Dependency2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.EnumerationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.InstanceSpecificationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ModelCreateCommandTN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ShortCutDiagramCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.SignalCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ModelItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Dependency_2014 == req.getElementType()) {
			return getGEFWrapper(new Dependency2CreateCommand(req));
		}
		if (UMLElementTypes.AssociationClass_2013 == req.getElementType()) {
			return getGEFWrapper(new AssociationClassCreateCommand(req));
		}
		if (UMLElementTypes.Association_2015 == req.getElementType()) {
			return getGEFWrapper(new AssociationNodeCreateCommand(req));
		}
		if (UMLElementTypes.InstanceSpecification_2001 == req.getElementType()) {
			return getGEFWrapper(new InstanceSpecificationCreateCommand(req));
		}
		if (UMLElementTypes.Component_2002 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommand(req));
		}
		if (UMLElementTypes.Signal_2003 == req.getElementType()) {
			return getGEFWrapper(new SignalCreateCommand(req));
		}
		if (UMLElementTypes.Interface_2004 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (UMLElementTypes.Model_2005 == req.getElementType()) {
			return getGEFWrapper(new ModelCreateCommandTN(req));
		}
		if (UMLElementTypes.Enumeration_2006 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if (UMLElementTypes.Package_2007 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if (UMLElementTypes.Class_2008 == req.getElementType()) {
			return getGEFWrapper(new ClassCreateCommand(req));
		}
		if (UMLElementTypes.PrimitiveType_2009 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req));
		}
		if (UMLElementTypes.DataType_2010 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (UMLElementTypes.Comment_2012 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if (UMLElementTypes.Diagram_2016 == req.getElementType()) {
			return getGEFWrapper(new ShortCutDiagramCreateCommand(req));
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
