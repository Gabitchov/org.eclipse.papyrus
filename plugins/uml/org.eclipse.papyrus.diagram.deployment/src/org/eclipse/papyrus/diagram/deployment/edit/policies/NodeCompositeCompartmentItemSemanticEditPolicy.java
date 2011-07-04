/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.edit.commands.DeviceCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.edit.commands.NodeCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.providers.UMLElementTypes;

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
		if(UMLElementTypes.Device_16 == req.getElementType()) {
			return getGEFWrapper(new DeviceCreateCommandCN(req));
		}
		if(UMLElementTypes.ExecutionEnvironment_21 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCreateCommandCN(req));
		}
		if(UMLElementTypes.Artifact_25 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommandCN(req));
		}
		if(UMLElementTypes.Node_23 == req.getElementType()) {
			return getGEFWrapper(new NodeCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
