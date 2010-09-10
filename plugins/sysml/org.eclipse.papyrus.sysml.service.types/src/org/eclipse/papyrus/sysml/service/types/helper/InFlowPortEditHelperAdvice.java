/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;

/** SysML FlowPort#In edit helper advice */
public class InFlowPortEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public InFlowPortEditHelperAdvice() {
		requiredProfileIDs.add(SysmlResource.PORT_AND_FLOWS_ID);
	}

	/** Complete creation process by applying the expected stereotype */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
					throws ExecutionException {

				Port type = (Port) request.getElementToConfigure();
				if (type != null) {
					Stereotype partStereotype = type.getApplicableStereotype(SysmlResource.FLOW_PORT_ID);

					if (partStereotype != null) {
						FlowPort flowportApplication = (FlowPort) type.applyStereotype(partStereotype);
						flowportApplication.setDirection(FlowDirection.IN);
					}
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}

}
