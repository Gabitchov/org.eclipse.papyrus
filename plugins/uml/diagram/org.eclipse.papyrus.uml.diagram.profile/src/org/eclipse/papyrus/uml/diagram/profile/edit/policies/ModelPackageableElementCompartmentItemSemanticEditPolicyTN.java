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
package org.eclipse.papyrus.uml.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ModelCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ProfileCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class ModelPackageableElementCompartmentItemSemanticEditPolicyTN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelPackageableElementCompartmentItemSemanticEditPolicyTN() {
		super(UMLElementTypes.Model_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.Comment_1007 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if(UMLElementTypes.Model_1027 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ModelCreateCommandCN(req));
		}
		if(UMLElementTypes.Profile_1024 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ProfileCreateCommandCN(req));
		}
		if(UMLElementTypes.Package_1012 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PackageCreateCommandCN(req));
		}
		if(UMLElementTypes.Constraint_1028 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.Enumeration_3025 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new EnumerationCreateCommandCN(req));
		}
		if(UMLElementTypes.PrimitiveType_3026 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req));
		}
		if(UMLElementTypes.DataType_3027 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DataTypeCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}
}
