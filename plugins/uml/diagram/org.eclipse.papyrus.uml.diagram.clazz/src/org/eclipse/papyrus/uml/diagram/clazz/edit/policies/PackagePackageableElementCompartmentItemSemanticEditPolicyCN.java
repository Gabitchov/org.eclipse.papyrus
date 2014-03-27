/*
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
package org.eclipse.papyrus.uml.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ClassCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ComponentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InformationItemCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InstanceSpecificationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.InterfaceCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ModelCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.SignalCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackagePackageableElementCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackagePackageableElementCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Package_3009);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if (requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if (baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType) requestElementType);
				isExtendedType = true;
			}
		}

		if (UMLElementTypes.InstanceSpecification_3020 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InstanceSpecificationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Component_3021 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ComponentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Signal_3022 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new SignalCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Interface_3023 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InterfaceCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Model_3024 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ModelCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Enumeration_3025 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new EnumerationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Package_3009 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new PackageCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Class_3010 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ClassCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.PrimitiveType_3026 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.DataType_3027 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DataTypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Comment_3028 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Constraint_3029 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.InformationItem_3040 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new InformationItemCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		return super.getCreateCommand(req);
	}

}
