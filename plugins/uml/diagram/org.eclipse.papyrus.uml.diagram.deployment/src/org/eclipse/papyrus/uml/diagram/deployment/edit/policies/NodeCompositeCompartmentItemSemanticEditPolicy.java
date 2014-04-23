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
package org.eclipse.papyrus.uml.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.DeviceCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.NodeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class NodeCompositeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public NodeCompositeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Node_2008);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if(UMLElementTypes.Device_16 == requestElementType) {
			return getGEFWrapper(new DeviceCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.ExecutionEnvironment_21 == requestElementType) {
			return getGEFWrapper(new ExecutionEnvironmentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Artifact_25 == requestElementType) {
			return getGEFWrapper(new ArtifactCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Node_23 == requestElementType) {
			return getGEFWrapper(new NodeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
