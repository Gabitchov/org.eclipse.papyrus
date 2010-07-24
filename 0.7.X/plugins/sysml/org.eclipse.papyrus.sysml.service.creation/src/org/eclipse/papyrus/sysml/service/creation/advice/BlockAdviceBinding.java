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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
/**
 * this is the adviceHelper to add the stereotype Block
 *
 */
public class BlockAdviceBinding extends AbstractEditHelperAdvice {

	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				// get the new part
				Element type = (Element)request.getElementToConfigure();

				if(type != null) {
					if(type.getNearestPackage().getAppliedProfile(SysmlResource.BLOCKS_ID) == null) {
						org.eclipse.papyrus.sysml.service.creation.Activator.getDefault().log.info(Messages.ERROR_MESSAGE_PROFILE_BEGIN + SysmlResource.BLOCKS_ID + Messages.ERROR_MESSAGE_PROFILE_END);
						return CommandResult.newCancelledCommandResult();
					}
					Stereotype partStereotype = type.getApplicableStereotype(SysmlResource.BLOCK_ID); // $NON-NSL-1$

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
