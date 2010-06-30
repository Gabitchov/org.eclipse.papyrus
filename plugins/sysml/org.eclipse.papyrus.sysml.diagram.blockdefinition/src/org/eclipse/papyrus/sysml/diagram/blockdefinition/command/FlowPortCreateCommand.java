/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;

public class FlowPortCreateCommand extends PortCreateCommand {

	public FlowPortCreateCommand(CreateElementRequest req) {
		super(req);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult result = super.doExecuteWithResult(monitor, info);
		Object returnValue = result.getReturnValue();

		if (returnValue instanceof Port) {
			Port createdPort = (Port)returnValue;

			// Set the element name
			String newElementName = NamedElementHelper.EINSTANCE.getNewUMLElementName(createdPort.getOwner(), PortandflowsPackage.eINSTANCE.getFlowPort());
			createdPort.setName(newElementName);

			// Apply stereotype
			// TODO if stereotype is not available warn the user
			Stereotype st = createdPort.getApplicableStereotype(SysmlResource.FLOW_PORT_ID);
			createdPort.applyStereotype(st);
		}
		return result;
	}
}
