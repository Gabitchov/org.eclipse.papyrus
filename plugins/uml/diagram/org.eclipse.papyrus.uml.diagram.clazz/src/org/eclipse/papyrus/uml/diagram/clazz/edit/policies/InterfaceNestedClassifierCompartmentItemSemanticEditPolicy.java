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
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedClassForInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedDataTypeForInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedEnumerationForInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedInterfaceForInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedPrimitiveTypeForInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.NestedSignalForInterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class InterfaceNestedClassifierCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public InterfaceNestedClassifierCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Interface_2004);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Class_3008 == requestElementType) {
			return getGEFWrapper(new NestedClassForInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_3038 == requestElementType) {
			return getGEFWrapper(new NestedInterfaceForInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Enumeration_3054 == requestElementType) {
			return getGEFWrapper(new NestedEnumerationForInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.PrimitiveType_3048 == requestElementType) {
			return getGEFWrapper(new NestedPrimitiveTypeForInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DataType_3043 == requestElementType) {
			return getGEFWrapper(new NestedDataTypeForInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Signal_3049 == requestElementType) {
			return getGEFWrapper(new NestedSignalForInterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
