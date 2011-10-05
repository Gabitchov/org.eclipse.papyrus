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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.commands.DuplicateNamedElementCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.AssociationNodeCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.CommentEditPartCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.DataTypeCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.DependencyNodeCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.EnumerationCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.MetaclassCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.ModelCreateCommandTN;
import org.eclipse.papyrus.diagram.profile.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.ProfileCreateCommandTN;
import org.eclipse.papyrus.diagram.profile.edit.commands.ShortCutDiagramCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.commands.StereotypeCreateCommand;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class ProfileDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ProfileDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Profile_1000);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Dependency_2014 == req.getElementType()) {
			return getGEFWrapper(new DependencyNodeCreateCommand(req));
		}
		if(UMLElementTypes.Association_2015 == req.getElementType()) {
			return getGEFWrapper(new AssociationNodeCreateCommand(req));
		}
		if(UMLElementTypes.Stereotype_1026 == req.getElementType()) {
			return getGEFWrapper(new StereotypeCreateCommand(req));
		}
		if(UMLElementTypes.Class_1031 == req.getElementType()) {
			return getGEFWrapper(new MetaclassCreateCommand(req));
		}
		if(UMLElementTypes.Comment_1002 == req.getElementType()) {
			return getGEFWrapper(new CommentEditPartCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_1014 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if(UMLElementTypes.Model_2005 == req.getElementType()) {
			return getGEFWrapper(new ModelCreateCommandTN(req));
		}
		if(UMLElementTypes.Profile_1030 == req.getElementType()) {
			return getGEFWrapper(new ProfileCreateCommandTN(req));
		}
		if(UMLElementTypes.Package_2007 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if(UMLElementTypes.Enumeration_2006 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if(UMLElementTypes.PrimitiveType_2009 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req));
		}
		if(UMLElementTypes.DataType_2010 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommand(req));
		}
		if(UMLElementTypes.Diagram_2016 == req.getElementType()) {
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
	private static class DuplicateAnythingCommand extends DuplicateNamedElementCommand {

		/**
		 * @generated
		 */
		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req, Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap(), currentDiagram);
			this.diagram = currentDiagram;
		}
	}

}
