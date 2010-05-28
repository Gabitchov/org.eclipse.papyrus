/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Stereotype;


public class BlockHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Returns a command that initialize a Block.
	 * It complete the creation command provided by the specialized Metamodel
	 * element helper by applying the Block stereotype and initializing the
	 * new element name.
	 */
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				org.eclipse.uml2.uml.Class newClass = (org.eclipse.uml2.uml.Class)request.getElementToConfigure();

				// Set the element name
				String newElementName = NamedElementHelper.EINSTANCE.getNewUMLElementName(newClass.getOwner(), BlocksPackage.eINSTANCE.getBlock());
				newClass.setName(newElementName);

				// Apply stereotype
				Stereotype st = newClass.getApplicableStereotype(SysmlResource.BLOCK_ID);
				newClass.applyStereotype(st);

				return CommandResult.newOKCommandResult();
			}
		};
	}

}
