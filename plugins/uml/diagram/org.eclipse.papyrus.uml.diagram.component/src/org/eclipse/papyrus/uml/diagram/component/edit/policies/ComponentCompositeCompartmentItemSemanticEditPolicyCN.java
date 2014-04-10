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
package org.eclipse.papyrus.uml.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ComponentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.PropertyCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentCompositeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public ComponentCompositeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Component_3070);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Component_3070 == requestElementType) {
			return getGEFWrapper(new ComponentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Property_3079 == requestElementType) {
			return getGEFWrapper(new PropertyCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
