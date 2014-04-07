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
package org.eclipse.papyrus.uml.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.OperationCreateCommandCLN;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class DataTypeOperationCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public DataTypeOperationCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.DataType_3080);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Operation_3102 == requestElementType) {
			return getGEFWrapper(new OperationCreateCommandCLN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
