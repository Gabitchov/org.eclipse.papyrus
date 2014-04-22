/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.diagram.profile.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.AssociationNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.CommentEditPartCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.DataTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.DependencyNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.EnumerationCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.MetaclassCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ModelCreateCommandTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ProfileCreateCommandTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ShortCutDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.StereotypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

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
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if(UMLElementTypes.Dependency_2014 == requestElementType) {
			return getGEFWrapper(new DependencyNodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Association_2015 == requestElementType) {
			return getGEFWrapper(new AssociationNodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Stereotype_1026 == requestElementType) {
			return getGEFWrapper(new StereotypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Class_2008 == requestElementType) {
			return getGEFWrapper(new ClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Class_1031 == requestElementType) {
			return getGEFWrapper(new MetaclassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Comment_1002 == requestElementType) {
			return getGEFWrapper(new CommentEditPartCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Constraint_1014 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Model_2005 == requestElementType) {
			return getGEFWrapper(new ModelCreateCommandTN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Profile_1030 == requestElementType) {
			return getGEFWrapper(new ProfileCreateCommandTN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Package_2007 == requestElementType) {
			return getGEFWrapper(new PackageCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Enumeration_2006 == requestElementType) {
			return getGEFWrapper(new EnumerationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.PrimitiveType_2009 == requestElementType) {
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.DataType_2010 == requestElementType) {
			return getGEFWrapper(new DataTypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Diagram_2016 == requestElementType) {
			return getGEFWrapper(new ShortCutDiagramCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
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
