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
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/** SysML Block edit helper advice */
public class BlockEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public BlockEditHelperAdvice() {
		requiredProfileIDs.add(SysmlResource.BLOCKS_ID);
	}

	/** Complete creation process by applying the expected stereotype */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
					throws ExecutionException {
				Element type = (Element) request.getElementToConfigure();
				if (type != null) {
					Stereotype blockSt = type.getApplicableStereotype(SysmlResource.BLOCK_ID);
					if (blockSt != null) {
						type.applyStereotype(blockSt);
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
