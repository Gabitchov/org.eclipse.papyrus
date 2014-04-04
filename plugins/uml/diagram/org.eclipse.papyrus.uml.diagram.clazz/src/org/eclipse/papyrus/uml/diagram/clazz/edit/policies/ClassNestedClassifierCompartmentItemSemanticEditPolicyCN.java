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
package org.eclipse.papyrus.uml.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedClassForClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedDataTypeForClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedEnumerationForClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedInterfaceForClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedPrimitiveTypeForClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedSignalForClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ClassNestedClassifierCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public ClassNestedClassifierCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Class_3010);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Class_3014 == requestElementType) {
			return getGEFWrapper(new NestedClassForClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_3036 == requestElementType) {
			return getGEFWrapper(new NestedInterfaceForClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Enumeration_3052 == requestElementType) {
			return getGEFWrapper(new NestedEnumerationForClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.PrimitiveType_3047 == requestElementType) {
			return getGEFWrapper(new NestedPrimitiveTypeForClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DataType_3044 == requestElementType) {
			return getGEFWrapper(new NestedDataTypeForClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Signal_3050 == requestElementType) {
			return getGEFWrapper(new NestedSignalForClassCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
