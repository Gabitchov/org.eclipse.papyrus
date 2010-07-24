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
package org.eclipse.papyrus.sysml.service.creation.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.sysml.service.creation.Messages;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;

/**
 *this advice helper is used to add the stereotype FLOW PORT with the direction IN OUT 
 *
 */
public class InOutFlowPortAdviceBinding extends AbstractEditHelperAdvice {

	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				// get the new part
				Port type = (Port)request.getElementToConfigure();
				if(type != null) {
					if(type.getNearestPackage().getAppliedProfile(SysmlResource.PORT_AND_FLOWS_ID) == null || type.getOwner().getAppliedStereotype(SysmlResource.BLOCK_ID) == null) {
						org.eclipse.papyrus.sysml.service.creation.Activator.getDefault().log.info(Messages.ERROR_MESSAGE_PROFILE_BEGIN + SysmlResource.PORT_AND_FLOWS_ID + Messages.ERROR_MESSAGE_PROFILE_END);
					}
					Stereotype partStereotype = type.getApplicableStereotype(SysmlResource.FLOW_PORT_ID); // $NON-NSL-1$

					if(partStereotype != null) {
						// apply the part stereotype
						type.applyStereotype(partStereotype);
					}
				}


				return CommandResult.newOKCommandResult();
			}
		};
	}
}
