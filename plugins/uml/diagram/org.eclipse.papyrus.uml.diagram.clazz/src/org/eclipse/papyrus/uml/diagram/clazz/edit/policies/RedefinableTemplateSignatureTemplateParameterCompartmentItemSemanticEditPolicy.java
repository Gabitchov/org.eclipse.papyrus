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
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ClassifierTemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ConnectableElementTemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.OperationTemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.TemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class RedefinableTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RedefinableTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.RedefinableTemplateSignature_3015);
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

		if (UMLElementTypes.ClassifierTemplateParameter_3031 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ClassifierTemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.ConnectableElementTemplateParameter_3034 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new ConnectableElementTemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.OperationTemplateParameter_3035 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new OperationTemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		if (UMLElementTypes.TemplateParameter_3016 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new TemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));

		}
		return super.getCreateCommand(req);
	}

}
