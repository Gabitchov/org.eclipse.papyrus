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
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedClassForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedDataTypeForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedEnumerationForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedInterfaceForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedPrimitiveTypeForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedSignalForComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentNestedClassifierCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentNestedClassifierCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_2002);
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

		if (UMLElementTypes.Class_3004 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new NestedClassForComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Interface_3037 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new NestedInterfaceForComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Enumeration_3053 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new NestedEnumerationForComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.PrimitiveType_3046 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new NestedPrimitiveTypeForComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.DataType_3045 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new NestedDataTypeForComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.Signal_3051 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new NestedSignalForComponentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		return super.getCreateCommand(req);
	}

}
