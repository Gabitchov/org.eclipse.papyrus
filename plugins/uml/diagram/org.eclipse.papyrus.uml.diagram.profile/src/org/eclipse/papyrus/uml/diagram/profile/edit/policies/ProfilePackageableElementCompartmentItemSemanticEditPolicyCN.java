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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ClassCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.MetaclassCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ModelCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ProfileCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.StereotypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class ProfilePackageableElementCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ProfilePackageableElementCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Profile_1024);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if(UMLElementTypes.Stereotype_1023 == requestElementType) {
			return getGEFWrapper(new StereotypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Model_1027 == requestElementType) {
			return getGEFWrapper(new ModelCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Profile_1024 == requestElementType) {
			return getGEFWrapper(new ProfileCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Package_1012 == requestElementType) {
			return getGEFWrapper(new PackageCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Constraint_1028 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Enumeration_3025 == requestElementType) {
			return getGEFWrapper(new EnumerationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.PrimitiveType_3026 == requestElementType) {
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.DataType_3027 == requestElementType) {
			return getGEFWrapper(new DataTypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Comment_1007 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Class_3028 == requestElementType) {
			return getGEFWrapper(new MetaclassCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Class_3010 == requestElementType) {
			return getGEFWrapper(new ClassCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
