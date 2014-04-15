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
import org.eclipse.papyrus.uml.diagram.component.edit.commands.CommentCreateCommandPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ComponentCreateCommandPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ConstraintCreateCommandPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.InterfaceCreateCommandPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.ModelCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.component.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackagePackageableElementCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public PackagePackageableElementCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_3200);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Interface_3078 == requestElementType) {
			return getGEFWrapper(new InterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_3074 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommandPCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_3075 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommandPCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Component_3071 == requestElementType) {
			return getGEFWrapper(new ComponentCreateCommandPCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Model_3077 == requestElementType) {
			return getGEFWrapper(new ModelCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Package_3076 == requestElementType) {
			return getGEFWrapper(new PackageCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_3072 == requestElementType) {
			return getGEFWrapper(new InterfaceCreateCommandPCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
